package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.modules.sys.entity.IpoStorage;

public interface IpoStorageMapper {
	int deleteByPrimaryKey(String storageid);

	int insert(IpoStorage record);

	IpoStorage selectByPrimaryKey(String storageid);

	List<IpoStorage> selectAll();

	int updateByPrimaryKey(IpoStorage record);
}