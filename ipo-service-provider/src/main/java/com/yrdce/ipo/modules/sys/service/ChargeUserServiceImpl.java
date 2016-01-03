package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoChargeUserMapper;
import com.yrdce.ipo.modules.sys.entity.IpoChargeUser;
import com.yrdce.ipo.modules.sys.vo.ChargeUser;
/**
 * 特殊费用配置 service impl
 * @author wq 2016-1-3
 *
 */
public class ChargeUserServiceImpl implements ChargeUserService {

	@Autowired
	private IpoChargeUserMapper chargeUserMapper;
	
	@Autowired
	private DataItemService dataItemService;
	
	/**
	 *  分页查询特殊费用配置
	 */
	public List<ChargeUser> queryForPage(String pageNo, String pageSize,
			ChargeUser chargeUser) {
		 
		int startIndex=PageUtil.getStartIndex(pageNo, pageSize); 
		int endIndex=PageUtil.getEndIndex(pageNo, pageSize);
		//业务常量
		Map<String,String> businessMap =dataItemService.queryForMap(ChargeConstant.BUSINESS);
		//角色常量
		Map<String,String> UserMap =dataItemService.queryForMap(ChargeConstant.ROLE);
		List<IpoChargeUser> dbList=chargeUserMapper.queryForPage(startIndex, endIndex, chargeUser);
		 
		List<ChargeUser> dataList=new ArrayList<ChargeUser>();
		for(IpoChargeUser item :dbList){
			ChargeUser entity=new ChargeUser();
			BeanUtils.copyProperties(item, entity);
			entity.setBusinessName(businessMap.get(item.getBusinessCode()));
			entity.setRoleCodeName(UserMap.get(item.getRoleCode()));
			entity.setChargePatternName(ChargeConstant.Pattern.getName(item.getChargePattern()));
			dataList.add(entity);
		};
		return dataList;
	}

	/**
	 * 查询特殊费用数量
	 */
	public long queryForCount(ChargeUser chargeUser) {
		return chargeUserMapper.queryForCount(chargeUser);
	}

	/**
	 * 添加特殊费用
	 */
	@Transactional
	public void save(ChargeUser chargeUser) {
		chargeUser.setCreateDate(new Date());
		chargeUserMapper.insert(chargeUser);
	}

	/**
	 * 查找特殊费用
	 */
	public ChargeUser findById(Long id) {
		IpoChargeUser dbChargeUser =chargeUserMapper.findById(id);
		ChargeUser entity=new ChargeUser();
		BeanUtils.copyProperties(dbChargeUser, entity);
		return entity;
	}

	/**
	 * 更新特殊费用
	 */
	@Transactional
	public void update(ChargeUser chargeUser) {
		chargeUser.setUpdateDate(new Date());
		chargeUserMapper.update(chargeUser);
	}

}
