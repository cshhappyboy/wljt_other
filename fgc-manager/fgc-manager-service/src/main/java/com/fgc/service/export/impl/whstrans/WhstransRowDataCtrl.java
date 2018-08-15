package com.fgc.service.export.impl.whstrans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
import com.pub.export.bean.CellExcelBeanVO;
import com.pub.export.bean.RowExcelBeanVO;
import com.pub.export.ctrl.CellValueCtrlUtils;
import com.pub.export.itf.IRowDataCtrl;
import com.pub.utils.AggVO;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月20日
 *
 *     未来离线需求
 */
public class WhstransRowDataCtrl implements IRowDataCtrl {

	private AggVO<WhstransHVO, WhstransBVO> aggVO;

	/**
	 * 表头行
	 */
	private int[] rowIndex = new int[] { 1, 3, 11, 12 };
	/**
	 * 表体开始行
	 */
	private int bodyBegin = 5;

	/**
	 * @param aggVO
	 */
	public WhstransRowDataCtrl(AggVO<WhstransHVO, WhstransBVO> aggVO) {
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

	/**
	 * 构造行数据,行数据是由每个cell组成，所有行里面全是CellExcelBeanVO
	 * 
	 * @return List<RowExcelBeanVO>
	 */
	public List<RowExcelBeanVO> getHeadRowDatas() {
		List<RowExcelBeanVO> listRowDatas = new ArrayList<>();
		if (MMValueUtils.isNotEmpty(aggVO)) {
			WhstransHVO headVO = aggVO.getHeadVO();

			RowExcelBeanVO rowExcelBeanVO = new RowExcelBeanVO();

			CellExcelBeanVO cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(3);
			cellExcelBeanVO.setCellValue(headVO.getDbilldate());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(7);
			cellExcelBeanVO.setCellValue(headVO.getVbillcode());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getCoutwarehouseid());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(5);
			cellExcelBeanVO.setCellValue(headVO.getCotherwhid());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getMemo());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getBillmaker());
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
			WhstransBVO[] bodyVOs = aggVO.getBodyVOs();
			RowExcelBeanVO rowExcelBeanVO = null;
			CellExcelBeanVO cellExcelBeanVO = null;
			for (WhstransBVO bodyVO : bodyVOs) {

				rowExcelBeanVO = new RowExcelBeanVO();

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(0);
				cellExcelBeanVO.setCellValue(bodyVO.getMaterialcode());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(1);
				cellExcelBeanVO.setCellValue(bodyVO.getMaterialname());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(3);
				cellExcelBeanVO.setCellValue(bodyVO.getVbdef1());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(4);
				cellExcelBeanVO.setCellValue(bodyVO.getMaterialspec());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

//				cellExcelBeanVO = new CellExcelBeanVO();
//				cellExcelBeanVO.setCellIndex(4);
//				cellExcelBeanVO.setCellValue(bodyVO.getMaterialtype());
//				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(6);
				cellExcelBeanVO.setCellValue(bodyVO.getCunitid());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				cellExcelBeanVO = new CellExcelBeanVO();
				cellExcelBeanVO.setCellIndex(7);
				cellExcelBeanVO.setCellType(Cell.CELL_TYPE_NUMERIC);
				cellExcelBeanVO.setCellValue(bodyVO.getNtrsnnum() == null ? BigDecimal.ZERO.doubleValue()
						: bodyVO.getNtrsnnum().doubleValue());
				rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

				String vbatchcode = bodyVO.getVbatchcode();
				if (MMStringUtil.isNotEmpty(vbatchcode)) {
					cellExcelBeanVO = new CellExcelBeanVO();
					cellExcelBeanVO.setCellIndex(8);
					cellExcelBeanVO.setCellValue(bodyVO.getVbatchcode().substring(bodyVO.getVbatchcode().length() - 6,
							bodyVO.getVbatchcode().length()));
					rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);
				}
				listRowDatas.add(rowExcelBeanVO);
			}
		}
		return listRowDatas;
	}

}
