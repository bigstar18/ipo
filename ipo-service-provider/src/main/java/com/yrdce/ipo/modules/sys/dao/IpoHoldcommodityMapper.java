package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	/** 
	 *  @Title: selectByFirmidAndTime 
	 *  @Description: 根据交易商id和注册日期查询（交易商条件选填）
	 *  @param firmid  交易商id
	 *  @param time   日期
	 *  @return  商品提货单 
	 */
	List<IpoHoldcommodity> selectByFirmidAndTime(@Param("firmid") String firmid, @Param("time") String time);
}