package com.yrdce.ipo.modules.sys.service;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoStockTransferrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.IpoChargeRole;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoPubpaymentTrack;
import com.yrdce.ipo.modules.sys.entity.IpoStockTransferrecords;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeWarehouse;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.ChargeRole;
import com.yrdce.ipo.modules.sys.vo.MProperty;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.PubpaymentTrack;
import com.yrdce.ipo.modules.sys.vo.StockTransferrecords;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipWarehouse;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;


@Service
public class StockTransferrecordsServiceImpl implements StockTransferrecordsService {
	
	
	@Autowired
	private TCustomerholdsumMapper customerholdsumMapper;
	@Autowired
	private IpoDeliveryorderMapper ipoDeliveryorderMapper;
	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfMapper;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoStockTransferrecordsMapper stocktransferrecordmapper;
	@Override
	public List<StockTransferrecords> selectByPage(String page, String rows, StockTransferrecords storage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotalNum(StockTransferrecords storage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockTransferrecords> findTransferRecord(String page, String rows, StockTransferrecords example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		IpoStockTransferrecords record = new IpoStockTransferrecords();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		
		List<IpoStockTransferrecords> dbList = stocktransferrecordmapper
				.findStockTransferrecords(startIndex, endIndex, record);
		List<StockTransferrecords> dataList = new ArrayList<StockTransferrecords>();
		for (IpoStockTransferrecords item : dbList) {
			StockTransferrecords entity = new StockTransferrecords();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
			}
		return dataList;
		}
		return null;
	}
		
	
	
	

	/**
	 * 新增
	 * @param positionReduce
	 * @return
	 */
	@Transactional
	public int saveTransfer(StockTransferrecords stockTransferrecords){

	
		return stocktransferrecordmapper.insert(stockTransferrecords);
	}
	@Override
	public Integer getNums(StockTransferrecords example) {
		com.yrdce.ipo.modules.sys.entity.IpoStockTransferrecords record = new com.yrdce.ipo.modules.sys.entity.IpoStockTransferrecords();
		example.setCreatetime(new Date());
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		return stocktransferrecordmapper.getStockCommNum(record);
	}

	@Override
	public List<StockTransferrecords> queryReduceForList(StockTransferrecords stockTransferrecords) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public Integer insertTransfer(StockTransferrecords example) {
		if (example != null) {
			IpoStockTransferrecords record = new IpoStockTransferrecords();
			BeanUtils.copyProperties(example, record);
			return stocktransferrecordmapper.insert(record);
		}
		return 0;
	}
	
	@Override
	public String deleteInfo(String applicationIds) {
		String[] Ids = applicationIds.split(",");
		int num = 0;
		
		
		for (int i = 0; i < Ids.length; i++) {
//			IpoStockTransferrecords example = 
			num+=stocktransferrecordmapper.selectByapplicationId(new BigDecimal(Ids[i]));
		}

		if (num == Ids.length) {
			return "true";
		}
		return "false";
	}

	/**
	 * 查找
	 */
	@Override
	public StockTransferrecords findById(Long applicationIds) {
		IpoStockTransferrecords dbChargeRole =  stocktransferrecordmapper.findById(applicationIds);
		StockTransferrecords entity=new StockTransferrecords();
		if(dbChargeRole!=null){			
			BeanUtils.copyProperties(dbChargeRole, entity);
		}
		return entity;
	}

	/**
	 * 更新状态
	 */
	@Transactional
	public void update(StockTransferrecords stockTransferrecords) {
		stockTransferrecords.setReviewtime(new Date());
		stocktransferrecordmapper.update(stockTransferrecords);
	}
	/**
	 * 对比持仓
	 * @return 
	 */
	@Override
	public boolean checkCommQuatity(Long quatity, String firmid, String commid) {
		String check = customerholdsumMapper.checkCommQuatity(firmid,commid);
 		if(check==null)
		{
			return false;
		}else{
		if(Long.parseLong(check)>=quatity){
			return true;
		}
		}
		return false;
	}
	/**
	 * 对比客户
	 * @return 
	 */
	@Override
	public boolean checkfirmid(String firmid) {
		String check = ipoDeliveryorderMapper.selectByFrim(firmid);
		if(check!=null){
			return true;
		}
		return false;
	}
	/**
	 * 对比商品
	 * @return 
	 */
	@Override
	public boolean checkcommid(String commid) {
		String check = ipoCommodityConfMapper.checkcommid(commid);
		if(check!=null){
			return true;
		}
		return false;
	}
}
