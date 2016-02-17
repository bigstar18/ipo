package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * @ClassName: BrokerageMemberReport
 * @Description: 经纪会员报表
 * @author bob
 */
public interface BrokerageReportService {

	/**
	 * @Title: getBroker
	 * @Description: 查询经纪会员交易商账号
	 */
	List<VBrBroker> getBroker();

	/**
	 * @Title: getBillfladInfo
	 * @Description: 获取经纪会员的提货单信息
	 */
	List<Billoflading> getBillfladInfo(String brokerid, String time);

	/**
	 * @Title: getDeliveryInfo
	 * @Description: 获取经纪会员的提货信息
	 */
	List<Delivery> getDeliveryInfo(String brokerid, String time);

	/**
	 * @Title: getHoldInfo
	 * @Description: 获取经纪会员的持仓信息
	 */
	List<Holdcommodity> getHoldInfo(String brokerid, String time);

	/**
	 * @Title: getReleaInfo
	 * @Description: 获取经纪会员的发行申购信息
	 */
	List<Releasesubscription> getReleaInfo(String brokerid, String time);
}
