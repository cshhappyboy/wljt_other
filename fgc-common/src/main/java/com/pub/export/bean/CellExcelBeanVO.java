package com.pub.export.bean;

import org.apache.poi.hssf.usermodel.HSSFCell;

import com.pub.export.itf.IExcelBeanVO;

/**
 * 
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public class CellExcelBeanVO implements IExcelBeanVO {

	private int cellIndex;

	private int cellType = HSSFCell.CELL_TYPE_STRING;

	private Object obj;

	@Override
	public int getCellIndex() {
		return this.cellIndex;
	}

	@Override
	public int getCellType() {
		return this.cellType;
	}

	@Override
	public Object getCellValue() {
		return this.obj;
	}

	@Override
	public void setCellIndex(int index) {
		this.cellIndex = index;
	}

	@Override
	public void setCellType(int type) {
		this.cellType = type;
	}

	@Override
	public void setCellValue(Object value) {
		this.obj = value;
	}
}
