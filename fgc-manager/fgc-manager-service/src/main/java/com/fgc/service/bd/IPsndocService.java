package com.fgc.service.bd;

/**
 * 人员服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface IPsndocService {

	/**
	 * 查询参照数据
	 * 
	 * @param filterData
	 * @return String
	 */
	public String queryData(String filterData) throws Exception;

	/**
	 * 根据人员id查询名称
	 * 
	 * @param id
	 * @return String
	 */
	public String queryNameById(String id) throws Exception;

	/**
	 * 根据人员id查询对应的人员部门
	 * 
	 * @param id
	 * @return String
	 */
	public String queryCdeptByPkpsndoc(String id) throws Exception;

}
