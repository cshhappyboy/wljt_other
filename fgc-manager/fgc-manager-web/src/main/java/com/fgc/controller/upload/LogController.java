package com.fgc.controller.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.service.upload.ILogService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月30日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/upload")
public class LogController {

	@Autowired
	private ILogService logService;

	@RequestMapping("/doc")
	public String showUploadDocPage() {
		return "upload/doc";
	}
	
	@RequestMapping("/bill")
	public String showUploadBillPage() {
		return "upload/bill";
	}

	@RequestMapping("/docData")
	@ResponseBody
	public EUDataGridResult queryDocData(int page, int rows) {
		try {
			return logService.queryDocData(page, rows);
		} catch (Exception e) {
			ExceptionUtil.error("查询档案同步日志", e);
			return null;
		}
	}
	
	@RequestMapping("/billData")
	@ResponseBody
	public EUDataGridResult queryBillData(int page, int rows) {
		try {
			return logService.queryBillData(page, rows);
		} catch (Exception e) {
			ExceptionUtil.error("查询单据同步日志", e);
			return null;
		}
	}

}
