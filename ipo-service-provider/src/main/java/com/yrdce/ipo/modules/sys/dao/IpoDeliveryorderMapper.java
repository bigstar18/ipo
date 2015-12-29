package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpressExtended;
import com.yrdce.ipo.modules.sys.entity.IpoPickupExtended;
import com.yrdce.ipo.modules.sys.vo.Paging;

@MyBatisDao
public interface IpoDeliveryorderMapper {
	List<IpoDeliveryorder> findAllDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getTotalNum();

	List<IpoDeliveryorder> queryAllDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoDeliveryorder record);

	int getQueryNum(@Param("record") IpoDeliveryorder record);

	List<IpoDeliveryorder> queryCancelDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoDeliveryorder record);

	int getQueryCancelNum(@Param("record") IpoDeliveryorder record);

	List<IpoDeliveryorder> approveDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getApproveNum();

	List<IpoDeliveryorder> cancelDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getCancelNum();

	void cancelDeorder(@Param("deorderId") String deorderId, @Param("canceller") String cancelId);

	int deleteByPrimaryKey(String deliveryorderId);

	int insert(IpoDeliveryorder record);

	IpoDeliveryorder selectByPrimaryKey(String deliveryorderId);

	List<IpoDeliveryorder> selectAll();

	int updateByPrimaryKey(IpoDeliveryorder record);

	// sequence序列，拼接提货单号
	int sequence();

	// 自提打印列表
	List<IpoDeliveryorder> selectByPickup(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	// 自提打印详细
	IpoPickupExtended selectByPickUp(String methodid);

	// 总页数
	int selectByCounts(@Param("paging") Paging paging, @Param("deliveryMethod") String deliveryMethod);

	// 订单总页数
	int allCounts(@Param("paging") Paging paging);

	// 在线配送列表
	List<IpoExpressExtended> selectByExpress(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	// 更新申请单状态
	int updateByStatus(@Param("deliveryorderId") String deliveryorderId, @Param("approvalStatus") int approvalStatus);

	// 根据用户ID查询申请主表（提货查询）
	List<IpoDeliveryorder> selectByUserid(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);
	
	// 根据提货单号 密码 查提货信息
	IpoDeliveryorder getPickupDeliveryInfo(@Param("delivery") IpoDeliveryorder delivery);
	
	//根据提货单号查 配送单信息
	IpoDeliveryorder getExpressDeliveryInfo(@Param("delivery") IpoDeliveryorder delivery);
	
	
	
	
}