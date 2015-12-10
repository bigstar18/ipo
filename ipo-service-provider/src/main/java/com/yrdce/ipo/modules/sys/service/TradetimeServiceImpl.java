package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoNottradedayMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTradetimeCommMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTradtimeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoNottradeday;
import com.yrdce.ipo.modules.sys.entity.IpoTradetime;
import com.yrdce.ipo.modules.sys.entity.IpoTradetimeComm;
import com.yrdce.ipo.modules.sys.vo.Nottradeday;
import com.yrdce.ipo.modules.sys.vo.Tradetime;
import com.yrdce.ipo.modules.sys.vo.TradetimeComm;

@Service("tradetimeservice")
public class TradetimeServiceImpl implements TradetimeService {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoTradtimeMapper tradetimeMapper;

	@Autowired
	private IpoNottradedayMapper notTradeTimeMapper;

	@Autowired
	private IpoTradetimeCommMapper ipotradetimecomm;

	@Autowired
	private SystemService systemService;

	public IpoTradtimeMapper getTradetimeMapper() {
		return tradetimeMapper;
	}

	public void setTradetimeMapper(IpoTradtimeMapper tradetimeMapper) {
		this.tradetimeMapper = tradetimeMapper;
	}

	public IpoNottradedayMapper getNotTradeTimeMapper() {
		return notTradeTimeMapper;
	}

	public void setNotTradeTimeMapper(IpoNottradedayMapper notTradeTimeMapper) {
		this.notTradeTimeMapper = notTradeTimeMapper;
	}

	public IpoTradetimeCommMapper getIpotradetimecomm() {
		return ipotradetimecomm;
	}

