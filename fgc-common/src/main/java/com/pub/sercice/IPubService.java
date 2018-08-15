package com.pub.sercice;

import java.util.List;

public abstract interface IPubService {
	/**
	 * 查询所有数据分页显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<?> queryAllPojoSplitPage(int page, int rows,Object obj) throws Exception;

	/**
	 * 查询所有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<?> queryAllPojo() throws Exception;

	/**
	 * 根据ids查询数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<?> queryPojoById(String[] ids) throws Exception;

	/**
	 * 插入数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<?> insertPojo(List<?> objs) throws Exception;

	/**
	 * 修改数据
	 * 
	 * @param objs
	 * @return
	 */
	public List<?> updatePojo(List<?> objs) throws Exception;

	/**
	 * 根据id删除数据
	 * 
	 * @param ids
	 * @return
	 */
	public List<?> deletePojoByIds(String[] ids) throws Exception;

}
