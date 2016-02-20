package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionExample;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionExtended;

@MyBatisDao
public interface IpoDistributionMapper {
	int countByExample(@Param("userid") String userid, @Param("ptime") String ptime);

	int deleteByExample(IpoDistributionExample example);

	int deleteByPrimaryKey(int id);

	int insert(IpoDistribution record);

	int insertSelective(IpoDistribution record);

	List<IpoDistribution> selectByExampleWithBLOBs(IpoDistributionExample example);

	List<IpoDistribution> selectByExample(IpoDistributionExample example);

	List<IpoDistribution> selectAll();

	List<IpoDistributionExtended> getAllByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("userid") String userid, @Param("ptime") String ptime);// 分页获取配号信息

	// 分页获取配号表
	List<IpoDistribution> selectByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	IpoDistribution selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") IpoDistribution record,
			@Param("example") IpoDistributionExample example);

	int updateByExampleWithBLOBs(@Param("record") IpoDistribution record,
			@Param("example") IpoDistributionExample example);

	int updateByExample(@Param("record") IpoDistribution record,
			@Param("example") IpoDistributionExample example);

	int updateByPrimaryKeySelective(IpoDistribution record);

	int updateByPrimaryKeyWithBLOBs(IpoDistribution record);

	int updateByPrimaryKey(IpoDistribution record);

	void updateBycomAndUserid(IpoDistribution record);

	List<IpoDistribution> selectByTime(String date);

	int selectByCount();

	List<IpoDistribution> selectByCommId(String commId);

	List<IpoDistribution> allByTime(String date);

	// 根据货款冻结情况查询信息 li
	List<IpoDistribution> getInfobyDate(@Param("ptime") String ptime);

	// 修改申购资金状态以及资金信息
	int setSomeInfo(IpoDistribution distribution);

	// hxx
	List<IpoDistribution> queryUnsettledByCommoId(@Param("commodityid") String commodityid);

	int updateSettledById(int id);

	int ballotCounts(String userid, String ptime);

	/**
	 * @Title: findByfirmidAndDate
	 * @Description: 通过用户id和时间查询
	 * @param userid
	 * @param startdate
	 * @param enddate
	 */
	List<IpoDistribution> findByfirmidAndDate(@Param("userid") String userid,
			@Param("startdate") String startdate, @Param("enddate") String enddate);

}