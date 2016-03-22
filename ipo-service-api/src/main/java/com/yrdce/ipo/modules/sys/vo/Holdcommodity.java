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

	private String brokerid;//会员id

	private String brokername;//会员名称

	private String firmid;//交易商id

	private String commodityid;//商品id

	private String commodityname;//商品名称

	private Short bsFlag;//买卖标志

	private long holdqty;//持仓量

	private long frozenqty;//冻结量

	private long quantityavailable;//可用数量

	private BigDecimal evenprice;//持仓均价

	private BigDecimal price;//持仓价

	private BigDecimal holdinggainsandlosses;//持有盈亏

	private BigDecimal marketvalue;//持有市值

	private Date createtime;//创建时间

	private String firmName;

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

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
}