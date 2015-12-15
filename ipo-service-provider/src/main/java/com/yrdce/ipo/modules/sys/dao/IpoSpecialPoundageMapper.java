package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoSpecialPoundage;
import java.util.List;

public interface IpoSpecialPoundageMapper {
    int deleteByPrimaryKey(String poundageId);

    int insert(IpoSpecialPoundage record);

    IpoSpecialPoundage selectByPrimaryKey(String poundageId);

    List<IpoSpecialPoundage> selectAll();

    int updateByPrimaryKey(IpoSpecialPoundage record);
}