function login() {
	var ar=[];
    $("#stu_pass").each(function(){
        ar.push($(this).val());
    });
    var a=ar[0];
	var json = {
			"username" : $("#username").val(),
			"password" :a
		// 初始化为当前页数
		};
	var data=0;
	$.getJSON("./AdminLogin", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		data = jsonObject;
		if(data==1){
			window.location.href="Admin/CompetitionManage/jsp/ContestList.jsp";
		}
		else {
			alert("您的账号密码有误");
		}
	});
}