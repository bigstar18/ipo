package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.modules.sys.entity.VFFirmcurfunds;
import com.yrdce.ipo.modules.sys.entity.VFFirmcurfundsExample;

public interface VFFirmcurfundsMapper extends CrudDao<VFFirmcurfunds> {
	int countByExample(VFFirmcurfundsExample example);

	int deleteByExample(VFFirmcurfundsExample example);

	int insert(VFFirmcurfunds record);

	int insertSelective(VFFirmcurfunds record);

	List<VFFirmcurfunds> selectByExample(VFFirmcurfundsExample example);

	int updateByExampleSelective(@Param("record") VFFirmcurfunds record, @Param("example") VFFirmcurfundsExample example);

	int updateByExample(@Param("record") VFFirmcurfunds record, @Param("example") VFFirmcurfundsExample example);
}