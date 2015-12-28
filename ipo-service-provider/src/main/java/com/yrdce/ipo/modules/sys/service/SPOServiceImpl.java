package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoSpo;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;
import com.yrdce.ipo.modules.sys.vo.Spo;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.SpoRation;

/**
 * 
 * @author Bob
 *
 */

@Service
public class SPOServiceImpl implements SPOService {

	static Logger logger = LoggerFactory.getLogger(SPOServiceImpl.class);
	@Autowired
	private IpoSpoMapper ipoSpoMapper;
	@Autowired
	private IpoSpoCommoditymanmaagementMapper ipoSPOComm;
	@Autowired
	private IpoCommodityMapper ipoCommodityMapper;
	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;

	@Override
	public List<Spo> getInfoByPages(Spo spo, String page, String rows) {
		// TODO Auto-generated method stub

		if (spo == null)
			return null;
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int beginNum = (Integer.parseInt(page) - 1) * Integer.parseInt(rows) + 1;
		int endNum = Integer.parseInt(page) * Integer.parseInt(rows);
		IpoSpo ipoSpo = new IpoSpo();
		BeanUtils.copyProperties(spo, ipoSpo);
		List<IpoSpo> ipoSpos = ipoSpoMapper.getInfoByPages(ipoSpo, beginNum, endNum);
		List<Spo> spos = new ArrayList<Spo>();
		for (IpoSpo ipoSpo2 : ipoSpos) {
			Spo tempSpo = new Spo();
			BeanUtils.copyProperties(ipoSpo2, tempSpo);
			spos.add(tempSpo);
		}
		return spos;
	}

	@Override
	public int getInfoCounts(Spo spo) {
		if (spo == null) {
			return 0;
		}
		IpoSpo ipoSpo = new IpoSpo();
		BeanUtils.copyProperties(spo, ipoSpo);
		int counts = ipoSpoMapper.getInfoCounts(ipoSpo);
		return counts;
	}

