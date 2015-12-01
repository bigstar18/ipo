/**
 * 
 */
package com.yrdce.ipo.modules.sys;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hxx
 *
 */
@Component
public class SectionManager {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void init() {

	}

	public boolean isOpenMarketTime(Date date) {
		return true;// TODO
	}

	public long getOpenMarketTimeFromNow(Date date) {

		return 100000l;// TODO
	}

	public long getTradeTimeFromNow(Date date) {

		return 100000l;// TODO
	}

	public int getCurrentSectionId(Date date) {

		return 1;// TODO
	}
}
