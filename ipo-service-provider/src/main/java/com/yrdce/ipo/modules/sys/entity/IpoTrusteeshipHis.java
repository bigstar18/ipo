package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 托管商品历史记录
 * 
 * @author wq 2015-12-24
 * 
 */
public class IpoTrusteeshipHis implements Serializable {
 
	private static final long serialVersionUID = 7847465847296871053L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 托管商品id
	 */
	private Long trusteeshipId;
	/**
	 * 申请的状态1:申请,2:撤销,3:仓库初审通过,4:仓库初审驳回, 5:仓库终审通过,6:仓库终审驳回,7:已增持加仓,8:已设置预减持
	 */
	private int state;
	/**
	 * 内容
	 */
	 private String content;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 创建人名称
	 */
	private String createUserName;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 备注
	 */
	private String remark;
	

	public IpoTrusteeshipHis() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTrusteeshipId() {
		return trusteeshipId;
	}

	public void setTrusteeshipId(Long trusteeshipId) {
		this.trusteeshipId = trusteeshipId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 
	
	
    
}