	@Override
	public int updateRationType(String rationType) {
		// TODO Auto-generated method stub
		int result = ipoSpoMapper.updateRationType(rationType);
		if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	// 分页获得增发列表
	@Override
	public List<SpoCommoditymanmaagement> getSPOList(String page, String rows, SpoCommoditymanmaagement spoComm) throws Exception {
		// TODO Auto-generated method stub
		logger.info("分页获得增发列表");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		List<SpoCommoditymanmaagement> list1 = new ArrayList<SpoCommoditymanmaagement>();
		List<IpoSpoCommoditymanmaagement> list2 = ipoSPOComm.selectAll((curpage - 1) * pagesize + 1, curpage * pagesize, ipospoComm);
		for (IpoSpoCommoditymanmaagement ipoSPOCommoditymanmaagement : list2) {
			SpoCommoditymanmaagement spoCommoditymanmaagement = new SpoCommoditymanmaagement();
			BeanUtils.copyProperties(ipoSPOCommoditymanmaagement, spoCommoditymanmaagement);
			list1.add(spoCommoditymanmaagement);
		}
		return list1;
	}

	// 获得商品名称以及商品代码
	@Override
	public Map<String, String> getCommodityidByAll() throws Exception {
		logger.info("获得商品名称以及商品代码");
		List<IpoCommodity> list1 = ipoCommodityMapper.selectAll();
		Map<String, String> map = new HashMap<String, String>();
		for (IpoCommodity ipoCommodity : list1) {
			String id = ipoCommodity.getCommodityid();
			String name = ipoCommodity.getCommodityname();
			map.put(id, name);
		}
		return map;
	}

	// 添加增发信息
	@Override
	@Transactional
	public int insertSPOInfo(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("添加增发信息");
		long counts = spoComm.getSpoCounts();
		spoComm.setNotRationCounts(counts);
		spoComm.setSuccessRationCounts((long) 0);
		spoComm.setRationSate(4);
		spoComm.setRebate(2);
		spoComm.setBeListed(2);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOComm.insert(ipospoComm);
	}

	// 修改增发信息
	@Override
	@Transactional
	public int updateSPOInfo(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("修改增发信息");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOComm.updateByPrimaryKey(ipospoComm);
	}

	// 删除增发信息
	@Override
	@Transactional
	public int deleteSPOInfo(String spoid) throws Exception {
		logger.info("删除增发信息" + "增发id:" + spoid);
		return ipoSPOComm.deleteByPrimaryKey(spoid);
	}

	// 承销商配售比例信息
	@Override
	public List<SpoRation> getRationInfo(String spoid) throws Exception {
		logger.info("承销商配售比例信息");
		List<IpoSpoRation> list1 = ipoSpoRationMapper.selectBySPOid(spoid);
		List<SpoRation> list2 = new ArrayList<SpoRation>();
		for (IpoSpoRation ipoSpoRation : list1) {
			SpoRation spoRation = new SpoRation();
			BeanUtils.copyProperties(ipoSpoRation, spoRation);
			list2.add(spoRation);
		}
		return list2;
	}

	// 更新承销商配售比例
	@Override
	@Transactional
	public int updateByRation(List<SpoRation> spoRationList) throws Exception {
		logger.info("更新承销商配售比例");
		for (SpoRation spoRation : spoRationList) {
			IpoSpoRation ipoSpoRation = new IpoSpoRation();
			BeanUtils.copyProperties(spoRation, ipoSpoRation);
			return ipoSpoRationMapper.updateByPrimaryKey(ipoSpoRation);
		}
		return 0;
	}

	// 分配承销商配售比例
	@Override
	@Transactional
	public int insertByRation(List<SpoRation> spoRationList) throws Exception {
		logger.info("分配承销商配售比例");
		for (SpoRation spoRation : spoRationList) {
			IpoSpoRation ipoSpoRation = new IpoSpoRation();
			BeanUtils.copyProperties(spoRation, ipoSpoRation);
			return ipoSpoRationMapper.insert(ipoSpoRation);
		}
		return 0;
	}

	// 分页获取配售信息
	@Override
	public List<SpoRation> getRationInfo(String page, String rows, SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("分页获取配售信息");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		List<SpoRation> list1 = new ArrayList<SpoRation>();
		List<IpoSpoRation> list2 = ipoSpoRationMapper.selectSPOAndRa((curpage - 1) * pagesize + 1, curpage * pagesize, ipospoComm);
		for (IpoSpoRation ipospoRation : list2) {
			SpoRation spoRation = new SpoRation();
			BeanUtils.copyProperties(ipospoRation, spoRation);
			list1.add(spoRation);
		}
		return list1;
	}

	// 删除配售信息
	@Override
	@Transactional
	public int deleteByRation(Long rationid) throws Exception {
		logger.info("删除配售信息" + "配售id:" + rationid);
		return ipoSpoRationMapper.deleteByPrimaryKey(rationid);
	}

	// 增发查询总页数
	@Override
	public int spoCounts() {
		logger.info("增发查询总页数");
		return ipoSPOComm.counts();
	}

	// 配售查询总页数
	@Override
	public int rationCounts() {
		logger.info("配售查询总页数");
		return ipoSpoRationMapper.counts();
	}

	// 根据增发id查增发信息
	@Override
	public SpoCommoditymanmaagement getListBySpocom(String spoid) {
		logger.info("根据增发id查增发信息" + "SPOID:" + spoid);
		IpoSpoCommoditymanmaagement ipoSpoComm = ipoSPOComm.selectByPrimaryKey(spoid);
		SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
		BeanUtils.copyProperties(ipoSpoComm, spoComm);
		return spoComm;
	}

	// 承销商列表信息
	public List getList() {
		logger.info("承销商列表信息");
		return null;
	}

	// 跟新状态
	@Override
	@Transactional
	public int updateStatus(Integer rationSate, String spoid) throws Exception {
		logger.info("跟新状态" + "rationSate:" + rationSate + "SPOID:" + spoid);
		return ipoSPOComm.updateByStatus(rationSate, spoid);
	}

	// 修改增发商品
	@Override
	@Transactional
	public int updateComm(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("修改增发商品");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOComm.updateByComm(ipospoComm);
	}

}
