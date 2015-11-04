package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.dao.IpoBallotNoInfoMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;

/**
 * 摇号处理类
 * 
 * @author zyg
 *
 */
public class GetBallotNoUtils {

	//配号业务处理
	private static IpoDistributionMapper ipoDistrMapper;
	//订单业务处理
	private static IpoOrderMapper ipoOrderMapper;
	//商品业务处理
	private static IpoCommodityMapper ipoCommdityMapper;
	//中签信息业务处理
	private static IpoBallotNoInfoMapper ipoBallotNoInfoMapper;

	// 执行摇号处理开始
	public static void start() {
		executeApplyBallotNo();
	}

	// 执行摇号处理执行方法
	public static void executeApplyBallotNo() {
		// 新股摇号规则
		MathUtil util = new MathUtil();
		// 产品编号,中签号码,商品对应的中签号码
		Map<String, String> commdityCorreSuccessNo = new HashMap<String, String>();
		// 根据当前时间T-2调用查询所有商品列表Service------------------------------------------------------//调用高波的查询方法
		List<IpoCommodity> ipoCommodityList =ipoCommdityMapper.selectByExample(new IpoCommodityExample());
		// 根据当前时间T-2调用查询所有订单列表Service------------------------------------------------------//调用高波的查询方法
		List<IpoOrder> ipoOrders = ipoOrderMapper.selectAll();
		//查询订单表中的商品编号
		List<String> commdityIdList = ipoOrderMapper.select();
		
		//将订单中的商品编号存放到Map中
		Map<String,String> commdityIdsMap = new HashMap<String,String>();
        if(commdityIdList != null || commdityIdList.size()> 0){
        	for(int i=0;i < commdityIdList.size();i++)
        		commdityIdsMap.put(commdityIdList.get(i), commdityIdList.get(i));
        }
        //将订单里面的商品编号和商品表进行匹配
        List<IpoCommodity> ipoCommoditys = new ArrayList<IpoCommodity>();
        if(ipoCommodityList != null || ipoCommodityList.size() > 0){
        	for(int j=0;j < ipoCommodityList.size();j++){
        		IpoCommodity ipoCommdi = ipoCommodityList.get(j);
        		if(commdityIdsMap.containsKey(ipoCommdi.getCommodityid())){
        			ipoCommoditys.add(ipoCommdi);
        		}
        	}
        }

		// ========1. 获取每个商品的中签率=====
		Map<String, String> successRateMap = GetSuccessRate.getSuccessRateByApplyCount(ipoOrders, ipoCommoditys);
		if (successRateMap != null) {
			for (String commdityId : successRateMap.keySet()) {
				String successRateStr = successRateMap.get(commdityId);
				// 将中签率转换为double
				double successRate = Double.valueOf(successRateStr);
				// ========2. 根据中签率获取中签号码=========
				List<String> result = util.getRandomResult(successRate, 0);
				// 中签号码字符串
				String successNoStr = "";
				if (result != null || result.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						successNoStr = result.get(i) + ",";
					}
				}
				// 按照产品编号，中签号码,商品对应的中签号码顺序存放到Map中
				commdityCorreSuccessNo.put(commdityId, successNoStr);
			}
		}

		// -----------------------------------根据系统时间T-2获取配号信息（高波）
		// 获取当前系统时间
		Date systemTime = new Date();
		List<IpoDistribution> ipoDistrList = ipoDistrMapper.selectAll();

		// ==========3. 根据中签号码计算出用户商品对应的中签配号数量并且更新配号结果表===========
		calculateCommdityOfUserSuccessNoCount(commdityCorreSuccessNo, ipoDistrList);

		// ===========4. 取出商品编号，中签号码后三位数，中签起始位数，结束位数存放入列表=======
		List<IpoBallotNoInfo> ipoBallotNoInfoList = new ArrayList<IpoBallotNoInfo>();//中签信息列表对象
		if (commdityCorreSuccessNo != null) {
			for (String commdityId : commdityCorreSuccessNo.keySet()) {
				// 中签号码，格式“，”号隔开字符串
				String ballotStr = commdityCorreSuccessNo.get(commdityId);
				// 根据字符串截取中签号码末三位数,中签号码起始位数，结束位数集合
				Map<String, Map<Integer, Integer>> ballotNoStartEndNumMap = GetSuccessRate
						.getBallotNoEndThree(ballotStr);
				// 调用插入IPO_BALLOTNO_INFO表的Dao里面的插入方法----------------------------------------------------------
				// 将产品编号和中签后三位数入库
				if (ballotNoStartEndNumMap != null) {
					for (String ballotNoThree : ballotNoStartEndNumMap.keySet()) {
						// ballotNoThree末三位数
						Map<Integer, Integer> ballotStartEndNumMap = ballotNoStartEndNumMap.get(ballotNoThree);
						//中签信息对象
						IpoBallotNoInfo ipoBallotNoInfo = new IpoBallotNoInfo();
						if (ballotStartEndNumMap != null) {
							//给中签信息对象赋值
							ipoBallotNoInfo.setCommodityId(commdityId);
							ipoBallotNoInfo.setBallotNo(ballotNoThree);
							ipoBallotNoInfo.setCreateTime(new Date());
							if (ballotStartEndNumMap != null) {
								for (Integer start : ballotStartEndNumMap.keySet()) {
									ipoBallotNoInfo.setBallotNoStartLen(start);
									ipoBallotNoInfo.setBallotNoStartLen(ballotStartEndNumMap.get(start));
								}
							}
						}
						ipoBallotNoInfoList.add(ipoBallotNoInfo);
					}
				}
			}
		}
		
