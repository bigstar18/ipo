package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;

@MyBatisDao
public interface IpoUnderwriterDepositMapper {
	int insert(IpoUnderwriterDeposit record);

	List<IpoUnderwriterDeposit> selectAll();
}