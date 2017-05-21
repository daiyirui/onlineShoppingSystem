package com.jxust.entity;

import java.sql.*;

/**
 * @author shymain
 */
public class Order {

    private int orderid;


    private String ordername;


    private String userjudge;



    private int productid;


    private int number;

    private int userid;

    public String createtime;

    private int isdelorder;


    private String remark;
    
    private int index;

    /**
     * 0代表未收货,1代表已经收货
     */
    private int receiver;
    
    private String size;

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getOrderid() {
        return orderid;
    }


    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }


    public String getOrdername() {
        return ordername;
    }


    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }


    public String getUserjudge() {
        return userjudge;
    }


    public void setUserjudge(String userjudge) {
        this.userjudge = userjudge;
    }


    public int getProductid() {
        return productid;
    }


    public void setProductid(int productid) {
        this.productid = productid;
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public int getUserid() {
        return userid;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getIsdelorder() {
        return isdelorder;
    }



    public void setIsdelorder(int isdelorder) {
        this.isdelorder = isdelorder;
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


    public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordername=" + ordername
				+ ", userjudge=" + userjudge + ", productid=" + productid
				+ ", number=" + number + ", userid=" + userid + ", createtime="
				+ createtime + ", isdelorder=" + isdelorder + ", remark="
				+ remark + ", index=" + index + ", receiver=" + receiver
				+ ", size=" + size + "]";
	}




}
