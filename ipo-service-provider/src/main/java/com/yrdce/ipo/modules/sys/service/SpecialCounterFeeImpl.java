package com.yrdce.ipo.modules.sys.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoSpecialcounterfeeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialcounterfee;
import com.yrdce.ipo.modules.sys.vo.Specialcounterfee;

@Service
public class SpecialCounterFeeImpl implements SpecialCounterFeeService {
	@Autowired
	private IpoSpecialcounterfeeMapper ipoSpecialcounterfeeMapper;

	@Override
	public int insertSpecialcounterfeeInfo(Specialcounterfee specialcounterfee) throws Exception {
		if (specialcounterfee != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String id1 = sdf.format(new Date());
			String id2 = String.valueOf(ipoSpecialcounterfeeMapper.sequence());
			IpoSpecialcounterfee ipoSpecialcounterfee = new IpoSpecialcounterfee();
			BeanUtils.copyProperties(specialcounterfee, ipoSpecialcounterfee);
			ipoSpecialcounterfee.setId(id1 + id2);
			return ipoSpecialcounterfeeMapper.insert(ipoSpecialcounterfee);
		}
		return 0;
	}

	@Override
	public List<Specialcounterfee> getSpecialcounterfeeInfo(String page, String rows) throws Exception {
		List<Specialcounterfee> specialcounterfees = new ArrayList<Specialcounterfee>();
		int beginNum = (Integer.parseInt(page) - 1) * Integer.parseInt(rows) + 1;
		int endNum = Integer.parseInt(page) * Integer.parseInt(rows);
		List<IpoSpecialcounterfee> ipospecialcounterfees = ipoSpecialcounterfeeMapper.selectAll(beginNum, endNum);
		if (ipospecialcounterfees.size() != 0) {
			for (IpoSpecialcounterfee ipoSpecialcounterfee : ipospecialcounterfees) {
				Specialcounterfee specialcounterfee = new Specialcounterfee();
				BeanUtils.copyProperties(ipoSpecialcounterfee, specialcounterfee);
				specialcounterfees.add(specialcounterfee);
			}
		}
		return specialcounterfees;
	}

	@Override
	public int getCounts() {
		return ipoSpecialcounterfeeMapper.selectCounts();
	}

	@Override
	public int deleteInfoById(String id) {
		return ipoSpecialcounterfeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int isFirm(String firmid) {
		return ipoSpecialcounterfeeMapper.isFirm(firmid);
	}

	@Override
	public Specialcounterfee selectInfoById(String id) throws Exception {
		IpoSpecialcounterfee ipoSpecialcounterfee = ipoSpecialcounterfeeMapper.selectByPrimaryKey(id);
		Specialcounterfee specialcounterfee = null;
		if (ipoSpecialcounterfee != null) {
			specialcounterfee = new Specialcounterfee();
			BeanUtils.copyProperties(ipoSpecialcounterfee, specialcounterfee);
		}
		return specialcounterfee;
	}

	@Override
	public int updateInfoById(Specialcounterfee specialcounterfee) throws Exception {
		if (specialcounterfee != null) {
			IpoSpecialcounterfee ipoSpecialcounterfee = new IpoSpecialcounterfee();
			BeanUtils.copyProperties(specialcounterfee, ipoSpecialcounterfee);
			return ipoSpecialcounterfeeMapper.updateByPrimaryKey(ipoSpecialcounterfee);
		}
		return 0;
	}

}
