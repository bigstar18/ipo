package com.yrdce.ipo.hq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.hq.entity.Currentdata;

@MyBatisDao
public interface CurrentdataMapper {
	int deleteByPrimaryKey(@Param("marketid") String marketid,
			@Param("commodityid") String commodityid);

	int insert(Currentdata record);

	Currentdata selectByPrimaryKey(@Param("marketid") String marketid,
			@Param("commodityid") String commodityid);

	List<Currentdata> selectAll();

	int updateByPrimaryKey(Currentdata record);

	List<Currentdata> selectTransferPrice(
			@Param("commodityid") String commodityid, @Param("days") int days);
}