package com.yrdce.ipo.common.utils;

import java.util.Random;

import com.yrdce.ipo.modules.sys.entity.FirmDistInfo;

public class CommodityDistribution {

	private int alldistNum;// 分配商品总量
	private int positionRatioNum;
	private int capitalRatioNum;
	private double distPositionRatio;// 分配持仓比例
	private double distCapitalRatio;// 分配资金比例

	public int getAlldistNum() {
		return alldistNum;
	}

	public void setAlldistNum(int alldistNum) {
		this.alldistNum = alldistNum;
	}

	// 构造初始化赋值
	public CommodityDistribution(int alldistNum, double distPositionRatio, double distCapitalRatio) {
		this.alldistNum = alldistNum;
		this.distPositionRatio = distPositionRatio / 100;
		this.distCapitalRatio = distCapitalRatio / 100;
		this.capitalRatioNum = (int) (alldistNum * distCapitalRatio);
		this.positionRatioNum = (int) (alldistNum * distPositionRatio);
	}

	// 初次分配主函数
	public FirmDistInfo distributionMain(FirmDistInfo firmDistInfo) {
		disCommodityByPosition(firmDistInfo);
		disCommodityByCapital(firmDistInfo);
		return firmDistInfo;
	}

	// 按持仓比例分配数量
	private void disCommodityByPosition(FirmDistInfo firmDistInfo) {
		int tempDistNumByPosition = (int) (this.positionRatioNum * firmDistInfo.getFirmPositionRatio());
		int result = firmDistInfo.getDistNum() + tempDistNumByPosition;
		if (this.alldistNum == 0) {
			return;
		}
		if (this.alldistNum < tempDistNumByPosition) {
			firmDistInfo.setDistNum(this.alldistNum);
			this.alldistNum = 0;
			return;
		}
		if (result > firmDistInfo.getMaxdistNum() && firmDistInfo.getMaxdistNum() != 0) {
			firmDistInfo.setDistNum(firmDistInfo.getMaxdistNum());
			this.alldistNum -= firmDistInfo.getMaxdistNum();
		} else {
			firmDistInfo.setDistNum(result);
			this.alldistNum -= result;
		}
		if (firmDistInfo.getDistNum() == firmDistInfo.getBuyNum()) {
			firmDistInfo.setFull(false);
		}

	}

	// 按资金比例分配数量
	private void disCommodityByCapital(FirmDistInfo firmDistInfo) {
		int tempDistNumByCapital = (int) (this.capitalRatioNum * firmDistInfo.getFirmCapitalRatio());
		int result = firmDistInfo.getDistNum() + tempDistNumByCapital;
		if (this.alldistNum == 0) {
			return;
		}
		if (this.alldistNum < tempDistNumByCapital) {
			firmDistInfo.setDistNum(this.alldistNum);
			this.alldistNum = 0;
			return;
		}
		if (result > firmDistInfo.getMaxdistNum() && firmDistInfo.getMaxdistNum() != 0) {
			firmDistInfo.setDistNum(firmDistInfo.getMaxdistNum());
			this.alldistNum -= firmDistInfo.getMaxdistNum();
		} else {
			firmDistInfo.setDistNum(result);
			this.alldistNum -= firmDistInfo.getMaxdistNum();
		}
		if (firmDistInfo.getDistNum() == firmDistInfo.getBuyNum()) {
			firmDistInfo.setFull(false);
		}
	}

	// 随机分配数量（再次分配）
	public FirmDistInfo disCommodityByRandom(FirmDistInfo firmDistInfo) {
		if (this.alldistNum != 0) {
			Random random = new Random();
			int result = random.nextInt(this.alldistNum);
			int tempDistNum = firmDistInfo.getDistNum() + result;
			if (tempDistNum > firmDistInfo.getBuyNum()) {
				tempDistNum = firmDistInfo.getBuyNum();
				result = firmDistInfo.getBuyNum() - firmDistInfo.getDistNum();
			}
			firmDistInfo.setDistNum(tempDistNum);
			this.alldistNum -= result;
		}
		if (firmDistInfo.getDistNum() == firmDistInfo.getBuyNum()) {
			firmDistInfo.setFull(false);
		}
		return firmDistInfo;
	}
}
