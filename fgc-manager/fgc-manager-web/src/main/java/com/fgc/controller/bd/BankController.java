package com.fgc.controller.bd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.bd.IBankService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;

/**
 * 银行账户Controller
 *  
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *   未来离线需求
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
	public String queryData(String filterData) {
		String result = null;
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
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String transNameById(@PathVariable(value = "id") String id,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return bankService.queryNameById(id,sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询银行账户档案数据出错" + id, e);
			return null;
		}
	}

}
