package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipCommodity;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;
/**
 * 托管商品
 * @author wq
 *
 */
@MyBatisDao
public interface IpoTrusteeshipCommodityMapper {

	/**
	 * 分页查询可申购的托管商品
	 * @param startIndex
	 * @param endIndex
	 * @param commodity
	 * @return
	 */
	public List<IpoTrusteeshipCommodity> queryApplyForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("commodity") TrusteeshipCommodity commodity);
	
	 /**
	  * 查询可申购的托管商品数量
	  * @param commodity
	  * @return
	  */
	public long queryApplyForCount( @Param("commodity")TrusteeshipCommodity commodity);
	
	
	
	
	
}
