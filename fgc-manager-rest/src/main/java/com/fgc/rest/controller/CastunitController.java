package com.fgc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.rest.service.ICastunitService;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 计量单位档案Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/castunit")
public class CastunitController {

	@Autowired
	private ICastunitService castunitService;

	/**
	 * 根据计量单位查询名称
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/trans/{id}/{local}")
	@ResponseBody
	public WebAppResult transNameById(@PathVariable(value = "id") String id,@PathVariable(value="local")String local) {
		try {
			return castunitService.transNameById(id,local);
		} catch (Exception e) {
			ExceptionUtil.error("根据计量单位查询名称出错" + id, e);
			return WebAppResult.build(500, "根据计量单位查询名称出错" + id);
		}
	}

}
