package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPublisherPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPublisherPosition;
import com.yrdce.ipo.modules.sys.vo.PublisherPosition;
import com.yrdce.ipo.modules.warehouse.dao.IpoStorageMapper;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorage;

/**
 * @author chenjing
 *
 */
@Service
public class PublisherPositionServiceImpl implements PublisherPositionService {

	@Autowired
	private IpoPublisherPositionMapper publisherPositionmapper;

	@Autowired
	private IpoStorageMapper stroragemapper;

	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;

	@Autowired
	private FFirmfundsMapper fundsMapper;

	@Override
	public List<PublisherPosition> getInfoByPage(String page, String rows,
			PublisherPosition example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			List<IpoPublisherPosition> datalist = publisherPositionmapper
					.selectByPage(startIndex, endIndex, record);
			List<PublisherPosition> datalist2 = new ArrayList<PublisherPosition>();
			for (IpoPublisherPosition temp : datalist) {
				PublisherPosition info = new PublisherPosition();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getPubPositionNum(PublisherPosition example) {
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			return publisherPositionmapper.getTotalNum(record);
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer insertPubPoition(PublisherPosition example) {
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			IpoStorage storage = stroragemapper.getStorageByPrimary(example
					.getStorageid());
			storage.setTransferstate(1);// 转持仓新增状态
			int unum = stroragemapper.updateByPrimaryKey(storage);
			int inum = publisherPositionmapper.insert(record);
			if (unum == 1 && inum == 1) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public Long getSaleCounts(String commodityid) {
		Long num = publisherPositionmapper.getSaleCounts(commodityid);
		if (num != null) {
			return num;
		}
		return (long) 0;
	}

	@Override
	@Transactional
	public String frozenFunds(String publisherid, BigDecimal money) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		String userid = ipoSpoRationMapper.firmidBySales(publisherid);
		param.put("userid", userid);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal funds = (BigDecimal) param.get("money");
		if (funds.compareTo(money) < 0) {
			return "false";
		}
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("money", "");
		param1.put("userid", userid);
		param1.put("amount", money);
		param1.put("moduleid", "40");
		fundsMapper.getfrozen(param1);
		return "true";
	}

	@Override
	public PublisherPosition getInfoByStorageId(String storageid) {
		IpoPublisherPosition example = publisherPositionmapper
				.getInfoByStorageId(storageid);
		if (example != null) {
			PublisherPosition record = new PublisherPosition();
			BeanUtils.copyProperties(example, record);
			return record;
		}
		return null;
	}

	@Override
	@Transactional
	public String updateStatus(PublisherPosition example) {
		IpoPublisherPosition record = new IpoPublisherPosition();
		BeanUtils.copyProperties(example, record);
		int num = publisherPositionmapper.updateByPrimaryKey(record);
		IpoStorage storage = stroragemapper.getStorageByPrimary(record
				.getStorageid());
		storage.setTransferstate(2);// 已冻结
		int snum = stroragemapper.updateByPrimaryKey(storage);
		if (num == 1 && snum == 1) {
			return "true";
		}
		return "false";
	}
}
