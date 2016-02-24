package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DistributionRule {
    private BigDecimal id;

    private String commodityid;

    private BigDecimal holdRatio;

    private BigDecimal purchaseRatio;

    private BigDecimal maxqty;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Short deleteFlag;

    private BigDecimal holdUnitValue;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid == null ? null : commodityid.trim();
    }

    public BigDecimal getHoldRatio() {
        return holdRatio;
    }

    public void setHoldRatio(BigDecimal holdRatio) {
        this.holdRatio = holdRatio;
    }

    public BigDecimal getPurchaseRatio() {
        return purchaseRatio;
    }

    public void setPurchaseRatio(BigDecimal purchaseRatio) {
        this.purchaseRatio = purchaseRatio;
    }

    public BigDecimal getMaxqty() {
        return maxqty;
    }

    public void setMaxqty(BigDecimal maxqty) {
        this.maxqty = maxqty;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public BigDecimal getHoldUnitValue() {
        return holdUnitValue;
    }

    public void setHoldUnitValue(BigDecimal holdUnitValue) {
        this.holdUnitValue = holdUnitValue;
    }
}