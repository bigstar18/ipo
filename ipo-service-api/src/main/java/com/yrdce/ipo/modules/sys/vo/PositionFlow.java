package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * ipo 持仓流水
 * @author wq 2016-2-16
 *
 */
public class PositionFlow implements Serializable {

	private static final long serialVersionUID = -1112459142599339841L;

	/**
	 * 持仓单号
	 */
	private Long id;
	
	/**
	 * 交易商id
	 */
	private String  firmId;
	
	/**
	 * 持仓量
	 */
	private Long holdqty; 
	/**
	 * 冻结数量
	 */
	private Long frozenqty; 
	/**
	 * 释放数量
	 */
	private Long freeqty;
	
	/**
	 * 业务类型
	 */
	private String  businessCode;
	/**
	 * 角色类型
	 */
	private String  roleCode;
	/**
	 * 商品编码
	 */
	private String  commodityId;
	/**
	 * 持仓价
	 */
	private BigDecimal  price;
	
	/**
	 * 状态 1:待转现货 2:已转现货
	 */
	private int state;
	/**
	 * 状态 1:待转现货 2:已转现货
	 */
	private String stateName;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改人
	 */
	private String updateUser;
	/**
	 * 修改时间
	 */
	private Date updateDate;
	/**
	 * 备注
	 */
	private String remark;
	
	public PositionFlow() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public Long getHoldqty() {
		return holdqty;
	}

	public void setHoldqty(Long holdqty) {
		this.holdqty = holdqty;
	}

	public Long getFrozenqty() {
		return frozenqty;
	}

	public void setFrozenqty(Long frozenqty) {
		this.frozenqty = frozenqty;
	}
    
	public Long getFreeqty() {
		return freeqty;
	}

	public void setFreeqty(Long freeqty) {
		this.freeqty = freeqty;
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

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
