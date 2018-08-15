package com.fgc.controller.bd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.bd.ICbalatypeService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;

/**
 * 结算方式Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/cbalatype")
public class CbalatypeController {

	@Autowired
	private ICbalatypeService cbalatypeService;

	/**
	 * 查询所有的结算方式
	 * 
	 * @return String
	 */
	@RequestMapping("/data")
	@ResponseBody
	public String queryData(HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return cbalatypeService.queryData(sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("查询所有的结算方式出错", e);
			return null;
		}
	}

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String getNameById(@PathVariable(value = "id") String id, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return cbalatypeService.queryNameById(id, sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询名称" + id, e);
			return null;
		}
	}

}
