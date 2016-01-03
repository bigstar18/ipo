package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.TrusteeshipConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipHisMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeship;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipHis;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;

/**
 * 托管商品 service
 * 
 * @author wq
 *
 */
@Service
public class TrusteeshipCommodityImpl implements TrusteeshipCommodityService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoTrusteeshipCommodityMapper shipCommodityMapper;
	@Autowired
	private IpoTrusteeshipMapper shipMapper;
	@Autowired
	private IpoTrusteeshipHisMapper shipHisMapper;
	@Autowired
	private IpoPositionMapper positionMapper;
	@Autowired
	private IpoCommodityConfMapper commodityConfMapper;

	/**
	 * 分页查询查询托管商品计划
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param commodity
	 * @return
	 */
	public List<TrusteeshipCommodity> queryPlanForPage(String pageNoStr,
			String pageSizeStr, TrusteeshipCommodity commodity) {

		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoTrusteeshipCommodity> dbList = shipCommodityMapper
				.queryApplyForPage(startIndex, endIndex, commodity);
		List<TrusteeshipCommodity> dataList = new ArrayList<TrusteeshipCommodity>();
		for (IpoTrusteeshipCommodity item : dbList) {
			TrusteeshipCommodity entity = new TrusteeshipCommodity();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 查询可申购的托管计划数量
	 * 
	 * @param commodity
	 * @return
	 */
	public long queryPlanForCount(TrusteeshipCommodity commodity) {
		long count = shipCommodityMapper.queryApplyForCount(commodity);
		return count;
	}

	/**
	 * 删除托管计划
	 * 
	 * @param id
	 */
	@Transactional
	public void deletePlan(TrusteeshipCommodity commodity) {
		commodity.setUpdateDate(new Date());
		shipCommodityMapper.deleteById(commodity);
	}

	/**
	 * 添加托管计划
	 * 
	 * @param commodity
	 */
	@Transactional
	public void savePlan(TrusteeshipCommodity commodity) {
		commodity.setCreateDate(new Date());
		shipCommodityMapper.insert(commodity);
	}

	/**
	 * 更新托管计划
	 */
	@Transactional
	public void updatePlan(TrusteeshipCommodity commodity) {
		commodity.setUpdateDate(new Date());
		shipCommodityMapper.update(commodity);
	}

	/**
	 * 查找托管计划
	 * 
	 * @return
	 */
	public TrusteeshipCommodity findPlanById(Long id) {

		IpoTrusteeshipCommodity dbShipCommodity = shipCommodityMapper
				.findById(id);
		TrusteeshipCommodity entity = new TrusteeshipCommodity();
		BeanUtils.copyProperties(dbShipCommodity, entity);
		return entity;
	}

	/**
	 * 新增商户申购的托管商品
	 * 
	 * @param trusteeship
	 * @return
	 */
	@Transactional
	public int saveApply(Trusteeship trusteeship) {
		Long planId = trusteeship.getTrusteeshipCommodityId();
		IpoTrusteeshipCommodity shipCommodity = shipCommodityMapper.findById(planId);
		//发行比例
		BigDecimal purchaseRate = shipCommodity.getPurchaseRate();
		Long applyAmount = trusteeship.getApplyAmount();
		// 约定入库数量等于申请数量，只能全部审核通过或全部审核不通过
		Long instorageAmount = applyAmount;
		trusteeship.setInstorageAmount(instorageAmount);
		trusteeship.setCreateDate(new Date());
		trusteeship.setState(TrusteeshipConstant.State.APPLY.getCode());
		Long effectiveAmount = new BigDecimal(instorageAmount).multiply(purchaseRate)
				.divide(new BigDecimal(100)).longValue();
		//挂牌费=入库数量*发行价格*挂牌费比例
		BigDecimal listingChargeRate = shipCommodity.getListingChargeRate();
		if(listingChargeRate!=null){
		   BigDecimal listingCharge =  new BigDecimal(instorageAmount).multiply(trusteeship.getPrice())
					.multiply(listingChargeRate).divide(new BigDecimal(100));
		   trusteeship.setListingCharge(listingCharge);
		}
		trusteeship.setEffectiveAmount(effectiveAmount);
		trusteeship.setPositionAmount(instorageAmount - effectiveAmount);
        
		
		return shipMapper.insertApply(trusteeship);
	}

	/**
	 * 查询商户提交的申请
	 */
	public List<Trusteeship> queryApplyForPage(String pageNoStr,
			String pageSizeStr, Trusteeship ship) {
		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoTrusteeship> dbList = shipMapper.queryApplyForPage(startIndex,
				endIndex, ship);
		List<Trusteeship> dataList = new ArrayList<Trusteeship>();
		for (IpoTrusteeship item : dbList) {
			Trusteeship entity = new Trusteeship();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(TrusteeshipConstant.State.getName(item
					.getState()));
			dataList.add(entity);
		}
		return dataList;
	}

	/**
	 * 查询商户提交的申请数量
	 */
	public long queryApplyForCount(Trusteeship ship) {
		long count = shipMapper.queryApplyForCount(ship);
		return count;
	}

	/**
	 * 撤销我的申请
	 */
	@Transactional
	public void cancelApply(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.CANCEL.getCode());
		ship.setUpdateDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 市场审核通过
	 */
	@Transactional
	public void marketAuditPass(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.MARKET_PASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 市场审核驳回
	 */
	@Transactional
	public void marketAuditNoPass(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.MARKET_NOTPASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 仓库初审审核通过
	 */
	@Transactional
	public void warehouseFirstAuditPass(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.FIRST_PASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 仓库初审审核驳回
	 */
	@Transactional
	public void warehouseFirstAuditNoPass(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.FIRST_NOTPASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 仓库终审审核通过
	 */
	@Transactional
	public void warehouseLastAuditPass(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.FINAL_PASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 仓库终审审核驳回
	 */
	@Transactional
	public void warehouseLastAuditNoPass(Trusteeship ship) throws Exception {
		saveHis(ship.getId(), ship.getUpdateUser());
		ship.setState(TrusteeshipConstant.State.FINAL_NOTPASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
	}

	/**
	 * 托管转持仓
	 */
	@Transactional
	public void saveTurnToPosition(Trusteeship ship) throws Exception {
		// 保存操作前的状态
		IpoTrusteeship dbShip = saveHis(ship.getId(), ship.getUpdateUser());
		// 商品信息
		IpoCommodityConf dbCommodityConf = commodityConfMapper
				.findIpoCommConfByCommid(dbShip.getCommodityId());
		// 更新状态
		ship.setState(TrusteeshipConstant.State.INCREASE.getCode());
		ship.setUpdateDate(new Date());
		shipMapper.updateApplyState(ship);
		// 保存持仓信息
		IpoPosition position = new IpoPosition();
		position.setCommodityid(dbShip.getCommodityId());
		position.setFirmid(dbShip.getCreateUser());
		position.setPosition(dbShip.getPositionAmount());
		position.setCommodityname(dbCommodityConf.getCommodityname());
		position.setPositionUnit(dbCommodityConf.getContractfactorname());
		if (dbShip.getPrice() != null) {
			position.setPositionPrice(dbShip.getPrice().longValue());
		}
		positionMapper.insert(position);
	}

	/**
	 * 保存上一次的操作记录
	 * 
	 * @param id
	 * @param createUser
	 * @throws Exception
	 */
	private IpoTrusteeship saveHis(Long id, String createUser) throws Exception {
		IpoTrusteeship dbShip = shipMapper.get(id);
		String content = JSON.json(dbShip);
		IpoTrusteeshipHis his = new IpoTrusteeshipHis();
		his.setContent(content);
		his.setTrusteeshipId(id);
		his.setCreateUser(createUser);
		his.setCreateDate(new Date());
		his.setState(dbShip.getState());
		shipHisMapper.insert(his);
		return dbShip;
	}

}
