package com.fgc.service.res;

import java.util.List;

import com.fgc.pojo.RestypeVO;
import com.fgc.pojo.util.Resource;
import com.pub.model.SessionInfo;
import com.pub.model.Tree;
import com.pub.utils.WebAppResult;

/**
 * 资源列表接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月10日
 *
 *     未来离线需求
 */
public interface IResService {

	/**
	 * 查询所有资源树
	 * 
	 * @return List<Resource>
	 */
	public List<Resource> qryAllResTreeGrid() throws Exception;

	/**
	 * @param type
	 * @param sessionInfo 
	 * 
	 */
	public List<Tree> contTree(String type, SessionInfo sessionInfo) throws Exception;

	/**
	 * 查询所有资源类型
	 */
	public List<RestypeVO> queryAllRestype() throws Exception;

	/**
	 * 保存资源
	 * 
	 * @param resource
	 * @return WebAppResult
	 * 
	 */
	public WebAppResult saveRes(Resource resource) throws Exception;

	/**
	 * 删除资源
	 * 
	 * @param sids
	 * @return WebAppResult
	 */
	public WebAppResult deleteResVOs(String[] ids) throws Exception;

	/**
	 * @param id
	 * @return Resource
	 */
	public Resource queryResById(String id) throws Exception;

	/**
	 * 修改资源
	 * 
	 * @param resource
	 * @return WebAppResult
	 */
	public WebAppResult updateResVO(Resource resource) throws Exception;

}
