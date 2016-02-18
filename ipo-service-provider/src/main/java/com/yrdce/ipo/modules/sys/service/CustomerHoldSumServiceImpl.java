package com.yrdce.ipo.modules.sys.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;

public class CustomerHoldSumServiceImpl implements CustomerHoldSumService {

	@Autowired
	private  TCustomerholdsumMapper customerholdsumMapper;
	
	
	/**
	  * 解冻客户持仓
	  * @param unfreezeqty 解冻数量
	  * @param customerid  客户代码
	  * @param commodityid 商品编码
	  * @param bsFlag      买卖标记
	  */
	@Transactional
	public void unfreezeCustomerHold(Long unfreezeqty, String customerid,
			String commodityid, short bsFlag) {
		 
		TCustomerholdsum dbCustomerHold= customerholdsumMapper.selectByPrimaryKey(customerid, commodityid, bsFlag);
		if(dbCustomerHold==null){
			throw new RuntimeException("解冻客户持仓记录不存在");
		};
		TCustomerholdsum param= new TCustomerholdsum();
		BeanUtils.copyProperties(dbCustomerHold, param);
		Long frozenqty=dbCustomerHold.getFrozenqty()-unfreezeqty;
		if(frozenqty<0){
			frozenqty=0L;
		};
		param.setFrozenqty(frozenqty);
		customerholdsumMapper.updateByPrimaryKey(param);
	}

	
	
	
	
}
