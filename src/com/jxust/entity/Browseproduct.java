package com.jxust.entity;

public class Browseproduct {
	
	private int browseproductid;
	private String browseproductname;
	private int productid;
	private int classid;
	private int popularity;
	private int hotsale;
	private String keywords;
	private String remark;
	private String picture;
	
	 private String size;
	public int getBrowseproductid() {
		return browseproductid;
	}
	public void setBrowseproductid(int browseproductid) {
		this.browseproductid = browseproductid;
	}
	public int getProductid() {
		return productid;
	}
	
	public String getBrowseproductname() {
		return browseproductname;
	}
	public void setBrowseproductname(String browseproductname) {
		this.browseproductname = browseproductname;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
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
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	
	public String toString() {
		return "Browseproduct [browseproductid=" + browseproductid
				+ ", browseproductname=" + browseproductname + ", productid="
				+ productid + ", classid=" + classid + ", popularity="
				+ popularity + ", hotsale=" + hotsale + ", keywords="
				+ keywords + ", remark=" + remark + ", picture=" + picture
				+ "]";
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	

	
	
	
	
}
