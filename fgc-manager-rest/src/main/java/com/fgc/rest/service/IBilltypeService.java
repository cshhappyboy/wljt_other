package com.fgc.rest.service;

import java.util.List;

import com.fgc.pojo.databsase.Billtype;
import com.pub.utils.WebAppResult;

/**
 * 单据类型接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
public interface IBilltypeService {
	/**
	 * 根据单据类型编码查询单据类型
	 * 
	 * @param typeCode
	 * @param local 
	 * @return Billtype
	 * @throws Exception
	 */
	public List<Billtype> queryBilltypeData(String typeCode, String local) throws Exception;

	/**
	 * 根据单据类型id查询单据类型名称
	 * @param local 
	 * 
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult queryBilltypeNameById(String id, String local) throws Exception;

}
