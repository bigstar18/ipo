package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author chenjing
 *
 */
public class Outbound implements Serializable {
	private String outboundorderid;

	private String deliveryorderid;

	private Integer outboundstate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date outbounddate;

	private String operatorid;

	private String auditorid;

	private String warehouseid;// 关联BI_WAREHOUSE表的主键 Long 类型的ID

	private String deliveryperson;

	private String sex;

	private String idtype;

	private String idnum;

	public String getOutboundorderid() {
		return outboundorderid;
	}

	public void setOutboundorderid(String outboundorderid) {
		this.outboundorderid = outboundorderid == null ? null : outboundorderid
				.trim();
	}

	public String getDeliveryorderid() {
		return deliveryorderid;
	}

	public void setDeliveryorderid(String deliveryorderid) {
		this.deliveryorderid = deliveryorderid == null ? null : deliveryorderid
				.trim();
	}

	public Integer getOutboundstate() {
		return outboundstate;
	}

	public void setOutboundstate(Integer outboundstate) {
		this.outboundstate = outboundstate;
	}

	public Date getOutbounddate() {
		return outbounddate;
	}

	public void setOutbounddate(Date outbounddate) {
		this.outbounddate = outbounddate;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid == null ? null : operatorid.trim();
	}

	public String getAuditorid() {
		return auditorid;
	}

	public void setAuditorid(String auditorid) {
		this.auditorid = auditorid == null ? null : auditorid.trim();
	}

	public String getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid == null ? null : warehouseid.trim();
	}

	public String getDeliveryperson() {
		return deliveryperson;
	}

	public void setDeliveryperson(String deliveryperson) {
		this.deliveryperson = deliveryperson == null ? null : deliveryperson
				.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype == null ? null : idtype.trim();
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum == null ? null : idnum.trim();
	}
}