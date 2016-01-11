package com.yrdce.ipo.modules.sys.entity;

/**
 * 发行商的承销会员查询
 * 
 * @author chenjing
 *
 */
public class IpoUnderWriters {
	private Long subscribeid;

	private String underwriterid;// 承销商ID

	private String commodityid;// 商品ID

	private String underwritername;// 承销商姓名

	private String commodityname;// 商品姓名

	private String pubmemberid;// 发行商代码

	public Long getSubscribeid() {
		return subscribeid;
	}

	public void setSubscribeid(Long subscribeid) {
		this.subscribeid = subscribeid;
	}

	public String getUnderwriterid() {
		return underwriterid;
	}

	public void setUnderwriterid(String underwriterid) {
		this.underwriterid = underwriterid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public String getUnderwritername() {
		return underwritername;
	}

	public void setUnderwritername(String underwritername) {
		this.underwritername = underwritername;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public String getPubmemberid() {
		return pubmemberid;
	}

	public void setPubmemberid(String pubmemberid) {
		this.pubmemberid = pubmemberid;
	}

	@Override
	public String toString() {
		return "UnderWriters [subscribeid=" + subscribeid + ", underwriterid="
				+ underwriterid + ", commodityid=" + commodityid
				+ ", underwritername=" + underwritername + ", commodityname="
				+ commodityname + ", pubmemberid=" + pubmemberid + "]";
	}

}