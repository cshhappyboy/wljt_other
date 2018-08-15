package com.fgc.controller.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.service.bd.ICdeptService;
import com.pub.utils.ExceptionUtil;

/**
 * 部门控制Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/cdept")
public class CdeptController {
	
	@Autowired
	private ICdeptService cdeptService;

	/**
	 * 查询所有部门数据
	 * 
	 * @param filterData
	 * @return String
	 */
	@RequestMapping("data")
	@ResponseBody
	public String queryData(String filterData,String id) {
		try {
			return cdeptService.queryData(filterData,id);
		} catch (Exception e) {
			ExceptionUtil.error("查询所有部门数据出错", e);
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
	public String getNameById(@PathVariable(value = "id") String id) {
		try {
			return cdeptService.queryNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据客户id查询客户名称出错", e);
			return null;
		}
	}

}
