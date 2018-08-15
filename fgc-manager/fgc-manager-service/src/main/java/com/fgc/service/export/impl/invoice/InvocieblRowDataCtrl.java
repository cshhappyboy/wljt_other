package com.fgc.service.export.impl.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.pub.export.bean.CellExcelBeanVO;
import com.pub.export.bean.RowExcelBeanVO;
import com.pub.export.ctrl.CellValueCtrlUtils;
import com.pub.export.itf.IRowDataCtrl;
import com.pub.utils.AggVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
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
public class InvocieblRowDataCtrl implements IRowDataCtrl {

	private AggVO<InvoiceHVO, InvoiceBVO> aggVO;

	/**
	 * 表头行
	 */
	private int[] rowIndex = new int[] { 3, 4, 5 };
	/**
	 * 表体开始行
	 */
	private int bodyBegin = 7;

	/**
	 * @param aggVO
	 */
	public InvocieblRowDataCtrl(AggVO<InvoiceHVO, InvoiceBVO> aggVO) {
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
			if (MMValueUtils.isEmpty(dataRow)) {
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
			InvoiceHVO headVO = aggVO.getHeadVO();

			RowExcelBeanVO rowExcelBeanVO = new RowExcelBeanVO();
			CellExcelBeanVO cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			cellExcelBeanVO.setCellValue(headVO.getBillmaketime());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getBillmaker());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(2);
			cellExcelBeanVO.setCellValue(headVO.getVbillcode().substring(headVO.getVbillcode().length() - 8,
					headVO.getVbillcode().length()));
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellValue(headVO.getSalesman());
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
			InvoiceBVO[] bodyVOs = aggVO.getBodyVOs();
			// 将相同的物料归集起来
			Map<String, List<InvoiceBVO>> mapListData = new HashMap<>();
			List<String> listId = new ArrayList<>();
			for (InvoiceBVO invoiceBVO : bodyVOs) {
				String cmaterial = invoiceBVO.getCmaterial();
				List<InvoiceBVO> listBVOs = mapListData.get(cmaterial);
				if (MMCollectionUtil.isNotEmpty(listBVOs)) {
					listBVOs.add(invoiceBVO);
				} else {
					List<InvoiceBVO> listData = new ArrayList<>();
					listData.add(invoiceBVO);
					listId.add(cmaterial);
					mapListData.put(cmaterial, listData);
				}
			}
			for (String key : listId) {
				List<InvoiceBVO> listBVOs = mapListData.get(key);

				RowExcelBeanVO rowExcelBeanVO = null;
				CellExcelBeanVO cellExcelBeanVO = null;

				for (int i = 0; i < listBVOs.size(); i++) {
					rowExcelBeanVO = new RowExcelBeanVO();
					cellExcelBeanVO = new CellExcelBeanVO();
					cellExcelBeanVO.setCellIndex(0);
					cellExcelBeanVO.setCellType(Cell.CELL_TYPE_NUMERIC);
					cellExcelBeanVO.setCellValue(listBVOs.get(i).getSalenum() == null ? BigDecimal.ZERO.doubleValue()
							: listBVOs.get(i).getSalenum().doubleValue());
					rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

					cellExcelBeanVO = new CellExcelBeanVO();
					cellExcelBeanVO.setCellIndex(1);
					cellExcelBeanVO.setCellValue(listBVOs.get(i).getMaterialname());
					rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

					cellExcelBeanVO = new CellExcelBeanVO();
					cellExcelBeanVO.setCellIndex(2);
					cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
					cellExcelBeanVO.setCellValue(listBVOs.get(i).getNmny() == null ? BigDecimal.ZERO.doubleValue()
							: listBVOs.get(i).getNmny().doubleValue());
					rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

					listRowDatas.add(rowExcelBeanVO);
				}
			}

			InvoiceHVO headVO = aggVO.getHeadVO();
			RowExcelBeanVO rowExcelBeanVO = new RowExcelBeanVO();

			CellExcelBeanVO cellExcelBeanVO = new CellExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			cellExcelBeanVO.setCellValue("          Total: ");
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO
					.setCellValue(
							MMNumberUtil
									.subtract(headVO.getNtotalmny(),
											new BigDecimal(headVO.getVdef2() == null ? "0" : headVO.getVdef2()))
									.doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			cellExcelBeanVO.setCellValue("          Remise:");
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(MMNumberUtil
					.subtract(BigDecimal.ZERO, new BigDecimal(headVO.getVdef2() == null ? "0" : headVO.getVdef2()))
					.doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			cellExcelBeanVO.setCellValue("          Total: ");
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getNtotalmny() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getNtotalmny().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			if (MMStringUtil.isNotEmpty(headVO.getCashaccount())) {
				cellExcelBeanVO.setCellValue("          Cash:");
			} else {
				cellExcelBeanVO.setCellValue("        CHEQUE:");
			}
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(1);
			cellExcelBeanVO.setCellType(Cell.CELL_TYPE_FORMULA);
			cellExcelBeanVO.setCellValue(headVO.getNtotalmny() == null ? BigDecimal.ZERO.doubleValue()
					: headVO.getNtotalmny().doubleValue());
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();

			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			cellExcelBeanVO.setCellValue("NOUS VOUS REMERCIONS DE");
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);

			rowExcelBeanVO = new RowExcelBeanVO();
			cellExcelBeanVO = new CellExcelBeanVO();
			cellExcelBeanVO.setCellIndex(0);
			cellExcelBeanVO.setCellValue("VOTRE VISITE A BIENTÔT!");
			rowExcelBeanVO.addCellBeanVO(cellExcelBeanVO);

			listRowDatas.add(rowExcelBeanVO);
		}
		return listRowDatas;
	}

}
