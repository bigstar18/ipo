package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class StockFreeze {
    private BigDecimal applicationId;

    private Object commodityid;

    private Object customerid;

    private Short state;

    private BigDecimal freezeNumber;

    private Date createtime;

    private Date reviewtime;

    private Object operator;
    
    private String freezereason;

    public BigDecimal getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(BigDecimal applicationId) {
        this.applicationId = applicationId;
    }

    public Object getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Object commodityid) {
        this.commodityid = commodityid;
    }

    public Object getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Object customerid) {
        this.customerid = customerid;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public BigDecimal getFreezeNumber() {
        return freezeNumber;
    }

    public void setFreezeNumber(BigDecimal freezeNumber) {
        this.freezeNumber = freezeNumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public Object getOperator() {
        return operator;
    }

    public void setOperator(Object operator) {
        this.operator = operator;
    }
    public String getFreezereason() {
        return freezereason;
    }

    public void setFreezereason(String freezereason) {
        this.freezereason = freezereason == null ? null : freezereason.trim();
    }
}