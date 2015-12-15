package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;

@MyBatisDao
public interface IpoDeliveryCostMapper {
	int deleteByPrimaryKey(String deliveryId);

	int insert(IpoDeliveryCost record);

	IpoDeliveryCost selectByPrimaryKey(String deliveryId);

	List<IpoDeliveryCost> selectAll();

	int updateByPrimaryKey(IpoDeliveryCost record);
}