package com.jxust.entity;

public class Orderlist {


    private int orderid;

    private String ordername;

     
     private String phone;


    private String productname;


    private double price;


    private int number;


    private String picture;


    private String remark;


    private String discount;


    private String tradenumber;


    private String userjudge;


    private int userid;


    public String createtime;

    public int isdelorder;


    /**
     * 0代表未收货,1代表已经收货
     */
    private int receiver;

    /**
     * 订单总金额
     */
    private int totalAccount;

     private String address;
     
     private int index;
     
     private String size;
    public int getIsdelorder() {
        return isdelorder;
    }

    public void setIsdelorder(int isdelorder) {
        this.isdelorder = isdelorder;
    }

    public int getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(int totalAccount) {
        this.totalAccount = totalAccount;
    }

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


    public String getProductname() {
        return productname;
    }


    public void setProductname(String productname) {
        this.productname = productname;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }



    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getDiscount() {
        return discount;
    }


    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public String getTradenumber() {
        return tradenumber;
    }


    public void setTradenumber(String tradenumber) {
        this.tradenumber = tradenumber;
    }


    public String getUserjudge() {
        return userjudge;
    }


    public void setUserjudge(String userjudge) {
        this.userjudge = userjudge;
    }


    public int getUserid() {
        return userid;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }


    public String getCreatetime() {
        return createtime;
    }


    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "Orderlist [orderid=" + orderid + ", ordername=" + ordername
				+ ", phone=" + phone + ", productname=" + productname
				+ ", price=" + price + ", number=" + number + ", picture="
				+ picture + ", remark=" + remark + ", discount=" + discount
				+ ", tradenumber=" + tradenumber + ", userjudge=" + userjudge
				+ ", userid=" + userid + ", createtime=" + createtime
				+ ", isdelorder=" + isdelorder + ", receiver=" + receiver
				+ ", totalAccount=" + totalAccount + ", address=" + address
				+ ", index=" + index + ", size=" + size + "]";
	}

}
