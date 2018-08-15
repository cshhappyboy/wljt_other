package com.fgc.service.role;

import java.util.List;

import com.fgc.pojo.util.Role;
import com.pub.model.Tree;
import com.pub.utils.WebAppResult;

/**
 * 角色管理接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月17日
 *
 *     未来离线需求
 */
public interface IRoleService {

	public List<Role> queryAllRoles() throws Exception;

	public List<Tree> contTree() throws Exception;

	public WebAppResult insertRoleVO(Role role) throws Exception;

	public List<Role> queryRoleById(String id) throws Exception;
	
	public WebAppResult updateRoleVO(Role role) throws Exception;

	public WebAppResult deleteRoleVO(String id) throws Exception;
	
}
