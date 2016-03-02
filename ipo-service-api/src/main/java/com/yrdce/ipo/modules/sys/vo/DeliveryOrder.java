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

	private String deliveryorderId;//提货单号

	private String commodityId;//商品

	private String commodityName;//商品名称

	private String dealerId;//交易商id

	private String dealerName;//交易商名称

	private String warehouseId;//仓库id

	private String warehouseName;//仓库名称

	private Long deliveryQuatity;//交割数量

	private Long deliveryCounts;//交割件数

	private String deliveryMethod;//提货方式

	private String methodId;//关联提货方式id

	private String unit;//单位

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;//提货日期

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applyDate;//申请日期

	private String approvalStatus;// (1、申请 2、市场通过 3、市场驳回 4、已打印 5、已过户 6、仓库通过
									// 7、仓库驳回 8、已设置配置费用 9、已确认 10.已废除 11、已出库
									// ) 改为枚举类型 参照DeliveryConstant

	private String approvers;//审批人

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approveDate;//审批日期

	private String canceler;//撤销人

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cancelDate;//撤销日期

	private Long position;//持仓量

	private String remarks;//备注

	private String pickupPassword;

	private String idcardNum;

	private String address;
	private BigDecimal cost;
	private String receiver;
	private String tel;

	private String warehousename;

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
		this.commodityName = commodityName == null ? null : commodityName.trim();
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
		this.warehouseName = warehouseName == null ? null : warehouseName.trim();
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
		this.deliveryMethod = deliveryMethod == null ? null : deliveryMethod.trim();
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

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
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

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	@Override
	public String toString() {
		return "DeliveryOrder [deliveryorderId=" + deliveryorderId + ", commodityId=" + commodityId
				+ ", commodityName=" + commodityName + ", dealerId=" + dealerId + ", dealerName=" + dealerName
				+ ", warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", deliveryQuatity="
				+ deliveryQuatity + ", deliveryCounts=" + deliveryCounts + ", deliveryMethod="
				+ deliveryMethod + ", methodId=" + methodId + ", unit=" + unit + ", deliveryDate="
				+ deliveryDate + ", applyDate=" + applyDate + ", approvalStatus=" + approvalStatus
				+ ", approvers=" + approvers + ", approveDate=" + approveDate + ", canceler=" + canceler
				+ ", cancelDate=" + cancelDate + ", position=" + position + ", remarks=" + remarks + "]";
	}

}