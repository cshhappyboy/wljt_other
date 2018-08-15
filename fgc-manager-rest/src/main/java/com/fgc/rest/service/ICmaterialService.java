package com.fgc.rest.service;

import java.util.List;

import com.pub.model.Tree;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 物料档案接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface ICmaterialService {
	/**
	 * 查询物料分类档案
	 * 
	 * @param filterData
	 * @param id
	 * @return List<Tree>
	 * @throws Exception
	 */
	public List<Tree> queryClassData(String filterData, String id) throws Exception;

	/**
	 * 根据物料分类id查询物料
	 * 
	 * @param filterData
	 * @param classId
	 * @param local
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryCmaterilaData(String filterData, String classId, String local) throws Exception;

	/**
	 * 根据物料id，查询物料编码
	 * 
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public WebAppResult transCmaterialCodeById(String id) throws Exception;

	/**
	 * 根据物料id，查询物料名称
	 * 
	 * @param id
	 * @param local
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult transCmaterialNameById(String id, String local) throws Exception;

	/**
	 * 根据物料id查询物料规格
	 * 
	 * @param id
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult transCmaterialSpecById(String id) throws Exception;

	/**
	 * 根据物料id查询物料类型
	 * 
	 * @param id
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult transCmaterialTypeById(String id) throws Exception;

	/**
	 * 根据物料id查询物料类型
	 * 
	 * @param id
	 * @return WebAppResult
	 */
	public WebAppResult transCmaterialMeasdocById(String id) throws Exception;
}
