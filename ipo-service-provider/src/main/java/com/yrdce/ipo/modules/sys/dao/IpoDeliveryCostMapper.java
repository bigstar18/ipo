package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;
import java.util.List;

public interface IpoDeliveryCostMapper {
    int deleteByPrimaryKey(String deliveryId);

    int insert(IpoDeliveryCost record);

    IpoDeliveryCost selectByPrimaryKey(String deliveryId);

    List<IpoDeliveryCost> selectAll();

    int updateByPrimaryKey(IpoDeliveryCost record);
}