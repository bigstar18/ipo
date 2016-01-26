package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExtended;
import com.yrdce.ipo.modules.sys.vo.Commodity;

/**
 * 
 * 商品发售服务 add by hxx
 *
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoCommodityMapper ipoCommodityMapper;

	public IpoCommodityMapper getIpoCommodityMapper() {
		return ipoCommodityMapper;
	}

	public void setIpoCommodityMapper(IpoCommodityMapper ipoCommodityMapper) {
		this.ipoCommodityMapper = ipoCommodityMapper;
	}

	/*
	 * 分页获取发售商品列表
	 */

	@Override
	@Transactional(readOnly = true)
	public List<Commodity> findCommList(String page, String rows) {
		logger.info("分页获取发售商品列表");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoCommodity> commlist = ipoCommodityMapper.getAllByPage((curpage - 1) * pagesize + 1, curpage * pagesize);
		List<Commodity> commlist2 = new ArrayList<Commodity>();
		for (int i = 0; i < commlist.size(); i++) {
			Commodity commo = new Commodity();
			BeanUtils.copyProperties(commlist.get(i), commo);
			commo.setPrice(commlist.get(i).getPrice().doubleValue());
			commlist2.add(commo);
		}
		return commlist2;
	}

	@Override
	public Commodity getCommodity(String commid) {
		logger.info("根据商品ID查询信息");
		IpoCommodity ipoCom = ipoCommodityMapper.selectByComid(commid.toUpperCase());
		if (ipoCom == null) {
			return null;
		}
		logger.debug("ipoCom:" + ipoCom.toString());
		Commodity commo = new Commodity();
		BeanUtils.copyProperties(ipoCom, commo);
		commo.setPrice(ipoCom.getPrice().doubleValue());
		return commo;
	}

	@Override
	public Integer getAllComms() {
		return ipoCommodityMapper.countByExample(new IpoCommodityExample());
	}

	/*
	 * 获取所有发售商品信息
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Commodity> findAll() {
		logger.info("获取所有发售商品信息");
		List<Commodity> commlist2 = new ArrayList<Commodity>();
		List<IpoCommodity> commlist = ipoCommodityMapper.selectAll();
		for (int i = 0; i < commlist.size(); i++) {
			Commodity commo = new Commodity();
			BeanUtils.copyProperties(commlist.get(i), commo);
			commo.setPrice(commlist.get(i).getPrice().doubleValue());
			commlist2.add(commo);
		}
		return commlist2;
	}

	/*
	 * mgr后台发行摇号
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Commodity> getList(String page, String rows) {
		logger.info("mgr后台发行摇号");

		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Commodity> commlist2 = new ArrayList<Commodity>();
		List<IpoCommodityExtended> commlist = ipoCommodityMapper.selectByCommodityAndOrder((curpage - 1) * pagesize + 1, curpage * pagesize);
		if (commlist == null) {
			return null;
		}
		for (int i = 0; i < commlist.size(); i++) {
			Commodity commo = new Commodity();
			BeanUtils.copyProperties(commlist.get(i), commo);
			// commo.setPrice(commlist.get(i).getPrice().doubleValue());
			commlist2.add(commo);
		}
		logger.debug("commlist2:" + commlist2.size());
		return commlist2;

	}

	@Override
	public Integer getCounts() {
		int counts1 = ipoCommodityMapper.getCounts();
		Integer counts2 = Integer.valueOf(counts1);
		return counts2;
	}

	@Override
	public List<Commodity> getCommodityByPage(String page, String rows, String commodityid) {
		logger.info("根据商品id分页查询mgr后台发行摇号");

		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Commodity> commlist2 = new ArrayList<Commodity>();
		List<IpoCommodityExtended> commlist;
		commlist = ipoCommodityMapper.getAllBycommodityid((curpage - 1) * pagesize + 1, curpage * pagesize, commodityid.toUpperCase());
		if (commlist == null) {
			return null;
		}
		for (int i = 0; i < commlist.size(); i++) {
			Commodity commo = new Commodity();
			BeanUtils.copyProperties(commlist.get(i), commo);
			// commo.setPrice(commlist.get(i).getPrice().doubleValue());
			commlist2.add(commo);
		}
		return commlist2;
	}

	@Override
	public Integer getCountsByPage(String commodityid) {
		int counts = ipoCommodityMapper.getCountsByPage(commodityid.toUpperCase());
		logger.debug("counts:" + counts);
		Integer counts1 = Integer.valueOf(counts);
		return counts1;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Commodity> queryByConditions(String page, String rows, Commodity comm) {
		logger.info("条件查询发售商品服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoCommodity example = new IpoCommodity();
		if (comm != null) {
			BeanUtils.copyProperties(comm, example);
			List<IpoCommodity> commlist = ipoCommodityMapper.queryByConditions((curpage - 1) * pagesize + 1, curpage * pagesize, example);
			List<Commodity> commlist2 = new ArrayList<Commodity>();
			for (int i = 0; i < commlist.size(); i++) {
				Commodity commo = new Commodity();
				BeanUtils.copyProperties(commlist.get(i), commo);
				commo.setPrice(commlist.get(i).getPrice().doubleValue());
				commlist2.add(commo);
			}
			return commlist2;
		}
		return null;
	}

	@Override
	public Integer countByConditions(Commodity comm) {
		IpoCommodity example = new IpoCommodity();
		if (comm != null) {
			BeanUtils.copyProperties(comm, example);
			return ipoCommodityMapper.countByConditions(example);
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Commodity> queryByConditionsfront(String page, String rows, Commodity comm) {
		logger.info("前台条件查询发售商品服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoCommodity example = new IpoCommodity();
		if (comm != null) {
			BeanUtils.copyProperties(comm, example);
			List<IpoCommodity> commlist = ipoCommodityMapper.queryByConditionsfront((curpage - 1) * pagesize + 1, curpage * pagesize, example);
			List<Commodity> commlist2 = new ArrayList<Commodity>();
			for (int i = 0; i < commlist.size(); i++) {
				Commodity commo = new Commodity();
				BeanUtils.copyProperties(commlist.get(i), commo);
				commo.setPrice(commlist.get(i).getPrice().doubleValue());
				commlist2.add(commo);
			}
			return commlist2;
		}
		return null;
	}

	@Override
	public Integer countByConditionsfront(Commodity comm) {
		IpoCommodity example = new IpoCommodity();
		if (comm != null) {
			BeanUtils.copyProperties(comm, example);
			return ipoCommodityMapper.countByConditionsfront(example);
		}
		return 0;
	}

	@Override
	public List<String> queryNames() {
		return ipoCommodityMapper.queryNames();
	}

	@Override
	public Commodity queryByComid(String comid) {
		if (comid != null) {
			Commodity commodity = new Commodity();
			IpoCommodity ipoCommodity = ipoCommodityMapper.queryByComid(comid);
			BeanUtils.copyProperties(ipoCommodity, commodity);
			return commodity;
		}
		return null;
	}

	@Override
	public List<Commodity> queryAllByStatusForSettle() {
		List<IpoCommodity> commlist = ipoCommodityMapper.selectByStatus(Integer.valueOf(SALE_STATUS_FEECOMPLETED));
		if (commlist != null && !commlist.isEmpty()) {
			List<Commodity> result = new ArrayList<Commodity>();
			for (int i = 0; i < commlist.size(); i++) {
				int update = ipoCommodityMapper.updateStatusByStatusId(Integer.valueOf(SALE_STATUS_FEECOMPLETED),
						Integer.valueOf(SALE_STATUS_SETTLING), commlist.get(i).getCommodityid());
				if (update < 1) // 更新不成功
					continue;

				logger.info("申购结算：获得待结算的商品id={}，成功把发售状态变为结算中={}", commlist.get(i).getCommodityid(), SALE_STATUS_SETTLING);
				Commodity commo = new Commodity();
				BeanUtils.copyProperties(commlist.get(i), commo);
				commo.setPrice(commlist.get(i).getPrice().doubleValue());
				result.add(commo);
			}
			return result;
		}
		logger.info("申购结算：没有获取到待结算的发售商品列表。。。。。。");
		return null;
	}

	@Override
	public int updateCommoditySettled(String commoId) {
		return ipoCommodityMapper.updateStatusByStatusId(Integer.valueOf(SALE_STATUS_SETTLING), Integer.valueOf(SALE_STATUS_SETTLED), commoId);
	}

}
