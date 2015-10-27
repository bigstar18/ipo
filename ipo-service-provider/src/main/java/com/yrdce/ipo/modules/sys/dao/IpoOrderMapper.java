package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.IpoOrderExample;

@MyBatisDao
public interface IpoOrderMapper extends CrudDao<IpoOrder> {
	int countByExample(IpoOrderExample example);

	int deleteByExample(IpoOrderExample example);

	int deleteByPrimaryKey(BigDecimal orderid);

	int insert(IpoOrder record);

	int insertSelective(IpoOrder record);

	List<IpoOrder> selectByExample(IpoOrderExample example);

	IpoOrder selectByPrimaryKey(BigDecimal orderid);

	int updateByExampleSelective(@Param("record") IpoOrder record, @Param("example") IpoOrderExample example);

	int updateByExample(@Param("record") IpoOrder record, @Param("example") IpoOrderExample example);

	int updateByPrimaryKeySelective(IpoOrder record);

	int updateByPrimaryKey(IpoOrder record);
}