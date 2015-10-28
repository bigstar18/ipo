package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;

public class Distribution<E> {

	private ArrayList<E> list = new ArrayList<E>();
	// 起始配号
	private int q;
	// 配号数量
	private int s;
	// 默认起始配号
	private int m = 1000;

	public void start() {
		if (q == m) {
			for (int i = 0; i < s; i++) {
				q = m++;
			}
		} else {
			for (int i = 0; i < s; i++) {
				q = +1;
			}
		}
	}
}
