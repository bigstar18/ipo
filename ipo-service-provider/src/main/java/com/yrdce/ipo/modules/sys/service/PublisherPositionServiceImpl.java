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
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPayFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPublisherPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;
import com.yrdce.ipo.modules.sys.entity.IpoPublisherPosition;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.PublisherPosition;
import com.yrdce.ipo.modules.warehouse.dao.IpoStorageMapper;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorage;

/**
 * @author chenjing
 *
 */
@Service
public class PublisherPositionServiceImpl implements PublisherPositionService,
		Observer {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoCommodityConfMapper commconfmapper;

	@Autowired
	private IpoPublisherPositionMapper publisherPositionmapper;

	@Autowired
	private IpoPositionMapper ipoPositionMapper;

	@Autowired
	private IpoStorageMapper stroragemapper;

	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;

	@Autowired
	private FFirmfundsMapper fundsMapper;

	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;

	@Autowired
	private IpoPayFlowMapper payFlowMapper;

	@Override
	public List<PublisherPosition> getInfoByPage(String page, String rows,
			PublisherPosition example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			List<IpoPublisherPosition> datalist = publisherPositionmapper
					.selectByPage(startIndex, endIndex, record);
			List<PublisherPosition> datalist2 = new ArrayList<PublisherPosition>();
			for (IpoPublisherPosition temp : datalist) {
				PublisherPosition info = new PublisherPosition();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getPubPositionNum(PublisherPosition example) {
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			return publisherPositionmapper.getTotalNum(record);
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer insertPubPoition(PublisherPosition example) {
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			IpoStorage storage = stroragemapper.getStorageByPrimary(example
					.getStorageid());
			storage.setTransferstate(1);// 转持仓新增状态
			int unum = stroragemapper.updateByPrimaryKey(storage);
			int inum = publisherPositionmapper.insert(record);
			if (unum == 1 && inum == 1) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public Long getSaleCounts(String commodityid) {
		Long num = publisherPositionmapper.getSaleCounts(commodityid);
		if (num != null) {
			return num;
		}
		return (long) 0;
	}

	@Override
	@Transactional
	public String frozenFunds(String publisherid, BigDecimal money) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		String userid = ipoSpoRationMapper.firmidBySales(publisherid);
		param.put("userid", userid);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal funds = (BigDecimal) param.get("money");
		if (funds.compareTo(money) < 0) {
			return "false";
		}
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("money", "");
		param1.put("userid", userid);
		param1.put("amount", money);
		param1.put("moduleid", "40");
		fundsMapper.getfrozen(param1);
		return "true";
	}

	@Override
	public PublisherPosition getInfoByStorageId(String storageid) {
		IpoPublisherPosition example = publisherPositionmapper
				.getInfoByStorageId(storageid);
		if (example != null) {
			PublisherPosition record = new PublisherPosition();
			BeanUtils.copyProperties(example, record);
			return record;
		}
		return null;
	}

	@Override
	@Transactional
	public String updateStatus(PublisherPosition example) {
		IpoPublisherPosition record = new IpoPublisherPosition();
		BeanUtils.copyProperties(example, record);
		int num = publisherPositionmapper.updateByPrimaryKey(record);
		int snum = stroragemapper.updateTransferstatusByPrimaryKey(
				record.getStorageid(), record.getStatus().intValue());
		if (num == 1 && snum == 1) {
			return "true";
		}
		return "false";
	}

	@Override
	@Transactional
	public void insertPoundage(PublisherPosition example, BigDecimal funds) {
		// 手续费流水
		DebitFlow debitFlow = new DebitFlow();
		debitFlow.setAmount(funds);
		debitFlow
				.setBusinessType(ChargeConstant.BusinessType.PUBLISH.getCode());
		debitFlow.setChargeType(ChargeConstant.ChargeType.HANDLING.getCode());
		debitFlow.setCommodityId(example.getCommodityid());
		debitFlow.setOrderId(String.valueOf(example.getPositionid()));
		debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
				.getCode());
		debitFlow.setPayer(ipoSpoRationMapper.firmidBySales(example
				.getPublisherid()));
		debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitFlow
				.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
		debitFlow.setCreateUser(example.getUpdater());
		debitFlow.setCreateDate(new Date());
		debitFlowMapper.insert(debitFlow);

	}

	@Override
	@Transactional
	public void insertLoan(PublisherPosition example, BigDecimal funds) {
		// 货款流水
		PayFlow payFlow = new PayFlow();
		payFlow.setAmount(funds);
		payFlow.setBusinessType(ChargeConstant.BusinessType.PUBLISH.getCode());
		payFlow.setChargeType(ChargeConstant.ChargeType.GOODS.getCode());
		payFlow.setCommodityId(example.getCommodityid());
		payFlow.setOrderId(String.valueOf(example.getPositionid()));
		payFlow.setPayState(ChargeConstant.PayState.UNPAY.getCode());
		payFlow.setPayee(ipoSpoRationMapper.firmidBySales(example
				.getPublisherid()));
		payFlow.setPayMode(ChargeConstant.PayMode.ONLINE.getCode());
		payFlow.setPayChannel(ChargeConstant.PayChannel.DEPOSIT.getCode());
		payFlow.setCreateUser(example.getUpdater());
		payFlow.setCreateDate(new Date());
		payFlowMapper.insert(payFlow);

	}

	@Override
	@Transactional
	public String transferPosition(PublisherPosition example) {
		String commid = example.getCommodityid();
		IpoCommodityConf record = commconfmapper
				.findIpoCommConfByCommid(commid);
		String commUnit = record.getContractfactor().toString()
				+ record.getContractfactorname() + "/批";
		String commodityname = record.getCommodityname();
		IpoPosition position = new IpoPosition();
		position.setFirmid(ipoSpoRationMapper.firmidBySales(example
				.getPublisherid()));
		position.setPosition(example.getPubposition());
		position.setCommodityid(commid);
		position.setCommodityname(commodityname);
		position.setPositionPrice(record.getPrice());
		position.setPositionUnit(commUnit);
		position.setOperationTime(new Date());
		int num = ipoPositionMapper.insert(position);
		if (num == 1) {
			return "true";
		}
		return "false";
	}

	@Override
	public void update(Observable observable, Object obj) {
		logger.info("监听财务结算消息内容为" + obj);
		String json = (String) obj;
		try {
			DebitFlow debitFlow = (DebitFlow) JSON.parse(json, DebitFlow.class);
			if ("002".equals(debitFlow.getBusinessType())
					&& "001".equals(debitFlow.getChargeType())
					&& debitFlow.getDebitState() == 2
					&& debitFlow.getDebitMode() == 1) {
				String positionId = debitFlow.getOrderId();
				IpoPublisherPosition example = publisherPositionmapper
						.selectByPrimaryKey(new BigDecimal(positionId));
				example.setStatus((short) 3);// 扣款成功
				publisherPositionmapper.updateByPrimaryKey(example);
				stroragemapper.updateTransferstatusByPrimaryKey(
						example.getStorageid(), example.getStatus().intValue());
			}
		} catch (ParseException e) {
			logger.error("监听财务结算消息内容json转换失败" + obj);
			throw new RuntimeException(e);
		}

	}
}
