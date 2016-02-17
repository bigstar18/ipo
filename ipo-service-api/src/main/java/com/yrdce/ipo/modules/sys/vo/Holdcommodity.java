package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: Holdcommodity
 * @Description: 经纪会员持仓表
 * @author bob
 */
public class Holdcommodity {
	private long id;

	private String brokerid;

	private String brokername;

	private String firmid;

	private String commodityid;

	private String commodityname;

	private Short bsFlag;

	private long holdqty;

	private long frozenqty;

	private long quantityavailable;

	private BigDecimal evenprice;

	private BigDecimal price;

	private BigDecimal holdinggainsandlosses;

	private BigDecimal marketvalue;

	private Date createtime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public String getBrokername() {
		return brokername;
	}

	public void setBrokername(String brokername) {
		this.brokername = brokername;
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
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

	public Short getBsFlag() {
		return bsFlag;
	}

	public void setBsFlag(Short bsFlag) {
		this.bsFlag = bsFlag;
	}

	public long getHoldqty() {
		return holdqty;
	}

	public void setHoldqty(long holdqty) {
		this.holdqty = holdqty;
	}

	public long getFrozenqty() {
		return frozenqty;
	}

	public void setFrozenqty(long frozenqty) {
		this.frozenqty = frozenqty;
	}

	public long getQuantityavailable() {
		return quantityavailable;
	}

	public void setQuantityavailable(long quantityavailable) {
		this.quantityavailable = quantityavailable;
	}

	public BigDecimal getEvenprice() {
		return evenprice;
	}

	public void setEvenprice(BigDecimal evenprice) {
		this.evenprice = evenprice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getHoldinggainsandlosses() {
		return holdinggainsandlosses;
	}

	public void setHoldinggainsandlosses(BigDecimal holdinggainsandlosses) {
		this.holdinggainsandlosses = holdinggainsandlosses;
	}

	public BigDecimal getMarketvalue() {
		return marketvalue;
	}

	public void setMarketvalue(BigDecimal marketvalue) {
		this.marketvalue = marketvalue;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}