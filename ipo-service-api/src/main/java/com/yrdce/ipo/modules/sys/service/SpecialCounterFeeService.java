package com.yrdce.ipo.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.yrdce.ipo.modules.sys.vo.Specialcounterfee;

public interface SpecialCounterFeeService {
	public int insertSpecialcounterfeeInfo(Specialcounterfee specialcounterfee) throws Exception;

	public List<Specialcounterfee> getSpecialcounterfeeInfo(String page, String rows) throws Exception;

	public int getCounts(Specialcounterfee specialcounterfee);

	public int deleteInfoById(String id);

	public int isFirm(String firmid);

	public Specialcounterfee selectInfoById(String id) throws Exception;

	public int updateInfoById(Specialcounterfee specialcounterfee) throws Exception;

	public int selectCountsById(String id) throws Exception;

	// 获得商品名称以及商品代码
	public Map<String, String> getCommodityidByAll() throws Exception;
}
