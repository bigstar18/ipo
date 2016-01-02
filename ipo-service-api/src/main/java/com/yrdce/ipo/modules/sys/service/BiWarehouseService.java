package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.BiWarehouse;

/**
 * 仓库
 * 
 * @author chenjing
 *
 */
public interface BiWarehouseService {
	/**
	 *
	 * 查询所有仓库
	 */
	public List<BiWarehouse> findAllWarehuses();

	public Long getWarehousePrimary(String warehouseId);// 根据仓库ID获取仓库号

	public String getWarehouseId(String userId);// 根据仓库管理员获取仓库ID

}