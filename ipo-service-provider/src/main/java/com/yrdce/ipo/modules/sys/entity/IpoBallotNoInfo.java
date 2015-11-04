package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

/**
 * 中签信息表
 * @author zyg
 *
 */
public class IpoBallotNoInfo {

	private int id;//ID
	
	private String commodityId;//商品编号
	
	private int ballotNoStartLen;//中签起始位数
	
	private int ballotNoEndLen;//中签结束位数
	
	private String ballotNo;//中签号
	
	private Date createTime;//生成时间
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommodityId() {
		 return commodityId;
	}

	public void setCommodityId(String commodityId) {
		 this.commodityId = commodityId == null ? null : commodityId.trim();
	}

	public int getBallotNoStartLen() {
		return ballotNoStartLen;
	}

	public void setBallotNoStartLen(int ballotNoStartLen) {
		this.ballotNoStartLen = ballotNoStartLen;
	}

	public int getBallotNoEndLen() {
		return ballotNoEndLen;
	}

	public void setBallotNoEndLen(int ballotNoEndLen) {
		this.ballotNoEndLen = ballotNoEndLen;
	}

	public String getBallotNo() {
		return ballotNo;
	}

	public void setBallotNo(String ballotNo) {
		this.ballotNo = ballotNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
