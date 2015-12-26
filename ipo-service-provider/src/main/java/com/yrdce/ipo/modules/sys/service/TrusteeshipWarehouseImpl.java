package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipWarehouseMapper;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeWarehouse;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipWarehouse;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipWarehouse;

/**
 * 托管仓库 service
 * 
 * @author chenjing
 *
 */
@Service
public class TrusteeshipWarehouseImpl implements TrusteeWarehouseService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoTrusteeshipWarehouseMapper trustWarehouseMapper;

	/**
	 * 根据商品分页查询托管仓库列表
	 * 
	 * @param page
	 * @param rows
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public List<TrusteeshipWarehouse> queryWarehouseByPage(String page,
			String rows, TrusteeshipWarehouse trusteeshipWarehouse) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		IpoTrusteeWarehouse example = new IpoTrusteeWarehouse();
		if (trusteeshipWarehouse != null) {
			BeanUtils.copyProperties(trusteeshipWarehouse, example);
		}
		List<IpoTrusteeWarehouse> dbList = trustWarehouseMapper
				.selectByCommodity(startIndex, endIndex, example);
		List<TrusteeshipWarehouse> dataList = new ArrayList<TrusteeshipWarehouse>();
		for (IpoTrusteeWarehouse item : dbList) {
			TrusteeshipWarehouse entity = new TrusteeshipWarehouse();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 根据商品查询托管仓库记录数
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	public Integer CountWarehouseByExample(
			TrusteeshipWarehouse trusteeshipWarehouse) {
		IpoTrusteeWarehouse example = new IpoTrusteeWarehouse();
		if (trusteeshipWarehouse != null) {
			BeanUtils.copyProperties(trusteeshipWarehouse, example);
		}
		return trustWarehouseMapper.getQueryNum(example);
	}

	/**
	 * 新增托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	@Transactional
	public String addTrusteeWare(String commId, String warehouse) {
		String[] wareIds = warehouse.split(",");
		IpoTrusteeshipWarehouse temp = new IpoTrusteeshipWarehouse();
		temp.setCommodityId(commId);
		int mark = 0;
		for (int i = 0; i < wareIds.length; i++) {
			temp.setWarehouseId(Long.parseLong(wareIds[i]));
			trustWarehouseMapper.insert(temp);
			mark++;
		}
		if (mark != 0) {
			return "true";
		}
		return "false";
	}

	/**
	 * 修改托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	@Transactional
	public String updateTrusteeWare(String commId, String warehouse) {
		String result1 = this.deleteTrusteeWare(commId);
		String result2 = this.addTrusteeWare(commId, warehouse);
		if (result1.equals("true") && result2.equals("true")) {
			return "true";
		}
		return "false";
	}

	/**
	 * 删除托管某商品的仓库
	 * 
	 * @param commId
	 * @return
	 */
	@Transactional
	public String deleteTrusteeWare(String commId) {
		int num = trustWarehouseMapper.deleteByCommId(commId);
		if (num != 0) {
			return "true";
		} else {
			return "false";
		}

	}

	@Override
	public List<Long> getTrusteeshipWarehouseByCommId(String commId) {
		return trustWarehouseMapper.selectWareIdsByCommId(commId);
	}

	@Override
	public List<String> findExsitIds() {
		return trustWarehouseMapper.selectCommIDs();
	}

}
