	function getyzm(obj) {
		var UserPhone=document.getElementById("phone").value;
		
		if(UserPhone.length != 11) {
			alert("手机号码填写有误！");
			return ;
		}
		$.getJSON("./UserRegisterNewServlet",{
			UserPhone:UserPhone},function(json){
				// var jsonObject = JSON.parse(json); 
			
				// alert(json.result);
			 	if(json.result == false && json.message == "1") {
			 		alert("此手机已经注册！");
			 	}
			 	if (json.result == false && json.message == "2") {
			 		alert("验证码发送失败！");
			 	}
				if(json.result == true){
					time(obj);
				alert("请注意查收验证码！");
			}			
		})
	}
	
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
	function register() {
		var UserPhone=document.getElementById("phone").value;
		var UserPassword=document.getElementById("password").value;	
		var SMSNumber=document.getElementById("identify").value;	
	
		if (UserPhone.length !=11 && UserPassword.length<=0 && SMSNumber.length<=6) {
			alert("信息填写有误，核对后再次注册");
			return ;
		}
		$.getJSON("./CheckSMSNumber",{
			UserPhone:UserPhone,
			UserPassWord:UserPassword,
			SMSNumber:SMSNumber},function(json){
				// var contact = JSON.parse(json); 
				if (json.result == true) {
					alert("注册成功！");
				}
				if(json.result == false) {
					alert("注册失败！");
				}
				window.location.href="WeChat/jsp/logins.jsp";
		})
}
	
	
	
	
	
	



	