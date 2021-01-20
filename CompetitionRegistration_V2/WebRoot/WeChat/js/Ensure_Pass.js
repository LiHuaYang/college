$(document).ready(function(){
});


//通过用户手机号码改变用户密码
function sure_change(){
	var pass_new=$("#phone_new").val();
	var pass_again=$("#phone_again").val();
	
	if (pass_new != pass_again) {
		alert("您输入的密码不一致，请重试！");
		return ;
	}

	$.ajax({
		type: "GET",
		url: "./UserChangePasswordByUserphoneServlet",
		data:{UserPhone:phone,UserPassage:pass_new},
		dataType: "json",
		success: function(json){
			alert("成功修改密码!");
			window.location.href="WeChat/jsp/mine.jsp";
		}
	})
}