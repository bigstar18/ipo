package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 付款流水记录
 * 
 * @author wq 2016-1-21
 *
 */
public class PayFlow implements Serializable {

	private static final long serialVersionUID = 4225236475098996750L;

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
	 * 商品名称
	 */
	private String commodityname;
	/**
	 * 单号
	 */
	private String orderId;

	/**
	 * 付款状态 :1未付款 2 已付款
	 */
	private int payState;
	/**
	 * 收款人
	 */
	private String payee;
	/**
	 * 付款金额
	 */
	private BigDecimal amount;
	/**
	 * 付款方式:1 线上付款 2 线下付款
	 */
	private int payMode;
	/**
	 * 付款渠道:1 保证金付款 2 :现金 3:刷卡 4:支付宝 5:微信
	 */
	private int payChannel;
	/**
	 * 付款时间
	 */
	private Date payDate;
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

	/**
	 * 发售结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endtime;

	/**
	 * 发行会员编号
	 */
	private String pubmemberid;

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getPubmemberid() {
		return pubmemberid;
	}

	public void setPubmemberid(String pubmemberid) {
		this.pubmemberid = pubmemberid;
	}

	public PayFlow() {
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

	public int getPayState() {
		return payState;
	}

	public void setPayState(int payState) {
		this.payState = payState;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getPayMode() {
		return payMode;
	}

	public void setPayMode(int payMode) {
		this.payMode = payMode;
	}

	public int getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(int payChannel) {
		this.payChannel = payChannel;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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
