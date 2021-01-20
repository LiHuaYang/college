package com.ServletWX;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tool.Sha1Util;

//网页授权获取用户信息

public class MainServlet extends HttpServlet{
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{		
		//拿到订单基本信息
		String money = request.getParameter("ContestMoney");
		String userId = request.getParameter("userid");
		
		// 创建订单
		// 公众号及商户相关参数
		String appid = "wxbd2420d3a7c050d6";
		
		// String Uri = "http://aric.tunnel.qydev.com/CompetitionRegistration/TopayServlet";
		// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理 
		String Uri = "http://www.usgame.cn/CompetitionRegistration_V2/TopayServlet";
		 
		// 授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
		// 最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
		// 比如 Sign = %3D%2F%CS% 
		String orderNo = appid + Sha1Util.getTimeStamp();
		
		Uri = Uri+"?userId=yousailexue&orderNo="+orderNo+"&describe=yousailexue&money="+money;
		
		//URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
		String backUri = URLEncoder.encode(Uri);
		//scope 参数视各自需求而定，这里用scope=snsapi_base 不弹出授权页面直接授权目的只获取统一支付接口的openid
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + 
			   "appid=" + appid +
			   "&redirect_uri=" +
			    backUri +
			    "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		System.out.println("MainServlet--url:" + url);
		response.sendRedirect(url);
	}
	
}
