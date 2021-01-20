
function showPic(url) {
	var pic = new Array("img/vip0.jpg", "img/vip1.jpg", "img/vip2.jpg",
			"img/vip3.jpg", "img/vip4.png");
	for ( var i = 0; i < 5; i++) {
		$(".vipinpicone").eq(i)
				.css("background-image", "url('" + pic[i] + "')");
	}
}

function vippicright() {
	var range = $(".vippic").css("width");
	var right = $(".vipinpic").css("right");
	var goright = parseInt(range) + parseInt(right);
	var max = parseInt($(".vipinpic").css("width"));
	if (goright >= max) {

		goright = 0;
	}
	$(".vipinpic").css("right", goright);
}

function vippicleft() {
	var range = $(".vippic").css("width");
	var right = $(".vipinpic").css("right");
	var goright = parseInt(right) - parseInt(range);
	if (parseInt(right) > 0) {
		$(".vipinpic").css("right", goright);
	}
}

/**
 * 左侧导航栏点击跳转事件
 * @param liObj点击对象
 * @return
 */
function liClick(liObj) {
	switch (liObj.id) {
	case "room":
		window.location.href = "jsp/adminjsp/mainroom.jsp";
		break;
	case "user":
		window.location.href = "jsp/adminjsp/mainclient.jsp";
		break;
	case "order":
		window.location.href = "jsp/adminjsp/mainorder.jsp";
		break;
	case "cleaner":
		window.location.href = "jsp/adminjsp/maincleaner.jsp";
		break;
	case "message":
		window.location.href = "jsp/adminjsp/messagemanage.jsp";
		break;
	case "financialsettlement":
		window.location.href = "jsp/adminjsp/financialsettlement.jsp";
		break;
	case "telephonehelp":
		window.location.href = "jsp/adminjsp/telephonehelp.jsp";
		break;
	}
}

/**
 * 显示菜单
 * @param menu 点击对象
 * @return
 */
function showMenu(menu) {
	menu.getElementsByTagName("ul")[0].style.display = "block";
}
/**
 * 显示子菜单
 * @param menu 点击对象
 * @return
 */
function showSubMenu(menu) {
	menu.getElementsByTagName("ul")[0].style.display = "none";
}

//Joker 2015/12/12 19:06:29
function judge(obj) {
	if (document.getElementById("customer1")) {
		document.getElementById("customer1").style.display = "none";
		document.getElementById("customer2").style.display = "none";
	}
	if (document.getElementById("cleaner1")) {
		document.getElementById("cleaner1").style.display = "none";
		document.getElementById("cleaner2").style.display = "none";
	}
	if (document.getElementById("room1")) {
		document.getElementById("room1").style.display = "none";
		document.getElementById("room2").style.display = "none";
	}
	if (document.getElementById("money1")) {
		document.getElementById("money1").style.display = "none";
		document.getElementById("money2").style.display = "none";
	}
	if (document.getElementById("telephonehelp1")) {
		document.getElementById("telephonehelp1").style.display = "none";
	}
	switch (obj.innerHTML) {
	case "安排记录":
		document.getElementById("cleaner1").style.display = "block";
		break;
	case "保洁记录":
		document.getElementById("cleaner2").style.display = "block";
		break;
	case "消费记录":
		document.getElementById("customer1").style.display = "block";
		break;
	case "充值记录":
		document.getElementById("customer2").style.display = "block";
		break;
	case "房间评价":
		document.getElementById("room1").style.display = "block";
		break;
	case "7天记录":
		document.getElementById("room2").style.display = "block";
		break;
	case "今日收益":
		document.getElementById("money1").style.display = "block";
		break;
	case "维护费用":
		document.getElementById("money2").style.display = "block";
		break;
	case "电话预定":
		document.getElementById("telephonehelp1").style.display = "block";
		break;
	}
}
function toModifyCleanerPage() {
	window.location.href = "jsp/adminjsp/cleanerrevise.jsp";
}

var tabuser;
/****
 判断选中的是奇数行还是偶数行，改变背景颜色 
 ****/
function changeTrColortwo(obj) {
	var _table = obj.parentNode;
	for ( var i = 0; i < _table.rows.length; i++) {
		if (i % 2 == 0) {
			_table.rows[i].style.backgroundColor = setColor(250, 250, 250);
		} else if (i % 2 != 0) {
			_table.rows[i].style.backgroundColor = setColor(255, 255, 255);
		}
	}
	tabuser = null;
}
/***
 清除之前选中的背景改变的颜色，改变选中的背景的颜色
 ***/
function do_onclick(tab) {
	changeTrColortwo(tab);
	var x = 251;
	var y = 236;
	var z = 136;
	tab.style.backgroundColor = setColor(x, y, z);

	tabuser = tab;
}
/***
 输入rgb三原色，转换成16进制颜色表示
 */
function setColor(x, y, z) {
	return "#" + x.toString(16) + y.toString(16) + z.toString(16);
}


/**************************************************************************/
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
}
/**************************************************************************/


