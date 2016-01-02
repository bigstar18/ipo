package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.BiWarehouse;

@MyBatisDao
public interface BiWarehouseMapper {
	int deleteByPrimaryKey(Long id);

	int insert(BiWarehouse record);

	BiWarehouse selectByPrimaryKey(Long id);

	List<BiWarehouse> selectAll();

	int updateByPrimaryKey(BiWarehouse record);

	Long getPrimaryKey(String warehouseId);

	String getWarehouseId(String userId);
}