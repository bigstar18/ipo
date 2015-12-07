package com.yrdce.ipo.common.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TaskMananeListener implements ServletContextListener {

	// Fields
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // 日志
	private static Timer timer;
	private static TimerTask task;

	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("调用contextDestroyed方法");
		if (timer != null) {
			timer.cancel();
			logger.debug("Timer Canceled");
		}
		logger.debug("contextDestroyed方法执行完成");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("调用contextInitialized方法");
		task = (TimerTask) WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()).getBean("taskmanage");
		try {

			timer = new Timer(true);
			GregorianCalendar now = new GregorianCalendar();
			// HOUR_OF_DAY( 用于 24 小时制时钟)
			// WEEK_OF_YEAR(第一个星期为1)
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 10);
			now.set(Calendar.SECOND, 0);

			Date date = new Date();
			Date i = now.getTime();
			if (now.getTime().before(date)) {
				now.setTime(date);
				now.add(Calendar.DATE, 1);

				i = now.getTime();
			}

			timer.schedule(task, i);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Unable to initialize Schedule.");
		}
		logger.debug("contextInitialized方法执行完成");

	}
}
