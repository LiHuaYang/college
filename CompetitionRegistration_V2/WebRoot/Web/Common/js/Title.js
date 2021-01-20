$(document).ready(function(){
	if(userid!=0){
		$(".Operationbefore").hide();
		$(".Operationlater").append(
			'<div class="myInfo" onclick="Go_My()">我的信息</div>'+
			'<div class="myback" onclick="exitlongin()">退出</div>'
				);
	}
	
	
});

//登录
function Login() {
	
	var account = $(".Accounttext").val();
	var password = $(".LoginPasswordtext").val();
	
	$.ajax({
		type: "GET",
		url: "./UserLogin",
		data: {UserPhone: account, Password:password},
		dataType: "json",
		success: function(json){
			if(json.result==true){
				alert("登录成功");
				window.location.reload();
			}
			else{
				alert("登录失败，账号或者密码错误！");
			};
		}
	});
}

//退出登录
function exitlongin() {
	if(confirm("确定退出登录吗？")){
		$.getJSON("./ExitLoginServlet",function(json){
			if(json.result==true){
				alert("退出成功！");
				window.location.href="Web/Main/jsp/Main.jsp";
			}
			else{
				alert("退出未成功，请重试");
			}
		});
	}
}


// 判断字符串是否是纯数字
function isnumeric(str, length)
{
	if (/^\d+$/.test(str) && str.length) {
		return true;
	}else{
	     return false; 
	}
}

//注册
function Rigester() {
	var UserPhone=$(".Phonetext").val(); //电话
	var UserPassword=$(".Passwordtext").val(); //电话
	var SMSNumber = $(".Verficationtext").val();//验证码
	
	if(UserPhone==null || UserPhone=="" || !isnumeric(UserPhone, 11)){
		alert("手机号码格式错误");
	}
	if(UserPassword==null||UserPassword==""){
		alert("密码不可为空");
	}
	if(SMSNumber==null||SMSNumber==""){
		alert("验证码不可为空");
	}
	
	$.ajax({
		type: "GET",
		url: "./CheckSMSNumber",
		data: {UserPhone: UserPhone, UserPassWord:UserPassword,SMSNumber:SMSNumber},
		dataType: "json",
		success: function(json){
			if(json.result==true){
				alert("注册成功,请登录");
				$(".bodymiddleLogin").show();
				$(".bodymiddleRegist").hide();
			}
			else{
				alert(json.ERR_FLAG);
			}
		}
	});
}

//获取验证码
function Verificationget(obj) {
	var UserPhone = $(".Phonetext").val(); //电话
	
	if (!isnumeric(UserPhone, 11)) {
		alert("请正确填写手机号码格式！");
		return ;
	}
	
	// 开始倒计时
	
	$.ajax({
		type: "GET",
		url: "./UserRegisterNewServlet",
		data: {UserPhone: UserPhone},
		dataType: "json",
		success: function(json){
			if (json.result==true){
// 				alert(json.message);
				time(obj);
			}
			if(json.result==false){
				alert("此账户已注册");
				return ;
			}
		}
	});
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

//注册框
function UserRigest() {
	$(".bodymiddleRegist").show();
	
	document.onkeydown=function(event){     //键盘响应事件
        var e = event || window.event || arguments.callee.caller.arguments[0];
                   
        if(e && e.keyCode==13){ // enter 键
        	
        	var UserPhone=$(".Phonetext").val(); //电话
        	var UserPassword=$(".Passwordtext").val(); //电话
        	var SMSNumber = $(".Verficationtext").val();//验证码
        	if(UserPhone!="" && UserPassword!="" && SMSNumber!=""){
        		Rigester();   //注册
        	}
        }
	}
}

function middleRegistClose() {
	$(".bodymiddleRegist").hide();
}

//登录框
function UserLogin() {
	$(".bodymiddleLogin").show();
	
	document.onkeydown=function(event){     //键盘响应事件
        var e = event || window.event || arguments.callee.caller.arguments[0];
                   
        if(e && e.keyCode==13){ // enter 键
        	var account_user=$(".Accounttext").val();
        	var pass_user=$(".LoginPasswordtext").val();
        	if(account_user!="" && pass_user!="" ){
        		Login();   //登录
        	}
        }
	}
}

function middleLoginClose() {
	$(".bodymiddleLogin").hide();
}

function gotoLoginFrame() {
	$(".bodymiddleRegist").hide();
	$(".bodymiddleLogin").show();
}

function gotoRigestFrame() {
	$(".bodymiddleRegist").show();
	$(".bodymiddleLogin").hide();
}

function gotoHome() {
	window.location.href="Web/Main/jsp/Main.jsp";
}

function gotocompetitionList() {
	var flag;
	window.location.href="Web/Competition/jsp/list.jsp?flag="+0+"";
}

//跳转到新闻页面
function gotoNews(){
	window.location.href="Web/News/jsp/NewsList.jsp";
}

//跳转试卷页面
function gotoPaper(){
	window.location.href="Web/Paper/jsp/PaperList.jsp";
}

//通过比赛名称或科目名查找
function Search_Com(){
	
	var condition;
	var Condition=$(".OperationSearchBox").val();
	window.location.href="Web/SearchCompetition/jsp/SearchCompetition.jsp?condition='"+Condition+"'";
	
}

function gotoShopping() {
	alert("此功能尚未开通");
}

//跳转到我的信息
function Go_My(){
	window.location.href="Web/User/jsp/User.jsp";
}

//跳转到手机新修改密码页面
function gotofindpassword(){
	window.location.href="Web/User/jsp/FindPassword.jsp";
	
}
