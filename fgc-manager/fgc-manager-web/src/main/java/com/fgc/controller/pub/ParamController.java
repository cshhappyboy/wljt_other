package com.fgc.controller.pub;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.pojo.PubParamVO;
import com.fgc.service.pub.IParamService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月16日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("param")
public class ParamController {

	@Autowired
	private IParamService paramService;

	/**
	 * 跳转参数界面
	 * 
	 * @return String
	 */
	@RequestMapping("/param")
	public String showParamListPage() {
		return "param/param";
	}

	/**
	 * 跳转参数新增界面
	 * 
	 * @return String
	 */
	@RequestMapping("/addParam")
	public String showAddParamPage() {
		return "param/addParam";
	}

	/**
	 * 跳转参数新增界面
	 * 
	 * @return String
	 */
	@RequestMapping("/editParam")
	public String showAddParamPage(String id,HttpServletRequest request) {
		PubParamVO pubParamVO;
		try {
			pubParamVO = paramService.queryParamById(id);
			request.setAttribute("paramVO", pubParamVO);
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询参数数据：id"+id, e);
		}
		return "param/editParam";
	}

	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryData() {
		try {
			return paramService.queryParam();
		} catch (Exception e) {
			ExceptionUtil.error("查询全局参数出错", e);
			return null;
		}
	}

	@RequestMapping("/saveParam")
	@ResponseBody
	public WebAppResult saveParam(PubParamVO paramVO) {
		try {
			return paramService.saveParam(paramVO);
		} catch (Exception e) {
			ExceptionUtil.error("添加全局参数出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	@RequestMapping("/updateParam")
	@ResponseBody
	public WebAppResult updateParam(PubParamVO paramVO) {
		try {
			return paramService.updateParam(paramVO);
		} catch (Exception e) {
			ExceptionUtil.error("修改全局参数出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	@RequestMapping("/deleteParam")
	@ResponseBody
	public WebAppResult deleteParam(String id) {
		try {
			return paramService.deleteParam(id);
		} catch (Exception e) {
			ExceptionUtil.error("删除全局参数出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
