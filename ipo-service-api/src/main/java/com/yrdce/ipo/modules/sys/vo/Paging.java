package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

/**
 * @ClassName: Paging
 * @Description: 查询条件共用封装类
 * @author bob
 */
public class Paging implements Serializable {
	private String dealerId;

	private String deliveryorderId;

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDeliveryorderId() {
		return deliveryorderId;
	}

	public void setDeliveryorderId(String deliveryorderId) {
		this.deliveryorderId = deliveryorderId;
	}

}
