package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.Spo;

@MyBatisDao
public interface IpoSpoCommoditymanmaagementMapper {
	int deleteByPrimaryKey(String spoId);

	int insert(IpoSpoCommoditymanmaagement record);

	IpoSpoCommoditymanmaagement selectByPrimaryKey(String spoId);

	List<IpoSpoCommoditymanmaagement> selectAll(int beginnum, int endnum, @Param("Spo") Spo spo);

	int updateByPrimaryKey(IpoSpoCommoditymanmaagement record);
}