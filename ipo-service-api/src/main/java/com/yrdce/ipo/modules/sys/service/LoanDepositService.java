package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Firmcurfunds;

/*
 *承销会员服务接口
 *李伟东
 *2015.12.14 
 **/
public interface LoanDepositService {
	public List<Firmcurfunds> GetAllInfo();//获取表内所有信息
	public List<Firmcurfunds> GetInfoByName(String name);//根据畅销会员名称查信息
}
