package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPayFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterDepositMapper;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterSubscribeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoUnderWriters;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.UnderWriters;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

@Service
public class UnderwriterSubscribeServiceImpl implements
		UnderwriterSubscribeService, Observer {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoUnderwriterSubscribeMapper underwriterSubscribrmapper;

	@Autowired
	private IpoPayFlowMapper payFlowMapper;

	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;

	@Autowired
	private IpoCommodityConfMapper commconfmapper;
	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;

	@Autowired
	private FFirmfundsMapper fundsMapper;

	@Autowired
	private IpoUnderwriterDepositMapper depositmapper;

	@Autowired
	private IpoPositionFlowMapper positionFlowMapper;

	@Override
	public List<UnderwriterSubscribe> getInfosByPage(String page, String rows,
			UnderwriterSubscribe example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoUnderwriterSubscribe record = new IpoUnderwriterSubscribe();
			BeanUtils.copyProperties(example, record);
			List<IpoUnderwriterSubscribe> datalist = underwriterSubscribrmapper
					.getInfosByPage(startIndex, endIndex, record);
			List<UnderwriterSubscribe> datalist2 = new ArrayList<UnderwriterSubscribe>();
			for (IpoUnderwriterSubscribe temp : datalist) {
				UnderwriterSubscribe info = new UnderwriterSubscribe();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getQueryNum(UnderwriterSubscribe example) {
		if (example != null) {
			IpoUnderwriterSubscribe record = new IpoUnderwriterSubscribe();
			BeanUtils.copyProperties(example, record);
			return underwriterSubscribrmapper.getQueryNum(record);
		}
		return 0;
	}

	@Override
	@Transactional
	public String deleteInfo(String ids) {
		String[] subscribeids = ids.split(",");
		int num = 0;
		for (String id : subscribeids) {
			IpoUnderwriterSubscribe example = underwriterSubscribrmapper
					.selectByPrimaryKey(new BigDecimal(id));
			example.setDeleteFlag((short) 1);
			num = num + underwriterSubscribrmapper.updateByPrimaryKey(example);
		}
		if (num == subscribeids.length) {
			return "true";
		}
		return "false";
	}

	@Override
	@Transactional
	public Integer insertInfo(UnderwriterSubscribe example) {
		if (example != null) {
			IpoUnderwriterSubscribe record = new IpoUnderwriterSubscribe();
			BeanUtils.copyProperties(example, record);
			record.setState((short) 1);
			return underwriterSubscribrmapper.insert(record);
		}
		return 0;
	}

	@Override
	public List<UnderWriters> findUnderwriters(String page, String rows,
			UnderWriters example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoUnderWriters record = new IpoUnderWriters();
			BeanUtils.copyProperties(example, record);
			List<IpoUnderWriters> datalist = underwriterSubscribrmapper
					.getUnderwritersByPub(startIndex, endIndex, record);
			List<UnderWriters> datalist2 = new ArrayList<UnderWriters>();
			for (IpoUnderWriters temp : datalist) {
				UnderWriters info = new UnderWriters();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getUnderwritersNum(UnderWriters example) {
		if (example != null) {
			IpoUnderWriters record = new IpoUnderWriters();
			BeanUtils.copyProperties(example, record);
			return underwriterSubscribrmapper.getUnderwritersNum(record);
		}
		return 0;
	}

	@Override
	@Transactional
	public void unfrozen(UnderwriterSubscribe example, BigDecimal frozenFunds,
			String updater) {

		Long subcounts = example.getSubscribecounts();
		BigDecimal subprice = example.getSubscribeprice();
		BigDecimal subFunds = subprice.multiply(new BigDecimal(subcounts));
		IpoCommodityConf commodity = commconfmapper
				.findIpoCommConfByCommid(example.getCommodityid());
		Short publishalgr = commodity.getPublishalgr();
		BigDecimal subHanding = new BigDecimal(0);
		if (publishalgr == 1) {
			subHanding = subFunds.multiply(commodity.getDealerpubcharatio())
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
		}
		if (publishalgr == 2) {
			subHanding = commodity.getDealerpubcharatio();
		}
		String frimId = ipoSpoRationMapper.firmidBySales(example
				.getUnderwriterid());
		IpoUnderwriterSubscribe sub = underwriterSubscribrmapper
				.selectSetByBrokerIdAndCommId(example.getUnderwriterid(),
						example.getCommodityid());
		// 新增货款流水
		DebitFlow debitflow = new DebitFlow();
		debitflow.setAmount(subFunds);
		debitflow.setBusinessType(ChargeConstant.BusinessType.UNDERWRITE
				.getCode());
		debitflow.setChargeType(ChargeConstant.ChargeType.GOODS.getCode());
		debitflow.setCommodityId(example.getCommodityid());
		debitflow.setOrderId(String.valueOf(sub.getSubscribeid()));
		debitflow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
				.getCode());
		debitflow.setPayer(frimId);
		debitflow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitflow
				.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
		debitflow.setCreateUser(example.getCreateUser());
		debitflow.setCreateDate(new Date());
		debitFlowMapper.insert(debitflow);
		// 新增手续费流水
		DebitFlow debitflow2 = new DebitFlow();
		debitflow2.setAmount(subHanding);
		debitflow2.setBusinessType(ChargeConstant.BusinessType.UNDERWRITE
				.getCode());
		debitflow2.setChargeType(ChargeConstant.ChargeType.HANDLING.getCode());
		debitflow2.setCommodityId(example.getCommodityid());
		debitflow2.setOrderId(String.valueOf(sub.getSubscribeid()));
		debitflow2.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
				.getCode());
		debitflow2.setPayer(frimId);
		debitflow2.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitflow2.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT
				.getCode());
		debitflow2.setCreateUser(example.getCreateUser());
		debitflow2.setCreateDate(new Date());
		debitFlowMapper.insert(debitflow2);

		// 计算应解冻资金
		List<IpoUnderwriterSubscribe> datalist = underwriterSubscribrmapper
				.selectUnFrozeSetExcpt(example.getUnderwriterid(), (short) 1,
						sub.getSubscribeid());// 仍未处理的设置信息
		BigDecimal newFrozen = new BigDecimal(0);
		for (IpoUnderwriterSubscribe temp : datalist) {
			newFrozen = newFrozen.add(this.getFundsBySubscirbeId(temp
					.getSubscribeid()));
		}
		BigDecimal unfrozenFunds = frozenFunds.subtract(subFunds)
				.subtract(subHanding).subtract(newFrozen);
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("money", "");
		param1.put("userid", frimId);
		param1.put("amount", new BigDecimal(0).subtract(unfrozenFunds));
		param1.put("moduleid", "40");
		fundsMapper.getfrozen(param1);
		// 把该条认购设置信息状态改为已处理资金状态
		sub.setState((short) 2);
		underwriterSubscribrmapper.updateByPrimaryKey(sub);
		IpoUnderwriterDeposit deposit = depositmapper
				.selectInfoByBrokerId(example.getUnderwriterid());
		deposit.setUpdateDate(new Date());
		deposit.setUpdateUser(updater);
		BigDecimal newAmount = deposit.getAmount().subtract(subFunds)
				.subtract(subHanding);
		deposit.setAmount(newAmount);
		depositmapper.updateByPrimaryKey(deposit);
		// 插入转持仓流水
		this.insertPositionFlow(example, updater);
	}

	@Override
	public String checkExist(UnderwriterSubscribe example) {
		IpoUnderwriterSubscribe record = underwriterSubscribrmapper
				.selectByExample(example);
		if (record != null) {
			return "true";// 已存在
		}
		return "false";
	}

	@Override
	public String checkTotalCounts(String commodityId) {
		Long subcounts = underwriterSubscribrmapper
				.selectSubscibedCounts(commodityId);// 已认购的数量
		Long totalcounts = underwriterSubscribrmapper
				.selectTotalCounts(commodityId);// 供认购的总数
		if (totalcounts != null) {
			if (subcounts == null) {
				subcounts = (long) 0;
			}
			if (subcounts < totalcounts) {
				return "true";
			}
		}
		return "false";
	}

	@Override
	public Float checkRatioSum(String commodityId) {
		Float ratio = underwriterSubscribrmapper.checkRatioSum(commodityId);
		if (ratio != null) {
			return 100 - ratio;
		}
		return (float) 100;
	}

	public BigDecimal getFundsBySubscirbeId(long subId) {
		IpoUnderwriterSubscribe example = underwriterSubscribrmapper
				.selectByPrimaryKey(new BigDecimal(subId));
		Long subcounts = example.getSubscribecounts();
		BigDecimal subprice = example.getSubscribeprice();
		BigDecimal subFunds = subprice.multiply(new BigDecimal(subcounts));
		IpoCommodityConf commodity = commconfmapper
				.findIpoCommConfByCommid(example.getCommodityid());
		Short publishalgr = commodity.getPublishalgr();
		BigDecimal subHanding = new BigDecimal(0);
		if (publishalgr == 1) {
			subHanding = subFunds.multiply(commodity.getDealerpubcharatio())
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
		}
		if (publishalgr == 2) {
			subHanding = commodity.getDealerpubcharatio();
		}
		return subFunds.add(subHanding);
	}

	@Override
	public List<UnderwriterSubscribe> selectUnFrozeSet(String brokerid) {
		List<IpoUnderwriterSubscribe> datalist = underwriterSubscribrmapper
				.selectUnFrozeSet(brokerid, (short) 1);// 仍未处理的设置信息
		List<UnderwriterSubscribe> result = new ArrayList<UnderwriterSubscribe>();
		for (IpoUnderwriterSubscribe temp : datalist) {
			UnderwriterSubscribe example = new UnderwriterSubscribe();
			BeanUtils.copyProperties(temp, example);
			result.add(example);
		}
		return result;
	}

	public void update(Observable observable, Object obj) {
		logger.info("监听财务结算消息内容为" + obj);
		String json = (String) obj;
		try {
			DebitFlow debitFlow = (DebitFlow) JSON.parse(json, DebitFlow.class);
			if ("001".equals(debitFlow.getBusinessType())
					&& "001".equals(debitFlow.getChargeType())
					&& debitFlow.getDebitState() == 2
					&& debitFlow.getDebitMode() == 1) {
				String positionId = debitFlow.getOrderId();
				/*
				 * IpoPublisherPosition example = publisherPositionmapper
				 * .selectByPrimaryKey(new BigDecimal(positionId));
				 * example.setStatus((short) 3);// 扣款成功
				 * publisherPositionmapper.updateByPrimaryKey(example);
				 * stroragemapper.updateTransferstatusByPrimaryKey(
				 * example.getStorageid(), example.getStatus().intValue());
				 */
			}
		} catch (ParseException e) {
			logger.error("监听财务结算消息内容json转换失败" + obj);
			throw new RuntimeException(e);
		}

	}

	@Override
	public String checkFrozenFunds(UnderwriterSubscribe example) {
		Long subcounts = example.getSubscribecounts();
		BigDecimal subprice = example.getSubscribeprice();
		BigDecimal subFunds = subprice.multiply(new BigDecimal(subcounts));
		IpoCommodityConf commodity = commconfmapper
				.findIpoCommConfByCommid(example.getCommodityid());
		Short publishalgr = commodity.getPublishalgr();
		BigDecimal subHanding = new BigDecimal(0);
		if (publishalgr == 1) {
			subHanding = subFunds.multiply(commodity.getDealerpubcharatio())
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
		}
		if (publishalgr == 2) {
			subHanding = commodity.getDealerpubcharatio();
		}
		BigDecimal totalvalue = subFunds.add(subHanding);
		IpoUnderwriterDeposit deposit = depositmapper
				.selectInfoByBrokerId(example.getUnderwriterid());
		if (deposit != null) {
			BigDecimal frozenFunds = depositmapper.selectInfoByBrokerId(
					example.getUnderwriterid()).getAmount();
			if (totalvalue.compareTo(frozenFunds) < 0) {
				return "true";
			}
		}
		return "false";
	}

	// 插入转持仓流水
	public void insertPositionFlow(UnderwriterSubscribe example, String updater) {
		// TODO 保存持仓信息(应保存各个业务记录的主键 )
		PositionFlow positionFlow = new PositionFlow();
		positionFlow.setState(PositionConstant.FlowState.no_turn_goods
				.getCode());
		positionFlow.setCommodityId(example.getCommodityid());
		positionFlow.setFirmId(ipoSpoRationMapper.firmidBySales(example
				.getUnderwriterid()));
		positionFlow.setHoldqty(example.getSubscribecounts());
		positionFlow.setPrice(example.getSubscribeprice());
		positionFlow.setFrozenqty(example.getSubscribecounts());
		positionFlow.setFreeqty((long) 0);
		positionFlow.setCreateUser(updater);
		positionFlow.setCreateDate(new Date());
		positionFlow.setRemark("承销商认购转持仓");
		positionFlow.setBusinessCode(ChargeConstant.BusinessType.UNDERWRITE
				.getCode());
		positionFlow.setRoleCode(ChargeConstant.RoleType.UNDERWRITER.getCode());
		positionFlowMapper.insert(positionFlow);
	}

}
