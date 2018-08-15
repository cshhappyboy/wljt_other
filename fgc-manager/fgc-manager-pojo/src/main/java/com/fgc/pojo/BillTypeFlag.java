package com.fgc.pojo;

/**
 * 单据类型和单据标识常量类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月24日
 *
 *     未来离线需求
 */
public class BillTypeFlag {
	/**
	 * 销售订单单据类型
	 */
	public final static String ORDER_TYPE = "OR";
	/**
	 * 销售订单单据标识
	 */
	public final static String ORDER_FLAG = "ORDER";

	/**
	 * 预收款单单据类型
	 */
	public final static String RECEIPT_TYPE = "RE";
	/**
	 * 预收款单单据标识
	 */
	public final static String RECEIPT_FLAG = "RECEIPT";

	/**
	 * 发票单据类型
	 */
	public final static String INVOICE_TYPE = "IN";
	/**
	 * 发票单据标识
	 */
	public final static String INVOICE_FLAG = "INVOICE";

	/**
	 * 销售出库单据类型
	 */
	public final static String SALEOUT_TYPE = "SA";
	/**
	 * 销售出库单据标识
	 */
	public final static String SALEOUT_FLAG = "SALEOUT";

	/**
	 * 产成品入库单据类型
	 */
	public final static String FINPRODIN_TYPE = "FI";
	/**
	 * 产成品入库单据标识
	 */
	public final static String FINPRODIN_FLAG = "FINPRODIN";

	/**
	 * 转库单单据类型
	 */
	public final static String WHSTRANS_TYPE = "WH";
	/**
	 * 转库单单据标识
	 */
	public final static String WHSTRANS_FLAG = "WHSTRANS";

}
