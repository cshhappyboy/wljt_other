package com.fgc.service.user;

import java.util.List;
import java.util.Map;

import com.fgc.pojo.UserDeptVO;
import com.fgc.pojo.UserVO;
import com.fgc.pojo.UserWarehouseVO;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 用户服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月16日
 *
 *     未来离线需求
 */
public interface IUserService {
	/**
	 * 查询所有用户
	 * 
	 * @return EUDataGridResult
	 * @throws Exception
	 */
	public EUDataGridResult queryAllUser(UserVO userVO) throws Exception;

	/**
	 * 查询用户对应的角色
	 * 
	 * @param userId
	 * @return String
	 * @throws Exception
	 */
	public String queryUserRoleVOById(String userId) throws Exception;

	/**
	 * 插入用户对应的角色
	 * 
	 * @param userVO
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult insertUserRole(UserVO userVO) throws Exception;

	/**
	 * 用户登录
	 * 
	 * @param userVO
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult login(UserVO userVO) throws Exception;

	/**
	 * 根据用户id查询资源列表
	 * 
	 * @param cuserid
	 * @return List<String>
	 */
	public List<String> resourceList(String cuserid) throws Exception;

	/**
	 * 根据人员id查询人员对应的部门
	 * 
	 * @param pkpsndoc
	 * @return String
	 * @throws Exception
	 */
	public String queryCdeptByPsndoc(String pkpsndoc) throws Exception;

	/**
	 * 根据用户id,查询用户的数据权限部门
	 * 
	 * @param id
	 * @return Map<String, String>
	 */
	public Map<String, String> queryUserDeptVOByUserId(String id) throws Exception;

	/**
	 * 给用户授权部门
	 * 
	 * @param userDeptVO
	 * @return WebAppResult
	 */
	public WebAppResult insertUserDeptVOs(UserDeptVO userDeptVO) throws Exception;

	/**
	 * 根据用户id,查询用户的数据权限仓库
	 * 
	 * @param id
	 * @return Map<String, String>
	 */
	public Map<String, String> queryUserWarehouseVOByUserId(String id) throws Exception;

	/**
	 * @param userWarehouseVO
	 * @return WebAppResult
	 */
	public WebAppResult insertUserWarehouseVOs(UserWarehouseVO userWarehouseVO) throws Exception;

}
