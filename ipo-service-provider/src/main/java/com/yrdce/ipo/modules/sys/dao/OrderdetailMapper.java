package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.modules.sys.entity.Orderdetail;
import com.yrdce.ipo.modules.sys.entity.OrderdetailExample;

public interface OrderdetailMapper extends CrudDao<Orderdetail> {
	int countByExample(OrderdetailExample example);

	int deleteByExample(OrderdetailExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Orderdetail record);

	int insertSelective(Orderdetail record);

	List<Orderdetail> selectByExample(OrderdetailExample example);

	Orderdetail selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

	int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

	int updateByPrimaryKeySelective(Orderdetail record);

	int updateByPrimaryKey(Orderdetail record);
}