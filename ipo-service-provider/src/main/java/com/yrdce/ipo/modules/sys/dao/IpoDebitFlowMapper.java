package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDebitFlow;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
/**
 * 扣款流水记录
 * @author wq 2016-1-17
 *
 */
@MyBatisDao
public interface IpoDebitFlowMapper {

	/**
	 * 新增
	 * @param debitFlow
	 */
	public void insert(DebitFlow debitFlow); 
	
	/**
	 * 查询
	 * @param debitFlow
	 * @return
	 */
	public List<IpoDebitFlow> queryForList(@Param("param")DebitFlow debitFlow);
	
	/**
	 * 更新状态
	 * @param debitFlow
	 */
	public void updateState(DebitFlow debitFlow);
	
	
}
