package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 发票保存前规则类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月30日
 *
 *     未来离线需求
 */
@Component
public class BeforeInvoiceSaveRule implements IRule<InvoiceHVO, InvoiceBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Override
	public void process(InvoiceHVO hvo, InvoiceBVO[] bvos) {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(hvo, bvos);
			String salesman = hvo.getSalesman();
			String cdept = hvo.getCdept();
			BigDecimal sumNmny = BigDecimal.ZERO;
			BigDecimal sumNum = BigDecimal.ZERO;
			for (InvoiceBVO bvo : bvos) {
				bvo.setVbdef1(salesman);
				bvo.setVbdef2(cdept);
				if (bvo.getServices() == 0L) {
					sumNum = MMNumberUtil.add(sumNum, bvo.getNastnum());
				}
				sumNmny = MMNumberUtil.add(sumNmny, bvo.getNmny());
			}
			hvo.setNorigtaxmny(sumNmny);
			hvo.setNtotalmny(sumNmny);
			// 发票数量
			hvo.setNtotalnum(sumNum);
			BigDecimal ntotaloutnum = hvo.getNtotaloutnum();
			if (MMValueUtils.isEmpty(ntotaloutnum)) {
				hvo.setNtotaloutnum(BigDecimal.ZERO);
			}
			// 尾款=累积开票金额+价税合计-累积收款金额，当计算结果小于0时，显示为0，字段不允许修改；
			BigDecimal ntotalinvoicemny = hvo.getNtotalinvoicemny();// 已开票金额
			BigDecimal norigtaxmny = hvo.getNorigtaxmny();// 价税合计
			BigDecimal ntotalrecemny = hvo.getNtotalrecemny();// 累积收款金额
			BigDecimal retainage = MMNumberUtil.subtract(MMNumberUtil.add(ntotalinvoicemny, norigtaxmny),
					ntotalrecemny);// 计算尾款
			if (MMNumberUtil.isLsEqualZero(retainage) && !MMStringUtil.isEqual(hvo.getVsrcbilltype(),
					pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"))) {
				hvo.setRetainage(BigDecimal.ZERO);
			} else {
				hvo.setRetainage(retainage);
			}
			hvo.setVdef10(hvo.getRetainage().toString());

			// 补充数据
			this.setDataValue(hvo, bvos);
		}
	}

	/**
	 * @param hvo
	 * @param bvos
	 */
	private void setDataValue(InvoiceHVO hvo, InvoiceBVO[] bvos) {
		Long isdebt = hvo.getIsdebt();
		if (MMValueUtils.isEmpty(isdebt)) {
			hvo.setIsdebt(0L);
		}
		// 设置单据类型编码
		String cbilltype = hvo.getCbilltype();
		if (MMStringUtil.isNotEmpty(cbilltype)) {
			BilltypeVO billtypeVO = billtypeVOMapper.selectByPrimaryKey(cbilltype);
			hvo.setVbilltype(billtypeVO.getPkbilltypecode());
		}

		for (InvoiceBVO bvo : bvos) {
			Long gift = bvo.getGift();
			if (MMValueUtils.isEmpty(gift)) {
				bvo.setGift(0L);
			}
			BigDecimal noutnum = bvo.getNoutnum();
			if (MMValueUtils.isEmpty(noutnum)) {
				bvo.setNoutnum(BigDecimal.ZERO);
			}
			bvo.setCashaccount(hvo.getCashaccount());
			bvo.setCbankid(hvo.getCbankid());
			bvo.setNorigmny(bvo.getNmny());
		}
	}

	/**
	 * @param hvo
	 * @param bvos
	 */
	private void setDefaultInfo(InvoiceHVO hvo, InvoiceBVO[] bvos) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		hvo.setPkGroup(pk_group);
		hvo.setPkOrg(pk_org);
		for (InvoiceBVO bvo : bvos) {
			bvo.setPkGroup(pk_group);
			bvo.setPkOrg(pk_org);
		}
	}
}
