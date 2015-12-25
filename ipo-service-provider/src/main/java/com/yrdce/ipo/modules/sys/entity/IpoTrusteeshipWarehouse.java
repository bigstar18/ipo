package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

public class IpoTrusteeshipWarehouse {
	private BigDecimal id;

	private String commodityId;

	private String commodityName;

	private BigDecimal warehouseId;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId == null ? null : commodityId.trim();
	}

	public BigDecimal getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(BigDecimal warehouseId) {
		this.warehouseId = warehouseId;
	}

	@Override
	public String toString() {
		return "IpoTrusteeshipWarehouse [id=" + id + ", commodityId="
				+ commodityId + ", commodityName=" + commodityName
				+ ", warehouseId=" + warehouseId + "]";
	}

}