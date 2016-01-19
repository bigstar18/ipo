package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialcounterfee;

@MyBatisDao
public interface IpoSpecialcounterfeeMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoSpecialcounterfee record);

	IpoSpecialcounterfee selectByPrimaryKey(BigDecimal id);

	List<IpoSpecialcounterfee> selectAll();

	int updateByPrimaryKey(IpoSpecialcounterfee record);
}