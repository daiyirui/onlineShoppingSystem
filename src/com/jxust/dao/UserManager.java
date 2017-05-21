package com.jxust.dao;

import com.jxust.entity.User;

/**
 * @author
 */
public interface UserManager {

    /**
     * @param user
     */
    public boolean register(User user);

    /**
     * @param username
     * @param userpassword
     */
    public User checkLogin(String username, String userpassword);


    /**
     * @param user
     * @return
     */
    public boolean modifyInfo(User user);

    /**
     * 按id查找user
     *
     * @param id
     * @return User
     */
    public User findUserById(int id);

	/**
	 * 检测email是否存在
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email);

	/**
	 * 根据email重置密码
	 * @param resetPassword
	 */
	public boolean resetPassword(String email,String resetpassword);


}
