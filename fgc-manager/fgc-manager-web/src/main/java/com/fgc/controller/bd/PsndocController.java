package com.fgc.controller.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.service.bd.IPsndocService;
import com.pub.utils.ExceptionUtil;

/**
 * 人员参照档案
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
	public String queryData(String filterData) {
		String result = null;
		try {
			result = psndocService.queryData(filterData);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
		}
		return result;
	}
	
	/**
	 * 根据id查询人员名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String getCustomerNameById(@PathVariable(value = "id") String id) {
		try {
			return psndocService.queryNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询人员名称出错", e);
			return null;
		}
	}
	/**
	 * 根据人员id查询对应的人员部门
	 */
	@RequestMapping("/cdept/{id}")
	@ResponseBody
	public String queryCdeptByPkpsndoc(@PathVariable(value="id")String id){
		try {
			String result=psndocService.queryCdeptByPkpsndoc(id);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("根据人员id查询对应的人员部门出错", e);
			return null;
		}
	}

}
