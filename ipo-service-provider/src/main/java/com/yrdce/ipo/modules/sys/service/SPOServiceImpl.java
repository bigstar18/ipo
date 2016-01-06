package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;
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
	private IpoSpoCommoditymanmaagementMapper ipoSPOCommMapper;
	@Autowired
	private IpoCommodityMapper ipoCommodityMapper;
	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;
	@Autowired
	private FFirmfundsMapper fundsMapper;

	@Override
	public List<SpoRation> getMyRationInfo(SpoCommoditymanmaagement spoCommo, String page, String rows) {
		// TODO Auto-generated method stub

		if (spoCommo == null)
			return null;
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int beginNum = (Integer.parseInt(page) - 1) * Integer.parseInt(rows) + 1;
		int endNum = Integer.parseInt(page) * Integer.parseInt(rows);
		IpoSpoCommoditymanmaagement ipoSpoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoCommo, ipoSpoComm);
		List<IpoSpoRation> ipoSpos = ipoSpoRationMapper.getMyRationInfo(beginNum, endNum, ipoSpoComm);
		List<SpoRation> spos = new ArrayList<SpoRation>();
		for (IpoSpoRation ipoSpo2 : ipoSpos) {
			SpoRation tempSpo = new SpoRation();
			BeanUtils.copyProperties(ipoSpo2, tempSpo);
			spos.add(tempSpo);
		}
		return spos;
	}

	@Override
	public int getRationInfoCounts(SpoCommoditymanmaagement spoComm) {
		if (spoComm == null) {
			return 0;
		}
		IpoSpoCommoditymanmaagement ipoSpoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipoSpoComm);
		int counts = ipoSpoRationMapper.getRationInfoCounts(ipoSpoComm);
		return counts;
	}

	@Override
	public int updateRationType(Long rationId, String dealerId) {
		// 获得可用资金
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monery", "");
		param.put("userid", dealerId);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal monery = (BigDecimal) param.get("monery");
		IpoSpoRation ipoSpoRation = ipoSpoRationMapper.selectByPrimaryKey(rationId);
		// 单价
		BigDecimal price = ipoSpoRation.getSpoPrice();
		// 数量
		Long counts = ipoSpoRation.getRationcounts();
		BigDecimal counts1 = new BigDecimal(counts);
		// 服务费
		BigDecimal fee = ipoSpoRation.getServicefee();
		BigDecimal Monery = price.multiply(counts1);
		// 总费用
		BigDecimal allMonery = Monery.add(fee);
		if (monery.compareTo(allMonery) != -1) {
			int result = ipoSpoRationMapper.updateRationType(rationId);
			// 资金冻结
			float mony = allMonery.floatValue();
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("monery", "");
			param1.put("userid", dealerId);
			param1.put("amount", mony);
			param1.put("moduleid", "40");
			fundsMapper.getfrozen(param1);
			if (result > 0) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;
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
		List<IpoSpoCommoditymanmaagement> list2 = ipoSPOCommMapper.selectAll((curpage - 1) * pagesize + 1, curpage * pagesize, ipospoComm);
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
		String type = spoComm.getRationType();
		if (type.equals("1")) {
			Date spoDate = spoComm.getSpoDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String spoDate1 = sdf.format(spoDate);
			String date = sdf.format(new Date());
			if (spoDate1.equals(date)) {
				IpoSpoCommoditymanmaagement ipospoComm = this.status(spoComm, 1);
				return ipoSPOCommMapper.insert(ipospoComm);
			} else {
				IpoSpoCommoditymanmaagement ipospoComm = this.status(spoComm, 4);
				return ipoSPOCommMapper.insert(ipospoComm);
			}
		} else {
			IpoSpoCommoditymanmaagement ipospoComm = this.status(spoComm, 1);
			return ipoSPOCommMapper.insert(ipospoComm);
		}
	}

	// 添加增发信息共用方法
	public IpoSpoCommoditymanmaagement status(SpoCommoditymanmaagement spoComm, int status) {
		long counts = spoComm.getSpoCounts();
		spoComm.setNotRationCounts(counts);
		spoComm.setSuccessRationCounts((long) 0);
		spoComm.setSpoSate(status);
		spoComm.setRebate(2);
		spoComm.setBeListed(2);
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipospoComm;
	}

	// 修改增发信息
	@Override
	@Transactional
	public int updateSPOInfo(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("修改增发信息");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOCommMapper.updateByPrimaryKey(ipospoComm);
	}

	// 删除增发信息
	@Override
	@Transactional
	public int deleteSPOInfo(String spoid) throws Exception {
		logger.info("删除增发信息" + "增发id:" + spoid);
		return ipoSPOCommMapper.deleteByPrimaryKey(spoid);
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
	public int updateByRation(SpoRation spoRation) throws Exception {
		logger.info("更新承销商配售比例");
		IpoSpoRation ipoSpoRation = new IpoSpoRation();
		BeanUtils.copyProperties(spoRation, ipoSpoRation);
		return ipoSpoRationMapper.updateByPrimaryKey(ipoSpoRation);
	}

	// 分配承销商配售比例
	@Override
	@Transactional
	public int insertByRation(SpoRation spoRation) throws Exception {
		logger.info("分配承销商配售比例");
		IpoSpoRation ipoSpoRation = new IpoSpoRation();
		BeanUtils.copyProperties(spoRation, ipoSpoRation);
		return ipoSpoRationMapper.insert(ipoSpoRation);
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
	public int spoCounts(SpoCommoditymanmaagement spoComm) {
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		logger.info("增发查询总页数");
		return ipoSPOCommMapper.counts(ipospoComm);
	}

	// 配售查询总页数
	@Override
	public int rationCounts(SpoCommoditymanmaagement spoComm) {
		logger.info("配售查询总页数");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSpoRationMapper.counts(ipospoComm);
	}

	// 根据增发id查增发信息
	@Override
	public SpoCommoditymanmaagement getListBySpocom(String spoid) {
		logger.info("根据增发id查增发信息" + "SPOID:" + spoid);
		IpoSpoCommoditymanmaagement ipoSpoComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
		BeanUtils.copyProperties(ipoSpoComm, spoComm);
		return spoComm;
	}

	// 更新状态
	@Override
	@Transactional
	public int updateStatus(Integer rationSate, String spoid) throws Exception {
		logger.info("跟新状态" + "rationSate:" + rationSate + "SPOID:" + spoid);
		return ipoSPOCommMapper.updateByStatus(rationSate, spoid);
	}

	// 修改增发商品
	@Override
	@Transactional
	public int updateComm(SpoCommoditymanmaagement spoComm) throws Exception {
		logger.info("修改增发商品");
		IpoSpoCommoditymanmaagement ipospoComm = new IpoSpoCommoditymanmaagement();
		BeanUtils.copyProperties(spoComm, ipospoComm);
		return ipoSPOCommMapper.updateByComm(ipospoComm);
	}

	// 根据增发ID查询增发总量
	@Override
	public long circulation(String spoid) throws Exception {
		logger.info("根据增发ID查询增发总量" + "spoid:" + spoid);
		IpoSpoCommoditymanmaagement ipoSPOComm = ipoSPOCommMapper.selectByPrimaryKey(spoid);
		return ipoSPOComm.getSpoCounts();
	}

	// 更新已配售和未配售
	@Override
	@Transactional
	public int updatePlscingNum(Long success, Long balance, String spoid) throws Exception {
		logger.info("更新已配售和未配售" + "已配售：" + success + ",未配售：" + balance + ",spoid:" + spoid);
		ipoSPOCommMapper.updatePlscingNum(success, balance, spoid);
		return ipoSPOCommMapper.updatePlscingNum(success, balance, spoid);
	}

	// 根据会员id查询交易商id
	@Override
	public String getFirmid(String brokerid) {
		return ipoSpoRationMapper.firmidBySales(brokerid);
	}

	@Override
	public String getFirmname(String firmid) {
		return ipoSpoRationMapper.selectFirmname(firmid);
	}
}
