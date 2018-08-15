package com.pub.utils;

/**
 * 业务单据状态类
 *  
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月25日
 *
 *   未来离线需求
 */
public class BillStatus {
	/**
	 * 自由
	 */
	public static Long FREE = Long.valueOf(0);
	/**
	 * 审批通过
	 */
	public static Long APPROVED = Long.valueOf(1);
	/**
	 * 签字
	 */
	public static Long SIGN = Long.valueOf(2);

}
