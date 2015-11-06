package com.yrdce.ipo.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecordsExample;

@MyBatisDao
public interface IpoNumberofrecordsMapper {
	int countByExample(IpoNumberofrecordsExample example);

	int deleteByExample(IpoNumberofrecordsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(IpoNumberofrecords record);

	int insertSelective(IpoNumberofrecords record);

	List<IpoNumberofrecords> selectByExample(IpoNumberofrecordsExample example);

	IpoNumberofrecords selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") IpoNumberofrecords record, @Param("example") IpoNumberofrecordsExample example);

	int updateByExample(@Param("record") IpoNumberofrecords record, @Param("example") IpoNumberofrecordsExample example);

	int updateByPrimaryKeySelective(IpoNumberofrecords record);

	int updateByPrimaryKey(IpoNumberofrecords record);

	int update(Map<String, Object> map);

	int selectbysid(String commodityid);

	void insertAll();

	void deleatAll();
}