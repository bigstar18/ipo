package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.VFFirmcurfunds;
import java.util.List;

public interface VFFirmcurfundsMapper {
    int insert(VFFirmcurfunds record);

    List<VFFirmcurfunds> selectAll();
}