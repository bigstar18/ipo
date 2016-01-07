package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionExtended;
import com.yrdce.ipo.modules.sys.vo.Distribution;

@Service("distributionService")

public class DistributionServiceImpl implements DistributionService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoDistributionMapper ipoDistributionMapper;

	public IpoDistributionMapper getIpoDistributionMapper() {
		return ipoDistributionMapper;
	}

	public void setIpoDistributionMapper(IpoDistributionMapper ipoDistributionMapper) {
		this.ipoDistributionMapper = ipoDistributionMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Distribution> getDistriList(String page, String rows, String userid, String condition) throws Exception {
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Distribution> list2 = new ArrayList<Distribution>();
		List<IpoDistributionExtended> list;
		String time = DateUtil.getTime(1);
		if (condition.equals("yes")) {
			list = ipoDistributionMapper.getAllByPage((curpage - 1) * pagesize + 1, curpage * pagesize, userid, time);
		} else {
			list = ipoDistributionMapper.getAllByPage((curpage - 1) * pagesize + 1, curpage * pagesize, userid, null);
		}
		for (int i = 0; i < list.size(); i++) {
			Distribution distrib = new Distribution();
			BeanUtils.copyProperties(list.get(i), distrib);
			list2.add(distrib);
		}
		return list2;
	}

	@Override
	public int getAllDistris(String userid, String condition) throws Exception {
		if (condition.equals("yes")) {
			String time = DateUtil.getTime(1);
			return ipoDistributionMapper.countByExample(userid, time);
		} else {
			return ipoDistributionMapper.countByExample(userid, null);
		}
	}

	/*
	 * 获取客户所有配号信息
	 */
	@Override
	public List<Distribution> findAll() throws Exception {
		List<Distribution> list2 = new ArrayList<Distribution>();
		List<IpoDistribution> list = ipoDistributionMapper.selectAll();
		for (int i = 0; i < list.size(); i++) {
			Distribution distrib = new Distribution();
			BeanUtils.copyProperties(list.get(i), distrib);
			list2.add(distrib);
		}
		return list2;
	}

	@Override
	public List<Distribution> getDistriAllList(String page, String rows) throws Exception {
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Distribution> list2 = new ArrayList<Distribution>();
		List<IpoDistribution> list = ipoDistributionMapper.selectByPage((curpage - 1) * pagesize + 1, curpage * pagesize);
		for (int i = 0; i < list.size(); i++) {
			Distribution distrib = new Distribution();
			BeanUtils.copyProperties(list.get(i), distrib);
			list2.add(distrib);
		}
		return list2;
	}

	@Override
	public int getAllDistribution() throws Exception {
		int i = 0;
		i = ipoDistributionMapper.selectByCount();
		return i;
	}

	// 根据冻结货款情况 查询 li
	@Override
	public List<Distribution> getInfobyFrozen(String ptime) throws Exception {
		// TODO Auto-generated method stub
		List<IpoDistribution> distributions = ipoDistributionMapper.getInfobyDate(ptime);
		List<Distribution> distributions2 = new ArrayList<Distribution>();
		for (IpoDistribution ipoDistribution : distributions) {
			Distribution distribution = new Distribution();
			BeanUtils.copyProperties(ipoDistribution, distribution);
			distributions2.add(distribution);
		}
		return distributions2;
	}

	@Override // hxx
	public List<Distribution> queryUnsettleOrdersByCommId(String commId) throws Exception {
		List<IpoDistribution> distributions = ipoDistributionMapper.queryUnsettledByCommoId(commId);
		List<Distribution> result = new ArrayList<Distribution>();
		if (distributions != null && !distributions.isEmpty()) {
			logger.info("申购结算：查询配号摇号记录表，frozen != 3, 找到记录数={}", commId);

			for (IpoDistribution ipoDistribution : distributions) {
				Distribution distribution = new Distribution();
				BeanUtils.copyProperties(ipoDistribution, distribution);
				distribution.setOrderid(String.valueOf(ipoDistribution.getId()));// 坑货啊
				result.add(distribution);
			}
		} else
			logger.info("申购结算：商品={} 没有找到相应的配号摇号记录", commId);
		return result;
	}

	@Override // hxx
	public int updateOrderSettled(String orderId) throws Exception {
		return ipoDistributionMapper.updateSettledById(Integer.parseInt(orderId));
	}

	@Override
	public List<Distribution> getBallotInfo(String page, String rows, String userid, String date) {
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Distribution> list2 = new ArrayList<Distribution>();
		List<IpoDistribution> list = ipoDistributionMapper.selectByPage((curpage - 1) * pagesize + 1, curpage * pagesize);
		for (int i = 0; i < list.size(); i++) {
			Distribution distrib = new Distribution();
			BeanUtils.copyProperties(list.get(i), distrib);
			list2.add(distrib);
		}
		return list2;
	}

	@Override
	public int ballotCounts(String userid, String date) {
		// TODO Auto-generated method stub
		return 0;
	}
}
