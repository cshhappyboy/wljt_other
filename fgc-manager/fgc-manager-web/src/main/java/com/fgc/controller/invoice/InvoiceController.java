package com.fgc.controller.invoice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.util.RefParamVO;
import com.fgc.service.invoice.InvoiceService;
import com.fgc.service.order.IOrderService;
import com.pub.model.SessionInfo;
import com.pub.utils.CookieUtils;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 发票控制器类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月30日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private InvoiceService invoiceService;

	/**
	 * 打开发票节点
	 * 
	 * @return String
	 */
	@RequestMapping("/invoice")
	public String showInvoicePage() {
		return "invoice/invoice";
	}

	/**
	 * 拉单跳转页面
	 * 
	 * @return String
	 */
	@RequestMapping("/orderChange2Invoice")
	public String showInvoiceChangeAddPage(RefParamVO refParamVO, HttpServletRequest request,HttpSession session) {
		JsonBill invoiceResult = null;
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			invoiceResult = orderService.orderChange2InvoiceById(refParamVO.getId(), refParamVO.getBids(),sessionInfo);
			request.setAttribute("invoiceHVO", JsonUtils.jsonToPojo(invoiceResult.getHead(), InvoiceHVO.class));
			request.setAttribute("invoiceBVOs", invoiceResult.getInsertBodys());
		} catch (Exception e) {
			ExceptionUtil.error("销售订单转换为发票VO出错", e);
		}
		return "invoice/invoiceAdd4Ref";
	}

	/**
	 * 跳转发票修改界面
	 * 
	 * @return
	 */
	@RequestMapping("/invoiceEdit")
	public String showInvoiceEditPage(String id, HttpServletRequest request) {
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				InvoiceHVO invoiceHVO = invoiceService.queryInvoiceHVOById(id);
				request.setAttribute("invoiceHVO", invoiceHVO);
				request.setAttribute("billHid", invoiceHVO.getId());
			} catch (Exception e) {
				ExceptionUtil.error("通过主键查询发票表头报错", e);
			}
		}
		return "invoice/invoiceEdit";
	}

	/**
	 * 跳转发票卡片界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/invoiceCard")
	public String showInvoiceCardPage(String id, HttpServletRequest request) {
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				InvoiceHVO invoiceHVO = invoiceService.queryInvoiceHVOById(id);
				request.setAttribute("invoiceHVO", invoiceHVO);
				request.setAttribute("billHid", invoiceHVO.getId());
			} catch (Exception e) {
				ExceptionUtil.error("通过主键查询发票表头报错", e);
			}
		}
		return "invoice/invoiceCard";
	}

	/**
	 * 跳转查询界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/invoiceQuery")
	public String showInvoiceQueryPage(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request,
				InvoiceCommons.COOKIE_QUERY_INVOICE_CONDITION);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			InvoiceHVO invoiceHVO = JsonUtils.jsonToPojo(cookie_query_condition, InvoiceHVO.class);
			request.setAttribute("invoiceHVO", invoiceHVO);
		} else {
			InvoiceHVO invoiceHVO = new InvoiceHVO();
			invoiceHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			invoiceHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("invoiceHVO", invoiceHVO);
		}
		return "invoice/invoiceQuery";
	}

	/**
	 * 查询发票数据
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param request
	 * @param response
	 * @return EUDataGridResult
	 */
	@RequestMapping("/allInvoice")
	@ResponseBody
	public EUDataGridResult queryAllInvoiceDatas(int page, int rows, InvoiceHVO hvo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		EUDataGridResult result = null;
		try {
			if (MMValueUtils.isNotEmpty(hvo)) {
				// 如果查询条件不为空，将查询条件保存在cookie中方便下次使用
				String effectbillcode = hvo.getEffectbillcode();
				if (effectbillcode.contains("\r\n")) {
					String newEffectbillcode = effectbillcode.replaceAll("\r\n", ",");
					hvo.setEffectbillcode(newEffectbillcode);
				}
				CookieUtils.setCookie(request, response, InvoiceCommons.COOKIE_QUERY_INVOICE_CONDITION,
						JsonUtils.objectToJson(hvo));
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = invoiceService.queryAllData(page, rows, hvo, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售发票主表查询失败", e);
		}
		return null;
	}

	/**
	 * 根据传过来的表头主键查询表体所有行
	 * 
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qryInvoiceBVOs")
	@ResponseBody
	public EUDataGridResult queryInvoiceBodyDatas(String id) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				result = invoiceService.queryInvoiceBVOsById(id);
				return result;
			} catch (Exception e) {
				ExceptionUtil.error("根据id" + id + "查询销售发票表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 根据传过来的表头主键查询表体所有行
	 * 
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qryInvoiceBVOs4Ref")
	@ResponseBody
	public EUDataGridResult queryInvoiceBodyDatas4Ref(String id) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				result = invoiceService.queryInvoiceBVOsById4Ref(id);
				return result;
			} catch (Exception e) {
				ExceptionUtil.error("根据id" + id + "查询销售发票表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 发票保存
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public WebAppResult saveInvoiceVO(JsonBill jsonBill, HttpSession session) {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			try {
				SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
				WebAppResult appResult = invoiceService.saveInvoiceVO(jsonBill, sessionInfo);
				return appResult;
			} catch (Exception e) {
				ExceptionUtil.error("销售订单保存单据失败", e);
				return WebAppResult.build(500, e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 发票修改
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/update")
	@ResponseBody
	public WebAppResult updateInvoiceVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = invoiceService.updateInvoiceVO(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 发票删除
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public WebAppResult deleteInvoiceVO(JsonTS jsonTS) {
		try {
			WebAppResult result = invoiceService.deleteInvoiceVOsByIds(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("删除销售发票报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 发票审核
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchApprove")
	@ResponseBody
	public WebAppResult approveInvoiceVOs(JsonTS jsonTS, HttpSession session) {
		if (MMValueUtils.isNotEmpty(jsonTS)) {
			try {
				SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
				return invoiceService.approveInvoiceVOs(jsonTS, sessionInfo);
			} catch (Exception e) {
				ExceptionUtil.error("销售发票审批失败", e);
				return WebAppResult.build(500, e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 发票弃审
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchUnApprove")
	@ResponseBody
	public WebAppResult unApproveInvoiceVOs(JsonTS jsonTS) {
		try {
			return invoiceService.unUpproveInvoiceVOs(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售发票审批失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	@RequestMapping("/refInvoice")
	public String showRefInvoicePage() {
		return "invoice/refInvoice";
	}

	/**
	 * 允许欠款
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchDebt")
	@ResponseBody
	public WebAppResult batchDebtInvoice(JsonTS jsonTS,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return invoiceService.batchDebtInvoice(jsonTS,sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("销售发票允许欠款失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
	
	/**
	 * 取消同步功能
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/unSyncData")
	@ResponseBody
	public WebAppResult unSyncData(JsonTS jsonTS){
		try {
			return invoiceService.unSyncData(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("发票取消同步报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
