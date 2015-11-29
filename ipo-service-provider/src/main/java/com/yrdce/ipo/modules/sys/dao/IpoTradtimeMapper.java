package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTradetime;

@MyBatisDao
public interface IpoTradtimeMapper {

	public List<IpoTradetime> selectByAll(@Param("page") int page, @Param("rows") int rows);// 分页

	public IpoTradetime selectByKey(Short id);

	public void deleteByPrimaryKey(int id);// ????????????????

	public void updateByAll(IpoTradetime tradetime);

	public void insert(IpoTradetime tradetime);

	public int selectByCounts();

	public List<IpoTradetime> selectAll();// 所有
}
