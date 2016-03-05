package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoSpoCommoditymanmaagement {
	private String spoId;//增发id

	private String commodityId;//商品id

	private Long spoCounts;//增发数量

	private BigDecimal spoPrice;//增发价格

	private Date registerDate;//登记日期

	private Date spoDate;//增发日期

	private Date ipoDate;//上市日期

	private Integer spoSate;//增发状态

	private String rationType;//配售类型

	private Long notRationCounts;//未配售数量

	private Long successRationCounts;//已配售数量

	private Long minRationCounts;//最小配售数量

	private Long minRationProportion;//最小配售比例

	private Integer rebate;//是否返佣

	private Integer beListed;//是否上市

	private Long prePlacement;//预配售

	private BigDecimal positionsPrice;//持仓价格

	private String registerDateSart;

	private String registerDateEnd;

	private String firmid;//交易商id

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

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
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