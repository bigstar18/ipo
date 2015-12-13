package com.yrdce.ipo.modules.sys.vo;

import java.util.Date;

public class IpoClearStatus {
    private Short actionid;

    private String actionnote;

    private String status;

    private Date finishtime;

    public IpoClearStatus(Short actionid, String actionnote, String status, Date finishtime) {
        this.actionid = actionid;
        this.actionnote = actionnote;
        this.status = status;
        this.finishtime = finishtime;
    }

    public IpoClearStatus() {
        super();
    }

    public Short getActionid() {
        return actionid;
    }

    public void setActionid(Short actionid) {
        this.actionid = actionid;
    }

    public String getActionnote() {
        return actionnote;
    }

    public void setActionnote(String actionnote) {
        this.actionnote = actionnote == null ? null : actionnote.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }
}