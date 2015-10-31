package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpoNumberofrecordsMapper {
    int countByExample(IpoNumberofrecordsExample example);

    int deleteByExample(IpoNumberofrecordsExample example);

    int insert(IpoNumberofrecords record);

    int insertSelective(IpoNumberofrecords record);

    List<IpoNumberofrecords> selectByExample(IpoNumberofrecordsExample example);

    int updateByExampleSelective(@Param("record") IpoNumberofrecords record, @Param("example") IpoNumberofrecordsExample example);

    int updateByExample(@Param("record") IpoNumberofrecords record, @Param("example") IpoNumberofrecordsExample example);
}