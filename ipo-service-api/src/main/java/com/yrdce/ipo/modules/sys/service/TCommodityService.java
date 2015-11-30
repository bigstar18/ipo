package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.VTCommodity;


/**
 * @author chenjing
 *
 */
public interface TCommodityService {

	/**
	 * 查询现货系统所有商品
	 */
	public List<VTCommodity> findAllTCommodity();
}
