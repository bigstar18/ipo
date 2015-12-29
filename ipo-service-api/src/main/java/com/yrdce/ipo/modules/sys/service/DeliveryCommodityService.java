package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;

/**
 * 交收属性配置商品列表
 * 
 * @author chenjing
 *
 */
public interface DeliveryCommodityService {

	public List<DeliveryCommodity> findDeliveryCommoditys(String page,
			String rows, DeliveryCommodity example);

	public Integer getNums(DeliveryCommodity example);

}
