<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>付款</title>
<script type="text/javascript" src="../common/jquery-1.11.1.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<script type="text/javascript">

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}


$(document).ready(function(){
	var js_app_id = getUrlParam("appId");
	var js_timestamp = getUrlParam("timestamp");
	var js_nonceStr = getUrlParam("nonceStr");
	var js_signature = getUrlParam("signature");
	var js_package = getUrlParam("package");
	var js_paySign = getUrlParam("paySign");
	// 
	wx.config({
   	    debug: false,
   	    appId: js_app_id,
   	    timestamp: js_timestamp,
   	    nonceStr : js_nonceStr ,
   	    signature: js_signature,
   	    jsApiList: ["chooseWXPay"]
   	});
	
	wx.ready(function(){
	 wx.chooseWXPay({
	        timestamp : js_timestamp,
	        nonceStr : js_nonceStr,
	        package : js_package,
	        signType : "MD5", // 注意：新版支付接口使用 MD5 加密
	        paySign : js_paySign,
	        success: function (res) {
	        	show();
	            //wx.log(res.err_msg);
		       // if(res.err_msg == "get_brand_wcpay_request:ok"){ 
		       // 	 alert("微信支付成功!"); 
		       // 	 show();
		       // 	// window.location.href = "www.baidu.com";
		       //   } else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
			  //           alert("用户取消支付!");  
		      //  } else{  
		       //      alert("支付失败!");  
		      //  } 
		        
		        window.location.href = "baoming.html";// 跳转到个人已经报名界面
	         },
	  		cancel:function(res) {
	             // alert("取消支付");
	  			window.history.go(-2); // 后退两页
	        },
	         fail:function(res) {
	        	 alert("支付失败！");
	        	 window.history.go(-2); // 后退两页
	         }
	     });
	});
});
function show() {
	 $('#dialog2').show().on('click', '.weui_btn_dialog', function () {
	 $('#dialog2').off('click').hide();
	 });
	 } 
</script>
</head>

<body>
	
	<div class="weui_dialog_alert" id="dialog2" style="display: none;">
	<div class="weui_mask"></div>
	<div class="weui_dialog">
		<div class="weui_dialog_hd">
			<strong class="weui_dialog_title">优赛乐学</strong>
		</div>
		<div class="weui_dialog_bd">付款成功！</div>
		<div class="weui_dialog_ft">
			<a href="geren.html" class="weui_btn_dialog primary">确定</a>
		</div>
	</div>
</div>
</body>
</html>