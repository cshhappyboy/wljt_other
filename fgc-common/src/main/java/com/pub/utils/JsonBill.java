package com.pub.utils;

/**
 * 前台通过ajax请求传过来的数据,springMVC用此类接收数据
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月23日
 *
 *     未来离线需求
 */
public class JsonBill {

	private String head;

	/**
	 * 不同状态的表体数据
	 */
	private String insertBodys;
	private String updateBodys;
	private String deleteBodys;
	/**
	 * 界面的所有表体行，用来在修改的时候，表体数据直接统计到表头，不做增删改用
	 */
	private String realyBodys;

	/**
	 * @return the head
	 */
	public String getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * @return the insertBodys
	 */
	public String getInsertBodys() {
		return insertBodys;
	}

	/**
	 * @param insertBodys
	 *            the insertBodys to set
	 */
	public void setInsertBodys(String insertBodys) {
		this.insertBodys = insertBodys;
	}

	/**
	 * @return the updateBodys
	 */
	public String getUpdateBodys() {
		return updateBodys;
	}

	/**
	 * @param updateBodys
	 *            the updateBodys to set
	 */
	public void setUpdateBodys(String updateBodys) {
		this.updateBodys = updateBodys;
	}

	/**
	 * @return the deleteBodys
	 */
	public String getDeleteBodys() {
		return deleteBodys;
	}

	/**
	 * @param deleteBodys
	 *            the deleteBodys to set
	 */
	public void setDeleteBodys(String deleteBodys) {
		this.deleteBodys = deleteBodys;
	}

	/**
	 * @return the realyBodys
	 */
	public String getRealyBodys() {
		return realyBodys;
	}

	/**
	 * @param realyBodys
	 *            the realyBodys to set
	 */
	public void setRealyBodys(String realyBodys) {
		this.realyBodys = realyBodys;
	}

}
