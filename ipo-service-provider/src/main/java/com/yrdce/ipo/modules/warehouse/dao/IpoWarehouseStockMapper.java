package com.yrdce.ipo.modules.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock;

@MyBatisDao
public interface IpoWarehouseStockMapper {
	int deleteByPrimaryKey(String stockid);

	int insert(IpoWarehouseStock record);

	IpoWarehouseStock selectByPrimaryKey(String stockid);

	List<IpoWarehouseStock> selectAll();

	int updateByPrimaryKey(IpoWarehouseStock record);

	List<IpoWarehouseStock> findWarehouseStockByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoWarehouseStock record);

	int getQueryNum(@Param("record") IpoWarehouseStock record);
}