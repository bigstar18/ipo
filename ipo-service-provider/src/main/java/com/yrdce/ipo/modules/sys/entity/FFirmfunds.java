package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

import com.yrdce.ipo.common.persistence.DataEntity;

public class FFirmfunds extends DataEntity<FFirmfunds> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firmid;

	private BigDecimal balance;

	private BigDecimal frozenfunds;

	private BigDecimal lastbalance;

	private BigDecimal lastwarranty;

	private BigDecimal settlemargin;

	private BigDecimal lastsettlemargin;

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getFrozenfunds() {
		return frozenfunds;
	}

	public void setFrozenfunds(BigDecimal frozenfunds) {
		this.frozenfunds = frozenfunds;
	}

	public BigDecimal getLastbalance() {
		return lastbalance;
	}

	public void setLastbalance(BigDecimal lastbalance) {
		this.lastbalance = lastbalance;
	}

	public BigDecimal getLastwarranty() {
		return lastwarranty;
	}

	public void setLastwarranty(BigDecimal lastwarranty) {
		this.lastwarranty = lastwarranty;
	}

	public BigDecimal getSettlemargin() {
		return settlemargin;
	}

	public void setSettlemargin(BigDecimal settlemargin) {
		this.settlemargin = settlemargin;
	}

	public BigDecimal getLastsettlemargin() {
		return lastsettlemargin;
	}

	public void setLastsettlemargin(BigDecimal lastsettlemargin) {
		this.lastsettlemargin = lastsettlemargin;
	}
}