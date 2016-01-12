package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.modules.sys.dao.TFirmHoldSumMaper;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;
import com.yrdce.ipo.modules.sys.vo.FirmHoldSum;
/**
 * 交易商持仓汇总
 * @author wq 2016-1-12
 *
 */
public class FirmHoldSumServiceImpl implements FirmHoldSumService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TFirmHoldSumMaper   firmHoldSumMaper;
	
	
	public long queryForCount(FirmHoldSum firmHoldSum) {
		return firmHoldSumMaper.queryForCount(firmHoldSum);
	}

	
	public List<FirmHoldSum> queryForList(FirmHoldSum firmHoldSum) {
	    List<TFirmHoldSum> dbList = firmHoldSumMaper.queryForList(firmHoldSum);
	    List<FirmHoldSum> dataList=new ArrayList<FirmHoldSum>();
		for(TFirmHoldSum item :dbList){
			FirmHoldSum entity=new FirmHoldSum();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		};
		return dataList;
	}

	
	
	
	
	
	
}
