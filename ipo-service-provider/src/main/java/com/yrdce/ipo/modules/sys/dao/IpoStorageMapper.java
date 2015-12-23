package com.yrdce.ipo.modules.sys.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoStorage;
import com.yrdce.ipo.modules.sys.entity.IpoStorageExtended;

@MyBatisDao
public interface IpoStorageMapper {
	int deleteByPrimaryKey(String storageid);

	int insert(IpoStorage record);

	IpoStorage selectByPrimaryKey(String storageid);

	IpoStorage selectByCommodityId(String commodityid);

	IpoStorage selectByStorageDate(Date storagedate);

	IpoStorage selectByStorageState(int storagestate);

	List<IpoStorage> selectAll();

	int updateByPrimaryKey(IpoStorage record);

	List<IpoStorageExtended> findStoragesByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoStorageExtended record);

	int getTotalNum(IpoStorageExtended record);

	int updateStorage(@Param("storageid") String storageid,
			@Param("checker") String checker, @Param("state") String state);

}