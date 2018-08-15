package com.fgc.pojo.util;

import java.math.BigDecimal;

/**
 * 回写参数类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月25日
 *
 *     未来离线需求
 */
public class RewriteParamVO {

	private String effectBillCode;

	private String id;

	private BigDecimal data;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the data
	 */
	public BigDecimal getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(BigDecimal data) {
		this.data = data;
	}

	/**
	 * @return the effectBillCode
	 */
	public String getEffectBillCode() {
		return effectBillCode;
	}

	/**
	 * @param effectBillCode
	 *            the effectBillCode to set
	 */
	public void setEffectBillCode(String effectBillCode) {
		this.effectBillCode = effectBillCode;
	}

}
