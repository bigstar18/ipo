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

	List<IpoDeliveryorder> queryAllDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoDeliveryorder record);

	int getQueryNum(@Param("record") IpoDeliveryorder record);

	List<IpoDeliveryorder> queryCancelDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoDeliveryorder record);

	int getQueryCancelNum(@Param("record") IpoDeliveryorder record);

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

	/**
	 * @Title: selectByPickup
	 * @Description: 自提打印列表
	 * @param @param
	 *            beginnum
	 * @param @param
	 *            endnum
	 * @param @param
	 *            paging
	 */
	List<IpoDeliveryorder> selectByPickup(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	/**
	 * @Title: selectByPickUp
	 * @Description: 自提打印详细
	 * @param @param
	 *            methodid 提货方式id
	 */
	IpoPickupExtended selectByPickUp(String methodid);

	/**
	 * @Title: selectCounts
	 * @Description: 总页数
	 * @param @param
	 *            paging
	 * @param @param
	 *            deliveryMethod
	 * @param @return
	 *            总页数
	 */
	int selectCounts(@Param("paging") Paging paging, @Param("deliveryMethod") String deliveryMethod);

	/**
	 * @Title: selectRevocation
	 * @Description: 订单列表（用于撤销提货页面数据展示）
	 * @param @param
	 *            beginnum
	 * @param @param
	 *            endnum
	 * @param @param
	 *            paging
	 * @param @return
	 *            订单列表
	 */
	List<IpoDeliveryorder> selectRevocation(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	/**
	 * @Title: allCounts
	 * @Description: 订单总页数
	 * @param @param
	 *            paging
	 */
	int allCounts(@Param("paging") Paging paging);

	//
	/**
	 * @Title: selectByExpress
	 * @Description: 在线配送列表
	 * @param @param
	 *            beginnum
	 * @param @param
	 *            endnum
	 * @param @param
	 *            paging
	 */
	List<IpoExpressExtended> selectByExpress(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	/**
	 * @Title: updateByStatus
	 * @Description: 更新申请单状态
	 * @param @param
	 *            deliveryorderId 订单号
	 * @param @param
	 *            approvalStatus 状态值
	 * @param @return
	 *            成功条数
	 */
	int updateByStatus(@Param("deliveryorderId") String deliveryorderId, @Param("approvalStatus") int approvalStatus);

	/**
	 * @Title: updateStatus
	 * @Description: 根据订单号修改状态
	 * @param @param
	 *            deliveryorder 订单号
	 * @param @return
	 *            成功条数
	 */
	int updateStatus(IpoDeliveryorder deliveryorder);

	/**
	 * @Title: selectByUserid
	 * @Description: 根据用户ID查询申请主表（提货查询） 分页
	 * @param @param
	 *            beginnum
	 * @param @param
	 *            endnum
	 * @param @param
	 *            paging
	 * @param @return
	 *            订单集合
	 */
	List<IpoDeliveryorder> selectByUserid(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("paging") Paging paging);

	/**
	 * @Title: getPickupDeliveryInfo
	 * @Description: 根据提货单号 密码 查提货信息
	 * @param @param
	 *            delivery 提货单号
	 * @param @return
	 *            自提订单数据
	 */
	IpoDeliveryorder getPickupDeliveryInfo(@Param("delivery") IpoDeliveryorder delivery);

	/**
	 * @Title: getExpressDeliveryInfo
	 * @Description: 根据提货单号查 配送单信息
	 * @param @param
	 *            delivery 提货单号
	 * @param @return
	 *            配送订单数据
	 */
	IpoDeliveryorder getExpressDeliveryInfo(@Param("delivery") IpoDeliveryorder delivery);

	/**
	 * @Title: selectByFrim
	 * @Description: 根据用户id查询用户名
	 * @param @param
	 *            dealerId 用户id
	 * @param @return
	 *            用户名
	 */
	String selectByFrim(String dealerId);

	/**
	 * @Title: selectByMethodAndId
	 * @Description: 根据提货方式和提货关联ID查找申请主表信息
	 * @param @param
	 *            method 提货方式
	 * @param @param
	 *            id 提货方式id
	 * @param @return
	 *            订单集合
	 */
	IpoDeliveryorder selectByMethodAndId(@Param("deliveryMethod") String method, @Param("methodId") String id);

	/**
	 * @Title: selectAllByStatus
	 * @Description: 查询出库状态前的所有订单
	 * @param @return
	 *            订单集合
	 */
	List<IpoDeliveryorder> selectAllByStatus();

}