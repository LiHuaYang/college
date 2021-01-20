package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFavoriteGoods {
	private	String	ProductName	;//	商品名称
	private	String	ProductPictureURL	;//	商品图片
	private	String	ProductPrice	;//	商品价格

	
	public UserFavoriteGoods(String	ProductName,String ProductPictureURL,String ProductPrice){
		this.ProductName=ProductName;
		this.ProductPictureURL=ProductPictureURL;
		this.ProductPrice=ProductPrice;
	}
	
	public UserFavoriteGoods(ResultSet resultSet) throws SQLException{
		this.ProductName=resultSet.getString("ProductName");
		this.ProductPictureURL=resultSet.getString("ProductPictureURL");
		this.ProductPrice=resultSet.getString("ProductPrice");
	}


	public String getProductName() {
		return ProductName;
	}

	public String getProductPictureURL() {
		return ProductPictureURL;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	@Override
	public String toString() {
		return "UserFavoriteGoods [ProductName=" + ProductName
				+ ", ProductPictureURL=" + ProductPictureURL
				+ ", ProductPrice=" + ProductPrice + "]";
	}
	
	
	
	
}
