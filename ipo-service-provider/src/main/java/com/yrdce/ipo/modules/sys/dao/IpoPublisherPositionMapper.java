package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPublisherPosition;

@MyBatisDao
public interface IpoPublisherPositionMapper {
	int deleteByPrimaryKey(BigDecimal positionid);

	int insert(IpoPublisherPosition record);

	IpoPublisherPosition selectByPrimaryKey(BigDecimal positionid);

	List<IpoPublisherPosition> selectAll();

	int updateByPrimaryKey(IpoPublisherPosition record);

	List<IpoPublisherPosition> selectByPage(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum,
			@Param("record") IpoPublisherPosition record);

	int getTotalNum(@Param("record") IpoPublisherPosition record);

	Long getSaleCounts(@Param("commodityid") String commodityid);

	IpoPublisherPosition getInfoByStorageId(@Param("storageid") String storageid);
}