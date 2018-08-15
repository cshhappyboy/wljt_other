package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
public interface ICurrencyService {
	/**
	 * 查询客户档案数据
	 * 
	 * @param filterData
	 * @return String
	 * @throws Exception
	 */
	public EUDataGridResult queryData(String filterData) throws Exception;

	/**
	 * 根据客户id查询客户名称
	 * 
	 * @param id
	 * @param local 
	 * @return String
	 * @throws Exception
	 */
	public WebAppResult queryNameById(String id, String local) throws Exception;
	
}
