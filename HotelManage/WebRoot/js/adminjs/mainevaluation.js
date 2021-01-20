var usercommintlength = 0;
var usercommintpage = 1;
var roomcommintlength=0;
var roomcommintpage=1;
$(document).ready(function() {
	$.getJSON("./WGetUserCommintNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.usercommintnumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.usercommintnumber / 10);// 获取当前的总页数
			if (pages < jsonObject.usercommintnumber / 10) {
				pages = pages + 1;
			}
		}
		usercommintlength = pages;
		showfenye(pages,1);
	});
	$.getJSON("./WGetRoomCommintNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.roomcommunitnumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.roomcommunitnumber / 10);// 获取当前的总页数
			if (pages < jsonObject.roomcommunitnumber / 10) {
				pages = pages + 1;
			}
		}
		roomcommintlength = pages;
	});
	toloadmainevaluation(1);
	select_change1();
});

var customercommit = 0;//客户评价选中
var roomcommit = 0;//房间评价选中
function select_change1(){
	customercommit = 1;
	roomcommit = 0;
}
function select_change2(){
	roomcommit = 1;
	customercommit = 0;
}

function seeEvaluation(){
	var x=tabuser;
	if(x==null){
		alert("Not Clicked");
	}
	else{
		if(customercommit==1){
			var UserCommitId=$(x).find("th").eq(0).html();
			$.getJSON("./WGetSingelUserCommitServlet",{
				UserCommitId:UserCommitId
			},function(json){
				var UserCommitId=json.result.userCommitId;
				var CleanerId=json.result.cleanerId;
				var UserCommitContent=json.result.userCommitContent;
				var UserCommitRank=json.result.userCommitRank;
				var UserCommitTime=json.result.userCommitTime;
				var UserId=json.result.userId;
				$(".shadow").show();
				$(".pagehead font").html("客户评价信息");
				$(".pagemain").html("<div class=userset>"+
						"<div style='margin-top: 10px'><a>评&nbsp;价&nbsp;号&nbsp;：</a><input disabled='disabled' id='UserCommitId'  type='text' value='"+UserCommitId+"'/></div>"+
						"<div style='margin-top: 10px'><a>客&nbsp;户&nbsp;号&nbsp;：</a><input disabled='disabled' id='UserId'  type='text' value='"+UserId+"'/></div>"+
						"<div style='margin-top: 10px'><a>清洁工号：</a><input disabled='disabled' id='CleanerId'  type='text' value='"+CleanerId+"'/></div>"+
						"<div style='margin-top: 10px'><a>评价星级：</a><input disabled='disabled' id='UserCommitRank'  type='text' value='"+UserCommitRank+"'/></div>"+
						"<div style='margin-top: 10px'><a>评价时间：</a><input disabled='disabled' id='UserCommitTime'  type='text' value='"+UserCommitTime+"'/></div>"+
						"<div style='margin-top: 10px'><a>评价内容：</a><br><textarea style='width:300px; height:100px;' disabled='disabled' id='UserCommitContent'  type='text'>"+UserCommitContent+"</textarea></div>"+
						"<button class=search-btn2 onclick='closepage()' style='float:right; margin-right:20px;'>确定</button></div>"+
				"</div>"); 
			})
		}
		if(roomcommit==1){
			var RoomCommitId=$(x).find("th").eq(0).html();
			$.getJSON("./WGetRoomCommitServlet",{
				RoomCommitId:RoomCommitId
			},function(json){
				var RoomcommitId=json.RoomCommit.roomcommitId;
				var RoomCommitContent=json.RoomCommit.roomCommitContent;
				var RoomCommitRank=json.RoomCommit.roomCommitRank;
				var RoomCommitTime=json.RoomCommit.roomCommitTime;
				var RoomId=json.RoomCommit.roomId;
				var UserId=json.RoomCommit.userId;
				$(".shadow").show();
				$(".pagehead font").html("房间评价信息");
				$(".pagemain").html("<div class=userset>"+
						"<div style='margin-top: 10px'><a>评&nbsp;价&nbsp;号&nbsp;：</a><input disabled='disabled' id='RoomcommitId'  type='text' value='"+RoomcommitId+"'/></a></div>"+
						"<div style='margin-top: 10px'><a>房&nbsp;间&nbsp;号&nbsp;：</a><input disabled='disabled' id='RoomId'  type='text' value='"+RoomId+"'/></a></div>"+
						"<div style='margin-top: 10px'><a>客&nbsp;户&nbsp;号&nbsp;：</a><input disabled='disabled' id='UserId'  type='text' value='"+UserId+"'/></a></div>"+
						"<div style='margin-top: 10px'><a>评价星级：</a><input disabled='disabled' id='RoomCommitRank'  type='text' value='"+RoomCommitRank+"'/></a></div>"+
						"<div style='margin-top: 10px'><a>评价时间：</a><input disabled='disabled' id='RoomCommitTime'  type='text' value='"+RoomCommitTime+"'/></a></div>"+
						"<div style='margin-top: 10px'><a>评价内容：</a><br><textarea style='width:300px; height:100px;' disabled='disabled' id='RoomCommitContent'  type='text'>"+RoomCommitContent+"</textarea></div>"+
						"<button class=search-btn2 onclick='closepage()' style='float:right; margin-right:20px;'>确定</button></div>"+
				"</div>"); 
			})
		}
	}
}

function changebut(x) {
	$("#addg1").attr("id", "adde1");
	$(x).attr("id", "addg1");
}

