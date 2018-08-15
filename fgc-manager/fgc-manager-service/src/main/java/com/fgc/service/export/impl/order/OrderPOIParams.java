package com.fgc.service.export.impl.order;

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
public class OrderPOIParams implements IPOIParams {

	private static final String EXCEL_ROOT_PATH = "excel/";

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public String getExportSheetName() {
		return pubInfoService.getValueByCode("ORDER_EXPORT_SHEET_NAME");
	}

	@Override
	public InputStream getTemplateInputStream() {
		return this.getClass().getClassLoader()
				.getResourceAsStream(EXCEL_ROOT_PATH + pubInfoService.getValueByCode("ORDER_FILE_NAME"));
	}

}
