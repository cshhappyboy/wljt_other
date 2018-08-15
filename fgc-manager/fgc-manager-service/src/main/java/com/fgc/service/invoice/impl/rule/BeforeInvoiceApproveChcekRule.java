package com.fgc.service.invoice.impl.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fgc.pojo.InvoiceHVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 发票审批前校验必填字段是否有值
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月3日
 *
 *     未来离线需求
 */
@Component
public class BeforeInvoiceApproveChcekRule {
	/**
	 * 现金
	 */
	private final static String XIAN_JIN = "0001Z0100000000000XZ";
	/**
	 * 银行转账
	 */
	private final static String ZHUAN_ZHANG = "1001A11000000000JY5Z";

	public void process(List<InvoiceHVO> listHVOs) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			List<String> listMsg = new ArrayList<>();
			for (InvoiceHVO invoiceHVO : listHVOs) {
				String cbalatype = invoiceHVO.getCbalatype();
				String vbillcode = invoiceHVO.getVbillcode();
				if (MMStringUtil.isEqual(XIAN_JIN, cbalatype)) {
					String cashaccount = invoiceHVO.getCashaccount();
					if (MMStringUtil.isEmpty(cashaccount)) {
						StringBuilder sBuilder = new StringBuilder();
						sBuilder.append("发票号为:【" + vbillcode + "】");
						sBuilder.append("的现金账户必填");
						listMsg.add(sBuilder.toString());
					}
				} else if (MMStringUtil.isEqual(ZHUAN_ZHANG, cbalatype)) {
					String cbankid = invoiceHVO.getCbankid();
					if (MMStringUtil.isEmpty(cbankid)) {
						StringBuilder sBuilder = new StringBuilder();
						sBuilder.append("发票号为:【" + vbillcode + "】");
						sBuilder.append("的收款银行账户必填");
						listMsg.add(sBuilder.toString());
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}

}
