package com.fgc.service.upload;

import com.pub.utils.EUDataGridResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月30日
 *
 *     未来离线需求
 */
public interface ILogService {

	public EUDataGridResult queryDocData(int page, int rows) throws Exception;

	/**
	 * @param page
	 * @param rows
	 * @return
	 */
	public EUDataGridResult queryBillData(int page, int rows) throws Exception;

}
