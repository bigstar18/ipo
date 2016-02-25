package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Position {
	private BigDecimal positionid;

	private String firmid;

	private Long position;

	private BigDecimal positionUnit;

	private Date settlementdate;

	private String commodityid;

	private String commodityname;

	private String[] warehouse;

	private String[] warehouseid;

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

	public BigDecimal getPositionUnit() {
		return positionUnit;
	}

	public void setPositionUnit(BigDecimal positionUnit) {
		this.positionUnit = positionUnit;
	}

	public Date getSettlementdate() {
		return settlementdate;
	}

	public void setSettlementdate(Date settlementdate) {
		this.settlementdate = settlementdate;
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

	public String[] getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String[] warehouse) {
		this.warehouse = warehouse;
	}

	public String[] getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(String[] warehouseid) {
		this.warehouseid = warehouseid;
	}
}