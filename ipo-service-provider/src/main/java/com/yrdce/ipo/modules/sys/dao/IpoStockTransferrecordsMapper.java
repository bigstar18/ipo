package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPubpaymentTrack;
import com.yrdce.ipo.modules.sys.entity.IpoStockTransferrecords;
import com.yrdce.ipo.modules.sys.vo.ChargeRole;
import com.yrdce.ipo.modules.sys.vo.StockTransferrecords;

@MyBatisDao
public interface IpoStockTransferrecordsMapper {
    int insert(StockTransferrecords stockTransferrecords);

    List<IpoStockTransferrecords> selectAll();
    
    int insert(IpoStockTransferrecords record);
    
    List<IpoStockTransferrecords> findStockTransferrecords(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoStockTransferrecords record);
    
    int getStockCommNum(@Param("record") IpoStockTransferrecords record);

	int  selectByapplicationId(BigDecimal applicationId);

	int updateByapplicationId(IpoStockTransferrecords example);

	public IpoStockTransferrecords findById(Long applicationIds);

	
	public void update(@Param("param")StockTransferrecords stockTransferrecords);


}