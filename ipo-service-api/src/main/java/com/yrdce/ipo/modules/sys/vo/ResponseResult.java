package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

public class ResponseResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7154114444244471776L;

	/*
	 * 一个返回类，用于返回jquery easyui封装的json串
	 * 
	 */
	private int total;

	private Object rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "ResponseResult [total=" + total + ", rows=" + rows + "]";
	}

}
