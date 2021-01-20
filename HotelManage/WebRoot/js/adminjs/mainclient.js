var length = 0;
var userpage = 1;
$(document).ready(function() {
	$.getJSON("./WGetUserNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.usernumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.usernumber / 10);// 获取当前的总页数
			if (pages < jsonObject.usernumber / 10) {
				pages = pages + 1;
			}
		}
		length = pages;
		showfenye(pages);
	});
	toloadmainclient(1);
});

function activateorlock2(){
	var x = tabuser;
	var userid = $(x).find("th").eq(0).html();
	if (x == null) {
		alert("Not Clicked");
		$("#ActiveOrLock2").find("option").eq(0).attr("selected","selected");
	} else {
		var userstate = $("#ActiveOrLock2").val();
		if(userstate==0){
			$.getJSON("./LockCheckUserServlet", {
				UserId : userid,
				UserState : userstate
			}, function(jsonObject) {
				if (jsonObject.Check) {
					alert("激活成功");
					$("#ActiveOrLock2").find("option").eq(0).attr("selected","selected");
					toloadmainclient(1);
				}else{
					alert("激活失败");
					$("#ActiveOrLock2").find("option").eq(0).attr("selected","selected");
				}
			});
		}
		if(userstate==1){
			$.getJSON("./LockCheckUserServlet", {
				UserId : userid,
				UserState:userstate
			}, function(jsonObject) {
				if (jsonObject.Check) {
					alert("锁定成功");
					$("#ActiveOrLock2").find("option").eq(0).attr("selected","selected");
					toloadmainclient(1);
				}else{
					alert("锁定失败");
					$("#ActiveOrLock2").find("option").eq(0).attr("selected","selected");
				}
			});
		}
	}
}

function changebut(x) {
	$("#addg").attr("id", "adde");
	$(x).attr("id", "addg");
}

function tosearchbyname_number(){
	var UserName = $("#key_input").val();
	$.getJSON("./WGetUserByNameNumberServlet", {
		UserName:UserName
	},function(jsonObject) {
		var pages2 = 0;
		if (jsonObject.usernumber <= 10) {
			pages2 = 1;
		} else {
			pages2 = parseInt(jsonObject.usernumber / 10);// 获取当前的总页数
			if (pages2 < jsonObject.usernumber / 10) {
				pages2 = pages2 + 1;
			}
		}
		length = pages2;
		showfenye(pages2);
	});
}

function tosearchbyname_button(){
	tosearchbyname_number();
	tosearchbyname(1);
}

function tosearchbyname(page){
	var UserName = $("#key_input").val();
	$(".mrtruedivs").html("");
	$(".mrtruediv")
	.append(
			'<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>客户号</td>' + '<td>客户姓名</td>' + '<td>登入密码</td>'
			+ '<td>客户性别</td>' + '<td>客户电话</td>'
			+ '<td>电子邮箱</td>'
			+ '<td>身份证号</td>' + '<td>VIP类型</td>'
			+ '<td>客户状态</td>' + '<td>账户余额</td>' +
			'</td>' + '</tr>' +
			'<tbody  class="thisgroup">' +
			'</tbody>' + '</table>');

	$.getJSON(
			"./WGetUserByNameServlet",
			{
				UserName:UserName,
				page : page
			},
			function(json) {
				for ( var i = 0; i < json.length; i++) {
					var co = "rgb(255,255,255)";
					if (i % 2 == 0) {
						co = "rgb(255,255,255)";
					} else if (i % 2 != 0) {
						co = "rgb(175,196,224)";
					}
					var uservip = "VIP用户";
					if (json[i].userVIP == 0) {
						uservip = "普通用户";
					} else if (json[i].userVIP == 1) {
						uservip = "VIP用户";
					}
					var userstate = "激活";
					if (json[i].userState == 0) {
						userstate = "激活";
					} else if (json[i].userState == 1) {
						userstate = "锁定";
					}
					for ( var j = 0; j < $(".mrtruediv").length; j++) {
						$(".mrtruediv")
						.eq(j)
						.find(".thisgroup")
						.append(
								'<tr onclick=do_onclick(this)   onselectstart="return false;"'
								+ '>'
								+ '<td >'
								+ json[i].userId
								+ '</td>'
								+ '<td >'
								+ json[i].userName
								+ '</td>'
								+ '<td >'
								+ json[i].userPassword
								+ '</td>'
								+ '<td >'
								+ json[i].userSex
								+ '</td>'
								+ '<td >'
								+ json[i].userPhone
								+ '</td>'
								+ '<td >'
								+ json[i].userEmail
								+ '</td>'
								+ '<td >'
								+ json[i].userIDNumber
								+ '</td>'
								+ '<td >'
								+ uservip
								+ '</td>'
								+ '<td >'
								+ userstate
								+ '</td>'
								+ '<td >'
								+ json[i].userBalance
								+ '</td>' + '</tr>')
					}
				}
			});
}

