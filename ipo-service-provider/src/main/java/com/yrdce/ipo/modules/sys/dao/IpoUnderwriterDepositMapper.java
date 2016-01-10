package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;

@MyBatisDao
public interface IpoUnderwriterDepositMapper {
	int insert(IpoUnderwriterDeposit record);

	List<IpoUnderwriterDeposit> selectAll();

	/*
	 * 2016.1.9 认购资金管理 li
	 */
	List<IpoUnderwriterDeposit> getSubFundsInfo(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("underwriterid") String underwriterid);

	int getSubFundsInfoCounts(@Param("underwriterid") String underwriterid);

}