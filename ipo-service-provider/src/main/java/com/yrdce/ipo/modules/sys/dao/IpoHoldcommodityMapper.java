package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoHoldcommodity;

/**
 * @ClassName: IpoHoldcommodityMapper
 * @Description: 经纪会员持仓汇总
 * @author bob
 */
@MyBatisDao
public interface IpoHoldcommodityMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoHoldcommodity record);

	IpoHoldcommodity selectByPrimaryKey(BigDecimal id);

	List<IpoHoldcommodity> selectAll();

	int updateByPrimaryKey(IpoHoldcommodity record);
}