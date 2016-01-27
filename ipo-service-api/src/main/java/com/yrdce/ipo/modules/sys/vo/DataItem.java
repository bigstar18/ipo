package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

/**
 * 数据项
 * @author wq 2016-1-1
 *
 */
public class DataItem implements Serializable {

	private static final long serialVersionUID = 9162734443297168709L;
	
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 值
	 */
	private String value;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 备注
	 */
	private String remark;

	public DataItem() {}
	
	public DataItem(String code, String type) {
		this.code = code;
		this.type = type;
	}



	public DataItem(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
