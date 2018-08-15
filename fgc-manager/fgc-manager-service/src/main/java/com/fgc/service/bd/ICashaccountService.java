package com.fgc.service.bd;

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
	public String queryData(String filterData) throws Exception;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @param string 
	 */
	public String queryNameById(String id, String string) throws Exception;

}
