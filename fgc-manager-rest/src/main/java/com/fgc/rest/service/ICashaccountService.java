package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 现金账户接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
public interface ICashaccountService {

	/**
	 * 查询现金账户
	 * 
	 * @param filterData
	 * @return String
	 */
	public EUDataGridResult queryData(String filterData) throws Exception;

	/**
	 * 根据现金账户查询名称出错
	 * 
	 * @param id
	 * @param local 
	 * @return WebAppResult
	 */
	public WebAppResult queryNameById(String id, String local) throws Exception;

}
