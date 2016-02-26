package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.List;

import com.yrdce.ipo.modules.sys.vo.PublisherPosition;
import com.yrdce.ipo.modules.sys.vo.Specialcounterfee;

public interface PublisherPositionService {

	/**
	 * 分页查询转持仓信息
	 * 
	 * @param page
	 * @param rows
	 * @param example
	 * @return
	 */
	public List<PublisherPosition> getInfoByPage(String page, String rows,
			PublisherPosition example);

	/**
	 * 获取符合条件的转持仓记录数
	 * 
	 * @param example
	 */
	public Integer getPubPositionNum(PublisherPosition example);

	/**
	 * 新增一条转持仓信息
	 * 
	 * @param example
	 * @return
	 */
	public Integer insertPubPoition(PublisherPosition example);

	/**
	 * 获取已经转成功的发售总量
	 * 
	 * @param commodityid
	 * @return
	 */
	public Long getSaleCounts(String commodityid);

	/**
	 * 根据入库单找转持仓单，获取发行商代码和发行手续费
	 * 
	 * @param publisherid
	 * @param money
	 * @return
	 */
	public PublisherPosition getInfoByStorageId(String storageid);

	/**
	 * 冻结费用
	 * 
	 * @param publisherid
	 * @param money
	 * @return
	 */
	public String frozenFunds(String publisherid, BigDecimal money);

	/**
	 * 新增手续费流水
	 * 
	 * @param example
	 * @return
	 */
	public void insertPoundage(PublisherPosition example, BigDecimal funds);

	/**
	 * 新增货款流水
	 * 
	 * @param example
	 * @return
	 */
	public void insertLoan(PublisherPosition example, BigDecimal funds);

	/**
	 * 新增转持仓流水记录
	 * 
	 * @param example
	 * @return
	 */
	public void insertPositionFlow(PublisherPosition example);

	/**
	 * 更改状态
	 * 
	 * @param publisherid
	 * @param money
	 * @return
	 */
	public String updateStatus(PublisherPosition example);

	/**
	 * 转IPO持仓
	 * 
	 * @param publisherid
	 * @param money
	 * @return
	 */
	public String transferPosition(PublisherPosition example);

	/**
	 * 查找特殊手续费
	 * 
	 * @param publisherid
	 * @param money
	 * @return
	 */
	public Specialcounterfee getSpecialCounterfee(String publisherid,
			String commodityid, String counterfeetype);

}
