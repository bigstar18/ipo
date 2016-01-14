package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPubpaymentTrack;

@MyBatisDao
public interface IpoPubpaymentTrackMapper {
	int deleteByPrimaryKey(Long trackid);

	int insert(IpoPubpaymentTrack record);

	IpoPubpaymentTrack selectByPrimaryKey(Long trackid);

	List<IpoPubpaymentTrack> selectAll();

	int updateByPrimaryKey(IpoPubpaymentTrack record);

	List<IpoPubpaymentTrack> selectByPage(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum,
			@Param("record") IpoPubpaymentTrack record);

	int getTarckNum(@Param("record") IpoPubpaymentTrack record);
}