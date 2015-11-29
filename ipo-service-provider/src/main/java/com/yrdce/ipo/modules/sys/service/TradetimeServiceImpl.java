package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoNottradedayMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTradtimeMapper;
import com.yrdce.ipo.modules.sys.dao.TABreedtradepropMapper;
import com.yrdce.ipo.modules.sys.dao.TACommoditytradepropMapper;
import com.yrdce.ipo.modules.sys.entity.IpoNottradeday;
import com.yrdce.ipo.modules.sys.entity.IpoTradetime;
import com.yrdce.ipo.modules.sys.vo.Nottradeday;
import com.yrdce.ipo.modules.sys.vo.Tradetime;

@Service("tradetimeservice")
public class TradetimeServiceImpl implements TradetimeService {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoTradtimeMapper tradetimeMapper;

	@Autowired
	private TABreedtradepropMapper breedtradepropMapper;

	@Autowired
	private TACommoditytradepropMapper commoditytradepropMapper;

	@Autowired
	private IpoNottradedayMapper notTradeTimeMapper;

	@Override
	public List<Tradetime> selectByPage(String page, String rows) {
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
	public int upDate(Tradetime tradetime) {
		logger.info("进入交易节修改" + tradetime);
		try {
			IpoTradetime tradetime1 = new IpoTradetime();
			BeanUtils.copyProperties(tradetime, tradetime1);
			tradetimeMapper.updateByAll(tradetime1);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
	}

	@Override
	public int insert(Tradetime tradetime) {
		logger.info("进入交易节添加" + tradetime.toString());
		try {
			IpoTradetime tradetime1 = new IpoTradetime();
			BeanUtils.copyProperties(tradetime, tradetime1);
			logger.info("tradetime1:" + tradetime1);
			tradetime1.setModifytime(new Date());
			tradetimeMapper.insert(tradetime1);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
	}

	@Override
	public int delete(Integer ids) {
		logger.info("进入交易节删除" + ids);
		// int sectionid = Integer.parseInt(String.valueOf(ids));
		tradetimeMapper.deleteByPrimaryKey(ids);
		return 1;
	}

	@Override
	public Tradetime selectByKey(Short id) {
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

	@Override
	public int selectByBreedAndCommodity(Short id) {
		logger.info("根据id查询商品和品名与交易节的关联" + id);
		int result = 0;
		List breedtradeprop = new ArrayList();
		List commoditytradeprop = new ArrayList();
		breedtradeprop = breedtradepropMapper.selectByBreed(id);
		commoditytradeprop = commoditytradepropMapper.selectByCommodity(id);
		if ((breedtradeprop != null) && (breedtradeprop.size() > 0))
			result = -1;
		else if ((commoditytradeprop != null) && (commoditytradeprop.size() > 0)) {
			result = -2;
		}
		return result;
	}

	@Override
	public int selectByCounts() {
		logger.info("查询交易节共有几条信息");
		int count = tradetimeMapper.selectByCounts();
		return count;
	}

	@Override
	public List<Tradetime> selectAll() {
		logger.info("进入查询所有交易节信息");
		try {
			List<IpoTradetime> tradetime1 = new ArrayList<IpoTradetime>();
			List<Tradetime> tradetime2 = new ArrayList<Tradetime>();
			tradetime1 = tradetimeMapper.selectAll();
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

	// 非交易日插入(删除、更新、提交共用此方法)
	@Override
	public int insertByNottradeday(Nottradeday notTradeDay) {
		logger.info("非交易节设置");
		int seccess = 1;
		int error = 2;
		try {
			IpoNottradeday nottradeday = new IpoNottradeday();
			BeanUtils.copyProperties(notTradeDay, nottradeday);
			notTradeTimeMapper.updateByPrimaryKeySelective(nottradeday);
			return seccess;
		} catch (Exception e) {
			e.printStackTrace();
			return error;
		}
	}

	// 非交易日查询
	@Override
	public Nottradeday select() {
		logger.info("非交易节查询");
		try {
			Nottradeday nottradeday = new Nottradeday();
			IpoNottradeday ipoNottradeday = notTradeTimeMapper.select();
			BeanUtils.copyProperties(ipoNottradeday, nottradeday);
			return nottradeday;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
