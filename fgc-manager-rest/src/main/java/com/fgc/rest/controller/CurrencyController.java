package com.fgc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.rest.service.ICurrencyService;
import com.pub.utils.EUDataGridResult;
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

	/**
	 * 查询数据
	 * 
	 * @param filterData
	 * @return EUDataGridResult
	 */
	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryData(String filterData) {
		EUDataGridResult result = null;
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
	@RequestMapping("/trans/{id}/{local}")
	@ResponseBody
	public WebAppResult getCustomerNameById(@PathVariable(value = "id") String id,
			@PathVariable(value = "local") String local) {
		try {
			return currencyService.queryNameById(id,local);
		} catch (Exception e) {
			ExceptionUtil.error("根据客户id查询客户名称出错", e);
			return null;
		}
	}

}
