package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoUnderwriterSubscribeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoUnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

@Service
public class UnderwriterSubscribeServiceImpl implements
		UnderwriterSubscribeService {
	@Autowired
	private IpoUnderwriterSubscribeMapper underwriterSubscribrmapper;

	@Override
	public List<UnderwriterSubscribe> getInfosByPage(String page, String rows,
			UnderwriterSubscribe example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoUnderwriterSubscribe record = new IpoUnderwriterSubscribe();
			BeanUtils.copyProperties(example, record);
			List<IpoUnderwriterSubscribe> datalist = underwriterSubscribrmapper
					.getInfosByPage(startIndex, endIndex, record);
			List<UnderwriterSubscribe> datalist2 = new ArrayList<UnderwriterSubscribe>();
			for (IpoUnderwriterSubscribe temp : datalist) {
				UnderwriterSubscribe info = new UnderwriterSubscribe();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getQueryNum(UnderwriterSubscribe example) {
		if (example != null) {
			IpoUnderwriterSubscribe record = new IpoUnderwriterSubscribe();
			BeanUtils.copyProperties(example, record);
			return underwriterSubscribrmapper.getQueryNum(record);
		}
		return 0;
	}

	@Override
	public String deleteInfo(String ids) {
		String[] subscribeids = ids.split(",");
		int num = 0;
		for (String id : subscribeids) {
			IpoUnderwriterSubscribe example = underwriterSubscribrmapper
					.selectByPrimaryKey(new BigDecimal(id));
			example.setDeleteFlag((short) 1);
			num = num + underwriterSubscribrmapper.updateByPrimaryKey(example);
		}
		if (num == subscribeids.length) {
			return "true";
		}
		return "false";
	}

}
