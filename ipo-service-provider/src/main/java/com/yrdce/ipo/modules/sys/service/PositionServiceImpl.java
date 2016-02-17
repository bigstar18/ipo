package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoPositionFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionReduceMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPositionFlow;
import com.yrdce.ipo.modules.sys.entity.IpoPositionReduce;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
/**
 * Iop 持仓 service
 * @author wq 2016-2-16
 *
 */
public class PositionServiceImpl implements PositionService {

	@Autowired
	private IpoPositionFlowMapper positionFlowMapper;
	@Autowired
	private IpoPositionReduceMapper positionReduceMapper;
	
	
	 /**
     * 查询ipo 持仓流水
     * @param positionFlow
     * @return
     */
	public List<PositionFlow> queryFlowForList(PositionFlow positionFlow){
		List<IpoPositionFlow> dbList = positionFlowMapper.queryForList(positionFlow);
		List<PositionFlow> dataList = new ArrayList<PositionFlow>();
		for (IpoPositionFlow item : dbList) {
			PositionFlow entity = new PositionFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setFreeqty(entity.getHoldqty()-entity.getFrozenqty());
			entity.setStateName(PositionConstant.FlowState.getName(entity.getState()));
			dataList.add(entity);
		}
		return dataList;
	}
	
	
	/**
	 * 分页查询 ipo 持仓流水
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param positionFlow
	 * @return
	 */
	public List<PositionFlow> queryFlowForPage(String pageNoStr, String pageSizeStr, PositionFlow positionFlow) {
		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoPositionFlow> dbList = positionFlowMapper.queryForPage(startIndex,endIndex,positionFlow);
		List<PositionFlow> dataList = new ArrayList<PositionFlow>();
		for (IpoPositionFlow item : dbList) {
			PositionFlow entity = new PositionFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setFreeqty(entity.getHoldqty()-entity.getFrozenqty());
			entity.setStateName(PositionConstant.FlowState.getName(entity.getState()));
			dataList.add(entity);
		}
		return dataList;
	}
	
	/**
	 * 查询 ipo 持仓流水数量
	 * @param positionFlow
	 * @return
	 */
	public long queryFlowForCount(PositionFlow positionFlow) {
		long count = positionFlowMapper.queryForCount(positionFlow);
		return count;
	}
	
	
	/**
	 * 新增 ipo 持仓流水
	 * @param positionFlow
	 * @return
	 */
	@Transactional
	public int savePositionFlow(PositionFlow positionFlow) {
		positionFlow.setState(PositionConstant.FlowState.no_turn_goods.getCode());
		positionFlow.setFrozenqty(0L);
		return positionFlowMapper.insert(positionFlow);
	}
	
	
	/**
	 * 查询减持仓设置
	 * @param positionReduce
	 * @return
	 */
	public List<PositionReduce> queryReduceForList(PositionReduce positionReduce){
		List<IpoPositionReduce> dbList = positionReduceMapper.queryForList(positionReduce);
		List<PositionReduce> dataList = new ArrayList<PositionReduce>();
		for (IpoPositionReduce item : dbList) {
			PositionReduce entity = new PositionReduce();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.ReduceState.getName(entity.getState()));
			dataList.add(entity);
		}
		return dataList;
	}
	
	
	/**
	 * 新增 减持仓设置
	 * @param positionReduce
	 * @return
	 */
	@Transactional
	public int savePositionReduce(PositionReduce positionReduce){
		positionReduce.setState(PositionConstant.ReduceState.no_reduce.getCode());
		positionReduce.setDeleteFlag(0);
		return positionReduceMapper.insert(positionReduce);
	}
	
	
	
	
	
	
}
