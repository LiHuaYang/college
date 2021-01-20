package com.ServletWX;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import com.Entity.V2.EnrollmentOrder;
import com.Tool.CommonUtil;
import com.Tool.GetWxOrderno;
import com.Tool.RequestHandler;
import com.Tool.Sha1Util;
import com.Tool.TenpayUtil;


public class TopayServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		
		// 网页授权后获取传递的参数
		String userId = request.getParameter("userId"); 	
		String orderNo = request.getParameter("orderNo"); 
		String money = request.getParameter("money");
		String code = request.getParameter("code");
		
		
		//金额转化为分为单位
		float sessionmoney = Float.parseFloat(money);
		String finalmoney = String.format("%.2f", new Object[] { Float.valueOf(sessionmoney) });
		finalmoney = finalmoney.replace(".","");
		
		//商户相关资料    
		String appid = "wxbd2420d3a7c050d6";			//公众号身份的唯一标识
		String appsecret = "d60915d70ab7124ca6dc79c03dc5d7c1";				
		String partner = "1317319901";					//财付通商户身份的标识
		String partnerkey = "ziyouedu1317319901ziyoueducation";					//财付通商户权限密钥Key
		
		String openId ="";								
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
		
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		if (null != jsonObject) {
			System.out.println("TopayServlet获取OpenId:"+jsonObject);
			openId = jsonObject.getString("openid");
		}
		
		//获取后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
		String currTime = TenpayUtil.getCurrTime();
		//8位日期
		String strTime = currTime.substring(8, currTime.length());
		//四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		//10位序列号,可以自行调整。
		String strReq = strTime + strRandom;
		//商户号
		String mch_id = partner;
		//子商户号  非必输
		//String sub_mch_id="";
		//设备号   非必输
		String device_info="";
		//随机数 
		String nonce_str = strReq;
		//商品描述
		String body = "比赛报名费用";
		//附加数据
		String attach = userId;   //如"深圳分店"
		//商户订单号
		String out_trade_no = orderNo;
		int intMoney = Integer.parseInt(finalmoney);
		
		//总金额以分为单位，不带小数点
		int total_fee = intMoney;
		//订单生成的机器 IP
		String spbill_create_ip = request.getRemoteAddr();
		//订 单 生 成 时 间   非必输
//		String time_start ="";
		//订单失效时间      非必输
//		String time_expire = "";
		//商品标记   非必输
//		String goods_tag = "";
		
		//这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		//String notify_url ="http://***/notifyServlet";
			
		String notify_url="http://www.usgame.cn/CompetitionRegistration_V2/NotifyServlet";
//		String notify_url="http://aric.tunnel.qydev.com/CompetitionRegistration/NotifyServlet";
		
		String trade_type = "JSAPI";
		String openid = openId;
		//非必输
//		String product_id = "";
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);  
		packageParams.put("mch_id", mch_id);  
		packageParams.put("nonce_str", nonce_str);  
		packageParams.put("body", body);   // 商品主体
		packageParams.put("attach", attach);  
		packageParams.put("out_trade_no", out_trade_no);  
				
//		packageParams.put("total_fee", "1");  
		packageParams.put("total_fee", finalmoney);  
		packageParams.put("spbill_create_ip", spbill_create_ip);  
		packageParams.put("notify_url", notify_url);  
		
		packageParams.put("trade_type", trade_type);  
		packageParams.put("openid", openid);  
		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(appid, appsecret, partnerkey);
		
		String sign = reqHandler.createSign(packageParams);
		String xml="<xml>"+
						"<appid>"+appid+"</appid>"+
						"<attach>"+attach+"</attach>"+
						"<body><![CDATA["+body+"]]></body>"+
						"<mch_id>"+mch_id+"</mch_id>"+	
						"<nonce_str>"+nonce_str+"</nonce_str>"+
						"<notify_url>"+notify_url+"</notify_url>"+
						"<openid>"+openid+"</openid>"+
						"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
						"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
						//金额，这里写的1 分到时修改
						"<total_fee>"+total_fee+"</total_fee>"+
						"<trade_type>"+trade_type+"</trade_type>"+				
						"<sign>"+sign+"</sign>"+
						"</xml>";
				String allParameters = "";
				try {
					allParameters =  reqHandler.genPackage(packageParams);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
				String prepay_id="";
				try {
					new GetWxOrderno();
					prepay_id = GetWxOrderno.getPayNo(createOrderURL, xml);
					if(prepay_id.equals("")){
						System.out.println("统一支付接口获取预支付订单出错");
						request.setAttribute("ErrorMsg", "统一支付接口获取预支付订单出错");
						response.sendRedirect("http://www.usgame.cn/CompetitionRegistration_V2/WeChat/jsp/error.jsp");
//						response.sendRedirect("http://aric.tunnel.qydev.com/CompetitionRegistration/WeChat/jsp/error.jsp");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				// 获取prepay_id后，拼接最后请求支付所需要的package
				SortedMap<String, String> finalpackage = new TreeMap<String, String>();	
				String appid2 = appid;
				String timestamp = Sha1Util.getTimeStamp();
				String nonceStr2 = nonce_str;
				String packages = "prepay_id="+prepay_id;
				
				finalpackage.put("appId", appid2);  
				finalpackage.put("timeStamp", timestamp);  
				finalpackage.put("nonceStr", nonceStr2);  
				finalpackage.put("package", packages);  
				finalpackage.put("signType", "MD5");				
				String finalsign = reqHandler.createSign(finalpackage);
				
				String url = "http://www.usgame.cn/CompetitionRegistration_V2/WeChat/jsp/pay.jsp?appid="+appid2+"&timeStamp="+timestamp+"&nonceStr="+nonceStr2+"&package="+packages+"&sign="+finalsign;
//				String url = "http://aric.tunnel.qydev.com/CompetitionRegistration/WeChat/jsp/pay.jsp?appid="+appid2+"&timeStamp="+timestamp+"&nonceStr="+nonceStr2+"&package="+packages+"&sign="+finalsign;
				
				System.out.println("TopayServlet--url:"+url);
				response.sendRedirect(url);
	}
	
	
	
	
	
	
	public boolean creatEnrollment(EnrollmentOrder order) {
//		EnrollmentOrder order = new EnrollmentOrder();
		
		
		
		return true;
	}
}
