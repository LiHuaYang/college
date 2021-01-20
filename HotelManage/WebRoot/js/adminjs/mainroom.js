var length = 0;
var roompage = 1;


$(document).ready(function() {
	// 初始化房间数据列表
	InitRoomList();
	// 载入房间列表
	loadRoomListByPage(1);
	// changepage("#pageone");
});


/**
 * 初始化房间页面
 * @return
 */
function InitRoomList() {
	// 1. 获取房间数据总页数
	$.getJSON("./WGetRoomNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.roomnumber <= 10) {
			pages = 1; 
		} else {
			pages = parseInt(jsonObject.roomnumber / 10);// 获取当前的总页数
			if (pages < jsonObject.roomnumber / 10) {
				pages = pages + 1;
			}
		}
		// 2. 设置总页数
		length = pages;
		// 3. 显示分页列表
		showfenye(pages);
	});
}

/**
 * 显示房间数据列表
 * @param jsonObject
 * @return
 */
function showRoomData(jsonObject) {
	// 1. 数据显示初始化
	for ( var i = 0; i < jsonObject.RoomInfo.length; i++) {
		if (jsonObject.RoomInfo[i].RoomType == 1) {
			roomtype = "标间";
		} else if (jsonObject.RoomInfo[i].RoomType == 2) {
			roomtype = "单人间";
		} else if (jsonObject.RoomInfo[i].RoomType == 3) {
			roomtype = "套房";
		}
		var roomUsingState = "使用中";
		if (jsonObject.RoomInfo[i].RoomUsingState == 1) {
			roomUsingState = "使用中";
		} else if (jsonObject.RoomInfo[i].RoomUsingState == 2) {
			roomUsingState = "空闲中";
		}
		var roomlockstate = "激活";
		if (jsonObject.RoomInfo[i].RoomLockState == 0) {
			roomlockstate = "激活";
		} else if (jsonObject.RoomInfo[i].RoomLockState == 1) {
			roomlockstate = "锁定";
		}
	// 2. 开始动态显示数据
	for ( var j = 0; j < $(".mrtruediv").length; j++) {
		$(".mrtruediv").eq(j).find(".thisgroup").append(
				'<tr onclick=do_onclick(this)   onselectstart="return false;">'
						+ '<td>' + jsonObject.RoomInfo[i].RoomId
						+ '</td>' + '<td>'
						+ jsonObject.RoomInfo[i].AddressProvince
						+ jsonObject.RoomInfo[i].AddressCity
						+ jsonObject.RoomInfo[i].AddressVillage
						+ '</td>' + '<td>' + roomtype + '</td>'
						+ '<td>' + jsonObject.RoomInfo[i].RoomPrice
						+ '</td>' + '<td>' + roomUsingState + '</td>'
						+ '<td>' + roomlockstate + '</td>' + '</tr>')
		}
	}
}

/**
 * 根据分页页数载入房间列表
 * @param page
 * @return
 */
function loadRoomListByPage(page) {
	// 去掉此句分页功能失败
	$(".mrtruediv").html("");
	// 在类名为mrtruediv的div中末尾插入
	// 去掉<tbody>
	$(".mrtruediv").append(
			'<table class="thisgroup" id="data_tab">' + '</table>');
	$.getJSON("./WGetPageRoomsServlet", {
		page : page
	}, function(jsonObject) {
		// 页面显示数据
		showRoomData(jsonObject);
	});
}

function topclick() {
	var pages = parseInt(length);// 获取当前的总页数
	if (roompage > 1) {
		roompage = roompage - 1;
		changeroompage(roompage);
		scrolltop(roompage);
	}
	loadRoomListByPage(roompage);
}

function downclick() {
	var pages = parseInt(length);// 获取当前的总页数
	if (roompage < pages) {
		roompage = roompage + 1;
		changeroompage(roompage);
		scrolltop(roompage);
	}
	loadRoomListByPage(roompage);
}

function firstclick() {
	changeroompage(1);
	roompage = 1;
	loadRoomListByPage(1);
}

function lastclick() {
	changeroompage(length);
	roompage = length;
	loadRoomListByPage(length);
}

function setColor(x, y, z) {
	return "#" + x.toString(16) + y.toString(16) + z.toString(16);
}

function changepage(x) {
	$(".mainxiahua div").attr("class", "mainroomnumbertwo");
	$(x).attr("class", "mainroomnumberone");
}

// 查找房间
function tofindroom(x) {
	var find = $(x).parent().find("input").val();
	var bl = false;
	if (find == "") {
		bl = true;
		loadRoomListByPage(1);
		$(".mainxiahua").show();
	}
	for ( var i = 0; i < array.length; i++) {
		if (array[i] == find) {
			tosearchroom(find);
			bl = true;
			break;
		}
	}
	if (!bl) {
		$(".mrtruediv").html("");
		alert("没有找到");
	}
}

