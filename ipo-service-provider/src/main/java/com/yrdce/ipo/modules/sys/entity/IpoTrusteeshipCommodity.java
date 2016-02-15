package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 托管商品计划
 * @author wq
 *
 */
public class IpoTrusteeshipCommodity implements Serializable {

	private static final long serialVersionUID = 416232160151376484L;
    /**
     * 主键
     */
	private Long id;
	/**
	 * 商品编码
	 */
	private String commodityId;
	/**
	 * 托管计划
	 */
	private String plan;
	/**
	 * 申购发行比例
	 */
	private BigDecimal purchaseRate;
	/**
	 * 挂牌费比例
	 */
	private BigDecimal listingChargeRate;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记 0:有效 1:无效
	 */
	private int deleteFlag;
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
	//other
	/**
	 * 商品名称
	 */
	private String commodityName;
	/**
	 * 发行价格
	 */
	private BigDecimal price;
	/**
	 * 发行数量
	 */
	private long counts;
	
	
	public IpoTrusteeshipCommodity() {
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

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public BigDecimal getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(BigDecimal purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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



	public String getCommodityName() {
		return commodityName;
	}



	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public long getCounts() {
		return counts;
	}



	public void setCounts(long counts) {
		this.counts = counts;
	}



	public BigDecimal getListingChargeRate() {
		return listingChargeRate;
	}



	public void setListingChargeRate(BigDecimal listingChargeRate) {
		this.listingChargeRate = listingChargeRate;
	}
	
	
	
	
}
