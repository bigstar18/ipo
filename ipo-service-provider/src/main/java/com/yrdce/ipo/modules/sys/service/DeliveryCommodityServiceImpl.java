package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryPropMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryProp;
import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.vo.MProperty;

@Service
public class DeliveryCommodityServiceImpl implements DeliveryCommodityService {

	@Autowired
	private IpoCommodityConfMapper commconfmapper;

	@Autowired
	private IpoDeliveryPropMapper deliverypropmapper;

	public IpoCommodityConfMapper getCommconfmapper() {
		return commconfmapper;
	}

	public void setCommconfmapper(IpoCommodityConfMapper commconfmapper) {
		this.commconfmapper = commconfmapper;
	}

	@Override
	public List<DeliveryCommodity> findDeliveryCommoditys(String page,
			String rows, DeliveryCommodity example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		com.yrdce.ipo.modules.sys.entity.DeliveryCommodity record = new com.yrdce.ipo.modules.sys.entity.DeliveryCommodity();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		List<com.yrdce.ipo.modules.sys.entity.DeliveryCommodity> dclist = commconfmapper
				.findDeliveryCommoditys(startIndex, endIndex, record);
		List<DeliveryCommodity> dclist2 = new ArrayList<DeliveryCommodity>();
		for (com.yrdce.ipo.modules.sys.entity.DeliveryCommodity temp : dclist) {
			DeliveryCommodity deliveryComm = new DeliveryCommodity();
			BeanUtils.copyProperties(temp, deliveryComm);
			dclist2.add(deliveryComm);
		}
		return dclist2;
	}

	@Override
	public Integer getNums(DeliveryCommodity example) {
		com.yrdce.ipo.modules.sys.entity.DeliveryCommodity record = new com.yrdce.ipo.modules.sys.entity.DeliveryCommodity();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		return commconfmapper.getDeliveryCommNum(record);
	}

	@Override
	public List<MProperty> getPropsByCategoryId(Long categoryId) {
		List<com.yrdce.ipo.modules.sys.entity.MProperty> mlist = deliverypropmapper
				.selectCategoryProps(categoryId);
		List<MProperty> mlist2 = new ArrayList<MProperty>();
		for (com.yrdce.ipo.modules.sys.entity.MProperty temp : mlist) {
			MProperty mprop = new MProperty();
			BeanUtils.copyProperties(temp, mprop);
			mlist2.add(mprop);
		}
		return mlist2;
	}

	@Override
	public List<MProperty> getPropertyValues(Long categoryId, Long breedId) {
		List<com.yrdce.ipo.modules.sys.entity.MProperty> mlist = deliverypropmapper
				.selectPropValues(categoryId, breedId);
		List<MProperty> mlist2 = new ArrayList<MProperty>();
		for (com.yrdce.ipo.modules.sys.entity.MProperty temp : mlist) {
			MProperty mprop = new MProperty();
			BeanUtils.copyProperties(temp, mprop);
			mlist2.add(mprop);
		}
		return mlist2;
	}

	@Override
	@Transactional
	public String setDeliveryProps(String commId, String propertys) {
		IpoDeliveryProp example = new IpoDeliveryProp();
		example.setCommodityid(commId);
		if (propertys.equals("")) {
			return "false";
		}
		deliverypropmapper.deleteByCommodityId(commId);
		String[] props = propertys.split(",");
		for (int i = 0; i < props.length; i++) {
			String temp = props[i];
			String[] info = temp.split(":");
			Long propertyId = Long.parseLong(info[0]);
			Long sortno = Long.parseLong(info[1]);
			example.setPropertyid(propertyId);
			example.setSortno(sortno);
			deliverypropmapper.insert(example);
			commconfmapper.updateDeliveryProps(commId, (short) 1);// 1表示已设置交收属性
		}
		return "true";
	}

	@Override
	@Transactional
	public String deleteDeliveryProps(String commId) {
		if (commId != null) {
			if (!commId.equals("")) {
				commconfmapper.updateDeliveryProps(commId, (short) 2);// 2表示未设置交收属性
				deliverypropmapper.deleteByCommodityId(commId);
				return "true";
			}
		}
		return "false";
	}

	@Override
	public List<com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp> selectByCommodityId(
			String commId) {
		List<IpoDeliveryProp> dlist = deliverypropmapper
				.selectByCommodityId(commId);
		List<com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp> dlist2 = new ArrayList<com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp>();
		for (IpoDeliveryProp temp : dlist) {
			com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp example = new com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp();
			BeanUtils.copyProperties(temp, example);
			dlist2.add(example);
		}
		return dlist2;
	}

}
