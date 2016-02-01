package com.yrdce.ipo.modules.sys.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.BrBrokerMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPayFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoPublisherSettle;
import com.yrdce.ipo.modules.sys.vo.PublisherBalance;
import com.yrdce.ipo.modules.sys.vo.PublisherSettle;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * @author chenjing
 *
 */
@Service("brBrokerService")
public class BrBrokerServiceImpl implements BrBrokerService {

	@Autowired
	private BrBrokerMapper brBrokerMapper;

	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;

	@Autowired
	private IpoPayFlowMapper payFlowMapper;

	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;

	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfmapper;

	public BrBrokerMapper getBrBrokerMapper() {
		return brBrokerMapper;
	}

	public void setBrBrokerMapper(BrBrokerMapper brBrokerMapper) {
		this.brBrokerMapper = brBrokerMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VBrBroker> findAllPublisher() {
		try {
			List<BrBroker> blist = brBrokerMapper.findAllPublisher();
			List<VBrBroker> blist2 = new ArrayList<VBrBroker>();
			for (BrBroker temp : blist) {
				VBrBroker brbroker = new VBrBroker();
				BeanUtils.copyProperties(temp, brbroker);
				blist2.add(brbroker);
			}
			return blist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int insert(VBrBroker record) {
		BrBroker brBroker = new BrBroker();
		if (record != null) {
			BeanUtils.copyProperties(record, brBroker);
			return brBrokerMapper.insert(brBroker);
		}
		return 0;
	}

	@Override
	// hxx
	public VBrBroker queryBrokerById(String brokerId) {
		BrBroker broker = brBrokerMapper.selectById(brokerId);
		if (broker != null) {
			VBrBroker brbroker = new VBrBroker();
			BeanUtils.copyProperties(broker, brbroker);
			return brbroker;
		}
		return null;
	}

	@Override
	public List<VBrBroker> findAllUnderwriter() {
		List<BrBroker> blist = brBrokerMapper.findAllUnderwriter();
		List<VBrBroker> blist2 = new ArrayList<VBrBroker>();
		for (BrBroker temp : blist) {
			VBrBroker brbroker = new VBrBroker();
			BeanUtils.copyProperties(temp, brbroker);
			blist2.add(brbroker);
		}
		return blist2;
	}

	@Override
	public PublisherBalance findBalance(String publisherid, String today) {
		String firmid = ipoSpoRationMapper.firmidBySales(publisherid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date curday = sdf.parse(today);
			Calendar c = Calendar.getInstance();
			c.setTime(curday);
			int day = c.get(Calendar.DATE);
			c.set(Calendar.DATE, day - 1);
			String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
					.getTime());
			com.yrdce.ipo.modules.sys.entity.PublisherBalance example = brBrokerMapper
					.findBalance(firmid, today, dayBefore);
			if (example != null) {
				PublisherBalance balance = new PublisherBalance();
				BeanUtils.copyProperties(example, balance);
				return balance;
			}
			return null;
		} catch (ParseException e) {
			Log.debug("查询交易商当日和上日余额异常");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<PublisherSettle> findLoanAndHandling(String publisherid,
			String today) {
		List<IpoPublisherSettle> plist = payFlowMapper
				.selectPublisherSettleByPublisher(publisherid, today);
		List<PublisherSettle> dlist = new ArrayList<PublisherSettle>();
		for (IpoPublisherSettle temp : plist) {
			PublisherSettle example = new PublisherSettle();
			BeanUtils.copyProperties(temp, example);
			String commid = temp.getCommodityid();
			IpoCommodityConf comm = ipoCommodityConfmapper
					.findIpoCommConfByCommid(commid);
			BeanUtils.copyProperties(comm, example);
			dlist.add(example);
		}
		return dlist;
	}

}
