package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeWarehouse;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipWarehouse;

@MyBatisDao
public interface IpoTrusteeshipWarehouseMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoTrusteeshipWarehouse record);

	IpoTrusteeshipWarehouse selectByPrimaryKey(BigDecimal id);

	List<IpoTrusteeshipWarehouse> selectAll();

	int updateByPrimaryKey(IpoTrusteeshipWarehouse record);

	List<IpoTrusteeWarehouse> selectByCommodity(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoTrusteeWarehouse record);

	int getQueryNum(IpoTrusteeWarehouse record);

	List<Long> selectWareIdsByCommId(@Param("commId") String commId);
}