package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.TrusteeshipConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPayFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipHisMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTrusteeshipMapper;
import com.yrdce.ipo.modules.sys.entity.FFirmfunds;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeship;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipHis;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;
import com.yrdce.ipo.throwable.BalanceNotEnoughException;

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
	@Autowired
	private IpoPositionMapper ipoPositionMapper;
	@Autowired
	private IpoPayFlowMapper  payFlowMapper;
	@Autowired
	private IpoDebitFlowMapper  debitFlowMapper;
	@Autowired
	private FFirmfundsMapper firmfundsMapper;
	 
	/**
	 * 分页查询查询托管商品计划
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param commodity
	 * @return
	 */
	public List<TrusteeshipCommodity> queryPlanForPage(String pageNoStr, String pageSizeStr, TrusteeshipCommodity commodity) {

		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoTrusteeshipCommodity> dbList = shipCommodityMapper.queryApplyForPage(startIndex, endIndex, commodity);
		List<TrusteeshipCommodity> dataList = new ArrayList<TrusteeshipCommodity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int today = Integer.parseInt(sdf.format(new Date()));
		int planStartDate = 0;
		int planEndDate = 0;
		for (IpoTrusteeshipCommodity item : dbList) {
			TrusteeshipCommodity entity = new TrusteeshipCommodity();
			BeanUtils.copyProperties(item, entity);
			planStartDate = Integer.parseInt(item.getPlan().substring(0, 8));
			planEndDate = Integer.parseInt(item.getPlan().substring(9));
			if (today > planEndDate) {
				entity.setState(TrusteeshipConstant.PlanState.END.getCode());
			} else if (today < planStartDate) {
				entity.setState(TrusteeshipConstant.PlanState.NOT_START.getCode());
			} else {
				entity.setState(TrusteeshipConstant.PlanState.STARTING.getCode());
			}
			;
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

		IpoTrusteeshipCommodity dbShipCommodity = shipCommodityMapper.findById(id);
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
		// 发行比例
		BigDecimal purchaseRate = shipCommodity.getPurchaseRate();
		Long applyAmount = trusteeship.getApplyAmount();
		// 约定入库数量等于申请数量，只能全部审核通过或全部审核不通过
		Long instorageAmount = applyAmount;
		trusteeship.setInstorageAmount(instorageAmount);
		trusteeship.setCreateDate(new Date());
		trusteeship.setState(TrusteeshipConstant.State.APPLY.getCode());
		Long effectiveAmount = new BigDecimal(instorageAmount).multiply(purchaseRate).divide(new BigDecimal(100)).longValue();
		// 挂牌费=入库数量*发行价格*挂牌费比例
		BigDecimal listingChargeRate = shipCommodity.getListingChargeRate();
		if (listingChargeRate != null) {
			BigDecimal listingCharge = new BigDecimal(instorageAmount).multiply(trusteeship.getPrice()).multiply(listingChargeRate)
					.divide(new BigDecimal(100));
			trusteeship.setListingCharge(listingCharge);
		};
		IpoCommodityConf commConf = commodityConfMapper.findIpoCommConfByCommid(trusteeship.getCommodityId());
		//发行手续费算法(1、按百分比  2、按绝对值)
		Short publishalgr=commConf.getPublishalgr();
		BigDecimal publishCharge=new BigDecimal(0);
		if(publishalgr==2){
			publishCharge=commConf.getPublishercharatio();
		}else{
			publishCharge=commConf.getPrice().multiply(new BigDecimal(instorageAmount)).
					multiply(commConf.getPublishercharatio()).divide(new BigDecimal(100));
		};
		trusteeship.setPublishCharge(publishCharge);
		trusteeship.setEffectiveAmount(effectiveAmount);
		trusteeship.setPositionAmount(instorageAmount - effectiveAmount);

		return shipMapper.insertApply(trusteeship);
	}

	/**
	 * 查询商户提交的申请
	 */
	public List<Trusteeship> queryApplyForPage(String pageNoStr, String pageSizeStr, Trusteeship ship) {
		int startIndex = PageUtil.getStartIndex(pageNoStr, pageSizeStr);
		int endIndex = PageUtil.getEndIndex(pageNoStr, pageSizeStr);
		List<IpoTrusteeship> dbList = shipMapper.queryApplyForPage(startIndex, endIndex, ship);
		List<Trusteeship> dataList = new ArrayList<Trusteeship>();
		for (IpoTrusteeship item : dbList) {
			Trusteeship entity = new Trusteeship();
			BeanUtils.copyProperties(item, entity);
			entity.setStateName(TrusteeshipConstant.State.getName(item.getState()));
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
		IpoTrusteeship dbShip =saveHis(ship.getId(), ship.getUpdateUser());
		BigDecimal publishCharge=dbShip.getPublishCharge();
		//验证资金是否充足
		validateBalance(dbShip.getCreateUser(),publishCharge);
		ship.setState(TrusteeshipConstant.State.MARKET_PASS.getCode());
		ship.setUpdateDate(new Date());
		ship.setAuditingDate(new Date());
		shipMapper.updateApplyState(ship);
		//冻结费用
		frozen(dbShip.getCreateUser(),publishCharge);
		//计算手续费
		DebitFlow debitFlow = new DebitFlow();
		debitFlow.setAmount(publishCharge);
		debitFlow.setBusinessType(ChargeConstant.BusinessType.TRUSTEESHIP.getCode());
		debitFlow.setChargeType(ChargeConstant.ChargeType.HANDLING.getCode());
		debitFlow.setCommodityId(dbShip.getCommodityId());
		debitFlow.setOrderId(String.valueOf(dbShip.getId()));
		debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS.getCode());
		debitFlow.setPayer(dbShip.getCreateUser());
		debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
		debitFlow.setCreateUser(ship.getUpdateUser());
		debitFlow.setCreateDate(new Date());
		debitFlowMapper.insert(debitFlow);
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
		IpoCommodityConf dbCommodityConf = commodityConfMapper.findIpoCommConfByCommid(dbShip.getCommodityId());
		// 更新状态
		ship.setState(TrusteeshipConstant.State.INCREASE.getCode());
		ship.setUpdateDate(new Date());
		shipMapper.updateApplyState(ship);
		// 保存持仓信息
		IpoPosition dbPosition = ipoPositionMapper.selectPosition(dbShip.getCreateUser(), dbShip.getCommodityId());
		if (dbPosition != null) {
			 long amount=dbPosition.getPosition()+dbShip.getPositionAmount();
			 ipoPositionMapper.updatePosition(dbShip.getCreateUser(), dbShip.getCommodityId(), amount);
		} else {
			IpoPosition position = new IpoPosition();
			position.setCommodityid(dbShip.getCommodityId());
			position.setFirmid(dbShip.getCreateUser());
			position.setPosition(dbShip.getPositionAmount());
			position.setCommodityname(dbCommodityConf.getCommodityname());
			position.setPositionUnit(dbCommodityConf.getContractfactorname());
			if (dbShip.getPrice() != null) {
				position.setPositionPrice(dbShip.getPrice());
			}
			positionMapper.insert(position);
		}
		
		//计算托管商品的货款
		Long effective=dbShip.getEffectiveAmount();
		BigDecimal amount=dbShip.getPrice().multiply(new BigDecimal(effective));
		PayFlow payFlow=new PayFlow();
		payFlow.setAmount(amount);
		payFlow.setBusinessType(ChargeConstant.BusinessType.TRUSTEESHIP.getCode());
		payFlow.setChargeType(ChargeConstant.ChargeType.GOODS.getCode());
		payFlow.setCommodityId(dbShip.getCommodityId());
		payFlow.setOrderId(String.valueOf(ship.getId()));
		payFlow.setPayState(ChargeConstant.PayState.UNPAY.getCode());
		payFlow.setPayee(ship.getCreateUser());
		payFlow.setPayMode(ChargeConstant.PayMode.ONLINE.getCode());
		payFlow.setPayChannel(ChargeConstant.PayChannel.DEPOSIT.getCode());
		payFlow.setCreateUser(ship.getUpdateUser());
		payFlow.setCreateDate(new Date());
		payFlowMapper.insert(payFlow);
	}

	/**
	 * 查找申请记录
	 * @param id
	 * @return
	 */
	public Trusteeship findTrusteeshipById(Long id){
		IpoTrusteeship dbShip = shipMapper.get(id);
		Trusteeship ship = new Trusteeship();
		BeanUtils.copyProperties(dbShip, ship);
		return ship;
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

	
	
	// 判断余额是否充足
    private void validateBalance(String firmId, BigDecimal charge) throws Exception{
		FFirmfunds firmfunds= firmfundsMapper.selectByPrimaryKey(firmId);
		if(firmfunds==null){
			throw new BalanceNotEnoughException();
		};
		BigDecimal balance=firmfunds.getBalance();
		BigDecimal frozenfunds=firmfunds.getFrozenfunds();
		BigDecimal difference=balance.subtract(frozenfunds).subtract(charge);
		if(difference.doubleValue()<=0){
			throw new BalanceNotEnoughException();
		};
	}
	
	// 冻结资金
	private  BigDecimal frozen(String userId, BigDecimal allMonery) {
		float mony = allMonery.floatValue();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monery", "");
		param.put("userid", userId);
		param.put("amount", mony);
		param.put("moduleid", "40");
		firmfundsMapper.getfrozen(param);
		BigDecimal monery = new BigDecimal((Double) (param.get("monery")));
		return monery;
	}
		
		
}
