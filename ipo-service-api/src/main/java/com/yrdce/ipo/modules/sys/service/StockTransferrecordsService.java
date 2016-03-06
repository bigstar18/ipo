package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.ChargeItem;
import com.yrdce.ipo.modules.sys.vo.ChargeRole;
import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.vo.StockTransferrecords;


public interface StockTransferrecordsService {
	
	// 分页查询过户信息
		List<StockTransferrecords> selectByPage(String page, String rows,
				StockTransferrecords storage);
	
		Integer getTotalNum(StockTransferrecords storage);
		
		public List<StockTransferrecords> findTransferRecord(String page, String rows, StockTransferrecords example);

		public Integer getNums(StockTransferrecords example);

		List<StockTransferrecords> queryReduceForList(StockTransferrecords stockTransferrecords);
		//添加
		public Integer insertTransfer(StockTransferrecords example);

		public String deleteInfo(String applicationIds);


		StockTransferrecords findById(Long applicationIds);

		public void update(StockTransferrecords stockTransferrecords);


		/**
		 * 查找一般费用
		 * @param id
		 * @return
		 */





}