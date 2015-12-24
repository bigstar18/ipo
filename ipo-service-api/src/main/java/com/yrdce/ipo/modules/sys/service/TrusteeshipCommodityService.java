package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Trusteeship;
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
	
	
	/**
	 * 新增商户申购的托管商品
	 * @param trusteeship
	 * @return
	 */
    public int saveApply(Trusteeship trusteeship);
    
    
    /**
     * 查询商户提交的申请
     * @param pageNo
     * @param pageSize
     * @param ship
     * @return
     */
	public List<Trusteeship> queryMyApplyForPage(String pageNo,String pageSize,
			Trusteeship ship);
	
	/**
	 * 查询商户提交的申请数量
	 * @param ship
	 * @return
	 */
	public long queryMyApplyForCount(Trusteeship ship);
	
	/**
	 * 撤销我的申请
	 * @param ship
	 */
	public void cancelMyApply(Trusteeship ship);
	
	
    
}
