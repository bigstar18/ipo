package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Commodity  implements Serializable {
	

	@JsonProperty("commodityid")
	@XmlElement(name = "commodityid")
	@NotNull
	@Size(min = 1, max = 32)
	private String    commodityid;                   //商品代码

	@JsonProperty("commodityname")
	@XmlElement(name = "commodityname")
	@NotNull
	@Size(min = 1, max = 32)
	private String commodityname;                //商品名称
	
	
	@JsonProperty("price")
	@XmlElement(name = "price")
	@NotNull
	private double  price;              //发售价格
	
	@JsonProperty("units")
	@XmlElement(name = "units")
	@NotNull
	private   int units ;              //配售单位
	
	@JsonProperty("starttime")
	@XmlElement(name = "starttime")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date starttime;                      //发售日期
	
	
	@JsonProperty("endtime")
	@XmlElement(name = "endtime")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endtime;                      //截止日期
	
		public Commodity() {
		super();
	}

		public Commodity(String commodityid, String commodityname, double price,
			int units, Date starttime, Date endtime) {
		super();
		this.commodityid = commodityid;
		this.commodityname = commodityname;
		this.price = price;
		this.units = units;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date date) {
		this.starttime = date;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "商品 [商品编码=" + commodityid + ", 商品名称="
				+ commodityname + ", 发售价格=" + price + ", 配售单位=" + units
				+ ", 发售日期=" + starttime + ", 截止日期=" + endtime + "]";
	}

}
