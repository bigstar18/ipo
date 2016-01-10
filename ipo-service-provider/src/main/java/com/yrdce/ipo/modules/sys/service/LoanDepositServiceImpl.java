package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterDepositMapper;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterSubscribeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.Firmcurfunds;
import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

/*
 * 有关ipo中承销会员资金服务
 * 李伟东
 * */

@Service("loanDepositService")
public class LoanDepositServiceImpl implements LoanDepositService {
	static org.slf4j.Logger logger = LoggerFactory.getLogger(LoanDepositServiceImpl.class);
	@Autowired
	private IpoUnderwriterSubscribeMapper ipoUnderwriterSubscribe;
	@Autowired
	private IpoUnderwriterDepositMapper depositMapper;

	@Override
	public List<UnderwriterSubscribe> GetAllInfo(String page, String rows, String underwriterid) {
		logger.info("认购资金明细");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoUnderwriterSubscribe> ipoUnderList;
		if (underwriterid.equals("no")) {
			underwriterid = null;
		}
		ipoUnderList = ipoUnderwriterSubscribe.selectFunds((curpage - 1) * pagesize + 1, curpage * pagesize,
				underwriterid);
		List<UnderwriterSubscribe> underlist = new ArrayList<UnderwriterSubscribe>();
		for (IpoUnderwriterSubscribe ipoUnder : ipoUnderList) {
			UnderwriterSubscribe under = new UnderwriterSubscribe();
			BeanUtils.copyProperties(ipoUnder, under);
			underlist.add(under);
		}
		return underlist;
	}

	@Override
	public int getpage(String underwriterid) {
		if (underwriterid.equals("no")) {
			underwriterid = null;
		}
		return ipoUnderwriterSubscribe.selectPage(underwriterid);
	}

	@Override
	public List<Firmcurfunds> GetInfoByName(String name) {

		return null;
	}

	@Override
	public List<Firmcurfunds> GetInfoByType(int memberType) {
		return null;
	}

	/**
	 * li 认购资金 2016.1.9
	 */
	@Override
	public List<UnderwriterDeposit> getSubFundsInfo(String page, String rows, String underwriterid) {
		int tempPae = Integer.parseInt(page);
		int temppRows = Integer.parseInt(rows);
		int beginnum = (tempPae - 1) * temppRows + 1;
		int endnum = tempPae * temppRows;
		List<IpoUnderwriterDeposit> deposits = depositMapper.getSubFundsInfo(beginnum, endnum, underwriterid);
		List<UnderwriterDeposit> tempDeposits = null;
		if (deposits.size() != 0) {
			tempDeposits = new ArrayList<UnderwriterDeposit>();
			for (IpoUnderwriterDeposit ipoUnderwriterDeposit : deposits) {
				UnderwriterDeposit deposit = new UnderwriterDeposit();
				BeanUtils.copyProperties(ipoUnderwriterDeposit, deposit);
				tempDeposits.add(deposit);
			}
		}
		return tempDeposits;
	}

	@Override
	public int getSubFundsInfoCounts(String underwriterid) {
		int counts = depositMapper.getSubFundsInfoCounts(underwriterid);
		return counts;
	}
}
