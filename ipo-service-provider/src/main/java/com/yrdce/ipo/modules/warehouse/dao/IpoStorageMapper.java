package com.yrdce.ipo.modules.warehouse.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoStorageExtended;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorage;
import com.yrdce.ipo.modules.warehouse.entity.StorageUnion;

@MyBatisDao
public interface IpoStorageMapper {
	int deleteByPrimaryKey(String storageid);

	//1.申请 2.仓库通过 3.仓库驳回 4.市场通过 5.市场驳回(storagedate对应数字)
	int insert(IpoStorage record);

	IpoStorage selectByPrimaryKey(String storageid);

	IpoStorage selectByCommodityId(String commodityid);

	IpoStorage selectByStorageDate(Date storagedate);
	
	//1.申请 2.仓库通过 3.仓库驳回 4.市场通过 5.市场驳回(storagedate对应数字)
	IpoStorage selectByStorageState(int storagestate);

	List<IpoStorage> selectAll();

	int updateByPrimaryKey(IpoStorage record);
	
	List<StorageUnion> queryUnionByPage(@Param("beginnum") Integer beginnum,@Param("endnum") Integer endnum,@Param("storageUnion") StorageUnion storageUnion);
	
	int countStorage();
	
	List<IpoStorageExtended> findStoragesByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoStorageExtended record);

	int getTotalNum(IpoStorageExtended record);

	int updateStorage(@Param("storageid") String storageid,
			@Param("checker") String checker, @Param("state") String state);
	
	
}