function login() {
	var userroll=$(".login-bottom2 input").eq(0).val();
	var password=$(".login-bottom2 input").eq(1).val();
	var json={
			"userRoll":userroll,
			"userPassword":password
	}
	$.getJSON("./LoginServlet",{json:JSON.stringify(json)},function(json){
		if (json.result==0) {
			alert("无该用户！")
		}else if (json.result==-1) {
			alert("密码错误")
		}else {
			alert("登录成功")
			window.location.href="jsp/main.jsp";
		}
		
	})
}