package com.yrdce.ipo.modules.sys.service;

import java.util.List;


import com.yrdce.ipo.modules.sys.vo.StockFreeze;
import com.yrdce.ipo.modules.sys.vo.StockTransferrecords;



public interface StockFreezeService {
	
	// 分页查询过户信息
//		List<StockTransferrecords> selectByPage(String page, String rows,
//				StockTransferrecords storage);
//	
//		Integer getTotalNum(StockTransferrecords storage);
		
		public List<StockFreeze> freezeRecord(String page, String rows, StockFreeze example);

		public Integer getNums(StockFreeze example);
	//添加
		public Integer insertFreeze(StockFreeze example);

		public StockFreeze findById(Long applicationIds);

		public void update(StockFreeze example);



//		List<StockTransferrecords> queryReduceForList(StockTransferrecords stockTransferrecords);

//
//		public String deleteInfo(String applicationIds);
//		
//
//		
//
//		public void update(StockTransferrecords stockTransferrecords);
//
//		public boolean checkCommQuatity(Long quatity, String firmid, String commid);
//
//		public boolean checkfirmid(String firmid);










}