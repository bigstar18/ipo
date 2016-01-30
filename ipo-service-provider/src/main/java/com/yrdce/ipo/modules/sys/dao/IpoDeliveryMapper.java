package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDelivery;

/**
 * @ClassName: IpoDeliveryMapper
 * @Description: 经济会员提货单汇总
 * @author bob
 */
@MyBatisDao
public interface IpoDeliveryMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoDelivery record);

	IpoDelivery selectByPrimaryKey(BigDecimal id);

	List<IpoDelivery> selectAll();

	int updateByPrimaryKey(IpoDelivery record);
}