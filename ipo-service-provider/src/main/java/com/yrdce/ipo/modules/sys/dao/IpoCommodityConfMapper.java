package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;

@MyBatisDao
public interface IpoCommodityConfMapper {

	List<IpoCommodityConf> findIpoCommConfByBreedid(@Param("breedid") Long breedid, @Param("beginnum") int beginnum, @Param("endnum") int endnum);// 分页获取对应商品

	int countByBreedid(@Param("breedid") Long breedid);// 获取品种对应商品总数

	IpoCommodityConf findIpoCommConfByCommid(@Param("commid") String commid);// 根据商品ID获取商品

	int insert(IpoCommodityConf record);

	int update(IpoCommodityConf record);

	int deleteByCommid(@Param("commid") String commid);// 根据商品ID删除商品

	int deleteByBreedid(@Param("breedid") Long breedid);// 根据品种ID删除对应商品

	List<String> findAllCommIds();

	List<IpoCommodityConf> findAllIpoCommConfsByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);// 分页获取所有商品

	int countAll();// 获取商品总数

	List<IpoCommodityConf> findAllIpoCommConfs();

	List<IpoCommodityConf> findAllIpoCommConfsByExample(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoCommodityConf example);// 根据条件分页获取所有商品

	int getNumsByExample(IpoCommodityConf example);// 根据条件获取商品总数

	List<DeliveryCommodity> findDeliveryCommoditys(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") DeliveryCommodity record);

	int getDeliveryCommNum(@Param("record") DeliveryCommodity record);

	int updateByStatus(@Param("status") int status, @Param("commodityid") String commodityid);

	int updateDeliveryProps(@Param("commId") String commId, @Param("option") Short option);// 设置交收属性

	List<IpoCommodityConf> selectCommodityByExample(@Param("record") IpoCommodityConf examples);

	// 查询单位名称
	IpoCommodityConf selectCommUnit(@Param("commodityid") String commodityid);

	// 查询待上市的商品
	List<IpoCommodityConf> queryListingCommodity(@Param("param") IpoCommodityConf example);

	// hxx 偷懒
	int querySubjectCommoCount(@Param("subject") String subject);

	// hxx
	int addFeeSubject(@Param("parentSubject") String parentSubject, @Param("commoId") String commoId);

}
