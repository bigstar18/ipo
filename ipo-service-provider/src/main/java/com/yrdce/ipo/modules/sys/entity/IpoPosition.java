package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoPosition {
	private BigDecimal positionid;

	private String firmid;

	private Long position;

	private String commodityid;

	private String commodityname;

	private Long positionPrice;

	private String positionUnit;

	private BigDecimal reductionNum;

	private Date reductionDate;

	private String warehouseName;

	private String warehouseId;

	public BigDecimal getPositionid() {
		return positionid;
	}

	public void setPositionid(BigDecimal positionid) {
		this.positionid = positionid;
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
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

	public Long getPositionPrice() {
		return positionPrice;
	}

	public void setPositionPrice(Long positionPrice) {
		this.positionPrice = positionPrice;
	}

	public String getPositionUnit() {
		return positionUnit;
	}

	public void setPositionUnit(String positionUnit) {
		this.positionUnit = positionUnit == null ? null : positionUnit.trim();
	}

	public BigDecimal getReductionNum() {
		return reductionNum;
	}

	public void setReductionNum(BigDecimal reductionNum) {
		this.reductionNum = reductionNum;
	}

	public Date getReductionDate() {
		return reductionDate;
	}

	public void setReductionDate(Date reductionDate) {
		this.reductionDate = reductionDate;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
}