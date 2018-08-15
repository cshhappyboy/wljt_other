package com.fgc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.rest.service.IBankService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 银行账户Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private IBankService bankService;

	/**
	 * 查询银行账户档案数据
	 * 
	 * @param filterData
	 * @return String
	 */
	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryData(String filterData) {
		EUDataGridResult result = null;
		try {
			result = bankService.queryData(filterData);
		} catch (Exception e) {
			ExceptionUtil.error("查询银行账户档案数据出错", e);
		}
		return result;
	}

	/**
	 * 根据id查询银行账户档案数据
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/trans/{id}/{local}")
	@ResponseBody
	public WebAppResult transNameById(@PathVariable(value = "id") String id,
			@PathVariable(value = "local") String local) {
		try {
			return bankService.queryNameById(id,local);
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询银行账户档案数据出错" + id, e);
			return WebAppResult.build(500, "根据id查询银行账户档案数据出错" + id);
		}
	}

}
