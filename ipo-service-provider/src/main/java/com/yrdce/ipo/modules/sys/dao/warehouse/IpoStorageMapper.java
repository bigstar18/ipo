package com.yrdce.ipo.modules.sys.dao.warehouse;

import com.yrdce.ipo.modules.sys.entity.warehouse.IpoStorage;
import java.util.List;

public interface IpoStorageMapper {
    int deleteByPrimaryKey(String storageid);

    int insert(IpoStorage record);

    IpoStorage selectByPrimaryKey(String storageid);

    List<IpoStorage> selectAll();

    int updateByPrimaryKey(IpoStorage record);
}