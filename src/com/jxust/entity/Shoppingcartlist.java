package com.jxust.entity;

public class Shoppingcartlist {

    private int shoppingcartid;


    private int productid;

    private int userid;

    private String createtime;

    private int number;

    private String remark;


    private String productname;


    private double price;


    private String picture;


    private String discount;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
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


    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getDiscount() {
        return discount;
    }


    public void setDiscount(String discount) {
        this.discount = discount;
    }


    @Override
    public String toString() {
        return "Shoppingcartlist [shoppingcartid=" + shoppingcartid
                + ", productid=" + productid + ", userid=" + userid
                + ", createtime=" + createtime + ", number=" + number
                + ", remark=" + remark + ", productname=" + productname
                + ", price=" + price + ", picture=" + picture + ", discount="
                + discount + ", type=" + type + "]";
    }


}
