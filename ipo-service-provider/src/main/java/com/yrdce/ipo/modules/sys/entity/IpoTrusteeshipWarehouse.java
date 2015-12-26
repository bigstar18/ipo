package com.yrdce.ipo.modules.sys.entity;

public class IpoTrusteeshipWarehouse {
	private Integer id;

	private String commodityId;

	private Long warehouseId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId == null ? null : commodityId.trim();
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	@Override
	public String toString() {
		return "IpoTrusteeshipWarehouse [id=" + id + ", commodityId="
				+ commodityId + ", warehouseId=" + warehouseId + "]";
	}

}