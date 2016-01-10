package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;

@MyBatisDao
public interface IpoPositionMapper {
	int deleteByPrimaryKey(BigDecimal positionid);

	int insert(IpoPosition record);

	IpoPosition selectByPrimaryKey(BigDecimal positionid);

	List<IpoPosition> selectAll();

	int updateByPrimaryKey(IpoPosition record);

	List<IpoPosition> selectByFirmid(String firmid);

	// 根据交易商id和商品id更新持仓量
	int updatePosition(@Param("firmid") String firmid, @Param("commodityid") String commodityid, @Param("position") long position);

	IpoPosition selectPosition(@Param("firmid") String firmid, @Param("commodityid") String commodityid);

	// 查询商品在持仓中的总量
	int selectSumByComm(String commodityid);

	// 根据商品id查询持仓
	List<IpoPosition> selectPositionList(String commodityid);

}