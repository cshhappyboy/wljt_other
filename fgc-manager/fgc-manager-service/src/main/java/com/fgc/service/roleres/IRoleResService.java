package com.fgc.service.roleres;

import java.util.Map;

import com.fgc.pojo.RoleVO;
import com.pub.utils.WebAppResult;

/**
 * 权限资源接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月17日
 *
 *     未来离线需求
 */
public interface IRoleResService {

	public WebAppResult insertRoleResVO(RoleVO roleVO) throws Exception;
	
	public Map<String,String> qryRoleRes(String id) throws Exception;

}
