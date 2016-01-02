package com.yrdce.ipo.modules.warehouse.service;

import java.util.List;

import com.yrdce.ipo.modules.warehouse.vo.IpoStorageVo;
import com.yrdce.ipo.modules.warehouse.vo.VIpoStorageExtended;

/**
 * 入库单接口
 * 
 * @author chenjing
 *
 */
public interface IpoStorageService {

	// 分页查询入库单
	List<VIpoStorageExtended> selectByPage(String page, String rows,
			VIpoStorageExtended storage);

	// 获取查询的总入库单数
	Integer getTotalNum(VIpoStorageExtended storage);

	// 插入指定的对象
	int insert(IpoStorageVo record);

	// 根据仓库管理员获取仓库编号
	String getWarehouseId(String userID);

	// 审核入库单
	Integer checkStorage(String storageId, String result, String checker);

}
