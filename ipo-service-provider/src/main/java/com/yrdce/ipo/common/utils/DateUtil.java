package com.yrdce.ipo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 * 
 * @author Bob
 *
 */
public class DateUtil {

	public static String getTime(int n) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String specifiedDay = sdf.format(date);
		String str = DateUtil.getSpecifiedDayAfter(specifiedDay, n);
		return str;

	}

	/**
	 * 获得指定日期的前N天
	 * 
	 * @param specifiedDay
	 * @param 前N天
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int n) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - n);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}
}
