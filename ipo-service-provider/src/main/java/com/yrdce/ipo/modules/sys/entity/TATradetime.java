package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class TATradetime {
    private Short sectionid;

    private String name;

    private String starttime;

    private String endtime;

    private Short status;

    private Short gatherbid;

    private String bidstarttime;

    private String bidendtime;

    private Date modifytime;

    private String startdate;

    private String enddate;

    private String bidstartdate;

    private String bidenddate;

    public Short getSectionid() {
        return sectionid;
    }

    public void setSectionid(Short sectionid) {
        this.sectionid = sectionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getGatherbid() {
        return gatherbid;
    }

    public void setGatherbid(Short gatherbid) {
        this.gatherbid = gatherbid;
    }

    public String getBidstarttime() {
        return bidstarttime;
    }

    public void setBidstarttime(String bidstarttime) {
        this.bidstarttime = bidstarttime == null ? null : bidstarttime.trim();
    }

    public String getBidendtime() {
        return bidendtime;
    }

    public void setBidendtime(String bidendtime) {
        this.bidendtime = bidendtime == null ? null : bidendtime.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate == null ? null : startdate.trim();
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    public String getBidstartdate() {
        return bidstartdate;
    }

    public void setBidstartdate(String bidstartdate) {
        this.bidstartdate = bidstartdate == null ? null : bidstartdate.trim();
    }

    public String getBidenddate() {
        return bidenddate;
    }

    public void setBidenddate(String bidenddate) {
        this.bidenddate = bidenddate == null ? null : bidenddate.trim();
    }
}