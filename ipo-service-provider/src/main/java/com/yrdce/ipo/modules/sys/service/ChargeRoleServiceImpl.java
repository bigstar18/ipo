package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoChargeRoleMapper;
import com.yrdce.ipo.modules.sys.entity.IpoChargeRole;
import com.yrdce.ipo.modules.sys.vo.ChargeRole;
/**
 * 一般费用配置 service impl
 * @author wq 2016-1-3
 *
 */
public class ChargeRoleServiceImpl implements ChargeRoleService {

	@Autowired
	private IpoChargeRoleMapper chargeRoleMapper;
	
	 
	/**
	 *  分页查询一般费用配置
	 */
	public List<ChargeRole> queryForPage(String pageNo, String pageSize,
			ChargeRole chargeRole) {
		 
		int startIndex=PageUtil.getStartIndex(pageNo, pageSize); 
		int endIndex=PageUtil.getEndIndex(pageNo, pageSize);
		 
		List<IpoChargeRole> dbList=chargeRoleMapper.queryForPage(startIndex,endIndex,chargeRole);
		List<ChargeRole> dataList=new ArrayList<ChargeRole>();
		for(IpoChargeRole item :dbList){
			ChargeRole entity=new ChargeRole();
			BeanUtils.copyProperties(item, entity);
			entity.setBusinessName(ChargeConstant.BusinessType.getName(item.getBusinessCode()));
			entity.setRoleCodeName(ChargeConstant.RoleType.getName(item.getRoleCode()));
			entity.setChargePatternName(ChargeConstant.Pattern.getName(item.getChargePattern()));
			dataList.add(entity);
		};
		return dataList;
	}

	/**
	 * 查询一般费用数量
	 */
	public long queryForCount(ChargeRole chargeRole) {
		return chargeRoleMapper.queryForCount(chargeRole);
	}

	/**
	 * 添加一般费用
	 */
	@Transactional
	public void save(ChargeRole chargeRole) {
		chargeRole.setCreateDate(new Date());
		chargeRoleMapper.insert(chargeRole);
	}

	/**
	 * 查找一般费用
	 */
	public ChargeRole findById(Long id) {
		IpoChargeRole dbChargeRole =chargeRoleMapper.findById(id);
		ChargeRole entity=new ChargeRole();
		BeanUtils.copyProperties(dbChargeRole, entity);
		return entity;
	}

	/**
	 * 更新一般费用
	 */
	@Transactional
	public void update(ChargeRole chargeRole) {
		chargeRole.setUpdateDate(new Date());
		chargeRoleMapper.update(chargeRole);
	}

}
