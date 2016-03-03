package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author chenjing
 *
 *         加盟商
 */
public class VBrBroker implements Serializable {
	private String brokerid;

	private String password;

	private String name;

	private String telephone;

	private String mobile;

	private String email;

	private String address;

	private String firmid;

	private Short areaid;

	private Short membertype;

	private Date timelimit;

	private String marketmanager;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifytime;

	private String note;

	private BigDecimal userBalance;

	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(BigDecimal userBalance) {
		this.userBalance = userBalance;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid == null ? null : brokerid.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
	}

	public Short getAreaid() {
		return areaid;
	}

	public void setAreaid(Short areaid) {
		this.areaid = areaid;
	}

	public Short getMembertype() {
		return membertype;
	}

	public void setMembertype(Short membertype) {
		this.membertype = membertype;
	}

	public Date getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(Date timelimit) {
		this.timelimit = timelimit;
	}

	public String getMarketmanager() {
		return marketmanager;
	}

	public void setMarketmanager(String marketmanager) {
		this.marketmanager = marketmanager == null ? null : marketmanager
				.trim();
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
}