package com.fgc.controller.whstrans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.WhstransHVO;
import com.fgc.service.whstrans.IWhstranService;
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
 * 转库单控制类controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月5日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/whstrans")
public class WhstransController {

	@Autowired
	private IWhstranService whstranService;

	/**
	 * 跳转到转库单主界面
	 * 
	 * @return String
	 */
	@RequestMapping("/whstrans")
	public String showWhstransPage() {
		return "whstrans/whstrans";
	}

	/**
	 * 跳转到转库单新增界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/whstransAdd")
	public String showWhrtransAddPage(HttpServletRequest request,HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
		WhstransHVO hvo = new WhstransHVO();
		hvo.setDbilldate(sessionInfo.getNowDate());
		hvo.setVbillstatus(BillStatus.FREE);
		request.setAttribute("whstransHVO", hvo);
		return "whstrans/whstransAdd";
	}

	/**
	 * 跳转到转库单修改界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/whstransEdit")
	public String showWhstransEditPage(String id, HttpServletRequest request) {
		try {
			WhstransHVO hvo = whstranService.queryWhstransHVOById(id);
			request.setAttribute("whstransHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "whstrans/whstransEdit";
	}

	/**
	 * 跳转卡片界面
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/whstransCard")
	public String showWhstransCardPage(String id, HttpServletRequest request) {
		try {
			WhstransHVO hvo = whstranService.queryWhstransHVOById(id);
			request.setAttribute("whstransHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "whstrans/whstransCard";
	}

	/**
	 * 弹出查询模板
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/whstransQuery")
	public String showQueryPage(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request,
				WhstransCommon.COOKIE_QUERY_WHSTRANS_CONDITION);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			WhstransHVO whstransHVO = JsonUtils.jsonToPojo(cookie_query_condition, WhstransHVO.class);
			request.setAttribute("whstransHVO", whstransHVO);
		} else {
			WhstransHVO whstransHVO = new WhstransHVO();
			whstransHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			whstransHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("whstransHVO", whstransHVO);
		}
		return "whstrans/whstransQuery";
	}

	/**
	 * 查询转库单数据
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param request
	 * @param response
	 * @return EUDataGridResult
	 */
	@RequestMapping("/allWhstrans")
	@ResponseBody
	public EUDataGridResult queryAllWhstransVODatas(int page, int rows, WhstransHVO hvo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		EUDataGridResult result = null;
		try {
			if (MMValueUtils.isNotEmpty(hvo)) {
				// 如果查询条件不为空，将查询条件保存在cookie中方便下次使用
				CookieUtils.setCookie(request, response, WhstransCommon.COOKIE_QUERY_WHSTRANS_CONDITION,
						JsonUtils.objectToJson(hvo));
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = whstranService.queryAllWhstransVO(page, rows, hvo, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("查询所有转库单数据出错", e);
		}
		return result;
	}

	/**
	 * 根据转库单表头pk查询表体数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qryWhstransBVOs")
	@ResponseBody
	public EUDataGridResult queryWhstransBVOs(String id) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				result = whstranService.queryWhstransBVOs(id);
			} catch (Exception e) {
				ExceptionUtil.error("根据id" + id + "查询转库单表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 保存转库单数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public WebAppResult saveWhstransVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = whstranService.saveWhstransVO(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("转库单保存失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 修改转库单数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/update")
	@ResponseBody
	public WebAppResult updateWhstransVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = whstranService.updateWhstransVO(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 转库单删除
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public WebAppResult batchDelete(JsonTS jsonTS) {
		try {
			WebAppResult result = whstranService.deleteWhstransVOs(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 转库单审批
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchApprove")
	@ResponseBody
	public WebAppResult batchApprove(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = whstranService.batchApprove(jsonTS, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单审批失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 转库单弃审
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchUnApprove")
	@ResponseBody
	public WebAppResult unBatchApprove(JsonTS jsonTS) {
		try {
			WebAppResult result = whstranService.unBatchApprove(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("转库单审批失败", e);
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
			return whstranService.unSyncData(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("转库单取消同步报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
