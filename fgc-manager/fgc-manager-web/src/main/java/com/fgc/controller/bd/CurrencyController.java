package com.fgc.controller.bd;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.adjustrate.IAdjustrateService;
import com.fgc.service.bd.ICurrencyService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private ICurrencyService currencyService;

	@Autowired
	private IAdjustrateService adjustrateService;

	/**
	 * 查询数据
	 * 
	 * @param filterData
	 * @return EUDataGridResult
	 */
	@RequestMapping("/data")
	@ResponseBody
	public String queryData(String filterData) {
		String result = null;
		try {
			result = currencyService.queryData(filterData);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
		}
		return result;

	}

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String getCustomerNameById(@PathVariable(value = "id") String id, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return currencyService.queryNameById(id, sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("根据客户id查询客户名称出错", e);
			return null;
		}
	}

	/**
	 * 根据币种查询折本汇率
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/adjustrate/{id}")
	@ResponseBody
	public WebAppResult queryDataByadjustrate(@PathVariable(value = "id") String id, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			BigDecimal adjustrate = adjustrateService.selectByCurreny(id, sessionInfo.getNowDate());
			return WebAppResult.ok(adjustrate);
		} catch (Exception e) {
			ExceptionUtil.error("根据币种查询汇率出错", e);
			return null;
		}
	}
}
