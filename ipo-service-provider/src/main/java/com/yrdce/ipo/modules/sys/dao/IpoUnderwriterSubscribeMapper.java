package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderWriters;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

@MyBatisDao
public interface IpoUnderwriterSubscribeMapper {
	int deleteByPrimaryKey(BigDecimal subscribeid);

	int insert(IpoUnderwriterSubscribe record);

	IpoUnderwriterSubscribe selectByPrimaryKey(BigDecimal subscribeid);

	IpoUnderwriterSubscribe selectByExample(
			@Param("record") UnderwriterSubscribe Subscribe);

	List<IpoUnderwriterSubscribe> selectAll();

	int updateByPrimaryKey(IpoUnderwriterSubscribe record);

	// 查询承销商认购资金明细
	List<IpoUnderwriterSubscribe> selectFunds(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum,
			@Param("underwriterid") String underwriterid);

	// 查询承销商认购资金明细页数
	int selectPage(@Param("underwriterid") String underwriterid);

	// 查询承销设置信息
	List<IpoUnderwriterSubscribe> getInfosByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoUnderwriterSubscribe record);

	// 获取承销设置记录数
	int getQueryNum(@Param("record") IpoUnderwriterSubscribe record);

	// 查询发行商的承销会员
	List<IpoUnderWriters> getUnderwritersByPub(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum, @Param("record") IpoUnderWriters record);

	// 获取发行商的承销会员记录数
	int getUnderwritersNum(@Param("record") IpoUnderWriters record);
}