package com.pub.utils;

import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月22日
 *
 *     未来离线需求
 */
public class MMNCUtils {
	/**
	 * 当月第一天
	 * 
	 * @return String
	 */
	public static String getMonthFirstDate() {
		return DateTime.now().dayOfMonth().withMinimumValue().toString("yyyy-MM-dd");
	}

	/**
	 * 当月最后一天
	 * 
	 * @return String
	 */
	public static String getMonthLastDate() {
		return DateTime.now().dayOfMonth().withMaximumValue().toString("yyyy-MM-dd");
	}

	public static String getNowDate(Date date) {
		return new DateTime(date.getTime()).toString("yyyy-MM-dd");
	}

	/**
	 * 获取当前时间
	 */
	public static String getNowTime() {
		return DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前日期
	 */
	public static String getNowDate() {
		return DateTime.now().toString("yyyy-MM-dd");
	}
	
	public static String getYear(){
		return DateTime.now().toString("yyyy");
	}
	public static String getMonth(){
		return DateTime.now().toString("MM");
	}

	/**
	 * 获取当前短日期
	 */
	public static String getShortNowDate() {
		return DateTime.now().toString("yyMMdd");
	}

	/**
	 * dr值
	 */
	public static BigDecimal getDR(int dr) {
		return BigDecimal.valueOf(dr);
	}

}
