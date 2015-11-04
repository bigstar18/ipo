package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.common.utils.ThreadClassTemplet;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;

/**
 * 获取中签率具体方法
 * @author zyg
 *
 */
public class GetSuccessRate {
	public static Logger logger = Logger.getLogger(GetSuccessRate.class);
	public static Map<String,String>  getSuccessRateByApplyCount(List<IpoOrder> ipoOrders,List<IpoCommodity> ipoCommoditys){
		// 根据商品编号统计客户申购数量
		Map<String, Integer> orderCountByCommodityMap = new HashMap<String, Integer>();
		// 根据商品编号统计发行数量
		Map<String, Integer> disbutCountByCommodityMap = new HashMap<String, Integer>();
        //每个商品的中签率
		Map<String,String> successRateMap = new HashMap<String,String>();
		
		// 统计每个商品被客户申购的总数量
		// 统计申购单位数
		int applyPurCount = 0;
		if (ipoOrders != null || ipoOrders.size() > 0) {
			for (int i = 0; i < ipoOrders.size(); i++) {
				//获取每个产品信息
				IpoOrder ipoOrder = ipoOrders.get(i);
				//判断当前产品在Map中是否存在，如果存在就将申购数量累加，如果不存在就直接存放Map中
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

		// 每个商品发布的总数量统计
		if (ipoCommoditys != null || ipoCommoditys.size() > 0) {
			for (int i = 0; i < ipoCommoditys.size(); i++) {
				//获取每个产品信息
				IpoCommodity ipoCommodity = ipoCommoditys.get(i);
				//判断当前产品在Map中是否存在，如果不存在就将商品编号和发布数量存放
				if (!disbutCountByCommodityMap.containsKey(ipoCommodity.getCommodityid())) {
					disbutCountByCommodityMap.put(ipoCommodity.getCommodityid(), ipoCommodity.getCounts());
				}else{
					logger.info("发布的商品有重复！");
				} 
			}
		}

		// 计算出每个商品的中签率 
		if (disbutCountByCommodityMap != null) {
			//获取发布商品信息Map的KEY值集合
			for (String orderkey : disbutCountByCommodityMap.keySet()) {
				//根据商品编号获取发布数量
				int disCount = disbutCountByCommodityMap.get(orderkey);
				//根据商品编号判断申购MAP中是否存在此商品
               if(orderCountByCommodityMap.containsKey(orderkey)){
            	   //根据商品编号获取申购的单位数
            	   int purCount = orderCountByCommodityMap.get(orderkey);
            	   //中签率=股票发行股数/有效申购股数*100
            	   double successRate = (double)disCount/(double)(purCount*1000);
            	   //将中签率转换为String类型存放到Map中
            	   String successRateStr = String.valueOf(successRate);
            	   successRateMap.put(orderkey, successRateStr);
               }else{
            	   logger.info("申购表中没有此产品的申够记录！");
               }
			}
		}
        
		return successRateMap;
	}
	
	/**
	 * 根据产生中签号码位数（长度）计算出中签起始于结束位数
	 * @param length
	 * @return
	 */
	public static Map<Integer,Integer> getBallotNoStartLength(int length){
		Map<Integer,Integer> ballotNoLength = new HashMap<Integer,Integer>();
		//长度必须大于0
		if(length > 0){
			if(length == 1){
				ballotNoLength.put(0, 8);
			}else if(length == 2){
				ballotNoLength.put(7, 8);
			}else if(length == 3){
				ballotNoLength.put(6, 8);
			}else if(length == 4){
				ballotNoLength.put(5, 8);
			}else if(length == 5){
				ballotNoLength.put(4, 8);
			}else if(length == 6){
				ballotNoLength.put(3, 8);
			}else if(length == 7){
				ballotNoLength.put(2, 8);
			}else if(length == 8){
				ballotNoLength.put(1, 8);
			}
		}else{
			logger.info("产生的中签号码不符合规则！");
		}
		return null;
	}
	
	/**
	 * 根据字符串截取中签号码末三位数
	 * @param ballotNosStr
	 * @return
	 */
	public static String getBallotNoEndThree(String ballotNosStr){
		String ballotNoEndThree = "";
		List<String> ballotStrList = new ArrayList<String>();
		if(ballotNosStr != null || "".equals(ballotNosStr)){
			String[] strList =  ballotNosStr.split(",");
			for(int i = 0;i < strList.length; i++){
				String  ballotNo = strList[i];
				System.out.println("aaa:"+ballotNo);
				if(ballotNo.length() > 3){
					String str1 = ballotNo.substring(ballotNo.length()-3,ballotNo.length());
					ballotStrList.add(str1);
					
				}else if(strList.length == 3){
					ballotStrList.add(ballotNo);
				}else{
					String str3 =ballotNo;
					ballotStrList.add(str3);
				}
			}
		}
		//平凑字符串
		if(ballotStrList != null || ballotStrList.size() > 0){
			for(int i = 0;i < ballotStrList.size(); i++){
				ballotNoEndThree += ballotStrList.get(i);
			}
		}
		return ballotNoEndThree;
	}
}
