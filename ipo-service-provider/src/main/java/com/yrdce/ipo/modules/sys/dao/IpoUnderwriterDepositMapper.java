package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;

@MyBatisDao
public interface IpoUnderwriterDepositMapper {
	int insert(IpoUnderwriterDeposit record);

	int updateByPrimaryKey(IpoUnderwriterDeposit record);

	IpoUnderwriterDeposit selectInfoByBrokerId(
			@Param("brokerid") String brokerid);

	List<IpoUnderwriterDeposit> selectAll();

}