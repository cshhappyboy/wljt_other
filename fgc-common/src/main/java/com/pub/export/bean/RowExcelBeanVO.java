package com.pub.export.bean;

import java.util.ArrayList;
import java.util.List;

public class RowExcelBeanVO {

	private List<CellExcelBeanVO> listBeanVOs;

	public RowExcelBeanVO() {
		this.listBeanVOs = new ArrayList<CellExcelBeanVO>();
	}

	public void addCellBeanVO(CellExcelBeanVO beanVO) {
		this.listBeanVOs.add(beanVO);
	}

	public CellExcelBeanVO getCellBeanVOs(int i) {
		return this.listBeanVOs.get(i);
	}

	public List<CellExcelBeanVO> getAllRowBeanVOs() {
		return listBeanVOs;
	}
	public int size() {
		return this.listBeanVOs.size();
	}
}
