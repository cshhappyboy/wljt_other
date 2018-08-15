package com.fgc.controller.export;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fgc.controller.report.ReportCommons;
import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.MoneyDetailVO;
import com.fgc.service.export.IExportExcelService;
import com.pub.model.SessionInfo;
import com.pub.utils.CookieUtils;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMStringUtil;

/**
 * Excel导出
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/file")
public class ExportExcelController {

	@Autowired
	private IExportExcelService exportExcelService;

	@RequestMapping("/invoice/{id}")
	public void invoiceExport(@PathVariable(value = "id") String id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			exportExcelService.exportInvoiceExcel(id, sessionInfo.getLocal(), request, response);
		} catch (Exception e) {
			ExceptionUtil.error(e.getMessage(), e);
		}

	}
	@RequestMapping("/invoice/bl/{id}")
	public void invoiceblExport(@PathVariable(value = "id") String id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			exportExcelService.exportInvoiceBlExcel(id, sessionInfo.getLocal(), request, response);
		} catch (Exception e) {
			ExceptionUtil.error(e.getMessage(), e);
		}
		
	}

	@RequestMapping("/receipt/{id}")
	public void receiptExport(@PathVariable(value = "id") String id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			exportExcelService.exportReceiptExcel(id, sessionInfo.getLocal(), request, response);
		} catch (Exception e) {
			ExceptionUtil.error(e.getMessage(), e);
		}
	}

	@RequestMapping("/order/{id}")
	public void orderExport(@PathVariable(value = "id") String id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			exportExcelService.exportOrderExcel(id, sessionInfo.getLocal(), request, response);
		} catch (Exception e) {
			ExceptionUtil.error(e.getMessage(), e);
		}
	}

	@RequestMapping("/whstrans/{id}")
	public void whstransExport(@PathVariable(value = "id") String id, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			exportExcelService.exportWhstransExcel(id, sessionInfo.getLocal(), request, response);
		} catch (Exception e) {
			ExceptionUtil.error(e.getMessage(), e);
		}
	}

	@RequestMapping("/moneyDetail")
	public void moneyDetailExport(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		try {
			MoneyDetailVO moneyDetailVO = null;
			String cookie_query_condition = CookieUtils.getCookieValue(request,
					ReportCommons.COOKIE_QUERY_REPORT_CONDITION, true);
			if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
				moneyDetailVO = JsonUtils.jsonToPojo(cookie_query_condition, MoneyDetailVO.class);
			} else {
				throw new RuntimeException("请先查询再导出数据！！！");
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			exportExcelService.exportMoneyDetailExcel(moneyDetailVO, request, response,sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error(e.getMessage(), e);
		}
	}
}
