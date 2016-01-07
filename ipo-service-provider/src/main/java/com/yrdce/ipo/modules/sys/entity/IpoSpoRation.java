package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoSpoRation {
	private Long rationid;

	private String spoid;

	private Long rationcounts;

	private String firmid;

	private Date operationdate;

	private BigDecimal rationloan;

	private BigDecimal servicefee;

	private BigDecimal salesAllocationratio;

	private BigDecimal salesRebateratio;

	private String firmname;

	private String salesid;

	private String communityId;

	private Date registerDate;

	private Date spoDate;

	private Date ipoDate;

	private Long spoCounts;

	private BigDecimal spoPrice;

	private Integer rationSate;

	private String brokerid;// 会员id

	private String name;// 会员名称

	public Date getSpoDate() {
		return spoDate;
	}

	public void setSpoDate(Date spoDate) {
		this.spoDate = spoDate;
	}

	public Date getIpoDate() {
		return ipoDate;
	}

	public void setIpoDate(Date ipoDate) {
		this.ipoDate = ipoDate;
	}

	public Long getSpoCounts() {
		return spoCounts;
	}

	public void setSpoCounts(Long spoCounts) {
		this.spoCounts = spoCounts;
	}

	public BigDecimal getSpoPrice() {
		return spoPrice;
	}

	public void setSpoPrice(BigDecimal spoPrice) {
		this.spoPrice = spoPrice;
	}

	public Long getRationid() {
		return rationid;
	}

	public void setRationid(Long rationid) {
		this.rationid = rationid;
	}

	public String getSpoid() {
		return spoid;
	}

	public void setSpoid(String spoid) {
		this.spoid = spoid;
	}

	public Long getRationcounts() {
		return rationcounts;
	}

	public void setRationcounts(Long rationcounts) {
		this.rationcounts = rationcounts;
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
	}

	public Date getOperationdate() {
		return operationdate;
	}

	public void setOperationdate(Date operationdate) {
		this.operationdate = operationdate;
	}

	public BigDecimal getRationloan() {
		return rationloan;
	}

	public void setRationloan(BigDecimal rationloan) {
		this.rationloan = rationloan;
	}

	public BigDecimal getServicefee() {
		return servicefee;
	}

	public void setServicefee(BigDecimal servicefee) {
		this.servicefee = servicefee;
	}

	public BigDecimal getSalesAllocationratio() {
		return salesAllocationratio;
	}

	public void setSalesAllocationratio(BigDecimal salesAllocationratio) {
		this.salesAllocationratio = salesAllocationratio;
	}

	public BigDecimal getSalesRebateratio() {
		return salesRebateratio;
	}

	public void setSalesRebateratio(BigDecimal salesRebateratio) {
		this.salesRebateratio = salesRebateratio;
	}

	public String getFirmname() {
		return firmname;
	}

	public void setFirmname(String firmname) {
		this.firmname = firmname == null ? null : firmname.trim();
	}

	public String getSalesid() {
		return salesid;
	}

	public void setSalesid(String salesid) {
		this.salesid = salesid == null ? null : salesid.trim();
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getRationSate() {
		return rationSate;
	}

	public void setRationSate(Integer rationSate) {
		this.rationSate = rationSate;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}