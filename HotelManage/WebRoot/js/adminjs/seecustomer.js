$(document).ready(function() {
	readyUser(UserId3);
	lockInfo();
});
function back(){
	window.location.href="jsp/adminjsp/main.jsp";
//	alert("1");
//	toloadmainclient(1);
}

function lockInfo(){
	$("#UserId").attr("disabled","disabled");
	$("#UserName").attr("disabled","disabled");
	$("#UserBalance").attr("disabled","disabled");
	$("#UserPassword").attr("disabled","disabled");
	$("#UserPicture").attr("disabled","disabled");
	$("#UserPhone").attr("disabled","disabled");
	$("#UserEmail").attr("disabled","disabled");
	$("#UserBoth").attr("disabled","disabled");
	$("#UserIDNumber").attr("disabled","disabled");
	$("#UserVIP").attr("disabled","disabled");
	$("#UserState").attr("disabled","disabled");
	$("#UserSex").attr("disabled","disabled");
	$("#UserMessage").attr("disabled","disabled");
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
		var UserMassage = json.userMessage;
		$("#UserId").val(UserId);
		$("#UserName").val(UserName);
		$("#UserBalance").val(UserBalance);
		$("#UserPassword").val(UserPassword);
		$("#UserPicture").attr("src",UserPicture);
		$("#UserPhone").val(UserPhone);
		$("#UserEmail").val(UserEmail);
		$("#UserBoth").val(UserBoth);
		$("#UserIDNumber").val(UserIDNumber);
		$("#UserMessage").html(UserMassage);
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
		$("#UserMassage").html(UserMassage);
	});
}