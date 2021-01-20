$(document).ready(function(){
	showflist($(".f-bar-m").eq(0));
	 getalluser();
	 opentimechats();
})
var allusername;
function getalluser() {
	$.getJSON("./getAllUserName",function(json){
		allusername=json;
	})
	
}
//通过ID查询用户名
function getusername(userid) {
	for ( var i = 0; i <allusername.length; i++) {
		if (userid==allusername[i].userId) {
			return allusername[i].userName;
		}
	}
}
function getuserpic(userid) {
	for ( var i = 0; i <allusername.length; i++) {
		if (userid==allusername[i].userId) {
			return allusername[i].userPic;
		}
	}
}
var myuserid=2;
var myfriend;
var otherId=0;
function showflist(x) {
	$(".f-bar-m").css("background-color","white");
	$(".f-bar-m").eq(1).find(".iconfont").css("color","#fb5721");
	$(".f-bar-m").eq(2).find(".iconfont").css("color","#51210d");
	$(x).css("background-color","#fcd947");
	$(x).find(".iconfont").css("color","white");
	
	showmyfriend();
	$(".f-list").show();
	$(".s-list").hide();
	$(".c-list").hide();
}
function showslist(x) {
	$(".f-bar-m").css("background-color","white");
	$(".f-bar-m").eq(0).find(".iconfont").css("color","#fcd947");
	$(".f-bar-m").eq(2).find(".iconfont").css("color","#51210d");
	$(x).css("background-color","#fb5721");
	$(x).find(".iconfont").css("color","white");
	
	$(".s-list").show();
	$(".f-list").hide();
	$(".c-list").hide();
}
function showclist(x) {
	$(".f-bar-m").css("background-color","white");
	$(".f-bar-m").eq(0).find(".iconfont").css("color","#fcd947");
	$(".f-bar-m").eq(1).find(".iconfont").css("color","#fb5721");
	$(x).css("background-color","#51210d");
	$(x).find(".iconfont").css("color","white");
	
	$(".c-list").show();
	$(".s-list").hide();
	$(".f-list").hide();
	showmakeinfo();
}

//显示我的好友
function rightf() {
	$(".rightf").css("right","250px");
	$(".friendlist"). fadeIn(200);
	$("#c").html("&#xf016d;");
	$(".rightf").attr("onclick","leftf()");
}

//影藏我的好友
function leftf() {
	$(".rightf").css("right","0px");
	$(".friendlist").fadeOut(200);
	$("#c").html("&#xf016e;");
	$(".rightf").attr("onclick","rightf()");
}
//获取好友
function showmyfriend() {
	var json={
			"userId":myuserid
	}
	$(".f-list").html("");
	$.getJSON("./GetFriendsByUserId",{json:JSON.stringify(json)},function(json){
		myfriend=json;
		for ( var i = 0; i < json.length; i++) {
			$(".f-list").append('<div class="f-one">'+
   					'<div class="f-one-pic" style="background-image:url('+json[i].friendPic+')"></div>'+
   					'<div class="f-one-name">'+json[i].friendName+'</div>'+
   					'<div class="f-one-bu">'+
   						'<i class="iconfont" style="float:left;font-size: 20px;padding: 15px;cursor: pointer;border-left: 1px dashed rgb(200,200,200);" onclick="opeanchats('+json[i].friendId+')">&#xf0132;</i>'+
   						'<i class="iconfont" style="float:left;font-size: 20px;padding: 15px;cursor: pointer;border-left: 1px dashed rgb(200,200,200);"  onclick="deletefriend('+json[i].friendId+')">&#xf0155;</i>'+
   					'</div>'+
   				'</div>')
		}		
	})


}
//删除好友
function deletefriend(x) {
	if (confirm("你确信要删除此好友吗？"))

	{
		var json = {
			"userId" : myuserid,
			"friendId" : x
		}
	$.getJSON("./DeleteFriend",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("删除成功")
			showmyfriend();
		}else {
			alert("删除失败")
		}
	})
	} else {

	}
}
//判断是否为好友
function isfriend(friendid) {
	for ( var i = 0; i < myfriend.length; i++) {
		if (friendid==myfriend[i].friendId) {
			return true;
		}
	}
	return false;
}

