package com.yrdce.ipo.modules.warehouse.entity;

import java.util.Date;

public class StorageUnion {
	
	private String storageid;  //入库单号

    private String commodityid; //商品代码
    
    private String commodityname; //商品名称
    
    private String brokerid;  //发行会员代码
    
    private String name;//发行会员名称
    
    private Long storagenum; //入库件数
    
    private Long instoragenum; //入库数量
    
    private String operatorid;//录入员
    
    private String warehouseauditorid;//仓库审核员
    
    private String marketauditorid;//市场审核员
    
    private Integer storagestate;//入库状态(1.申请 2.仓库通过 3.仓库驳回 4.市场通过 5.市场驳回)
    
    private Date storagedate;//入库时间

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

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname == null ? null : commodityname.trim();
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid == null ? null : brokerid.trim();
	}

	public Long getStoragenum() {
		return storagenum;
	}

	public void setStoragenum(Long storagenum) {
		this.storagenum = storagenum;
	}

	

	public Long getInstoragenum() {
		return instoragenum;
	}

	public void setInstoragenum(Long instoragenum) {
		this.instoragenum = instoragenum;
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
		this.warehouseauditorid = warehouseauditorid == null ? null : warehouseauditorid.trim();
	}

	public String getMarketauditorid() {
		return marketauditorid;
	}

	public void setMarketauditorid(String marketauditorid) {
		this.marketauditorid = marketauditorid == null ? null : marketauditorid.trim();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

}
