package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 特殊费用配置
 * 
 * @author wq 2016-1-2
 * 
 */
public class IpoChargeUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2927578722687269898L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 业务代码
	 */
	private String businessCode;
	/**
	 * 角色代码
	 */
	private String roleCode;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 费用项
	 */
	private String chargeId;
	/**
	 * 费用名称
	 */
	private String chargeName;
	/**
	 * 上级费用
	 */
	private String chargeParentId;
	/**
	 * 上级费用名称
	 */
	private String chargeParentName;
	/**
	 * 收费模式 ,1:百分比 2:固定值
	 */
	private int chargePattern;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 删除标记 ,0:未删除，1:已删除
	 */
	private int deleteFlag;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 创建人名称
	 */
	private String createUserName;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改人
	 */
	private String updateUser;
	/**
	 * 修改人名称
	 */
	private String updateUserName;
	/**
	 * 修改时间
	 */
	private Date updateDate;

	public IpoChargeUser() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getChargeParentId() {
		return chargeParentId;
	}

	public void setChargeParentId(String chargeParentId) {
		this.chargeParentId = chargeParentId;
	}

	public String getChargeParentName() {
		return chargeParentName;
	}

	public void setChargeParentName(String chargeParentName) {
		this.chargeParentName = chargeParentName;
	}

	public int getChargePattern() {
		return chargePattern;
	}

	public void setChargePattern(int chargePattern) {
		this.chargePattern = chargePattern;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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
		this.updateUser = updateUser;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
