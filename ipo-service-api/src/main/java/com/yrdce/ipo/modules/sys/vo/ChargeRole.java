package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 一般费用配置
 * @author wq 2016-1-3
 *
 */
public class ChargeRole implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8423050314645039990L;

	
	/**
     * 主键
     */
	private Long id;
	/**
	 * 业务代码
	 */
	private String businessCode;
	/**
	 * 业务代码名称
	 */
	private String businessName;
	/**
	 * 角色代码
	 */
	private String roleCode;
	/**
	 * 角色代码名称
	 */
	private String roleCodeName;
	/**
	 * 费用
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
	 * 收费模式 
	 */
	private String chargePatternName;
	/**
	 * 金额
	 */
	private BigDecimal amount;
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
	 
	
	public ChargeRole() {
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


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public String getRoleCodeName() {
		return roleCodeName;
	}


	public void setRoleCodeName(String roleCodeName) {
		this.roleCodeName = roleCodeName;
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


	public String getChargePatternName() {
		return chargePatternName;
	}


	public void setChargePatternName(String chargePatternName) {
		this.chargePatternName = chargePatternName;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
