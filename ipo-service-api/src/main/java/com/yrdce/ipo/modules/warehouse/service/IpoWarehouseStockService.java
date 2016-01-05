package com.yrdce.ipo.modules.warehouse.service;

import java.util.List;

import com.yrdce.ipo.modules.warehouse.vo.IpoWarehouseStock;

/**
 * 仓库库存接口
 * 
 * @author chenjing
 *
 */
public interface IpoWarehouseStockService {

	/**
	 * 分页查询库存信息
	 * 
	 * @param page
	 * @param rows
	 * @param example
	 * @return
	 */
	public List<IpoWarehouseStock> findWarehouseStockByPage(String page,
			String rows, IpoWarehouseStock example);

	/**
	 * 获取记录数
	 * 
	 * @param example
	 * @return
	 */
	public Integer getQueryNum(IpoWarehouseStock example);
}
