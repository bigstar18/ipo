package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.CTradeModule;

@MyBatisDao
public interface CTradeModuleMapper {

	public CTradeModule findById(Long id);
	
	
}
