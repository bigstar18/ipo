package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoChargeItemMapper;
import com.yrdce.ipo.modules.sys.entity.IpoChargeItem;
import com.yrdce.ipo.modules.sys.vo.ChargeItem;

/**
 * 费用项 service impl
 * 
 * @author wq 2016-1-1
 * 
 */
public class ChargeItemServiceImpl implements ChargeItemService {

	@Autowired
	private IpoChargeItemMapper   chargeItemMapper;
	

	/**
	 * 分页查询下级费用配置
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param chargeItem
	 * @return
	 */
	public List<ChargeItem> querySubLevelForPage(String pageNo,
			String pageSize, ChargeItem chargeItem) {

		int startIndex=PageUtil.getStartIndex(pageNo,pageSize); 
		int endIndex=PageUtil.getEndIndex(pageNo, pageSize);
		List<IpoChargeItem> dbList=chargeItemMapper.querySubLevelForPage(startIndex,endIndex,chargeItem);
		List<ChargeItem> dataList=new ArrayList<ChargeItem>();
		for(IpoChargeItem item :dbList){
			ChargeItem entity=new ChargeItem();
			BeanUtils.copyProperties(item, entity);
			entity.setTypeName(ChargeConstant.Type.getName(item.getType()));
			dataList.add(entity);
		};
		return dataList;
	}

	/**
	 * 分页查询下级费用配置数量
	 * 
	 * @param chargeItem
	 * @return
	 */
	public long querySubLevelForCount(ChargeItem chargeItem) {
		return chargeItemMapper.querySubLevelForCount(chargeItem);
	}

	/**
	 * 分页查询所有子费用配置
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param chargeItem
	 * @return
	 */
	public List<ChargeItem> queryChildLevelForPage(String pageNo,
			String pageSize, ChargeItem chargeItem) {
		
		int startIndex=PageUtil.getStartIndex(pageNo,pageSize); 
		int endIndex=PageUtil.getEndIndex(pageNo, pageSize);
		List<IpoChargeItem> dbList=chargeItemMapper.queryChildLevelForPage(startIndex,endIndex,chargeItem);
		List<ChargeItem> dataList=new ArrayList<ChargeItem>();
		for(IpoChargeItem item :dbList){
			ChargeItem entity=new ChargeItem();
			BeanUtils.copyProperties(item, entity);
			entity.setTypeName(ChargeConstant.Type.getName(item.getType()));
			dataList.add(entity);
		};
		return dataList;
	}

	/**
	 * 分页查询所有子费用配置数量
	 * 
	 * @param chargeItem
	 * @return
	 */
	public long queryChildLevelForCount(ChargeItem chargeItem) {
		return chargeItemMapper.queryChildLevelForCount(chargeItem);
	}
	
	
	/**
	 * 查询所有的叶子节点
	 * @return
	 */
	public List<ChargeItem> queryLeafForList() {
		List<IpoChargeItem> dbList=chargeItemMapper.queryLeafForList();
		List<ChargeItem> dataList=new ArrayList<ChargeItem>();
		for(IpoChargeItem item :dbList){
			ChargeItem entity=new ChargeItem();
			BeanUtils.copyProperties(item, entity);
			entity.setTypeName(ChargeConstant.Type.getName(item.getType()));
			dataList.add(entity);
		};
		return dataList;
	}
	
	
	/**
	 * 添加费用
	 */
	@Transactional
	public void save(ChargeItem chargeItem) {
		 String id=generateId(chargeItem);
		 chargeItem.setId(id);
		 chargeItem.setLeaf(true);
		 chargeItem.setCreateDate(new Date());
		 chargeItemMapper.insert(chargeItem);
		 // 更新父节点为非叶子节点
		 ChargeItem parent=new ChargeItem();
		 parent.setId(chargeItem.getParentId());
		 parent.setLeaf(false);
		 parent.setUpdateDate(new Date());
		 parent.setUpdateUser(chargeItem.getCreateUser());
		 chargeItemMapper.updateLeaf(parent);
	}
	
	/**
	 * 更新费用
	 */
	@Transactional
	public void update(ChargeItem chargeItem) {
		 chargeItem.setUpdateDate(new Date());
		 chargeItemMapper.update(chargeItem);
	}
	
	
	/**
	 * 查询费用配置 
	 */
	public List<ChargeItem> queryForList(ChargeItem chargeItem) {
		 
		List<IpoChargeItem> dbList=chargeItemMapper.queryForList(chargeItem);
		List<ChargeItem> dataList=new ArrayList<ChargeItem>();
		for(IpoChargeItem item :dbList){
			ChargeItem entity=new ChargeItem();
			BeanUtils.copyProperties(item, entity);
			entity.setTypeName(ChargeConstant.Type.getName(item.getType()));
			dataList.add(entity);
		};
		return dataList;
	}
	 
	/**
	 * 查找费用
	 */
	public ChargeItem findById(String id) {
		IpoChargeItem item=chargeItemMapper.findById(id);
		ChargeItem entity=new ChargeItem();
		BeanUtils.copyProperties(item, entity);
		entity.setTypeName(ChargeConstant.Type.getName(item.getType()));
		return entity;
	}
	
	
	/**
	 * 删除费用项
	 */
	@Transactional
	public void delete(ChargeItem chargeItem) {
		chargeItem.setUpdateDate(new Date());
		chargeItemMapper.deleteById(chargeItem);
		
	}
	
	
	
	/**
	 * id 生成策略
	 * @return
	 */
	public synchronized String  generateId(ChargeItem chargeItem){
		String maxId=chargeItemMapper.getMaxId(chargeItem);
		if(maxId!=null&&!"".equals(maxId)){
			String prefix=maxId.substring(0,maxId.length()-3);
			String suffix=maxId.substring(maxId.length()-3);
			suffix=String.format("%03d",Integer.parseInt(suffix)+1);
			return prefix+suffix;
		}
		//如果是一级费用
		if(chargeItem.TOP_LEVEL_ID.equals(chargeItem.getParentId())){
			return "001";
		};
		// 子级费用
		return chargeItem.getParentId()+"001";
	}
	
	
	
	 
	
	
}
