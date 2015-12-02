/**
 * 
 */
package com.yrdce.ipo.modules.sys;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yrdce.ipo.modules.sys.dao.IpoNottradedayMapper;
import com.yrdce.ipo.modules.sys.dao.IpoTradtimeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoNottradeday;
import com.yrdce.ipo.modules.sys.entity.IpoTradetime;

/**
 * @author hxx
 *
 */
@Component
public class SectionManager {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public static long dayOfMM = 86400000l;

	@Autowired
	IpoTradtimeMapper tradtimeMapper;
	@Autowired
	IpoNottradedayMapper nottradedayMapper;

	// 排过序，按starttime
	private List<IpoTradetime> tradetimes;

	private IpoNottradeday nonTradeDay;

	public void init() {
		tradetimes = tradtimeMapper.selectAll();
		if (tradetimes != null && tradetimes.size() > 0) {
			Collections.sort(tradetimes, new Comparator<IpoTradetime>() {
				@Override
				public int compare(IpoTradetime o1, IpoTradetime o2) {
					String s1 = o1.getStarttime().replaceAll(":", "");
					String s2 = o2.getStarttime().replaceAll(":", "");
					return (new Integer(s1)).compareTo(new Integer(s2));
				}
			});
		}
		nonTradeDay = nottradedayMapper.select();
		if (nonTradeDay != null)
			logger.info("非交易日: 星期=({}),日期={}", nonTradeDay.getWeek(), nonTradeDay.getDay());
	}

	// 是否是交易日
	private boolean isTradeDay(Date date) {
		String nonDayStr = nonTradeDay.getDay();

		String inputDay = SystemManager.sdf.format(date);
		if (nonDayStr != null && nonDayStr.indexOf(inputDay) > -1)
			return false;

		String nonWeekStr = nonTradeDay.getWeek();

		Calendar in = Calendar.getInstance();
		in.setTime(date);
		in.setFirstDayOfWeek(Calendar.MONDAY);
		int inputWeek = in.get(Calendar.DAY_OF_WEEK);
		if (nonWeekStr != null && nonWeekStr.indexOf(String.valueOf(inputWeek)) > -1)
			return false;

		return true;
	}

	// 是否在交易节内
	private boolean isTimeInSections(Date date) {
		if (tradetimes != null) {
			int input = date.getHours() * 10000 + date.getMinutes() * 100 + date.getSeconds();
			for (IpoTradetime ipoTradetime : tradetimes) {
				String start = ipoTradetime.getStarttime().replaceAll(":", "");
				String end = ipoTradetime.getEndtime().replace(":", "");
				if (input >= Integer.parseInt(start) && input < Integer.parseInt(end))
					return true;
			}
		}

		return false;
	}

	// 是否在第一个交易节前5分钟内
	private boolean isTimeIn5mBeforeSection(Date date) {
		if (tradetimes != null && tradetimes.size() > 0) {
			Calendar end = getFirstSectionTimeByDate(date);
			Calendar start = getTimeBeforSection5m(date);

			long in = date.getTime();
			if (in >= start.getTimeInMillis() && in <= end.getTimeInMillis())
				return true;
		}

		return false;
	}

	// 第一个交易节的起始时间前5分钟
	private Calendar getTimeBeforSection5m(Date date) {
		Calendar start = getFirstSectionTimeByDate(date);
		if (start != null) {
			start.add(Calendar.MINUTE, -5);

			return start;
		}
		return null;
	}

	// 获取第一个交易节的起始时间
	private Calendar getFirstSectionTimeByDate(Date date) {
		if (tradetimes != null && tradetimes.size() > 0) {
			return getStartTime(tradetimes.get(0), date);
		}
		return null;
	}

	/**
	 * 是否是开市时间
	 * 
	 * @param date
	 * @return
	 */
	public boolean isOpenMarketTime(Date date) {
		if (!isTradeDay(date))
			return false;

		if (isTimeInSections(date))
			return true;
		else if (isTimeIn5mBeforeSection(date))
			return true;
		else
			return false;
	}

