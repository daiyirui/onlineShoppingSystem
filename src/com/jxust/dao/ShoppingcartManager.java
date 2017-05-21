package com.jxust.dao;

import java.sql.Date;
import java.util.List;



import com.jxust.entity.Product;
import com.jxust.entity.Shoppingcart ;
import com.jxust.entity.Shoppingcartlist;

public interface ShoppingcartManager {


	   /**
	    * 鏌ユ壘璐墿杞﹂噷闈㈡墍鏈変骇鍝�
	 * @return
	 */
	public List<Shoppingcart > findAllShoppingcarts();

	/**
	 * 閫氳繃鏌愪釜鐢ㄦ埛id鏌ユ壘瀵瑰簲璇ョ敤鎴疯喘鐗╄溅閲岄潰鐨勬墍鏈変笢瑗匡紒
	 * @param userid
	 * @return
	 */
	public List<Shoppingcart > findOneUserAllShoppingcarts(int userid);


	/**
	 * 閫氳繃璐墿杞︾紪鍙锋煡璇㈡煇涓�釜璐墿杞︼紒
	 * @param Shoppingcart id
	 * @return
	 */
	public Shoppingcart  findShoppingcartById(int Shoppingcartid);

	/**
	 * 閫氳繃鐢熸垚鏃堕棿鏌ヨ
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Shoppingcart > findShoppingcart (Date start , Date end);

	/**
	 * 鍚戣喘鐗╄溅涓坊鍔犱骇鍝�
	 * @param Shoppingcart
	 */
	public boolean addShoppingcart (Shoppingcart  Shoppingcart);

	/**
	 * 鍒犻櫎璐墿杞﹂噷闈㈢殑鏌愪釜浜у搧
	 * @param Shoppingcart id
	 */
	public boolean deleteShoppingcart(int shoppingcartid);


	/**
	 * 淇敼璐墿杞﹂噷闈㈢殑涓滆タ锛�
	 * @param Shoppingcart
	 * @return
	 */
	public boolean  modifyShoppingcart (Shoppingcart  shoppingcart );

	/**
	 * App验证该用户在购物车中是否有相同的商品
	 * @param productid
	 * @param userid
     * @param size
     * @return
     */
	public int checkoutShoppingCart(int productid, int userid, String size);

	/**
	 *	App如果存在相同的商品,则更新购物车该商品的购买数量
	 * @param shoppingcartid
     * @param flag 0代表减 , 1代表加
	 * @return
     */
	public boolean updateShoppingCartNumber(int shoppingcartid,int flag);

	/**
	 * App 查询用户的所用购物车信息
	 * @return
     */
	public List<Shoppingcartlist> queryAllShoppingCartByUserId(int userid);

	/**
	 * App 删除用户所有的购物车信息
	 * @param userid
	 * @return
     */
	public boolean deleteAllByUserId(int userid);

	public Product findproductById(int productid);
}
