package com.yrdce.ipo.modules.warehouse.service;

import java.util.Date;
import java.util.List;

import com.yrdce.ipo.modules.sys.vo.VIpoStorageExtended;
import com.yrdce.ipo.modules.warehouse.vo.IpoStorageVo;
import com.yrdce.ipo.modules.warehouse.vo.StorageUnionVo;

public interface IpoStorageService {
	
	//根据入库单号删除记录，并返回删除的记录条数
	int deleteByPrimaryKey(String storageid);

	//插入指定的对象
    int insert(IpoStorageVo record);

    //根据入库单号查询对象，并返回这个对象
    IpoStorageVo selectByPrimaryKey(String storageid);

    //根据商品代码查询对象，并返回这个对象
    IpoStorageVo selectByCommodityId(String commodityid);
    
    //根据入库时间查询对象，并返回这个对象
    IpoStorageVo selectByStorageDate(Date storagedate);
    
    //根据入库状态查询对象，并返回这个对象
    IpoStorageVo selectByStorageState(int storagestate);
    
    //查询所有的对象记录，并返回该对象的List集合
    List<IpoStorageVo> selectAll();

    //更新指定的对象，并返回更新的记录数
    int updateByPrimaryKey(IpoStorageVo record);
    
    //入库申请列表页的查询
    List<StorageUnionVo> queryVos(Integer beginnum, Integer endnum, StorageUnionVo storageUnionVo);
    
    //入库申请总记录条数
    int countStorage();
    
 // 分页查询入库单
 	List<VIpoStorageExtended> selectByPage(String page, String rows,
 			VIpoStorageExtended storage);

 	// 获取查询的总入库单数
 	Integer getTotalNum(VIpoStorageExtended storage);

 	// 审核入库单
 	Integer checkStorage(String storageId, String result, String checker);
 	
 	//根据入库单号查询对象
 	StorageUnionVo selectUnionById(String storageid);
}
