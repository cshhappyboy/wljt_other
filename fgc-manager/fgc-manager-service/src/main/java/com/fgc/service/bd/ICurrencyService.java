package com.fgc.service.bd;

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
	public String queryData(String filterData) throws Exception;

	/**
	 * 根据客户id查询客户名称
	 * 
	 * @param id
	 * @param string 
	 * @return String
	 * @throws Exception
	 */
	public String queryNameById(String id, String string) throws Exception;
	
}
