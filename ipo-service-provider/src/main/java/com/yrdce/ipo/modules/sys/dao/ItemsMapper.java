package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.modules.sys.entity.Items;
import com.yrdce.ipo.modules.sys.entity.ItemsExample;

public interface ItemsMapper extends CrudDao<Items> {
	int countByExample(ItemsExample example);

	int deleteByExample(ItemsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Items record);

	int insertSelective(Items record);

	List<Items> selectByExampleWithBLOBs(ItemsExample example);

	List<Items> selectByExample(ItemsExample example);

	Items selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

	int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

	int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

	int updateByPrimaryKeySelective(Items record);

	int updateByPrimaryKeyWithBLOBs(Items record);

	int updateByPrimaryKey(Items record);
}