package com.fgc.controller.finprodin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.util.RefParamVO;
import com.fgc.service.finprodin.IFinprodinService;
import com.fgc.service.order.IOrderService;
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
 * 产成品入库单控制类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月1日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/finprodin")
public class FinprodinController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IFinprodinService finprodinService;

	/**
	 * 跳转产成品入库单界面
	 * 
	 * @return String
	 */
	@RequestMapping("/finprodin")
	public String showFinprodinPage() {
		return "finprodin/finprodin";
	}

	/**
	 * 跳转产成品入库单新增界面
	 * 
	 * @return String
	 */
	@RequestMapping("/finprodinAdd")
	public String showFinprodinAddPage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
		FinprodinHVO hvo = new FinprodinHVO();
		hvo.setDbilldate(sessionInfo.getNowDate());
		hvo.setVbillstatus(BillStatus.FREE);
		hvo.setCbilltype("0001A110000000001SSC");
		request.setAttribute("finprodinHVO", hvo);
		return "finprodin/finprodinAdd";
	}

	/**
	 * 转单界面
	 * 
	 * @param refParamVO
	 * @param request
	 * @return String
	 */
	@RequestMapping("/orderChange2Finprodin")
	public String showFinprodinChangeAddPage(RefParamVO refParamVO, HttpServletRequest request, HttpSession session) {
		JsonBill finprodinJsonBill = null;
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			finprodinJsonBill = orderService.orderChange2FinprodinById(refParamVO.getId(), refParamVO.getBids(),
					sessionInfo);
			request.setAttribute("finprodinHVO", JsonUtils.jsonToPojo(finprodinJsonBill.getHead(), FinprodinHVO.class));
			request.setAttribute("finprodinBVOs", finprodinJsonBill.getInsertBodys());
		} catch (Exception e) {
			ExceptionUtil.error("销售订单转换为发票VO出错", e);
		}
		return "finprodin/finprodinAdd4Ref";
	}

	/**
	 * 跳转到产成品入库单修改界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/finprodinEdit")
	public String showFinprodinEditPage(String id, HttpServletRequest request) {
		try {
			FinprodinHVO hvo = finprodinService.queryFinprodinHVOById(id);
			request.setAttribute("finprodinHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "finprodin/finprodinEdit";
	}

	/**
	 * 跳转卡片界面
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/finprodinCard")
	public String showFinprodinCardPage(String id, HttpServletRequest request) {
		try {
			FinprodinHVO hvo = finprodinService.queryFinprodinHVOById(id);
			request.setAttribute("finprodinHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "finprodin/finprodinCard";
	}

	/**
	 * 弹出查询模板
	 * 
	 * @return String
	 */
	@RequestMapping("/finprodinQuery")
	public String showFinprodinQueryPage(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request,
				FinprodinCommon.COOKIE_QUERY_FINPRODIN_CONDITION);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			FinprodinHVO finprodinHVO = JsonUtils.jsonToPojo(cookie_query_condition, FinprodinHVO.class);
			finprodinHVO.setCmaterial(null);
			finprodinHVO.setCwarehouseid(null);
			request.setAttribute("finprodinHVO", finprodinHVO);
		} else {
			FinprodinHVO finprodinHVO = new FinprodinHVO();
			finprodinHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			finprodinHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("finprodinHVO", finprodinHVO);
		}
		return "finprodin/finprodinQuery";
	}

	/**
	 * 查询数据
	 * 
	 * @return String
	 */
	@RequestMapping("/allFinprodin")
	@ResponseBody
	public EUDataGridResult queryAllFinprodinVODatas(int page, int rows, FinprodinHVO hvo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		EUDataGridResult result = null;
		try {
			if (MMValueUtils.isNotEmpty(hvo)) {
				// 如果查询条件不为空，将查询条件保存在cookie中方便下次使用
				CookieUtils.setCookie(request, response, FinprodinCommon.COOKIE_QUERY_FINPRODIN_CONDITION,
						JsonUtils.objectToJson(hvo));
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = finprodinService.queryAllFinprodinVO(page, rows, hvo, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("查询所有产成品入库数据出错", e);
		}
		return result;

	}

	/**
	 * 根据主表id查询子表数据
	 * 
	 * @return String
	 */
	@RequestMapping("/qryFinprodinBVOs")
	@ResponseBody
	public EUDataGridResult queryFinprodinBVOs(String id) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				result = finprodinService.queryFinprodinBVOs(id);
			} catch (Exception e) {
				ExceptionUtil.error("根据id" + id + "查询产成品入库表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 保存产成品入库数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public WebAppResult saveFinprodinVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = finprodinService.saveFinprodinVO(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("产成品入库单保存失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 修改产成品入库数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/update")
	@ResponseBody
	public WebAppResult updateFinprodinVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = finprodinService.updateFinprodinVO(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 产成品入库删除
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public WebAppResult deleteFinprodinVOs(JsonTS jsonTS) {
		try {
			WebAppResult result = finprodinService.deleteFinprodinVOs(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 产成品入库单批量签字
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchSign")
	@ResponseBody
	public WebAppResult signFinprodinBatch(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = finprodinService.signBatch(jsonTS, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 产成品入库单批量取消签字
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchUnSign")
	@ResponseBody
	public WebAppResult unSignFinprodinBatch(JsonTS jsonTS) {
		try {
			WebAppResult result = finprodinService.unSignBatch(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
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
			return finprodinService.unSyncData(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("产成品入库取消同步报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
}
