package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;
import java.util.Date;

public interface IpoSysStatusMapper {
    int deleteByPrimaryKey(Date tradedate);

    int insert(IpoSysStatus record);

    int insertSelective(IpoSysStatus record);

    IpoSysStatus selectByPrimaryKey(Date tradedate);

    int updateByPrimaryKeySelective(IpoSysStatus record);

    int updateByPrimaryKey(IpoSysStatus record);
}