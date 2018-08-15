package com.fgc.controller.pub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.pub.IPubInfoService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 获取集团，组织参数服务
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/context")
public class PubInfoController {

	@Autowired
	private IPubInfoService pubInfoService;

	/**
	 * 获取集团pk
	 * 
	 * @return String
	 */
	@RequestMapping("/group")
	@ResponseBody
	public String getPkGroup() {
		String pk_group = null;
		try {
			pk_group = pubInfoService.getPk_group();
		} catch (Exception e) {
			ExceptionUtil.error("获取集团参数出现异常", e);
		}
		return pk_group;
	}

	/**
	 * 获取组织pk
	 * 
	 * @return String
	 */
	@RequestMapping("/org")
	@ResponseBody
	public String getPkOrg() {
		String pk_org = null;
		try {
			pk_org = pubInfoService.getPk_org();
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtil.error("获取组织参数出现异常", e);
		}
		return pk_org;
	}

	/**
	 * 跳转修改业务日期界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/ywDate")
	public String changeYWDate(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
		request.setAttribute("ywdate", sessionInfo.getNowDate());
		return "ywdate/date";
	}

	/**
	 * 设置业务日期在session中
	 * 
	 * @param ywdate
	 * @param session
	 * @return WebAppResult
	 */
	@RequestMapping("/changeDate")
	@ResponseBody
	public WebAppResult changeDate(String ywdate, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			sessionInfo.setNowDate(ywdate);
			return WebAppResult.ok(ywdate);
		} catch (Exception e) {
			ExceptionUtil.error("设置业务日期出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
