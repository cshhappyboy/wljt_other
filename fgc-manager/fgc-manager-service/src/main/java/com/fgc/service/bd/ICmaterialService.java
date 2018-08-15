package com.fgc.service.bd;

/**
 * 物料参照档案接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public interface ICmaterialService {
	/**
	 * 查询物料分类
	 * 
	 * @param filterData
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String queryClassData(String filterData, String id) throws Exception;

	/**
	 * 查询物料数据
	 * 
	 * @param filterData
	 * @param id
	 * @param local 
	 * @return String
	 */
	public String queryCmaterialData(String filterData, String id, String local) throws Exception;

	/**
	 * 根据物料id，查询物料编码
	 * 
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String transCmaterialCodeById(String id) throws Exception;

	/**
	 * 根据物料id，查询物料名称
	 * 
	 * @param id
	 * @param local 
	 * @return String
	 * @throws Exception
	 */
	public String transCmaterialNameById(String id, String local) throws Exception;

	/**
	 * 根据物料id查询物料规格
	 * 
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String transCmaterialSpecById(String id) throws Exception;

	/**
	 * 根据物料id查询物料型号
	 * 
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String transCmaterialTypeById(String id) throws Exception;

	/**
	 * 根据物料id查询物料辅单位
	 * 
	 * @param id
	 * @return String
	 * @throws Exception
	 */
	public String transCmaterialMeasdocById(String id)throws Exception;
}
