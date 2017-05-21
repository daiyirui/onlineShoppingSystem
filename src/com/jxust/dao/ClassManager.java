package com.jxust.dao;

import java.util.List;

import com.jxust.entity.Class;



public interface ClassManager {

	/**
	 * @param classid通过类别id查找
	 * @return
	 */
	public Class findClassById(int classid);
	
	/**
	 * 查找所有类别
	 * @return
	 */
	public List<Class> findAllClasses();

	/**
	 * 根据类别名查找类别
	 * @return
	 */
	public Class findClassByclassName(String className);


	
}
