package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Integer insertInfo(UnderwriterDeposit example) {
		if (example != null) {
			IpoUnderwriterDeposit record = new IpoUnderwriterDeposit();
			BeanUtils.copyProperties(example, record);
			BigDecimal subId = new BigDecimal(example.getSubscribeid());
			int num = depositmapper.insert(record);
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("money", "");
			param1.put("userid", ipoSpoRationMapper
					.firmidBySales(subscribeMapper.selectByPrimaryKey(subId)
							.getUnderwriterid()));
			param1.put("amount", example.getAmount());
			param1.put("moduleid", "40");
			fundsMapper.getfrozen(param1);
			return num;
		}
		return 0;
	}

}
