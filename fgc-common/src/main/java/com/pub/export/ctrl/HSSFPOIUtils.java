package com.pub.export.ctrl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pub.export.itf.IPOIParams;
import com.pub.export.itf.IRowDataCtrl;

/**
 * POI工程对Excel 97(-2007)文件操作
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public class HSSFPOIUtils {

	private IPOIParams poiParams;

	private HSSFWorkbook hssfWorkbook;

	// private HSSFSheet sheet;

	// private IRowDataCtrl rowDataCtrl;

	public HSSFPOIUtils(IPOIParams poiParams) {
		this.poiParams = poiParams;
	}

	public void setRowDataCtrl(HSSFSheet sheet, IRowDataCtrl rowDataCtrl) {
		// this.sheet = sheet;
		// this.rowDataCtrl = rowDataCtrl;
		setDataToSheet(sheet, rowDataCtrl);
	}

	/**
	 * 加载模板excel的工作簿到内存中并在内存中实例化Excel文件和第一个工作簿（sheet）
	 * 
	 * @param templateExcelFileName
	 * @throws IOException
	 */
	public HSSFWorkbook createWorkBookFile() throws IOException {
		InputStream inputStream = poiParams.getTemplateInputStream();
		try {
			return hssfWorkbook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			throw new RuntimeException("Excel内存文件创建失败");
		} finally {
			inputStream.close();
		}
	}

	// public HSSFWorkbook doActionForExport() {
	// try {
	// // 1、载模板excel的工作簿到内存中并在内存中实例化Excel文件和第一个工作簿（sheet）
	// this.createWorkBookFile();
	// // 2、把要导出的数据设置在工作簿上
	// this.setDataToSheet();
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return hssfWorkbook;
	// }

	private void setDataToSheet(HSSFSheet sheet, IRowDataCtrl rowDataCtrl) {
		if (null == rowDataCtrl) {
			throw new RuntimeException("没有要导出的数据,请实现数据导出接口");
		}
		rowDataCtrl.loadSheetData(hssfWorkbook, sheet);
	}

	// private void createWorkBookFile() throws IOException {
	// InputStream inputStream = poiParams.getTemplateInputStream();
	// try {
	// hssfWorkbook = new HSSFWorkbook(inputStream);
	// hssfWorkbook.setSheetName(0, poiParams.getExportSheetName());
	// sheet = hssfWorkbook.getSheetAt(0);
	// sheet.protectSheet(IDUtils.genId());//加密只读
	// } catch (IOException e) {
	// throw new RuntimeException("Excel内存文件创建失败");
	// } finally {
	// inputStream.close();
	// }
	// }
}
