package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoUnderwriterSubscribe {
    private BigDecimal subscribeid;

    private String underwriterid;

    private String commodityid;

    private Long subscribecounts;

    private BigDecimal proportion;

    private Short deleteFlag;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    public BigDecimal getSubscribeid() {
        return subscribeid;
    }

    public void setSubscribeid(BigDecimal subscribeid) {
        this.subscribeid = subscribeid;
    }

    public String getUnderwriterid() {
        return underwriterid;
    }

    public void setUnderwriterid(String underwriterid) {
        this.underwriterid = underwriterid == null ? null : underwriterid.trim();
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid == null ? null : commodityid.trim();
    }

    public Long getSubscribecounts() {
        return subscribecounts;
    }

    public void setSubscribecounts(Long subscribecounts) {
        this.subscribecounts = subscribecounts;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
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
}