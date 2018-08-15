package com.fgc.controller.role;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fgc.pojo.RoleVO;
import com.fgc.pojo.util.Role;
import com.fgc.service.role.IRoleService;
import com.fgc.service.roleres.IRoleResService;
import com.pub.model.Tree;
import com.pub.utils.ExceptionUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.WebAppResult;

/**
 * 角色controller
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月17日
 *
 *     未来离线需求
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IRoleResService roleResService;

	/**
	 * 跳转角色页面
	 * 
	 * @return String
	 */
	@RequestMapping("/role")
	public String showRolePage() {
		return "role/role";
	}

	/**
	 * 跳转到角色新增界面
	 * 
	 * @return String
	 */
	@RequestMapping("/roleAdd")
	public String showRoleAdd() {
		return "role/roleAdd";
	}

	/**
	 * 跳转到角色修改界面
	 * 
	 * @param id
	 * @param request
	 * @return String
	 */
	@RequestMapping("/editRole")
	public String showEditRole(String id, HttpServletRequest request) {
		List<Role> roles = null;
		try {
			roles = (List<Role>) roleService.queryRoleById(id);
			if (MMCollectionUtil.isNotEmpty(roles)) {
				request.setAttribute("role", roles.get(0));
			}
		} catch (Exception e) {
			ExceptionUtil.error("查询角色出错，角色id=" + id, e);
		}
		return "role/roleEdit";
	}

	/**
	 * 授权
	 */
	@RequestMapping("/roleGrant")
	public String showRoleGrantPage(String id, HttpServletRequest request) {
		try {
			Map<String, String> data = roleResService.qryRoleRes(id);
			RoleVO roleVO = new RoleVO();
			roleVO.setId(id);
			roleVO.setResIds(data.get(id));
			request.setAttribute("role", roleVO);
		} catch (Exception e) {
			ExceptionUtil.error("查询已经授权信息错误", e);
		}
		return "role/roleGrant";
	}

	/**
	 * 查询所有角色
	 * 
	 * @return List<Role>
	 */
	@RequestMapping("/queryAllRoles")
	@ResponseBody
	public List<Role> queryAllRoles() {
		try {
			return roleService.queryAllRoles();
		} catch (Exception e) {
			ExceptionUtil.error("查询所有角色出错", e);
			return null;
		}
	}

	/**
	 * 构建上级资源树
	 * 
	 * @return List<Tree>
	 */
	@RequestMapping("/roleTree")
	@ResponseBody
	public List<Tree> roleTree() {
		try {
			return roleService.contTree();
		} catch (Exception e) {
			ExceptionUtil.error("构建上级资源树出错", e);
			return null;
		}
	}

	/**
	 * 插入角色
	 * 
	 * @param role
	 * @return WebAppResult
	 */
	@RequestMapping("/insertRole")
	@ResponseBody
	public WebAppResult insertRoleVO(Role role) {
		try {
			WebAppResult result = roleService.insertRoleVO(role);
			return result;
		} catch (Exception e) {
			ExceptionUtil.error("添加角色失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 角色修改保存
	 * 
	 * @param role
	 * @return WebAppResult
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public WebAppResult updateRoleVO(Role role) {
		try {
			return roleService.updateRoleVO(role);
		} catch (Exception e) {
			ExceptionUtil.error("修改权限出现错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 删除权限
	 */
	@RequestMapping("/delRole")
	@ResponseBody
	public WebAppResult deleteRoleVO(String ids) {
		try {
			return roleService.deleteRoleVO(ids);
		} catch (Exception e) {
			ExceptionUtil.error("删除角色出现错误", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

	/**
	 * 授权
	 */
	@RequestMapping("/grantRes")
	@ResponseBody
	public WebAppResult grantRes(RoleVO roleVO) {
		try {
			return roleResService.insertRoleResVO(roleVO);
		} catch (Exception e) {
			ExceptionUtil.error("授权失败", e);
			return WebAppResult.build(500, e.getMessage());
		}
	}

}
