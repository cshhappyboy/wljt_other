package com.pub.utils;

import java.util.List;

public class EUDataGridResult {
	/**
	 * easyUI 不开启分页功能,开始页为第一页
	 */
	public static int E_U_STARTPAGE = 1;
	/**
	 * easyUI 不开启分页功能,第一页查询默认1000条
	 */
	public static int E_U_PAGESIZE = 1000;

	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}