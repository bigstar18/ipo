package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryProp;
import com.yrdce.ipo.modules.sys.entity.MProperty;

@MyBatisDao
public interface IpoDeliveryPropMapper {
	int insert(IpoDeliveryProp record);

	int deleteByCommodityId(String commId);

	List<IpoDeliveryProp> selectAll();

	List<MProperty> selectCategoryProps(Long categoryId);// 查出商品有哪些属性

	List<MProperty> selectPropValues(@Param("categoryId") Long categoryId,
			@Param("breedId") Long breedId);// 查出属性对应的下拉框
}