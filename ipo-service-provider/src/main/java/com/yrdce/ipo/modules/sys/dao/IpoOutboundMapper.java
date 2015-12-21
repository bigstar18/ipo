package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoOutbound;

@MyBatisDao
public interface IpoOutboundMapper {
	int deleteByPrimaryKey(String outboundorderid);

	int insert(IpoOutbound record);

	IpoOutbound selectByPrimaryKey(String outboundorderid);

	List<IpoOutbound> selectAll();

	int updateByPrimaryKey(IpoOutbound record);
	
	List<IpoOutbound> getInfoByType();
}