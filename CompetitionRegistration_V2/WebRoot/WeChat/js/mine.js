$(document).ready(function(){
	if(baruserid!=0){
		$(".exit").show();
		GetUserInfobyid();
	}
	//定义下面菜单栏的字体颜色
	$(".gotoMine").css("color","#0075c3");
});


//得到用户信息
function GetUserInfobyid() {
	$.ajax({
		type: "GET",
		url: "./GetUserInfoByIdServlet",
		data:{UserId:baruserid},
		dataType: "json",
		success: function(json){
			
			if(json.result.userPicture==null||json.result.userPicture==""){
				$("#imgWeChat").hide();
				$(".user-pic").css({"background-image":"url('WeChat/image/tx1.png')"});
				$(".user-pic").css({"background-size":"100% 100%"});
		    }
			else{
				$("#imgWeChat").hide();
				$(".user-pic").css({"background-image":"url('"+json.result.userPicture+"')"});
				$(".user-pic").css({"background-size":"100% 100%"});
			}
			
			if(json.result.userNickname==null||json.result.userNickname==""){
				$(".log").html(
					'<div class="user_name">暂无昵称</div>');
			}
			else{
				$(".log").html(
					'<div class="user_name">'+json.result.userNickname+'</div>');
			}
			
			
		}
		});
}


/**
 * 跳转到登录界面
 */
function turntologin(){

		window.location.href="WeChat/jsp/logins.jsp";
}
/**
 * 跳转到注册界面
 */
function turntoregister(){

		window.location.href="WeChat/jsp/registers.jsp";
}


/**
 * 跳转到我的收藏界面
 */
function turntoMyCollection(baruserid){
	if(baruserid!=0){	
		window.location.href="WeChat/jsp/MyCollection.jsp?baruserid="+baruserid;
	}	
	else{
		window.location.href="WeChat/jsp/logins.jsp";
	}
}
/**
 * 我的比赛
 */
function gotosearch(){
	if(baruserid!=0){
		window.location.href="WeChat/jsp/myMatch.jsp?baruserid="+baruserid;
	}
	else{
		window.location.href="WeChat/jsp/logins.jsp";
	}
}

//跳转到已报名比赛
function goenroll_com(){
	if(baruserid!=0){
		window.location.href="WeChat/jsp/EnrollCompetition.jsp";
	}
	else{
		window.location.href="WeChat/jsp/logins.jsp";
	}
}

//跳转到修改资料
function ChangemineInfo() {
	if(baruserid!=0){
		window.location.href="WeChat/jsp/revisedata.jsp?userId="+baruserid;
	}
	else{
		window.location.href="WeChat/jsp/logins.jsp";
	}
}

//退出登录
function Exit() {
	if(confirm("确定退出登录吗？")){
		$.getJSON("./ExitLoginServlet",function(json){
			if(json.result==true){
				alert("退出成功！");
				window.location.href="WeChat/jsp/mine.jsp";
			}
			else{
				alert("退出未成功，请重试");
			}
		});
	}
}

//跳转到扫面二维码
function gotoQRcode(){
	window.location.href="WeChat/jsp/QRcode.jsp";
}


//跳转到意见反馈界面
function gotoFeddback() {
	if(baruserid!=0){
		window.location.href="WeChat/jsp/feedback.jsp";
	}
	else{
		window.location.href="WeChat/jsp/logins.jsp";
	}
	
}

//跳转到报名使用帮助
function gotohelp(){
	window.location.href="WeChat/jsp/help.jsp";
}