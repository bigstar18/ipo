package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TACommoditytradeprop;
import com.yrdce.ipo.modules.sys.entity.TACommoditytradepropExample;
import com.yrdce.ipo.modules.sys.entity.TACommoditytradepropKey;
import com.yrdce.ipo.modules.sys.vo.Commoditytradeprop;

@MyBatisDao
public interface TACommoditytradepropMapper {
	int countByExample(TACommoditytradepropExample example);

	int deleteByExample(TACommoditytradepropExample example);

	int deleteByPrimaryKey(TACommoditytradepropKey key);

	int insert(TACommoditytradeprop record);

	int insertSelective(TACommoditytradeprop record);

	List<TACommoditytradeprop> selectByExample(TACommoditytradepropExample example);

	TACommoditytradeprop selectByPrimaryKey(TACommoditytradepropKey key);

	int updateByExampleSelective(@Param("record") TACommoditytradeprop record, @Param("example") TACommoditytradepropExample example);

	int updateByExample(@Param("record") TACommoditytradeprop record, @Param("example") TACommoditytradepropExample example);

	int updateByPrimaryKeySelective(TACommoditytradeprop record);

	int updateByPrimaryKey(TACommoditytradeprop record);

	List<Commoditytradeprop> selectByCommodity(Short id);
}