package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;

@MyBatisDao
public interface IpoPositionMapper {
	int deleteByPrimaryKey(BigDecimal positionid);

	int insert(IpoPosition record);

	IpoPosition selectByPrimaryKey(BigDecimal positionid);

	List<IpoPosition> selectAll();

	int updateByPrimaryKey(IpoPosition record);

	List<IpoPosition> selectByFirmid(String firmid);
}