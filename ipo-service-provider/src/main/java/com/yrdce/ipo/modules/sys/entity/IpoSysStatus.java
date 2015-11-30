package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class IpoSysStatus {
    private Date tradedate;

    private Short status;

    private Short sectionid;

    private String note;

    private String recovertime;

    public IpoSysStatus(Date tradedate, Short status, Short sectionid, String note, String recovertime) {
        this.tradedate = tradedate;
        this.status = status;
        this.sectionid = sectionid;
        this.note = note;
        this.recovertime = recovertime;
    }

    public IpoSysStatus() {
        super();
    }

    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getSectionid() {
        return sectionid;
    }

    public void setSectionid(Short sectionid) {
        this.sectionid = sectionid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getRecovertime() {
        return recovertime;
    }

    public void setRecovertime(String recovertime) {
        this.recovertime = recovertime == null ? null : recovertime.trim();
    }
}