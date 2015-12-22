package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Spo {
    private String spoId;

    private String communityId;

    private Long spoCounts;

    private BigDecimal spoPrice;

    private Long rationCounts;

    private BigDecimal rationRepayment;

    private BigDecimal rationPoundage;

    private Date registerDate;

    private Date spoDate;

    private Date ipoDate;

    private Integer rationSate;

    private String rationType;

    private String firmId;

    public String getSpoId() {
        return spoId;
    }

    public void setSpoId(String spoId) {
        this.spoId = spoId == null ? null : spoId.trim();
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId == null ? null : communityId.trim();
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

    public Long getRationCounts() {
        return rationCounts;
    }

    public void setRationCounts(Long rationCounts) {
        this.rationCounts = rationCounts;
    }

    public BigDecimal getRationRepayment() {
        return rationRepayment;
    }

    public void setRationRepayment(BigDecimal rationRepayment) {
        this.rationRepayment = rationRepayment;
    }

    public BigDecimal getRationPoundage() {
        return rationPoundage;
    }

    public void setRationPoundage(BigDecimal rationPoundage) {
        this.rationPoundage = rationPoundage;
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

    public Integer getRationSate() {
        return rationSate;
    }

    public void setRationSate(Integer rationSate) {
        this.rationSate = rationSate;
    }

    public String getRationType() {
        return rationType;
    }

    public void setRationType(String rationType) {
        this.rationType = rationType == null ? null : rationType.trim();
    }

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId == null ? null : firmId.trim();
    }
}