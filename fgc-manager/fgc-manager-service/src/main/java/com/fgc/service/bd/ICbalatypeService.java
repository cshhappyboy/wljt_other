package com.fgc.service.bd;

/**
 * 结算方式接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface ICbalatypeService {
	/**
	 * 查询所有的结算方式
	 * 
	 * @param string
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String queryData(String string) throws Exception;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @param string
	 * @return String
	 */
	public String queryNameById(String id, String string) throws Exception;
}
