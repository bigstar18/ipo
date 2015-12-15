package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;

@MyBatisDao
public interface IpoDeliveryorderMapper {
	int deleteByPrimaryKey(String deliveryorderId);

	int insert(IpoDeliveryorder record);

	IpoDeliveryorder selectByPrimaryKey(String deliveryorderId);

	List<IpoDeliveryorder> selectAll();

	int updateByPrimaryKey(IpoDeliveryorder record);
}