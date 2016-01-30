package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoBilloflading;

/**
 * 
* @ClassName: IpoBillofladingMapper 
* @Description: 经济会员商品提货单
* @author bob
 */
@MyBatisDao
public interface IpoBillofladingMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoBilloflading record);

	IpoBilloflading selectByPrimaryKey(BigDecimal id);

	List<IpoBilloflading> selectAll();

	int updateByPrimaryKey(IpoBilloflading record);
}