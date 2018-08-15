package com.fgc.controller.user;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;

import com.fgc.pojo.UserDeptVO;
import com.fgc.pojo.UserVO;
import com.fgc.pojo.UserWarehouseVO;
import com.fgc.service.user.IUserService;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 用户控制controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月16日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private LocaleResolver localeResolver;

	/**
	 * 跳转到用户管理界面
	 * 
	 * @return String
	 */
	@RequestMapping("/user")
	public String showUserPage() {
		return "user/user";
	}

	/**
	 * 跳转到用户授权界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/userGrant")
	public String showUserGrantPage(String id, HttpServletRequest request) {
		try {
			String roleIds = userService.queryUserRoleVOById(id);
			UserVO userVO = new UserVO();
			userVO.setCuserid(id);
			userVO.setRoleIds(roleIds);

			request.setAttribute("user", userVO);
		} catch (Exception e) {
			ExceptionUtil.error("根据用户id,查询角色出错,用户id=" + id, e);
		}
		return "user/userGrant";
	}

	/**
	 * 数据权限
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/grantDeptPage")
	public String showGrantDetpPage(String id, HttpServletRequest request) {
		try {
			Map<String, String> mapData = userService.queryUserDeptVOByUserId(id);
			UserDeptVO userDeptVO = new UserDeptVO();
			userDeptVO.setUserId(id);
			userDeptVO.setDeptIds(mapData.get(id));

			request.setAttribute("dept", userDeptVO);
		} catch (Exception e) {
			ExceptionUtil.error("根据用户id,查询角色出错,用户id=" + id, e);
		}

		return "user/grantDept";
	}
	/**
	 * 给用户分配部门
	 * @return WebAppResult
	 */
	@RequestMapping("/grantDepts")
	@ResponseBody
	public WebAppResult grantDepts(UserDeptVO userDeptVO){
		try {
			return userService.insertUserDeptVOs(userDeptVO);
		} catch (Exception e) {
			ExceptionUtil.error("查询用户出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
	/**
	 * 给用户分配仓库
	 * @return WebAppResult
	 */
	@RequestMapping("/grantWarehouse")
	@ResponseBody
	public WebAppResult grantWarehouse(UserWarehouseVO userWarehouseVO){
		try {
			return userService.insertUserWarehouseVOs(userWarehouseVO);
		} catch (Exception e) {
			ExceptionUtil.error("查询用户出错", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}
	/**
	 * 数据权限
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/grantWarehousePage")
	public String showGrantWarehousePage(String id, HttpServletRequest request) {
		try {
			Map<String, String> mapData = userService.queryUserWarehouseVOByUserId(id);
			UserWarehouseVO userWarehouseVO = new UserWarehouseVO();
			userWarehouseVO.setUserId(id);
			userWarehouseVO.setWarehouseIds(mapData.get(id));
			request.setAttribute("warehouse", userWarehouseVO);
		} catch (Exception e) {
			ExceptionUtil.error("根据用户id,查询角色出错,用户id=" + id, e);
		}
		
		return "user/grantWarehouse";
	}
	/**
	 * 查询所有用户信息
	 * 
	 * @return EUDataGridResult
	 */
	@RequestMapping("/qryAllUser")
	@ResponseBody
	public EUDataGridResult queryAllUser(UserVO userVO) {
		try {
			EUDataGridResult result = userService.queryAllUser(userVO);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("查询用户出错", e);
			return null;
		}
	}

	/**
	 * 给用户授权
	 * 
	 * @return WebAppResult
	 */
	@RequestMapping("/grant")
	@ResponseBody
	public WebAppResult grantRole(UserVO userVO) {
		try {
			return userService.insertUserRole(userVO);
		} catch (Exception e) {
			ExceptionUtil.error("给用户授权失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param userVO
	 * @param session
	 * @param request
	 * @param response
	 * @return WebAppResult
	 */
	@RequestMapping("/login")
	@ResponseBody
	public WebAppResult login(UserVO userVO, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		SessionInfo sessionInfo = new SessionInfo();
		if (MMValueUtils.isNotEmpty(userVO)) {
			String locale = userVO.getLocale();
			sessionInfo.setLocal(locale);
			if (MMStringUtil.isNotEmpty(locale)) {
				switch (locale) {
				case "1":
					localeResolver.setLocale(request, response, Locale.CHINESE);
					break;
				case "2":
					localeResolver.setLocale(request, response, Locale.ENGLISH);
					break;
				case "3":
					localeResolver.setLocale(request, response, Locale.FRENCH);
					break;
				case "4":
					localeResolver.setLocale(request, response, Locale.KOREAN);
					break;
				default:
					localeResolver.setLocale(request, response, Locale.CHINESE);
					break;
				}
			}
			try {
				WebAppResult userResult = userService.login(userVO);
				UserVO dbUserVO = (UserVO) userResult.getData();
				sessionInfo.setNowDate(MMNCUtils.getNowDate());
				sessionInfo.setId(dbUserVO.getCuserid());
				sessionInfo.setName(dbUserVO.getUsername());
				sessionInfo.setPkpsndoc(dbUserVO.getPkpsndoc());
				String cdept = userService.queryCdeptByPsndoc(dbUserVO.getPkpsndoc());
				sessionInfo.setCdept(cdept);
				Map<String, String> mapDept = userService.queryUserDeptVOByUserId(dbUserVO.getCuserid());
				String strDepts = mapDept.get(dbUserVO.getCuserid());
				if(MMStringUtil.isNotEmpty(strDepts)){
					String[] arrayDepts = strDepts.split(",");
					sessionInfo.setDataDept(MMArrayUtil.toList(String.class, arrayDepts));
				}
				sessionInfo.setResourceList(userService.resourceList(dbUserVO.getCuserid()));
				
				
				session.setAttribute(UserCommon.SESSION_INFO_NAME, sessionInfo);

			} catch (Exception e) {
				ExceptionUtil.error("用户登录失败", e);
				return WebAppResult.build(500, e.getMessage());
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("http://");
		sBuilder.append(request.getServerName());
		sBuilder.append(":");
		sBuilder.append(request.getServerPort());
		sBuilder.append("/index");
		return WebAppResult.ok(sBuilder.toString());
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return WebAppResult
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public WebAppResult logout(HttpSession session) {
		session.invalidate();
		return WebAppResult.ok();
	}
}
