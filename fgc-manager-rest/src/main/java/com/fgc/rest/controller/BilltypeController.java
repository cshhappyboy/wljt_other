package com.fgc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.pojo.databsase.Billtype;
import com.fgc.rest.service.IBilltypeService;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 单据类型档案Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/billtype")
public class BilltypeController {

	@Autowired
	private IBilltypeService billtypeService;

	/**
	 * 获取单据类型
	 * 
	 * @param typeCode
	 * @return Billtype
	 */
	@RequestMapping("/{code}/{local}")
	@ResponseBody
	public List<Billtype> getBilltype(@PathVariable(value = "code") String code,@PathVariable(value="local") String local) {
		try {
			return billtypeService.queryBilltypeData(code,local);
		} catch (Exception e) {
			ExceptionUtil.error("获取单据类型出错", e);
			return null;
		}
	}

	/**
	 * 根据pk获取档案名称
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	@RequestMapping("/trans/{id}/{local}")
	@ResponseBody
	public WebAppResult getBilltypeNameById(@PathVariable(value = "id") String id,@PathVariable(value="local") String local) {
		try {
			return billtypeService.queryBilltypeNameById(id,local);
		} catch (Exception e) {
			ExceptionUtil.error("根据id,获取单据类型名称出错", e);
			return WebAppResult.build(500, "根据id,获取单据类型名称出错");
		}
	}

}