function toloadmainevaluation(page) {
	$(".mrtruediv").html("");
	$(".mrtruediv").append('<table>'+  '<tbody class="thisgroup">' + '</tbody>'+'</table>');
	$
	.getJSON("./WGetUserCommintPageServlet",
			{
		page : page
			},
			function(json) {
				//	
				for ( var i = 0; i < json.length; i++) {
					var content = json[i].userCommitContent;
					if (json[i].userCommitContent.length > 10) {
						content = content.substr(0, 10);
						content += "...";
					}
					for ( var j = 0; j < $(".mrtruediv").length; j++) {
						$(".mrtruediv")
						.eq(j)
						.find(".thisgroup")
						.append(
								'<tr onclick=do_onclick(this)   onselectstart="return false;"'
								+ ';">'
								+ '<td>'
								+ json[i].userCommitId
								+ '</td>'
								+ '<td>'
								+ json[i].userId
								+ '</td>'
								+ '<td>'
								+ json[i].cleanerId
								+ '</td>'
								+ '<td>'
								+ json[i].userCommitTime
								+ '</td>'
								+ '<td>'
								+ content
								+ '</td>'
								+ '<td>'
								+ json[i].userCommitRank
								+ '</td>' + '</tr>')
					}
				}

			})
			changeevalutionpage(page, 1)
}
function showcontentdetail() {
	alert(1);
}

//pagestate 1为客户评价，2为房间评价
function showfenye(pages, pagestate) {
	var mypage = 0;
	if (pagestate == 1) {
		mypage = usercommintlength;
	} else if (pagestate == 2) {
		mypage=roomcommintlength;
	}

	$(".fenye").html("");
	$(".fenye").append(
			'<ul>' + '<li id="first" onclick=firstclick(' + pagestate
			+ ');>首页</li>' + '<li id="top" onclick=topclick('
			+ pagestate + ');>上一页</li>'
			+ '<li class="xifenye" id="xifenye">'
			+ '<a id="xiye">1</a>	/  <a id="mo">' + mypage + '</a>'
			+ '<div class="xab" id="xab" style="display: none">'
			+ '<ul id="uljia"></ul>' + '</div>' + '</li>'
			+ '<li id="down" onclick=downclick(' + pagestate
			+ ');>下一页</li>' + '<li id="last" onclick=lastclick('
			+ pagestate + ');>末页</li>' + '</ul>');
}

function changeevalutionpage(page, pagestate) {
	var mypage = 0;
	if (pagestate == 1) {
		mypage = usercommintlength;
	} else if (pagestate == 2) {
		mypage = roomcommintlength;
	}

	$(".fenye").html("");
	$(".fenye").append(
			'<ul>' + '<li id="first" onclick=firstclick(' + pagestate
			+ ');>首页</li>' + '<li id="top" onclick=topclick('
			+ pagestate + ');>上一页</li>'
			+ '<li class="xifenye" id="xifenye">' + '<a id="xiye">'
			+ page + '</a>	/  <a id="mo">' + mypage + '</a>'
			+ '<div class="xab" id="xab" style="display: none">'
			+ '<ul id="uljia"></ul>' + '</div>' + '</li>'
			+ '<li id="down" onclick=downclick(' + pagestate
			+ ');>下一页</li>' + '<li id="last" onclick=lastclick('
			+ pagestate + ');>末页</li>' + '</ul>');

}

//分页的的上一页和下一页
function topclick(pagestate) {
	if (pagestate == 1) {
		var pages = parseInt(usercommintlength);// 获取当前的总页数
		if (usercommintpage > 1) {
			usercommintpage = usercommintpage - 1;
//			changeevalutionpage(usercommintpage,1);
			scrolltop(usercommintpage);
		}
		toloadmainevaluation(usercommintpage);
	} else if (pagestate == 2) {
		var pages = parseInt(roomcommintlength);// 获取当前的总页数
		if (roomcommintpage > 1) {
			roomcommintpage = roomcommintpage - 1;
//			changeevalutionpage(roomcommintpage,2);
			scrolltop(roomcommintpage);
		}
		toloadmainroomevaluation(roomcommintpage);
	}

}
function downclick(pagestate) {
	if (pagestate == 1) {
		var pages = parseInt(usercommintlength);// 获取当前的总页数
		if (usercommintpage < pages) {
			usercommintpage = usercommintpage + 1;
			scrolltop(usercommintpage);
//			changeevalutionpage(usercommintpage,1);
		}
		toloadmainevaluation(usercommintpage);
	} else if (pagestate == 2) {
		var pages = parseInt(roomcommintlength);// 获取当前的总页数
		if (roomcommintpage < pages) {
			roomcommintpage = roomcommintpage + 1;
			scrolltop(roomcommintpage);
//			changeevalutionpage(roomcommintpage,2);
		}
		toloadmainroomevaluation(roomcommintpage);
	}
}
//分页的的首页和未页
function firstclick(pagestate) {
	if (pagestate == 1) {
//		changeevalutionpage(1,1);
		usercommintpage = 1;
		toloadmainevaluation(1);
	} else if (pagestate == 2) {
//		changeevalutionpage(1,2);
		roomcommintpage = 1;
		toloadmainroomevaluation(1);
	}

}
function lastclick(pagestate) {
	if (pagestate == 1) {
//		changeevalutionpage(usercommintlength,1);
		usercommintpage = usercommintlength;
		toloadmainevaluation(usercommintlength);
	} else if (pagestate == 2) {
//		changeevalutionpage(roomcommintlength,2);
		roomcommintpage = roomcommintlength;
		toloadmainroomevaluation(roomcommintlength);
	}
}
//滚动条
function scrolltop(top) {
	var hei = 25 * top - 25;
	$("#xab").scrollTop(hei);
}
