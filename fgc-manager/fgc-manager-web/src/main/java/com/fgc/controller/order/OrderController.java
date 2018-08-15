package com.fgc.controller.order;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.adjustrate.IAdjustrateService;
import com.fgc.service.order.IOrderService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.model.SessionInfo;
import com.pub.utils.BillStatus;
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
 * 销售订单controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月22日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IAdjustrateService adjustrateService;

	/**
	 * 显示销售订单列表页面
	 * 
	 * @param sale
	 * @param page
	 * @return String
	 */
	@RequestMapping("/order")
	public String showListPage() {
		return "order/order";
	}

	/**
	 * 跳转卡片界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/orderCard")
	public String showCardPage(String id, HttpServletRequest request) {
		try {
			OrderHVO hvo = orderService.queryOrderHVOById(id);
			request.setAttribute("orderHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "order/orderCard";
	}

	/**
	 * 跳转到拉单界面
	 * 
	 * @return String
	 */
	@RequestMapping("/refOrder")
	public String showRefOrder() {
		return "order/refOrder";
	}

	/**
	 * 显示销售订单新增页面
	 * 
	 * @param sale
	 * @param page
	 * @return String
	 */
	@RequestMapping("/orderAdd")
	public String showAddPage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
		OrderHVO hvo = new OrderHVO();
		hvo.setDbilldate(sessionInfo.getNowDate());
		hvo.setVbillstatus(BillStatus.FREE);
		hvo.setSalesman(sessionInfo.getPkpsndoc());
		hvo.setCdept(sessionInfo.getCdept());
		hvo.setCbalatype("0001Z0100000000000XZ");// 默认现金
		hvo.setCurrency(pubInfoService.getCurrency());// 默认币种
		hvo.setNtotalinvoicemny(BigDecimal.ZERO);
		hvo.setNtotalinvoicenum(BigDecimal.ZERO);
		BigDecimal selectByCurreny = adjustrateService.selectByCurreny(pubInfoService.getCurrency(),sessionInfo.getNowDate());
		hvo.setNexchangerate(selectByCurreny);
		request.setAttribute("orderHVO", hvo);
		return "order/orderAdd";
	}

	/**
	 * 显示销售订单修改页面
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/orderEdit")
	public String showEditPage(String id, HttpServletRequest request) {
		try {
			OrderHVO hvo = orderService.queryOrderHVOById(id);
			request.setAttribute("orderHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "order/orderEdit";
	}

	/**
	 * 显示销售订单通知生产页面
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/orderInfo")
	public String showInfoPage(String id, HttpServletRequest request) {
		try {
			OrderHVO hvo = orderService.queryOrderHVOById(id);
			request.setAttribute("orderHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "order/orderInfo";
	}

	/**
	 * 显示销售订单修订页面
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/orderRevise")
	public String showRevisePage(String id, HttpServletRequest request) {
		try {
			OrderHVO hvo = orderService.queryOrderHVOById(id);
			request.setAttribute("orderHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "order/orderRevise";
	}

	/**
	 * 查询模板
	 */
	@RequestMapping("/orderQuery")
	public String showOrderQuery(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request, OrderCommons.COOKIE_QUERY_ORDER_CONDITION,
				true);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			OrderHVO orderHVO = JsonUtils.jsonToPojo(cookie_query_condition, OrderHVO.class);
			request.setAttribute("orderHVO", orderHVO);
		} else {
			OrderHVO orderHVO = new OrderHVO();
			orderHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			orderHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("orderHVO", orderHVO);
		}
		return "order/orderQuery";
	}

	@RequestMapping("/orderQuery4F")
	public String showOrderQuery4F(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request,
				OrderCommons.COOKIE_QUERY_ORDER_4F_CONDITION, true);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			OrderHVO orderHVO = JsonUtils.jsonToPojo(cookie_query_condition, OrderHVO.class);
			request.setAttribute("orderHVO", orderHVO);
		} else {
			OrderHVO orderHVO = new OrderHVO();
			orderHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			orderHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("orderHVO", orderHVO);
		}
		return "order/orderQuery4F";
	}

	/**
	 * 查询销售订单
	 * 
	 * @param page
	 * @param rows
	 * @return EUDataGridResult
	 */
	@RequestMapping("/allOrder")
	@ResponseBody
	public EUDataGridResult queryAllOrder(int page, int rows, OrderHVO hvo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		EUDataGridResult result = null;
		try {
			if (MMValueUtils.isNotEmpty(hvo) && hvo.getQuery_flag().equals("Y")) {
				// 如果查询条件不为空，将查询条件保存在cookie中方便下次使用
				String effectbillcode = hvo.getEffectbillcode();
				if (effectbillcode.contains("\r\n")) {
					String newEffectbillcode = effectbillcode.replaceAll("\r\n", ",");
					hvo.setEffectbillcode(newEffectbillcode);
				}
				CookieUtils.setCookie(request, response, OrderCommons.COOKIE_QUERY_ORDER_CONDITION,
						JsonUtils.objectToJson(hvo), true);
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = orderService.queryAllOrder(page, rows, hvo, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("查询所有订单数据出错", e);
		}
		return result;
	}

	/**
	 * 销售订单保存controller
	 * 
	 * @param bill
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public WebAppResult saveOrder(JsonBill bill, HttpSession session) {
		if (MMValueUtils.isNotEmpty(bill)) {
			try {
				SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
				WebAppResult appResult = orderService.saveOrder(bill, sessionInfo);
				return appResult;
			} catch (Exception e) {
				ExceptionUtil.error("销售订单保存单据失败", e);
				return WebAppResult.build(500, e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 订单修改
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public WebAppResult updateOrder(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = orderService.updateOrder(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 订单通知生产
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping(value = "/singleInfo", method = RequestMethod.POST)
	@ResponseBody
	public WebAppResult singleInfoOrder(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = orderService.singleInfo(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 订单修订
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping(value = "/revise", method = RequestMethod.POST)
	@ResponseBody
	public WebAppResult reviseOrder(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = orderService.reviseOrder(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修订错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 订单删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public WebAppResult deleteOrder(JsonTS jsonTS) {
		try {
			WebAppResult result = orderService.deleteOrder(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
	/**
	 * 订单作废
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/batchBlackout")
	@ResponseBody
	public WebAppResult batchBlackout(JsonTS jsonTS) {
		try {
			WebAppResult result = orderService.batchBlackout(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
	/**
	 * 刷订单表体有效订单号
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/refreshEffectbillcode")
	@ResponseBody
	public WebAppResult refreshEffectbillcode(JsonTS jsonTS) {
		try {
			WebAppResult result = orderService.refreshEffectbillcode(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单刷新表体有效订单号失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 根据表头id,查询表体数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qryOrderBVOs")
	@ResponseBody
	public EUDataGridResult queryOrderBVOs(String id) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				result = orderService.queryOrderBVOsById(id);
			} catch (Exception e) {
				ExceptionUtil.error("根据id" + id + "查询销售订单表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 根据表头id,查询表体数据过滤已开票数量=表体行数量的数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qryOrderBVOs4Ref")
	@ResponseBody
	public EUDataGridResult queryOrderBVOs4Ref(OrderHVO hvo) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(hvo.getId())) {
			try {
				result = orderService.queryOrderBVOsById4Ref(hvo);
			} catch (Exception e) {
				ExceptionUtil.error("根据id【" + hvo.getId() + "】查询销售订单表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 审核订单
	 */
	@RequestMapping("/batchApprove")
	@ResponseBody
	public WebAppResult approveOrderVOs(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return orderService.approveOrderVOs(jsonTS, sessionInfo, false);
		} catch (Exception e) {
			ExceptionUtil.error("销售订单审批失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 专人审批
	 * 
	 * @param ids
	 * @param session
	 * @return WebAppResult
	 */
	@RequestMapping("/handBatchApprove")
	@ResponseBody
	public WebAppResult handApproveOrderVOs(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return orderService.approveOrderVOs(jsonTS, sessionInfo, true);
		} catch (Exception e) {
			ExceptionUtil.error("销售订单审批失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 弃审
	 */
	@RequestMapping("/batchUnApprove")
	@ResponseBody
	public WebAppResult unApproveOrderVOs(JsonTS jsonTS) {
		try {
			return orderService.unApproveOrderVOs(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售订单弃审失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 跳转退货页面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/returnOrder")
	public String showReturnOrderPage(String id, HttpServletRequest request, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			JsonBill returnJsonBill = orderService.orderReturnById(id, sessionInfo);
			if (MMValueUtils.isNotEmpty(returnJsonBill)) {
				String head = returnJsonBill.getHead();
				String insertBodys = returnJsonBill.getInsertBodys();
				request.setAttribute("orderHVO", JsonUtils.jsonToPojo(head, OrderHVO.class));
				request.setAttribute("orderBVOs", insertBodys);
			}
		} catch (Exception e) {
			ExceptionUtil.error("销售出库出错", e);
		}
		return "order/orderReturn";
	}

	/**
	 * 销售订单批量推产成品入库单
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchFinprodin")
	@ResponseBody
	public WebAppResult orderBatchPush2Finprodin(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return orderService.orderBatchPush2Finprodin(jsonTS, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("批量生成产成品入库出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 跳转选择文件界面
	 * 
	 * @return String
	 */
	@RequestMapping("/orderImport")
	public String showOrderImportPage() {
		return "order/orderImport";
	}

	/**
	 * 跳转选择文件界面
	 * 
	 * @return String
	 */
	@RequestMapping("/orderOldImport")
	public String showOrderOldDataImportPage() {
		return "order/oldOrderImport";
	}

	/**
	 * 上传文件
	 * 
	 * @param response
	 * @param orderFile
	 * @return WebAppResult
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public WebAppResult uploadFile(@RequestParam(value = "orderFile") CommonsMultipartFile orderFile,
			HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return orderService.importExcel(orderFile.getInputStream(), sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("导入销售订单失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param response
	 * @param orderFile
	 * @return WebAppResult
	 */
	@RequestMapping("/uploadFileOld")
	@ResponseBody
	public WebAppResult uploadFileOld(@RequestParam(value = "orderFile") CommonsMultipartFile orderFile) {
		try {
			return orderService.importOldDataExcel(orderFile.getInputStream());
		} catch (Exception e) {
			ExceptionUtil.error("导入销售订单失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 批量通知生产
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/infoOrder")
	@ResponseBody
	public WebAppResult infoOrder(JsonTS jsonTS) {
		try {
			return orderService.infoOrder(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售订单通知生产报错", e);
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
	public WebAppResult unSyncData(JsonTS jsonTS) {
		try {
			return orderService.unSyncData(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售订单取消同步报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
