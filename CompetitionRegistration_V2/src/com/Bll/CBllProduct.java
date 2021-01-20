package com.Bll;

//商城管理
public class CBllProduct {
	
	//CBllCompetition单例
//	private volatile static CBllProduct cBllProduct = null;
//	
//	private CBllProduct(){
//		System.out.println("CBllProduct构造函数被调用");
//	};
//	
//	public static CBllProduct getInstance(){
//		if(cBllProduct == null){
//			synchronized (CBllProduct.class) {
//				if(cBllProduct == null){
//					cBllProduct = new CBllProduct();
//				}
//			}
//		}
//		
//		return cBllProduct;
//	}
	
	public CBllProduct(){
		System.out.println("CBllProduct构造函数被调用");
	};

}
