package com.pub.export.itf;

/**
 * 
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public interface IExcelBeanVO {

	public int getCellIndex();

	public int getCellType();

	public Object getCellValue();

	public void setCellIndex(int index);

	public void setCellType(int type);

	public void setCellValue(Object value);

}
