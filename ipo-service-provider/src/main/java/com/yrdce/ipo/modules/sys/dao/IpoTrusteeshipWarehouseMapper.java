package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeWarehouse;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipWarehouse;

@MyBatisDao
public interface IpoTrusteeshipWarehouseMapper {
	int deleteByPrimaryKey(Integer id);

	int deleteByCommId(@Param("commId") String commId);

	int insert(IpoTrusteeshipWarehouse record);

	IpoTrusteeshipWarehouse selectByPrimaryKey(Integer id);

	List<IpoTrusteeshipWarehouse> selectAll();

	int updateByPrimaryKey(IpoTrusteeshipWarehouse record);

	List<IpoTrusteeWarehouse> selectByCommodity(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoTrusteeWarehouse record);

	int getQueryNum(IpoTrusteeWarehouse record);

	List<String> selectCommIDs();

	List<Long> selectWareIdsByCommId(@Param("commId") String commId);
}