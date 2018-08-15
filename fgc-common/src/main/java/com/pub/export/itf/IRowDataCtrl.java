package com.pub.export.itf;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public interface IRowDataCtrl {

	public void loadSheetData(HSSFWorkbook hssfWorkbook, HSSFSheet sheet);
}
