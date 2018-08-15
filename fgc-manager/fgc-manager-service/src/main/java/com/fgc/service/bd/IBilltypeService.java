package com.fgc.service.bd;

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
	 * @param string 
	 * @return String
	 * @throws Exception
	 */
	public String queryBilltypeData(String typeCode, String string) throws Exception;

	/**
	 * 根据单据类型id查询单据类型名称
	 * @param string 
	 * 
	 * @return WebAppResult
	 * @throws Exception
	 */
	public String queryBilltypeNameById(String id, String string) throws Exception;

}
