package com.pub.utils;

/**
 * ts并发校验
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月27日
 *
 *     未来离线需求
 */
public class TSException {

	public static void error() {
		throw new RuntimeException("单据出现并发，请刷新界面！！！");
	}
}
