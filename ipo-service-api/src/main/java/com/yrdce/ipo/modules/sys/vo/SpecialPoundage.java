package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SpecialPoundage {
    private Long poundageId;

    private String dealerId;

    private String commodityId;

    private Integer poundageAlgr;

    private Date modifyDate;

    private BigDecimal poundageRatio;

    private String poundageType;

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

    public BigDecimal getPoundageRatio() {
        return poundageRatio;
    }

    public void setPoundageRatio(BigDecimal poundageRatio) {
        this.poundageRatio = poundageRatio;
    }

    public String getPoundageType() {
        return poundageType;
    }

    public void setPoundageType(String poundageType) {
        this.poundageType = poundageType == null ? null : poundageType.trim();
    }
}