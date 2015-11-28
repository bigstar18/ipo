package com.yrdce.ipo.modules.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

/**
 * 获取中签率具体方法
 * 
 * @author zyg
 *
 */
public class GetSuccessRate {

	public static org.slf4j.Logger logger = LoggerFactory.getLogger(GetSuccessRate.class);

	/**
	 * 中签率计算方法
	 * 
	 * @param ipoOrders
	 *            订单表中所有商品申购的信息
	 * @param ipoCommoditys
	 *            此次发布的商品信息
	 * @return
	 */
	public static Map<String, String> getSuccessRateByApplyCount(List<IpoOrder> ipoOrders, List<IpoCommodity> ipoCommoditys,
			IpoCommodityMapper ipoCommdityMapper) {
		// 根据商品编号统计客户申购数量 Map<商品编号,申购单位数>
		Map<String, Integer> orderCountByCommodityMap = new HashMap<String, Integer>();
		// 根据商品编号统计发行数量 Map<商品编号,发行数量>
		Map<String, Integer> disbutCountByCommodityMap = new HashMap<String, Integer>();
		// 每个商品的中签率 Map<商品编号，中签率>
		Map<String, String> successRateMap = new HashMap<String, String>();

		// 统计此次订单表中商品被客户申购的总数量
		// 统计申购单位数
		int applyPurCount = 0;
		if (ipoOrders != null || ipoOrders.size() > 0) {
			for (int i = 0; i < ipoOrders.size(); i++) {
				// 获取此次申购的商品信息
				IpoOrder ipoOrder = ipoOrders.get(i);
				// 判断当前产品在Map中是否存在，如果存在就将申购数量累加，如果不存在就直接存放Map中
				if (orderCountByCommodityMap.containsKey(ipoOrder.getCommodityid())) {
					applyPurCount = ipoOrder.getCounts();
					int count = orderCountByCommodityMap.get(ipoOrder.getCommodityid());
					applyPurCount += count;
					orderCountByCommodityMap.put(ipoOrder.getCommodityid(), applyPurCount);
				} else {
					orderCountByCommodityMap.put(ipoOrder.getCommodityid(), ipoOrder.getCounts());
				}
			}
		}
		logger.info("统计此次订单表中商品被客户申购的总数量：" + orderCountByCommodityMap);

		// 统计此次商品发布表中每个商品发布的总数量统计
		if (ipoCommoditys != null || ipoCommoditys.size() > 0) {
			for (int i = 0; i < ipoCommoditys.size(); i++) {
				// 获取每个产品信息
				IpoCommodity ipoCommodity = ipoCommoditys.get(i);
				// 判断当前产品在Map中是否存在，如果不存在就将商品编号和发布数量存放
				if (!disbutCountByCommodityMap.containsKey(ipoCommodity.getCommodityid())) {
					disbutCountByCommodityMap.put(ipoCommodity.getCommodityid(), ipoCommodity.getCounts());
				} else {
					logger.info("发布的商品有重复！");
				}
			}
		}
		logger.info("统计此次商品发布表中每个商品发布的总数量：" + disbutCountByCommodityMap);

		// 计算出每个商品的中签率 disbutCountByCommodityMap商品发布数量 ，orderCountByCommodityMap 商品申购的单位数
		if (disbutCountByCommodityMap != null) {
			// 获取发布商品信息Map的KEY值集合
			for (String orderkey : disbutCountByCommodityMap.keySet()) {
				// 根据商品编号获取发布数量
				int disCount = disbutCountByCommodityMap.get(orderkey);
				// 根据商品编号判断申购MAP中是否存在此商品
				if (orderCountByCommodityMap.containsKey(orderkey)) {
					// 根据商品编号获取申购的单位数
					int purCount = orderCountByCommodityMap.get(orderkey);
					// 获取申购单位
					int units = ipoCommdityMapper.selectByComid(orderkey.toUpperCase()).getUnits();
					// 中签率=股票发行股数/有效申购股数*申购单位
					double successRate = (double) disCount / (double) (purCount * units);
					// 将中签率转换为String类型存放到Map中
					String successRateStr = String.valueOf(successRate);
					successRateMap.put(orderkey, successRateStr);
				} else {
					logger.info("申购表中没有此产品的申够记录！");
				}
			}
		}
		logger.info("发布数量/申购单位数*1000 = 计算出每个商品的中签率 :" + successRateMap);
		return successRateMap;
	}

	/**
	 * 根据产生中签号码位数（长度）计算出中签起始于结束位数
	 * 
	 * @param length
	 * @return
	 */
	public static Map<Integer, Integer> getBallotNoStartLength(String ballotNo) {
		int length = ballotNo.length();
		Map<Integer, Integer> ballotNoLength = new HashMap<Integer, Integer>();
		// 长度必须大于0
		if (length > 0) {
			if (length == 1) {
				ballotNoLength.put(8, 8);
			} else if (length == 2) {
				ballotNoLength.put(7, 8);
			} else if (length == 3) {
				ballotNoLength.put(6, 8);
			} else if (length == 4) {
				ballotNoLength.put(5, 8);
			} else if (length == 5) {
				ballotNoLength.put(4, 8);
			} else if (length == 6) {
				ballotNoLength.put(3, 8);
			} else if (length == 7) {
				ballotNoLength.put(2, 8);
			} else if (length == 8) {
				ballotNoLength.put(1, 8);
			}
		} else {
			logger.info("产生的中签号码不符合规则！");
		}
		return ballotNoLength;
	}

	/**
	 * 根据字符串截取中签号码末三位数和起始位数于结束位数
	 * 
	 * @param ballotNosStr
	 * @return
	 */
	public static Map<String, Map<Integer, Integer>> getBallotNoEndThree(String ballotNosStr) {
		Map<String, Map<Integer, Integer>> ballotStartAndEndNum = new HashMap<String, Map<Integer, Integer>>();
		if (ballotNosStr != null || "".equals(ballotNosStr)) {
			// 根据“，”号截取每一位中签号码
			String[] strList = ballotNosStr.split(",");
			for (int i = 0; i < strList.length; i++) {
				// 获取中签号码
				String ballotNo = strList[i];
				// 根据中签号码获取起始和结束位数
				Map<Integer, Integer> ballotStartEndNum = getBallotNoStartLength(ballotNo);

				String ballotNoStr = "";
				if (ballotNo.length() > 3) {
					ballotNoStr = ballotNo.substring(ballotNo.length() - 3, ballotNo.length());
				} else if (strList.length == 3) {
					ballotNoStr = ballotNo;
				} else {
					ballotNoStr = ballotNo;
				}
				ballotStartAndEndNum.put(ballotNoStr, ballotStartEndNum);
			}
		}
		logger.info("根据字符串截取中签号码末三位数和起始位数于结束位数：" + ballotStartAndEndNum);
		return ballotStartAndEndNum;
	}
}
