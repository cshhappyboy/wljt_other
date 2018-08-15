package com.fgc.service.export.impl.receipt;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.service.pub.IPubInfoService;
import com.pub.export.itf.IPOIParams;

/**
 * 收款单导出参数
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月22日
 *
 *     未来离线需求
 */
@Component
public class ReceiptPOIParams implements IPOIParams {

	private static final String EXCEL_ROOT_PATH = "excel/";

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public String getExportSheetName() {
		return pubInfoService.getValueByCode("RECEIPT_EXPORT_SHEET_NAME");
	}

	@Override
	public InputStream getTemplateInputStream() {
		return this.getClass().getClassLoader()
				.getResourceAsStream(EXCEL_ROOT_PATH + pubInfoService.getValueByCode("RECEIPT_FILE_NAME"));
	}

}
