package com.fgc.service.report;

import java.util.List;

import com.fgc.pojo.MoneyDetailVO;
import com.pub.model.SessionInfo;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月10日
 *
 *     未来离线需求
 */
public interface IReceiptPortService {

	public List<MoneyDetailVO> queryDetailVO(MoneyDetailVO moneyDetailVO, SessionInfo sessionInfo) throws Exception;

}
