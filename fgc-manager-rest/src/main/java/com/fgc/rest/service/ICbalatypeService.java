package com.fgc.rest.service;

import java.util.List;

import com.fgc.pojo.databsase.Billtype;
import com.pub.utils.WebAppResult;

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
	 * @return String
	 * @throws Exception
	 */
	public List<Billtype> queryData(String local) throws Exception;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @param local 
	 * @return WebAppResult
	 */
	public WebAppResult queryNameById(String id, String local) throws Exception;
}