function toloadmainclient(page) {
	$(".mrtruediv").html("");
	$(".mrtruediv").append('<table id="data_tab">'+'<tbody class="thisgroup">' +'</tbody>');
	$.getJSON(
			"./WGetUserPageServlet",
			{
				page : page
			},
			function(json) {
				for ( var i = 0; i < json.length; i++) {
					var uservip = "VIP用户";
					if (json[i].userVIP == 0) {
						uservip = "普通用户";
					} else if (json[i].userVIP == 1) {
						uservip = "VIP用户";
					}
					var userstate = "激活";
					if (json[i].userState == 0) {
						userstate = "激活";
					} else if (json[i].userState == 1) {
						userstate = "锁定";
					}
					for ( var j = 0; j < $(".mrtruediv").length; j++) {
						$(".mrtruediv")
						.eq(j)
						.find(".thisgroup")
						.append(
								'<tr onclick=do_onclick(this)    onselectstart="return false;"'
								+ '">'
								+ '<td >'
								+ json[i].userId
								+ '</td>'
								+ '<td >'
								+ json[i].userName
								+ '</td>'
								+ '<td >'
								+ json[i].userPassword
								+ '</td>'
								+ '<td >'
								+ json[i].userSex
								+ '</td>'
								+ '<td>'
								+ json[i].userPhone
								+ '</td>'
								+ '<td >'
								+ json[i].userEmail
								+ '</td>'
								+ '<td >'
								+ json[i].userIDNumber
								+ '</td>'
								+ '<td>'
								+ uservip
								+ '</td>'
								+ '<td >'
								+ userstate
								+ '</td>'
								+ '<td >'
								+ json[i].userBalance
								+ '</td>' + '</tr>')
					}
				}
			});
}
function showfenye(pages) {
	$(".fenye").html("");
	$(".fenye").append(
			'<ul>' + '<li id="clientfirst" onclick=firstclick();>首页</li>'
			+ '<li id="clienttop" onclick=topclick();>上一页</li>'
			+ '<li class="xifenye" id="clientxifenye">'
			+ '<a  id="clientxiye">1</a>	/  <a   id="clientmo">'
			+ length + '</a>'
			+ '<div class="xab" id="clientxab" style="display: none">'
			+ '<ul id="clientuljia"></ul>' + '</div>' + '</li>'
			+ '<li id="clientdown" onclick=downclick();>下一页</li>'
			+ '<li id="clientlast" onclick=lastclick();>末页</li>'
			+ '</ul>');
}
function changeclientpage(page) {
	$(".fenye").html("");
	$(".fenye").append(
			'<ul>' + '<li id="clientfirst" onclick=firstclick();>首页</li>'
			+ '<li id="clienttop" onclick=topclick();>上一页</li>'
			+ '<li class="xifenye"  id="clientxifenye">'
			+ '<a  id="clientxiye">'+page+'</a>/<a   id="clientmo">'
			+ length + '</a>'
			+ '<div class="xab" id="clientxab" style="display: none">'
			+ '<ul id="clientuljia"></ul>' + '</div>' + '</li>'
			+ '<li id="clientdown" onclick=downclick();>下一页</li>'
			+ '<li id="clientlast" onclick=lastclick();>末页</li>'
			+ '</ul>');
}

//分页的的上一页和下一页
function topclick() {
	var pages = parseInt(length);// 获取当前的总页数
	if (userpage > 1) {
		userpage = userpage - 1;
		changeclientpage(userpage);
		scrolltop(userpage);
	}
	toloadmainclient(userpage);
}

function downclick() {
	var pages = parseInt(length);// 获取当前的总页数
	if (userpage < pages) {
		userpage = userpage + 1;
//		$("#clientxiye").html(userpage);
		scrolltop(userpage);
		changeclientpage(userpage);
	}
	toloadmainclient(userpage);

}
//分页的的首页和未页
function firstclick() {
	changeclientpage(1);
	userpage = 1;
	toloadmainclient(1);
}
function lastclick() {
	changeclientpage(length);
	userpage = length;
	toloadmainclient(length);
}
//滚动条
function scrolltop(top) {
	var hei = 25 * top - 25;
	$("#clientxab").scrollTop(hei);
}

