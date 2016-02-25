package com.yrdce.ipo.common.utils;

public class CommodityDistribution {
	private String firmId;// 交易商id
	private double firmPositionRatio;// 交易商的持仓比例
	private double firmCapitalRatio;// 交易商资金比例
	private int distNum;// 中签数量

	private int maxdistNum;// 最大中签数
	private int alldistNum;// 分配商品总量
	private double distPositionRatio;// 分配持仓比例
	private double distCapitalRatio;// 分配资金比例

	public int getDistNum() {
		return distNum;
	}

	public void setDistNum(int distNum) {
		this.distNum = distNum;
	}

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public int getMaxdistNum() {
		return maxdistNum;
	}

	public void setMaxdistNum(int maxdistNum) {
		this.maxdistNum = maxdistNum;
	}

	public int getAlldistNum() {
		return alldistNum;
	}

	public void setAlldistNum(int alldistNum) {
		this.alldistNum = alldistNum;
	}

	public double getDistPositionRatio() {
		return distPositionRatio;
	}

	public void setDistPositionRatio(double distPositionRatio) {
		this.distPositionRatio = distPositionRatio;
	}

	public double getDistCapitalRatio() {
		return distCapitalRatio;
	}

	public void setDistCapitalRatio(double distCapitalRatio) {
		this.distCapitalRatio = distCapitalRatio;
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

	public void distributionMain() {
		disCommodityByPosition();
		disCommodityByCapital();
	}

	// 按持仓比例分配数量
	private void disCommodityByPosition() {
		int tempDistNumByPosition = (int) (this.alldistNum * this.distPositionRatio * this.firmPositionRatio);
		this.distNum += tempDistNumByPosition;
	}

	// 按资金比例分配数量
	private void disCommodityByCapital() {
		int tempDistNumByCapital = (int) (this.alldistNum * this.distCapitalRatio * this.firmCapitalRatio);
		this.distNum += tempDistNumByCapital;
	}

	// // 随机分配数量
	// private void disCommodityByRandom() {
	// int remainingNum=this.alldistNum-this.dist
	// int tempDistNumByRandom=
	// }
}
