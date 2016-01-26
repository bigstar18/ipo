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

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPayFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpecialcounterfeeMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialcounterfee;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.SpoRation;

/**
 * 
 * @author Bob
 *
 */

@Service
public class SPOServiceImpl implements SPOService {

	static Logger logger = LoggerFactory.getLogger(SPOServiceImpl.class);
	@Autowired
	private IpoSpoCommoditymanmaagementMapper ipoSPOCommMapper;
	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;
	@Autowired
	private FFirmfundsMapper fundsMapper;
	@Autowired
	private IpoPositionMapper ipoPositionMapper;
	@Autowired
	private IpoCommodityConfMapper ipoCommMapper;
	@Autowired
	private IpoDebitFlowMapper ipoDebitFlowMapper;
	@Autowired
	private IpoPayFlowMapper ipoPayFlowMapper;
	@Autowired
	private IpoSpecialcounterfeeMapper ipoSpecialcounterfeeMapper;

	@Override
	public List<SpoRation> getMyRationInfo(SpoCommoditymanmaagement spoCommo, String page, String rows) {
		// TODO Auto-generated method stub

		if (spoCommo == null)
			return null;
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int beginNum = (Integer.parseInt(page) - 1) * Integer.parseInt(rows) + 1;
		int endNum = Integer.parseInt(page) * Integer.parseInt(rows);
		IpoSpoCommoditymanmaagement ipoSpoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoCommo, ipoSpoComm);
		List<IpoSpoRation> ipoSpos = ipoSpoRationMapper.getMyRationInfo(beginNum, endNum, ipoSpoComm);
		List<SpoRation> spos = new ArrayList<SpoRation>();
		for (IpoSpoRation ipoSpo2 : ipoSpos) {
			SpoRation tempSpo = new SpoRation();
			BeanUtils.copyProperties(ipoSpo2, tempSpo);
			spos.add(tempSpo);
		}
		return spos;
	}

	@Override
	public int getRationInfoCounts(SpoCommoditymanmaagement spoComm) {
		if (spoComm == null) {
			return 0;
		}
		IpoSpoCommoditymanmaagement ipoSpoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipoSpoComm);
		int counts = ipoSpoRationMapper.getRationInfoCounts(ipoSpoComm);
		return counts;
	}

	@Override
	public int updateRationType(Long rationId, String dealerId) {
		logger.info("进入客户确认操作");
		// 获得可用资金
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		param.put("userid", dealerId);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal money1 = (BigDecimal) param.get("money");
		IpoSpoRation ipoSpoRation = ipoSpoRationMapper.selectByPrimaryKey(rationId);
		BigDecimal money = ipoSpoRation.getRationloan();
		BigDecimal fee = ipoSpoRation.getServicefee();
		String spoid = ipoSpoRation.getSpoid();
		IpoSpoCommoditymanmaagement ipoSpoComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		String commodityid = ipoSpoComm.getCommodityId();
		IpoCommodityConf ipoCommodityConf = ipoCommMapper.selectCommUnit(commodityid);
		String pubmemberid = ipoCommodityConf.getPubmemberid();
		// 总费用
		BigDecimal allMonery = money.add(fee);
		logger.debug("总费用allMonery：" + allMonery);
		if (money1.compareTo(allMonery) != -1) {
			// 资金冻结
			float moneyParam = allMonery.floatValue();
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("money", "");
			param1.put("userid", dealerId);
			param1.put("amount", moneyParam);
			param1.put("moduleid", "40");
			fundsMapper.getfrozen(param1);
			String rationIdparam = Long.toString(rationId);
			this.fundsFlow(commodityid, rationIdparam, dealerId, money, fee, pubmemberid);
			int result = ipoSpoRationMapper.updateRationType(rationId);
			if (result > 0) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;
	}

	// 分页获得增发列表
	@Override
	public List<SpoCommoditymanmaagement> getSPOList(String page, String rows, SpoCommoditymanmaagement spoComm) throws Exception {
		// TODO Auto-generated method stub
		logger.info("分页获得增发列表");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		List<SpoCommoditymanmaagement> list1 = new ArrayList<SpoCommoditymanmaagement>();
		List<IpoSpoCommoditymanmaagement> list2 = ipoSPOCommMapper.selectAll((curpage - 1) * pagesize + 1, curpage * pagesize, ipospoComm);
		for (IpoSpoCommoditymanmaagement ipoSPOCommoditymanmaagement : list2) {
			SpoCommoditymanmaagement spoCommoditymanmaagement = new SpoCommoditymanmaagement();
			BeanUtils.copyProperties(ipoSPOCommoditymanmaagement, spoCommoditymanmaagement);
			list1.add(spoCommoditymanmaagement);
		}
		return list1;
	}

	// 获得商品名称以及商品代码
	@Override
	public Map<String, String> getCommodityidByAll() throws Exception {
		logger.info("获得商品名称以及商品代码");
		IpoCommodityConf examples = new IpoCommodityConf();
		List<IpoCommodityConf> list1 = ipoCommMapper.queryListingCommodity(examples);
		Map<String, String> map = new HashMap<String, String>();
		for (IpoCommodityConf ipoCommodity : list1) {
			String id = ipoCommodity.getCommodityid();
			String name = ipoCommodity.getCommodityname();
			map.put(id, name);
		}
		return map;
	}

	// 添加增发信息
	@Override
	@Transactional
	public int insertSPOInfo(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("添加增发信息");
		String type = spoComm.getRationType();
		if (type.equals("1")) {
			Date spoDate = spoComm.getSpoDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String spoDate1 = sdf.format(spoDate);
			String date = sdf.format(new Date());
			if (spoDate1.equals(date)) {
				IpoSpoCommoditymanmaagement ipospoComm = this.status(spoComm, 1);
				return ipoSPOCommMapper.insert(ipospoComm);
			} else {
				IpoSpoCommoditymanmaagement ipospoComm = this.status(spoComm, 4);
				return ipoSPOCommMapper.insert(ipospoComm);
			}
		} else {
			IpoSpoCommoditymanmaagement ipospoComm = this.status(spoComm, 1);
			return ipoSPOCommMapper.insert(ipospoComm);
		}
	}

	// 添加增发信息共用方法
	public IpoSpoCommoditymanmaagement status(SpoCommoditymanmaagement spoComm, int status) {
		long counts = spoComm.getSpoCounts();
		spoComm.setNotRationCounts(counts);
		spoComm.setSuccessRationCounts((long) 0);
		spoComm.setSpoSate(status);
		spoComm.setRebate(2);
		spoComm.setBeListed(2);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipospoComm;
	}

	// 修改增发信息
	@Override
	@Transactional
	public int updateSPOInfo(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("修改增发信息");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOCommMapper.updateByPrimaryKey(ipospoComm);
	}

	// 删除增发信息
	@Override
	@Transactional
	public int deleteSPOInfo(String spoid) throws Exception {
		logger.info("删除增发信息" + "增发id:" + spoid);
		return ipoSPOCommMapper.deleteByPrimaryKey(spoid);
	}

	// 承销商配售比例信息
	@Override
	public List<SpoRation> getRationInfo(String spoid) throws Exception {
		logger.info("承销商配售比例信息");
		List<IpoSpoRation> list1 = ipoSpoRationMapper.selectBySPOid(spoid);
		List<SpoRation> list2 = new ArrayList<SpoRation>();
		for (IpoSpoRation ipoSpoRation : list1) {
			SpoRation spoRation = new SpoRation();
			BeanUtils.copyProperties(ipoSpoRation, spoRation);
			list2.add(spoRation);
		}
		return list2;
	}

	// 更新承销商配售比例<暂不用>
	@Override
	@Transactional
	public int updateByRation(SpoRation spoRation) throws Exception {
		logger.info("更新承销商配售比例");
		IpoSpoRation ipoSpoRation = new IpoSpoRation();
		BeanUtils.copyProperties(spoRation, ipoSpoRation);
		return ipoSpoRationMapper.updateByPrimaryKey(ipoSpoRation);
	}

	// 分配承销商配售比例
	@Override
	@Transactional
	public int insertByRation(ArrayList<SpoRation> spoRationList) throws Exception {
		logger.info("分配承销商配售比例");
		int result = 0;
		int sum = 0;
		String spoid = spoRationList.get(0).getSpoid();
		IpoSpoCommoditymanmaagement ipoSPOComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		BigDecimal price = ipoSPOComm.getSpoPrice();
		long counts = ipoSPOComm.getSpoCounts();
		for (SpoRation spoRation : spoRationList) {
			IpoSpoRation ipoSpoRation = new IpoSpoRation();
			BeanUtils.copyProperties(spoRation, ipoSpoRation);
			String rationid = ipoSpoRation.getRationid().toString();
			if (rationid.equals("0")) {
				String brokerid = ipoSpoRation.getBrokerid();
				String firmid = ipoSpoRationMapper.firmidBySales(brokerid);
				String firmname = ipoSpoRationMapper.selectFirmname(firmid);
				ipoSpoRation.setFirmname(firmname);
				ipoSpoRation.setFirmid(firmid);
				ipoSpoRation.setSalesid(brokerid);
				// 获取以配售总和
				BigDecimal proportion = ipoSpoRation.getSalesAllocationratio();
				logger.info("插入承销商配售比例：" + proportion);
				double pro = proportion.doubleValue();
				long sumparam = (long) (counts * (pro / 100));
				BigDecimal priceparam = new BigDecimal(sumparam);
				BigDecimal rationloan = price.multiply(priceparam);
				ipoSpoRation.setRationloan(rationloan);
				ipoSpoRation.setRationcounts(sumparam);
				ipoSpoRation.setOperationdate(new Date());
				logger.info("插入承销商配售总数：" + sumparam);
				sum += sumparam;
				result += ipoSpoRationMapper.insert(ipoSpoRation);
			} else {
				// 获取以配售总和
				BigDecimal proportion = ipoSpoRation.getSalesAllocationratio();
				logger.info("更新承销商配售比例：" + proportion);
				double pro = proportion.doubleValue();
				long sumparam = (long) (counts * (pro / 100));
				BigDecimal priceparam = new BigDecimal(sumparam);
				BigDecimal rationloan = price.multiply(priceparam);
				ipoSpoRation.setRationloan(rationloan);
				spoRation.setRationcounts(sumparam);
				ipoSpoRation.setOperationdate(new Date());
				logger.info("更新承销商配售总数：" + sumparam);
				sum += sumparam;
				result += ipoSpoRationMapper.updateByPrimaryKey(ipoSpoRation);
			}
		}
		// 更新已配售和未配售
		Long balance = counts - sum;
		logger.info("共计和：" + sum);
		ipoSPOCommMapper.updatePlscingNum(sum, balance, spoid);
		return result;
	}

	// 分页获取配售信息
	@Override
	public List<SpoRation> getRationInfo(String page, String rows, SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("分页获取配售信息");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		List<SpoRation> list1 = new ArrayList<SpoRation>();
		List<IpoSpoRation> list2 = ipoSpoRationMapper.selectSPOAndRa((curpage - 1) * pagesize + 1, curpage * pagesize, ipospoComm);
		for (IpoSpoRation ipospoRation : list2) {
			SpoRation spoRation = new SpoRation();
			BeanUtils.copyProperties(ipospoRation, spoRation);
			list1.add(spoRation);
		}
		return list1;
	}

	// 删除配售信息
	@Override
	@Transactional
	public int deleteByRation(Long rationid) throws Exception {
		logger.info("删除配售信息" + "配售id:" + rationid);
		return ipoSpoRationMapper.deleteByPrimaryKey(rationid);
	}

	// 增发查询总页数
	@Override
	public int spoCounts(SpoCommoditymanmaagement spoComm) {
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		logger.info("增发查询总页数");
		return ipoSPOCommMapper.counts(ipospoComm);
	}

	// 配售查询总页数
	@Override
	public int rationCounts(SpoCommoditymanmaagement spoComm) {
		logger.info("配售查询总页数");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSpoRationMapper.counts(ipospoComm);
	}

	// 根据增发id查增发信息
	@Override
	public SpoCommoditymanmaagement getListBySpocom(String spoid) {
		logger.info("根据增发id查增发信息" + "SPOID:" + spoid);
		IpoSpoCommoditymanmaagement ipoSpoComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
		BeanUtils.copyProperties(ipoSpoComm, spoComm);
		return spoComm;
	}

	// 更新状态
	@Override
	@Transactional
	public int updateStatus(Integer rationSate, String spoid) throws Exception {
		logger.info("更新状态" + "rationSate:" + rationSate + "SPOID:" + spoid);
		IpoSpoCommoditymanmaagement ipoSpoComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		// 增发价格
		BigDecimal price = ipoSpoComm.getPositionsPrice();
		// 商品代码
		String commid = ipoSpoComm.getCommodityId();
		IpoCommodityConf ipoCommodityConf = ipoCommMapper.selectCommUnit(commid);
		String pubmemberid = ipoCommodityConf.getPubmemberid();
		//BrBroker brBroker = brBrokerMapper.selectById(pubmemberid);
		short tradealgr = 0;
		BigDecimal buy = new BigDecimal(0);
		BigDecimal fee = new BigDecimal(0);

		List<IpoSpoRation> list2 = ipoSpoRationMapper.selectInfoBySPOid(spoid);
		for (IpoSpoRation ipoSpoRation : list2) {
			// 承销商id
			String salesid = ipoSpoRation.getSalesid();
			long rationId = ipoSpoRation.getRationid();
			String rationIdparam = Long.toString(rationId);
			String userid = ipoSpoRation.getFirmid();
			if (salesid != null) {
				// 交易商id
				String firmid = ipoSpoRation.getFirmid();
				// 买了多少
				long counts = ipoSpoRation.getRationcounts();
				BigDecimal countsparam = new BigDecimal(counts);
				// 计算应冻结多少
				BigDecimal money = countsparam.multiply(price);
				IpoSpecialcounterfee ipoSpecialcounterfee = ipoSpecialcounterfeeMapper.selectInfo(firmid, commid,
						ChargeConstant.BusinessType.INCREASE_PUBLISH.getCode());
				if (ipoSpecialcounterfee != null) {
					tradealgr = ipoSpecialcounterfee.getTradealgr();
					buy = ipoSpecialcounterfee.getBuy();
					if (tradealgr == 1) {
						BigDecimal valparam = buy.divide(new BigDecimal("100"));
						fee = money.multiply(valparam);
						logger.debug("特殊比例手续费：" + fee);
					} else {
						fee = countsparam.multiply(buy);
						logger.debug("特殊绝对值手续费：" + fee);
					}
				} else {
					// 手续费
					tradealgr = ipoCommodityConf.getTradealgr();
					buy = ipoCommodityConf.getBuy();
					if (tradealgr == 1) {
						BigDecimal valparam = buy.divide(new BigDecimal("100"));
						fee = money.multiply(valparam);
					} else {
						fee = countsparam.multiply(buy);
					}
				}
				BigDecimal moneyPaeam = money.add(fee);
				float allmoney = moneyPaeam.floatValue();
				// 资金冻结
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("money", "");
				param.put("userid", firmid);
				param.put("amount", allmoney);
				param.put("moduleid", "40");
				fundsMapper.getfrozen(param);

				// 更新手续费
				ipoSpoRationMapper.updateServicefee(fee, rationId);
				String value = this.fundsFlow(commid, rationIdparam, userid, money, fee, pubmemberid);
				if (value != "success") {
					return 0;
				}
			}
			logger.info("调用转持仓");
			long countsparam = ipoSpoRation.getRationcounts();
			this.transferPosition(userid, ipoCommodityConf, countsparam, price);
		}
		logger.info("增发状态更新成功");
		return ipoSPOCommMapper.updateByStatus(rationSate, spoid);
	}

	private void transferPosition(String userid, IpoCommodityConf ipoCommodityConf, Long position, BigDecimal price) throws Exception {
		logger.info("转持仓开始");
		String commid = ipoCommodityConf.getCommodityid();
		String commUnit = ipoCommodityConf.getContractfactorname();
		String commodityname = ipoCommodityConf.getCommodityname();
		IpoPosition record = new IpoPosition();
		record.setFirmid(userid);
		record.setPosition(position);
		record.setCommodityid(commid);
		record.setCommodityname(commodityname);
		record.setPositionPrice(price);
		record.setPositionUnit(commUnit);
		record.setOperationTime(new Date());
		ipoPositionMapper.insert(record);
		logger.info("转持仓结束");
	}

	// 修改增发商品
	@Override
	@Transactional
	public int updateComm(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("修改增发商品");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOCommMapper.updateByComm(ipospoComm);
	}

	// 根据增发ID查询增发总量<暂不用>
	@Override
	public SpoCommoditymanmaagement circulation(String spoid) throws Exception {
		logger.info("根据增发ID查询增发总量" + "spoid:" + spoid);
		IpoSpoCommoditymanmaagement ipoSPOComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
		BeanUtils.copyProperties(ipoSPOComm, spoComm);
		return spoComm;
	}

	// 更新已配售和未配售
	@Override
	@Transactional
	public int updatePlscingNum(Long success, Long balance, String spoid) throws Exception {
		logger.info("更新已配售和未配售" + "已配售：" + success + ",未配售：" + balance + ",spoid:" + spoid);
		ipoSPOCommMapper.updatePlscingNum(success, balance, spoid);
		return ipoSPOCommMapper.updatePlscingNum(success, balance, spoid);
	}

	// 根据会员id查询交易商id<暂不用>
	@Override
	public String getFirmid(String brokerid) {
		return ipoSpoRationMapper.firmidBySales(brokerid);
	}

	// <暂不用>
	@Override
	public String getFirmname(String firmid) {
		return ipoSpoRationMapper.selectFirmname(firmid);
	}

	@Override
	public String checkFundsAvailable(String firmid, BigDecimal moneyNeeded) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		param.put("userid", firmid);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal money = (BigDecimal) param.get("money");
		if ((money.compareTo(moneyNeeded)) > 0) {
			return "true";
		}
		return "false";
	}

	//收付款流水
	private String fundsFlow(String commodityid, String id, String userid, BigDecimal money, BigDecimal fee, String pubmemberid) {
		// 货款流水
		DebitFlow debitFlow = new DebitFlow();
		debitFlow.setBusinessType(ChargeConstant.BusinessType.INCREASE_PUBLISH.getCode());
		debitFlow.setChargeType(ChargeConstant.ChargeType.GOODS.getName());
		debitFlow.setCommodityId(commodityid);
		debitFlow.setOrderId(id);
		debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS.getCode());
		debitFlow.setPayer(userid);
		debitFlow.setAmount(money);
		debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
		debitFlow.setBuyBackFlag(0);
		debitFlow.setCreateUser(userid);
		debitFlow.setCreateDate(new Date());
		ipoDebitFlowMapper.insert(debitFlow);
		// 手续费流水
		debitFlow.setChargeType(ChargeConstant.ChargeType.HANDLING.getName());
		debitFlow.setAmount(fee);
		ipoDebitFlowMapper.insert(debitFlow);

		PayFlow payFlow = new PayFlow();
		payFlow.setAmount(money);
		payFlow.setBusinessType(ChargeConstant.BusinessType.INCREASE_PUBLISH.getCode());
		payFlow.setChargeType(ChargeConstant.ChargeType.GOODS.getCode());
		payFlow.setCommodityId(commodityid);
		payFlow.setOrderId(id);
		payFlow.setPayState(ChargeConstant.PayState.UNPAY.getCode());
		payFlow.setPayee(pubmemberid);
		payFlow.setPayMode(ChargeConstant.PayMode.ONLINE.getCode());
		payFlow.setPayChannel(ChargeConstant.PayChannel.DEPOSIT.getCode());
		payFlow.setCreateUser(userid);
		payFlow.setCreateDate(new Date());
		ipoPayFlowMapper.insert(payFlow);
		return "success";
	}
}
