package com.fgc.pojo;

public class UserDeptVO {

	private String deptIds;

	private String userId;

	private String deptId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId == null ? null : deptId.trim();
	}

	/**
	 * @return the deptIds
	 */
	public String getDeptIds() {
		return deptIds;
	}

	/**
	 * @param deptIds
	 *            the deptIds to set
	 */
	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

}