package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;
import com.yrdce.ipo.modules.sys.vo.Commodity;

@Service("commodityService")
@Transactional(readOnly = true)
public class CommodityServiceImpl implements CommodityService {

	
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
	 * 
	 */

	@Override
	public List<Commodity> findCommList(String page, String rows) {
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
			commo.setUnits(commlist.get(i).getUnits());
			commo.setStarttime(commlist.get(i).getStarttime());
			commo.setEndtime(commlist.get(i).getEndtime());
			commlist2.add(commo);
		}
		return commlist2;
	}

	@Override
	public Commodity getCommodity(String commId) {
		IpoCommodity ipoCom = ipoCommodityMapper.selectByComid(commId);
		if (ipoCom == null) {
			return null;
		}
		Commodity commo = new Commodity();
		BeanUtils.copyProperties(ipoCom, commo);
		commo.setPrice(ipoCom.getPrice().doubleValue());
		commo.setUnits(ipoCom.getUnits());
		commo.setStarttime(ipoCom.getStarttime());
		commo.setEndtime(ipoCom.getEndtime());
		return commo;
	}

	@Override
	public int getAllComms() {
		return ipoCommodityMapper.countByExample(new IpoCommodityExample());
	}

	/*
	 * 获取所有发售商品信息
	 */
	@Override
	public List<Commodity> findAll() {
		List<IpoCommodity> commlist = new ArrayList<IpoCommodity>();
		List<Commodity> commlist2 = new ArrayList<Commodity>();
		commlist = ipoCommodityMapper.selectAll();
		for (int i = 0; i < commlist.size(); i++) {
			Commodity commo = new Commodity();
			BeanUtils.copyProperties(commlist.get(i), commo);
			commo.setPrice(commlist.get(i).getPrice().doubleValue());
			commo.setUnits(commlist.get(i).getUnits());
			commo.setStarttime(commlist.get(i).getStarttime());
			commo.setEndtime(commlist.get(i).getEndtime());
			commlist2.add(commo);
		}
		return commlist2;
	}

}
