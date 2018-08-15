package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeInvoiceUpdateRule implements IRule<InvoiceHVO, InvoiceBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public void process(InvoiceHVO hvo, InvoiceBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			BigDecimal sumNmny = BigDecimal.ZERO;
			BigDecimal sumNum = BigDecimal.ZERO;
			for (InvoiceBVO bvo : bvos) {
				sumNmny = MMNumberUtil.add(sumNmny, bvo.getNmny());
				if (bvo.getServices() == 0L) {
					sumNum = MMNumberUtil.add(sumNum, bvo.getNastnum());
				}
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
		}
	}

}
