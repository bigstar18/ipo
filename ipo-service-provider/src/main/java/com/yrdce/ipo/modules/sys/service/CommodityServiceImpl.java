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

@Service("commodityService")
@Transactional(readOnly = true)
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
	public List<Commodity> findCommList(String page, String rows) {
		logger.info("分页获取发售商品列表");
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoCommodity> commlist = new ArrayList<IpoCommodity>();
			List<Commodity> commlist2 = new ArrayList<Commodity>();
			commlist = ipoCommodityMapper.getAllByPage((curpage - 1) * pagesize + 1, curpage * pagesize);
			for (int i = 0; i < commlist.size(); i++) {
				Commodity commo = new Commodity();
				BeanUtils.copyProperties(commlist.get(i), commo);
				commo.setPrice(commlist.get(i).getPrice().doubleValue());
				commlist2.add(commo);
			}
			return commlist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Commodity getCommodity(String commid) {
		logger.info("根据商品ID查询信息");
		IpoCommodity ipoCom = ipoCommodityMapper.selectByComid(commid.toUpperCase());
		logger.info("ipoCom:" + ipoCom.toString());
		if (ipoCom == null) {
			return null;
		}
		Commodity commo = new Commodity();
		BeanUtils.copyProperties(ipoCom, commo);
		commo.setPrice(ipoCom.getPrice().doubleValue());
		return commo;
	}

	@Override
	public Integer getAllComms() {
		try {
			return ipoCommodityMapper.countByExample(new IpoCommodityExample());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * 获取所有发售商品信息
	 */
	@Override
	public List<Commodity> findAll() {
		logger.info("获取所有发售商品信息");
		try {
			List<IpoCommodity> commlist = new ArrayList<IpoCommodity>();
			List<Commodity> commlist2 = new ArrayList<Commodity>();
			commlist = ipoCommodityMapper.selectAll();
			for (int i = 0; i < commlist.size(); i++) {
				Commodity commo = new Commodity();
				BeanUtils.copyProperties(commlist.get(i), commo);
				commo.setPrice(commlist.get(i).getPrice().doubleValue());
				commlist2.add(commo);
			}
			return commlist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * mgr后台发行摇号
	 */
	@Override
	public List<Commodity> getList(String page, String rows) {
		logger.info("mgr后台发行摇号");

		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoCommodityExtended> commlist = new ArrayList<IpoCommodityExtended>();
		List<Commodity> commlist2 = new ArrayList<Commodity>();
		commlist = ipoCommodityMapper.selectByCommodityAndOrder((curpage - 1) * pagesize + 1, curpage * pagesize);
		if (commlist == null) {
			return null;
		}
		for (int i = 0; i < commlist.size(); i++) {
			Commodity commo = new Commodity();
			BeanUtils.copyProperties(commlist.get(i), commo);
			// commo.setPrice(commlist.get(i).getPrice().doubleValue());
			commlist2.add(commo);
		}
		logger.info("commlist2:" + commlist2.size());
		return commlist2;

	}

	@Override
	public Integer getCounts() {
		try {
			int counts1 = ipoCommodityMapper.getCounts();
			Integer counts2 = Integer.valueOf(counts1);
			return counts2;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Commodity getCommodityByPage(String page, String rows, String commodityid) {
		logger.info("根据商品id分页查询mgr后台发行摇号");

		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoCommodityExtended commlist;
		commlist = ipoCommodityMapper.getAllBycommodityid((curpage - 1) * pagesize + 1, curpage * pagesize, commodityid.toUpperCase());
		if (commlist == null) {
			return null;
		}

		Commodity commo = new Commodity();
		BeanUtils.copyProperties(commlist, commo);
		logger.info("commo:" + commo.toString());
		return commo;
	}

	@Override
	public Integer getCountsByPage(String commodityid) {
		int counts = ipoCommodityMapper.getCountsByPage(commodityid.toUpperCase());
		Integer counts1 = Integer.valueOf(counts);
		return counts1;
	}

}
