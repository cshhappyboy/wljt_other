package com.fgc.controller.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月22日
 *
 *     未来离线需求
 */
@Controller
public class ShowPageController {

	/**
	 * 显示主页面
	 */
	@RequestMapping("/")
	public String showLogin() {
		return "login";
	}

	/**
	 * 显示主页面
	 */
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	/**
	 * 跳转首页
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/index")
	public String showIndex(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}

	/**
	 * 显示布局模块和页面
	 * 
	 * @param module
	 * @param page
	 * @return String
	 */
	@RequestMapping("/layout/{page}")
	public String showLayoutPath(@PathVariable String page) {
		return "layout/" + page;
	}

	/**
	 * 重写登录页面链接
	 * 
	 * @return String
	 */
	@RequestMapping("/relogin")
	public String reLogin() {
		return "error/relogin";
	}

	@RequestMapping("/portal/index")
	public String portalIndex() {
		return "portal/index";
	}

	/**
	 * 手动同步界面
	 * 
	 * @return String
	 */
	@RequestMapping("/manual/manual")
	public String showManualPage() {
		return "manual/manual";
	}
}
