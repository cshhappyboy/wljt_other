package com.fgc.rest.service;

import java.util.List;

import com.pub.model.Tree;
import com.pub.utils.WebAppResult;

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
	public List<Tree> queryData(String filterData, String id) throws Exception;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	public WebAppResult queryNameById(String id) throws Exception;

}
