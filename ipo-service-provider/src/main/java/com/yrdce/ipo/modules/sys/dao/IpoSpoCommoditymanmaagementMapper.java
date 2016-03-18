package com.yrdce.ipo.modules.sys.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;

@MyBatisDao
public interface IpoSpoCommoditymanmaagementMapper {
	int deleteByPrimaryKey(String spoId);

	int insert(IpoSpoCommoditymanmaagement record);

	IpoSpoCommoditymanmaagement selectByPrimaryKey(String spoId);

	List<IpoSpoCommoditymanmaagement> selectAll(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("Spo") IpoSpoCommoditymanmaagement spoComm);

	int updateByPrimaryKey(IpoSpoCommoditymanmaagement record);

	int counts(@Param("Spo") IpoSpoCommoditymanmaagement spoComm);

	int updateByStatus(@Param("sposate") int sposate, @Param("spoid") String spoid);

	int updateByComm(IpoSpoCommoditymanmaagement record);

	List<IpoSpoCommoditymanmaagement> select(@Param("rationtype") String rationtype,
			@Param("ipoDate") Date ipoDate, @Param("spoSate") Integer spoSate);

	int updatePlscingNum(@Param("successRationCounts") long success, @Param("notRationCounts") long balance,
			@Param("spoId") String spoid);

	List<IpoSpoCommoditymanmaagement> findByDate(@Param("rationtype") String rationtype,
			@Param("ipoDate") Date ipoDate);

	/**
	 * @Title: updateForListed
	 * @Description: 更新上市状态
	 * @param listed
	 * @param spoid
	 */
	int updateForListed(@Param("listed") int listed, @Param("spoid") String spoid);

	/**
	 * @Title: findSuccess
	 * @Description: 根据增发状态查询
	 * @param spoSate
	 * @return 参数说明
	 */
	List<IpoSpoCommoditymanmaagement> findBySpoDate(Integer spoSate);
}