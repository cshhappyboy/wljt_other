package com.fgc.pojo;

public class UserWarehouseVO {
	
	private String warehouseIds;

	private String userId;

	private String warehouseId;

	/**
	 * @return the warehouseIds
	 */
	public String getWarehouseIds() {
		return warehouseIds;
	}

	/**
	 * @param warehouseIds
	 *            the warehouseIds to set
	 */
	public void setWarehouseIds(String warehouseIds) {
		this.warehouseIds = warehouseIds;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId == null ? null : warehouseId.trim();
	}
}