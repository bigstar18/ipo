package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;

@MyBatisDao
public interface IpoSpoRationMapper {
	int deleteByPrimaryKey(Long rationid);

	int insert(IpoSpoRation record);

	IpoSpoRation selectByPrimaryKey(Long rationid);

	List<IpoSpoRation> selectAll();

	int updateByPrimaryKey(IpoSpoRation record);

	List<IpoSpoRation> selectBySPOid(String spoid);

	List<IpoSpoRation> selectSPOAndRa(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("IpoSpoComm") IpoSpoCommoditymanmaagement ipospocomm);

	int counts(@Param("IpoSpoComm") IpoSpoCommoditymanmaagement ipospocomm);

	int getRationInfoCounts(@Param("IpoSpoComm") IpoSpoCommoditymanmaagement ipospocomm);
	
	int updateRationType(Long rationId);

	List<IpoSpoRation> getMyRationInfo(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("IpoSpoComm") IpoSpoCommoditymanmaagement ipospocomm);

	int updateByStatus(int status, String spoid);

}