package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import java.util.List;

public interface IpoDeliveryorderMapper {
    int deleteByPrimaryKey(String deliveryorderId);

    int insert(IpoDeliveryorder record);

    IpoDeliveryorder selectByPrimaryKey(String deliveryorderId);

    List<IpoDeliveryorder> selectAll();

    int updateByPrimaryKey(IpoDeliveryorder record);
}