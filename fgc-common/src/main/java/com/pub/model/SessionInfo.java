package com.pub.model;

import java.util.List;

public class SessionInfo {
	
	private String nowDate;

	private String id;// 用户ID
	private String name;// 用户登录名
	private String pkpsndoc;// 用户id
	private String cdept;// 人员对应所在的部门
	private String local;//语言类型

	private List<String> dataDept;// 用户所能看到的部门数据（部门）

	private List<String> resourceList;// 用户可以访问的资源地址列表

	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * @return the pkpsndoc
	 */
	public String getPkpsndoc() {
		return pkpsndoc;
	}

	/**
	 * @param pkpsndoc
	 *            the pkpsndoc to set
	 */
	public void setPkpsndoc(String pkpsndoc) {
		this.pkpsndoc = pkpsndoc;
	}

	/**
	 * @return the cdept
	 */
	public String getCdept() {
		return cdept;
	}

	/**
	 * @param cdept
	 *            the cdept to set
	 */
	public void setCdept(String cdept) {
		this.cdept = cdept;
	}

	/**
	 * @return the dataDept
	 */
	public List<String> getDataDept() {
		return dataDept;
	}

	/**
	 * @param dataDept
	 *            the dataDept to set
	 */
	public void setDataDept(List<String> dataDept) {
		this.dataDept = dataDept;
	}

	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * @return the nowDate
	 */
	public String getNowDate() {
		return nowDate;
	}

	/**
	 * @param nowDate the nowDate to set
	 */
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}

}
