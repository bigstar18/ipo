package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: Releasesubscription
 * @Description: 经纪会员发行申购明细表
 * @author bob
 */
public class Releasesubscription {
	private long id;

	private String brokerid;

	private String brokername;

	private String firmid;

	private String commodityid;

	private String commodityname;

	private BigDecimal issueprice;

	private Date purchasetime;

	private long purchasequantity;

	private BigDecimal purchaseamount;

	private BigDecimal issuancefee;

	private BigDecimal refundablepurchaseamount;

	private BigDecimal refundableservicefee;

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

	public BigDecimal getIssueprice() {
		return issueprice;
	}

	public void setIssueprice(BigDecimal issueprice) {
		this.issueprice = issueprice;
	}

	public Date getPurchasetime() {
		return purchasetime;
	}

	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}

	public long getPurchasequantity() {
		return purchasequantity;
	}

	public void setPurchasequantity(long purchasequantity) {
		this.purchasequantity = purchasequantity;
	}

	public BigDecimal getPurchaseamount() {
		return purchaseamount;
	}

	public void setPurchaseamount(BigDecimal purchaseamount) {
		this.purchaseamount = purchaseamount;
	}

	public BigDecimal getIssuancefee() {
		return issuancefee;
	}

	public void setIssuancefee(BigDecimal issuancefee) {
		this.issuancefee = issuancefee;
	}

	public BigDecimal getRefundablepurchaseamount() {
		return refundablepurchaseamount;
	}

	public void setRefundablepurchaseamount(BigDecimal refundablepurchaseamount) {
		this.refundablepurchaseamount = refundablepurchaseamount;
	}

	public BigDecimal getRefundableservicefee() {
		return refundableservicefee;
	}

	public void setRefundableservicefee(BigDecimal refundableservicefee) {
		this.refundableservicefee = refundableservicefee;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}