function changeroompage(page) {
	$(".fenye").html("");
	$(".fenye").append(
			'<ul>' + '<li id="roomfirst" onclick=firstclick();>首页</li>'
					+ '<li id="roomtop" onclick=topclick();>上一页</li>'
					+ '<li class="xifenye" id="roomxifenye">'
					+ '<a id="roomxiye">' + page + '</a>	/  <a id="roommo">'
					+ length + '</a>'
					+ '<div class="xab" id="roomxab" style="display: none">'
					+ '<ul id="roomuljia"></ul>' + '</div>' + '</li>'
					+ '<li id="roomdown" onclick=downclick();>下一页</li>'
					+ '<li id="roomlast" onclick=lastclick();>末页</li>'
					+ '</ul>');
}

function scrolltop(top) {
	var hei = 25 * top - 25;
	$("#roomxab").scrollTop(hei);
}

/**
 * 解锁或锁定房间
 * 
 * @param val
 * @return
 */
function activateorlock(val) {
	// 获取鼠标焦点
	var x = tabuser;
	// 获取当前选中的房间ID
	var roomid = $(x).find("td").eq(0).html();
	if (x == null) {
		alert("Not Clicked");
	}
	var lockState = $(x).find("td").eq(5).html();
	
	if("激活" == lockState) {
		var RoomLockState = 1;
		$.getJSON("./WLockCheckRoomServlet", {
			RoomId : roomid,
			RoomLockState:RoomLockState
		}, function(jsonObject) {
			$(x).find("td").eq(5).html("锁定");
		});
	}
	if("锁定" == lockState) {
		var RoomLockState = 0;
		$.getJSON("./WLockCheckRoomServlet", {
			RoomId : roomid,
			RoomLockState:RoomLockState
		}, function(jsonObject) {
			$(x).find("td").eq(5).html("激活");
		});
	}
}

/** ************************************************************************************** */

function tosearchroom_button() {
	tosearchroom_number();
	tosearchroom(1);
}


function tosearchroom_number() {
	var Address = $("#fuzzy_input").val();
	$.getJSON("./WGetRoomNumberByAddressServlet", {
		Address : Address,
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
		length = pages2;
		showfenye(pages2);
	});
}

function tosearchroom(page) {
	$(".mrtruediv").html("");
	$(".mrtruediv").append(
			'<table class="thisgroup" id="data_tab">' + '</table>');
	var RoomDetailAddress = $("#fuzzy_input").val();
	
	$.getJSON("./WGetRoomByAddressAndDetailServlet", {
		RoomDetailAddress : RoomDetailAddress,
		page : page
	}, function(jsonObject) {
		showRoomData(jsonObject);
	});
}

function showfenye(pages) {
	$(".fenye").html("");
	$(".fenye").append(
			'<ul>' + '<li id="roomfirst" onclick=firstclick();>首页</li>'
					+ '<li id="roomtop" onclick=topclick();>上一页</li>'
					+ '<li class="xifenye" id="roomxifenye">'
					+ '<a id="roomxiye">1</a>	/  <a id="roommo">' + length
					+ '</a>'
					+ '<div class="xab" id="roomxab" style="display: none">'
					+ '<ul id="roomuljia"></ul>' + '</div>' + '</li>'
					+ '<li id="roomdown" onclick=downclick();>下一页</li>'
					+ '<li id="roomlast" onclick=lastclick();>末页</li>'
					+ '</ul>');
}

/** ************************************************************************************** */

/** ************************************************************************************** */
// 查看房间
function toseeroom() {
	var x = tabuser;
	var RoomId = $(x).find("td").eq(0).html();
	if(x==null){
		alert("请先选中!");
	}else{
		window.location.href="jsp/adminjsp/seeroom.jsp?RoomId="+RoomId;
	}
}

// 获取地址栏中的参数
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
}

// 获取房间的详细信息
function getRoomDetailInfo() {
	var RoomId = GetQueryString("RoomId");
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
		length = pages2;
		showfenye(pages2);
	});
}
/** ************************************************************************************** */
function tochangeroom(){
	var x = tabuser;
	var RoomId=$(x).find("td").eq(0).html();
	if(x==null){
		alert("请先选中！");
	} else {
		if (confirm("是否修改？")){
			window.location.href="jsp/adminjsp/changeroom.jsp?RoomId="+RoomId;
		}
		else{
			alert("取消修改");
		}
	}
}

function addroom(){
	window.location.href="jsp/adminjsp/addroom.jsp"
}



