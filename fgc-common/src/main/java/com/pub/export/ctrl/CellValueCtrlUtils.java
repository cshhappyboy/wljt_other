package com.pub.export.ctrl;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import com.pub.export.itf.IExcelBeanVO;

public class CellValueCtrlUtils {

	private HSSFWorkbook hssfWorkbook;

	private HSSFFont font;

	public CellValueCtrlUtils(HSSFWorkbook hssfWorkbook) {
		this.hssfWorkbook = hssfWorkbook;
		if (null != this.hssfWorkbook) {
			font = this.hssfWorkbook.createFont();
			font.setFontHeightInPoints((short) 11);
			font.setFontName("Times New Roman");
		}

	}

	public CellValueCtrlUtils(HSSFWorkbook hssfWorkbook, boolean flag) {
		this(hssfWorkbook);
		this.setCellStyle();
	}

	/**
	 * @param hssfWorkbook2
	 * @param b
	 * @param c
	 */
	public CellValueCtrlUtils(HSSFWorkbook hssfWorkbook, boolean b, boolean c) {
		this(hssfWorkbook);
		this.setCellStyleFlag();
	}

	public void setExcelCellValue(HSSFRow row, IExcelBeanVO beanVO) {
		HSSFCell cell = row.createCell(beanVO.getCellIndex());

		switch (beanVO.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			this.setCellValue(cell, (String) beanVO.getCellValue());
			break;
		// Integer
		case Cell.CELL_TYPE_NUMERIC:
			this.setNumberCellValue(cell, (Double) beanVO.getCellValue());
			break;
		// Double
		case Cell.CELL_TYPE_FORMULA:
			this.setCellValue(cell, (Double) beanVO.getCellValue());
			break;
		// Date
		case Cell.CELL_TYPE_BLANK:
			this.setCellValue(cell, (Date) beanVO.getCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			break;
		case Cell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}

	}

	private void setCellValue(HSSFCell aCell, Date value) {
		aCell.setCellValue(value);
		HSSFCellStyle borderStyle = this.hssfWorkbook.createCellStyle();
		HSSFDataFormat dataFormat = this.hssfWorkbook.createDataFormat();
		borderStyle.setDataFormat(dataFormat.getFormat("yyyy/m/d"));
		borderStyle.setFont(font);
		aCell.setCellStyle(borderStyle);
	}

	/**
	 * 设置单元格的值
	 * 
	 * @param row
	 * @param cellIndex
	 * @param value
	 */
	private void setCellValue(HSSFCell aCell, Double value) {
		aCell.setCellType(Cell.CELL_TYPE_NUMERIC);
		aCell.setCellValue(value);
		HSSFCellStyle borderStyle = this.hssfWorkbook.createCellStyle();
		HSSFDataFormat dataFormat = this.hssfWorkbook.createDataFormat();
		borderStyle.setDataFormat(dataFormat.getFormat("#,##0"));
		borderStyle.setFont(font);
		aCell.setCellStyle(borderStyle);
	}

	/**
	 * 设置单元格的值
	 * 
	 * @param row
	 * @param cellIndex
	 * @param value
	 */
	private void setNumberCellValue(HSSFCell aCell, Double value) {
		aCell.setCellType(Cell.CELL_TYPE_NUMERIC);
		aCell.setCellValue(value);
		HSSFCellStyle borderStyle = this.hssfWorkbook.createCellStyle();
		borderStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		borderStyle.setFont(font);
		aCell.setCellStyle(borderStyle);
	}

	/**
	 * 设置单元格的值
	 * 
	 * @param row
	 * @param cellIndex
	 * @param value
	 */
	private void setCellValue(HSSFCell aCell, String value) {
		aCell.setCellType(Cell.CELL_TYPE_STRING);
		aCell.setCellValue(value);
		HSSFCellStyle borderStyle = this.hssfWorkbook.createCellStyle();
		borderStyle = this.hssfWorkbook.createCellStyle();
		borderStyle.setDataFormat(borderStyle.getDataFormat());
		borderStyle.setFont(font);
		aCell.setCellStyle(borderStyle);
	}

	/**
	 * 添加边框
	 * 
	 * @param borderStyle
	 */
	private void setCellStyle() {
		HSSFCellStyle borderStyle = this.hssfWorkbook.createCellStyle();
		borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
		borderStyle.setBorderRight(CellStyle.BORDER_THIN);
	}

	private void setCellStyleFlag() {
		HSSFCellStyle borderStyle = this.hssfWorkbook.createCellStyle();
		borderStyle.setBorderTop(CellStyle.BORDER_THIN);
		borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
		borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
		borderStyle.setBorderRight(CellStyle.BORDER_THIN);
	}

}
