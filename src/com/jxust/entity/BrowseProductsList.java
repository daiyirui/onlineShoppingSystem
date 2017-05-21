package com.jxust.entity;

/**
 * Created by idisfkj on 16/7/27.
 */
public class BrowseProductsList {
    private int productid;
    private double price;
    private String picture;
    private String discount;
    private String productName;
    private int popularity;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getHotsale() {
        return hotsale;
    }

    public void setHotsale(int hotsale) {
        this.hotsale = hotsale;
    }

    private int hotsale;
}
