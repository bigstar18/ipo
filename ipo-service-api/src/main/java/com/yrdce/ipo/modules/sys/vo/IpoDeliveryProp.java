package com.yrdce.ipo.modules.sys.vo;

/**
 * 交收属性设置表
 * 
 * @author chenjing
 *
 */
public class IpoDeliveryProp {
	private Long deliverypropid;// 主键

	private String commodityid;

	private Long propertyid;// 属性ID

	private Long sortno;// 属性值

	public Long getDeliverypropid() {
		return deliverypropid;
	}

	public void setDeliverypropid(Long deliverypropid) {
		this.deliverypropid = deliverypropid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public Long getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(Long propertyid) {
		this.propertyid = propertyid;
	}

	public Long getSortno() {
		return sortno;
	}

	public void setSortno(Long sortno) {
		this.sortno = sortno;
	}

	@Override
	public String toString() {
		return "IpoDeliveryProp [deliverypropid=" + deliverypropid
				+ ", commodityid=" + commodityid + ", propertyid=" + propertyid
				+ ", sortno=" + sortno + "]";
	}

}