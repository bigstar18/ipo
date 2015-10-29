package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

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
	
	@JsonProperty("start_time")
	@XmlElement(name = "start_time")
	@NotNull
	private String start_time;                      //发售日期
	
	
	@JsonProperty("end_time")
	@XmlElement(name = "end_time")
	@NotNull
	private String end_time;                      //截止日期
	
		public Commodity() {
		super();
	}

		public Commodity(String commodityid, String commodityname, double price,
			int units, String start_time, String end_time) {
		super();
		this.commodityid = commodityid;
		this.commodityname = commodityname;
		this.price = price;
		this.units = units;
		this.start_time = start_time;
		this.end_time = end_time;
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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "商品 [商品编码=" + commodityid + ", 商品名称="
				+ commodityname + ", 发售价格=" + price + ", 配售单位=" + units
				+ ", 发售日期=" + start_time + ", 截止日期=" + end_time + "]";
	}

}
