package com.fgc.service.bd;

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
	 * @param string 
	 * @return String
	 * @throws Exception
	 */
	public String transNameById(String id, String string) throws Exception;

}
