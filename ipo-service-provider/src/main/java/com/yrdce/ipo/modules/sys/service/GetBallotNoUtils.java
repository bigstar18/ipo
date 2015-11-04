package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
/**
 * 摇号处理类
 * @author zyg
 *
 */
public class GetBallotNoUtils {
	
    //执行摇号处理路基
	public static void executeApplyBallotNo(){
		//新股摇号规则
		MathUtil util = new MathUtil();
		//产品编号，中签数量，中签号码,商品对应的中签号码
		Map<String, Map<Integer, String>> commdityCorreSuccessNo = new HashMap<String, Map<Integer, String>>();
		//中签数量，中签号码
		Map<Integer, String> correSuccessNo = new HashMap<Integer, String>();
		//调用查询所有商品列表Service------------------------------------------------------//调用高波的查询方法
		List<IpoCommodity>  ipoCommoditys = new ArrayList<IpoCommodity>();
		//调用查询所有订单列表Service------------------------------------------------------//调用高波的查询方法
		List<IpoOrder> ipoOrders = new ArrayList<IpoOrder>();
		
		
		//获取每个商品的中签率
		Map<String,String> successRateMap = GetSuccessRate.getSuccessRateByApplyCount(ipoOrders, ipoCommoditys);
		if(successRateMap != null){
			for(String commdityId : successRateMap.keySet()){
				String successRateStr = successRateMap.get(commdityId);
				//将中签率转换为double
				double successRate = Double.valueOf(successRateStr);
				//根据中签率获取中签号码
				List<String> result = util.getRandomResult(successRate, 0);
				//中签数量
				int successNoNum = result.size();
				//中签号码字符串
				String successNoStr ="";
				if(result != null || result.size() > 0 ){
					for(int i = 0;i < result.size(); i++){
						successNoStr = result.get(i)+",";
					}
				}
				//按照产品编号，中签数量，中签号码,商品对应的中签号码顺序存放到Map中
				correSuccessNo.put(successNoNum, successNoStr);
				commdityCorreSuccessNo.put(commdityId, correSuccessNo);	
			}
		}

		
		//取出中签号码后三位数字入库。
		if(commdityCorreSuccessNo != null ){
		  for(String key : commdityCorreSuccessNo.keySet()){
			  Map<Integer,String> map = commdityCorreSuccessNo.get(key);
			  Collection<String> allotNos = map.values();
			  for(String ballotNoStr:allotNos){
				  GetSuccessRate.getBallotNoEndThree(ballotNoStr);
				  //调用插入IPO_BALLOTNO_INFO表的Dao里面的插入方法
				  //1.将产品编号和中签后三位数入库
				  
			  }
		  } 
		}

		
	}
}
