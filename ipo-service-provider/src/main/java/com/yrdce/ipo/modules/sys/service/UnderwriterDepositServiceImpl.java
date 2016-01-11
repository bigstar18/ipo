package com.yrdce.ipo.modules.sys.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterDepositMapper;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterDeposit;
import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;

@Service
public class UnderwriterDepositServiceImpl implements UnderwriterDepositService {

	@Autowired
	private IpoUnderwriterDepositMapper depositmapper;

	@Override
	@Transactional
	public Integer insertInfo(UnderwriterDeposit example) {
		if (example != null) {
			IpoUnderwriterDeposit record = new IpoUnderwriterDeposit();
			BeanUtils.copyProperties(example, record);
			return depositmapper.insert(record);
		}

		return 0;
	}

}
