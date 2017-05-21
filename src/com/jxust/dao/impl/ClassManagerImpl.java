package com.jxust.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.ClassManager;
import com.jxust.entity.Class;


public class ClassManagerImpl implements ClassManager {

	@Override
	public Class findClassById(int classid) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Class cla = new Class();

		try {
			conn = JDBCUtil.getConn();
			stat = conn.createStatement();
			String sql = "select * from class where classid = "+classid;
			rs = stat.executeQuery(sql);
			if (rs.next()){
				cla.setClassid(rs.getInt("classid"));
				cla.setClassname(rs.getString("classname"));
				cla.setRemark(rs.getString("remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cla;
	}

	@Override
	public List<Class> findAllClasses() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Class> classes = new ArrayList<Class>();
		
		conn = JDBCUtil.getConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from class");
			while (rs.next()) {
				Class cla = new Class();
				cla.setClassid(rs.getInt("classid"));
				cla.setClassname(rs.getString("classname"));
				cla.setRemark(rs.getString("remark"));
				classes.add(cla);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classes;

	}

	@Override
	public Class findClassByclassName(String className) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Class cla = new Class();

		try {
			conn = JDBCUtil.getConn();
			stat = conn.createStatement();
			String sql = "select * from class where classname = "+ "'" + className + "'";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				cla.setClassid(rs.getInt("classid"));
				cla.setClassname(rs.getString("classname"));
				cla.setRemark(rs.getString("remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cla;
	}

}
