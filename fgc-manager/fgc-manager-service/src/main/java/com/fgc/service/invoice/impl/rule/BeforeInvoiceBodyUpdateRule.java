package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.service.order.impl.util.ZhekouRule;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月31日
 *
 *     未来离线需求
 */
@Component
public class BeforeInvoiceBodyUpdateRule implements IRule<InvoiceHVO, InvoiceBVO> {

	@Autowired
	private ZhekouRule zhekouRule;
	
	@Override
	public void process(InvoiceHVO hvo, InvoiceBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			String salesman = hvo.getSalesman();
			String cdept = hvo.getCdept();
			for (InvoiceBVO bvo : bvos) {
				if(zhekouRule.isZheKou(bvo.getCmaterial())){
					BigDecimal nastnum = bvo.getNastnum();
					if(MMNumberUtil.isGtZero(nastnum)){
						throw new RuntimeException("折扣类物料销售数量不能大于0！");
					}
				}
				bvo.setVbdef1(salesman);
				bvo.setVbdef2(cdept);
			}
		}
	}

}
