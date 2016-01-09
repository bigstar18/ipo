package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;

@MyBatisDao
public interface IpoUnderwriterSubscribeMapper {
	int deleteByPrimaryKey(BigDecimal subscribeid);

	int insert(IpoUnderwriterSubscribe record);

	IpoUnderwriterSubscribe selectByPrimaryKey(BigDecimal subscribeid);

	List<IpoUnderwriterSubscribe> selectAll();

	int updateByPrimaryKey(IpoUnderwriterSubscribe record);
}