package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.vo.MProperty;

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

	public List<MProperty> getPropsByCategoryId(Long categoryId);

	public List<MProperty> getPropertyValues(Long categoryId, Long breedId);

	public String setDeliveryProps(String commId, String propertys);

	public String deleteDeliveryProps(String commId);

}
