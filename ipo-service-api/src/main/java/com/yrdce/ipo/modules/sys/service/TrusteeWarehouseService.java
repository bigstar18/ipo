package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.TrusteeshipWarehouse;

/**
 * 托管仓库 service
 * 
 * @author chenjing
 *
 */
public interface TrusteeWarehouseService {

	/**
	 * 根据商品分页查询托管仓库列表
	 * 
	 * @param page
	 * @param rows
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public List<TrusteeshipWarehouse> queryWarehouseByPage(String page,
			String rows, TrusteeshipWarehouse trusteeshipWarehouse);

	/**
	 * 根据商品查询托管仓库记录数
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public Integer CountWarehouseByExample(
			TrusteeshipWarehouse trusteeshipWarehouse);

	/**
	 * 新增托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public Integer addTrusteeWare(TrusteeshipWarehouse trusteeshipWarehouse);

	/**
	 * 修改托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public Integer updateTrusteeWare(TrusteeshipWarehouse trusteeshipWarehouse);

	/**
	 * 删除托管某商品的仓库
	 * 
	 * @param commId
	 * @return
	 */
	public Integer deleteTrusteeWare(String commId);

}
