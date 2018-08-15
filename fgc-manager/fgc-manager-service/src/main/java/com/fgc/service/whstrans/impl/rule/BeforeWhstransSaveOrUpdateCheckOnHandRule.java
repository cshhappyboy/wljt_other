package com.fgc.service.whstrans.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.HandNumVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.pojo.HandNumVO;
import com.fgc.pojo.HandNumVOExample;
import com.fgc.pojo.HandNumVOExample.Criteria;
import com.fgc.pojo.StordocVO;
import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月3日
 *
 *     未来离线需求
 */
@Component
public class BeforeWhstransSaveOrUpdateCheckOnHandRule implements IRule<WhstransHVO, WhstransBVO> {

	@Autowired
	private HandNumVOMapper handNumVOMapper;

	@Autowired
	private StordocVOMapper stordocVOMapper;

	@Override
	public void process(WhstransHVO hvo, WhstransBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMArrayUtil.isNotEmpty(bvos)) {
			String coutwarehouseid = hvo.getCoutwarehouseid();
			List<String> listMsg = new ArrayList<>();
			for (WhstransBVO bvo : bvos) {
				String cmaterial = bvo.getCmaterial();
				BigDecimal ntrsnnum = bvo.getNtrsnnum();
				String vbatchcode = bvo.getVbatchcode();
				if (MMStringUtil.isNotEmpty(coutwarehouseid) && MMStringUtil.isNotEmpty(cmaterial)
						&& MMNumberUtil.isGtZero(ntrsnnum)) {
					HandNumVOExample example = new HandNumVOExample();
					Criteria criteria = example.createCriteria();
					criteria.andCmaterialEqualTo(cmaterial);
					criteria.andCwarehouseidEqualTo(coutwarehouseid);
					if(MMStringUtil.isNotEmpty(vbatchcode)){
						criteria.andVbatchcodeEqualTo(vbatchcode);
					}else{
						criteria.andVbatchcodeEqualTo("aaaaa");
					}
					List<HandNumVO> listHandNumVOs = handNumVOMapper.selectByExample(example);
					if (MMCollectionUtil.isNotEmpty(listHandNumVOs)) {
						HandNumVO handNumVO = listHandNumVOs.get(0);
						if (MMNumberUtil.isLs(handNumVO.getNastnum(), ntrsnnum)) {
							this.contractMsg(listMsg, bvo.getMaterialcode(), coutwarehouseid,
									MMNumberUtil.subtract(ntrsnnum, handNumVO.getNastnum()));
						}
					} else {
						this.contractMsg(listMsg, bvo.getMaterialcode(), coutwarehouseid, ntrsnnum);
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
	private void contractMsg(List<String> listMsg, String cmaterialcode, String delwarehouse, BigDecimal quekouNum) {
		StordocVO stordocVO = stordocVOMapper.selectByPrimaryKey(delwarehouse);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("物料编码为:【" + cmaterialcode + "】,");
		sBuilder.append("仓库为:" + stordocVO.getName() + ",");
		sBuilder.append("现存量缺口:" + quekouNum + "。");
		listMsg.add(sBuilder.toString());
	}
}