	/**
	 * 现在离开市时间有多久毫秒，注意：没有计算非交易日
	 * 
	 * @param date
	 * @return
	 */
	public long getOpenMarketTimeFromNow(Date date) {
		long in = date.getTime();
		long start = getTimeBeforSection5m(date).getTimeInMillis();
		long result = start - in;
		return result < 0 ? dayOfMM + result : result;
	}

	/**
	 * 离第一个交易节还差多少毫秒
	 * 当天的交易日
	 * 
	 * @param date
	 * @return
	 */
	public long getFirstTradeTimeFromNow(Date date) {
		long in = date.getTime();
		long start = getFirstSectionTimeByDate(date).getTimeInMillis();
		long result = start - in;
		return result;
	}

	/**
	 * 离当前交易节结束还有多少毫秒
	 * 
	 * @param date
	 * @return
	 */
	public long getCurSectionEndTimeFromNow(Date date, String sectionId) {
		if (tradetimes != null) {
			for (IpoTradetime ipoTradetime : tradetimes) {
				String section = String.valueOf(ipoTradetime.getSectionid());
				if (section.equals(sectionId)) {
					long in = date.getTime();
					long end = getEndTime(ipoTradetime, date).getTimeInMillis();

					return end - in;
				}
			}
		}

		return 0;
	}

	/**
	 * 下一个交易节开始还有多少毫秒
	 * 
	 * @param date
	 * @return
	 */
	public long getNextTradeTimeFromNow(Date date) {
		if (tradetimes != null) {
			int input = date.getHours() * 10000 + date.getMinutes() * 100 + date.getSeconds();
			for (IpoTradetime ipoTradetime : tradetimes) {
				String start = ipoTradetime.getStarttime().replaceAll(":", "");
				if (input <= Integer.parseInt(start)) {// 有序
					long in = date.getTime();
					long next = getStartTime(ipoTradetime, date).getTimeInMillis();

					return next - in;
				}
			}
		}

		return 0;
	}

	/**
	 * 是否是最后一个交易节
	 * 
	 * @param sectionId
	 * @return
	 */
	public boolean isLastSection(String sectionId) {
		IpoTradetime tradetime = getLastSection();
		if (tradetime != null) {
			return sectionId.equals(tradetime.getSectionid().toString());
		}
		return false;
	}

	/**
	 * 现在所处的交易节
	 * 
	 * @param date
	 * @return
	 */
	public int getCurrentSectionId(Date date) {
		IpoTradetime ipoTradetime = getSectionByTime(date);

		if (ipoTradetime != null) {
			return ipoTradetime.getSectionid();

		}

		return -1;
	}

	// 最后一个交易节
	private IpoTradetime getLastSection() {
		if (tradetimes != null && tradetimes.size() > 0) {
			return tradetimes.get(tradetimes.size() - 1);
		}
		return null;
	}

	// 时间所处的交易节对象
	private IpoTradetime getSectionByTime(Date date) {
		if (tradetimes != null) {
			int input = date.getHours() * 10000 + date.getMinutes() * 100 + date.getSeconds();
			for (IpoTradetime ipoTradetime : tradetimes) {
				String start = ipoTradetime.getStarttime().replaceAll(":", "");
				String end = ipoTradetime.getEndtime().replace(":", "");
				if (input >= Integer.parseInt(start) && input < Integer.parseInt(end))
					return ipoTradetime;
			}
		}

		return null;
	}

	// 交易节的开始时间对象
	private Calendar getStartTime(IpoTradetime ipoTradetime, Date date) {
		String[] tmp = ipoTradetime.getStarttime().split(":");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmp[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(tmp[1]));
		calendar.set(Calendar.SECOND, Integer.parseInt(tmp[2]));

		return calendar;
	}

	// 交易节的结束时间
	private Calendar getEndTime(IpoTradetime ipoTradetime, Date date) {
		String[] tmp = ipoTradetime.getEndtime().split(":");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmp[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(tmp[1]));
		calendar.set(Calendar.SECOND, Integer.parseInt(tmp[2]));

		return calendar;
	}
}
