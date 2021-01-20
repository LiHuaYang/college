
$(document).ready(function() {
	// $(".heads").load("jsp/common/adminbar.jsp");
	
});

//function add(){
//	var RoomNumber = $("#infoaddress").val();//房间命名号 infoaddress
//	var RoomPwd = $("#infopwd").val();//房间密码//房间密码 infopwd
//	var RoomDetailAddress = $("#RoomDetailAddress").val();//房间详细地址 infodetailaddress
//	var RoomType = jQuery("#selectRoomType  option:selected").val();//房间类型 selectRoomType
//	
//	var RoomPrice = $("#inforoomprice").val();//房间单价 inforoomprice
//	var AddressVillage = jQuery("#selectRoomAddress  option:selected").val();
//	
//	$.getJSON("./WNewRoomServlet",{
//		RoomNumber : RoomNumber,
//		RoomPwd:RoomPwd,
//		RoomDetailAddress : RoomDetailAddress,
//		RoomType : RoomType,
//		RoomPrice : RoomPrice,
//		AddressVillage : AddressVillage
//		
//	},function(jsonObject){
//			alert(jsonObject);
//	});
//}


function add(){
	
	var RoomLongitude = "121.555293";//经度
	var RoomLatitude = "29865638";//纬度
	
	// 服务器上传图片
	// var RoomPicture = $("#textfield").val();//房间图片
	var RoomPicture = "e:\\";//房间图片
	
	// 新增房间的使用状态默认为空
	var RoomUsingState = 2;//房间使用状态
	// 新增房间的锁状态默认为激活
	var RoomLockState = 0;//房间锁状态
	// 新增房间的描述默认为空
	var RoomMassage = "";//房间描述	
	
	var RoomNumber = $("#RoomNumber").val();//房间命名号
	var RoomPassWord = $("#RoomPassWord").val();//房间密码
	var RoomDetailAddress = $("#RoomDetailAddress").val();//房间详细地址
	var RoomUnitPrice =  parseInt($("#RoomUnitPrice").val());//房间单价
	
	var RoomType = $("#selectRoomType  option:selected").val();//房间类型 selectRoomType
	alert(RoomType);
	
	var AddressProvince = $("#selectRoomProvince  option:selected").text();//房间类型 selectRoomType
	alert(AddressProvince);
	
	var AddressCity = $("#selectRoomCity  option:selected").text();//房间类型 selectRoomType
	alert(AddressCity);
	
	var AddressVillage = $("#selectRoomVillage  option:selected").text();//房间类型 selectRoomType
	alert(AddressVillage);
	
	// var s = "asd ddd bbb sss";
	var reg = "//s/g";
	var AddressProvince = AddressProvince.replace(reg, "");
	var AddressCity = AddressCity.replace(reg, "");
	var AddressVillage = AddressVillage.replace(reg, "");
	
	alert(AddressProvince);
	alert(AddressCity);
	alert(AddressVillage);
	
	//var AddressProvince = $("#AddressProvince").val();//省
	//var AddressCity = $("#AddressCity").val();//市
	//var AddressVillage = $("#AddressVillage").val();//村（区）

	var AirConditioner = 0;//空调
	var IndoorFirePlace = 0;//壁炉
	var Necessities = 0;//	生活必需品
	var TV = 0;//	电视
	var Heating = 0;//	暖气
	var Kitchen = 0;//	厨房
	var Network = 0;//	网络
	var HotTub = 0;//	热水浴缸
	var WashingMachine =0;//	洗衣机
	var SwimmingPool = 0;//	游泳池
	var DryingMachine = 0;//	烘干机
	var Breakfast = 0;//	早餐
	var CoatHanger = 0;//	衣架
	var Iron = 0;//	熨斗
	var WheelchairAccessible = 0;//	无障碍设施
	var PETFacilities = 0;//	宠物设施
	var WorkingSpace = 0;//	工作区域

	//jquery获取复选框值 
	var chk_value =[]; 
	$('input[name="equipment"]:checked').each(function(){
		var str=$(this).val();
		if(str=="AirConditioner"){
			AirConditioner = 1;
		}
		if(str=="IndoorFirePlace"){
			IndoorFirePlace = 1;
		}
		if(str=="Necessities"){
			Necessities = 1;
		}
		if(str=="TV"){
			TV = 1;
		}
		if(str=="Heating"){
			Heating = 1;
		}
		if(str=="Kitchen"){
			Kitchen = 1;
		}
		if(str=="Network"){
			Network = 1;
		}
		if(str=="HotTub"){
			HotTub = 1;
		}
		if(str=="WashingMachine"){
			WashingMachine = 1;
		}
		if(str=="SwimmingPool"){
			SwimmingPool = 1;
		}
		if(str=="DryingMachine"){
			DryingMachine = 1;
		}
		if(str=="Breakfast"){
			Breakfast = 1;
		}
		if(str=="CoatHanger"){
			CoatHanger = 1;
		}
		if(str=="Iron"){
			Iron = 1;
		}
		if(str=="WheelchairAccessible"){
			WheelchairAccessible = 1;
		}
		if(str=="PETFacilities"){
			PETFacilities = 1;
		}
		if(str=="WorkingSpace"){
			WorkingSpace = 1;
		}
	}); 
	
	$.getJSON("./AdminAddARoom",{
		RoomNumber:RoomNumber,
		RoomPassword:RoomPassWord,
		RoomType:RoomType,
		RoomUnitPrice:RoomUnitPrice,
		RoomUsingState:RoomUsingState,
		RoomLockState:RoomLockState,
		RoomMassage:RoomMassage,
		RoomLongitude:RoomLongitude,
		RoomLatitude:RoomLatitude,
		RoomPicture:RoomPicture,
		RoomDetailAddress:RoomDetailAddress,
		
		AddressProvince:AddressProvince,
		AddressCity:AddressCity,
		AddressVillage:AddressVillage,
		
		AirConditioner:AirConditioner,
		IndoorFirePlace:IndoorFirePlace,
		Necessities:IndoorFirePlace,
		TV:TV,
		Heating:Heating,
		Kitchen:Kitchen,
		Network:Network,
		HotTub:HotTub,
		WashingMachine:WashingMachine,
		SwimmingPool:SwimmingPool,
		DryingMachine:DryingMachine,
		Breakfast:Breakfast,
		CoatHanger:CoatHanger,
		Iron:Iron,
		WheelchairAccessible:WheelchairAccessible,
		PETFacilities:PETFacilities,
		WorkingSpace:WorkingSpace
	},function(jsonObject){
		if(jsonObject.Check){
			alert("新建房间成功");
		}
		else{
			alert("新建失败");
		}
	});
}