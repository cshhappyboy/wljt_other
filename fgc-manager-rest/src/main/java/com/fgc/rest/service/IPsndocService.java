package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface IPsndocService {

	/**
	 * @param filterData
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryData(String filterData) throws Exception;
	
	/**
	 * 根据人员id查询客户名称
	 * 
	 * @param id
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult queryNameById(String id) throws Exception;
	/**
	 * 根据人员id查询对应的人员部门
	 * 
	 * @param id
	 * @return String
	 */
	public WebAppResult queryCdeptByPkpsndoc(String id) throws Exception;
}
