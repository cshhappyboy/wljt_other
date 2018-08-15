package com.fgc.controller.bd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.bd.IBilltypeService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;

/**
 * 单据类型档案Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/billtype")
public class BilltypeController {

	@Autowired
	private IBilltypeService billtypeService;

	/**
	 * 获取单据类型
	 * 
	 * @param typeCode
	 * @return Billtype
	 */
	@RequestMapping("/{code}")
	@ResponseBody
	public String getBilltype(@PathVariable(value = "code") String code,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return billtypeService.queryBilltypeData(code,sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("获取单据类型出错", e);
			return null;
		}
	}

	/**
	 * 根据pk获取档案名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String getBilltypeNameById(@PathVariable(value = "id") String id,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return billtypeService.queryBilltypeNameById(id,sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("根据id,获取单据类型名称出错", e);
			return null;
		}
	}

}
