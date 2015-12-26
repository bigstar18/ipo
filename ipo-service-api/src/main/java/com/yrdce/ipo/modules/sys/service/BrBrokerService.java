package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * 加盟商
 * 
 * @author chenjing
 *
 */
public interface BrBrokerService {

	/**
	 *
	 * 查询所有发行会员
	 */
	public List<VBrBroker> findAllPublisher();

}
