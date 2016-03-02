package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoPositionFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionReduceMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPositionFlow;
import com.yrdce.ipo.modules.sys.entity.IpoPositionReduce;
import com.yrdce.ipo.modules.sys.entity.IpoPubPositionFlow;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.PubPositionFlow;

/**
 * Iop 持仓 service
 * 
 * @author wq 2016-2-16
 *
 */
public class PositionServiceImpl implements PositionService {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoPositionFlowMapper positionFlowMapper;
	@Autowired
	private IpoPositionReduceMapper positionReduceMapper;
	@Autowired
	private TCustomerholdsumMapper customerholdsumMapper;

	/**
	 * 查询ipo 持仓流水
	 * 
	 * @param positionFlow
	 * @return
	 */
	public List<PositionFlow> queryFlowForList(PositionFlow positionFlow) {
		List<IpoPositionFlow> dbList = positionFlowMapper
				.queryForList(positionFlow);
		List<PositionFlow> dataList = new ArrayList<PositionFlow>();
		for (IpoPositionFlow item : dbList) {
			PositionFlow entity = new PositionFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.FlowState.getName(entity
					.getState()));
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	public PositionFlow findFlow(Long id) {
		PositionFlow positionFlow = new PositionFlow();
		positionFlow.setId(id);
		List<IpoPositionFlow> dbList = positionFlowMapper
				.queryForList(positionFlow);
		if (dbList != null && !dbList.isEmpty()) {
			IpoPositionFlow item = dbList.get(0);
			PositionFlow entity = new PositionFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.FlowState.getName(entity
					.getState()));
			return entity;
		}
		return null;
	}

