package com.fgc.service.report;

import java.util.List;

import com.fgc.pojo.util.Money;
import com.pub.model.SessionInfo;

/**
 * 销售收入报表接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月9日
 *
 *     未来离线需求
 */
public interface IRevenueService {
	/**
	 * 查询数据
	 * 
	 * @param id
	 * @param year
	 * @param month
	 * @param sessionInfo 
	 * @return
	 * @throws Exception
	 */
	public List<Money> queryData(String year, String month, SessionInfo sessionInfo) throws Exception;

}
