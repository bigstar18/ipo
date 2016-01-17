package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 扣款流水记录
 * 
 * @author wq 2016-1-17
 * 
 */
public class IpoDebitFlow implements Serializable {

	private static final long serialVersionUID = -2287930479306368445L;
	
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 业务类型
	 */
	private String businessType;
	/**
	 * 费用类型
	 */
	private String chargeType;
	/**
	 * 商品编号
	 */
	private String commodityId;
	/**
	 * 单号
	 */
	private String orderId;

	/**
	 * 扣款状态 :1冻结成功 2 扣款成功
	 */
	private int debitState;
	/**
	 * 付款人
	 */
	private String payer;
	/**
	 * 扣款金额
	 */
	private BigDecimal amount;
	/**
	 * 扣款方式:1 线上扣款 2 线下扣款
	 */
	private int debitMode;
	/**
	 * 扣款渠道:1 保证金扣款 2 :现金 3:刷卡 4:支付宝 5:微信
	 */
	private int debitChannel;
	/**
	 * 扣款时间
	 */
	private Date debitDate;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 返销标记 0:未返销 1 :已返销
	 */
	private int buyBackFlag;

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
	
	public IpoDebitFlow() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getDebitState() {
		return debitState;
	}

	public void setDebitState(int debitState) {
		this.debitState = debitState;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getDebitMode() {
		return debitMode;
	}

	public void setDebitMode(int debitMode) {
		this.debitMode = debitMode;
	}

	public int getDebitChannel() {
		return debitChannel;
	}

	public void setDebitChannel(int debitChannel) {
		this.debitChannel = debitChannel;
	}

	public Date getDebitDate() {
		return debitDate;
	}

	public void setDebitDate(Date debitDate) {
		this.debitDate = debitDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getBuyBackFlag() {
		return buyBackFlag;
	}

	public void setBuyBackFlag(int buyBackFlag) {
		this.buyBackFlag = buyBackFlag;
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
	
	
	
	

}
