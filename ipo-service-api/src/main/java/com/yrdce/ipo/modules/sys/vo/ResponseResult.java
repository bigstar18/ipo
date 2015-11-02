package com.yrdce.ipo.modules.sys.vo;

public class ResponseResult {
	/*
	 * 一个返回类，用于返回jquery easyui封装的json串

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
	  
	
	
	

}
