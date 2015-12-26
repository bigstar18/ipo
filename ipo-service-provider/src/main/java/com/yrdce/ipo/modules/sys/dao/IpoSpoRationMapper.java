package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;

@MyBatisDao
public interface IpoSpoRationMapper {
	int deleteByPrimaryKey(Long rationid);

	int insert(IpoSpoRation record);

	IpoSpoRation selectByPrimaryKey(Long rationid);

	List<IpoSpoRation> selectAll(int beginnum, int endnum, @Param("SpoComm") SpoCommoditymanmaagement spocomm);

	int updateByPrimaryKey(IpoSpoRation record);

	List<IpoSpoRation> selectBySPOid(String spoid);
}