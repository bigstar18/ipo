package com.yrdce.ipo.modules.warehouse.vo;

/**
 * 仓库库存表
 * 
 * @author chenjing
 *
 */
public class IpoWarehouseStock {
	private String stockid;

	private String commodityid;

	private Long storagenum;

	private Long forzennum;

	private Long availablenum;

	private Long outboundnum;

	private Long warehouseid;
	private String commodityname;

	private String pubmemberid;

	private String pubmembername;

	private String warehousename;

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public String getPubmemberid() {
		return pubmemberid;
	}

	public void setPubmemberid(String pubmemberid) {
		this.pubmemberid = pubmemberid;
	}

	public String getPubmembername() {
		return pubmembername;
	}

	public void setPubmembername(String pubmembername) {
		this.pubmembername = pubmembername;
	}

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

	@Override
	public String toString() {
		return "IpoWarehouseStock [stockid=" + stockid + ", commodityid="
				+ commodityid + ", storagenum=" + storagenum + ", forzennum="
				+ forzennum + ", availablenum=" + availablenum
				+ ", outboundnum=" + outboundnum + ", warehouseid="
				+ warehouseid + ", commodityname=" + commodityname
				+ ", pubmemberid=" + pubmemberid + ", pubmembername="
				+ pubmembername + "]";
	}

}