package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易商持仓汇总
 * @author wq 2016-1-12
 *
 */
public class TFirmHoldSum implements Serializable{
     
	private static final long serialVersionUID = 3656111479337004791L;
	
	
	/**
     * 交易商id
     */
	private String firmId;
	/**
	 * 商品代码
	 */
	private String commodityId;
	/**
	 * 买卖标志 1:买 2：卖
	 */
	private int bsFlag;
	/**
	 * 持仓数量 		
	 */
	private Long  holdqty;
	/**
	 * 持仓金额
	 */
	private BigDecimal holdFunds;
	/**
	 * 浮动盈亏 		
	 */
	private BigDecimal floatingLoss;
	/**
	 * 持仓均价
	 */
	private BigDecimal evenPrice;	 	
	/**
	 * 实时保证金
	 */
	private BigDecimal holdMargin;	 
	/**
	 * 抵顶数量
	 */
	private Long  gageqty;	 
	/**
	 * 持仓担保金
	 */
	private BigDecimal holdAssure;
	
	
	public TFirmHoldSum() {
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


	public int getBsFlag() {
		return bsFlag;
	}


	public void setBsFlag(int bsFlag) {
		this.bsFlag = bsFlag;
	}


	public Long getHoldqty() {
		return holdqty;
	}


	public void setHoldqty(Long holdqty) {
		this.holdqty = holdqty;
	}


	public BigDecimal getHoldFunds() {
		return holdFunds;
	}


	public void setHoldFunds(BigDecimal holdFunds) {
		this.holdFunds = holdFunds;
	}


	public BigDecimal getFloatingLoss() {
		return floatingLoss;
	}


	public void setFloatingLoss(BigDecimal floatingLoss) {
		this.floatingLoss = floatingLoss;
	}


	public BigDecimal getEvenPrice() {
		return evenPrice;
	}


	public void setEvenPrice(BigDecimal evenPrice) {
		this.evenPrice = evenPrice;
	}


	public BigDecimal getHoldMargin() {
		return holdMargin;
	}


	public void setHoldMargin(BigDecimal holdMargin) {
		this.holdMargin = holdMargin;
	}


	public Long getGageqty() {
		return gageqty;
	}


	public void setGageqty(Long gageqty) {
		this.gageqty = gageqty;
	}


	public BigDecimal getHoldAssure() {
		return holdAssure;
	}


	public void setHoldAssure(BigDecimal holdAssure) {
		this.holdAssure = holdAssure;
	}
	
	
	
	 
		 

}
