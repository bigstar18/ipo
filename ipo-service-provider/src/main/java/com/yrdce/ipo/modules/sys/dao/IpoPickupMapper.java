package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPickup;

@MyBatisDao
public interface IpoPickupMapper {
	int deleteByPrimaryKey(Long pickupId);

	int insert(IpoPickup record);

	IpoPickup selectByPrimaryKey(Long pickupId);

	List<IpoPickup> selectAll();

	int updateByPrimaryKey(IpoPickup record);
}