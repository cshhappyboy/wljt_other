package com.fgc.controller.manual;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.pojo.ManualVO;
import com.fgc.service.manaul.IManualService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.WebAppResult;

/**
 * 手动同步controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月13日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/manual")
public class ManualController {

	@Autowired
	private IManualService manualService;

	@RequestMapping("/addManual")
	public String showAddManualPage() {
		return "manual/addManual";
	}

	@RequestMapping("/eidtManual")
	public String showEditManualPage(String id, HttpServletRequest request) {
		try {
			ManualVO manualVO = manualService.queryDataById(id);
			request.setAttribute("manualVO", manualVO);
		} catch (Exception e) {
			ExceptionUtil.error("根据id" + id + "查询数据失败", e);
		}
		return "manual/editManual";
	}

	@RequestMapping("/syncManual")
	public String showSyncManualPage(String id, HttpServletRequest request) {
		try {
			ManualVO manualVO = manualService.queryDataById(id);
			manualVO.setBeginDate(MMNCUtils.getNowTime());
			manualVO.setEndDate(MMNCUtils.getNowTime());
			request.setAttribute("manualVO", manualVO);
		} catch (Exception e) {
			ExceptionUtil.error("根据id" + id + "查询数据失败", e);
		}
		return "manual/syncManual";
	}

	/**
	 * 查询所有数据
	 * 
	 * @return EUDataGridResult
	 */
	@RequestMapping("/data")
	@ResponseBody
	public EUDataGridResult queryData() {
		EUDataGridResult result = new EUDataGridResult();
		try {
			return manualService.queryData();
		} catch (Exception e) {
			ExceptionUtil.error("查询同步资源出错", e);
			return result;
		}
	}

	/**
	 * 保存数据
	 * 
	 * @return WebAppResult
	 */
	@RequestMapping("/saveManual")
	@ResponseBody
	public WebAppResult saveManual(ManualVO manualVO) {
		try {
			return manualService.saveData(manualVO);
		} catch (Exception e) {
			ExceptionUtil.error("保存同步资源出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 修改数据
	 * 
	 * @return WebAppResult
	 */
	@RequestMapping("/updateManual")
	@ResponseBody
	public WebAppResult updateManual(ManualVO manualVO) {
		try {
			return manualService.updateData(manualVO);
		} catch (Exception e) {
			ExceptionUtil.error("修改同步资源出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 删除数据
	 * 
	 * @return WebAppResult
	 */
	@RequestMapping("/deleteManual")
	@ResponseBody
	public WebAppResult deleteManual(String id) {
		try {
			return manualService.deleteData(id);
		} catch (Exception e) {
			ExceptionUtil.error("删除同步资源出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	@RequestMapping("/syncManualData")
	@ResponseBody
	public WebAppResult syncManual(ManualVO manualVO) {
		try {
			return manualService.syncManual(manualVO);
		} catch (Exception e) {
			ExceptionUtil.error("同步资源失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
