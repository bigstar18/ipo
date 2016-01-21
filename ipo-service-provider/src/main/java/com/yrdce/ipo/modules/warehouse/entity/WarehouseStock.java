package com.yrdce.ipo.modules.warehouse.entity;

public class WarehouseStock {
	private String stockid;

	private String commodityid;

	private Long storagenum;

	private Long forzennum;

	private Long availablenum;

	private Long outboundnum;

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

	public Long getStoragenum() {
		return storagenum;
	}

	public void setStoragenum(Long storagenum) {
		this.storagenum = storagenum;
	}

	public Long getForzennum() {
		return forzennum;
	}

	public void setForzennum(Long forzennum) {
		this.forzennum = forzennum;
	}

	public Long getAvailablenum() {
		return availablenum;
	}

	public void setAvailablenum(Long availablenum) {
		this.availablenum = availablenum;
	}

	public Long getOutboundnum() {
		return outboundnum;
	}

	public void setOutboundnum(Long outboundnum) {
		this.outboundnum = outboundnum;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}

}