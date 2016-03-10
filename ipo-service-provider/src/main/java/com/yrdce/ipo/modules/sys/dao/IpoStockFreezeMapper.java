package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoStockFreeze;
import com.yrdce.ipo.modules.sys.vo.StockFreeze;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface IpoStockFreezeMapper {
    int insert(IpoStockFreeze record);
//    List<IpoStockTransferrecords> selectAll();
//    
//    int insert(IpoStockTransferrecords record);
//    
    List<IpoStockFreeze> findfreezerecords(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoStockFreeze record);
    
//    int getStockCommNum(@Param("record") IpoStockTransferrecords record);
//
//	int  selectByapplicationId(BigDecimal applicationId);
//
//	int updateByapplicationId(IpoStockTransferrecords example);
//
	public IpoStockFreeze findById(Long applicationIds);
//
//	
	public void update(@Param("param")StockFreeze stockFreeze);
    List<IpoStockFreeze> selectAll();


	Integer getStockCommNum(IpoStockFreeze record);
	

}