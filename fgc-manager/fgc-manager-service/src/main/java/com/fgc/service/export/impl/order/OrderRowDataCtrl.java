package com.fgc.service.export.impl.order;

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
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public class OrderRowDataCtrl implements IRowDataCtrl {

	private AggVO<OrderHVO, OrderBVO> aggVO;

	/**
	 * 表头行
	 */
	private int[] rowIndex = new int[] { 6, 7, 8, 9 };
	/**
	 * 表体开始行
	 */
	private int bodyBegin = 11;

	/**
	 * @param aggVO
	 */
	public OrderRowDataCtrl(AggVO<OrderHVO, OrderBVO> aggVO) {
		this.aggVO = aggVO;
	}

	@Override
	public void loadSheetData(HSSFWorkbook hssfWorkbook, HSSFSheet sheet) {
		CellValueCtrlUtils utils = new CellValueCtrlUtils(hssfWorkbook);
		CellValueCtrlUtils utilsBody = new CellValueCtrlUtils(hssfWorkbook, true, true);

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
			if(MMValueUtils.isEmpty(dataRow)){
				dataRow = sheet.createRow(i + bodyBegin);
			}
			RowExcelBeanVO rowExcelBeanVO = bodyRowDatas.get(i);
			List<CellExcelBeanVO> allRowBeanVOs = rowExcelBeanVO.getAllRowBeanVOs();
			for (CellExcelBeanVO cellExcelBeanVO : allRowBeanVOs) {
				utilsBody.setExcelCellValue(dataRow, cellExcelBeanVO);
			}
		}

	}

	/**
	 * 构造行数据,行数据是由每个cell组成，所有行里面全是CellExcelBeanVO
	 * 
	 * @return List<RowExcelBeanVO>
	 */
	public List<RowExcelBeanVO> getHeadRowDatas() {
		List<RowExcelBeanVO> listRowDatas = new ArrayList<>();
		if (MMValueUtils.isNotEmpty(aggVO)) {
			OrderHVO headVO = aggVO.getHeadVO();

			RowExcelBeanVO rowExcelBeanVO = new RowExcelBeanVO();

			CellExcelBeanVO cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(2);
			cellExcelBeanVO.setCellValue(headVO.getVbillcode());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(4);
			cellExcelBeanVO.setCellValue(headVO.getDbilldate());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellValue(headVO.getCbilltype());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(2);
			cellExcelBeanVO.setCellValue(headVO.getCustomer());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(4);
			cellExcelBeanVO.setCellValue(headVO.getSalesman());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellValue(headVO.getTel());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(2);
			cellExcelBeanVO.setCellValue(headVO.getClient());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(4);
			cellExcelBeanVO.setCellValue(headVO.getAddress());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getNorigtaxmny() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getNorigtaxmny().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(2);
			cellExcelBeanVO.setCellValue(headVO.getEffectbillcode());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(4);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_NUMERIC);
			cellExcelBeanVO.setCellValue(headVO.getNtotalnum() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getNtotalnum().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getNorigtaxmny() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getNorigtaxmny().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

		}
		return listRowDatas;
	}

	/**
	 * 构造行数据,行数据是由每个cell组成，所有行里面全是CellExcelBeanVO
	 * 
	 * @return List<RowExcelBeanVO>
	 */
	public List<RowExcelBeanVO> getBodyRowDatas() {
		List<RowExcelBeanVO> listRowDatas = new ArrayList<>();
		if (MMValueUtils.isNotEmpty(aggVO)) {
			OrderBVO[] bodyVOs = aggVO.getBodyVOs();
			RowExcelBeanVO rowExcelBeanVO = null;
			CellExcelBeanVO cellExcelBeanVO = null;
			int i = 0;
			for (OrderBVO bodyVO : bodyVOs) {
				i++;

				rowExcelBeanVO = new RowExcelBeanVO();

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(0);
				cellExcelBeanVO.setCellValue(i + "");
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(1);
				cellExcelBeanVO.setCellValue(bodyVO.getMaterialcode());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(2);
				cellExcelBeanVO.setCellValue(bodyVO.getMaterialname());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(3);
				cellExcelBeanVO.setCellValue(bodyVO.getCsaleunitid());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(4);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_NUMERIC);
				cellExcelBeanVO.setCellValue(bodyVO.getSalenum() == null ? BigDecimal.ZERO.doubleValue()
						: bodyVO.getSalenum().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(5);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(
						bodyVO.getNsaleprice() == null ? BigDecimal.ZERO.doubleValue() : bodyVO.getNsaleprice().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(6);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
				cellExcelBeanVO.setCellValue(
						bodyVO.getNmny() == null ? BigDecimal.ZERO.doubleValue() : bodyVO.getNmny().doubleValue());
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

}
