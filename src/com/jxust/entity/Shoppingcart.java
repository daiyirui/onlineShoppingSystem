package com.jxust.entity;





/**
 * @author shymain
 *
 */
public class Shoppingcart {
	
	private int shoppingcartid;
	
	
	private int productid;
	
	
	private int userid;
	
    private String createtime;
	
	private int number;

	private String remark;
	private String type;
    
	public int getShoppingcartid() {
		return shoppingcartid;
	}

	public void setShoppingcartid(int shoppingcartid) {
		this.shoppingcartid = shoppingcartid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	@Override
	public String toString() {
		return "Shoppingcart [shoppingcartid=" + shoppingcartid
				+ ", productid=" + productid + ", userid=" + userid
				+ ", createtime=" + createtime + ", number=" + number
				+ ", remark=" + remark + ", type=" + type 
				+ "]";
	}

	

}
