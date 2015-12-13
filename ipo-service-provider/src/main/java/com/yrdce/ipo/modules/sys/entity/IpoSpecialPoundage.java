package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoSpecialPoundage {
    private Long poundageId;

    private String dealerId;

    private String commodityId;

    private Integer poundageAlgr;

    private Date modifyDate;

    private BigDecimal registerRatio;

    private BigDecimal cancelRatio;

    private BigDecimal sailRatio;

    public Long getPoundageId() {
        return poundageId;
    }

    public void setPoundageId(Long poundageId) {
        this.poundageId = poundageId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId == null ? null : dealerId.trim();
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId == null ? null : commodityId.trim();
    }

    public Integer getPoundageAlgr() {
        return poundageAlgr;
    }

    public void setPoundageAlgr(Integer poundageAlgr) {
        this.poundageAlgr = poundageAlgr;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getRegisterRatio() {
        return registerRatio;
    }

    public void setRegisterRatio(BigDecimal registerRatio) {
        this.registerRatio = registerRatio;
    }

    public BigDecimal getCancelRatio() {
        return cancelRatio;
    }

    public void setCancelRatio(BigDecimal cancelRatio) {
        this.cancelRatio = cancelRatio;
    }

    public BigDecimal getSailRatio() {
        return sailRatio;
    }

    public void setSailRatio(BigDecimal sailRatio) {
        this.sailRatio = sailRatio;
    }
}