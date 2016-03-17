package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class THFirmholdsum {
	private Date cleardate;//创建时间

	private String firmid;//交易商id

	private String commodityid;//商品id

	private Short bsFlag;//买卖标志

	private Long holdqty;//持仓量

	private BigDecimal holdfunds;//持仓金额

	private BigDecimal floatingloss;//浮动盈亏

	private BigDecimal evenprice;//持仓均价

	private BigDecimal holdmargin;//实时保证金

	private Long gageqty;//抵顶数量

	private BigDecimal holdassure;//持仓保证金

	public Date getCleardate() {
		return cleardate;
	}

	public void setCleardate(Date cleardate) {
		this.cleardate = cleardate;
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

	public Short getBsFlag() {
		return bsFlag;
	}

	public void setBsFlag(Short bsFlag) {
		this.bsFlag = bsFlag;
	}

	public Long getHoldqty() {
		return holdqty;
	}

	public void setHoldqty(Long holdqty) {
		this.holdqty = holdqty;
	}

	public BigDecimal getHoldfunds() {
		return holdfunds;
	}

	public void setHoldfunds(BigDecimal holdfunds) {
		this.holdfunds = holdfunds;
	}

	public BigDecimal getFloatingloss() {
		return floatingloss;
	}

	public void setFloatingloss(BigDecimal floatingloss) {
		this.floatingloss = floatingloss;
	}

	public BigDecimal getEvenprice() {
		return evenprice;
	}

	public void setEvenprice(BigDecimal evenprice) {
		this.evenprice = evenprice;
	}

	public BigDecimal getHoldmargin() {
		return holdmargin;
	}

	public void setHoldmargin(BigDecimal holdmargin) {
		this.holdmargin = holdmargin;
	}

	public Long getGageqty() {
		return gageqty;
	}

	public void setGageqty(Long gageqty) {
		this.gageqty = gageqty;
	}

	public BigDecimal getHoldassure() {
		return holdassure;
	}

	public void setHoldassure(BigDecimal holdassure) {
		this.holdassure = holdassure;
	}
}