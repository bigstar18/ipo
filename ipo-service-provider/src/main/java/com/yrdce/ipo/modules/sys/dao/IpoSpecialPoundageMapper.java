package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialPoundage;

@MyBatisDao
public interface IpoSpecialPoundageMapper {
	int deleteByPrimaryKey(Long poundageId);

	int insert(IpoSpecialPoundage record);

	IpoSpecialPoundage selectByPrimaryKey(Long poundageId);

	List<IpoSpecialPoundage> selectAll();

	int updateByPrimaryKey(IpoSpecialPoundage record);
}