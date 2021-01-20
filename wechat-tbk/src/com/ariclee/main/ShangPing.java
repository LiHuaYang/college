package com.ariclee.main;

public class ShangPing {

	private String name;
	private String picture;
	private String num_iid;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(String num_iid) {
		this.num_iid = num_iid;
	}
	
	
	
	@Override
	public String toString() {
		String spmz = "商品名字：";
		String spid = "商品ID：";
		String zpdz = "商品照片：";
		return (spmz + this.name + "\n"  + zpdz + this.picture);
	}
	
	
	
}
