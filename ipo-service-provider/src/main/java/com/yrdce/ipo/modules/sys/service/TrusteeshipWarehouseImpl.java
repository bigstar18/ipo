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
import com.yrdce.ipo.modules.sys.dao.BiWarehouseMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipWarehouseMapper;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeWarehouse;
import com.yrdce.ipo.modules.sys.vo.BiWarehouse;
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

	@Autowired
	private BiWarehouseMapper biWarehouseMapper;

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
	public Integer addTrusteeWare(TrusteeshipWarehouse trusteeshipWarehouse) {
		return null;

	}

	/**
	 * 修改托管某商品的仓库
	 * 
	 * @param trusteeshipWarehouse
	 * @return
	 */
	@Transactional
	public Integer updateTrusteeWare(TrusteeshipWarehouse trusteeshipWarehouse) {
		return null;

	}

	/**
	 * 删除托管某商品的仓库
	 * 
	 * @param commId
	 * @return
	 */
	@Transactional
	public Integer deleteTrusteeWare(String commId) {
		return null;

	}

	@Override
	public List<Integer> getTrusteeshipWarehouseByCommId(String commId) {
		return trustWarehouseMapper.selectWareIdsByCommId(commId);
	}

	/**
	 * 获取所有仓库列表
	 * 
	 * @return
	 */
	@Override
	public List<BiWarehouse> selectAllWarehouses() {
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

}
