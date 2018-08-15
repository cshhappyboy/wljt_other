package com.fgc.service.bd;

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
	 * @return String
	 * @throws Exception
	 */
	public String queryData(String filterData) throws Exception;

	/**
	 * 根据客户id查询客户名称
	 * 
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String queryNameById(String id) throws Exception;

}
