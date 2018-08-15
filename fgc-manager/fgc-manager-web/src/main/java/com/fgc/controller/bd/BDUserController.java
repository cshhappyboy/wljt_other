package com.fgc.controller.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.service.bd.IBDUserService;
import com.pub.utils.ExceptionUtil;

/**
 * 用户Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/bduser")
public class BDUserController {
	@Autowired
	private IBDUserService userService;

	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String queryNameById(@PathVariable(value = "id") String id) {
		try {
			return userService.queryNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询名称出错", e);
			return null;
		}
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @param filterData
	 * @return String
	 */
	@RequestMapping("/data")
	@ResponseBody
	public String queryData(String filterData) {
		try {
			return userService.queryData(filterData);
		} catch (Exception e) {
			ExceptionUtil.error("查询用户出错", e);
			return null;
		}
	}
}
