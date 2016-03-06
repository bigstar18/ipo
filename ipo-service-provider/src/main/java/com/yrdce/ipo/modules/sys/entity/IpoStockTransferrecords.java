package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoStockTransferrecords {
    private BigDecimal applicationId;

    private Object commodityid;

    private Object customeridApply;

    private Object customeridAccept;

    private BigDecimal transferNumber;

    private Short state;

    private Object remarks;

    private Date createtime;

    private Date reviewtime;

    private Object operator;

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

    public Object getCustomeridApply() {
        return customeridApply;
    }

    public void setCustomeridApply(Object customeridApply) {
        this.customeridApply = customeridApply;
    }

    public Object getCustomeridAccept() {
        return customeridAccept;
    }

    public void setCustomeridAccept(Object customeridAccept) {
        this.customeridAccept = customeridAccept;
    }

    public BigDecimal getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(BigDecimal transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
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
    
    @Override
	public String toString() {
		return "IpoStockTransferrecords [applicationId=" + applicationId
				+ ", commodityid=" + commodityid + "  , customeridApply=" + customeridApply + ", customeridAccept=" + customeridAccept + ", transferNumber=" + transferNumber + ", state=" + state + " , remarks=" + remarks + ", createtime=" + createtime + "  , reviewtime=" + reviewtime + ", operator=" + operator + " ]";
	
    
    
    }

	
}