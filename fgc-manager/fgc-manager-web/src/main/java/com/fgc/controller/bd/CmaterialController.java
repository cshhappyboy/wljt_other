package com.fgc.controller.bd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.service.bd.ICmaterialService;
import com.pub.model.SessionInfo;
import com.pub.utils.ExceptionUtil;

/**
 * 物料树表参照Controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/cmaterial")
public class CmaterialController {

	@Autowired
	private ICmaterialService cmaterialService;

	/**
	 * 查询物料分类档案数据
	 * 
	 * @param filterData
	 * @param id
	 * @return String
	 */
	@RequestMapping("/class/data")
	@ResponseBody
	public String queryClassData(String filterData, String id) {
		try {
			return cmaterialService.queryClassData(filterData, id);
		} catch (Exception e) {
			ExceptionUtil.error("查询物料分类档案数据出错", e);
			return null;
		}
	}

	/**
	 * 查询物料数据
	 * 
	 * @param filterData
	 * @param id
	 * @return String
	 */
	@RequestMapping("/data")
	@ResponseBody
	public String queryCmaterialData(String filterData, String classId,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return cmaterialService.queryCmaterialData(filterData, classId,sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("查询物料数据出错", e);
			return null;
		}
	}

	/**
	 * 根据物料id查询物料编码
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/transCode/{id}")
	@ResponseBody
	public String transCmateriaCodelByid(@PathVariable(value = "id") String id) {
		try {
			return cmaterialService.transCmaterialCodeById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料code出错" + id, e);
			return null;
		}
	}

	/**
	 * 根据物料id查询物料名称
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/transName/{id}")
	@ResponseBody
	public String transCmaterialNameByid(@PathVariable(value = "id") String id,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return cmaterialService.transCmaterialNameById(id,sessionInfo.getLocal());
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料code出错" + id, e);
			return null;
		}
	}

	/**
	 * 根据物料id查询物料规格
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/transSpec/{id}")
	@ResponseBody
	public String transCmaterialSpecById(@PathVariable(value = "id") String id) {
		try {
			return cmaterialService.transCmaterialSpecById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料规格出错" + id, e);
			return null;
		}
	}
	
	/**
	 * 根据物料id查询物料型号
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/transType/{id}")
	@ResponseBody
	public String transCmaterialTypeById(@PathVariable(value = "id") String id) {
		try {
			return cmaterialService.transCmaterialTypeById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料型号出错" + id, e);
			return null;
		}
	}
	
	/**
	 * 根据物料id查询物料辅单位
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/transMeasdoc/{id}")
	@ResponseBody
	public String transCmaterialMeasdocById(@PathVariable(value = "id") String id) {
		try {
			return cmaterialService.transCmaterialMeasdocById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料型号出错" + id, e);
			return null;
		}
	}
}
