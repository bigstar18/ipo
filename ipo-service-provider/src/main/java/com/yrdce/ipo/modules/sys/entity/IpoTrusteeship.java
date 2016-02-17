package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 托管商品
 * 
 * @author wq 2015-12-24
 * 
 */
public class IpoTrusteeship implements Serializable {
	private static final long serialVersionUID = -8938501207598556959L;

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
	 * 申请数量
	 */
	private Long applyAmount;
	/**
	 * 入库数量
	 */
	private Long instorageAmount;
	/**
	 * 供申购数量
	 */
	private Long effectiveAmount;
	/**
	 * 持仓数量
	 */
	private Long positionAmount;
	/**
	 * 托管商品id
	 */
	private Long trusteeshipCommodityId;
	/**
	 * 申请的状态1:申请,2:撤销,3:仓库初审通过,4:仓库初审驳回, 5:仓库终审通过,6:仓库终审驳回,7:已增持加仓,8:已设置预减持
	 */
	private int state;
	/**
	 * 发行价
	 */
	private BigDecimal price;
	
	/**
	 * 发行手续费
	 */
	private BigDecimal publishCharge;
	/**
	 * 滞纳金
	 */
	private BigDecimal delayCharge;
	/**
	 * 挂牌费
	 */
	private BigDecimal listingCharge;
	/**
	 * 审核时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date auditingDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 创建人名称
	 */
	private String createUserName;
	/**
	 * 创建人手机
	 */
	private String createUserMobile;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	/**
	 * 删除标记 0:有效 1:无效
	 */
	private int deleteFlag;
	/**
	 * 仓库id
	 */
	private Long warehouseId;
	/**
	 * 仓库名称
	 */
	private String warehouseName;
	/**
	 * 托管计划
	 */
	private String plan;
	/**
	 * 付货款流水id 
	 */
	private Long payGoodsId;
	/**
	 * 货款支付状态  
	 */
    private int payGoodsState;
    /**
     * 货款
     */
	private BigDecimal goodsCharge;
	/**
	 * 支付时间
	 */
	private Date payDate;
	
	/**
	 * 预减持日期
	 */
	private Date reduceDate;
	/**
	 * 预减持百分比
	 */
	private BigDecimal reduceRatio;
	
	

	public IpoTrusteeship() {
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

	public Long getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(Long applyAmount) {
		this.applyAmount = applyAmount;
	}

	public Long getInstorageAmount() {
		return instorageAmount;
	}

	public void setInstorageAmount(Long instorageAmount) {
		this.instorageAmount = instorageAmount;
	}

	public Long getEffectiveAmount() {
		return effectiveAmount;
	}

	public void setEffectiveAmount(Long effectiveAmount) {
		this.effectiveAmount = effectiveAmount;
	}

	public Long getPositionAmount() {
		return positionAmount;
	}

	public void setPositionAmount(Long positionAmount) {
		this.positionAmount = positionAmount;
	}

	public Long getTrusteeshipCommodityId() {
		return trusteeshipCommodityId;
	}

	public void setTrusteeshipCommodityId(Long trusteeshipCommodityId) {
		this.trusteeshipCommodityId = trusteeshipCommodityId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPublishCharge() {
		return publishCharge;
	}

	public void setPublishCharge(BigDecimal publishCharge) {
		this.publishCharge = publishCharge;
	}

	public BigDecimal getListingCharge() {
		return listingCharge;
	}

	public void setListingCharge(BigDecimal listingCharge) {
		this.listingCharge = listingCharge;
	}

	public Date getAuditingDate() {
		return auditingDate;
	}

	public void setAuditingDate(Date auditingDate) {
		this.auditingDate = auditingDate;
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

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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

	public String getCreateUserMobile() {
		return createUserMobile;
	}

	public void setCreateUserMobile(String createUserMobile) {
		this.createUserMobile = createUserMobile;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getPayGoodsId() {
		return payGoodsId;
	}

	public void setPayGoodsId(Long payGoodsId) {
		this.payGoodsId = payGoodsId;
	}

	public int getPayGoodsState() {
		return payGoodsState;
	}

	public void setPayGoodsState(int payGoodsState) {
		this.payGoodsState = payGoodsState;
	}

	public BigDecimal getGoodsCharge() {
		return goodsCharge;
	}

	public void setGoodsCharge(BigDecimal goodsCharge) {
		this.goodsCharge = goodsCharge;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getReduceDate() {
		return reduceDate;
	}

	public void setReduceDate(Date reduceDate) {
		this.reduceDate = reduceDate;
	}

	public BigDecimal getReduceRatio() {
		return reduceRatio;
	}

	public void setReduceRatio(BigDecimal reduceRatio) {
		this.reduceRatio = reduceRatio;
	}
	
    
}
