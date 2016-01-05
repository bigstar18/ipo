package com.yrdce.ipo.modules.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aspectj.internal.lang.annotation.ajcDeclareParents;

import com.alibaba.dubbo.config.support.Parameter;
import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock;
import com.yrdce.ipo.modules.warehouse.entity.WarehouseStock;

@MyBatisDao
public interface IpoWarehouseStockMapper {

	int insert(WarehouseStock record);// 序列从2开始

	List<IpoWarehouseStock> findWarehouseStockByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoWarehouseStock record);

	int getQueryNum(@Param("record") IpoWarehouseStock record);
	
	
	IpoWarehouseStock selectByCommoId(@Param("commodityid")String commodityid,@Param("warehouseid")String warehouseid);
	
	int updateInfo(IpoWarehouseStock ipoWarehouseStock);
}