package com.fgc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.rest.service.IPsndocService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * rest用户服务Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/psndoc")
public class PsndocController {
	
	@Autowired
	private IPsndocService psndocService;

	/**
	 * 查询数据
	 * 
	 * @param filterData
	 * @return EUDataGridResult
	 */
	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryData(String filterData) {
		EUDataGridResult result = null;
		try {
			result = psndocService.queryData(filterData);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
		}
		return result;

	}

	/**
	 * 根据人员id查询人员名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public WebAppResult getCustomerNameById(@PathVariable(value = "id") String id) {
		try {
			return psndocService.queryNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据人员id查询人员名称出错", e);
			return WebAppResult.build(500, "根据人员id查询人员名称");
		}
	}
	
	/**
	 * 根据人员id查询对应的人员部门
	 */
	@RequestMapping("/cdept/{id}")
	@ResponseBody
	public WebAppResult queryCdeptByPkpsndoc(@PathVariable(value="id")String id){
		try {
			return psndocService.queryCdeptByPkpsndoc(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据人员id查询对应的人员部门出错", e);
			return WebAppResult.build(500, "根据人员id查询对应的人员部门出错");
		}
	}
}
