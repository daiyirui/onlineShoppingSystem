package com.jxust.dao;

import com.jxust.entity.User;

/**
 * 该接口主要实现前台会员的注册，登录，用户自己的信息修改，对商品进行评价
 * 
 * 订单查询（包含订单删除功能，但不在数据库中删除订单记录，仅仅是会员登录后查询不到订单）
 * 
 * 由订单标记来完成。订单标记为0，说明该条订单被用户删除，订单标记为1，说明该订单可以被用户查询！
 * 
 * @author 江西理工大学*中软国际项目组开发
 *
 */
public interface Manager {

	/**
	 * 会员注册
	 * @param user
	 */
	public void  register(User user);
	
	/**
	 * 验证会员登录名称和密码
	 * @param username
	 * @param userpassword
	 */
	public void checkLogin(String username, String userpassword);
	
	
	/**
	 * 修改用户信息！
	 * @param user
	 * @return
	 */
	public User modifyInfo(User user);
	
	
	
	
	
}
