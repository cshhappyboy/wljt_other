package com.fgc.rest.service;

import com.pub.utils.WebAppResult;

/**
 * 计量单位档案接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
public interface ICastunitService {
	/**
	 * 根据id查询计量单位名称
	 * 
	 * @param id
	 * @param local 
	 * @return String
	 * @throws Exception
	 */
	public WebAppResult transNameById(String id, String local) throws Exception;

}
