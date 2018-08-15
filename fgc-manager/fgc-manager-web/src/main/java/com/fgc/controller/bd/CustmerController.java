package com.fgc.controller.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.service.bd.ICustomerService;
import com.pub.utils.ExceptionUtil;

/**
 * 客户参照Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/customer")
public class CustmerController {

	@Autowired
	private ICustomerService customerService;

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
			result = customerService.queryData(filterData);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
		}
		return result;

	}

	/**
	 * 根据客户id查询客户名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String getCustomerNameById(@PathVariable(value = "id") String id) {
		try {
			return customerService.queryNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据客户id查询客户名称出错", e);
			return null;
		}
	}
}
