package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;

@MyBatisDao
public interface IpoExpressMapper {
	int deleteByPrimaryKey(String expressId);

	int insert(IpoExpress record);

	IpoExpress selectByPrimaryKey(String expressId);

	List<IpoExpress> selectAll();

	int updateByPrimaryKey(IpoExpress record);

	IpoExpress selectExpressAndCost(String methodid, String deliveryorderid);

	// 冻结邮费的查询方法
	IpoExpress selectExpress(@Param("deliveryorderId") String deliveryorderid);
}