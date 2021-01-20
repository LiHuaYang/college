
// 
var gPages = 0;
/******************************************************************************************/
// 页面初始化模块
// 获取数据长度（页数）
$(document).ready(function() {
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
		gPages = pages;// gPages全局变量第一次赋值
		
		showfenye(pages);// TODO: 显示分页按钮
	});
	toloadmainroom(1);
});

/**
 * 
 * html()函数用于设置或返回当前jQuery对象所匹配的DOM元素内的html内容。 
 * 该函数的用途相当于设置或获取DOM元素的innerHTML属性值
 * 该函数属于jQuery对象(实例)。
 * 
 * @param page
 * @return
 */
function toloadmainroom(page) {
	// 去掉此句分页功能失败
	$(".mrtruediv").html("");
	// 在类名为mrtruediv的div中末尾插入
	// 去掉<tbody>
	$(".mrtruediv").append(
			'<table class="thisgroup" id="data_tab">' + '</table>');
	$.getJSON("./WGetPageRoomsServlet", {
		page : page
	}, function(jsonObject) {
		// 这里可不可以定义一些常量，那么每次进入函数就不用判断是什么了？
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
				// 这边是根据mrtruediv的长度来append节点的吗？
			// 不是根据服务器返回的数据长度来append？
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
	});
}
/******************************************************************************************/


// ******************** 分页功能模块 ******************** //

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


/**
 * 分页功能--首页
 * 
 * @return
 */
function firstclick() {
	changeroompage(1);
	roompage = 1;
	toloadmainroom(1);
}

/**
 * 分页功能--尾页
 * 
 * @return
 */
function lastclick() {
	changeroompage(gPages);
	roompage = length;
	toloadmainroom(gPages);
}

/**
 * 分页功能--上一页
 * 
 * @return
 */
function topclick() {
	var pages = parseInt(length);// 获取当前的总页数
	if (roompage > 1) {
		roompage = roompage - 1;
		changeroompage(roompage);
		scrolltop(roompage);
	}
	toloadmainroom(roompage);
}
/**
 * 分页功能--下一页
 * 
 * @return
 */
function downclick() {
	var pages = parseInt(length);// 获取当前的总页数
	if (roompage < pages) {
		roompage = roompage + 1;
		changeroompage(roompage);
		scrolltop(roompage);
	}
	toloadmainroom(roompage);
}
//******************** ******************** //