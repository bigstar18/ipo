package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
/**
 * 数据项
 * @author wq 2016-1-1
 *
 */
public class IpoDataItem implements Serializable {
 
	private static final long serialVersionUID = 7872413832166741294L;
	
	/**
     * 编码
     */
	private String  code;
	/**
	 * 值
	 */
	private String  value;
	/**
	 * 类别
	 */
	private String  type;
	/**
	 * 备注
	 */
	private String  remark;
	/**
	 * 删除标记 0:有效 1:无效
	 */
	private int deleteFlag;
	
	public IpoDataItem() {}
	

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

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
	
}
