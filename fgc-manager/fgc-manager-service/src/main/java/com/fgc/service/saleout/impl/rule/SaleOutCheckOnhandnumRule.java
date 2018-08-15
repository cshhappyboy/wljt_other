package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.HandNumVOMapper;
import com.fgc.mapper.SaleOutHVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.pojo.HandNumVO;
import com.fgc.pojo.HandNumVOExample;
import com.fgc.pojo.HandNumVOExample.Criteria;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.fgc.pojo.StordocVO;
import com.pub.model.SessionInfo;
import com.pub.utils.AggVO;
import com.pub.utils.IUParamVO;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;

/**
 * 发票审批推销售出库修改保存时校验现存量（物料+仓库）
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月2日
 *
 *     未来离线需求
 */
@Component
public class SaleOutCheckOnhandnumRule {

	@Autowired
	private HandNumVOMapper handNumVOMapper;

	@Autowired
	private StordocVOMapper stordocVOMapper;

	@Autowired
	private SaleOutHVOMapper outHVOMapper;

	/**
	 * @param aggVOs
	 * @param sessionInfo
	 */
	public void process(List<AggVO<SaleOutHVO, SaleOutBVO>> aggVOs, SessionInfo sessionInfo) {
		if (MMCollectionUtil.isNotEmpty(aggVOs)) {
			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			paramVO.setYeDate(sessionInfo.getNowDate());
			List<String> listMsg = new ArrayList<>();
			for (AggVO<SaleOutHVO, SaleOutBVO> aggVO : aggVOs) {
				SaleOutHVO hvo = aggVO.getHeadVO();
				SaleOutBVO[] bvos = aggVO.getBodyVOs();
				if (MMValueUtils.isNotEmpty(hvo) && MMArrayUtil.isNotEmpty(bvos)) {
					String inVbillcode = hvo.getVsrccode();
					String savVbillcode = hvo.getVbillcode();

					Map<String, BigDecimal> mapCmaterialData = new HashMap<>();

					for (SaleOutBVO bvo : bvos) {
						String cmaterial = bvo.getCmaterial();
						String vbdef1 = bvo.getVbdef1();
						String vbatchcode = bvo.getVbatchcode() == null ? "aaaaa" : bvo.getVbatchcode();
						String materialcode = bvo.getMaterialcode();
						BigDecimal nnum = bvo.getNnum();

						String key = cmaterial + "&" + vbdef1 + "&" + vbatchcode + "&" + materialcode;

						BigDecimal numData = mapCmaterialData.get(key);
						if (MMNumberUtil.isNullOrZero(numData)) {
							mapCmaterialData.put(key, nnum);
						} else {
							mapCmaterialData.put(key, MMNumberUtil.add(numData, nnum));
						}

					}

					Set<String> keySet = mapCmaterialData.keySet();
					for (String key : keySet) {
						BigDecimal numData = mapCmaterialData.get(key);
						String[] split = key.split("&");
						String cmaterial = split[0];
						String vbdef1 = split[1];
						String vbatchcode = split[2];
						String materialcode = split[3];

						if (MMStringUtil.isNotEmpty(cmaterial) && MMStringUtil.isNotEmpty(vbdef1)
								&& MMNumberUtil.isGtZero(numData)) {
							HandNumVOExample example = new HandNumVOExample();
							Criteria criteria = example.createCriteria();
							criteria.andCmaterialEqualTo(cmaterial);
							criteria.andCwarehouseidEqualTo(vbdef1);
							criteria.andVbatchcodeEqualTo(vbatchcode);
							List<HandNumVO> listHandNumVOs = handNumVOMapper.selectByExample(example);
							if (MMCollectionUtil.isNotEmpty(listHandNumVOs)) {
								HandNumVO handNumVO = listHandNumVOs.get(0);
								if (MMNumberUtil.isLs(handNumVO.getNastnum(), numData)) {
									this.contractMsg(listMsg, inVbillcode, savVbillcode, materialcode, vbdef1,
											MMNumberUtil.subtract(numData, handNumVO.getNastnum()));
								} 
							} else {
								this.contractMsg(listMsg, inVbillcode, savVbillcode, materialcode, vbdef1, numData);
							}
						}
					}
				}
				if (new DateTime(sessionInfo.getNowDate()).isBefore(new DateTime(hvo.getDbilldate()))) {
					throw new RuntimeException("签字时间不能早于单据时间！");
				}
				PojoTools.beforeSign(SaleOutHVO.class, hvo, paramVO);
				outHVOMapper.updateByPrimaryKey(hvo);
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}

	/**
	 * @param listMsg
	 * @param vbillcode
	 * @param bodyVO
	 * @param cmaterial
	 * @param delwarehouse
	 */
	private void contractMsg(List<String> listMsg, String inVbillcode, String saVbillcode, String cmaterialcode,
			String delwarehouse, BigDecimal quekouNum) {
		StordocVO stordocVO = stordocVOMapper.selectByPrimaryKey(delwarehouse);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("发票号为:【" + inVbillcode + "】现存量不足,");
		sBuilder.append("销售出库单号为:【" + saVbillcode + "】现存量不足,");
		sBuilder.append("物料编码为:【" + cmaterialcode + "】,");
		sBuilder.append("仓库为:" + stordocVO.getName() + ",");
		sBuilder.append("现存量缺口:" + quekouNum + "。");
		listMsg.add(sBuilder.toString());
	}

}
