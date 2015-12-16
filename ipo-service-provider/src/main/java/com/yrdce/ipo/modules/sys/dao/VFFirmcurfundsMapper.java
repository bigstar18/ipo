package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.VFFirmcurfunds;
import java.util.List;
@MyBatisDao
public interface VFFirmcurfundsMapper {
    int insert(VFFirmcurfunds record);

    List<VFFirmcurfunds> selectAll();
    List<VFFirmcurfunds> selectInfoByName(String name);
    List<VFFirmcurfunds> getInfoByType(int memberType);
}