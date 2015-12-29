package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author chenjing
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private String deliveryorderId;

	private String commodityId;

	private String commodityName;

	private String dealerId;

	private String dealerName;

	private String warehouseId;

	private String warehouseName;

	private Long deliveryQuatity;

	private Long deliveryCounts;

	private String deliveryMethod;

	private String methodId;

	private String unit;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applyDate;

	private Integer approvalStatus;

	private String approvers;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approveDate;

	private String canceler;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cancelDate;

	private Long position;

	private String remarks;
	
	private String pickupPassword;
	
	private String idcardNum;
	
	private String address;
	private BigDecimal cost;
	private String receiver;
	private String tel;
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		this.receiver = receiver;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPickupPassword() {
		return pickupPassword;
	}

	public void setPickupPassword(String pickupPassword) {
		this.pickupPassword = pickupPassword;
	}

	public String getIdcardNum() {
		return idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public String getDeliveryorderId() {
		return deliveryorderId;
	}

	public void setDeliveryorderId(String deliveryorderId) {
		this.deliveryorderId = deliveryorderId;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId == null ? null : commodityId.trim();
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName == null ? null : commodityName
				.trim();
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId == null ? null : dealerId.trim();
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName == null ? null : dealerName.trim();
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId == null ? null : warehouseId.trim();
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName == null ? null : warehouseName
				.trim();
	}

	public Long getDeliveryQuatity() {
		return deliveryQuatity;
	}

	public void setDeliveryQuatity(Long deliveryQuatity) {
		this.deliveryQuatity = deliveryQuatity;
	}

	public Long getDeliveryCounts() {
		return deliveryCounts;
	}

	public void setDeliveryCounts(Long deliveryCounts) {
		this.deliveryCounts = deliveryCounts;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod == null ? null : deliveryMethod
				.trim();
	}

	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovers() {
		return approvers;
	}

	public void setApprovers(String approvers) {
		this.approvers = approvers == null ? null : approvers.trim();
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public String getCanceler() {
		return canceler;
	}

	public void setCanceler(String canceler) {
		this.canceler = canceler == null ? null : canceler.trim();
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	@Override
	public String toString() {
		return "DeliveryOrder [deliveryorderId=" + deliveryorderId
				+ ", commodityId=" + commodityId + ", commodityName="
				+ commodityName + ", dealerId=" + dealerId + ", dealerName="
				+ dealerName + ", warehouseId=" + warehouseId
				+ ", warehouseName=" + warehouseName + ", deliveryQuatity="
				+ deliveryQuatity + ", deliveryCounts=" + deliveryCounts
				+ ", deliveryMethod=" + deliveryMethod + ", methodId="
				+ methodId + ", unit=" + unit + ", deliveryDate="
				+ deliveryDate + ", applyDate=" + applyDate
				+ ", approvalStatus=" + approvalStatus + ", approvers="
				+ approvers + ", approveDate=" + approveDate + ", canceler="
				+ canceler + ", cancelDate=" + cancelDate + ", position="
				+ position + ", remarks=" + remarks + "]";
	}

}