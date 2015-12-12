package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExtended;

@MyBatisDao
public interface IpoCommodityMapper {
	int countByExample(IpoCommodityExample example);

	int deleteByExample(IpoCommodityExample example);

	int deleteByPrimaryKey(int id);

	int insert(IpoCommodity record);

	int update(IpoCommodity record);

	int insertSelective(IpoCommodity record);

	List<IpoCommodity> selectByExample(IpoCommodityExample example);

	List<IpoCommodity> queryByConditions(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum, @Param("record") IpoCommodity record);

	List<IpoCommodity> queryByConditionsfront(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum, @Param("record") IpoCommodity record);

	int countByConditions(IpoCommodity record);

	int countByConditionsfront(IpoCommodity record);

	List<IpoCommodity> selectAll();

	List<IpoCommodity> getAllByPage(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum);// 分页获取发售商品

	IpoCommodity selectByPrimaryKey(int id);

	IpoCommodity selectByComid(@Param("comid") String comid); // 根据商品ID获取商品信息

	int updateByExampleSelective(@Param("record") IpoCommodity record,
			@Param("example") IpoCommodityExample example);

	int updateByExample(@Param("record") IpoCommodity record,
			@Param("example") IpoCommodityExample example);

	int updateByPrimaryKeySelective(IpoCommodity record);

	int updateByPrimaryKey(IpoCommodity record);

	List<IpoCommodity> selectByTime(String date);

	List<IpoCommodity> selectByEnd(String enddate);

	List<IpoCommodityExtended> selectByCommodityAndOrder(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getCounts();

	int getCountsByPage(String commodityid);

	void updateByStatus(@Param("status") int status,
			@Param("commodityid") String commodityid);


	List<IpoCommodityExtended> getAllBycommodityid(
			@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("commodityid") String commodityid);
	

	int selectByCommodityid(String commodityid);
}
