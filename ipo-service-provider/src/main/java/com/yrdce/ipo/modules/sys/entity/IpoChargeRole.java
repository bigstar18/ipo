package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 一般费用配置
 * @author wq 2016-1-2
 *
 */
public class IpoChargeRole implements Serializable {
	 
	private static final long serialVersionUID = -5307724911242239731L;
	
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
	 * 费用项
	 */
	private String chargeId;
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
	
	public IpoChargeRole() {
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

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
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

	
	
	
}
