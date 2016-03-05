package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoUnderwriterDeposit {
	private Long id;

	private BigDecimal amount;

	private String brokerid;

	private String remark;

	private String createUser;

	private Date createDate;

	private String updateUser;

	private Date updateDate;

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}