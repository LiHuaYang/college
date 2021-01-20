function Login(){
	var ManagerAccount=$(".name input").val();
	var ManagerPassword=$(".pass input").val();

	
	$.getJSON("./WManagerLoginServlet",{
		ManagerAccount:ManagerAccount,
		ManagerPassword:ManagerPassword
	},function(outjson){
		if(outjson.Check==true){
			alert("登录成功");
			window.location.href="jsp/adminjsp/main.jsp"
		}else if(outjson.Check==false){
			alert("账户名或密码错误，登录失败");
		}
	})
}