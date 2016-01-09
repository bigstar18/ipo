package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.BrBrokerMapper;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * @author chenjing
 *
 */
@Service("brBrokerService")
public class BrBrokerServiceImpl implements BrBrokerService {

	@Autowired
	private BrBrokerMapper brBrokerMapper;

	public BrBrokerMapper getBrBrokerMapper() {
		return brBrokerMapper;
	}

	public void setBrBrokerMapper(BrBrokerMapper brBrokerMapper) {
		this.brBrokerMapper = brBrokerMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VBrBroker> findAllPublisher() {
		try {
			List<BrBroker> blist = brBrokerMapper.findAllPublisher();
			List<VBrBroker> blist2 = new ArrayList<VBrBroker>();
			for (BrBroker temp : blist) {
				VBrBroker brbroker = new VBrBroker();
				BeanUtils.copyProperties(temp, brbroker);
				blist2.add(brbroker);
			}
			return blist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int insert(VBrBroker record) {
		BrBroker brBroker = new BrBroker();
		if (record != null) {
			BeanUtils.copyProperties(record, brBroker);
			return brBrokerMapper.insert(brBroker);
		}
		return 0;
	}

	@Override // hxx
	public VBrBroker queryBrokerById(String brokerId) {
		BrBroker broker = brBrokerMapper.selectById(brokerId);
		if (broker != null) {
			VBrBroker brbroker = new VBrBroker();
			BeanUtils.copyProperties(broker, brbroker);
			return brbroker;
		}
		return null;
	}
}
