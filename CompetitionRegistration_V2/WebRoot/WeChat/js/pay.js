$(document).ready(function(){
	alert("111");
});

//调用支付接口getBrandWCPayRequest，发起支付请求,需要如下6个参数
function onBridgeReady(){
		WeixinJSBridge.invoke(
   	  	'getBrandWCPayRequest',{
       	"appId":"wxbd2420d3a7c050d6",     //公众号名称，由商户传入     
       	"timeStamp":"1395712654",         //时间戳，自1970年以来的秒数     
       	"nonceStr":"e61463f8efa94090b1f366cccfbbb444", //随机串     
       	"package":"prepay_id=u802345jgfjsdfgsdg888",     
       	"signType":"MD5",         //微信签名方式：     
      	"paySign":"70EA570631E4BB79628FBCA90534C63FF7FADD89" //微信签名 
   		},
   		function(res){     
       		if(res.err_msg == "get_brand_wcpay_request：ok" ) {
       		 	alert("微信支付成功!"); 
           	}     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
       		else{
       			alert("支付功能未开发完善");
       		}
   		}
		); 
}
if (typeof WeixinJSBridge == "undefined"){
		if( document.addEventListener ){
   		document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
		}else if (document.attachEvent){
   		document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
   		document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
}else{
	 	onBridgeReady();
}
