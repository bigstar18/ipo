package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.modules.sys.dao.IpoBillofladingMapper;
import com.yrdce.ipo.modules.sys.dao.IpoBrokerMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryMapper;
import com.yrdce.ipo.modules.sys.dao.IpoHoldcommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoReleasesubscriptionMapper;
import com.yrdce.ipo.modules.sys.entity.IpoBilloflading;
import com.yrdce.ipo.modules.sys.entity.IpoBroker;
import com.yrdce.ipo.modules.sys.entity.IpoDelivery;
import com.yrdce.ipo.modules.sys.entity.IpoHoldcommodity;
import com.yrdce.ipo.modules.sys.entity.IpoReleasesubscription;
import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Paging;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;

/**
 * @ClassName: BrokerageMemberReport
 * @Description: 经纪会员报表
 * @author bob
 */
@Service
public class BrokerageReportServiceImpl implements BrokerageReportService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoBrokerMapper brokerMapper;
	@Autowired
	private IpoBillofladingMapper ipoBillofladingMapper;
	@Autowired
	private IpoDeliveryMapper ipoDeliveryMapper;
	@Autowired
	private IpoHoldcommodityMapper holdcommodityMapper;
	@Autowired
	private IpoReleasesubscriptionMapper ReleasesubscriptionMapper;

	@Override
	public List<String> getBroker() {
		logger.info("经纪会员id查询");
		List<IpoBroker> brokersList = brokerMapper.selectFirm();
		List<String> list = new ArrayList<String>();
		for (IpoBroker ipoBroker : brokersList) {
			String firmid = ipoBroker.getFirmid();
			list.add(firmid);
		}
		return list;
	}

	@Override
	public List<Billoflading> getBillfladInfo(Paging paging) {
		logger.info("经纪会员提货单查询");
		String firmid = paging.getDealerId();
		String time = paging.getTime();
		List<IpoBilloflading> list1 = ipoBillofladingMapper.selectByFirmidAndTime(firmid, time);
		List<Billoflading> list2 = new ArrayList<Billoflading>();
		for (IpoBilloflading ipoBilloflading : list1) {
			Billoflading billoflading = new Billoflading();
			BeanUtils.copyProperties(ipoBilloflading, billoflading);
			list2.add(billoflading);
		}
		return list2;
	}

	@Override
	public List<Delivery> getDeliveryInfo(Paging paging) {
		logger.info("经纪会员交货查询");
		String firmid = paging.getDealerId();
		String time = paging.getTime();
		List<IpoDelivery> list1 = ipoDeliveryMapper.selectByFirmidAndTime(firmid, time);
		List<Delivery> list2 = new ArrayList<Delivery>();
		for (IpoDelivery ipoDelivery : list1) {
			Delivery delivery = new Delivery();
			BeanUtils.copyProperties(ipoDelivery, delivery);
			list2.add(delivery);
		}
		return list2;
	}

	@Override
	public List<Holdcommodity> getHoldInfo(Paging paging) {
		logger.info("经纪会员持仓查询");
		String firmid = paging.getDealerId();
		String time = paging.getTime();
		List<IpoHoldcommodity> list1 = holdcommodityMapper.selectByFirmidAndTime(firmid, time);
		List<Holdcommodity> list2 = new ArrayList<Holdcommodity>();
		for (IpoHoldcommodity ipoHoldcommodity : list1) {
			Holdcommodity holdcommodity = new Holdcommodity();
			BeanUtils.copyProperties(ipoHoldcommodity, holdcommodity);
			list2.add(holdcommodity);
		}
		return list2;
	}

	@Override
	public List<Releasesubscription> getReleaInfo(Paging paging) {
		logger.info("经纪会员发行申购明查询");
		String firmid = paging.getDealerId();
		String time = paging.getTime();
		List<IpoReleasesubscription> list1 = ReleasesubscriptionMapper.selectByFirmidAndTime(firmid, time);
		List<Releasesubscription> list2 = new ArrayList<Releasesubscription>();
		for (IpoReleasesubscription ipoReleasesubscription : list1) {
			Releasesubscription releasesubscription = new Releasesubscription();
			BeanUtils.copyProperties(ipoReleasesubscription, releasesubscription);
			list2.add(releasesubscription);
		}
		return list2;
	}
}
