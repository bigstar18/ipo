package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoMapper;
import com.yrdce.ipo.modules.sys.entity.IpoSpo;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.IpoSpoRation;
import com.yrdce.ipo.modules.sys.vo.Spo;

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
	public List<Spo> getSPOList(String page, String rows, Spo spo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("分页获得增发列表");
		return null;
	}

	// 获得商品名称以及商品代码
	@Override
	public Map<String, String> getCommodityidByAll() throws Exception {
		// TODO Auto-generated method stub
		logger.info("获得商品名称以及商品代码");
		return null;
	}

	// 添加增发信息
	@Override
	@Transactional
	public int insertSPOInfo(SpoCommoditymanmaagement ipoSpoCom) throws Exception {
		// TODO Auto-generated method stub
		logger.info("添加增发信息");
		return 0;
	}

	// 修改增发信息
	@Override
	@Transactional
	public int updateSPOInfo(Spo spo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("修改增发信息");
		return 0;
	}

	// 删除增发信息
	@Override
	@Transactional
	public int deleteSPOInfo(String spoid) throws Exception {
		// TODO Auto-generated method stub
		logger.info("删除增发信息" + "增发id:" + spoid);
		return 0;
	}

	// 承销商配售比例信息
	@Override
	public List<IpoSpoRation> getRationInfo(Spo spo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("承销商配售比例信息");
		return null;
	}

	// 更新承销商配售比例
	@Override
	@Transactional
	public int updateByRation(String spoid) throws Exception {
		// TODO Auto-generated method stub
		logger.info("更新承销商配售比例" + "增发id:" + spoid);
		return 0;
	}

	// 分配承销商配售比例
	@Override
	@Transactional
	public int insertByRation(IpoSpoRation ipoSpoRation) throws Exception {
		// TODO Auto-generated method stub
		logger.info("分配承销商配售比例");
		return 0;
	}

	// 分页获取配售信息
	@Override
	public List<IpoSpoRation> getRationInfo(String page, String rows, Spo spo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("分页获取配售信息");
		return null;
	}

	// 删除配售信息
	@Override
	@Transactional
	public int deleteByRation(String rationid) throws Exception {
		// TODO Auto-generated method stub
		logger.info("删除配售信息" + "配售id:" + rationid);
		return 0;
	}
}
