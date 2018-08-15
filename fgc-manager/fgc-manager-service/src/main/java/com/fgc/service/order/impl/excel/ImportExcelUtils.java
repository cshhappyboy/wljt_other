package com.fgc.service.order.impl.excel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.util.OrderImportVO;
import com.fgc.service.order.IOrderService;
import com.fgc.service.order.impl.excel.change.ImportVOChange2OrderVO;
import com.pub.model.SessionInfo;
import com.pub.utils.JsonBill;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月22日
 *
 *     未来离线需求
 */
@Component
public class ImportExcelUtils {

	@Autowired
	private ImportVOChange2OrderVO change2OrderVO;

	@Autowired
	private IOrderService orderService;
	/**
	 * 数据开始行
	 */
	private int beginRow = 2;
	/**
	 * 结束列
	 */
	private int endCell = 15;
	/**
	 * 时间类型列
	 */
	private int datetype = 2;
	/**
	 * 数字类型列
	 */
	private Integer[] numbertype = new Integer[] { 11, 12, 13 };

	public WebAppResult importExcel(XSSFSheet sheet, SessionInfo sessionInfo) throws Exception {
		int lastRowNum = sheet.getLastRowNum();

		List<OrderImportVO> listVOs = new ArrayList<>();
		for (int i = beginRow; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			listVOs.add(builderImportVO(row));
		}
		List<JsonBill> listJsonBills = change2OrderVO.change2OrderVO(listVOs,sessionInfo.getNowDate());
		for (JsonBill jsonBill : listJsonBills) {
			orderService.saveOrder(jsonBill, sessionInfo);
		}
		return WebAppResult.ok();
	}

	/**
	 * @param cell
	 * @return
	 */
	private OrderImportVO builderImportVO(XSSFRow row) {
		OrderImportVO vo = new OrderImportVO();
		for (int j = 0; j <= endCell; j++) {
			if (j == datetype) {
				XSSFCell cell = row.getCell(j);
				Date dbilldate = cell.getDateCellValue();
				if(MMValueUtils.isEmpty(dbilldate)){
					throw new RuntimeException("请把excel下部空表删除！");
				}
				String date = MMNCUtils.getNowDate(dbilldate);
				vo.setDbilldate(date);
			} else if (MMArrayUtil.toList(Integer.class, numbertype).contains(j)) {
				XSSFCell cell = row.getCell(j);
				if (j == 11) {
					// 数量
					double numericCellValue = cell.getNumericCellValue();
					vo.setSalenum(new BigDecimal(numericCellValue));
				} else if (j == 12) {
					// 单价
//					double numericCellValue = cell.getNumericCellValue();
//					vo.setNsaleprice(new BigDecimal(numericCellValue));
				} else if (j == 13) {
					// 金额
					double numericCellValue = cell.getNumericCellValue();
					vo.setNmny(new BigDecimal(numericCellValue));
				}
			} else {
				XSSFCell cell = row.getCell(j);
				if (MMValueUtils.isNotEmpty(cell)) {
					String stringCellValue = cell.getStringCellValue();
					if (MMStringUtil.isNotEmpty(stringCellValue)) {
						if (j == 0) {
							vo.setVbillcode(stringCellValue);
						}
						if (j == 1) {
							vo.setVbilltype(stringCellValue);
						}
						if (j == 3) {
							vo.setCustomer(stringCellValue);
						}
						if (j == 4) {
							vo.setSalesman(stringCellValue);
						}
						if (j == 5) {
							vo.setCurrency(stringCellValue);
						}
						if (j == 6) {
							vo.setMemo(stringCellValue);
						}
						if (j == 7) {
							vo.setClient(stringCellValue);
						}
						if (j == 8) {
							vo.setAddress(stringCellValue);
						}
						if (j == 9) {
							vo.setTel(stringCellValue);
						}
						if (j == 10) {
							vo.setCmaterial(stringCellValue);
						}
						if (j == 14) {
							vo.setEffectbillcode(stringCellValue);
						}
						if (j == 15) {
							vo.setDelwarehouse(stringCellValue);
						}
					}
				}
			}
		}
		return vo;
	}

}
