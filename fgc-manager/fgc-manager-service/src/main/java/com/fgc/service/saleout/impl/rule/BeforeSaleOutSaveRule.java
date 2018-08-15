package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 销售订单保存前业务规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月31日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutSaveRule implements IRule<SaleOutHVO, SaleOutBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Override
	public void process(SaleOutHVO hvo, SaleOutBVO[] bvos) {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(hvo, bvos);
			this.setDefaultData(hvo);
			
			String cwarehouseid = hvo.getCwarehouseid();
			BigDecimal sumNum = BigDecimal.ZERO;
			for (SaleOutBVO bvo : bvos) {
				bvo.setVbdef1(cwarehouseid);
				BigDecimal nassistnum = bvo.getNassistnum();
				sumNum = MMNumberUtil.add(sumNum, nassistnum);
			}
			hvo.setNtotalnum(sumNum);
		}

	}

	/**
	 * @param hvo
	 */
	private void setDefaultData(SaleOutHVO hvo) {
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
	private void setDefaultInfo(SaleOutHVO hvo, SaleOutBVO[] bvos) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		hvo.setPkGroup(pk_group);
		hvo.setPkOrg(pk_org);
		for (SaleOutBVO bvo : bvos) {
			bvo.setPkGroup(pk_group);
			bvo.setPkOrg(pk_org);
		}
	}
}
