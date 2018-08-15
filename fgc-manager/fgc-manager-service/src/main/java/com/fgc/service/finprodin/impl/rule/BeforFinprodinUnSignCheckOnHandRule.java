package com.fgc.service.finprodin.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.FinprodinBVOMapper;
import com.fgc.mapper.FinprodinHVOMapper;
import com.fgc.mapper.HandNumVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinBVOExample;
import com.fgc.pojo.FinprodinBVOExample.Criteria;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.HandNumVO;
import com.fgc.pojo.HandNumVOExample;
import com.fgc.pojo.StordocVO;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月11日
 *
 *     未来离线需求
 */
@Component
public class BeforFinprodinUnSignCheckOnHandRule {

	@Autowired
	private StordocVOMapper stordocVOMapper;

	@Autowired
	private FinprodinHVOMapper finprodinHVOMapper;

	@Autowired
	private FinprodinBVOMapper finprodinBVOMapper;

	@Autowired
	private HandNumVOMapper handNumVOMapper;

	public void process(List<String> ids) throws Exception {
		if (MMCollectionUtil.isNotEmpty(ids)) {
			List<String> listMsg = new ArrayList<>();
			for (String id : ids) {
				FinprodinHVO finprodinHVO = finprodinHVOMapper.selectByPrimaryKey(id);
				FinprodinBVOExample example = new FinprodinBVOExample();
				Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(id);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<FinprodinBVO> listBVOs = finprodinBVOMapper.selectByExample(example);

				String vbillcode = finprodinHVO.getVbillcode();
				String cwarehouseid = finprodinHVO.getCwarehouseid();
				for (FinprodinBVO bvo : listBVOs) {
					BigDecimal ninnum = bvo.getNinnum();
					String cmaterial = bvo.getCmaterial();
					String vbatchcode = bvo.getVbatchcode();
					HandNumVOExample handNumVOExample = new HandNumVOExample();
					com.fgc.pojo.HandNumVOExample.Criteria createCriteria = handNumVOExample.createCriteria();
					createCriteria.andCmaterialEqualTo(cmaterial);
					if (MMStringUtil.isNotEmpty(cwarehouseid)) {
						createCriteria.andCwarehouseidEqualTo(cwarehouseid);
					}
					if (MMStringUtil.isNotEmpty(vbatchcode)) {
						createCriteria.andVbatchcodeEqualTo(vbatchcode);
					} else {
						createCriteria.andVbatchcodeEqualTo("aaaaa");
					}
					List<HandNumVO> listHandNumVOs = handNumVOMapper.selectByExample(handNumVOExample);
					if (MMCollectionUtil.isNotEmpty(listHandNumVOs)) {
						HandNumVO handNumVO = listHandNumVOs.get(0);
						if (MMNumberUtil.isLs(handNumVO.getNastnum(), ninnum)) {
							this.contractMsg(listMsg, vbillcode, bvo.getMaterialcode(), cwarehouseid,
									MMNumberUtil.subtract(ninnum, handNumVO.getNastnum()));
						}
					} else if (MMNumberUtil.isGtZero(ninnum)) {
						this.contractMsg(listMsg, vbillcode, bvo.getMaterialcode(), cwarehouseid, ninnum);
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
	 * @param bodyVO
	 * @param cmaterial
	 * @param delwarehouse
	 */
	private void contractMsg(List<String> listMsg, String vbillcode, String cmaterialcode, String delwarehouse,
			BigDecimal quekouNum) {
		StordocVO stordocVO = stordocVOMapper.selectByPrimaryKey(delwarehouse);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("单据号为:【" + vbillcode + "】现存量不足,");
		sBuilder.append("物料编码为:【" + cmaterialcode + "】,");
		sBuilder.append("仓库为:" + stordocVO.getName() + ",");
		sBuilder.append("现存量缺口:" + quekouNum + "。");
		listMsg.add(sBuilder.toString());
	}

	/**
	 * @param newJsonBill
	 * @param oldJsonBill
	 */
	public void processUpdate(JsonBill newJsonBill, JsonBill oldJsonBill) {
		if (MMValueUtils.isNotEmpty(newJsonBill) && MMValueUtils.isNotEmpty(oldJsonBill)) {
			String head = newJsonBill.getHead();

			FinprodinHVO headVO = JsonUtils.jsonToPojo(head, FinprodinHVO.class);
			String cwarehouseid = headVO.getCwarehouseid();

			String vbillcode = headVO.getVbillcode();
			// 表头数量回写
			// 回写发票
			// 2、表体数量回写
			String updateBodys = newJsonBill.getUpdateBodys();
			String oldBodys = oldJsonBill.getRealyBodys();
			List<FinprodinBVO> updateBVOs = JsonUtils.jsonToList(updateBodys, FinprodinBVO.class);
			List<FinprodinBVO> oldBVOs = JsonUtils.jsonToList(oldBodys, FinprodinBVO.class);
			if (MMCollectionUtil.isNotEmpty(updateBVOs)) {
				List<String> listMsg = new ArrayList<>();
				for (FinprodinBVO bvo : updateBVOs) {
					String id = bvo.getId();
					for (FinprodinBVO oldBVO : oldBVOs) {
						String oldID = oldBVO.getId();
						if (MMStringUtil.isEqual(id, oldID)) {
							BigDecimal changeNum = MMNumberUtil.subtract(bvo.getNinnum(), oldBVO.getNinnum());
							if (MMNumberUtil.isLsEqualZero(changeNum)) {
								continue;
							} else {
								String cmaterial = bvo.getCmaterial();
								String vbatchcode = bvo.getVbatchcode();
								if (MMStringUtil.isNotEmpty(cmaterial) && MMStringUtil.isNotEmpty(cwarehouseid)) {
									HandNumVOExample example = new HandNumVOExample();
									com.fgc.pojo.HandNumVOExample.Criteria criteria = example.createCriteria();
									criteria.andCmaterialEqualTo(cmaterial);
									criteria.andCwarehouseidEqualTo(cwarehouseid);
									if (MMStringUtil.isNotEmpty(vbatchcode)) {
										criteria.andVbatchcodeEqualTo(vbatchcode);
									} else {
										criteria.andVbatchcodeEqualTo("aaaaa");
									}
									List<HandNumVO> listHandNumVOs = handNumVOMapper.selectByExample(example);
									if (MMCollectionUtil.isNotEmpty(listHandNumVOs)) {
										HandNumVO handNumVO = listHandNumVOs.get(0);
										if (MMNumberUtil.isLs(handNumVO.getNastnum(), changeNum)) {
											this.contractMsg(listMsg, vbillcode, bvo.getMaterialcode(), cwarehouseid,
													MMNumberUtil.subtract(changeNum, handNumVO.getNastnum()));
										}
									} else {
										this.contractMsg(listMsg, vbillcode, bvo.getMaterialcode(), cwarehouseid,
												changeNum);
									}
								}
							}
						}
					}
				}
				if (MMCollectionUtil.isNotEmpty(listMsg)) {
					throw new RuntimeException(listMsg.toString());
				}
			}
		}
	}
}
