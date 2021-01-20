//注册
function register() {
	var phonenumber = $("#phonenumber").val();
	var password = $("#password").val();
	var confirm_pw = $("#confirm_pw").val();
	if(password!=confirm_pw) {
		showdialog1();
	}
	else {
		$.post("../UserServlet", {
			method : "register",
			phone :phonenumber,
			password : password,
			yanzhengma : $('#yanzhengma').val()
		}, function(json) {
			var data = JSON.parse(json);
			if(data.msg==true) {
				window.location.href = "geren.html";
			}
			else {
				$("#tishi").text(data.other);
				showdialog2();
			}
		});
	}
}

function getTest() {
	var phonenumber = $("#phonenumber").val();
	$.post("../UserServlet", {
		method : "RCAPTCHA",
		phone :phonenumber,
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		if(data.msg==true) {
			countdown();
		}
	});
}
//倒计时60秒
var i=60;
function countdown () {
    document.getElementById("verification").innerHTML = i+"s";
    i--;
    if(i>0) {
    	setTimeout("countdown()",1000);
    }
    if(i==0) {
    	document.getElementById("verification").innerHTML = "<a href='javascript:getTest()' >| 获取验证码</a>";
    	i=60;
    }
	
}
function showdialog1 () {
	$("#dialog1").show();
}
function showdialog2 () {
	$("#dialog2").show();
}
function tozhuce () {
	$("#dialog1").hide();
	window.location.href = "zhuce.html";
}
