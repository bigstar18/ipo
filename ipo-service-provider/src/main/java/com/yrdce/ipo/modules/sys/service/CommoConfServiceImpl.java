package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

@Service("ipoCommConfService")
public class CommoConfServiceImpl implements IpoCommConfService {
	
	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfmapper;
	
	@Autowired
	private IpoCommodityMapper commoditymapper;

	public IpoCommodityMapper getCommoditymapper() {
		return commoditymapper;
	}

	public void setCommoditymapper(IpoCommodityMapper commoditymapper) {
		this.commoditymapper = commoditymapper;
	}

	public IpoCommodityConfMapper getIpoCommodityConfmapper() {
		return ipoCommodityConfmapper;
	}

	public void setIpoCommodityConfmapper(
			IpoCommodityConfMapper ipoCommodityConfmapper) {
		this.ipoCommodityConfmapper = ipoCommodityConfmapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VIpoCommConf> findIpoCommConfByBreedid(Long Breedid,
			String page, String rows) {
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper.findIpoCommConfByBreedid(Breedid, (curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			List<VIpoCommConf> ipocomcoflist2=new ArrayList<VIpoCommConf>();
			for (int i = 0; i < ipocomcoflist.size(); i++) {
				VIpoCommConf vipocomconf = new VIpoCommConf();
				BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
				ipocomcoflist2.add(vipocomconf);
			}
			return ipocomcoflist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTotalIpoCommsByBreedid(Long Breedid) {
		try{
			return ipoCommodityConfmapper.countByBreedid(Breedid);	
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public VIpoCommConf getVIpoCommConfByCommid(String commid) {
		try{
			VIpoCommConf ipocommconf=new VIpoCommConf();
			BeanUtils.copyProperties(ipoCommodityConfmapper.findIpoCommConfByCommid(commid), ipocommconf);
			return ipocommconf;	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void addCommodity(VIpoCommConf comm) {
			IpoCommodityConf ipocommconf=new IpoCommodityConf();
			IpoCommodity ipocomm=new IpoCommodity();
			BeanUtils.copyProperties(comm, ipocommconf);
			BeanUtils.copyProperties(comm, ipocomm);
			ipocomm.setPurchaseCredits(comm.getMaxapplynum().intValue());
			ipocomm.setUnits(comm.getUnits().intValue());
			ipocomm.setCounts(comm.getCounts().intValue());
			ipoCommodityConfmapper.insert(ipocommconf);
			commoditymapper.insert(ipocomm);
	}

	@Override
	@Transactional
	public void updateCommodity(VIpoCommConf comm) {
			IpoCommodityConf ipocommconf=new IpoCommodityConf();
			IpoCommodity ipocomm=new IpoCommodity();
			BeanUtils.copyProperties(comm, ipocommconf);
			BeanUtils.copyProperties(comm, ipocomm);
			ipocomm.setPurchaseCredits(comm.getMaxapplynum().intValue());
			ipocomm.setUnits(comm.getUnits().intValue());
			ipocomm.setCounts(comm.getCounts().intValue());
			ipoCommodityConfmapper.update(ipocommconf);
			commoditymapper.update(ipocomm);
	}

	@Override
	@Transactional
	public void deleteCommodityByCommid(String commid) {
		ipoCommodityConfmapper.deleteByCommid(commid);
	}

	@Override
	@Transactional
	public void deleteCommodityByBreedID(Long breedid) {
		ipoCommodityConfmapper.deleteByBreedid(breedid);
	}

	@Override
	public List<String> findIpoCommConfIds() {
		return ipoCommodityConfmapper.findAllCommIds();
	}

	@Override
	@Transactional(readOnly = true)
	public List<VIpoCommConf> findIpoCommConfsByPage(String page, String rows) {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper.findAllIpoCommConfsByPage((curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			List<VIpoCommConf> ipocomcoflist2=new ArrayList<VIpoCommConf>();
			for (int i = 0; i < ipocomcoflist.size(); i++) {
				VIpoCommConf vipocomconf = new VIpoCommConf();
				BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
				ipocomcoflist2.add(vipocomconf);
			}
			return ipocomcoflist2;
	}

	@Override
	public int getAllComms() {
	return ipoCommodityConfmapper.countAll();	
	}

	@Override
	public List<VIpoCommConf> findIpoCommConfs() {
		List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper.findAllIpoCommConfs();
		List<VIpoCommConf> ipocomcoflist2=new ArrayList<VIpoCommConf>();
		for (int i = 0; i < ipocomcoflist.size(); i++) {
			VIpoCommConf vipocomconf = new VIpoCommConf();
			BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
			ipocomcoflist2.add(vipocomconf);
		}
		return ipocomcoflist2;
	}
}
