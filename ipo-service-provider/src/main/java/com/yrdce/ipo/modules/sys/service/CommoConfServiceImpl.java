package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;
import com.yrdce.ipo.modules.warehouse.dao.IpoStorageMapper;

@Service("ipoCommConfService")
public class CommoConfServiceImpl implements IpoCommConfService {

	static Logger log = LoggerFactory.getLogger(CommoConfServiceImpl.class);

	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfmapper;

	@Autowired
	private IpoCommodityMapper commoditymapper;

	@Autowired
	private IpoStorageMapper ipoStorageMapper;

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

		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper
				.findIpoCommConfByBreedid(Breedid,
						(curpage - 1) * pagesize + 1, curpage * pagesize);
		List<VIpoCommConf> ipocomcoflist2 = new ArrayList<VIpoCommConf>();
		for (int i = 0; i < ipocomcoflist.size(); i++) {
			VIpoCommConf vipocomconf = new VIpoCommConf();
			BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
			ipocomcoflist2.add(vipocomconf);
		}
		return ipocomcoflist2;

	}

	@Override
	public int getTotalIpoCommsByBreedid(Long Breedid) {
		return ipoCommodityConfmapper.countByBreedid(Breedid);
	}

	@Override
	public VIpoCommConf getVIpoCommConfByCommid(String commid) {
		VIpoCommConf ipocommconf = new VIpoCommConf();
		IpoCommodityConf comm = ipoCommodityConfmapper
				.findIpoCommConfByCommid(commid);
		if (comm != null) {
			log.debug(comm.toString());
			BeanUtils.copyProperties(comm, ipocommconf);
			return ipocommconf;
		}
		return null;
	}

	@Override
	@Transactional
	public String addCommodity(VIpoCommConf comm) {
		IpoCommodityConf ipocommconf = new IpoCommodityConf();
		IpoCommodity ipocomm = new IpoCommodity();
		if (comm != null) {
			BeanUtils.copyProperties(comm, ipocommconf);
			BeanUtils.copyProperties(comm, ipocomm);
			ipocomm.setStatus(comm.getStatus().intValue());
			int inum = ipoCommodityConfmapper.insert(ipocommconf);
			int cnum = commoditymapper.insert(ipocomm);
			addFeeSubject(comm.getCommodityid());
			if (inum != 0 && cnum != 0) {
				return "success";
			}
			return "false";
		}
		return "false";
	}

	// select count(*) into v_cnt from f_account where
	// code='200215'||p_CommodityID;
	// if(v_cnt=0) then
	// insert into f_account(Code,Name,accountLevel,dCFlag)
	// select '200215'||p_CommodityID,name||p_CommodityID,3,'C' from f_account
	// where code='200215';
	// end if;
	// INSERT INTO "TRADE_GNNT"."F_ACCOUNT" VALUES ('200240', '申购货款', '2', 'C',
	// 'Y');
	// hxx
	private void addFeeSubject(String commoId) {
		int cnt = ipoCommodityConfmapper.querySubjectCommoCount("200240"
				+ commoId);
		if (cnt == 0) {
			if (ipoCommodityConfmapper.addFeeSubject("200240", commoId) < 1)
				log.error("账簿添加科目失败: parentSubject=200240, commoId={}", commoId);
		} else
			log.error("科目已经存在: parentSubject=200240, commoId={}", commoId);
	}

	@Override
	@Transactional
	public String updateCommodity(VIpoCommConf comm) {
		IpoCommodityConf ipocommconf = new IpoCommodityConf();
		IpoCommodity ipocomm = new IpoCommodity();
		if (comm != null) {
			BeanUtils.copyProperties(comm, ipocommconf);
			BeanUtils.copyProperties(comm, ipocomm);
			ipocomm.setStatus(comm.getStatus().intValue());
			int inum = ipoCommodityConfmapper.update(ipocommconf);
			int cnum = commoditymapper.update(ipocomm);
			if (cnum != 0 && inum != 0) {
				return "success";
			}
		}
		return "false";
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
		List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper
				.findAllIpoCommConfsByPage((curpage - 1) * pagesize + 1,
						curpage * pagesize);
		List<VIpoCommConf> ipocomcoflist2 = new ArrayList<VIpoCommConf>();
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
		List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper
				.findAllIpoCommConfs();
		List<VIpoCommConf> ipocomcoflist2 = new ArrayList<VIpoCommConf>();
		for (int i = 0; i < ipocomcoflist.size(); i++) {
			VIpoCommConf vipocomconf = new VIpoCommConf();
			BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
			ipocomcoflist2.add(vipocomconf);
		}
		return ipocomcoflist2;
	}

	@Override
	public List<VIpoCommConf> selectCommodityByExample(VIpoCommConf example) {
		IpoCommodityConf record = new IpoCommodityConf();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper
				.selectCommodityByExample(record);
		List<VIpoCommConf> ipocomcoflist2 = new ArrayList<VIpoCommConf>();
		for (int i = 0; i < ipocomcoflist.size(); i++) {
			VIpoCommConf vipocomconf = new VIpoCommConf();
			BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
			ipocomcoflist2.add(vipocomconf);
		}
		return ipocomcoflist2;
	}

	@Override
	public List<VIpoCommConf> findIpoCommConfsByExample(String page,
			String rows, VIpoCommConf example) {
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoCommodityConf record = new IpoCommodityConf();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper
				.findAllIpoCommConfsByExample((curpage - 1) * pagesize + 1,
						curpage * pagesize, record);
		List<VIpoCommConf> ipocomcoflist2 = new ArrayList<VIpoCommConf>();
		for (int i = 0; i < ipocomcoflist.size(); i++) {
			VIpoCommConf vipocomconf = new VIpoCommConf();
			BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
			ipocomcoflist2.add(vipocomconf);
		}
		return ipocomcoflist2;
	}

	@Override
	public int getNumsByExample(VIpoCommConf example) {
		IpoCommodityConf record = new IpoCommodityConf();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		return ipoCommodityConfmapper.getNumsByExample(record);
	}

	@Override
	public List<VIpoCommConf> selectCommodityByWarehouse(String wareManagerId) {
		Long warehouseId = ipoStorageMapper
				.getWarehousePrimaryKey(wareManagerId);
		if (warehouseId != null) {
			List<IpoCommodityConf> ipocomcoflist = ipoCommodityConfmapper
					.findCommodityByWarehouse(ipoStorageMapper
							.getWarehousePrimaryKey(wareManagerId));
			List<VIpoCommConf> ipocomcoflist2 = new ArrayList<VIpoCommConf>();
			for (int i = 0; i < ipocomcoflist.size(); i++) {
				VIpoCommConf vipocomconf = new VIpoCommConf();
				BeanUtils.copyProperties(ipocomcoflist.get(i), vipocomconf);
				ipocomcoflist2.add(vipocomconf);
			}
			return ipocomcoflist2;
		}
		return null;
	}

	@Override
	public List<VIpoCommConf> findAvaiSubscribeCommoditys() {
		log.info("获取可供承销认购的商品");
		List<VIpoCommConf> commlist2 = new ArrayList<VIpoCommConf>();
		List<IpoCommodityConf> commlist = ipoCommodityConfmapper
				.findAvaiSubscribeCommoditys();
		for (int i = 0; i < commlist.size(); i++) {
			VIpoCommConf commo = new VIpoCommConf();
			BeanUtils.copyProperties(commlist.get(i), commo);
			commlist2.add(commo);
		}
		return commlist2;
	}
}
