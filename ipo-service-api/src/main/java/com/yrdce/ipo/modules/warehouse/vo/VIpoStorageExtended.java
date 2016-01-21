package com.yrdce.ipo.modules.warehouse.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VIpoStorageExtended implements Serializable {
	private String storageid;

	private String commodityid;

	private Long storagenum;

	private String startnum;

	private String endnum;

	private String operatorid;

	private String warehouseauditorid;

	private String marketauditorid;

	private Integer storagestate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date storagedate;

	private Long warehouseid;

	private String mapperbillid;

	private Long storagecounts;

	private String commodityname;

	private String pubmemberid;

	private String publishername;

	private BigDecimal counts;// 发行数量

	private BigDecimal contractfactor;// 申购单位

	public BigDecimal getContractfactor() {
		return contractfactor;
	}

	public void setContractfactor(BigDecimal contractfactor) {
		this.contractfactor = contractfactor;
	}

	public BigDecimal getCounts() {
		return counts;
	}

	public void setCounts(BigDecimal counts) {
		this.counts = counts;
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

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public String getStorageid() {
		return storageid;
	}

	public void setStorageid(String storageid) {
		this.storageid = storageid == null ? null : storageid.trim();
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public String getStartnum() {
		return startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum == null ? null : startnum.trim();
	}

	public String getEndnum() {
		return endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum == null ? null : endnum.trim();
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid == null ? null : operatorid.trim();
	}

	public String getWarehouseauditorid() {
		return warehouseauditorid;
	}

	public void setWarehouseauditorid(String warehouseauditorid) {
		this.warehouseauditorid = warehouseauditorid == null ? null
				: warehouseauditorid.trim();
	}

	public String getMarketauditorid() {
		return marketauditorid;
	}

	public void setMarketauditorid(String marketauditorid) {
		this.marketauditorid = marketauditorid == null ? null : marketauditorid
				.trim();
	}

	public Integer getStoragestate() {
		return storagestate;
	}

	public void setStoragestate(Integer storagestate) {
		this.storagestate = storagestate;
	}

	public Date getStoragedate() {
		return storagedate;
	}

	public void setStoragedate(Date storagedate) {
		this.storagedate = storagedate;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}

	public String getMapperbillid() {
		return mapperbillid;
	}

	public void setMapperbillid(String mapperbillid) {
		this.mapperbillid = mapperbillid == null ? null : mapperbillid.trim();
	}

	public Long getStoragenum() {
		return storagenum;
	}

	public void setStoragenum(Long storagenum) {
		this.storagenum = storagenum;
	}

	public Long getStoragecounts() {
		return storagecounts;
	}

	public void setStoragecounts(Long storagecounts) {
		this.storagecounts = storagecounts;
	}

	@Override
	public String toString() {
		return "VIpoStorageExtended [storageid=" + storageid + ", commodityid="
				+ commodityid + ", storagenum=" + storagenum + ", startnum="
				+ startnum + ", endnum=" + endnum + ", operatorid="
				+ operatorid + ", warehouseauditorid=" + warehouseauditorid
				+ ", marketauditorid=" + marketauditorid + ", storagestate="
				+ storagestate + ", storagedate=" + storagedate
				+ ", warehouseid=" + warehouseid + ", mapperbillid="
				+ mapperbillid + ", storagecounts=" + storagecounts
				+ ", commodityname=" + commodityname + ", pubmemberid="
				+ pubmemberid + ", publishername=" + publishername
				+ ", counts=" + counts + ", contractfactor=" + contractfactor
				+ "]";
	}

}