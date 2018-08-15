package com.fgc.rest.service;

/**
 * 获取公共配置接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
public interface IPubInfoService {

	public String getPk_group() throws Exception;

	public String getPk_org() throws Exception;

	public String getValueByCode(String code) throws Exception;

}
