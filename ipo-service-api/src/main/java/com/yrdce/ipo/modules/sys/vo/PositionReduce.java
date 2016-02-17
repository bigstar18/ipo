package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * ipo 持仓减持设置
 * 
 * @author wq 2016-2-16
 * 
 */
public class PositionReduce implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 849972266536664505L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * ipo持仓单号
	 */
	private Long positionFlowId;
	/**
	 * 减持比例
	 */
	private BigDecimal ratio;
	/**
	 * 减持数量
	 */
	private Long reduceqty;
	/**
	 * 减持日期
	 */
	private Date reduceDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改人
	 */
	private String updateUser;
	/**
	 * 修改时间
	 */
	private Date updateDate;
	/**
	 * 状态 1:未减持 2:已减持
	 */
	private int state;
	/**
	 * 状态 1:未减持 2:已减持
	 */
	private String stateName;
	/**
	 * 删除标记 0:有效 1:无效
	 */
	private int deleteFlag;
	
	
	// ------other--------
	/**
	 * 客户代码
	 */
	private String firmId;
	/**
	 * 商品代码
	 */
	private String commodityId;
	
	
	
	public PositionReduce() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPositionFlowId() {
		return positionFlowId;
	}

	public void setPositionFlowId(Long positionFlowId) {
		this.positionFlowId = positionFlowId;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	public Long getReduceqty() {
		return reduceqty;
	}

	public void setReduceqty(Long reduceqty) {
		this.reduceqty = reduceqty;
	}

	public Date getReduceDate() {
		return reduceDate;
	}

	public void setReduceDate(Date reduceDate) {
		this.reduceDate = reduceDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	
	
}