	/**
	 * 分页查询 ipo 持仓流水
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param positionFlow
	 * @return
	 */
	public List<PositionFlow> queryFlowForPage(String pageNoStr,
			String pageSizeStr, PositionFlow positionFlow) {
		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoPositionFlow> dbList = positionFlowMapper.queryForPage(
				startIndex, endIndex, positionFlow);
		List<PositionFlow> dataList = new ArrayList<PositionFlow>();
		for (IpoPositionFlow item : dbList) {
			PositionFlow entity = new PositionFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.FlowState.getName(entity
					.getState()));
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 查询 ipo 持仓流水数量
	 * 
	 * @param positionFlow
	 * @return
	 */
	public long queryFlowForCount(PositionFlow positionFlow) {
		long count = positionFlowMapper.queryForCount(positionFlow);
		return count;
	}

	/**
	 * 新增 ipo 持仓流水
	 * 
	 * @param positionFlow
	 * @return
	 */
	@Transactional
	public int savePositionFlow(PositionFlow positionFlow) {
		positionFlow.setState(PositionConstant.FlowState.no_turn_goods
				.getCode());
		return positionFlowMapper.insert(positionFlow);
	}

	/**
	 * 查询减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	public List<PositionReduce> queryReduceForList(PositionReduce positionReduce) {
		List<IpoPositionReduce> dbList = positionReduceMapper
				.queryForList(positionReduce);
		List<PositionReduce> dataList = new ArrayList<PositionReduce>();
		for (IpoPositionReduce item : dbList) {
			PositionReduce entity = new PositionReduce();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.ReduceState.getName(entity
					.getState()));
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 分页查询减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	public List<PositionReduce> queryReduceForListByPage(String page,
			String row, PositionReduce positionReduce) {
		int startIndex = PageUtil.getStartIndex(page, row);
		int endIndex = PageUtil.getEndIndex(page, row);
		List<IpoPositionReduce> dbList = positionReduceMapper
				.queryForPositionId(startIndex, endIndex, positionReduce);
		List<PositionReduce> dataList = new ArrayList<PositionReduce>();
		for (IpoPositionReduce item : dbList) {
			PositionReduce entity = new PositionReduce();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.ReduceState.getName(entity
					.getState()));
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 新增 减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	@Transactional
	public int savePositionReduce(PositionReduce positionReduce) {
		positionReduce.setState(PositionConstant.ReduceState.no_reduce
				.getCode());
		if (positionReduce.getCreateDate() == null) {
			positionReduce.setCreateDate(new Date());
		}
		;
		return positionReduceMapper.insert(positionReduce);
	}

	/**
	 * 逻辑删除减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	@Transactional
	public int deletePositionReduce(PositionReduce positionReduce) {
		if (positionReduce.getUpdateDate() == null) {
			positionReduce.setUpdateDate(new Date());
		}
		;
		return positionReduceMapper.deleteById(positionReduce);
	}

	/**
	 * 更新减持状态
	 */
	@Transactional
	public int updateReduceState(PositionReduce positionReduce) {
		if (positionReduce.getUpdateDate() == null) {
			positionReduce.setUpdateDate(new Date());
		}
		;
		return positionReduceMapper.updateState(positionReduce);
	}

	/**
	 * 客户持仓减持
	 * 
	 * @param positionReduce
	 */
	@Transactional
	public void reduceeCustomerHold(PositionReduce positionReduce) {
		Long reduceId = positionReduce.getId();
		String customerid = positionReduce.getFirmId() + "00";
		String commodityid = positionReduce.getCommodityId();
		short bsFlag = 1; // 买卖标志 1:买 buy，2:卖 sell
		TCustomerholdsum dbCustomerHold = customerholdsumMapper
				.selectByPrimaryKey(customerid, commodityid, bsFlag);
		if (dbCustomerHold == null) {
			throw new RuntimeException("解冻客户持仓记录不存在,[reduceId:" + reduceId
					+ ",customerid:" + customerid + "," + "commodityid:"
					+ commodityid + ",bsFlag:" + bsFlag + "]");
		}
		;
		TCustomerholdsum param = new TCustomerholdsum();
		BeanUtils.copyProperties(dbCustomerHold, param);
		Long frozenqty = dbCustomerHold.getFrozenqty()
				- positionReduce.getReduceqty();
		if (frozenqty < 0) {
			frozenqty = 0L;
		}
		;
		param.setFrozenqty(frozenqty);
		customerholdsumMapper.updateByPrimaryKey(param);
		// 更新状态
		positionReduce.setState(PositionConstant.ReduceState.reduce.getCode());
		if (positionReduce.getUpdateDate() == null) {
			positionReduce.setUpdateDate(new Date());
		}
		;
		positionReduceMapper.updateState(positionReduce);
		// 更新释放数量
		Long flowId = positionReduce.getPositionFlowId();
		PositionFlow dbPositionFlow = findFlow(flowId);
		Long freeqty = dbPositionFlow.getFreeqty();
		if (freeqty == null) {
			freeqty = 0L;
		}
		;
		freeqty += positionReduce.getReduceqty();
		dbPositionFlow.setFreeqty(freeqty);
		dbPositionFlow.setUpdateDate(new Date());
		dbPositionFlow.setUpdateUser(positionReduce.getUpdateUser());
		positionFlowMapper.updateFreeqty(dbPositionFlow);

	}

	@Override
	public List<PubPositionFlow> queryPubFlowForPage(String pageNoStr,
			String pageSizeStr, PubPositionFlow positionFlow) {
		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoPubPositionFlow> dbList = positionFlowMapper
				.queryPubFlowForPage(startIndex, endIndex, positionFlow);
		List<PubPositionFlow> dataList = new ArrayList<PubPositionFlow>();
		for (IpoPubPositionFlow item : dbList) {
			PubPositionFlow entity = new PubPositionFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(PositionConstant.FlowState.getName(entity
					.getState()));
			dataList.add(entity);
		}
		return dataList;
	}

	@Override
	public long queryPubFlowForCount(PubPositionFlow positionFlow) {
		long count = positionFlowMapper.queryPubFlowForCount(positionFlow);
		return count;
	}

	@Override
	public int queryReduceCount(PositionReduce positionReduce) {
		return positionReduceMapper.quertReduceCount(positionReduce);
	}

}
