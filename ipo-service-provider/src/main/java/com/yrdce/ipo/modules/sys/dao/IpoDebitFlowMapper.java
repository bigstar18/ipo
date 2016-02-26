package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDebitFlow;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;

/**
 * 扣款流水记录
 * 
 * @author wq 2016-1-17
 *
 */
@MyBatisDao
public interface IpoDebitFlowMapper {

	/**
	 * 新增
	 * 
	 * @param debitFlow
	 */
	public void insert(DebitFlow debitFlow);

	/**
	 * 查询
	 * 
	 * @param debitFlow
	 * @return
	 */
	public List<IpoDebitFlow> queryForList(@Param("param") DebitFlow debitFlow);

	/**
	 * 更新状态
	 * 
	 * @param debitFlow
	 */
	public void updateState(DebitFlow debitFlow);

	/**
	 * 分页查询费用
	 * 
	 * @param debitFlow
	 * @return
	 */
	public List<IpoDebitFlow> queryForPage(@Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("param") DebitFlow debitFlow);

	/**
	 * 查询费用数量
	 * 
	 * @param debitFlow
	 * @return
	 */
	public long queryForCount(@Param("param") DebitFlow debitFlow);

	/**
	 * @Title: select
	 * @Description: 根据业务类型，费用类型以及用户查询
	 * @param businessType
	 * @param chargeType
	 * @param payer
	 * @return 参数说明
	 */
	public List<IpoDebitFlow> selectInfo(@Param("businessType") String businessType,
			@Param("chargeType") String chargeType, @Param("payer") String payer);

	public IpoDebitFlow findInfo(@Param("param") DebitFlow debitFlow);

}
