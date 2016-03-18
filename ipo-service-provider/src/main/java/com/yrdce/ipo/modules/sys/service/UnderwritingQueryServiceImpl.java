package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterSubscribeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.UnderwritingQuery;

/**
 * 
 * @ClassName: UnderwritingQueryServiceImpl
 * @Description:承销会员查询
 * @author bob
 */
@Service
public class UnderwritingQueryServiceImpl implements UnderwritingQueryService {

	static Logger logger = LoggerFactory.getLogger(UnderwritingQueryServiceImpl.class);
	@Autowired
	private IpoUnderwriterSubscribeMapper ipoUnderwriterSubscribeMapper;
	@Autowired
	private IpoCommodityMapper ipoCommodityMapper;

	// 商品承销信息
	@Override
	public List<UnderwritingQuery> getUnderInfo(String page, String rows, UnderwritingQuery underwriting)
			throws Exception {
		logger.info("商品承销信息");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoUnderwriterSubscribe ipoUnderwriterSub = new IpoUnderwriterSubscribe();
		BeanUtils.copyProperties(underwriting, ipoUnderwriterSub);
		List<IpoUnderwriterSubscribe> list1 = ipoUnderwriterSubscribeMapper
				.findInfosByPage((curpage - 1) * pagesize + 1, curpage * pagesize, ipoUnderwriterSub);
		List<UnderwritingQuery> list2 = new ArrayList<UnderwritingQuery>();
		for (IpoUnderwriterSubscribe ipoUnderwriterSubscribe : list1) {
			String commodityid = ipoUnderwriterSubscribe.getCommodityid();
			IpoCommodity ipoCommodity = ipoCommodityMapper.queryByComid(commodityid);
			UnderwritingQuery underwritingQuery = new UnderwritingQuery();
			BeanUtils.copyProperties(ipoUnderwriterSubscribe, underwritingQuery);
			underwritingQuery.setCommodityname(ipoCommodity.getCommodityname());
			list2.add(underwritingQuery);
		}
		return list2;
	}

	@Override
	public Integer getQueryNum(UnderwritingQuery example) {
		IpoUnderwriterSubscribe record = new IpoUnderwriterSubscribe();
		BeanUtils.copyProperties(example, record);
		return ipoUnderwriterSubscribeMapper.findQueryNum(record);
	}
}
