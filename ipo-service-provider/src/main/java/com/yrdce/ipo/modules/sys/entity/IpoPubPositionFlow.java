package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ������ ipo �ֲ���ˮ
 * 
 * @author wq 2016-2-16
 *
 */
public class IpoPubPositionFlow implements Serializable {

	private static final long serialVersionUID = -1112459142599339841L;

	/**
	 * �ֲֵ���
	 */
	private Long id;

	/**
	 * �����̻�Ա����
	 */
	private String publisherId;

	/**
	 * ������id
	 */
	private String firmId;

	/**
	 * �ֲ���
	 */
	private Long holdqty;
	/**
	 * ��������
	 */
	private Long frozenqty;
	/**
	 * �ͷ�����
	 */
	private Long freeqty;

	/**
	 * ҵ������
	 */
	private String businessCode;
	/**
	 * ��ɫ����
	 */
	private String roleCode;
	/**
	 * ��Ʒ����
	 */
	private String commodityId;
	/**
	 * ��Ʒ����
	 */
	private String commodityName;
	/**
	 * �ֲּ�
	 */
	private BigDecimal price;

	/**
	 * ״̬ 1:��ת�ֻ� 2:��ת�ֻ�
	 */
	private int state;
	/**
	 * ״̬ 1:��ת�ֻ� 2:��ת�ֻ�
	 */
	private String stateName;
	/**
	 * ������
	 */
	private String createUser;
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	/**
	 * �޸���
	 */
	private String updateUser;
	/**
	 * �޸�ʱ��
	 */
	private Date updateDate;
	/**
	 * ��ע
	 */
	private String remark;

	public IpoPubPositionFlow() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
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
