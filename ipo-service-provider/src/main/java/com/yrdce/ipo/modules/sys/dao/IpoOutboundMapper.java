package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoOutbound;
import com.yrdce.ipo.modules.sys.entity.IpoOutboundExtended;

@MyBatisDao
public interface IpoOutboundMapper {
	int deleteByPrimaryKey(String outboundorderid);

	int insert(IpoOutbound record);

	IpoOutbound selectByPrimaryKey(String outboundorderid);

	List<IpoOutbound> selectAll();

	int updateByPrimaryKey(IpoOutbound record);

	List<IpoOutbound> getInfoByType();

	List<IpoOutboundExtended> findOutboundsByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoOutboundExtended record);

	int getTotalNum(IpoOutboundExtended record);
	
	int updateOutBoundInfo(IpoOutbound ipoOutbound);

}