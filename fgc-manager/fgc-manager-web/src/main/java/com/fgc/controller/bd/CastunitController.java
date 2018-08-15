package com.fgc.controller.bd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.bd.ICastunitService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;

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
	@RequestMapping("/trans/{id}")
	@ResponseBody
	public String transNameById(@PathVariable(value = "id") String id,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return castunitService.transNameById(id,sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("根据计量单位查询名称出错" + id, e);
			return null;
		}
	}

}
