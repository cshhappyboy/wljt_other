package com.fgc.service.bd;

/**
 * 部门档案接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface ICdeptService {

	/**
	 * 查询部门档案数据
	 * 
	 * @param filterData
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String queryData(String filterData, String id) throws Exception;

	/**
	 * 根据部门id查询部门名称
	 * 
	 * @param id
	 * @return String
	 */
	public String queryNameById(String id) throws Exception;

}
