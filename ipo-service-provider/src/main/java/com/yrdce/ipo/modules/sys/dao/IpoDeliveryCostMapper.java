package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCostExtended;
import com.yrdce.ipo.modules.sys.vo.Paging;

@MyBatisDao
public interface IpoDeliveryCostMapper {
	int deleteByPrimaryKey(String deliveryId);

	int insert(IpoDeliveryCost record);

	IpoDeliveryCost selectByPrimaryKey(String deliveryId);

	List<IpoDeliveryCost> selectAll();

	int updateByPrimaryKey(IpoDeliveryCost record);

	List<IpoDeliveryCostExtended> selectByUserid(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	int countsByCost(@Param("paging") Paging paging);

	List<IpoDeliveryCost> getInfo(@Param("firmid") String firmid);
}