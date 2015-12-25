package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class IpoSpoRation {
    private Long rationid;

    private Long spoid;

    private Long rationcounts;

    private String firmid;

    private Date operationdate;

    private BigDecimal rationloan;

    private BigDecimal servicefee;

    private Long salesAllocationratio;

    private Long salesRebateratio;

    private String firmname;

    private String salesid;

    public Long getRationid() {
        return rationid;
    }

    public void setRationid(Long rationid) {
        this.rationid = rationid;
    }

    public Long getSpoid() {
        return spoid;
    }

    public void setSpoid(Long spoid) {
        this.spoid = spoid;
    }

    public Long getRationcounts() {
        return rationcounts;
    }

    public void setRationcounts(Long rationcounts) {
        this.rationcounts = rationcounts;
    }

    public String getFirmid() {
        return firmid;
    }

    public void setFirmid(String firmid) {
        this.firmid = firmid == null ? null : firmid.trim();
    }

    public Date getOperationdate() {
        return operationdate;
    }

    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }

    public BigDecimal getRationloan() {
        return rationloan;
    }

    public void setRationloan(BigDecimal rationloan) {
        this.rationloan = rationloan;
    }

    public BigDecimal getServicefee() {
        return servicefee;
    }

    public void setServicefee(BigDecimal servicefee) {
        this.servicefee = servicefee;
    }

    public Long getSalesAllocationratio() {
        return salesAllocationratio;
    }

    public void setSalesAllocationratio(Long salesAllocationratio) {
        this.salesAllocationratio = salesAllocationratio;
    }

    public Long getSalesRebateratio() {
        return salesRebateratio;
    }

    public void setSalesRebateratio(Long salesRebateratio) {
        this.salesRebateratio = salesRebateratio;
    }

    public String getFirmname() {
        return firmname;
    }

    public void setFirmname(String firmname) {
        this.firmname = firmname == null ? null : firmname.trim();
    }

    public String getSalesid() {
        return salesid;
    }

    public void setSalesid(String salesid) {
        this.salesid = salesid == null ? null : salesid.trim();
    }
}