package com.fgc.service.export.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.ReceiptHVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.MoneyDetailVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.export.IExportExcelService;
import com.fgc.service.export.impl.invoice.InvocieRowDataCtrl;
import com.fgc.service.export.impl.invoice.InvocieblRowDataCtrl;
import com.fgc.service.export.impl.invoice.InvoicePOIParams;
import com.fgc.service.export.impl.invoice.InvoiceblPOIParams;
import com.fgc.service.export.impl.order.OrderPOIParams;
import com.fgc.service.export.impl.order.OrderRowDataCtrl;
import com.fgc.service.export.impl.receipt.ReceiptPOIParams;
import com.fgc.service.export.impl.receipt.ReceiptRowDataCtrl;
import com.fgc.service.export.impl.report.ReportPOIParams;
import com.fgc.service.export.impl.report.ReportRowDataCtrl;
import com.fgc.service.export.impl.whstrans.WhstransPOIParams;
import com.fgc.service.export.impl.whstrans.WhstransRowDataCtrl;
import com.fgc.service.invoice.InvoiceService;
import com.fgc.service.invoice.impl.util.InvoiceChangeUtils;
import com.fgc.service.order.IOrderService;
import com.fgc.service.order.impl.util.OrderChangeUtils;
import com.fgc.service.report.IReceiptPortService;
import com.fgc.service.whstrans.IWhstranService;
import com.fgc.service.whstrans.impl.utils.WhstransChangeUtils;
import com.pub.export.ctrl.HSSFPOIUtils;
import com.pub.model.SessionInfo;
import com.pub.utils.AggVO;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.IDUtils;
import com.pub.utils.MMArrayUtil;
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
@Service
public class ExportExcelServiceImpl implements IExportExcelService {

	@Autowired
	private ReportPOIParams reportPOIParams;

	@Autowired
	private IReceiptPortService receiptPortService;

	@Autowired
	private WhstransPOIParams whstransPOIParams;

	@Autowired
	private WhstransChangeUtils whstransChangeUtils;

	@Autowired
	private IWhstranService whstranService;

	@Autowired
	private InvoiceChangeUtils invoiceChangeUtils;

	@Autowired
	private OrderChangeUtils orderChangeUtils;

	@Autowired
	private IOrderService orderService;

	@Autowired
	private ReceiptHVOMapper receiptHVOMapper;

	@Autowired
	private OrderPOIParams orderPOIParams;

	@Autowired
	private ReceiptPOIParams receiptPOIParams;
	
	@Autowired
	private InvoiceblPOIParams invoiceblPOIParams;

	@Autowired
	private InvoicePOIParams invoicePOIParams;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;
	
	@Override
	public void exportInvoiceBlExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			InvoiceHVO invoiceHVO = invoiceService.queryInvoiceHVOById(id);
			trans2NameUtils.transHVO(InvoiceHVO.class, MMArrayUtil.toList(InvoiceHVO.class, invoiceHVO), local);

			EUDataGridResult euDataGridResult = invoiceService.queryInvoiceBVOsById(id);
			List<InvoiceBVO> rows = (List<InvoiceBVO>) euDataGridResult.getRows();
			trans2NameUtils.transBVO(InvoiceBVO.class, rows, local);

