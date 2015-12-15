package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;

@MyBatisDao
public interface IpoDeliveryorderMapper {

	List<IpoDeliveryorder> findAllDeliOrdersByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getTotalNum();

	List<IpoDeliveryorder> findAllDeliOrdersByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoDeliveryorder record);

	int getTotalNum(@Param("record") IpoDeliveryorder record);

	List<IpoDeliveryorder> approveDeliOrdersByPage(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getApproveNum();

	int deleteByPrimaryKey(Long deliveryorderId);

	int insert(IpoDeliveryorder record);

	IpoDeliveryorder selectByPrimaryKey(Long deliveryorderId);

	List<IpoDeliveryorder> selectAll();

	int updateByPrimaryKey(IpoDeliveryorder record);
}