package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 托管商品
 * 
 * @author wq 2015-12-24
 * 
 */
public class Trusteeship implements Serializable {

	private static final long serialVersionUID = -3264199182545595199L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 商品编号
	 */
	private String commodityId;
	/**
	 * 商品名称
	 */
	private String commodityName;
	/**
	 * 发行价
	 */
	private BigDecimal price;
	/**
	 * 申请的状态1:申请,2:撤销,3:仓库初审通过,4:仓库初审驳回, 5:仓库终审通过,6:仓库终审驳回,7:已增持加仓,8:已设置预减持
	 */
	private int state;
	/**
	 * 状态名称
	 */
	private String stateName;
	/**
	 * 仓库id
	 */
	private Long warehouseId;
	/**
	 * 仓库名称
	 */
	private String warehouseName;

	/**
	 * 申请数量
	 */
	private Long applyAmount;
	/**
	 * 托管商品计划id
	 */
	private Long trusteeshipCommodityId;
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
	 * 修改时间
	 */
	private Date updateDate;
	/**
	 * 入库数量
	 */
	private Long instorageAmount;
	/**
	 * 托管计划
	 */
	private String plan;
	/**
	 * 滞纳金
	 */
	private BigDecimal delayCharge;
	/**
	 * 审核时间
	 */
	private Date auditingDate;
	/**
	 * 申请时间
	 */
	private String beginCreateDate;
	private String endCreateDate;
	/**
	 * 审核时间
	 */
	private String beginAuditingDate;
	private String endAuditingDate;
	

	public Trusteeship() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Long getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(Long applyAmount) {
		this.applyAmount = applyAmount;
	}

	public Long getTrusteeshipCommodityId() {
		return trusteeshipCommodityId;
	}

	public void setTrusteeshipCommodityId(Long trusteeshipCommodityId) {
		this.trusteeshipCommodityId = trusteeshipCommodityId;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Long getInstorageAmount() {
		return instorageAmount;
	}

	public void setInstorageAmount(Long instorageAmount) {
		this.instorageAmount = instorageAmount;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public BigDecimal getDelayCharge() {
		return delayCharge;
	}

	public void setDelayCharge(BigDecimal delayCharge) {
		this.delayCharge = delayCharge;
	}

	public Date getAuditingDate() {
		return auditingDate;
	}

	public void setAuditingDate(Date auditingDate) {
		this.auditingDate = auditingDate;
	}

	public String getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(String beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	public String getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(String endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public String getBeginAuditingDate() {
		return beginAuditingDate;
	}

	public void setBeginAuditingDate(String beginAuditingDate) {
		this.beginAuditingDate = beginAuditingDate;
	}

	public String getEndAuditingDate() {
		return endAuditingDate;
	}

	public void setEndAuditingDate(String endAuditingDate) {
		this.endAuditingDate = endAuditingDate;
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

	@Override
	public String toString() {
		return "Trusteeship [id=" + id + ", commodityId=" + commodityId
				+ ", commodityName=" + commodityName + ", price=" + price
				+ ", state=" + state + ", stateName=" + stateName
				+ ", warehouseId=" + warehouseId + ", warehouseName="
				+ warehouseName + ", applyAmount=" + applyAmount
				+ ", trusteeshipCommodityId=" + trusteeshipCommodityId
				+ ", createUser=" + createUser + ", createUserName="
				+ createUserName + ", createDate=" + createDate
				+ ", updateUser=" + updateUser + ", updateDate=" + updateDate
				+ ", instorageAmount=" + instorageAmount + ", plan=" + plan
				+ ", delayCharge=" + delayCharge + ", auditingDate="
				+ auditingDate + ", beginCreateDate=" + beginCreateDate
				+ ", endCreateDate=" + endCreateDate + ", beginAuditingDate="
				+ beginAuditingDate + ", endAuditingDate=" + endAuditingDate
				+ "]";
	}
    
	
	
	
}
