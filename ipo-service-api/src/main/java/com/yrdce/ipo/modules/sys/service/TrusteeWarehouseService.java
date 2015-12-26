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
	 * 根据商品查询托管该商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public List<Long> getTrusteeshipWarehouseByCommId(String commId);

	/**
	 * 新增托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public String addTrusteeWare(String commId, String warehouse);

	/**
	 * 修改托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public String updateTrusteeWare(String commId, String warehouse);

	/**
	 * 删除托管某商品的仓库
	 * 
	 * @param commId
	 * @return
	 */
	public String deleteTrusteeWare(String commId);

	/**
	 * 获取已配置托管仓库的商品Id
	 * 
	 * @param commId
	 * @return
	 */
	public List<String> findExsitIds();
}
