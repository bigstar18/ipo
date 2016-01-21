package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoSpoCommoditymanmaagement {
	private String spoId;

	private String commodityId;

	private Long spoCounts;

	private BigDecimal spoPrice;

	private Date registerDate;

	private Date spoDate;

	private Date ipoDate;

	private Integer spoSate;

	private String rationType;

	private Long notRationCounts;

	private Long successRationCounts;

	private Long minRationCounts;

	private Long minRationProportion;

	private Integer rebate;

	private Integer beListed;

	private Long prePlacement;

	private BigDecimal positionsPrice;

	private String registerDateSart;

	private String registerDateEnd;

	private String firmid;

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid;
	}

	public String getRegisterDateSart() {
		return registerDateSart;
	}

	public void setRegisterDateSart(String registerDateSart) {
		this.registerDateSart = registerDateSart;
	}

	public String getRegisterDateEnd() {
		return registerDateEnd;
	}

	public void setRegisterDateEnd(String registerDateEnd) {
		this.registerDateEnd = registerDateEnd;
	}

	public String getSpoId() {
		return spoId;
	}

	public void setSpoId(String spoId) {
		this.spoId = spoId == null ? null : spoId.trim();
	}

	public String getCommodityid() {
		return commodityId;
	}

	public void setCommodityid(String commodityId) {
		this.commodityId = commodityId == null ? null : commodityId.trim();
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

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

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

	public Integer getSpoSate() {
		return spoSate;
	}

	public void setSpoSate(Integer spoSate) {
		this.spoSate = spoSate;
	}

	public String getRationType() {
		return rationType;
	}

	public void setRationType(String rationType) {
		this.rationType = rationType == null ? null : rationType.trim();
	}

	public Long getNotRationCounts() {
		return notRationCounts;
	}

	public void setNotRationCounts(Long notRationCounts) {
		this.notRationCounts = notRationCounts;
	}

	public Long getSuccessRationCounts() {
		return successRationCounts;
	}

	public void setSuccessRationCounts(Long successRationCounts) {
		this.successRationCounts = successRationCounts;
	}

	public Long getMinRationCounts() {
		return minRationCounts;
	}

	public void setMinRationCounts(Long minRationCounts) {
		this.minRationCounts = minRationCounts;
	}

	public Long getMinRationProportion() {
		return minRationProportion;
	}

	public void setMinRationProportion(Long minRationProportion) {
		this.minRationProportion = minRationProportion;
	}

	public Integer getRebate() {
		return rebate;
	}

	public void setRebate(Integer rebate) {
		this.rebate = rebate;
	}

	public Integer getBeListed() {
		return beListed;
	}

	public void setBeListed(Integer beListed) {
		this.beListed = beListed;
	}

	public Long getPrePlacement() {
		return prePlacement;
	}

	public void setPrePlacement(Long prePlacement) {
		this.prePlacement = prePlacement;
	}

	public BigDecimal getPositionsPrice() {
		return positionsPrice;
	}

	public void setPositionsPrice(BigDecimal positionsPrice) {
		this.positionsPrice = positionsPrice;
	}
}