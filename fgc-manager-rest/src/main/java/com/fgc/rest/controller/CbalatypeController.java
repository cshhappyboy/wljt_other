package com.fgc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.pojo.databsase.Billtype;
import com.fgc.rest.service.ICbalatypeService;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

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
	@RequestMapping("/data/{local}")
	@ResponseBody
	public List<Billtype> queryData(@PathVariable(value="local")String local) {
		try {
			return cbalatypeService.queryData(local);
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
	@RequestMapping("/trans/{id}/{local}")
	@ResponseBody
	public WebAppResult getNameById(@PathVariable(value = "id") String id,@PathVariable(value="local")String local) {
		try {
			return cbalatypeService.queryNameById(id,local);
		} catch (Exception e) {
			ExceptionUtil.error("根据客户id查询客户名称出错", e);
			return null;
		}
	}

}
