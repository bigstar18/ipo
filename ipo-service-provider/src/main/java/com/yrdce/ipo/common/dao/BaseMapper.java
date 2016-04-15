package com.yrdce.ipo.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.yrdce.ipo.modules.sys.ConfigManager;

public class BaseMapper {

	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ConfigManager cm = ConfigManager.getinstance();

	private boolean operate(String sql, Object... params) {
		getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			int i = ps.executeUpdate();// ====>ps.excute();
										// ====>ps.getUpdateCount();
			if (i == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return true;
	}

	public boolean add(String sql, Object... params) {
		return this.operate(sql, params);
	}

	public boolean delete(String sql, Object... params) {
		return this.operate(sql, params);
	}

	public boolean update(String sql, Object... params) {
		return this.operate(sql, params);
	}

	public ResultSet select(String sql, Object[] params) {
		getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);// ?��ʾ���ֶ�ֵ������object[]���Ԫ��һһ��Ӧ
			}
			rs = ps.executeQuery();// ====>ps.excute();
									// ====>ps.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// Tomcatδ����ʱ web��Ŀ��ȡ���Ӷ���ķ�ʽ
	public Connection getConnection() {
		try {
			Class.forName(cm.getString("jdbc.driver"));
			connection = DriverManager.getConnection(cm.getString("jdbc.url"),
					cm.getString("jdbc.username"),
					cm.getString("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Tomcat������ �ɷ�������ȡ���Ӷ���ķ�ʽ
	public Connection getConnection2() {

		try {
			Context cxt = new InitialContext();

			DataSource ds = (DataSource) cxt
					.lookup("java:comp/env/jdbc/dataSource");

			connection = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeResource() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
