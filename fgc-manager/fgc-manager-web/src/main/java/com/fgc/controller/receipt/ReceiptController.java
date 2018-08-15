package com.fgc.controller.receipt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.service.order.IOrderService;
import com.fgc.service.receipt.IReceiptService;
import com.pub.model.SessionInfo;
import com.pub.utils.CookieUtils;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 预收款单控制类controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/receipt")
public class ReceiptController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IReceiptService receiptService;

	/**
	 * 跳转预收款单界面
	 * 
	 * @return String
	 */
	@RequestMapping("/receipt")
	public String showReceiptPage() {
		return "receipt/receipt";
	}

	/**
	 * 根据销售订单id，推出预收款单
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/orderPushReceipt")
	public String showOrderPushReceiptPage(String id, HttpServletRequest request,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			JsonBill receiptJsonBill = orderService.pushReceiptVO(id,sessionInfo);
			if (MMValueUtils.isNotEmpty(receiptJsonBill)) {
				String head = receiptJsonBill.getHead();
				request.setAttribute("receiptHVO", JsonUtils.jsonToPojo(head, ReceiptHVO.class));
			}
		} catch (Exception e) {
			ExceptionUtil.error("销售订单转换为预收款单失败", e);
		}
		return "receipt/receiptAdd4Push";
	}
	/**
	 * 根据销售订单id，推出预收款单
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/hongchongReceipt")
	public String showHongchongReceiptPage(String id, HttpServletRequest request,HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			ReceiptHVO receiptHVO = receiptService.hongchongReceiptVO(id,sessionInfo);
			if (MMValueUtils.isNotEmpty(receiptHVO)) {
				request.setAttribute("receiptHVO", receiptHVO);
			}
		} catch (Exception e) {
			ExceptionUtil.error("红冲预收款单", e);
		}
		return "receipt/receiptAdd4Push";
	}

	/**
	 * 跳转预收款单修改界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/receiptEdit")
	public String showReceiptEditPage(String id, HttpServletRequest request) {
		try {
			ReceiptHVO hvo = receiptService.queryReceiptHVOById(id);
			hvo.setMaxtotal(MMNumberUtil.subtract(hvo.getNordermny(), hvo.getNreceivedmny()));
			request.setAttribute("receiptHVO", hvo);
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询预收款单出错,id:" + id, e);
		}
		return "receipt/receiptEdit";
	}

	/**
	 * 跳转卡片界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/receiptCard")
	public String showReceiptCardPage(String id, HttpServletRequest request) {
		try {
			ReceiptHVO hvo = receiptService.queryReceiptHVOById(id);
			request.setAttribute("receiptHVO", hvo);
		} catch (Exception e) {
			ExceptionUtil.error("根据id查询预收款单出错,id:" + id, e);
		}
		return "receipt/receiptCard";
	}

	/**
	 * 跳转预收款单查询界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/receiptQuery")
	public String showReceiptQueryPage(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request,
				ReceiptCommons.COOKIE_QUERY_RECEIPT_CONDITION, true);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			ReceiptHVO receiptHVO = JsonUtils.jsonToPojo(cookie_query_condition, ReceiptHVO.class);
			request.setAttribute("receiptHVO", receiptHVO);
		} else {
			ReceiptHVO receiptHVO = new ReceiptHVO();
			receiptHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			receiptHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("receiptHVO", receiptHVO);
		}
		return "receipt/receiptQuery";
	}

	/**
	 * 查询预收款单数据
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param request
	 * @param response
	 * @return EUDataGridResult
	 */
	@RequestMapping("/allReceipt")
	@ResponseBody
	public EUDataGridResult queryAllReceiptData(int page, int rows, ReceiptHVO hvo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		EUDataGridResult result = null;
		try {
			if (MMValueUtils.isNotEmpty(hvo)) {
				String effectbillcode = hvo.getEffectbillcode();
				if (MMStringUtil.isNotEmpty(effectbillcode) && effectbillcode.contains("\r\n")) {
					effectbillcode = effectbillcode.replaceAll("\r\n", ",");
					hvo.setEffectbillcode(effectbillcode);
				}
				// 如果查询条件不为空，将查询条件保存在cookie中方便下次使用
				CookieUtils.setCookie(request, response, ReceiptCommons.COOKIE_QUERY_RECEIPT_CONDITION,
						JsonUtils.objectToJson(hvo), true);
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = receiptService.queryAllReceiptData(page, rows, hvo, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("查询预收款单出错", e);
		}
		return result;
	}

	/**
	 * 保存预收款单
	 * 
	 * @param bill
	 * @return WebAppResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public WebAppResult saveReceiptHVO(JsonBill bill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = receiptService.saveReceiptVO(bill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("预收款单保存失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 修改预收款单
	 * 
	 * @param bill
	 * @return WebAppResult
	 */
	@RequestMapping("/update")
	@ResponseBody
	public WebAppResult updateReceiptVO(JsonBill bill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = receiptService.updateReceiptVO(bill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 删除预收款单
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public WebAppResult deleteReceiptVO(JsonTS jsonTS) {
		try {
			WebAppResult result = receiptService.deleteReceiptVO(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("删除预收款单失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 预收款单审批
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchApprove")
	@ResponseBody
	public WebAppResult approveReceiptVOs(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return receiptService.approveReceiptVOs(jsonTS, sessionInfo,false);
		} catch (Exception e) {
			ExceptionUtil.error("预收款单审核失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
	/**
	 * 预收款单审批
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/handBatchApprove")
	@ResponseBody
	public WebAppResult handApproveReceiptVOs(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return receiptService.approveReceiptVOs(jsonTS, sessionInfo,true);
		} catch (Exception e) {
			ExceptionUtil.error("预收款单审核失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 弃审
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchUnApprove")
	@ResponseBody
	public WebAppResult unApproveReceiptVOs(JsonTS jsonTS) {
		try {
			return receiptService.unApproveReceiptVOs(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("预收款单审核失败", e);
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
			return receiptService.unSyncData(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售订单取消同步报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
