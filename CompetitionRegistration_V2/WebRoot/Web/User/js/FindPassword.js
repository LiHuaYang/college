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
// 申请人手机号码
var applicanterPhone = null;
// 输入手机号码，获取验证码
function getyanz(obj) {
	var UserPhone = $("#user_phone").val();
	//alert(UserPhone.length);
	if (isnumeric(UserPhone) && UserPhone.length == 11) {
		applicanterPhone = UserPhone;
		$.getJSON("./FoundBackPassWord", {
			CommendType : "1",
			UserPhone : UserPhone
		}, function(jsonObject) {
			if(jsonObject.result) {
				publish(obj); // 验证成功，显示下一步界面
			}
		});
	}
	else {
		alert("您输入的手机号码有误");// 验证失败，给出提示
	}
}


function send_check_number(obj) {
	// var flag = true;
	var SMSNumber = $("#SMSNumber_input").val();
	var UserPhone = $("#UserPhone_input").val();
	var ERROR_FLAG = null;
	
	if (SMSNumber.length != 6) {
		ERROR_FLAG = "您输入的验证码长度错误！";
		alert(ERROR_FLAG);
		return ;
	}
	if (UserPhone != applicanterPhone) {
		ERROR_FLAG = "您输入的手机号码有误！";
		alert(ERROR_FLAG);
		return ;
	}
	$.getJSON("./FoundBackPassWord", {
		CommendType : "2",
		UserPhone : UserPhone,
		SMSNumber : SMSNumber
	}, function(jsonObject) {
		if(jsonObject.result) {
			publish(obj);  // 验证成功，显示下一步界面
		
		}
		else {
			alert("您输入的验证码有误，请修改后重新提交！"); // 验证失败，给出提示
		}
	});
}

//通过用户手机号码改变用户密码
function ChangeUserPassword(){
	var UserPhone = $("#UserPhone_input").val();
	var UserPassage=$("#Userpass").val();
	var UserPassword=$("#sure-Userpass").val();
	   
	if (UserPassage != UserPassword) {
		ERROR_FLAG = "您输入的密码不一致，请重试！";
		alert(ERROR_FLAG);
		return ;
	}

	$.ajax({
		type: "GET",
		url: "./UserChangePasswordByUserphoneServlet",
		data:{UserPhone:UserPhone,UserPassage:UserPassage},
		dataType: "json",
		success: function(json){
			alert("成功修改密码!");
			
		}
	})
}


function publish(obj) {
	switch (obj.id) {
	case "first":
		$("#firstcontent").hide();
		$("#secondcontent").show();
		break;
	case "second":
		$("#secondcontent").hide();
		$("#thirdcontent").show();
		break;
	}
}
function publish2(obj) {
	switch (obj.id) {
	case "second":
		$("#secondcontent").hide();
		$("#firstcontent").show();	
		break;
	case "third":
		$("#thirdcontent").hide();
		$("#secondcontent").show();
		break;
	}
}