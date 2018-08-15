package com.fgc.service.bd;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
public interface IStoredocService {

	/**
	 * 查询仓库档案数据
	 * 
	 * @param filterData
	 * @param userid 
	 * @return String
	 */
	public String queryData(String filterData, String userid) throws Exception;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return String
	 */
	public String transNameById(String id) throws Exception;

}
