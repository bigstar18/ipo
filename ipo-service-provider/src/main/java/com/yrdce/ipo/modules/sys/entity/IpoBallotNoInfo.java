package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class IpoBallotNoInfo {
    private Short id;

    private String commodityid;

    private Short ballotnostartlen;

    private Short ballotnoendlen;

    private String ballotno;

    private Date createtime;

    public IpoBallotNoInfo(Short id, String commodityid, Short ballotnostartlen, Short ballotnoendlen, String ballotno, Date createtime) {
        this.id = id;
        this.commodityid = commodityid;
        this.ballotnostartlen = ballotnostartlen;
        this.ballotnoendlen = ballotnoendlen;
        this.ballotno = ballotno;
        this.createtime = createtime;
    }

    public IpoBallotNoInfo() {
        super();
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid == null ? null : commodityid.trim();
    }

    public Short getBallotnostartlen() {
        return ballotnostartlen;
    }

    public void setBallotnostartlen(Short ballotnostartlen) {
        this.ballotnostartlen = ballotnostartlen;
    }

    public Short getBallotnoendlen() {
        return ballotnoendlen;
    }

    public void setBallotnoendlen(Short ballotnoendlen) {
        this.ballotnoendlen = ballotnoendlen;
    }

    public String getBallotno() {
        return ballotno;
    }

    public void setBallotno(String ballotno) {
        this.ballotno = ballotno == null ? null : ballotno.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}