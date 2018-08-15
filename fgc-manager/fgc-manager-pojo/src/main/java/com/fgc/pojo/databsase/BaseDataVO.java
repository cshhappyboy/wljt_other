package com.fgc.pojo.databsase;

/**
 * 档案参照VO
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
public class BaseDataVO {

	private String id;

	private String code;

	private String name;

	private String spec;

	private String type;

	private String xiaoshoumeasdoc;// 销售单位

	private String xiaoshoumeasdocname;// 销售单位名称

	private String fumeasdoc;// 辅单位

	private String zhumeasdoc;// 主单位

	private String fumeasdocname;// 辅单位名称

	private String zhumeasdocname;// 主单位名称

	private String measrate;// 主单位/辅单位

	private String vunitratio;// 销售单位与单位比例值

	private String fee;// 服务类
	
	private String isBatch;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * @param spec
	 *            the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the fumeasdoc
	 */
	public String getFumeasdoc() {
		return fumeasdoc;
	}

	/**
	 * @param fumeasdoc
	 *            the fumeasdoc to set
	 */
	public void setFumeasdoc(String fumeasdoc) {
		this.fumeasdoc = fumeasdoc;
	}

	/**
	 * @return the zhumeasdoc
	 */
	public String getZhumeasdoc() {
		return zhumeasdoc;
	}

	/**
	 * @param zhumeasdoc
	 *            the zhumeasdoc to set
	 */
	public void setZhumeasdoc(String zhumeasdoc) {
		this.zhumeasdoc = zhumeasdoc;
	}

	/**
	 * @return the fumeasdocname
	 */
	public String getFumeasdocname() {
		return fumeasdocname;
	}

	/**
	 * @param fumeasdocname
	 *            the fumeasdocname to set
	 */
	public void setFumeasdocname(String fumeasdocname) {
		this.fumeasdocname = fumeasdocname;
	}

	/**
	 * @return the zhumeasdocname
	 */
	public String getZhumeasdocname() {
		return zhumeasdocname;
	}

	/**
	 * @param zhumeasdocname
	 *            the zhumeasdocname to set
	 */
	public void setZhumeasdocname(String zhumeasdocname) {
		this.zhumeasdocname = zhumeasdocname;
	}

	/**
	 * @return the measrate
	 */
	public String getMeasrate() {
		return measrate;
	}

	/**
	 * @param measrate
	 *            the measrate to set
	 */
	public void setMeasrate(String measrate) {
		this.measrate = measrate;
	}

	/**
	 * @return the fee
	 */
	public String getFee() {
		return fee;
	}

	/**
	 * @param fee
	 *            the fee to set
	 */
	public void setFee(String fee) {
		this.fee = fee;
	}

	/**
	 * @return the vunitratio
	 */
	public String getVunitratio() {
		return vunitratio;
	}

	/**
	 * @param vunitratio
	 *            the vunitratio to set
	 */
	public void setVunitratio(String vunitratio) {
		this.vunitratio = vunitratio;
	}

	/**
	 * @return the xiaoshoumeasdoc
	 */
	public String getXiaoshoumeasdoc() {
		return xiaoshoumeasdoc;
	}

	/**
	 * @param xiaoshoumeasdoc
	 *            the xiaoshoumeasdoc to set
	 */
	public void setXiaoshoumeasdoc(String xiaoshoumeasdoc) {
		this.xiaoshoumeasdoc = xiaoshoumeasdoc;
	}

	/**
	 * @return the xiaoshoumeasdocname
	 */
	public String getXiaoshoumeasdocname() {
		return xiaoshoumeasdocname;
	}

	/**
	 * @param xiaoshoumeasdocname
	 *            the xiaoshoumeasdocname to set
	 */
	public void setXiaoshoumeasdocname(String xiaoshoumeasdocname) {
		this.xiaoshoumeasdocname = xiaoshoumeasdocname;
	}

	/**
	 * @return the isBatch
	 */
	public String getIsBatch() {
		return isBatch;
	}

	/**
	 * @param isBatch the isBatch to set
	 */
	public void setIsBatch(String isBatch) {
		this.isBatch = isBatch;
	}

}
