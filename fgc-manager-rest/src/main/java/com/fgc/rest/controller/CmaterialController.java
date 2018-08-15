package com.fgc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.rest.service.ICmaterialService;
import com.pub.model.Tree;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.WebAppResult;

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
	public List<Tree> queryClassData(String filterData, String id) {
		try {
			return cmaterialService.queryClassData(filterData, id);
		} catch (Exception e) {
			ExceptionUtil.error("查询物料分类档案数据出错", e);
			return null;
		}
	}

	/**
	 * 根据物理分类id查询物料
	 * 
	 * @param filterData
	 * @param classId
	 * @return EUDataGridResult
	 */
	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryCmaterialData(String filterData, String classId, String local) {
		try {
			return cmaterialService.queryCmaterilaData(filterData, classId, local);
		} catch (Exception e) {
			ExceptionUtil.error("根据物理分类id查询物料出错" + classId, e);
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
	public WebAppResult transCmaterialCodeByid(@PathVariable(value = "id") String id) {
		try {
			return cmaterialService.transCmaterialCodeById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料code出错" + id, e);
			return WebAppResult.build(500, "根据物料id查询物料code出错");
		}
	}

	/**
	 * 根据物料id查询物料编码
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/transName/{id}/{local}")
	@ResponseBody
	public WebAppResult transCmaterialNameByid(@PathVariable(value = "id") String id,
			@PathVariable(value = "local") String local) {
		try {
			return cmaterialService.transCmaterialNameById(id, local);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料code出错" + id, e);
			return WebAppResult.build(500, "根据物料id查询物料code出错");
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
	public WebAppResult transCmaterialSpecById(@PathVariable(value = "id") String id) {
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
	public WebAppResult transCmaterialTypeById(@PathVariable(value = "id") String id) {
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
	public WebAppResult transCmaterialMeasdocById(@PathVariable(value = "id") String id) {
		try {
			return cmaterialService.transCmaterialMeasdocById(id);
		} catch (Exception e) {
			ExceptionUtil.error("根据物料id查询物料型号出错" + id, e);
			return null;
		}
	}

}