		// 5. =========将中签对象列表统一入库==========
        if(ipoBallotNoInfoList != null || ipoBallotNoInfoList.size() > 0){
        	for(int i =0;i < ipoBallotNoInfoList.size();i++){
        		IpoBallotNoInfo ipobal = ipoBallotNoInfoList.get(i);
        		//调用入库方法------------------------------高波提供
        		ipoBallotNoInfoMapper.insert(ipobal);
        	}
        }
		

	}

	/**
	 * 根据中签号码计算出用户商品对应的中签号码数量
	 * 
	 * @param commdityCorreSuccessNo
	 * @param ipoDistrList
	 */
	public static void calculateCommdityOfUserSuccessNoCount(Map<String, String> commdityCorreSuccessNo,
			List<IpoDistribution> ipoDistrList) {
		if (ipoDistrList != null || ipoDistrList.size() > 0) {
			for (int i = 0; i < ipoDistrList.size(); i++) {
				IpoDistribution ipoDis = ipoDistrList.get(i);
				String commdityId = ipoDis.getCommodityid();
				// 判断配号列表中产品与Map<商品编号，中签号码>中商品编号相同
				if (commdityCorreSuccessNo.containsKey(commdityId)) {
					// 获取中签号码字符串
					String ballotNoStr = commdityCorreSuccessNo.get(commdityId);
					// 取出Map中商品编号对应中签号码字符串
					String[] ballotNos = ballotNoStr.split(",");
					int g = 0;
					while (g < ballotNos.length) {
						String ballotNo = ballotNos[g];
						// 根据每一位中签号码获取每个用户对应商品的中签数量
						getBallotNoCount(ipoDistrList, ballotNo);
						g++;
					}
				}
			}

		}

		// if (commdityCorreSuccessNo != null) {
		// for (String key : commdityCorreSuccessNo.keySet()) {
		// // 获取各个商品的中签号码
		// String ballotStr = commdityCorreSuccessNo.get(key);
		// String[] ballotNos = ballotStr.split(",");
		// int g = 0;
		// while (g < ballotNos.length) {
		// String ballotNo = ballotNos[g];
		// getBallotNoCount(ipoDistrList, ballotNo);
		// g++;
		// }
		//
		// }
		// }

	}

	public static void getBallotNoCount(List<IpoDistribution> ipoDistrList, String ballotNo) {
		// 形成一个新的配号列表
		List<IpoDistribution> newIpoDistributionList = new ArrayList<IpoDistribution>();
		if (ipoDistrList != null || ipoDistrList.size() > 0) {
			for (int i = 0; i < ipoDistrList.size(); i++) {
				IpoDistribution newIpoDis = new IpoDistribution();
				IpoDistribution ipoDis = ipoDistrList.get(i);
				// 用户编号
				String userId = ipoDis.getUserid();
				// 产品编号
				String commdityId = ipoDis.getCommodityid();
				// 配号起始号
				long startNum = ipoDis.getStartnumber();
				// 配号数量
				int count = ipoDis.getPcounts();
				// 配号时间
				Date ipoTime = ipoDis.getPtime();
				// 中签数量
				int ipoDisZcounts = ipoDis.getZcounts();

				// 取出对应商品所有配号
				List distrNos = new ArrayList();
				for (int j = 0; i < count; j++) {
					distrNos.add(startNum + j);
				}

				// 用此用户生成的配号去和中签号码比对，查看中签的号码的数量
				int f = 0;
				while (f < distrNos.size()) {
					// 获取每一个中签号码
					String disNo = distrNos.get(f).toString();
					String disNoDigit = disNo.substring(disNo.length() - ballotNo.length(), disNo.length());
					if (ballotNo.equals(disNoDigit)) {
						ipoDisZcounts = ipoDisZcounts + 1;
					}
					f++;
				}

				// 新配号列表只需要存储 用户编号，商品编号，中签数量
				newIpoDis.setUserid(userId);
				newIpoDis.setCommodityid(commdityId);
				newIpoDis.setZcounts(ipoDisZcounts);
				newIpoDistributionList.add(newIpoDis);

			}

			// 根据用户编号，商品编号作为更新条件去更新中签数量
			if (newIpoDistributionList != null || newIpoDistributionList.size() > 0) {
				for (int i = 0; i < newIpoDistributionList.size(); i++) {
					IpoDistribution ipoDistribution = newIpoDistributionList.get(i);
					// 调用更新方法----------------------//后期需添加，时间作为条件
					ipoDistrMapper.updateBycomAndUserid(ipoDistribution);
				}

			}

		}
	}

}
