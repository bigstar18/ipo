package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.dao.BrBrokerMapper;
import com.yrdce.ipo.modules.sys.dao.IpoBillofladingMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoFirmrewarddeailMapper;
import com.yrdce.ipo.modules.sys.dao.IpoHoldcommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoReleasesubscriptionMapper;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.entity.IpoBilloflading;
import com.yrdce.ipo.modules.sys.entity.IpoDelivery;
import com.yrdce.ipo.modules.sys.entity.IpoFirmrewarddeail;
import com.yrdce.ipo.modules.sys.entity.IpoHoldcommodity;
import com.yrdce.ipo.modules.sys.entity.IpoReleasesubscription;
import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.Firmrewarddeail;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * @ClassName: BrokerageMemberReport
 * @Description: 经纪会员报表
 * @author bob
 */
@Service
public class BrokerageReportServiceImpl implements BrokerageReportService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BrBrokerMapper brokerMapper;
	@Autowired
	private IpoBillofladingMapper ipoBillofladingMapper;
	@Autowired
	private IpoDeliveryMapper ipoDeliveryMapper;
	@Autowired
	private IpoHoldcommodityMapper holdcommodityMapper;
	@Autowired
	private IpoReleasesubscriptionMapper ReleasesubscriptionMapper;
	@Autowired
	private IpoDistributionMapper distributionMapper;
	@Autowired
	private IpoFirmrewarddeailMapper FirmrewarddeailMapper;

	@Override
	public List<VBrBroker> getBroker() {
		logger.info("经纪会员id查询");
		List<BrBroker> brokersList = brokerMapper.findAllBrokerageMember();
		List<VBrBroker> list = new ArrayList<VBrBroker>();
		for (BrBroker ipoBroker : brokersList) {
			VBrBroker vBrBroker = new VBrBroker();
			BeanUtils.copyProperties(ipoBroker, vBrBroker);
			list.add(vBrBroker);
		}
		return list;
	}

	@Override
	public List<Billoflading> getBillfladInfo(String brokerid, String time) {
		logger.info("经纪会员提货单查询");
		List<Billoflading> list2 = new ArrayList<Billoflading>();
		List<IpoBilloflading> list1 = ipoBillofladingMapper.selectByFirmidAndTime(brokerid, time);
		for (IpoBilloflading ipoBilloflading : list1) {
			Billoflading billoflading = new Billoflading();
			BeanUtils.copyProperties(ipoBilloflading, billoflading);
			list2.add(billoflading);
		}
		return list2;
	}

	@Override
	public List<Delivery> getDeliveryInfo(String brokerid, String time) {
		logger.info("经纪会员交货查询");
		List<Delivery> list2 = new ArrayList<Delivery>();
		List<IpoDelivery> list1 = ipoDeliveryMapper.selectByFirmidAndTime(brokerid, time);
		for (IpoDelivery ipoDelivery : list1) {
			Delivery delivery = new Delivery();
			BeanUtils.copyProperties(ipoDelivery, delivery);
			list2.add(delivery);
		}
		return list2;
	}

	@Override
	public List<Holdcommodity> getHoldInfo(String brokerid, String time) {
		logger.info("经纪会员持仓查询");
		List<Holdcommodity> list2 = new ArrayList<Holdcommodity>();
		List<IpoHoldcommodity> list1 = holdcommodityMapper.selectByFirmidAndTime(brokerid, time);
		for (IpoHoldcommodity ipoHoldcommodity : list1) {
			Holdcommodity holdcommodity = new Holdcommodity();
			BeanUtils.copyProperties(ipoHoldcommodity, holdcommodity);
			list2.add(holdcommodity);
		}
		return list2;
	}

	@Override
	public List<Releasesubscription> getReleaInfo(String brokerid, String time) {
		logger.info("经纪会员发行申购明查询");
		List<Releasesubscription> list2 = new ArrayList<Releasesubscription>();
		List<IpoReleasesubscription> list1 = ReleasesubscriptionMapper.selectByFirmidAndTime(brokerid, time);
		for (IpoReleasesubscription ipoReleasesubscription : list1) {
			Releasesubscription releasesubscription = new Releasesubscription();
			BeanUtils.copyProperties(ipoReleasesubscription, releasesubscription);
			list2.add(releasesubscription);
		}
		return list2;
	}

	@Override
	public List<Firmrewarddeail> getHandlingInfo(String brokerid, String starttime, String endtime) {
		logger.info("经纪会员申购经纪收入查询");
		List<BrBroker> brBrokers = brokerMapper.findTraderByBrokerid(brokerid);
		List<Firmrewarddeail> list = new ArrayList<Firmrewarddeail>();
		for (BrBroker broker : brBrokers) {
			String firmid = broker.getFirmid();
			List<IpoFirmrewarddeail> list1 = FirmrewarddeailMapper.findByFirmidAndType(firmid,
					ChargeConstant.ChargeType.HANDLING.getCode(),
					ChargeConstant.BusinessType.PURCHASE.getCode(), starttime, endtime);
			if (list1.size() != 0 && list1 != null) {
				for (IpoFirmrewarddeail ipoFirmrewarddeail : list1) {
					Firmrewarddeail firmrewarddeail = new Firmrewarddeail();
					BeanUtils.copyProperties(ipoFirmrewarddeail, firmrewarddeail);
					firmrewarddeail.setFirmid(firmid);
					list.add(firmrewarddeail);
				}
			}
		}
		return list;
	}

	@Override
	public List<Firmrewarddeail> getRegisterInfo(String brokerid, String starttime, String endtime) {
		logger.info("经纪会员注册经纪收入查询");
		List<BrBroker> brBrokers = brokerMapper.findTraderByBrokerid(brokerid);
		List<Firmrewarddeail> list = new ArrayList<Firmrewarddeail>();
		for (BrBroker broker : brBrokers) {
			String firmid = broker.getFirmid();
			List<IpoFirmrewarddeail> list2 = FirmrewarddeailMapper.findByFirmidAndType(firmid,
					ChargeConstant.ChargeType.REGISTER.getCode(),
					ChargeConstant.BusinessType.DELIVERY.getCode(), starttime, endtime);
			if (list2.size() != 0 && list2 != null) {
				for (IpoFirmrewarddeail ipoFirmrewarddeail : list2) {
					Firmrewarddeail firmrewarddeail = new Firmrewarddeail();
					BeanUtils.copyProperties(ipoFirmrewarddeail, firmrewarddeail);
					list.add(firmrewarddeail);
				}
			}
		}
		return list;
	}

	@Override
	public List<Firmrewarddeail> getCancelInfo(String brokerid, String starttime, String endtime) {
		logger.info("经纪会员注销经纪收入查询");
		List<BrBroker> brBrokers = brokerMapper.findTraderByBrokerid(brokerid);
		List<Firmrewarddeail> list = new ArrayList<Firmrewarddeail>();
		for (BrBroker broker : brBrokers) {
			String firmid = broker.getFirmid();
			List<IpoFirmrewarddeail> list3 = FirmrewarddeailMapper.findByFirmidAndType(firmid,
					ChargeConstant.ChargeType.CANCEL.getCode(),
					ChargeConstant.BusinessType.DELIVERY.getCode(), starttime, endtime);
			if (list3.size() != 0 && list3 != null) {
				for (IpoFirmrewarddeail ipoFirmrewarddeail : list3) {
					Firmrewarddeail firmrewarddeail = new Firmrewarddeail();
					BeanUtils.copyProperties(ipoFirmrewarddeail, firmrewarddeail);
					list.add(firmrewarddeail);
				}
			}
		}
		return list;
	}
}
