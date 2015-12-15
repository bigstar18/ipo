package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoPickup;
import java.util.List;

public interface IpoPickupMapper {
    int deleteByPrimaryKey(String pickupId);

    int insert(IpoPickup record);

    IpoPickup selectByPrimaryKey(String pickupId);

    List<IpoPickup> selectAll();

    int updateByPrimaryKey(IpoPickup record);
}