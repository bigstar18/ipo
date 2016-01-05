package com.yrdce.ipo.modules.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorage;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorageExtended;

@MyBatisDao
public interface IpoStorageMapper {

	List<IpoStorageExtended> findStoragesByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoStorageExtended record);

	int getTotalNum(IpoStorageExtended record);

	// sequence序列，拼接入库单号
	int sequence();

	// 1.申请 2.仓库通过 3.仓库驳回 4.市场通过 5.市场驳回(storagedate对应数字)
	int insert(IpoStorage record);

	IpoStorage getStorageByPrimary(String storageid);

	int updateStorageState(@Param("storageid") String storageid,
			@Param("checker") String checker, @Param("state") String state);

	String getWarehouseId(String userId);

	Long getWarehousePrimaryKey(String userId);

}