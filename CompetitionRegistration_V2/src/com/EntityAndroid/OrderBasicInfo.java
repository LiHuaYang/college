package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBasicInfo {

	private	String	ProductPictureURL	;//	商品图片
	private	String	ProductName	;//	商品名称
	private	int	ProductPrice	;//	商品价格

	
	public OrderBasicInfo(String ProductPictureURL,String ProductName,int ProductPrice){
		this.ProductPictureURL=ProductPictureURL;
		this.ProductName=ProductName;
		this.ProductPrice=ProductPrice;
	}

	public OrderBasicInfo(ResultSet resultSet) throws SQLException{
		this.ProductPictureURL=resultSet.getString("ProductPictureURL");
		this.ProductName=resultSet.getString("ProductName");
		this.ProductPrice=resultSet.getInt("ProductPrice");
		
	}

	
	public String getProductPictureURL() {
		return ProductPictureURL;
	}


	public String getProductName() {
		return ProductName;
	}


	public int getProductPrice() {
		return ProductPrice;
	}


	@Override
	public String toString() {
		return "OrderBasicInfo [ProductName=" + ProductName
				+ ", ProductPictureURL=" + ProductPictureURL
				+ ", ProductPrice=" + ProductPrice + "]";
	}
	
	
	
}
