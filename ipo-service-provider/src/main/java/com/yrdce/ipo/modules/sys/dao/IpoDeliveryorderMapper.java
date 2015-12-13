package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;

@MyBatisDao
public interface IpoDeliveryorderMapper {
	int deleteByPrimaryKey(Long deliveryorderId);

	int insert(IpoDeliveryorder record);

	IpoDeliveryorder selectByPrimaryKey(Long deliveryorderId);

	List<IpoDeliveryorder> selectAll();

	int updateByPrimaryKey(IpoDeliveryorder record);
}