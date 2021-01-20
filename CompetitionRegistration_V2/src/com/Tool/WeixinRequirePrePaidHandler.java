package com.Tool;

import java.util.SortedMap;
import java.util.TreeMap;

public class WeixinRequirePrePaidHandler {  
  
//	RequestHandler requestHandler = new RequestHandler(super.getRequest(),super.getResponse());
//	 
//	//获取token //两小时内有效，两小时后重新获取
//	 
//	Token = requestHandler.GetToken();
//	 
//	//更新token 到应用中
//	 
//	requestHandler.getTokenReal();
//	 
//	System.out.println("微信支付获取token=======================:" +Token);
//	 
//	 
//	 
//	//requestHandler 初始化
//	 
//	requestHandler.init();
//	 
//	requestHandler.init(appid,appsecret, appkey,partnerkey, key);
//	 
//	 
//	 
//	// --------------------------------本地系统生成订单------------------------------------- 
//	 
//	// 设置package订单参数  
//	 
//	    SortedMap<String, String> packageParams = new TreeMap<String, String>();  
//	 
//	    packageParams.put("bank_type", "WX"); // 支付类型  
//	 
//	    packageParams.put("body", "xxxx"); // 商品描述  
//	 
//	    packageParams.put("fee_type", "1"); // 银行币种  
//	 
//	    packageParams.put("input_charset", "UTF-8"); // 字符集  
//	 
//	    packageParams.put("notify_url", "http://xxxx.com/xxxx/wxcallback"); // 通知地址  这里的通知地址使用外网地址测试，注意80端口是否打开。
//	 
//	    packageParams.put("out_trade_no", no); // 商户订单号  
//	 
//	    packageParams.put("partner", partenerid); // 设置商户号  
//	 
//	    packageParams.put("spbill_create_ip", super.getRequest().getRemoteHost()); // 订单生成的机器IP，指用户浏览器端IP  
//	 
//	    packageParams.put("total_fee", String.valueOf(rstotal)); // 商品总金额,以分为单位  
//	 
//	 
//	 
//	// 设置支付参数  
//	 
//	    SortedMap<String, String> signParams = new TreeMap<String, String>();  
//	 
//	    signParams.put("appid", appid);  
//	 
//	    signParams.put("noncestr", noncestr);  
//	 
//	    signParams.put("traceid", PropertiesUtils.getOrderNO());  
//	 
//	    signParams.put("timestamp", timestamp);  
//	 
//	    signParams.put("package", packageValue);  
//	 
//	    signParams.put("appkey", this.appkey);
//	 
//	 
//	 
//	    // 生成支付签名，要采用URLENCODER的原始值进行SHA1算法！  
//	 
//	    String sign ="";
//	 
//	        try {
//	 
//	        sign = Sha1Util.createSHA1Sign(signParams);
//	 
//	        } catch (Exception e) {
//	 
//	        e.printStackTrace();
//	 
//	        }  
//	 
//	      
//	 
//	    // 增加非参与签名的额外参数  
//	 
//	    signParams.put("sign_method", "sha1");  
//	 
//	    signParams.put("app_signature", sign);  
//	 
//	    
//	 
//	      
//	 
//	    // api支付拼包结束------------------------------------  
//	 
//	    
//	 
//	    //获取prepayid
//	 
//	    String prepayid = requestHandler.sendPrepay(signParams);
//	 
//	    System.out.println("prepayid :" + prepayid);
//	 
//	 
//	 
//	 
//	 
//	    
//	 
//	// --------------------------------生成完成---------------------------------------------  
//	 
//	    
//	 
//	 //生成预付快订单完成，返回给android,ios 掉起微信所需要的参数。
//	 
//	    SortedMap<String, String> payParams = new TreeMap<String, String>();  
//	 
//	    payParams.put("appid", appid);
//	 
//	    payParams.put("noncestr", noncestr);
//	 
//	    payParams.put("package", "Sign=WXPay");
//	 
//	    payParams.put("partnerid", partenerid);
//	 
//	    payParams.put("prepayid", prepayid);
//	 
//	    payParams.put("appkey", this.appkey);
//	 
//	   //这里除1000 是因为参数长度限制。
//	 
//	    int time = (int) (System.currentTimeMillis() / 1000);
//	 
//	    payParams.put("timestamp",String.valueOf(time));
//	 
//	    
//	 
//	    System.out.println("timestamp:" + time);
//	 
//	    
//	 
//	   //签名
//	 
//	    String paysign ="";
//	 
//	    try {
//	 
//	                paysign = Sha1Util.createSHA1Sign(payParams);
//	 
//	    } catch (Exception e) {
//	 
//	        e.printStackTrace();
//	 
//	    }
//	 
//	    payParams.put("sign", paysign);
//	 
//	    
//	 
//	  //拼json 数据返回给客户端
//	 
//	    BasicDBObject backObject = new BasicDBObject();
//	 
//	    backObject.put("appid", appid);
//	 
//	    backObject.put("noncestr", payParams.get("noncestr"));
//	 
//	    backObject.put("package", "Sign=WXPay");
//	 
//	    backObject.put("partnerid", payParams.get("partnerid"));
//	 
//	    backObject.put("prepayid", payParams.get("prepayid"));
//	 
//	    backObject.put("appkey", this.appkey);
//	 
//	    backObject.put("timestamp",payParams.get("timestamp"));
//	 
//	    backObject.put("sign",payParams.get("sign"));
//	 
//	    
//	 
//	    String backstr = dataObject.toString();
//	 
//	    System.out.println("backstr:" + backstr);
//	 
//	 
//	 
//	    return backstr;
      
}
