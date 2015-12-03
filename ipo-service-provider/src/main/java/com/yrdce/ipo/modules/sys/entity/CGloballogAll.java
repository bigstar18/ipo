package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class CGloballogAll {
    private Long id;

    private String operator;

    private Date operatetime;

    private Short operatetype;

    private String operateip;

    private String operatortype;

    private String mark;

    private String operatecontent;

    private String currentvalue;

    private Short operateresult;

    private Short logtype;

    public CGloballogAll(Long id, String operator, Date operatetime, Short operatetype, String operateip, String operatortype, String mark, String operatecontent, String currentvalue, Short operateresult, Short logtype) {
        this.id = id;
        this.operator = operator;
        this.operatetime = operatetime;
        this.operatetype = operatetype;
        this.operateip = operateip;
        this.operatortype = operatortype;
        this.mark = mark;
        this.operatecontent = operatecontent;
        this.currentvalue = currentvalue;
        this.operateresult = operateresult;
        this.logtype = logtype;
    }

    public CGloballogAll() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public Short getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Short operatetype) {
        this.operatetype = operatetype;
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip == null ? null : operateip.trim();
    }

    public String getOperatortype() {
        return operatortype;
    }

    public void setOperatortype(String operatortype) {
        this.operatortype = operatortype == null ? null : operatortype.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getOperatecontent() {
        return operatecontent;
    }

    public void setOperatecontent(String operatecontent) {
        this.operatecontent = operatecontent == null ? null : operatecontent.trim();
    }

    public String getCurrentvalue() {
        return currentvalue;
    }

    public void setCurrentvalue(String currentvalue) {
        this.currentvalue = currentvalue == null ? null : currentvalue.trim();
    }

    public Short getOperateresult() {
        return operateresult;
    }

    public void setOperateresult(Short operateresult) {
        this.operateresult = operateresult;
    }

    public Short getLogtype() {
        return logtype;
    }

    public void setLogtype(Short logtype) {
        this.logtype = logtype;
    }
}