package com.yrdce.ipo.modules.sys.dao;

import java.util.Date;
import java.util.List;

import com.yrdce.ipo.modules.sys.entity.IpoStorage;

public interface IpoStorageMapper {
	int deleteByPrimaryKey(String storageid);

	int insert(IpoStorage record);

	IpoStorage selectByPrimaryKey(String storageid);

    IpoStorage selectByCommodityId(String commodityid);
    
    IpoStorage selectByStorageDate(Date storagedate);
    
    IpoStorage selectByStorageState(int storagestate);
	
	List<IpoStorage> selectAll();

	int updateByPrimaryKey(IpoStorage record);
}