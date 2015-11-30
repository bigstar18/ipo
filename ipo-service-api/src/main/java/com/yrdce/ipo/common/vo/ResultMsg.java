/**
 * 
 */
package com.yrdce.ipo.common.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hxx
 *
 */
public class ResultMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8165892927357858901L;

	public static final String RESULT_SUCCESS = "success";
	public static final String RESULT_ERROR = "error";
	public static final String RESULT_EXCEPTION = "exception";
	private String result = RESULT_SUCCESS;
	private String msg = "出错啦！";
	private Map business = new HashMap();

	public Map getBusiness() {
		return business;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
