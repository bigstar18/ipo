package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Firmrewarddeail {
    private String firmid;

    private String commodityid;

    private Date cleardate;

    private String brokerid;

    private String brokername;

    private BigDecimal firstpay;

    private BigDecimal secondpay;

    private BigDecimal reward;

    private BigDecimal marketreward;

    private BigDecimal brokereachdivide;

    private String commodityname;

    private Long breedid;

    private String breedname;

    private String businessType;

    private String chargeType;

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
}