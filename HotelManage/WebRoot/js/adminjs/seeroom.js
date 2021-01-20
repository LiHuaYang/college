

// 
$(document).ready(function() {
	getRoomDetailInfo();
});

//获取地址栏中的参数
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) 
		return unescape(r[2]); 
	return null; 
}

// 获取房间的详细信息
function getRoomDetailInfo() {
	// alert(GetQueryString("参数名1"))
	var RoomId = getQueryString("RoomId");
	$.getJSON("./AdminGetARoom", {
		RoomId : RoomId,
	}, function(jsonObject) {
		var pages2 = 0;
		if (jsonObject.roomnumber <= 10) {
			pages2 = 1;
		} else {
			pages2 = parseInt(jsonObject.roomnumber / 10);// 获取当前的总页数
			if (pages2 < jsonObject.roomnumber / 10) {
				pages2 = pages2 + 1;
			}
		}
		$("#infoId").html(jsonObject.Room.roomId.toString());
		$("#infopwd").html(jsonObject.Room.roomPassword.toString());
		$("#infotype").html(jsonObject.Room.roomType.toString());
		$("#infoaddress").html(jsonObject.Room.roomNumber.toString());
		$("#infodetailaddress").html(jsonObject.Room.roomDetailAddress.toString());
		$("#inforoomprice").html(jsonObject.Room.roomUnitPrice.toString());
	});
}
/*************************************************************************************/
//function lockInfo(){
//	$("#RoomId").attr("disabled","disabled");//房间id
//	$("#RoomNumber").attr("disabled","disabled");//房间命名号
//	$("#RoomPassWord").attr("disabled","disabled");//房间密码
//	$("#RoomDetailAddress").attr("disabled","disabled");//房间详细地址
//	$("#textfield").attr("disabled","disabled");//房间图片
//	$("#RoomType").attr("disabled","disabled");//房间类型-------
//	$("#RoomUnitPrice").attr("disabled","disabled");//房间单价
//	$("#RoomUsingState").attr("disabled","disabled");//房间使用状态-------
//	$("#RoomLockState").attr("disabled","disabled");//房间锁状态------
//
//	$("#RoomMassage").attr("disabled","disabled");//房间描述
//
//	//地址信息填写
//	$("#AddressProvince").attr("disabled","disabled");//省
//	$("#AddressCity").attr("disabled","disabled");//市
//	$("#AddressVillage").attr("disabled","disabled");//区
//	//房间设备信息填写
//	$("#AirConditioner").attr("disabled","disabled");
//	$("#IndoorFirePlace").attr("disabled","disabled");
//	if(json.RoomInfo.Necessities==1){
//		$("#Necessities").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.TV==1){
//		$("#TV").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.Heating==1){
//		$("#Heating").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.Kitchen==1){
//		$("#Kitchen").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.Network==1){
//		$("#Network").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.HotTub==1){
//		$("#HotTub").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.WashingMachine==1){
//		$("#WashingMachine").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.SwimmingPool==1){
//		$("#SwimmingPool").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.DryingMachine==1){
//		$("#DryingMachine").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.Breakfast==1){
//		$("#Breakfast").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.CoatHanger==1){
//		$("#CoatHanger").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.Iron==1){
//		$("#Iron").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.WheelchairAccessible==1){
//		$("#WheelchairAccessible").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.PETFacilities==1){
//		$("#PETFacilities").attr("disabled","disabled");
//	}
//	if(json.RoomInfo.WorkingSpace==1){
//		$("#WorkingSpace").attr("disabled","disabled");
//	}
//}
//var RoomEquipmentId = 0;
//var AddressId = 0;
//var lng = 0;
//var lat = 0;
//function readyroom(RoomId){
//	$.getJSON("./WGetRoomByIdServlet",{
//		RoomId:RoomId
//	},function(json){
//		$("#RoomNumber").val(json.RoomInfo.RoomNumber);//房间命名号
//		$("#RoomPassWord").val(json.RoomInfo.RoomPassWord);//房间密码
//		$("#RoomDetailAddress").val(json.RoomInfo.RoomDetailAddress);//房间详细地址
//		lng = json.RoomInfo.RoomLongitude;//房间经度
//		lat = json.RoomInfo.RoomLatitude;//房间纬度
//		$("#textfield").val(json.RoomInfo.RoomPicture);//房间图片
//		$("#RoomType").val(json.RoomInfo.RoomType);//房间类型-------
//		$("#RoomUnitPrice").val(json.RoomInfo.RoomUnitPrice);//房间单价
//		$("#RoomUsingState").val(json.RoomInfo.RoomUsingState);//房间使用状态-------
//		$("#RoomLockState").val(json.RoomInfo.RoomLockState);//房间锁状态------
//
//		$("#RoomMassage").val(json.RoomInfo.RoomMassage);//房间描述
//		RoomId = json.RoomInfo.RoomId;
//		RoomEquipmentId = json.RoomInfo.RoomEquipmentId;
//		AddressId = json.RoomInfo.AddressId;
//
//		//地址信息填写
//		$("#AddressProvince").val(json.RoomInfo.AddressProvince);//省
//		$("#AddressCity").val(json.RoomInfo.AddressCity);//市
//		$("#AddressVillage").val(json.RoomInfo.AddressVillage);//区
//		//房间设备信息填写
//		if(json.RoomInfo.AirConditioner==1){
//			$("#AirConditioner").attr("checked","checked");
//		}
//		if(json.RoomInfo.IndoorFirePlace==1){
//			$("#IndoorFirePlace").attr("checked","checked");
//		}
//		if(json.RoomInfo.Necessities==1){
//			$("#Necessities").attr("checked","checked");
//		}
//		if(json.RoomInfo.TV==1){
//			$("#TV").attr("checked","checked");
//		}
//		if(json.RoomInfo.Heating==1){
//			$("#Heating").attr("checked","checked");
//		}
//		if(json.RoomInfo.Kitchen==1){
//			$("#Kitchen").attr("checked","checked");
//		}
//		if(json.RoomInfo.Network==1){
//			$("#Network").attr("checked","checked");
//		}
//		if(json.RoomInfo.HotTub==1){
//			$("#HotTub").attr("checked","checked");
//		}
//		if(json.RoomInfo.WashingMachine==1){
//			$("#WashingMachine").attr("checked","checked");
//		}
//		if(json.RoomInfo.SwimmingPool==1){
//			$("#SwimmingPool").attr("checked","checked");
//		}
//		if(json.RoomInfo.DryingMachine==1){
//			$("#DryingMachine").attr("checked","checked");
//		}
//		if(json.RoomInfo.Breakfast==1){
//			$("#Breakfast").attr("checked","checked");
//		}
//		if(json.RoomInfo.CoatHanger==1){
//			$("#CoatHanger").attr("checked","checked");
//		}
//		if(json.RoomInfo.Iron==1){
//			$("#Iron").attr("checked","checked");
//		}
//		if(json.RoomInfo.WheelchairAccessible==1){
//			$("#WheelchairAccessible").attr("checked","checked");
//		}
//		if(json.RoomInfo.PETFacilities==1){
//			$("#PETFacilities").attr("checked","checked");
//		}
//		if(json.RoomInfo.WorkingSpace==1){
//			$("#WorkingSpace").attr("checked","checked");
//		}
//		$("#img0").attr("src",json.RoomInfo.RoomPicture);//图片加载
//	})
//}