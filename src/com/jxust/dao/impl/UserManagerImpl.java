package com.jxust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.UserManager;
import com.jxust.entity.User;

/**
 * @author Administrator
 */
public class UserManagerImpl implements UserManager {

    @Override
    public boolean register(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean flag;

        try {
            String sql = "insert into user(username,userpassword,age,sex,email,type,remark,phone,address) "
                    + "value(?,?,?,?,?,?,?,?,?)";
            connection = JDBCUtil.getConn();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getUserpassword());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getSex());
            statement.setString(5, user.getEmail());
            statement.setInt(6, 0);
            statement.setString(7, user.getRemark());
            statement.setString(8, user.getPhone());
            statement.setString(9, user.getAddress());
            statement.executeUpdate();
            flag = true;


        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, null);
        }
        return flag;


    }

    @Override
    public User checkLogin(String username, String userpassword) {
        int flag = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        User user = new User();
        try {
            connection = JDBCUtil.getConn();
            statement = connection.createStatement();
            String sql = "select * from user "
                    + "where username='" + username + "' and userpassword='" + userpassword + "' and type=0";
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                user.setUserid(rs.getInt(1));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                System.out.println(rs.getInt(1));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, rs);
        }

        return user;
    }

    @Override
    public boolean modifyInfo(User user) {

        boolean flag;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtil.getConn();

            String sql = "update user set username=?,userpassword=?,age=?,sex=?,email=?,remark=?,phone=?,address=? where userid=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getUserpassword());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getSex());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getRemark());
            statement.setString(7, user.getPhone());
            statement.setString(8, user.getAddress());
            statement.setInt(9, user.getUserid());
            statement.executeUpdate();
            flag = true;

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, null);
        }
        return flag;
    }

    @Override
    public User findUserById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();

        connection = JDBCUtil.getConn();
        String sql = "SELECT * From user WHERE userid=?";
        System.out.println(sql+id);
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpassword(resultSet.getString("userpassword"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
                user.setType(resultSet.getInt("type"));
                user.setRemark(resultSet.getString("remark"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, resultSet);
        }
        return user;

    }

	@Override
	public boolean checkEmail(String email) {
		boolean flag=false;
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		connection=JDBCUtil.getConn();
        try {
        	stmt=connection.prepareStatement("Select * from user where type=0");
			rs=stmt.executeQuery();
			while(rs.next()){
	            if(email.equals(rs.getString(6))){
	            	flag = true;
	            }
            
			}

        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, stmt, null);
        }
        return flag;

	}

	@Override
	public boolean resetPassword(String email, String resetpassword) {
		
		boolean flag;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtil.getConn();

            String sql = "update user set userpassword=? where email=?";

            statement = connection.prepareStatement(sql);
           
            statement.setString(1, resetpassword);
            statement.setString(2, email);
            
            statement.executeUpdate();
            flag = true;

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            JDBCUtil.closeDB(connection, statement, null);
        }
        return flag;
	}


}
