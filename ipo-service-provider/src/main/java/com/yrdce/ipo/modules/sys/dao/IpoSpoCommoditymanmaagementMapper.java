package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;

@MyBatisDao
public interface IpoSpoCommoditymanmaagementMapper {
	int deleteByPrimaryKey(String spoId);

	int insert(IpoSpoCommoditymanmaagement record);

	IpoSpoCommoditymanmaagement selectByPrimaryKey(String spoId);

	List<IpoSpoCommoditymanmaagement> selectAll(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("Spo") IpoSpoCommoditymanmaagement spoComm);

	int updateByPrimaryKey(IpoSpoCommoditymanmaagement record);

	int counts();

	int updateByStatus(@Param("rationSate") int rationSate, @Param("spoid") String spoid);

	int updateByComm(IpoSpoCommoditymanmaagement record);
}