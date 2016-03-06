package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterDepositMapper;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterSubscribeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;
import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;

@Service
public class UnderwriterDepositServiceImpl implements UnderwriterDepositService {

	@Autowired
	private IpoUnderwriterDepositMapper depositmapper;

	@Autowired
	private FFirmfundsMapper fundsMapper;

	@Autowired
	private IpoUnderwriterSubscribeMapper subscribeMapper;

	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;

	@Override
	@Transactional
	public void insertInfo(UnderwriterDeposit example) {
		if (example != null) {
			IpoUnderwriterDeposit record = new IpoUnderwriterDeposit();
			BeanUtils.copyProperties(example, record);
			IpoUnderwriterDeposit result = depositmapper
					.selectInfoByBrokerId(example.getBrokerid());
			if (result == null) {
				depositmapper.insert(record);
			} else {
				result.setUpdateDate(new Date());
				result.setUpdateUser(example.getCreateUser());
				BigDecimal newFrozenLoans = result.getAmount().add(
						example.getAmount());
				result.setAmount(newFrozenLoans);
				depositmapper.updateByPrimaryKey(result);
			}
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("money", "");
			param1.put("userid",
					ipoSpoRationMapper.firmidBySales(example.getBrokerid()));
			param1.put("amount", example.getAmount());
			param1.put("moduleid", "40");
			fundsMapper.getfrozen(param1);
		}
	}

	@Override
	public List<UnderwriterDeposit> selectInfoByPage(String page, String rows,
			UnderwriterDeposit example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		List<IpoUnderwriterDeposit> datalist = depositmapper.selectInfoByPage(
				startIndex, endIndex, example);
		List<UnderwriterDeposit> datalist2 = new ArrayList<UnderwriterDeposit>();
		for (IpoUnderwriterDeposit temp : datalist) {
			UnderwriterDeposit info = new UnderwriterDeposit();
			BeanUtils.copyProperties(temp, info);
			datalist2.add(info);
		}
		return datalist2;
	}

	@Override
	public Integer getInfoCounts(UnderwriterDeposit example) {
		return depositmapper.getInfoCounts(example);
	}

	@Override
	public UnderwriterDeposit selectInfoByBrokerId(String brokerid) {
		IpoUnderwriterDeposit example = depositmapper
				.selectInfoByBrokerId(brokerid);
		if (example != null) {
			UnderwriterDeposit record = new UnderwriterDeposit();
			BeanUtils.copyProperties(example, record);
			return record;
		}
		return null;
	}
}
