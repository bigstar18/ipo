package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;

@MyBatisDao
public interface IpoUnderwriterSubscribeMapper {
	int deleteByPrimaryKey(BigDecimal subscribeid);

	int insert(IpoUnderwriterSubscribe record);

	IpoUnderwriterSubscribe selectByPrimaryKey(BigDecimal subscribeid);

	List<IpoUnderwriterSubscribe> selectAll();

	int updateByPrimaryKey(IpoUnderwriterSubscribe record);

	// 查询承销商认购资金明细
	List<IpoUnderwriterSubscribe> selectFunds(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("underwriterid") String underwriterid);

	// 查询承销商认购资金明细页数
	int selectPage(@Param("underwriterid") String underwriterid);

	List<IpoUnderwriterSubscribe> getInfosByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoUnderwriterSubscribe record);

	int getQueryNum(@Param("record") IpoUnderwriterSubscribe record);
}