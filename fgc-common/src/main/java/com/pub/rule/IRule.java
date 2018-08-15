package com.pub.rule;

/**
 * 业务规则接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月25日
 *
 *     未来离线需求
 */
public interface IRule<H, B> {

	public void process(H hvo, B[] bvos) throws Exception;
}
