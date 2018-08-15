package com.fgc.service.export.impl.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.fgc.pojo.MoneyDetailVO;
import com.pub.export.bean.CellExcelBeanVO;
import com.pub.export.bean.RowExcelBeanVO;
import com.pub.export.ctrl.CellValueCtrlUtils;
import com.pub.export.itf.IRowDataCtrl;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public class ReportRowDataCtrl implements IRowDataCtrl {

	private List<MoneyDetailVO> listVOs;

	/**
	 * 表体开始行
	 */
	private int bodyBegin = 1;

	/**
	 * @param listMoneyDetailVO
	 */
	public ReportRowDataCtrl(List<MoneyDetailVO> listMoneyDetailVO) {
		this.listVOs = listMoneyDetailVO;
	}

	@Override
	public void loadSheetData(HSSFWorkbook hssfWorkbook, HSSFSheet sheet) {
		CellValueCtrlUtils utilsBody = new CellValueCtrlUtils(hssfWorkbook, true, true);

		List<RowExcelBeanVO> rowDatas = this.getRowDatas();

		for (int i = 0; i < rowDatas.size(); i++) {
			HSSFRow dataRow = sheet.getRow(i + bodyBegin);
			if (MMValueUtils.isEmpty(dataRow)) {
				dataRow = sheet.createRow(i + bodyBegin);
			}
			RowExcelBeanVO rowExcelBeanVO = rowDatas.get(i);
			List<CellExcelBeanVO> allRowBeanVOs = rowExcelBeanVO.getAllRowBeanVOs();
			for (CellExcelBeanVO cellExcelBeanVO : allRowBeanVOs) {
				utilsBody.setExcelCellValue(dataRow, cellExcelBeanVO);
			}
		}
	}

	/**
	 * 
	 */
	private List<RowExcelBeanVO> getRowDatas() {
		List<RowExcelBeanVO> listRowDatas = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listVOs)) {
			RowExcelBeanVO rowExcelBeanVO = null;
			CellExcelBeanVO cellExcelBeanVO = null;
			for (MoneyDetailVO moneyDetailVO : listVOs) {
				rowExcelBeanVO = new RowExcelBeanVO();

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(0);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getDbilldate());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(1);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getDdh());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(2);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getBah());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(3);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getFpzje() == null ? BigDecimal.ZERO.doubleValue()
						: moneyDetailVO.getFpzje().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(4);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getSkje() == null ? BigDecimal.ZERO.doubleValue()
						: moneyDetailVO.getSkje().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(5);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getWk() == null ? BigDecimal.ZERO.doubleValue()
						: moneyDetailVO.getWk().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
				
				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(6);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getRnreceivedmny() == null ? BigDecimal.ZERO.doubleValue()
						: moneyDetailVO.getRnreceivedmny().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(7);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getFph());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(8);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getBillmaker());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
				
				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(9);
				cellExcelBeanVO.setCellValue(moneyDetailVO.getSohbillmaker());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				listRowDatas.add(rowExcelBeanVO);
			}
		}
		return listRowDatas;
	}
}
