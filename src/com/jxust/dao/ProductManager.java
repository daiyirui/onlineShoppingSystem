package com.jxust.dao;

import java.util.List;

import com.jxust.entity.Product;

public interface ProductManager  {
	
	/**
	 * @param productid通过产品id查询！
	 * @return
	 */
	public Product findProductById(int productid);
	
	/**
	 * @param string模糊查找
	 * @return
	 */
	public List<Product> findProductByName(String string);
	
	
	/**
	 * @param param通类别查找
	 * @return
	 */
	public List<Product> findProductByClass(int classid);
	
	/**
	 * @param low
	 * @param high通过价格范围查询！
	 * @return
	 */
	public List<Product> findProductByprice(Double low,Double high);
	
	/**
	 * 获取所有的产品
	 * @return
	 */
	public List<Product> findAllProduct();

	public List<Product> findHostByTradeNumber();
	
	public List<Product> findHostBydiscount(String discount);
	
	

}
