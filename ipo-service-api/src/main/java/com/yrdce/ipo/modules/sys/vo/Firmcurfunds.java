package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

public class Firmcurfunds {
    private String firmid;

    private String name;

    private BigDecimal fBalance;

    private BigDecimal lBalance;

    private BigDecimal yBalance;

    private BigDecimal balancesubtract;

    private BigDecimal lastwarranty;

    private BigDecimal frozenfunds;

    private BigDecimal userBalance;

    public String getFirmid() {
        return firmid;
    }

    public void setFirmid(String firmid) {
        this.firmid = firmid == null ? null : firmid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getfBalance() {
        return fBalance;
    }

    public void setfBalance(BigDecimal fBalance) {
        this.fBalance = fBalance;
    }

    public BigDecimal getlBalance() {
        return lBalance;
    }

    public void setlBalance(BigDecimal lBalance) {
        this.lBalance = lBalance;
    }

    public BigDecimal getyBalance() {
        return yBalance;
    }

    public void setyBalance(BigDecimal yBalance) {
        this.yBalance = yBalance;
    }

    public BigDecimal getBalancesubtract() {
        return balancesubtract;
    }

    public void setBalancesubtract(BigDecimal balancesubtract) {
        this.balancesubtract = balancesubtract;
    }

    public BigDecimal getLastwarranty() {
        return lastwarranty;
    }

    public void setLastwarranty(BigDecimal lastwarranty) {
        this.lastwarranty = lastwarranty;
    }

    public BigDecimal getFrozenfunds() {
        return frozenfunds;
    }

    public void setFrozenfunds(BigDecimal frozenfunds) {
        this.frozenfunds = frozenfunds;
    }

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }
}