package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

/**
 * 中签信息表
 * @author zyg
 *
 */
public class IpoBallotNoInfo {

	private int id;//ID
	
	private String commodityid;//商品编号
	
	private int ballotnostartlen;//中签起始位数
	
	private int ballotnoendlen;//中签结束位数
	
	private String ballotno;//中签号
	
	private Date createtime;//生成时间
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public int getBallotnostartlen() {
		return ballotnostartlen;
	}

	public void setBallotnostartlen(int ballotnostartlen) {
		this.ballotnostartlen = ballotnostartlen;
	}

	public int getBallotnoendlen() {
		return ballotnoendlen;
	}

	public void setBallotnoendlen(int ballotnoendlen) {
		this.ballotnoendlen = ballotnoendlen;
	}

	public String getBallotno() {
		return ballotno;
	}

	public void setBallotno(String ballotno) {
		this.ballotno = ballotno;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
