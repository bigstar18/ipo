package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoUnderWriters;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

@MyBatisDao
public interface IpoUnderwriterSubscribeMapper {
	int deleteByPrimaryKey(BigDecimal subscribeid);

	int insert(IpoUnderwriterSubscribe record);

	IpoUnderwriterSubscribe selectByPrimaryKey(BigDecimal subscribeid);

	IpoUnderwriterSubscribe selectByExample(@Param("record") UnderwriterSubscribe Subscribe);

	/**
	 * 查询某商品已被认购的数量
	 * 
	 * @param commodityId
	 * @return
	 */
	Long selectSubscibedCounts(@Param("commodityId") String commodityId);

	/**
	 * 查询某商品供承销商认购的总量
	 * 
	 * @param commodityId
	 * @return
	 */
	Long selectTotalCounts(@Param("commodityId") String commodityId);

	/**
	 * 获取已认购同一商品的承销商手续费比例总和
	 * 
	 * @param example
	 * @return
	 */
	Float checkRatioSum(@Param("commodityId") String commodityId);

	List<IpoUnderwriterSubscribe> selectAll();

	int updateByPrimaryKey(IpoUnderwriterSubscribe record);

	// 查询承销商认购资金明细
	List<IpoUnderwriterSubscribe> selectFunds(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("underwriterid") String underwriterid);

	// 查询承销商认购资金明细页数
	int selectPage(@Param("underwriterid") String underwriterid);

	// 查询承销设置信息
	List<IpoUnderwriterSubscribe> getInfosByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoUnderwriterSubscribe record);

	// 获取承销设置记录数
	int getQueryNum(@Param("record") IpoUnderwriterSubscribe record);

	// 查询发行商的承销会员
	List<IpoUnderWriters> getUnderwritersByPub(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoUnderWriters record);

	// 获取发行商的承销会员记录数
	int getUnderwritersNum(@Param("record") IpoUnderWriters record);

	// 查询承销商认购资金未处理的认购设置信息(除去正在处理的这条记录)
	List<IpoUnderwriterSubscribe> selectUnFrozeSetExcpt(@Param("brokerid") String brokerid,
			@Param("state") short state, @Param("subscribeid") long subscribeid);

	// 查询承销商认购资金未处理的认购设置信息
	List<IpoUnderwriterSubscribe> selectUnFrozeSet(@Param("brokerid") String brokerid,
			@Param("state") short state);

	// 根据承销会员编号和商品代码查询设置信息
	IpoUnderwriterSubscribe selectSetByBrokerIdAndCommId(@Param("brokerid") String brokerid,
			@Param("commodityid") String commodityid);

	/**
	 * @Title: findInfosByPage
	 * @Description: 承销会员查询
	 * @param beginnum
	 * @param endnum
	 * @param record
	 * @author bob
	 */
	List<IpoUnderwriterSubscribe> findInfosByPage(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum, @Param("record") IpoUnderwriterSubscribe record);

	// 获取承销设置记录数
	/**
	 * @Title: findQueryNum
	 * @Description: 承销会员查询
	 * @param record
	 * @author bob
	 */
	int findQueryNum(@Param("record") IpoUnderwriterSubscribe record);
}