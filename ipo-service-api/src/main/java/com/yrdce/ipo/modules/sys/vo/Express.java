package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Bob
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Express {

	private String expressId;

	private String address;

	private BigDecimal cost;

	private String receiver;

	private String tel;

	private DeliveryCost deliveryCost;

	private DeliveryOrder deliveryOrder;

	public String getExpressId() {
		return expressId;
	}

	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver == null ? null : receiver.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public DeliveryCost getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(DeliveryCost deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public DeliveryOrder getDeliveryOrder() {
		return deliveryOrder;
	}

	public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
		this.deliveryOrder = deliveryOrder;
	}

}
