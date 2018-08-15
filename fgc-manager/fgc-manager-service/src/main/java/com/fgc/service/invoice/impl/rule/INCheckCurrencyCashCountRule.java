package com.fgc.service.invoice.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.CashAccountVOMapper;
import com.fgc.pojo.CashAccountVO;
import com.fgc.pojo.InvoiceHVO;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 校验币种和现金账户是否保持一致
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月3日
 *
 *     未来离线需求
 */
@Component
public class INCheckCurrencyCashCountRule {

	@Autowired
	private CashAccountVOMapper cashAccountVOMapper;

	public void process(InvoiceHVO hvo) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo)) {
			String currency = hvo.getCurrency();
			String cashaccount = hvo.getCashaccount();
			if (MMStringUtil.isNotEmpty(cashaccount)) {
				CashAccountVO cashAccountVO = cashAccountVOMapper.selectByPrimaryKey(cashaccount);
				String pkmoneytype = cashAccountVO.getPkmoneytype();
				if (!MMStringUtil.isEqual(currency, pkmoneytype)) {
					throw new RuntimeException("现金账户与币种不匹配,请检查！");
				}
			}
		}
	}
}
