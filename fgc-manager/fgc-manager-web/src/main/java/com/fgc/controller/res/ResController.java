package com.fgc.controller.res;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.controller.user.UserCommon;
import com.fgc.pojo.RestypeVO;
import com.fgc.pojo.util.Resource;
import com.fgc.service.res.IResService;
import com.pub.model.SessionInfo;
import com.pub.model.Tree;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.WebAppResult;

/**
 * 资源列表控制controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月10日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/res")
public class ResController {

	@Autowired
	private IResService resService;

	/**
	 * 跳转资源列表界面
	 * 
	 * @return String
	 */
	@RequestMapping("/res")
	public String showResPage() {
		return "res/res";
	}

	/**
	 * 跳转到资源新增界面
	 * 
	 * @param request
	 * @return String
	 */
	@RequestMapping("/addRes")
	public String showAddResPage(HttpServletRequest request) {
		try {
			List<RestypeVO> list = resService.queryAllRestype();
			request.setAttribute("resTypeList", list);
		} catch (Exception e) {
			ExceptionUtil.error("查询资源类型出错", e);
		}
		return "res/addRes";
	}

	/**
	 * 跳转到资源修改界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/editRes")
	public String showEditResPage(String id, HttpServletRequest request) {
		if (MMStringUtil.isNotEmpty(id)) {
			try {
				Resource resource = resService.queryResById(id);
				request.setAttribute("resource", resource);
				List<RestypeVO> list = resService.queryAllRestype();
				request.setAttribute("resTypeList", list);
			} catch (Exception e) {
				ExceptionUtil.error("根据id查询资源出错，id=" + id, e);
			}
		}
		return "res/editRes";
	}

	/**
	 * 查询所有资源
	 * 
	 * @return List<Resource>
	 */
	@RequestMapping("/queryAllRes")
	@ResponseBody
	public List<Resource> queryAllResource() {
		List<Resource> treeGrid = null;
		try {
			treeGrid = resService.qryAllResTreeGrid();
		} catch (Exception e) {
			ExceptionUtil.error("查询资源列表出现错误", e);
		}
		return treeGrid;
	}

	/**
	 * 查询菜单和功能树
	 * 
	 * @param type
	 * @param session
	 * @return List<Tree>
	 */
	@RequestMapping("/resTree")
	@ResponseBody
	public List<Tree> queryResTree(@RequestParam(value = "type", defaultValue = "0") String type, HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(UserCommon.SESSION_INFO_NAME);
			return resService.contTree(type, sessionInfo);
		} catch (Exception e) {
			ExceptionUtil.error("查询所有菜单出现错误", e);
		}
		return null;
	}

	/**
	 * 资源数据保存
	 * 
	 * @param resource
	 * @return WebAppResult
	 */
	@RequestMapping("/saveRes")
	@ResponseBody
	public WebAppResult saveResVO(Resource resource) {
		try {
			return resService.saveRes(resource);
		} catch (Exception e) {
			ExceptionUtil.error("新增资料类别出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 删除资源
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	@RequestMapping("/delRes")
	@ResponseBody
	public WebAppResult deleteResVO(String ids) {
		if (MMStringUtil.isNotEmpty(ids)) {
			String[] sids = ids.split(",");
			try {
				return resService.deleteResVOs(sids);
			} catch (Exception e) {
				ExceptionUtil.error("删除资源失败", e);
				return WebAppResult.build(500, "删除资源失败,请联系管理员");
			}
		}
		return WebAppResult.ok();
	}

	/**
	 * 资源修改
	 * 
	 * @param resource
	 * @return WebAppResult
	 */
	@RequestMapping("/updateRes")
	@ResponseBody
	public WebAppResult updateResVO(Resource resource) {
		try {
			return resService.updateResVO(resource);
		} catch (Exception e) {
			ExceptionUtil.error("修改资源出错", e);
			return WebAppResult.build(500, "修改资源出错");
		}
	}
}
