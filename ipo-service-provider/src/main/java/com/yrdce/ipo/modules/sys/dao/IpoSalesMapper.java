package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSales;

@MyBatisDao
public interface IpoSalesMapper {
	List<IpoSales> getList();
}
