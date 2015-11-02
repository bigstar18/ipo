package com.yrdce.ipo.modules.sys.vo;

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
public class Distribution {
        
	@JsonProperty("userid")
	@XmlElement(name = "userid")
	@NotNull
	@Size(min = 1, max = 32)
	private String    userid;                   //客户编码

	@JsonProperty("commodityname")
	@XmlElement(name = "commodityname")
	@NotNull
	@Size(min = 1, max = 32)
	private String commodityname;                //商品名称
	
	
	@JsonProperty("startnumber")
	@XmlElement(name = "startnumber")
	@NotNull
	private int  startnumber;              //起始配号
	
	@JsonProperty("pcounts")
	@XmlElement(name = "pcounts")
	@NotNull
	private   int pcounts ;              //配号数量
	
	@JsonProperty("ptime")
	@XmlElement(name = "ptime")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date ptime;                      //配号时间

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public int getStartnumber() {
		return startnumber;
	}

	public void setStartnumber(int startnumber) {
		this.startnumber = startnumber;
	}

	public int getPcounts() {
		return pcounts;
	}

	public void setPcounts(int pcounts) {
		this.pcounts = pcounts;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