			List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs = invoiceChangeUtils
					.aggVOs(MMArrayUtil.toList(InvoiceHVO.class, invoiceHVO), rows);
			this.exportInvoicebl(response, aggVOs);
		}
	}
	private void exportInvoicebl(HttpServletResponse response, List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs)
			throws IOException {
		HSSFPOIUtils utils = new HSSFPOIUtils(invoiceblPOIParams);
		HSSFWorkbook workbook = utils.createWorkBookFile();
		HSSFSheet sheet = null;
		sheet = workbook.getSheetAt(0);
		sheet.protectSheet(IDUtils.genId());
		workbook.setSheetName(0, invoiceblPOIParams.getExportSheetName());
		utils.setRowDataCtrl(sheet, new InvocieblRowDataCtrl(aggVOs.get(0)));

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "No-cache");
		InvoiceHVO headVO = aggVOs.get(0).getHeadVO();
		String fileName = headVO.getVbillcode() + ".xls";
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.setSelectedTab(0);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void exportInvoiceExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			InvoiceHVO invoiceHVO = invoiceService.queryInvoiceHVOById(id);
			trans2NameUtils.transHVO(InvoiceHVO.class, MMArrayUtil.toList(InvoiceHVO.class, invoiceHVO), local);

			EUDataGridResult euDataGridResult = invoiceService.queryInvoiceBVOsById(id);
			List<InvoiceBVO> rows = (List<InvoiceBVO>) euDataGridResult.getRows();
			trans2NameUtils.transBVO(InvoiceBVO.class, rows, local);

			List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs = invoiceChangeUtils
					.aggVOs(MMArrayUtil.toList(InvoiceHVO.class, invoiceHVO), rows);
			this.exportInvoice(response, aggVOs);
		}

	}

	private void exportInvoice(HttpServletResponse response, List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs)
			throws IOException {
		HSSFPOIUtils utils = new HSSFPOIUtils(invoicePOIParams);
		HSSFWorkbook workbook = utils.createWorkBookFile();
		HSSFSheet sheet = null;
		sheet = workbook.getSheetAt(0);
		sheet.protectSheet(IDUtils.genId());
		workbook.setSheetName(0, invoicePOIParams.getExportSheetName());
		utils.setRowDataCtrl(sheet, new InvocieRowDataCtrl(aggVOs.get(0)));

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "No-cache");
		InvoiceHVO headVO = aggVOs.get(0).getHeadVO();
		String fileName = headVO.getVbillcode() + ".xls";
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.setSelectedTab(0);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void exportReceiptExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			ReceiptHVO receiptHVO = receiptHVOMapper.selectByPrimaryKey(id);
			String vbillcode = receiptHVO.getVbillcode();
			String vsrcid = receiptHVO.getVsrcid();

			OrderHVO orderHVO = orderService.queryOrderHVOById(vsrcid);
			orderHVO.setThisReceiptMny(receiptHVO.getTotal());
			orderHVO.setRetainage(MMNumberUtil.subtract(orderHVO.getNorigtaxmny(), receiptHVO.getTotal(),
					receiptHVO.getNreceivedmny()));

			trans2NameUtils.transHVO(OrderHVO.class, MMArrayUtil.toList(OrderHVO.class, orderHVO), local);
			EUDataGridResult euDataGridResult = orderService.queryOrderBVOsById(vsrcid);
			List<OrderBVO> rows = (List<OrderBVO>) euDataGridResult.getRows();
			trans2NameUtils.transBVO(OrderBVO.class, rows, local);
			List<AggVO<OrderHVO, OrderBVO>> listAggVOs = new ArrayList<>();
			List<OrderBVO> listBVOs = null;
			if (rows.size() > 19) {
				while (rows.size() > 0) {
					listBVOs = new ArrayList<>();
					int size = rows.size();
					if (rows.size() < 19) {
						for (int i = size - 1; i >= 0; i--) {
							listBVOs.add(rows.get(i));
							rows.remove(i);
						}
					} else {
						for (int i = size - 1; i > size - 20; i--) {
							listBVOs.add(rows.get(i));
							rows.remove(i);
						}
					}
					AggVO<OrderHVO, OrderBVO> aggVO = new AggVO<>();
					aggVO.setHeadVO(orderHVO);
					aggVO.setBodyVOs(MMArrayUtil.toArray(listBVOs));
					listAggVOs.add(aggVO);
				}
				this.exportReceipt(response, listAggVOs, vbillcode);
			} else {
				List<AggVO<OrderHVO, OrderBVO>> aggVOs = orderChangeUtils
						.aggVOs(MMArrayUtil.toList(OrderHVO.class, orderHVO), rows);
				this.exportReceipt(response, aggVOs, vbillcode);
			}
		}
	}

	/**
	 * @param response
	 * @param listAggVOs
	 * @throws IOException
	 */
	private void exportReceipt(HttpServletResponse response, List<AggVO<OrderHVO, OrderBVO>> aggVOs, String vbillcode)
			throws IOException {
		HSSFPOIUtils utils = new HSSFPOIUtils(receiptPOIParams);
		HSSFWorkbook workbook = utils.createWorkBookFile();
		HSSFSheet sheet = null;
		for (int i = aggVOs.size() - 1; i >= 0; i--) {
			sheet = workbook.getSheetAt(i);
			sheet.protectSheet(IDUtils.genId());
			workbook.setSheetName(i, receiptPOIParams.getExportSheetName() + i);
			utils.setRowDataCtrl(sheet, new ReceiptRowDataCtrl(aggVOs.get(i)));
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "No-cache");
		String fileName = vbillcode + ".xls";
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.setSelectedTab(0);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void exportOrderExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			OrderHVO orderHVO = orderService.queryOrderHVOById(id);
			trans2NameUtils.transHVO(OrderHVO.class, MMArrayUtil.toList(OrderHVO.class, orderHVO), local);
			EUDataGridResult euDataGridResult = orderService.queryOrderBVOsById(id);
			List<OrderBVO> rows = (List<OrderBVO>) euDataGridResult.getRows();
			trans2NameUtils.transBVO(OrderBVO.class, rows, local);
			List<AggVO<OrderHVO, OrderBVO>> aggVOs = orderChangeUtils
					.aggVOs(MMArrayUtil.toList(OrderHVO.class, orderHVO), rows);
			this.exportOrder(response, aggVOs);
		}
	}

	private void exportOrder(HttpServletResponse response, List<AggVO<OrderHVO, OrderBVO>> aggVOs) throws IOException {
		HSSFPOIUtils utils = new HSSFPOIUtils(orderPOIParams);
		HSSFWorkbook workbook = utils.createWorkBookFile();
		HSSFSheet sheet = null;
		sheet = workbook.getSheetAt(0);
		sheet.protectSheet(IDUtils.genId());
		workbook.setSheetName(0, orderPOIParams.getExportSheetName());
		utils.setRowDataCtrl(sheet, new OrderRowDataCtrl(aggVOs.get(0)));

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "No-cache");
		OrderHVO headVO = aggVOs.get(0).getHeadVO();
		String fileName = headVO.getVbillcode() + ".xls";
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.setSelectedTab(0);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void exportWhstransExcel(String id, String local, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			WhstransHVO whstransHVO = whstranService.queryWhstransHVOById(id);
			trans2NameUtils.transHVO(WhstransHVO.class, MMArrayUtil.toList(WhstransHVO.class, whstransHVO), local);
			EUDataGridResult euDataGridResult = whstranService.queryWhstransBVOs(id);
			List<WhstransBVO> rows = (List<WhstransBVO>) euDataGridResult.getRows();
			trans2NameUtils.transBVO(WhstransBVO.class, rows, local);
			List<AggVO<WhstransHVO, WhstransBVO>> aggVOs = whstransChangeUtils
					.aggVOs(MMArrayUtil.toList(WhstransHVO.class, whstransHVO), rows);
			this.exportWhstrans(response, aggVOs);
		}
	}

	/**
	 * @param response
	 * @param aggVOs
	 * @throws IOException
	 */
	private void exportWhstrans(HttpServletResponse response, List<AggVO<WhstransHVO, WhstransBVO>> aggVOs)
			throws IOException {
		HSSFPOIUtils utils = new HSSFPOIUtils(whstransPOIParams);
		HSSFWorkbook workbook = utils.createWorkBookFile();
		HSSFSheet sheet = null;
		sheet = workbook.getSheetAt(0);
		sheet.protectSheet(IDUtils.genId());
		workbook.setSheetName(0, whstransPOIParams.getExportSheetName());
		utils.setRowDataCtrl(sheet, new WhstransRowDataCtrl(aggVOs.get(0)));

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "No-cache");
		WhstransHVO headVO = aggVOs.get(0).getHeadVO();
		String fileName = headVO.getVbillcode() + ".xls";
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.setSelectedTab(0);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void exportMoneyDetailExcel(MoneyDetailVO moneyDetailVO, HttpServletRequest request,
			HttpServletResponse response, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(moneyDetailVO)) {
			List<MoneyDetailVO> listDetailVOs = receiptPortService.queryDetailVO(moneyDetailVO, sessionInfo);
			this.exportMoneyDetail(response, listDetailVOs);
		}
	}

	/**
	 * @param response
	 * @param listMoneyDetailVO
	 * @throws IOException
	 */
	private void exportMoneyDetail(HttpServletResponse response, List<MoneyDetailVO> listMoneyDetailVO)
			throws IOException {
		HSSFPOIUtils utils = new HSSFPOIUtils(reportPOIParams);
		HSSFWorkbook workbook = utils.createWorkBookFile();
		HSSFSheet sheet = null;
		sheet = workbook.getSheetAt(0);
		workbook.setSheetName(0, reportPOIParams.getExportSheetName());
		utils.setRowDataCtrl(sheet, new ReportRowDataCtrl(listMoneyDetailVO));

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "No-cache");
		String dbilldate = listMoneyDetailVO.get(0).getDbilldate();
		String fileName = dbilldate + ".xls";
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.setSelectedTab(0);
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

}
