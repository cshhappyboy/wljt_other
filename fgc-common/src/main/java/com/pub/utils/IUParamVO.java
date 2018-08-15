package com.pub.utils;

/**
 * 保存和修改操作时传递给公共类的参数类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
public class IUParamVO {

	private String vbillcode;

	private String cuserid;

	private String yeDate;

	/**
	 * @return the vbillcode
	 */
	public String getVbillcode() {
		return vbillcode;
	}

	/**
	 * @param vbillcode
	 *            the vbillcode to set
	 */
	public void setVbillcode(String vbillcode) {
		this.vbillcode = vbillcode;
	}

	/**
	 * @return the cuserid
	 */
	public String getCuserid() {
		return cuserid;
	}

	/**
	 * @param cuserid
	 *            the cuserid to set
	 */
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}

	/**
	 * @return the yeDate
	 */
	public String getYeDate() {
		return yeDate;
	}

	/**
	 * @param yeDate
	 *            the yeDate to set
	 */
	public void setYeDate(String yeDate) {
		this.yeDate = yeDate;
	}

}
