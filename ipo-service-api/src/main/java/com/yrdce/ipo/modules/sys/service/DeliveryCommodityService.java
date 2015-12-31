package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp;
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

	public List<MProperty> getPropsByCategoryId(Long categoryId);// 根据商品的分类ID获取商品的属性

	public List<MProperty> getPropertyValues(Long categoryId, Long breedId);// 根据商品的分类和品种获取商品的属性可选项

	public String setDeliveryProps(String commId, String propertys);// 设置交收属性

	public String deleteDeliveryProps(String commId);// 删除交收属性

	public List<IpoDeliveryProp> selectByCommodityId(String commId);// 根据商品ID获取已配置的交收属性值

}
