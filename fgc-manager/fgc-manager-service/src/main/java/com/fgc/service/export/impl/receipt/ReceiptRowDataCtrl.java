package com.fgc.service.export.impl.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.export.bean.CellExcelBeanVO;
import com.pub.export.bean.RowExcelBeanVO;
import com.pub.export.ctrl.CellValueCtrlUtils;
import com.pub.export.itf.IRowDataCtrl;
import com.pub.utils.AggVO;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月22日
 *
 *     未来离线需求
 */
public class ReceiptRowDataCtrl implements IRowDataCtrl {

	private AggVO<OrderHVO, OrderBVO> aggVO;

	/**
	 * 表头行
	 */
	private int[] rowIndex = new int[] { 10, 11, 12, 13, 35, 36, 38, 40, 42 };
	/**
	 * 表体开始行
	 */
	private int bodyBegin = 16;

	/**
	 * 
	 * @param aggVO
	 * @param billtype
	 */

	public ReceiptRowDataCtrl(AggVO<OrderHVO, OrderBVO> aggVO) {
		this.aggVO = aggVO;
	}

	@Override
	public void loadSheetData(HSSFWorkbook hssfWorkbook, HSSFSheet sheet) {
		CellValueCtrlUtils utils = new CellValueCtrlUtils(hssfWorkbook);
		CellValueCtrlUtils utilsBody = new CellValueCtrlUtils(hssfWorkbook);

		List<RowExcelBeanVO> headRowDatas = this.getHeadRowDatas();
		List<RowExcelBeanVO> bodyRowDatas = this.getBodyRowDatas();

		for (int i = 0; i < rowIndex.length; i++) {
			HSSFRow dataRow = sheet.getRow(rowIndex[i]);
			RowExcelBeanVO rowExcelBeanVO = headRowDatas.get(i);
			List<CellExcelBeanVO> allRowBeanVOs = rowExcelBeanVO.getAllRowBeanVOs();
			for (CellExcelBeanVO cellExcelBeanVO : allRowBeanVOs) {
				utils.setExcelCellValue(dataRow, cellExcelBeanVO);
			}
		}

		for (int i = 0; i < bodyRowDatas.size(); i++) {
			HSSFRow dataRow = sheet.getRow(i + bodyBegin);
			RowExcelBeanVO rowExcelBeanVO = bodyRowDatas.get(i);
			List<CellExcelBeanVO> allRowBeanVOs = rowExcelBeanVO.getAllRowBeanVOs();
			for (CellExcelBeanVO cellExcelBeanVO : allRowBeanVOs) {
				utilsBody.setExcelCellValue(dataRow, cellExcelBeanVO);
			}
		}
	}

	private List<RowExcelBeanVO> getBodyRowDatas() {
		List<RowExcelBeanVO> listRowDatas = new ArrayList<>();
		if (MMValueUtils.isNotEmpty(aggVO)) {
			OrderBVO[] bodyVOs = aggVO.getBodyVOs();
			RowExcelBeanVO rowExcelBeanVO = null;
			CellExcelBeanVO cellExcelBeanVO = null;
			for (OrderBVO bodyVO : bodyVOs) {
				rowExcelBeanVO = new RowExcelBeanVO();

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(0);
				cellExcelBeanVO.setCellValue(bodyVO.getMaterialname());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(3);
				cellExcelBeanVO.setCellValue(bodyVO.getVbdef1());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(5);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_NUMERIC);
				cellExcelBeanVO.setCellValue(bodyVO.getSalenum() == null ? BigDecimal.ZERO.doubleValue()
						: bodyVO.getSalenum().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(6);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(bodyVO.getNsaleprice() == null ? BigDecimal.ZERO.doubleValue()
						: bodyVO.getNsaleprice().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(7);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(
						bodyVO.getNmny() == null ? BigDecimal.ZERO.doubleValue() : bodyVO.getNmny().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				listRowDatas.add(rowExcelBeanVO);
			}
		}
		return listRowDatas;
	}

	private List<RowExcelBeanVO> getHeadRowDatas() {
		List<RowExcelBeanVO> listRowDatas = new ArrayList<>();
		if (MMValueUtils.isNotEmpty(aggVO)) {
			OrderHVO headVO = aggVO.getHeadVO();

			RowExcelBeanVO rowExcelBeanVO = new RowExcelBeanVO();
			
			CellExcelBeanVO cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(3);
			cellExcelBeanVO.setCellValue(MMNCUtils.getNowDate());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			 cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(6);
			cellExcelBeanVO.setCellValue(headVO.getEffectbillcode());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getClient());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getAddress());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getTel());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);
			// excel下面的表头数据
			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO
					.setCellValue(
							MMNumberUtil
									.subtract(headVO.getNorigtaxmny(),
											new BigDecimal(
													headVO.getVdef2() == null ? "0" : headVO.getVdef2())) == null
															? BigDecimal.ZERO.doubleValue()
															: MMNumberUtil
																	.subtract(headVO.getNorigtaxmny(),
																			new BigDecimal(headVO.getVdef2() == null
																					? "0" : headVO.getVdef2()))
																	.doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO
					.setCellValue(new BigDecimal(headVO.getVdef2() == null ? "0" : headVO.getVdef2()).doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getNorigtaxmny() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getNorigtaxmny().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getThisReceiptMny() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getThisReceiptMny().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getRetainage() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getRetainage().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);
		}
		return listRowDatas;
	}

}
