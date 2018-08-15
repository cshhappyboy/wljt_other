package com.fgc.service.pub;

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

	public String getPk_group();

	public String getPk_org();

	public String getCurrency();

	public String getCashaccount(String cdept);

	public String getValueByCode(String code);

}
