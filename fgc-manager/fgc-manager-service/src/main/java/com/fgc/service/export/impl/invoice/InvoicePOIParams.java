package com.fgc.service.export.impl.invoice;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.service.pub.IPubInfoService;
import com.pub.export.itf.IPOIParams;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
@Service
public class InvoicePOIParams implements IPOIParams {

	private static final String EXCEL_ROOT_PATH = "excel/";

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public String getExportSheetName() {
		return pubInfoService.getValueByCode("INVOICE_EXPORT_SHEET_NAME");
	}

	@Override
	public InputStream getTemplateInputStream() {
		return this.getClass().getClassLoader()
				.getResourceAsStream(EXCEL_ROOT_PATH + pubInfoService.getValueByCode("INVOICE_FILE_NAME"));
	}

}
