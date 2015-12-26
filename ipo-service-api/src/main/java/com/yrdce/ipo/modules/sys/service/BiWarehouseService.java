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

}