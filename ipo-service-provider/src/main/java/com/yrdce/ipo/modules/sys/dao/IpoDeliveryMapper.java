package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	/** 
	 *  @Title: selectByFirmidAndTime 
	 *  @Description: 根据交易商id和注册日期查询（交易商条件选填）
	 *  @param firmid  交易商id
	 *  @param time   过户日期
	 *  @return  商品提货单 
	 */
	List<IpoDelivery> selectByFirmidAndTime(@Param("firmid") String firmid, @Param("time") String time);
}