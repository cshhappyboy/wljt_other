package com.fgc.pojo.databsase;

/**
 * 单据类型返回给前台的数据结构
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
public class Billtype {

	private String billtype_id;

	private String billtype_name;

	/**
	 * @return the billtype_id
	 */
	public String getBilltype_id() {
		return billtype_id;
	}

	/**
	 * @param billtype_id
	 *            the billtype_id to set
	 */
	public void setBilltype_id(String billtype_id) {
		this.billtype_id = billtype_id;
	}

	/**
	 * @return the billtype_name
	 */
	public String getBilltype_name() {
		return billtype_name;
	}

	/**
	 * @param billtype_name
	 *            the billtype_name to set
	 */
	public void setBilltype_name(String billtype_name) {
		this.billtype_name = billtype_name;
	}

}
