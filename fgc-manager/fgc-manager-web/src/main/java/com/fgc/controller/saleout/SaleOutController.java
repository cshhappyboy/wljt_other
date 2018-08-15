package com.fgc.controller.saleout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.SaleOutHVO;
import com.fgc.service.saleout.ISaleOutService;
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
 * 销售出库控制类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月31日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/saleout")
public class SaleOutController {

	@Autowired
	private ISaleOutService saleOutService;

	/**
	 * 跳转销售出库主界面
	 * 
	 * @return String
	 */
	@RequestMapping("/saleout")
	public String showSaleOutPage() {
		return "saleout/saleout";
	}

	/**
	 * 跳转到销售出库新增界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/saleoutAdd")
	public String showSaleOutAddPage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
		SaleOutHVO hvo = new SaleOutHVO();
		hvo.setDbilldate(sessionInfo.getNowDate());
		hvo.setVbillstatus(BillStatus.FREE);
		request.setAttribute("saleOutHVO", hvo);
		return "saleout/saleoutAdd";
	}

	/**
	 * 跳转到销售出库修改界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/saleoutEdit")
	public String showSaleOutEditPage(String id, HttpServletRequest request) {
		try {
			SaleOutHVO hvo = saleOutService.querySaleOutHVOById(id);
			request.setAttribute("saleOutHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "saleout/saleoutEdit";
	}

	@RequestMapping("/saleoutCard")
	public String showSaleOutCardPage(String id, HttpServletRequest request) {
		try {
			SaleOutHVO hvo = saleOutService.querySaleOutHVOById(id);
			request.setAttribute("saleOutHVO", hvo);
			request.setAttribute("billHid", id);
		} catch (Exception e) {
			ExceptionUtil.error("修改查询出错", e);
		}
		return "saleout/saleoutCard";
	}

	/**
	 * 跳转到查询界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/saleoutQuery")
	public String showQueryPage(HttpServletRequest request) {
		// 从cookie中取出上次保存的查询条件，返回给界面
		String cookie_query_condition = CookieUtils.getCookieValue(request,
				SaleOutCommon.COOKIE_QUERY_SALEOUT_CONDITION);
		if (MMStringUtil.isNotEmpty(cookie_query_condition)) {
			SaleOutHVO saleOutHVO = JsonUtils.jsonToPojo(cookie_query_condition, SaleOutHVO.class);
			saleOutHVO.setCmaterial(null);
			saleOutHVO.setCwarehouseid(null);
			request.setAttribute("saleOutHVO", saleOutHVO);
		} else {
			SaleOutHVO saleOutHVO = new SaleOutHVO();
			saleOutHVO.setDbilldatestart(MMNCUtils.getMonthFirstDate());
			saleOutHVO.setDbilldateend(MMNCUtils.getMonthLastDate());
			request.setAttribute("saleOutHVO", saleOutHVO);
		}
		return "saleout/saleoutQuery";
	}

	/**
	 * 查询销售出库数据
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param request
	 * @param response
	 * @return EUDataGridResult
	 */
	@RequestMapping("allsaleout")
	@ResponseBody
	public EUDataGridResult queryAllSaleOutVO(int page, int rows, SaleOutHVO hvo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		EUDataGridResult result = null;
		try {
			if (MMValueUtils.isNotEmpty(hvo)) {
				// 如果查询条件不为空，将查询条件保存在cookie中方便下次使用
				CookieUtils.setCookie(request, response, SaleOutCommon.COOKIE_QUERY_SALEOUT_CONDITION,
						JsonUtils.objectToJson(hvo));
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			result = saleOutService.queryAllSaleOutVO(page, rows, hvo, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("查询所有销售出库数据出错", e);
		}
		return result;
	}

	/**
	 * 根据表头id，查询表体的数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qrysaleoutBVOs")
	@ResponseBody
	public EUDataGridResult querySaleOutBVOs(String id) {
		EUDataGridResult result = null;
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				result = saleOutService.querySaleOutBVOs(id);
			} catch (Exception e) {
				ExceptionUtil.error("根据id" + id + "查询销售出库表体数据失败", e);
			}
		}
		return result;
	}

	/**
	 * 保存销售出库的数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public WebAppResult saveSaleOutVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = saleOutService.saveSaleOutVO4Invoice(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售出库报错失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 更新销售出库的数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public WebAppResult updateSaleOutVO(JsonBill jsonBill, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			WebAppResult result = saleOutService.updateSaleOutVO(jsonBill, sessionInfo);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单修改错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 删除销售出库的数据
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public WebAppResult deleteSaleOutVOs(JsonTS jsonTS) {
		try {
			WebAppResult result = saleOutService.deleteSaleOut(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售订单删除失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 销售出库签字
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchSign")
	@ResponseBody
	public WebAppResult signSaleOutVOs(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return saleOutService.signSaleOutVOs(jsonTS, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("销售出库签字失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 销售出库取消签字
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/batchUnSign")
	@ResponseBody
	public WebAppResult unSignSaleOutVOs(JsonTS jsonTS) {
		try {
			return saleOutService.unSignSaleOutVOs(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售出库签字失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 批量出库
	 * 
	 * @return WebAppResult
	 */
	@RequestMapping("/batchSaleout")
	@ResponseBody
	public WebAppResult batchSaleout(JsonTS jsonTS, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return saleOutService.batchSaleout(jsonTS, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("销售出库批量出库失败", e);
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
			return saleOutService.unSyncData(jsonTS);
		} catch (Exception e) {
			ExceptionUtil.error("销售出库取消同步报错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	@RequestMapping("/refreshEffectbillcode")
	@ResponseBody
	public WebAppResult refreshEffectbillcode(JsonTS jsonTS) {
		try {
			WebAppResult result = saleOutService.refreshEffectbillcode(jsonTS);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("销售出库刷新表体有效订单号失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

}
