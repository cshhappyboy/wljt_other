package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

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
	 * @param userId 
	 * @return String
	 */
	public EUDataGridResult queryData(String filterData, String userId) throws Exception;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	public WebAppResult transNameById(String id) throws Exception;

}
