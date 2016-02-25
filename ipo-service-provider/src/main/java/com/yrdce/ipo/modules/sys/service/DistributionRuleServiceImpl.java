package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoDistributionRuleMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionRule;
import com.yrdce.ipo.modules.sys.vo.DistributionRule;

@Service("distributionRuleService")
public class DistributionRuleServiceImpl implements DistributionRuleService {
	@Autowired
	private IpoDistributionRuleMapper ipoDistributionRuleMapper;

	// 插入商品分配方式信息
	@Override
	public int insertRuleInfo(DistributionRule distributionRule) throws Exception {
		IpoDistributionRule ipoDistributionRule = new IpoDistributionRule();
		int result = 0;
		if (distributionRule != null) {
			BeanUtils.copyProperties(distributionRule, ipoDistributionRule);
			result = ipoDistributionRuleMapper.insert(ipoDistributionRule);
		}
		return result;
	}

	// 根据商品id查询信息条数
	@Override
	public int infoIsExistence(String commodityid) throws Exception {
		int result = ipoDistributionRuleMapper.selectCountByCommId(commodityid);
		return result;
	}

	// 分页查询
	@Override
	public List<DistributionRule> selectRuleInfoByPages(String page, String rows, DistributionRule distributionRule)
			throws Exception {
		IpoDistributionRule ipoDistributionRule = new IpoDistributionRule();
		if (distributionRule != null) {
			BeanUtils.copyProperties(distributionRule, ipoDistributionRule);
		}
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDistributionRule> ipoDistributionRules = ipoDistributionRuleMapper
				.selectInfoByPages((curpage - 1) * pagesize + 1, curpage * pagesize, ipoDistributionRule);
		List<DistributionRule> distributionRules = new ArrayList<DistributionRule>();
		for (IpoDistributionRule tempIpoDistributionRule : ipoDistributionRules) {
			DistributionRule tempDistributionRule = new DistributionRule();
			BeanUtils.copyProperties(tempIpoDistributionRule, tempDistributionRule);
			distributionRules.add(tempDistributionRule);
		}
		return distributionRules;
	}

	// 查询信息条数
	@Override
	public int selectInfoCounts(DistributionRule distributionRule) throws Exception {
		IpoDistributionRule ipoDistributionRule = new IpoDistributionRule();
		if (distributionRule != null) {
			BeanUtils.copyProperties(distributionRule, ipoDistributionRule);

		}
		int counts = ipoDistributionRuleMapper.selectCounts(ipoDistributionRule);
		return counts;
	}

	// 根据商品代码查询信息
	@Override
	public DistributionRule selectInfoByCommId(String commId) throws Exception {
		DistributionRule distributionRule = null;
		IpoDistributionRule ipoDistributionRule = ipoDistributionRuleMapper.selectInfoByCommId(commId);
		if (ipoDistributionRule != null) {
			distributionRule = new DistributionRule();
			BeanUtils.copyProperties(ipoDistributionRule, distributionRule);

		}
		return distributionRule;

	}

	// 修改分配信息
	@Override
	public int updateInfoByCommId(DistributionRule distributionRule) throws Exception {
		IpoDistributionRule ipoDistributionRule = null;
		if (distributionRule != null) {
			ipoDistributionRule = new IpoDistributionRule();
			BeanUtils.copyProperties(distributionRule, ipoDistributionRule);
		}
		int result = ipoDistributionRuleMapper.updateInfoByCommId(ipoDistributionRule);
		return result;
	}

	// 删除分配信息
	@Override
	public int deleteInfoByCommid(String commid) throws Exception {
		int result = ipoDistributionRuleMapper.deleteInfoByCommid(commid);
		return result;
	}

}
