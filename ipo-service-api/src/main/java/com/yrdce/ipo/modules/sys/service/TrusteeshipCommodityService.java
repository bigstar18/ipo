package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;

/**
 * 托管商品 service
 * @author wq
 *
 */
public interface TrusteeshipCommodityService {

	/**
	 * 分页查询可申购的托管商品
	 * @param pageNo
	 * @param pageSize
	 * @param commodity
	 * @return
	 */
	public List<TrusteeshipCommodity> queryApplyForPage(String pageNo,String pageSize,
			TrusteeshipCommodity commodity);
	/**
	 * 查询可申购的托管商品数量
	 * @param commodity
	 * @return
	 */
	public long queryApplyForCount(TrusteeshipCommodity commodity);
	
	
}
