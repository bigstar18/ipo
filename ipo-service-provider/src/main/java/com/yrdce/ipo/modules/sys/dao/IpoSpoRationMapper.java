package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
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

	String firmidBySales(@Param("brokerid") String brokerid);

	// 根据交易商id查找交易商名称
	String selectFirmname(String firmid);

	// 增发id查询配售信息
	List<IpoSpoRation> selectInfoBySPOid(String spoid);

	// 根据id查询信息（关联增发价格）
	IpoSpoRation select(Long rationid);

	// 更新服务费
	int updateServicefee(@Param("servicefee") BigDecimal servicefee, @Param("rationId") long rationId);

	/**
	 * @Title: findFirm
	 * @Description: 定向配售是否有此会员
	 * @param spoid
	 * @param brokerid
	 * @return 参数说明
	 */
	IpoSpoRation findFirm(@Param("spoid") String spoid, @Param("brokerid") String brokerid);

	/**
	 * @Title: updateCounts
	 * @Description: 更新配售数量
	 * @param rationCounts
	 * @param rationid
	 * @return 参数说明
	 */
	int updateCounts(@Param("rationCounts") long rationCounts, @Param("rationloan") BigDecimal rationloan,
			@Param("servicefee") BigDecimal servicefee, @Param("rationSate") int rationSate,
			@Param("rationId") long rationid);

	/**
	 * @Title: findRationInfo
	 * @Description: 客户端确认配售列表
	 * @param beginnum
	 * @param endnum
	 * @param ipospocomm
	 */
	List<IpoSpoRation> findRationInfo(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("IpoSpoComm") IpoSpoCommoditymanmaagement ipospocomm);

	/**
	 * @Title: findRationInfoCounts
	 * @Description: 客户端确认配售列表条数
	 */
	int findRationInfoCounts(@Param("IpoSpoComm") IpoSpoCommoditymanmaagement ipospocomm);

}