package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.Historydaydata;

@MyBatisDao
public interface HistorydaydataMapper {

	List<Historydaydata> selectByExample(Historydaydata record);

	List<Historydaydata> selectAll();

}