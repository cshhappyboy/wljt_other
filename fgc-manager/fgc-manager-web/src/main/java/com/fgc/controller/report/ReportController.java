package com.fgc.controller.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.MoneyDetailVO;
import com.fgc.pojo.util.Money;
import com.fgc.service.report.IReceiptPortService;
import com.fgc.service.report.IRevenueService;
import com.pub.model.SessionInfo;
import com.pub.utils.CookieUtils;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMNCUtils;

/**
 * 销售收入报表导出
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月9日
 *
 *     未来离线需求
 */
@RequestMapping("/report")
@Controller
public class ReportController {

	@Autowired
	private IRevenueService revenueService;

	@Autowired
	private IReceiptPortService receiptPortService;

	/**
	 * 跳转报表界面
	 * 
	 * @return String
	 */
	@RequestMapping("/revenue")
	public String showRevenue() {
		return "report/revenue";
	}

	/**
	 * 跳转到查询界面
	 * 
	 * @return String
	 */
	@RequestMapping("/revenueQuery")
	public String showQueryPage(HttpServletRequest request) {
		request.setAttribute("year", MMNCUtils.getYear());
		request.setAttribute("month", MMNCUtils.getMonth());
		return "report/revenueQuery";
	}

	/**
	 * 查询数据
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping("/moneyData")
	@ResponseBody
	public List<Money> queryData(String year, String month,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return revenueService.queryData(year, month,sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("报表查询失败", e);
			return null;
		}
	}

	/**
	 * 跳转明细页面
	 * 
	 * @return String
	 */
	@RequestMapping("/receipt")
	public String showReceiptPage() {
		return "report/receiptPage";
	}

	/**
	 * 跳转明细查询页面
	 * 
	 * @return String
	 */
	@RequestMapping("/receiptQuery")
	public String showReceiptQueryPage(HttpServletRequest request) {
		MoneyDetailVO moneyDetailVO = new MoneyDetailVO();
		moneyDetailVO.setDbilldate(MMNCUtils.getNowDate());
		request.setAttribute("moneyDetailVO", moneyDetailVO);
		return "report/receiptQueryPage";
	}

	@RequestMapping("/moneyDetail")
	@ResponseBody
	public List<MoneyDetailVO> queryDetailData(MoneyDetailVO moneyDetailVO, HttpServletRequest request,
			HttpServletResponse response,HttpSession session) {
		try {
			CookieUtils.setCookie(request, response, ReportCommons.COOKIE_QUERY_REPORT_CONDITION,
					JsonUtils.objectToJson(moneyDetailVO), true);
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return receiptPortService.queryDetailVO(moneyDetailVO,sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("报表查询失败", e);
			return null;
		}
	}

}
