package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoDistribution {
    private String id;

    private String userid;

    private String commodityname;

    private BigDecimal startnumber;

    private BigDecimal pcounts;

    private Date ptime;

    private BigDecimal zcounts;

    private byte[] numbers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public BigDecimal getStartnumber() {
        return startnumber;
    }

    public void setStartnumber(BigDecimal startnumber) {
        this.startnumber = startnumber;
    }

    public BigDecimal getPcounts() {
        return pcounts;
    }

    public void setPcounts(BigDecimal pcounts) {
        this.pcounts = pcounts;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public BigDecimal getZcounts() {
        return zcounts;
    }

    public void setZcounts(BigDecimal zcounts) {
        this.zcounts = zcounts;
    }

    public byte[] getNumbers() {
        return numbers;
    }

    public void setNumbers(byte[] numbers) {
        this.numbers = numbers;
    }
}