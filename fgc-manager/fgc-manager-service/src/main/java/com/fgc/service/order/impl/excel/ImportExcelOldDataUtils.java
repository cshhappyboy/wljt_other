package com.fgc.service.order.impl.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.util.OrderImportOldVO;
import com.fgc.service.order.IOrderService;
import com.fgc.service.order.impl.excel.change.ImportVOChange2OrderOldVO;
import com.pub.utils.JsonBill;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 期初数据导入
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月22日
 *
 *     未来离线需求
 */
@Component
public class ImportExcelOldDataUtils {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private ImportVOChange2OrderOldVO importVOChange2OrderOldVO;

	/**
	 * 数据开始行
	 */
	private int beginRow = 2;
	/**
	 * 结束列
	 */
	private int endCell = 25;

	public WebAppResult importOldExcel(XSSFSheet sheet) throws Exception {
		int lastRowNum = sheet.getLastRowNum();

		List<OrderImportOldVO> listVOs = new ArrayList<>();
		for (int i = beginRow; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			listVOs.add(builderImportVO(row, i));
		}
		List<JsonBill> listJsonBills = importVOChange2OrderOldVO.change2OrderVO(listVOs);
		for (JsonBill jsonBill : listJsonBills) {
			orderService.saveOldOrder(jsonBill);
		}
		return WebAppResult.ok();
	}

	/**
	 * @param cell
	 * @return
	 */
	private OrderImportOldVO builderImportVO(XSSFRow row, int x) {
		OrderImportOldVO vo = new OrderImportOldVO();
		for (int i = 0; i <= endCell; i++) {
			XSSFCell cell = row.getCell(i);
			if (MMValueUtils.isNotEmpty(cell)) {
				String stringCellValue = cell.getStringCellValue();
				if (i == 0) {
					vo.setHid(stringCellValue);
				} else if (i == 1) {
					vo.setBid(stringCellValue);
				} else if (i == 2) {
					vo.setVbillcode(stringCellValue);
				} else if (i == 3) {
					vo.setVbilltype(stringCellValue);
				} else if (i == 4) {
					vo.setDbilldate(stringCellValue);
				} else if (i == 5) {
					vo.setCustomer(stringCellValue);
				} else if (i == 6) {
					vo.setSalesman(stringCellValue);
				} else if (i == 7) {
					vo.setCdept(stringCellValue);
				} else if (i == 8) {
					vo.setCurrency(stringCellValue);
				} else if (i == 9) {
					vo.setHuilv(stringCellValue);
				} else if (i == 10) {
					vo.setShijishoukuanjine(stringCellValue);
				} else if (i == 11) {
					vo.setClient(stringCellValue);
				} else if (i == 12) {
					vo.setAddress(stringCellValue);
				} else if (i == 13) {
					vo.setTel(stringCellValue);
				} else if (i == 14) {
					vo.setCmaterial(stringCellValue);
				} else if (i == 15) {
					vo.setNastnum(stringCellValue);
				} else if (i == 16) {
					vo.setNprice(stringCellValue);
				} else if (i == 17) {
					vo.setNnum(stringCellValue);
				} else if (i == 18) {
					vo.setNmny(stringCellValue);
				} else if (i == 19) {
					vo.setEffectbillcode(stringCellValue);
				} else if (i == 20) {
					vo.setDelwarehouse(stringCellValue);
				} else if (i == 21) {
					vo.setZhidanren(stringCellValue);
				} else if (i == 22) {
					vo.setZhidantime(stringCellValue);
				} else if (i == 23) {
					vo.setShenheren(stringCellValue);
				} else if (i == 24) {
					vo.setShenhetime(stringCellValue);
				} else if (i == 25) {
					vo.setLeijikaipiaonum(stringCellValue);
				}
			}
		}
		return vo;
	}
}
