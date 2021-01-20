
function login() {
	var UserPhone = document.getElementById("account").value;
	var Password = document.getElementById("password").value;

	$.getJSON("./UserLogin", {
		UserPhone : UserPhone,
		Password : Password
	}, function(json) {
		if (json.result == true) {
//			alert("登录成功！");
			window.location.href = "WeChat/jsp/mine.jsp" ;
		} else {
			alert("登录失败！");
		}
	})
}

function registers() {
	window.location.href = "WeChat/jsp/registers.jsp";
}
function find() {
	window.location.href = "WeChat/jsp/ForgetPass_One.jsp";
}
