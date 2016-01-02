package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
/**
 * 费用配置表
 * @author wq 2016-1-1
 *
 */
public class IpoChargeItem implements Serializable {
 
	private static final long serialVersionUID = -765283164428034852L;
	
	/**
     * 费用编码
     */
	private String id;
	/**
	 * 费用名称
	 */
	private String name;
	/**
	 * 费用类型,1:一次性费用,2:周期性费用
	 */
	private int type;
	/**
	 * 费用类型
	 */
	private String typeName;
	/**
	 * 父级费用编码
	 */
	private String parentId;
	/**
	 * 父级费用名称
	 */
	private String parentName;
	/**
	 * 排序
	 */
	private int sortId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记 0:有效 1:无效
	 */
	private int deleteFlag;
	
	
	
	 public IpoChargeItem() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public int getSortId() {
		return sortId;
	}


	public void setSortId(int sortId) {
		this.sortId = sortId;
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


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	 
	 
	 

}
