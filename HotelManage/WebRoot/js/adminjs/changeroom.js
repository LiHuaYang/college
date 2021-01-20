var RoomId1 = 0;
$(document).ready(function() {
//	$(".heads").load("jsp/common/adminbar.jsp");
//	var RoomId = $("#RoomId").val();
//	RoomId1 = RoomId;
//	readyroom(RoomId);
	
	// ChangeRoom();
}) ;

function back(){
	window.location.href="jsp/adminjsp/main.jsp";
}


function ChangeRoom(){
	var RoomId = $("#infoId").html();
	var RoomPwd = $("#infopwd").val();//房间密码
	var RoomPrice = $("#inforoomprice").val();
	var RoomType = jQuery("#selectRoomType  option:selected").val();
	
	alert(RoomId);
	alert(RoomPwd);
	alert(RoomPrice);
	alert(RoomType);
	
	$.getJSON("./AdminModifyARoom",{
		RoomId:RoomId,
		RoomPwd:RoomPwd,
		RoomPrice:RoomPrice,
		RoomType:RoomType
	},function(jsonObject){
//		if(jsonObject){
//			alert("修房间成功");
//		}
//		else{
//			alert("修改失败");
//		}
		alert(jsonObject);
	});
}
