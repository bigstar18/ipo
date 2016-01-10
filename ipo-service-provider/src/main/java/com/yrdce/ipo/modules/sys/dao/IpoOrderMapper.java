package com.yrdce.ipo.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.IpoOrderExample;

@MyBatisDao
public interface IpoOrderMapper {
	int countByExample(@Param("userid") String userid);

	int deleteByExample(IpoOrderExample example);

	int deleteByPrimaryKey(String orderid);

	int insert(IpoOrder record);

	int insertSelective(IpoOrder record);

	List<IpoOrder> selectByExample(IpoOrderExample example);

	IpoOrder selectFirst();

	IpoOrder selectByid(@Param("userid") String userid, @Param("commodityid") String sid);

	int updateByExampleSelective(@Param("record") IpoOrder record, @Param("example") IpoOrderExample example);

	int updateByExample(@Param("record") IpoOrder record, @Param("example") IpoOrderExample example);

	int updateByPrimaryKeySelective(IpoOrder record);

	int updateByPrimaryKey(IpoOrder record);

	int bycommodityid(String sid);

	List<IpoOrder> selectAll(String date);

	List<String> select(String commodityid);

	void insertAll();

	void deleteAll();

	int selectbysid(String commodityid);

	IpoOrder selectByPrimaryKey(@Param("orderid") String orderid);

	List<IpoOrder> selectByUserId(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("userid") String userid);

	List<IpoOrder> selectByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int selectByCounts(String userid);

	List<IpoOrder> selectByCid(String commodityid);

	int ipoCommSum(Map<String, String> map);

	long sequence();

	List<IpoOrder> selectByCidPaged(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("commodityid") String commodityid);

	int updateByOrderId(@Param("frozenst") int frozenst, @Param("orderid") String sid);

	IpoOrder selectCounterFeeInfo(@Param("commodityid") String commodityid);// 查询发售时的手续费信息
}