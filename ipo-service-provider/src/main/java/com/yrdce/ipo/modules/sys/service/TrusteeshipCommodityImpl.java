package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.TrusteeshipConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeship;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipCommodity;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;
/**
 * 托管商品 service
 * @author wq
 *
 */
@Service
public   class TrusteeshipCommodityImpl implements TrusteeshipCommodityService {
	
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

	
	
	/**
	 * 新增商户申购的托管商品
	 * @param trusteeship
	 * @return
	 */
	@Transactional
    public int saveApply(Trusteeship trusteeship){
		trusteeship.setCreateDate(new Date());
		trusteeship.setState(TrusteeshipConstant.State.APPLY.getCode());
    	return mapper.insertApply(trusteeship);
    }


	/**
	 * 查询商户提交的申请 
	 */
	public List<Trusteeship> queryMyApplyForPage(String pageNoStr,
			String pageSizeStr, Trusteeship ship) {
		int startIndex=PageUtil.getStartIndex(pageNoStr, pageSizeStr); 
		int endIndex=PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoTrusteeship> dbList= mapper.queryMyApplyForPage(startIndex, endIndex, ship);
		List<Trusteeship> dataList=new ArrayList<Trusteeship>();
		for(IpoTrusteeship item :dbList){
			Trusteeship entity=new Trusteeship();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(TrusteeshipConstant.State.getName(item.getState()));
			dataList.add(entity);
		}
		return dataList;
	}


	/**
	 * 查询商户提交的申请数量 
	 */
	public long queryMyApplyForCount(Trusteeship ship) {
		long count=mapper.queryMyApplyForCount(ship);
		return count;
	}
	
	
	/**
	 * 撤销我的申请
	 */
	@Transactional
	public void cancelMyApply(Trusteeship ship) {
		ship.setState(TrusteeshipConstant.State.CANCEL.getCode());
		ship.setUpdateDate(new Date());
		logger.info(ship.toString());
		mapper.canelMyApply(ship);
	}
	
	
}
