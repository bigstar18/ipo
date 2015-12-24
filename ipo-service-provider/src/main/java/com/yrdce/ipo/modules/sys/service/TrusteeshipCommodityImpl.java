package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipCommodity;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;
/**
 * 托管商品 service
 * @author wq
 *
 */
@Service
public class TrusteeshipCommodityImpl implements TrusteeshipCommodityService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoTrusteeshipCommodityMapper mapper;
	
	
	/**
	 * 分页查询可申购的托管商品
	 * @param pageNo
	 * @param pageSize
	 * @param commodity
	 * @return
	 */
	public List<TrusteeshipCommodity> queryApplyForPage(String pageNoStr,
			String pageSizeStr, TrusteeshipCommodity commodity) {
		
		int startIndex=PageUtil.getStartIndex(pageNoStr, pageSizeStr); 
		int endIndex=PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoTrusteeshipCommodity> dbList= mapper.queryApplyForPage(startIndex, endIndex, commodity);
		List<TrusteeshipCommodity> dataList=new ArrayList<TrusteeshipCommodity>();
		for(IpoTrusteeshipCommodity item :dbList){
			TrusteeshipCommodity entity=new TrusteeshipCommodity();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		}
		return dataList;
	}

	
	/**
	 * 查询可申购的托管商品数量
	 * @param commodity
	 * @return
	 */
	public long queryApplyForCount(TrusteeshipCommodity commodity) {
		 long count=mapper.queryApplyForCount(commodity);
		 return count;
	}

	
	
	
	
	
	
}
