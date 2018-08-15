package com.fgc.pojo.util;

import java.math.BigDecimal;

/**
 * 收款单过度VO
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月25日
 *
 *     未来离线需求
 */
public class ReceiptMoneyVO {

	private String orderId;

	private BigDecimal receiptMoney;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the receiptMoney
	 */
	public BigDecimal getReceiptMoney() {
		return receiptMoney;
	}

	/**
	 * @param receiptMoney
	 *            the receiptMoney to set
	 */
	public void setReceiptMoney(BigDecimal receiptMoney) {
		this.receiptMoney = receiptMoney;
	}

}