	public void setIpotradetimecomm(IpoTradetimeCommMapper ipotradetimecomm) {
		this.ipotradetimecomm = ipotradetimecomm;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tradetime> selectByPage(String page, String rows) throws Exception {
		logger.info("进入分页查询交易节信息" + "page:" + page + "rows:" + rows);
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<Tradetime> tradetime2 = new ArrayList<Tradetime>();
			List<IpoTradetime> tradetime1 = tradetimeMapper.selectByAll((curpage - 1) * pagesize + 1, curpage * pagesize);
			for (int i = 0; i < tradetime1.size(); i++) {
				Tradetime tradetime = new Tradetime();
				BeanUtils.copyProperties(tradetime1.get(i), tradetime);
				tradetime2.add(tradetime);
			}
			return tradetime2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public int upDate(Tradetime tradetime, String comms) throws Exception {
		logger.info("进入交易节修改" + tradetime);

		logger.info("id:" + tradetime.getSectionid());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>tradetime:" + tradetime.getName());
		IpoTradetime tradetime1 = new IpoTradetime();
		BeanUtils.copyProperties(tradetime, tradetime1);
		tradetime1.setModifytime(new Date());
		tradetimeMapper.updateByAll(tradetime1);
		if (comms.equals("no")) {

			// 获取交易节id删除关联表数据
			Short tradeTimeId = tradetime1.getSectionid();
			BigDecimal tradeTimeId1 = new BigDecimal(tradeTimeId);
			ipotradetimecomm.deleteBytradetimeid(tradeTimeId1);
		} else {
			// 获取交易节id删除关联表数据
			Short tradeTimeId = tradetime1.getSectionid();
			BigDecimal tradeTimeId1 = new BigDecimal(tradeTimeId);
			ipotradetimecomm.deleteBytradetimeid(tradeTimeId1);

			// 插入数据
			String[] comidarray = comms.split(",");
			for (String comid : comidarray) {
				IpoTradetimeComm ipotracom = new IpoTradetimeComm();
				ipotracom.setCommodityid(comid);
				ipotracom.setTradetimeid(tradetime1.getSectionid());
				ipotradetimecomm.insert(ipotracom);
			}

		}
		return 1;
	}

	@Override
	@Transactional
	public int insert(Tradetime tradetime, String comms) throws Exception {

		logger.info("进入交易节添加" + tradetime.toString());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>tradetime:" + tradetime.getName());

		IpoTradetime tradetime1 = new IpoTradetime();
		BeanUtils.copyProperties(tradetime, tradetime1);
		logger.info("tradetime1:" + tradetime1);
		tradetime1.setModifytime(new Date());
		tradetime1.setSectionid(tradetimeMapper.getPK());

		tradetimeMapper.insert(tradetime1);
		if (!comms.equals("no")) {
			// 插入数据
			String[] comidarray = comms.split(",");
			for (String comid : comidarray) {
				IpoTradetimeComm ipotracom = new IpoTradetimeComm();
				ipotracom.setCommodityid(comid);
				ipotracom.setTradetimeid(tradetime1.getSectionid());
				ipotradetimecomm.insert(ipotracom);
			}
		}
		return 1;
	}

	@Override
	@Transactional
	public int delete(String ids) throws Exception {
		logger.info("进入交易节删除" + ids);
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			short sectionid = Short.parseShort(String.valueOf(id[i]));
			tradetimeMapper.deleteByPrimaryKey(sectionid);
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = true)
	public Tradetime selectByKey(Short id) throws Exception {
		logger.info("根据id查询交易节信息" + id);
		try {
			IpoTradetime tradetime1;
			tradetime1 = tradetimeMapper.selectByKey(id);
			Tradetime tradetime = new Tradetime();
			BeanUtils.copyProperties(tradetime1, tradetime);
			return tradetime;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @Override public int selectByBreedAndCommodity(Short id) { logger.info("根据id查询商品和品名与交易节的关联" + id); int result = 0; List commoditytradeprop =
	 * new ArrayList(); List breedtradeprop = breedtradepropMapper.selectByBreed(id); commoditytradeprop =
	 * commoditytradepropMapper.selectByCommodity(id); if ((breedtradeprop != null) && (breedtradeprop.size() > 0)) result = -1; else if
	 * ((commoditytradeprop != null) && (commoditytradeprop.size() > 0)) { result = -2; } return result; }
	 */

	@Override
	@Transactional(readOnly = true)
	public int selectByCounts() throws Exception {
		logger.info("查询交易节共有几条信息");
		int count = tradetimeMapper.selectByCounts();
		return count;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tradetime> selectAll() throws Exception {
		logger.info("进入查询所有交易节信息");
		List<Tradetime> tradetime2 = new ArrayList<Tradetime>();
		List<IpoTradetime> tradetime1 = tradetimeMapper.selectAll();
		for (int i = 0; i < tradetime1.size(); i++) {
			Tradetime tradetime = new Tradetime();
			BeanUtils.copyProperties(tradetime1.get(i), tradetime);
			tradetime2.add(tradetime);
		}
		return tradetime2;
	}

	// 非交易日插入(删除、更新、提交共用此方法)
	@Override
	@Transactional
	public int insertByNottradeday(Nottradeday notTradeDay) throws Exception {
		logger.info("非交易节设置");
		int seccess = 1;
		IpoNottradeday nottradeday = new IpoNottradeday();
		BeanUtils.copyProperties(notTradeDay, nottradeday);
		nottradeday.setModifytime(new Date());
		Long status = nottradeday.getId();
		logger.info(status + "");
		if (status == 1) {
			notTradeTimeMapper.updateByPrimaryKeySelective(nottradeday);
			return seccess;
		} else {
			nottradeday.setId(1L);
			notTradeTimeMapper.insert(nottradeday);
			return seccess;
		}
	}

	// 非交易日查询
	@Override
	@Transactional(readOnly = true)
	public Nottradeday select() throws Exception {
		logger.info("非交易节查询");
		Nottradeday nottradeday = new Nottradeday();

		IpoNottradeday ipoNottradeday = notTradeTimeMapper.select();
		if (ipoNottradeday != null) {
			BeanUtils.copyProperties(ipoNottradeday, nottradeday);
			return nottradeday;
		} else {
			return null;
		}
	}

	// 是否在交易节时间内
	@Override
	public boolean getTime() {
		// TODO Auto-generated method stub
		// 获取数据可时间
		Date DBTime = systemService.getDBTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String DBTime1 = sdf.format(DBTime);
		// 获取交易节时间
		List<IpoTradetime> list = tradetimeMapper.selectAll();
		for (int i = 0; i < list.size(); i++) {
			String startTime = list.get(i).getStarttime();
			String endTime = list.get(i).getEndtime();
			long begin = Long.parseLong(startTime.replaceAll(":", ""));
			long finish = Long.parseLong(endTime.replaceAll(":", ""));
			long now = Long.parseLong(DBTime1.replaceAll(":", ""));

			if (now >= begin && now < finish) {
				return true;
			}
		}

		return false;
	}

	// 是否在交易节前5分钟
	@Override
	public boolean timeComparison() {
		// 获取数据库时间
		Date DBTime = systemService.getDBTime();
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(DBTime);
		// 当前时间加5分钟
		rightNow.add(Calendar.MINUTE, 5);
		Date dt1 = rightNow.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(dt1);
		// 获取交易节时间
		List<IpoTradetime> list = tradetimeMapper.selectAll();
		for (int i = 0; i < list.size(); i++) {
			String startTime = list.get(i).getStarttime();

			long begin = Long.parseLong(startTime.replaceAll(":", ""));
			long now = Long.parseLong(str.replaceAll(":", ""));

			if (now >= begin) {
				return true;
			}
		}

		return false;
	}

	// 判断交易节与商品是否有关联
	@Override
	@Transactional(readOnly = true)
	public boolean tradeTimeAndCom(String ids) throws Exception {
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			int tradeTimeId = Integer.parseInt(id[i]);
			int counts = ipotradetimecomm.countById(tradeTimeId);
			if (counts == 0) {
				return true;
			}
		}
		return false;
	}

	// 根据交易节id查询关联商品信息
	@Override
	@Transactional(readOnly = true)
	public List<TradetimeComm> getTradetimeByComm(Short id) throws Exception {
		BigDecimal tradeTimeId1 = new BigDecimal(id);
		List<IpoTradetimeComm> list = ipotradetimecomm.selectBytradetimeid(tradeTimeId1);
		List<TradetimeComm> list1 = new ArrayList<TradetimeComm>();
		for (int i = 0; i < list.size(); i++) {
			TradetimeComm tradeTimeComm = new TradetimeComm();
			BeanUtils.copyProperties(list.get(i), tradeTimeComm);
			list1.add(tradeTimeComm);
		}
		return list1;
	}
}
