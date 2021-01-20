$(document).ready(function(){
});


// 判断字符串是否为纯数字
function isnumeric(str)
{
	// var patrn=/^\d$/; 
	if (/^\d+$/.test(str)) {
	    // alert("内容不能全为数字");
		return true;
	}else{
	     return false; 
	}
}

//申请人手机号码
var applicanterPhone = null;
// 输入手机号码，获取验证码
function getyanz(obj) {
	
	var UserPhone = $("#phone").val();
	if (isnumeric(UserPhone) && UserPhone.length == 11) {
		applicanterPhone = UserPhone;
		$.getJSON("./FoundBackPassWord", {
			CommendType : "1",
			UserPhone : UserPhone
		}, function(jsonObject) {
			if(jsonObject.message==0){
				alert("您还未注册过");
				window.location.href="WeChat/jsp/registers.jsp";
				return;
			}
			if(jsonObject.result) {
				time(obj);
				alert("验证码已发送，注意接收"); // 验证成功
			}
		});
	}
	else {
		alert("您输入的手机号码有误");// 验证失败，给出提示
	}
}

//下一步
function next_step(){
	
	var SMSNumber = $("#identify").val();     //验证码
	var userPhone = $("#phone").val();          //手机号
	var ERROR_FLAG = null;
	
	if (SMSNumber.length != 6) {
		ERROR_FLAG = "您输入的验证码长度错误！";
		alert(ERROR_FLAG);
		return ;
	}
	if (userPhone != applicanterPhone) {
		ERROR_FLAG = "您输入的手机号码有误！";
		alert(ERROR_FLAG);
		return ;
	}
	$.getJSON("./FoundBackPassWord", {
		CommendType : "2",
		UserPhone : userPhone,
		SMSNumber : SMSNumber
	}, function(jsonObject) {
		if(jsonObject.result) {
			window.location.href="WeChat/jsp/Ensure_Pass.jsp?phone='"+userPhone+"' ";  // 验证成功，显示下一步界面
		
		}
		else {
			alert(jsonObject.ERR_FLAG); // 验证失败，给出提示
		}
	});
}

//60秒后收到验证码
var wait=60; 
function time(obj) {  
    if (wait == 0) {  
    	obj.removeAttribute("disabled");            
	obj.value="免费获取验证码";  
    wait = 60;  
} else {  
	obj.setAttribute("disabled", true);  
	obj.value="重新发送(" + wait + ")";    
        wait--;  
        setTimeout(function() {  
            time(obj)  
        },  
        1000)  
    }  
} 