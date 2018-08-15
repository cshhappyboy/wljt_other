package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 用户服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface IBDUserService {
	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult queryNameById(String id) throws Exception;

	/**
	 * 查询所有用户信息
	 * 
	 * @param filterData
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryData(String filterData) throws Exception;

}
