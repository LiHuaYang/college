

function register () {
	
	var id = $("#id").val(); 
	var nickname = $("#nick").val();
	var password = $("#pw").val();
	var passwod2 = $("#pwRp").val();
	var school = $("#sc").val();
	var email = $("#em").val();
	
	// 值是否为空验证
	if (id=="" || password=="" || passwod2=="") {
		alert("值不能为空");
		return ;
	}
	// 没有输入任何东西
	if (email=="") {
		email = null;
	}
	if (school=="") {
		school = null;
	}
	// 学号长度验证
	
	// 邮箱格式验证
	
	// 密码长度验证
	
	// 提交
	$.post("../../UserActionV2",{ 
		"id" : id, "password":password, "password2":passwod2, "school":school, "nickname":nickname,"email":email, "method":"register"},
		function(data) {
			var obj = JSON.parse(data);
			if (obj.res=="true") {
				alert(obj.msg);
				window.location.href="problem_list.html"; 
			} else {
				alert(obj.msg);
			}
		}
	);
}
