package com.yrdce.ipo.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.FFirmfunds;
import com.yrdce.ipo.modules.sys.entity.FFirmfundsExample;

@MyBatisDao
public interface FFirmfundsMapper extends CrudDao<FFirmfunds> {
	int countByExample(FFirmfundsExample example);

	int deleteByExample(FFirmfundsExample example);

	int deleteByPrimaryKey(String firmid);

	int insert(FFirmfunds record);

	int insertSelective(FFirmfunds record);

	List<FFirmfunds> selectByExample(FFirmfundsExample example);

	FFirmfunds selectByPrimaryKey(String firmid);

	int updateByExampleSelective(@Param("record") FFirmfunds record, @Param("example") FFirmfundsExample example);

	int updateByExample(@Param("record") FFirmfunds record, @Param("example") FFirmfundsExample example);

	int updateByPrimaryKeySelective(FFirmfunds record);

	int updateByPrimaryKey(FFirmfunds record);

	void getMonery(Map<String, Object> map);

	void getfrozen(Map<String, Object> map);
}