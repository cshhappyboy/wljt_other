package com.fgc.controller.bd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.bd.IStoredocService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;

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
	public String queryData(String filterData, HttpSession session) {
		String result = null;
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = toredocService.queryData(filterData, sessionInfo.getId());
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
		}
		return result;
	}

	/**
	 * 无人员过滤查询仓库档案数据
	 * 
	 * @param filterData
	 * @return String
	 */
	@RequestMapping("/allData")
	@ResponseBody
	public String queryAllData(String filterData) {
		String result = null;
		try {
			result = toredocService.queryData(filterData, null);
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
	public String transNameById(@PathVariable(value = "id") String id) {
		try {
			return toredocService.transNameById(id);
		} catch (Exception e) {
			ExceptionUtil.error("查询客户档案出错", e);
			return null;
		}
	}

}
