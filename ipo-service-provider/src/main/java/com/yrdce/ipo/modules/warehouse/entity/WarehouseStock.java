package com.yrdce.ipo.modules.warehouse.entity;

import java.math.BigDecimal;

public class WarehouseStock {
	private String stockid;

	private String commodityid;

	private BigDecimal storagenum;

	private BigDecimal forzennum;

	private BigDecimal availablenum;

	private BigDecimal outboundnum;

	private Long warehouseid;

	public String getStockid() {
		return stockid;
	}

	public void setStockid(String stockid) {
		this.stockid = stockid == null ? null : stockid.trim();
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public BigDecimal getStoragenum() {
		return storagenum;
	}

	public void setStoragenum(BigDecimal storagenum) {
		this.storagenum = storagenum;
	}

	public BigDecimal getForzennum() {
		return forzennum;
	}

	public void setForzennum(BigDecimal forzennum) {
		this.forzennum = forzennum;
	}

	public BigDecimal getAvailablenum() {
		return availablenum;
	}

	public void setAvailablenum(BigDecimal availablenum) {
		this.availablenum = availablenum;
	}

	public BigDecimal getOutboundnum() {
		return outboundnum;
	}

	public void setOutboundnum(BigDecimal outboundnum) {
		this.outboundnum = outboundnum;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}

}