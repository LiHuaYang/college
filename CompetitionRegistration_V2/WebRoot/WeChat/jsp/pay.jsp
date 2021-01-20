<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.Tool.CommonUtil"%>
<%@ page import="com.Tool.SHA1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String appId = request.getParameter("appid");				//公众号id
	String timeStamp = request.getParameter("timeStamp");		//时间戳
	String nonceStr = request.getParameter("nonceStr");			//随机字符串
	String packageValue = request.getParameter("package");		//订单详情扩展字符串
	String paySign = request.getParameter("sign");				//签名

	// 获得ticket生成signature
	String ticket = CommonUtil.getToken();
	String str = "jsapi_ticket="+ticket+"&noncestr="+nonceStr+"&timestamp="+timeStamp+"&url="+"http://www.usgame.cn/CompetitionRegistration_V2/WeChat/jsp/pay.jsp";
	// String str = "jsapi_ticket="+ticket+"&noncestr="+nonceStr+"&timestamp="+timeStamp+"&url="+"http://aric.tunnel.qydev.com/CompetitionRegistration/WeChat/jsp/pay.jsp";
	String signature = new SHA1().getDigestOfString(str.getBytes()); 
	System.out.println("JSP页面signature"+signature);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>付款</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="Common/iconfont/iconfont.css"type="text/css">
	
	<style type="text/css">
		#pay {
			width:80px;
			height:46px;
			font-size:20px;
			font-family:'微软雅黑';
			margin:0 auto;
			display:block;
			margin-top:60px;
		}
	</style>
	<script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript">
	function pay(){
	    wx.config({
	   	    debug: false,
	   	    appId: "<%=appId%>",
	   	    timestamp: "<%=timeStamp%>",
	   	    nonceStr: "<%=nonceStr%>",
	   	    signature: "<%=signature%>",
	   	    jsApiList: ["chooseWXPay"]
	   	});
	    wx.chooseWXPay({
	        timestamp: "<%=timeStamp%>",
	        nonceStr: "<%=nonceStr%>",
	        package: "<%=packageValue%>",
	        signType: "MD5", // 注意：新版支付接口使用 MD5 加密
	        paySign: "<%=paySign%>",
	        success: function (res) {
	            wx.log(res.err_msg);
		        if(res.err_msg == "get_brand_wcpay_request:ok"){ 
		        	alert("微信支付成功!");  
		        }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
			            alert("用户取消支付!");  
		        }else{  
		            alert("支付失败!");  
		        }  
	         },
	  		cancel:function(res) {
                 alert("取消支付");
	        }
	     });
	};
	</script>
   </head>
  <body>
  	<div class="wrap">	
 		<button id="pay" class="submit" onclick="pay()">开始付款</button>
 	</div>
  </body>
</html>
