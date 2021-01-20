package com.EntityAndroid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStandInfo {

	private	String	ReceivingUserName	;//	收件人
	private	String	ReceivingUserPhone	;//	收件人电话
	private	String	ReceivingDetailAddress	;//	收货地址
	private	String	DeliverProductInvoice	;//	物流单号
	private	String	DeliverProductExpressFirm	;//	物流公司
	private	String	LogisticsTime	;//	当前物流更新时间
	private	String	LogisticsAddress	;//	当前物流地址
	private	String	LogisticsMassage	;//	物流信息
	private	String	DeliverGoodsTime	;//	发货时间
	private	String	ProductPictureURL	;//	商品图片
	private	String	ProductName	;//	商品名字
	private	int	ProductPrice	;//	商品价格
	private	String	ProductDetail	;//	商品信息详情
	
	public OrderStandInfo(String receivingUserName, String receivingUserPhone,
			String receivingDetailAddress, String deliverProductInvoice,
			String deliverProductExpressFirm, String logisticsTime,
			String logisticsAddress, String logisticsMassage,
			String deliverGoodsTime, String productPictureURL,
			String productName, int productPrice, String productDetail) {
		this.ReceivingUserName = receivingUserName;
		this.ReceivingUserPhone = receivingUserPhone;
		this.ReceivingDetailAddress = receivingDetailAddress;
		this.DeliverProductInvoice = deliverProductInvoice;
		this.DeliverProductExpressFirm = deliverProductExpressFirm;
		this.LogisticsTime = logisticsTime;
		this.LogisticsAddress = logisticsAddress;
		this.LogisticsMassage = logisticsMassage;
		this.DeliverGoodsTime = deliverGoodsTime;
		this.ProductPictureURL = productPictureURL;
		this.ProductName = productName;
		this.ProductPrice = productPrice;
		this.ProductDetail = productDetail;
	}
	
	public OrderStandInfo(ResultSet resultSet) throws SQLException{
		this.ReceivingUserName=resultSet.getString("ReceivingUserName");
		this.ReceivingUserPhone=resultSet.getString("ReceivingUserPhone");
		this.ReceivingDetailAddress=resultSet.getString("ReceivingDetailAddress");
		this.ProductPrice=resultSet.getInt("ProductPrice");
		this.DeliverProductInvoice=resultSet.getString("DeliverProductInvoice");
		this.DeliverProductExpressFirm=resultSet.getString("DeliverProductExpressFirm");
		this.LogisticsTime=resultSet.getString("LogisticsTime");
		this.LogisticsAddress=resultSet.getString("LogisticsAddress");
		this.LogisticsMassage=resultSet.getString("LogisticsMassage");
		this.DeliverGoodsTime=resultSet.getString("DeliverGoodsTime");
		this.ProductPictureURL=resultSet.getString("ProductPictureURL");
		this.ProductName=resultSet.getString("ProductName");
		this.ProductDetail=resultSet.getString("ProductDetail");
	}
	
	public String getReceivingUserName() {
		return ReceivingUserName;
	}
	
	public String getReceivingUserPhone() {
		return ReceivingUserPhone;
	}
	
	public String getReceivingDetailAddress() {
		return ReceivingDetailAddress;
	}
	
	public String getDeliverProductInvoice() {
		return DeliverProductInvoice;
	}
	
	public String getDeliverProductExpressFirm() {
		return DeliverProductExpressFirm;
	}
	
	public String getLogisticsTime() {
		return LogisticsTime;
	}
	
	public String getLogisticsAddress() {
		return LogisticsAddress;
	}
	
	public String getLogisticsMassage() {
		return LogisticsMassage;
	}
	
	public String getDeliverGoodsTime() {
		return DeliverGoodsTime;
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
	
	public String getProductDetail() {
		return ProductDetail;
	}

	@Override
	public String toString() {
		return "OrderStandInfo [DeliverGoodsTime=" + DeliverGoodsTime
				+ ", DeliverProductExpressFirm=" + DeliverProductExpressFirm
				+ ", DeliverProductInvoice=" + DeliverProductInvoice
				+ ", LogisticsAddress=" + LogisticsAddress
				+ ", LogisticsMassage=" + LogisticsMassage + ", LogisticsTime="
				+ LogisticsTime + ", ProductDetail=" + ProductDetail
				+ ", ProductName=" + ProductName + ", ProductPictureURL="
				+ ProductPictureURL + ", ProductPrice=" + ProductPrice
				+ ", ReceivingDetailAddress=" + ReceivingDetailAddress
				+ ", ReceivingUserName=" + ReceivingUserName
				+ ", ReceivingUserPhone=" + ReceivingUserPhone + "]";
	}
	
	

}
