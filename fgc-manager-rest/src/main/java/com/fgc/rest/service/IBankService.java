package com.fgc.rest.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 银行账户服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
public interface IBankService {

	/**
	 * @param filterData
	 * @return String
	 */
	public EUDataGridResult queryData(String filterData) throws Exception;

	/**
	 * @param id
	 * @param local 
	 * @return String
	 */
	public WebAppResult queryNameById(String id, String local) throws Exception;

}
