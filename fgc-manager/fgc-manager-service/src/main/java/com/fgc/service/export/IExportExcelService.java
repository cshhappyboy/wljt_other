package com.fgc.service.export;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fgc.pojo.MoneyDetailVO;
import com.pub.model.SessionInfo;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public interface IExportExcelService {

	/**
	 * 导出发票Excel
	 * 
	 * @param id
	 * @param string
	 * @param request
	 * @param response
	 */
	public void exportInvoiceExcel(String id, String string, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 导出收款单Excel
	 * 
	 * @param id
	 * @param string
	 * @param request
	 * @param response
	 */
	public void exportReceiptExcel(String id, String string, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 导出销售订单Excel
	 * 
	 * @param id
	 * @param local
	 * @param request
	 * @param response
	 */
	public void exportOrderExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 导出转库单
	 * 
	 * @param id
	 * @param local
	 * @param request
	 * @param response
	 */
	public void exportWhstransExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 导出销售明细表
	 * 
	 * @param moneyDetailVO
	 * @param request
	 * @param response
	 * @param sessionInfo
	 */
	public void exportMoneyDetailExcel(MoneyDetailVO moneyDetailVO, HttpServletRequest request,
			HttpServletResponse response, SessionInfo sessionInfo) throws Exception;

	/**
	 * @param id
	 * @param local
	 * @param request
	 * @param response
	 */
	public void exportInvoiceBlExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
