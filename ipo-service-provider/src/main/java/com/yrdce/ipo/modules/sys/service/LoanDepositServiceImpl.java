package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.VFFirmcurfundsMapper;
import com.yrdce.ipo.modules.sys.entity.VFFirmcurfunds;
import com.yrdce.ipo.modules.sys.vo.Firmcurfunds;

/*
 * 有关ipo中承销会员资金服务
 * 李伟东
 * */

@Service("loanDepositService")
public class LoanDepositServiceImpl implements LoanDepositService  {
	@Autowired
	private VFFirmcurfundsMapper firmcurfundsMapper;
	public VFFirmcurfundsMapper getFirmcurfundsMapper(){
		return firmcurfundsMapper;
	}
	public void setFirmcurfundsMapper(VFFirmcurfundsMapper firmcurfundsMapper){
		this.firmcurfundsMapper = firmcurfundsMapper;
	}
	@Override
	public List<Firmcurfunds> GetAllInfo() {
		// TODO Auto-generated method stub
		List<VFFirmcurfunds> firmcurfounds =   firmcurfundsMapper.selectAll();		
		List<Firmcurfunds> tempList = new ArrayList<Firmcurfunds>();
		for(VFFirmcurfunds tempFinds:firmcurfounds){
			Firmcurfunds funds = new Firmcurfunds();
			BeanUtils.copyProperties(tempFinds, funds);
			tempList.add(funds);
		}
		return tempList;
	}
	@Override
	public List<Firmcurfunds> GetInfoByName(String name) {
		List<VFFirmcurfunds> firmcurfounds =   firmcurfundsMapper.selectInfoByName(name);		
		List<Firmcurfunds> tempList = new ArrayList<Firmcurfunds>();
		for(VFFirmcurfunds tempFinds:firmcurfounds){
			Firmcurfunds funds = new Firmcurfunds();
			BeanUtils.copyProperties(tempFinds, funds);
			tempList.add(funds);
		}
		return tempList;
	}
	

}
