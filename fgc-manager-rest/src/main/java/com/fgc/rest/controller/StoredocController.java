package com.fgc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.rest.service.IStoredocService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 仓库档案Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/storedoc")
public class StoredocController {

	@Autowired
	private IStoredocService toredocService;

	/**
	 * 查询仓库档案数据
	 * 
	 * @param filterData
	 * @return String
	 */
	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryData(String filterData,String userId) {
		EUDataGridResult result = null;
		try {
			result = toredocService.queryData(filterData,userId);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
		}
		return result;
	}
	
	/**
	 * 根据id查询名称
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public WebAppResult transNameById(@PathVariable(value = "id") String id) {
		try {
			return toredocService.transNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
			return WebAppResult.build(500, "查询客户档案出错");
		}
	}

}
