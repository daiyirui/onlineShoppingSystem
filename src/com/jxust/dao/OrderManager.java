package com.jxust.dao;

import java.sql.Date;
import java.util.List;

import com.jxust.entity.Order;
import com.jxust.entity.Orderlist;
import com.jxust.entity.Product;
import com.jxust.entity.User;

public interface OrderManager {
	
	   /**
	    * 
	 * @param Orderid
	 * @return
	 */
	public Order findOrderById(int Orderid);
	
	/**
	 * @param orderid
	 * @return
	 */
	public Product findproductById(int orderid);
	/**
	 * @param userid
	 * @return
	 */
	public List<Order> findOrderByUserId(int userid);
	

	/**
	 * 
	 * @return
	 */
	public List<Order> findAllOrder();
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public List<Order> findOrder(Date start , Date end);
	
	/**
	 * 
	 * @param order
	 */
	public  boolean addOrder(Order order);
	
	/**
	 * 
	 * @param Orderid
	 */
	public  void deleteOrder(int Orderid);
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public void modifyOrder(Order order);

	/**
	 * App 根据userid查找orderName
	 * @param userid
	 * @return
     */
	public List<String> findOrderNameByUserid(int userid);

	/**
	 * App 通过orderName查询Order信息
	 * @param orderName
	 * @return
     */
	public List<Orderlist> findOrderListByOrderName(String orderName);




     public	Order findAllOrderById(int Orderid);


	/**根据订单查找产品
	 * @param orderId
	 * @return
	 * 
	 */
	public List<Product> findProductByOrder(String orderName);

	/**
	 * 确认收货
	 * @param orderName
	 * @return
	 */
	public boolean comfirmReceiveByOrderName(String orderName);

	/**
	 * 确认查出订单
	 * @param orderName
	 * @return
	 */
	public boolean isDelOrderByOrderName(String orderName);

	 public User findUserByUserId(int userid);

}
