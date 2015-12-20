package com.yrdce.ipo.modules.sys.dao.warehouse;

import com.yrdce.ipo.modules.sys.entity.warehouse.IpoOutbound;
import java.util.List;

public interface IpoOutboundMapper {
    int deleteByPrimaryKey(String outboundorderid);

    int insert(IpoOutbound record);

    IpoOutbound selectByPrimaryKey(String outboundorderid);

    List<IpoOutbound> selectAll();

    int updateByPrimaryKey(IpoOutbound record);
}