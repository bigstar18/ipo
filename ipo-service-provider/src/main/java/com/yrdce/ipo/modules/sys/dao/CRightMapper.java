package com.yrdce.ipo.modules.sys.dao;

import gnnt.MEBS.common.mgr.model.Menu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;

@MyBatisDao
public interface CRightMapper {

	Menu selectByPrimaryKey(Long id);

	List<Menu> selectAll();

	List<Menu> getMenuByFilter(@Param("paramInt1") int paramInt1,
			@Param("paramInt2") int paramInt2, @Param("paramInt3") int paramInt3);

	List<Menu> getMenuBySubFilter(@Param("paramInt1") int paramInt1,
			@Param("paramInt2") int paramInt2, @Param("paramInt3") int paramInt3);

	List<Menu> getMenuById(@Param("id") long paramLong,
			@Param("paramInt1") int paramInt1,
			@Param("paramInt2") int paramInt2,
			@Param("paramInt3") int paramInt3,
			@Param("paramList") List<Integer> paramList);

}