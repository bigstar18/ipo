package com.yrdce.ipo.modules.sys.vo;

public class Purchase {

	// 客户id
	private String userid;
	// 商品ID
	private String sid;
	// 商品申购数量
	private int count;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
