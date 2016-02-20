package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.entity.BrBrokerExample;
import com.yrdce.ipo.modules.sys.entity.PublisherBalance;

@MyBatisDao
public interface BrBrokerMapper {
	int countByExample(BrBrokerExample example);

	int deleteByExample(BrBrokerExample example);

	int deleteByPrimaryKey(String brokerid);

	int insert(BrBroker record);

	int insertSelective(BrBroker record);

	List<BrBroker> selectByExampleWithBLOBs(BrBrokerExample example);

	List<BrBroker> selectByExample(BrBrokerExample example);

	BrBroker selectByPrimaryKey(String brokerid);

	int updateByExampleSelective(@Param("record") BrBroker record, @Param("example") BrBrokerExample example);

	int updateByExampleWithBLOBs(@Param("record") BrBroker record, @Param("example") BrBrokerExample example);

	int updateByExample(@Param("record") BrBroker record, @Param("example") BrBrokerExample example);

	int updateByPrimaryKeySelective(BrBroker record);

	int updateByPrimaryKeyWithBLOBs(BrBroker record);

	int updateByPrimaryKey(BrBroker record);

	List<BrBroker> findAllPublisher();// 获取所有发行会员

	BrBroker selectById(String brokerid);

	List<BrBroker> findAllUnderwriter();// 获取所有承销会员

	PublisherBalance findBalance(@Param("firmid") String firmid, @Param("today") String today,
			@Param("yesterday") String yesterday);// 获取某个发行商的当前和上日余额

	/**
	 * @Title: findAllBrokerageMember
	 * @Description: 查询经纪会员信息
	 */
	List<BrBroker> findAllBrokerageMember();

	/**
	 * @Title: findMemberTrader
	 * @Description: 获取经纪会员以及下属交易商
	 */
	List<BrBroker> findMemberTrader();

	/**
	 * @Title: findTraderByBrokerid
	 * @Description: 通过会员id查找下属交易商
	 * @param brokerid
	 */
	List<BrBroker> findTraderByBrokerid(String brokerid);
}
