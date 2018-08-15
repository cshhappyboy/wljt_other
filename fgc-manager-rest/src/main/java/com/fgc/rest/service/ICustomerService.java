package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 客户档案接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
public interface ICustomerService {
	/**
	 * 查询客户档案数据
	 * 
	 * @param filterData
	 * @return EUDataGridResult
	 * @throws Exception
	 */
	public EUDataGridResult queryData(String filterData) throws Exception;

	/**
	 * 根据客户id查询客户名称
	 * 
	 * @param id
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult queryNameById(String id) throws Exception;

}
