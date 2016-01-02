package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.BiWarehouseMapper;
import com.yrdce.ipo.modules.sys.vo.BiWarehouse;

/**
 * @author chenjing
 *
 */
@Service("biWarehouseService")
public class BiWarehouseServiceImpl implements BiWarehouseService {

	@Autowired
	private BiWarehouseMapper biWarehouseMapper;

	/**
	 * 获取所有仓库列表
	 * 
	 * @return
	 */

	@Override
	public List<BiWarehouse> findAllWarehuses() {
		List<com.yrdce.ipo.modules.sys.entity.BiWarehouse> dbList = biWarehouseMapper
				.selectAll();
		List<BiWarehouse> dataList = new ArrayList<BiWarehouse>();
		for (com.yrdce.ipo.modules.sys.entity.BiWarehouse item : dbList) {
			BiWarehouse entity = new BiWarehouse();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		}
		return dataList;
	}

	public Long getWarehousePrimary(String warehouseId) {
		return biWarehouseMapper.getPrimaryKey(warehouseId);
	}

	public String getWarehouseId(String userId) {
		return biWarehouseMapper.getWarehouseId(userId);
	}
}
