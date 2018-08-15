package com.fgc.pojo.util;

import java.io.Serializable;

/**
 * 资源树实体
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月10日
 *
 *     未来离线系统
 */
public class Resource implements Serializable {

	private static final long serialVersionUID = -2658437101190497910L;

	private String id;
	private String iconCls;
	private String name;
	private String remark;
	private Integer seq;
	private String url;
	private String pid;
	private String pname;
	private String restypeId;
	private String restypeName;
	private String roleId;
	private String roleName;

	private String ename;

	private String fname;

	private String mname;

	private String ts;
	private String dr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getRestypeId() {
		return restypeId;
	}

	public void setRestypeId(String restypeId) {
		this.restypeId = restypeId;
	}

	public String getRestypeName() {
		return restypeName;
	}

	public void setRestypeName(String restypeName) {
		this.restypeName = restypeName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getDr() {
		return dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @param ename
	 *            the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname
	 *            the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}

	/**
	 * @param mname
	 *            the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

}