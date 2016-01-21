package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialcounterfee;

@MyBatisDao
public interface IpoSpecialcounterfeeMapper {
	int deleteByPrimaryKey(String id);

	int insert(IpoSpecialcounterfee record);

	IpoSpecialcounterfee selectByPrimaryKey(String id);

	List<IpoSpecialcounterfee> selectAll(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int updateByPrimaryKey(IpoSpecialcounterfee record);

	int selectCounts();

	int sequence();

	int isFirm(@Param("firmid") String firmid);
}