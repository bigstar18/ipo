package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Specialcounterfee;

public interface SpecialCounterFeeService {
	public int insertSpecialcounterfeeInfo(Specialcounterfee specialcounterfee) throws Exception;

	public List<Specialcounterfee> getSpecialcounterfeeInfo(String page, String rows) throws Exception;

	public int getCounts();

	public int deleteInfoById(String id);

	public int isFirm(String firmid);

	public Specialcounterfee selectInfoById(String id) throws Exception;

	public int updateInfoById(Specialcounterfee specialcounterfee) throws Exception;
}
