package com.yrdce.ipo.modules.sys.entity;

/**
 * li 用于交易商摇号分配
 */
public class FirmDistInfo {
	private String firmId;// 交易商id
	private double firmPositionRatio;// 交易商的持仓比例
	private double firmCapitalRatio;// 交易商资金比例
	private int distNum;// 中签数量
	private int maxdistNum;

	public int getMaxdistNum() {
		return maxdistNum;
	}

	public void setMaxdistNum(int maxdistNum) {
		this.maxdistNum = maxdistNum;
	}

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public double getFirmPositionRatio() {
		return firmPositionRatio;
	}

	public void setFirmPositionRatio(double firmPositionRatio) {
		this.firmPositionRatio = firmPositionRatio;
	}

	public double getFirmCapitalRatio() {
		return firmCapitalRatio;
	}

	public void setFirmCapitalRatio(double firmCapitalRatio) {
		this.firmCapitalRatio = firmCapitalRatio;
	}

	public int getDistNum() {
		return distNum;
	}

	public void setDistNum(int distNum) {
		this.distNum = distNum;
	}

}
