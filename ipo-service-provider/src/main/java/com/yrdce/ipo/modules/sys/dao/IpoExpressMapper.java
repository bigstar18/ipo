package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import java.util.List;

public interface IpoExpressMapper {
    int deleteByPrimaryKey(String expressId);

    int insert(IpoExpress record);

    IpoExpress selectByPrimaryKey(String expressId);

    List<IpoExpress> selectAll();

    int updateByPrimaryKey(IpoExpress record);
}