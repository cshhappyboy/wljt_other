package com.fgc.service.finprodin.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 产成品入库单业务保存前规则类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月1日
 *
 *     未来离线需求
 */
@Component
public class BeforeFinprodinSaveRule implements IRule<FinprodinHVO, FinprodinBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Override
	public void process(FinprodinHVO hvo, FinprodinBVO[] bvos) {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(hvo, bvos);
			this.setDefaultData(hvo);
			// 表体数据合计到表头
			BigDecimal sumNum = BigDecimal.ZERO;
			String cwarehouseid = hvo.getCwarehouseid();
			for (FinprodinBVO bvo : bvos) {
				BigDecimal ninassistnum = bvo.getNinassistnum();
				sumNum = MMNumberUtil.add(sumNum, ninassistnum);
				bvo.setVbdef3(cwarehouseid);
				
				String dbizindate = bvo.getDbizindate();
				if(MMStringUtil.isEmpty(dbizindate)){
					bvo.setDbizindate(MMNCUtils.getNowDate());
				}
			}
			hvo.setNtotalnum(sumNum);
		}

	}

	/**
	 * @param hvo
	 */
	private void setDefaultData(FinprodinHVO hvo) {
		String cbilltype = hvo.getCbilltype();
		if (MMStringUtil.isNotEmpty(cbilltype)) {
			BilltypeVO billtypeVO = billtypeVOMapper.selectByPrimaryKey(cbilltype);
			hvo.setVbilltype(billtypeVO.getPkbilltypecode());
		}
	}

	/**
	 * @param hvo
	 * @param bvos
	 */
	private void setDefaultInfo(FinprodinHVO hvo, FinprodinBVO[] bvos) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		hvo.setPkGroup(pk_group);
		hvo.setPkOrg(pk_org);
		for (FinprodinBVO bvo : bvos) {
			bvo.setPkGroup(pk_group);
			bvo.setPkOrg(pk_org);
		}
	}
}
