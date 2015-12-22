package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpo;
import com.yrdce.ipo.modules.sys.vo.Spo;

@MyBatisDao
public interface IpoSpoMapper {
	int deleteByPrimaryKey(String spoId);

	int insert(IpoSpo record);

	IpoSpo selectByPrimaryKey(String spoId);

	List<IpoSpo> selectAll();

	int updateByPrimaryKey(IpoSpo record);
	
	List<IpoSpo> getInfoByPages(@Param("spo")IpoSpo spo,@Param("beginnum")int beginnun,@Param("endnum")int endnum);
	
	int getInfoCounts(@Param("spo")IpoSpo spo);
	int updateRationType(String spoId);
	
}