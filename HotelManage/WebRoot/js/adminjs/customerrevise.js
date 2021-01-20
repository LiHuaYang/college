$(document).ready(function() {
	readyUser(UserId3);
});
function back(){
	window.location.href="jsp/adminjsp/main.jsp";

}
function readyUser(UserId){
	$.getJSON("./WGetSingelUserServlet",{
		UserId:UserId
	},function(json){
		var UserId = json.userId;
		var UserName = json.userName;
		var UserBalance = json.userBalance;
		var UserPassword = json.userPassword;
		var UserPicture = json.userPicture;
		var UserPhone = json.userPhone;
		var UserEmail = json.userEmail;
		var UserBoth = json.userBoth;
		var UserIDNumber = json.userIDNumber;
		var UserVIP = json.userVIP;
		var UserState = json.userState;
		var UserSex = json.userSex;
		var UserMessage = json.userMessage;
		$("#UserId").val(UserId);
		$("#UserName").val(UserName);
		$("#UserBalance").val(UserBalance);
		$("#UserPassword").val(UserPassword);
		$("#UserPicture").attr("src",UserPicture);
		$("#UserPhone").val(UserPhone);
		$("#UserEmail").val(UserEmail);
		$("#UserBoth").val(UserBoth);
		$("#UserIDNumber").val(UserIDNumber);
		if(UserVIP==1){
			$("#UserVIP_yes").attr("selected","selected");//是vip
		}
		if(UserVIP==0){
			$("#UserVIP_no").attr("selected","selected");//不是vip
		}
		if(UserState==0){
			$("#UserState_on").attr("selected","selected");//激活
		}
		if(UserState==1){
			$("#UserState_lock").attr("selected","selected");//锁定
		}
		if(UserSex == "男"){
			$("#UserSex_nan").attr("selected","selected");//男
		}
		if(UserSex == "女"){
			$("#UserSex_nv").attr("selected","selected");//女
		}
		$("#UserMessage").html(UserMessage);
	});
}
function ChangeUser(){
	var UserId=$("#UserId").val();
	var UserName = $("#UserName").val();
	var UserBalance = $("#UserBalance").val();
	var UserPassword = $("#UserPassword").val();
	var UserPicture = $("#UserPicture").val();
	var UserPhone = $("#UserPhone").val();
	var UserEmail = $("#UserEmail").val();
	var UserBoth = $("#UserBoth").val();
	var UserIDNumber = $("#UserIDNumber").val();
	var UserVIP = $("#UserVIP").val();
	var UserState = $("#UserState").val();
	var UserSex = $("#UserSex").val();
	var UserMassage = $("#UserMassage").val();
	$.getJSON("./WChangeUserServlet",{
		UserId:UserId,
		UserName:UserName,
		UserBalance:UserBalance,
		UserPassword:UserPassword,
		UserPicture:UserPassword,
		UserPhone:UserPhone,
		UserEmail:UserEmail,
		UserBoth:UserBoth,
		UserIDNumber:UserIDNumber,
		UserVIP:UserVIP,
		UserState:UserState,
		UserSex:UserSex,
		UserMassage:UserMassage,
	},function(jsonObject){
		if(jsonObject.result){
			alert("修改客户成功");
		}
		else{
			alert("修改客户失败");
		}
	});
}
