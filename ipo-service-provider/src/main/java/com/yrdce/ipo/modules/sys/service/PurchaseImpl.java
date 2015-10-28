package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.modules.sys.entity.FFirmfunds;

public class PurchaseImpl implements Purchase {

	// 客户id
	private String userid;
	// 商品ID
	private String sid;
	// 商品申购数量
	private int count;

	private FFirmfunds funds;

	@Override
	public int apply(String id, int price, int count) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FFirmfunds get() {
		return funds;

	}
}
