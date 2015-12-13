package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;

@MyBatisDao
public interface IpoDeliveryCostMapper {
	int deleteByPrimaryKey(Long deliveryId);

	int insert(IpoDeliveryCost record);

	IpoDeliveryCost selectByPrimaryKey(Long deliveryId);

	List<IpoDeliveryCost> selectAll();

	int updateByPrimaryKey(IpoDeliveryCost record);
}