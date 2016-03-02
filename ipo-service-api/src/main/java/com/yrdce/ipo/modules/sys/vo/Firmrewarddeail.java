package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Firmrewarddeail {
	private String firmid;//交易商id

	private String commodityid;//商品id

	private Date cleardate;//清算日期

	private String brokerid;//加盟商id

	private String brokername;//加盟商名称

	private BigDecimal firstpay;//首款

	private BigDecimal secondpay;//尾款

	private BigDecimal reward;//加盟商实得手续费

	private BigDecimal marketreward;//交易所实得手续费

	private BigDecimal brokereachdivide;//交易手续费中加盟商手续费分成

	private String commodityname;//商品名称

	private Long breedid;//品种编码

	private String breedname;//品种名称

	private String businessType;//业务类型

	private String chargeType;//费用类型

	private long id;//主键

	private BigDecimal trademoney;//交易额

	private String orderId;//订单主键

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

	public Date getCleardate() {
		return cleardate;
	}

	public void setCleardate(Date cleardate) {
		this.cleardate = cleardate;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid == null ? null : brokerid.trim();
	}

	public String getBrokername() {
		return brokername;
	}

	public void setBrokername(String brokername) {
		this.brokername = brokername == null ? null : brokername.trim();
	}

	public BigDecimal getFirstpay() {
		return firstpay;
	}

	public void setFirstpay(BigDecimal firstpay) {
		this.firstpay = firstpay;
	}

	public BigDecimal getSecondpay() {
		return secondpay;
	}

	public void setSecondpay(BigDecimal secondpay) {
		this.secondpay = secondpay;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public BigDecimal getMarketreward() {
		return marketreward;
	}

	public void setMarketreward(BigDecimal marketreward) {
		this.marketreward = marketreward;
	}

	public BigDecimal getBrokereachdivide() {
		return brokereachdivide;
	}

	public void setBrokereachdivide(BigDecimal brokereachdivide) {
		this.brokereachdivide = brokereachdivide;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname == null ? null : commodityname.trim();
	}

	public Long getBreedid() {
		return breedid;
	}

	public void setBreedid(Long breedid) {
		this.breedid = breedid;
	}

	public String getBreedname() {
		return breedname;
	}

	public void setBreedname(String breedname) {
		this.breedname = breedname == null ? null : breedname.trim();
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType == null ? null : businessType.trim();
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType == null ? null : chargeType.trim();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getTrademoney() {
		return trademoney;
	}

	public void setTrademoney(BigDecimal trademoney) {
		this.trademoney = trademoney;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}