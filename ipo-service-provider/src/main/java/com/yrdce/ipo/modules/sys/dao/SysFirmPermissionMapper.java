package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.SysFirmPermission;

@MyBatisDao
public interface SysFirmPermissionMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(SysFirmPermission record);

	SysFirmPermission selectByPrimaryKey(BigDecimal id);

	List<SysFirmPermission> selectAll();

	int updateByPrimaryKey(SysFirmPermission record);

	List<SysFirmPermission> selectByFirmId(String firmId);
}