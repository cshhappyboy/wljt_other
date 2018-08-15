package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.HandNumVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.pojo.HandNumVO;
import com.fgc.pojo.HandNumVOExample;
import com.fgc.pojo.HandNumVOExample.Criteria;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.StordocVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.AggVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 发票审批推销售出库之前校验现存量足不足<br>
 * 
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月2日
 *
 *     未来离线需求
 */
@Component
public class BeforeInvoicePushSaleOutCheckOnhandRule {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private HandNumVOMapper handNumVOMapper;

	@Autowired
	private StordocVOMapper stordocVOMapper;

	public void process(List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs) throws Exception {
		if (MMCollectionUtil.isNotEmpty(aggVOs)) {
			List<String> listMsg = new ArrayList<>();
			for (AggVO<InvoiceHVO, InvoiceBVO> aggVO : aggVOs) {
				InvoiceHVO headVO = aggVO.getHeadVO();
				// 零售类发票需要校验库存
				String vsrcbilltype = headVO.getVsrcbilltype();
				if (!MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"), vsrcbilltype)) {
					return;
				}

				Map<String, BigDecimal> mapCmaterialData = new HashMap<>();

				InvoiceBVO[] bodyVOs = aggVO.getBodyVOs();
				String vbillcode = headVO.getVbillcode();
				for (InvoiceBVO bodyVO : bodyVOs) {
					String cmaterial = bodyVO.getCmaterial();
					String delwarehouse = bodyVO.getDelwarehouse();
					String sizecode = bodyVO.getSizecode() == null ? "aaaaa" : bodyVO.getSizecode();
					BigDecimal nnum = bodyVO.getNnum();
					String materialcode = bodyVO.getMaterialcode();
					Long services = bodyVO.getServices();

					String key = cmaterial + "&" + delwarehouse + "&" + sizecode + "&" + materialcode + "&" + services;

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
					String delwarehouse = split[1];
					String sizecode = split[2];
					String materialcode = split[3];
					String services = split[4];

					if (MMStringUtil.isNotEmpty(cmaterial) && MMStringUtil.isNotEmpty(delwarehouse)
							&& MMNumberUtil.isGtZero(numData) && MMStringUtil.isEqual("0", services)) {
						HandNumVOExample example = new HandNumVOExample();
						Criteria criteria = example.createCriteria();
						criteria.andCmaterialEqualTo(cmaterial);
						criteria.andCwarehouseidEqualTo(delwarehouse);
						criteria.andVbatchcodeEqualTo(sizecode);
						List<HandNumVO> listHandNumVOs = handNumVOMapper.selectByExample(example);
						if (MMCollectionUtil.isNotEmpty(listHandNumVOs)) {
							HandNumVO handNumVO = listHandNumVOs.get(0);
							if (MMNumberUtil.isLs(handNumVO.getNastnum(), numData)) {
								this.contractMsg(listMsg, vbillcode, materialcode, delwarehouse,
										MMNumberUtil.subtract(numData, handNumVO.getNastnum()));
							}
						} else {
							this.contractMsg(listMsg, vbillcode, materialcode, delwarehouse, numData);
						}

					}
				}

			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}

	/**
	 * @param listMsg
	 * @param vbillcode
	 * @param cmaterial
	 * @param delwarehouse
	 */
	private void contractMsg(List<String> listMsg, String vbillcode, String cmaterialcode, String delwarehouse,
			BigDecimal quekouNum) {
		StordocVO stordocVO = stordocVOMapper.selectByPrimaryKey(delwarehouse);
		StringBuilder sBuilder = new StringBuilder();
		if(MMValueUtils.isEmpty(stordocVO)){
			sBuilder.append("发票号为:【" + vbillcode + "】没有找到对应的仓库，请检查数据！");
		}else{
			sBuilder.append("发票号为:【" + vbillcode + "】现存量不足,");
			sBuilder.append("物料编码为:【" + cmaterialcode + "】,");
			sBuilder.append("仓库为:" + stordocVO.getName() + ",");
			sBuilder.append("现存量缺口:" + quekouNum + "。");
		}
		listMsg.add(sBuilder.toString());
	}

}
