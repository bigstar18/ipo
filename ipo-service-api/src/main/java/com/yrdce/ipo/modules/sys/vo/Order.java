package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8285225304887656105L;

	@JsonProperty("orderid")
	@XmlElement(name = "orderid")
	private String orderid;// 订单

	// 交易商id
	@JsonProperty("userid")
	@XmlElement(name = "userid")
	private String userid;// 交易商id

	// 商品编号
	@JsonProperty("commodityid")
	@XmlElement(name = "commodityid")
	private String commodityid;

	// 商品名称
	@JsonProperty("commodityname")
	@XmlElement(name = "commodityname")
	private String commodityname;

	// 申购 量
	@JsonProperty("counts")
	@XmlElement(name = "counts")
	private int counts;

	// 申购时间
	@JsonProperty("createtime")
	@XmlElement(name = "createtime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createtime;

	// 资金冻结
	@JsonProperty("frozenfunds")
	@XmlElement(name = "frozenfunds")
	private BigDecimal frozenfunds;

	@JsonProperty("commodity_id")
	@XmlElement(name = "commodity_id")
	private Integer commodity_id;// 发售表主键ID

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Integer getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname == null ? null : commodityname.trim();
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getFrozenfunds() {
		return frozenfunds;
	}

	public void setFrozenfunds(BigDecimal frozenfunds) {
		this.frozenfunds = frozenfunds;
	}
}