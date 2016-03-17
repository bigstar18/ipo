package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

/**
 * @ClassName: FundSettlement
 * @Description: 资金结算报表
 * @author bob
 */
public class FundSettlement {
	private BigDecimal lastBalance;//上日资金余额

	private BigDecimal lastSettleMargin;//上日保证金

	private BigDecimal settleMargin;//当日保证金

	private BigDecimal payment;//货款

	private BigDecimal deposit;//入金

	private BigDecimal withdrawal;//出金

	private BigDecimal otherSale;//发售当日其他项

	private BigDecimal saleDelivery;//发售交货费用

	private BigDecimal issuedServiceFee;//发行服务费

	private BigDecimal purchaseMoney;//申购金额

	private BigDecimal transactionCost;//交易费用

	private BigDecimal otherSystem;//其他交易系统

	private BigDecimal balance;//当日资金余额

	private BigDecimal advancePayment;//预付货款

	private BigDecimal hisPurchaseMoney;//历史申购金额

	private BigDecimal marketValue;//当日持有市值

	private BigDecimal tradeEquity;//当日交易商权益

	public BigDecimal getLastBalance() {
		return lastBalance;
	}

	public void setLastBalance(BigDecimal lastBalance) {
		this.lastBalance = lastBalance;
	}

	public BigDecimal getLastSettleMargin() {
		return lastSettleMargin;
	}

	public void setLastSettleMargin(BigDecimal lastSettleMargin) {
		this.lastSettleMargin = lastSettleMargin;
	}

	public BigDecimal getSettleMargin() {
		return settleMargin;
	}

	public void setSettleMargin(BigDecimal settleMargin) {
		this.settleMargin = settleMargin;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(BigDecimal withdrawal) {
		this.withdrawal = withdrawal;
	}

	public BigDecimal getOtherSale() {
		return otherSale;
	}

	public void setOtherSale(BigDecimal otherSale) {
		this.otherSale = otherSale;
	}

	public BigDecimal getSaleDelivery() {
		return saleDelivery;
	}

	public void setSaleDelivery(BigDecimal saleDelivery) {
		this.saleDelivery = saleDelivery;
	}

	public BigDecimal getIssuedServiceFee() {
		return issuedServiceFee;
	}

	public void setIssuedServiceFee(BigDecimal issuedServiceFee) {
		this.issuedServiceFee = issuedServiceFee;
	}

	public BigDecimal getPurchaseMoney() {
		return purchaseMoney;
	}

	public void setPurchaseMoney(BigDecimal purchaseMoney) {
		this.purchaseMoney = purchaseMoney;
	}

	public BigDecimal getTransactionCost() {
		return transactionCost;
	}

	public void setTransactionCost(BigDecimal transactionCost) {
		this.transactionCost = transactionCost;
	}

	public BigDecimal getOtherSystem() {
		return otherSystem;
	}

	public void setOtherSystem(BigDecimal otherSystem) {
		this.otherSystem = otherSystem;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getAdvancePayment() {
		return advancePayment;
	}

	public void setAdvancePayment(BigDecimal advancePayment) {
		this.advancePayment = advancePayment;
	}

	public BigDecimal getHisPurchaseMoney() {
		return hisPurchaseMoney;
	}

	public void setHisPurchaseMoney(BigDecimal hisPurchaseMoney) {
		this.hisPurchaseMoney = hisPurchaseMoney;
	}

	public BigDecimal getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}

	public BigDecimal getTradeEquity() {
		return tradeEquity;
	}

	public void setTradeEquity(BigDecimal tradeEquity) {
		this.tradeEquity = tradeEquity;
	}
}
