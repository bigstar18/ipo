package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发行会员转持仓
 * 
 * @author chenjing
 *
 */
public class IpoPublisherPosition {
	private Long positionid;

	private String publisherid;// 发行会员代码

	private String publishername;// 发行会员名称

	private String commodityid;// 商品代码

	private String commodityname;// 商品名称

	private BigDecimal totalvalue;// 总市值

	private Long pubposition;// 转持仓

	private Long salecounts;// 转发售数量

	private Long totalcounts;// 总数量

	private Short status;// 状态（1、新增 2、已冻结费用 3、已扣费 4、已转持仓）

	private String creater;

	private Date createdate;

	private String updater;

	private Date updatedate;

	private String storageid;

	public String getStorageid() {
		return storageid;
	}

	public void setStorageid(String storageid) {
		this.storageid = storageid;
	}

	public String getPublisherid() {
		return publisherid;
	}

	public void setPublisherid(String publisherid) {
		this.publisherid = publisherid == null ? null : publisherid.trim();
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public BigDecimal getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(BigDecimal totalvalue) {
		this.totalvalue = totalvalue;
	}

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}

	public Long getPubposition() {
		return pubposition;
	}

	public void setPubposition(Long pubposition) {
		this.pubposition = pubposition;
	}

	public Long getSalecounts() {
		return salecounts;
	}

	public void setSalecounts(Long salecounts) {
		this.salecounts = salecounts;
	}

	public Long getTotalcounts() {
		return totalcounts;
	}

	public void setTotalcounts(Long totalcounts) {
		this.totalcounts = totalcounts;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater == null ? null : creater.trim();
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater == null ? null : updater.trim();
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

}