package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.entity.BrBrokerExample;

@MyBatisDao
public interface BrBrokerMapper {
	int countByExample(BrBrokerExample example);

	int deleteByExample(BrBrokerExample example);

	int deleteByPrimaryKey(String brokerid);

	int insert(BrBroker record);

	int insertSelective(BrBroker record);

	List<BrBroker> selectByExampleWithBLOBs(BrBrokerExample example);

	List<BrBroker> selectByExample(BrBrokerExample example);

	BrBroker selectByPrimaryKey(String brokerid);

	int updateByExampleSelective(@Param("record") BrBroker record, @Param("example") BrBrokerExample example);

	int updateByExampleWithBLOBs(@Param("record") BrBroker record, @Param("example") BrBrokerExample example);

	int updateByExample(@Param("record") BrBroker record, @Param("example") BrBrokerExample example);

	int updateByPrimaryKeySelective(BrBroker record);

	int updateByPrimaryKeyWithBLOBs(BrBroker record);

	int updateByPrimaryKey(BrBroker record);

	List<BrBroker> findAllPublisher();// 获取所有发行会员

}