//搜索用户
function searchuser() {
	var susername=$(".searchf").val();
	if (susername=="") {
		alert("请输入用户名")
	}else{
		var json = {
				"userName" : susername
			}
		$.getJSON("./SearchUser",{json:JSON.stringify(json)},function(json){
			showslist($(".f-bar-m").eq(1));
			$(".s-list").html("");
			for ( var i = 0; i < json.length; i++) {
				var text='<i class="iconfont" style="float:left;font-size: 20px;padding: 15px;cursor: pointer;border-left: 1px dashed rgb(200,200,200);"  onclick="makefriend('+json[i].userId+')">&#xf014d;</i>';
				if (isfriend(json[i].userId)) {
					text='<div style="height:32px;width:50px;text-align:center;float:left;font-size: 12px;padding-top: 18px;cursor: pointer;border-left: 1px dashed rgb(200,200,200);">好友</div>'
				}
				$(".s-list").append('<div class="f-one">'+
	   					'<div class="f-one-pic" style="background-image:url('+json[i].userPic+')"></div>'+
	   					'<div class="f-one-name">'+json[i].userName+'</div>'+
	   					'<div class="f-one-bu" style="width:51px">'+
	   						text+
	   					'</div>'+
	   				'</div>')
			}
			
		})
	}
}
//申请成为好友
function makefriend(x) {
	var json = {
			"userId" : myuserid,
			"friendId":x
	}
	$.getJSON("./ApplyFriend",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("已发送请求")
			showmyfriend();
		}else {
			alert("申请失败")
		}
	})	
	
}
//显示用户结交信息
function showmakeinfo() {
	var json = {
			"userId" : myuserid
	}
	$.getJSON("./GetApplyFriend",{json:JSON.stringify(json)},function(json){
		$(".c-list").html("");
		for ( var i = 0; i < json.length; i++) {
			var username=getusername(json[i].userId);
			$(".c-list").append('<div class="f-one">'+
   					'<div class="f-one-name">'+username+'</div>'+
   					'<div class="f-one-bu">'+
						'<i class="iconfont" style="float:left;font-size: 20px;padding: 15px;cursor: pointer;border-left: 1px dashed rgb(200,200,200);"onclick="tobefriend('+json[i].userId+',this)">&#xf0156;</i>'+
						'<i class="iconfont" style="float:left;font-size: 20px;padding: 15px;cursor: pointer;border-left: 1px dashed rgb(200,200,200);"  onclick="refusefriend('+json[i].userId+',this)">&#xf0155;</i>'+
					'</div>'+
   				'</div>')
		}
	})
}
//成为好友
function tobefriend(userId,x) {
	var json = {
			"userId" : myuserid,
			"friendId":userId
	}

	$.getJSON("./TobeFriend",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("你与该用户成为好友")
			showmyfriend();
			$(x).parent().parent().remove();
		}else {
			alert("无法成为好友")
		}
	})
}
//拒绝成为好友
function refusefriend(userId,x) {
	var json = {
			"userId" : myuserid,
			"friendId":userId
	}

	$.getJSON("./RefuseTobeFriend",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("拒绝成功")
			$(x).parent().parent().remove();
		}else {
			alert("拒绝失败")
		}
	})
}
//打开聊天窗口
function opeanchats(friendId) {
	$(".chats").show();
	$(".chats-people-pic").css("background-image","url("+getuserpic(friendId)+")")
	$(".chats-people-name").html(getusername(friendId));
	$(".ppps").html(getusername(friendId));
	$(".x").eq(1).attr("onclick","sentchats("+friendId+")");
	otherId=friendId;
	 getchats();
}

//关闭聊天窗口
function closechats() {
	$(".chats").hide();
	otherId=0;
}
//发送消息
function sentchats(reciveId) {
	var text=$(".chat-send-text").html();
	if (text=="") {
		alert("请输入文字");
		$(".chat-send-text").focus();
	}else {
		var json={
				"CreateId":myuserid,
				"ReciverId":reciveId,
				"Content":text
				
		}
	}
	$.getJSON("./SendChat",{json:JSON.stringify(json)},function(json){
	if (json.result==true) {
		$(".chat-send-text").html("");
		$(".chat-show").append('<div class="my"><div class="mtext"><div>'+text+'</div></div><div class="photo" style="background-image:url('+getuserpic(myuserid)+')"></div></div>')
	}else {
		alert("发送失败")
	}
})
}
//开启定时查询聊天
function opentimechats() {
	if (otherId!=0) {
		getchats();
		setTimeout("opentimechats()", 5000);  
	}
}

//获取聊天
function getchats() {
	var json={
			"CreateId":otherId,
			"ReciverId":myuserid,
	}
	$.getJSON("./GetPeopleChats",{json:JSON.stringify(json)},function(json){
		$(".chat-show").html("");
		for ( var i = 0; i < json.length; i++) {
			if (myuserid==json[i].reciverId) {
				$(".chat-show").append('<div class="he"><div class="photo" style="background-image:url('+getuserpic(otherId)+')"></div><div class="ctext"><div>'+json[i].content+'</div></div></div>')


			}else {
				$(".chat-show").append('<div class="my"><div class="mtext"><div>'+json[i].content+'</div></div><div class="photo" style="background-image:url('+getuserpic(myuserid)+')"></div></div>')
			}
		}
		
	})
}
