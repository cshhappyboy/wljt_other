package com.fgc.service.bd;

/**
 * 银行账户服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
public interface IBankService {

	/**
	 * @param filterData
	 * @return String
	 */
	public String queryData(String filterData) throws Exception;

	/**
	 * @param id
	 * @param string 
	 * @return String
	 */
	public String queryNameById(String id, String string) throws Exception;

}
