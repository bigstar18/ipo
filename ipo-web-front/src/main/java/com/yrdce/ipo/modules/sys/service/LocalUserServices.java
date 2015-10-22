/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yrdce.ipo.modules.sys.service;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.yrdce.ipo.modules.sys.entity.User;

/**
 * 用户工具类
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
public interface LocalUserServices {
	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		private boolean mobileLogin; // 是否手机登录

		// private Map<String, Object> cacheMap;

		public Principal(User user, boolean mobileLogin) {
			// this.id = user.getId();
			// this.loginName = user.getLoginName();
			this.name = user.getName();
			this.mobileLogin = mobileLogin;
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

		// @JsonIgnore
		// public Map<String, Object> getCacheMap() {
		// if (cacheMap==null){
		// cacheMap = new HashMap<String, Object>();
		// }
		// return cacheMap;
		// }

		@Override
		public String toString() {
			return id;
		}

	}

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";

	/**
	 * 获取授权主要对象
	 */
	public Subject getSubject();

	/**
	 * 获取当前登录者对象
	 */
	public Principal getPrincipal();

	public Session getSession();

	// ============== User Cache ==============

	public Object getCache(String key);

	public Object getCache(String key, Object defaultValue);

	public void putCache(String key, Object value);

	public void removeCache(String key);

	// public static Map<String, Object> getCacheMap(){
	// Principal principal = getPrincipal();
	// if(principal!=null){
	// return principal.getCacheMap();
	// }
	// return new HashMap<String, Object>();
	// }

}
