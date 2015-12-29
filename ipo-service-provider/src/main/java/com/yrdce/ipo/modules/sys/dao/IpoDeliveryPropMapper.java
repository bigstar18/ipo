package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryProp;

@MyBatisDao
public interface IpoDeliveryPropMapper {
	int insert(IpoDeliveryProp record);

	int deleteByCommodityId(String commId);

	List<IpoDeliveryProp> selectAll();
}