package com.pub.rule;

/**
 *  
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *   未来离线需求
 */
public interface ISRule<H> {
	
	public void process(H hvo)throws Exception;

}
