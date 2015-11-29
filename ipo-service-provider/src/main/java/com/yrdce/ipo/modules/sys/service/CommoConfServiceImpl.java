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
@Transactional(readOnly = true)
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
	public void addCommodity(VIpoCommConf comm) {
		try{
			IpoCommodityConf ipocommconf=new IpoCommodityConf();
			IpoCommodity ipocomm=new IpoCommodity();
			BeanUtils.copyProperties(comm, ipocommconf);
			BeanUtils.copyProperties(comm, ipocomm);
			ipocomm.setPurchaseCredits(comm.getMaxapplynum().intValue());
			ipocomm.setUnits(comm.getUnits().intValue());
			ipocomm.setCounts(comm.getCounts().intValue());
			ipoCommodityConfmapper.insert(ipocommconf);
			commoditymapper.insert(ipocomm);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void updateCommodity(VIpoCommConf comm) {
		try{
			IpoCommodityConf ipocommconf=new IpoCommodityConf();
			IpoCommodity ipocomm=new IpoCommodity();
			BeanUtils.copyProperties(comm, ipocommconf);
			BeanUtils.copyProperties(comm, ipocomm);
			ipocomm.setPurchaseCredits(comm.getMaxapplynum().intValue());
			ipocomm.setUnits(comm.getUnits().intValue());
			ipocomm.setCounts(comm.getCounts().intValue());
			ipoCommodityConfmapper.update(ipocommconf);
			commoditymapper.update(ipocomm);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteCommodityByCommid(String commid) {
		try{
			ipoCommodityConfmapper.deleteByCommid(commid);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteCommodityByBreedID(Long breedid) {
		try{
			ipoCommodityConfmapper.deleteByBreedid(breedid);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public List<String> findIpoCommConfIds() {
		try{
			return ipoCommodityConfmapper.findAllCommIds();
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public List<VIpoCommConf> findIpoCommConf(String page, String rows) {
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper.findAllIpoCommConfs((curpage - 1) * pagesize
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
	public int getAllComms() {
		try{
			return ipoCommodityConfmapper.countAll();	
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
