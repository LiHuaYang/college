var cleaningrecordlength=0;
var cleaningrecordpage=1;

var rechargerecordlength=0;
var rechargerecordpage=1;

var comsumptionrecordlength=0;
var comsumptionrecordpage=1;

var cleanerworklength=0;
var cleanerworkpage=1;
$(document).ready(function() {
	$.getJSON("./WGetCleaningRecordNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.cleaningrecordnumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.cleaningrecordnumber / 10);// 获取当前的总页数
			if (pages < jsonObject.cleaningrecordnumber / 10) {
				pages = pages + 1;
			}
		}
		cleaningrecordlength = pages;
		showfenye(pages,1);
	});

	$.getJSON("./WGetRechageRecordNubmerServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.rechargerecordnumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.rechargerecordnumber / 10);// 获取当前的总页数
			if (pages < jsonObject.rechargerecordnumber / 10) {
				pages = pages + 1;
			}
		}
		rechargerecordlength = pages;
	});

	$.getJSON("./WGetComsumptionRecordNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.consumptionrecordnumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.consumptionrecordnumber / 10);// 获取当前的总页数
			if (pages < jsonObject.consumptionrecordnumber / 10) {
				pages = pages + 1;
			}
		}
		comsumptionrecordlength = pages;
	});

	$.getJSON("./WGetCleanerWorkPageServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.cleanerworknumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.cleanerworknumber / 10);// 获取当前的总页数
			if (pages < jsonObject.cleanerworknumber / 10) {
				pages = pages + 1;
			}
		}
		cleanerworklength = pages;
	});
	toconsume(1);

}) ;
function changebut(x) {
	$("#addg").attr("id","adde");
	$(x).attr("id","addg");
}

function toworkarrange(page) {
	$(".mrtruediv").html("");
	$(".mrtruediv").append("<div id=addgroup><div id=adde onclick='changebut(this),toloadpeople(1)'>清洁记录</div><div style='width:24%;' id=adde onclick='changebut(this),torecharge(1)'>充值记录</div>"+
	"<div id=adde onclick='changebut(this),toconsume(1)'>消费记录</div><div  id=addg onclick='changebut(this),toworkarrange(1)'>清洁员工作安排记录</div></div>")	
	$(".mrtruediv").append('<div id=mccontent> '+
			'<table>'+
			'<tbody>'+
			'<tr>'+
			'<td>工作安排号</td>'+
			'<td>清洁员号</td>'+
			'<td>房间号</th>'+
			'<td>工作安排状态</td>'+
			'</tr>'+
			'<tbody  class="thisgroup">'+
			'</tbody>'+
			'</table>'+
	'</div>');

	$.getJSON("./WGetCleanerWorkArrangesByPageServlet",{page:page},function(json){
		for ( var i = 0; i < json.length; i++) {
			var  cleanerWorkState = json[i].cleanerWorkState;
			if(cleanerWorkState == 0){
				cleanerWorkState = "工作未完成";
			}else if(cleanerWorkState == 1){
				cleanerWorkState = "工作完成";
			}
			var co="rgb(255,255,255)";
			if(i%2==0){
				co="rgb(255,255,255)";
			}
			else if(i%2!=0){
				co="rgb(175,196,224)";
			}
			for(var j = 0;j < $(".mrtruediv").length; j++){
				$(".mrtruediv").eq(j).find(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;"'+co+'">'+
						'<td>'+json[i].cleanerWorkId+' </td>'+
						'<td>'+json[i].cleanerId+'</td>'+
						'<td>'+json[i].roomId+' </td>'+
						'<td>'+cleanerWorkState+'</td>'+
				'</tr>')
			}
		}
		changehistorypage(page, 4);
	})
}

function toconsume(page) {
	$(".mhtruediv").html("");
	$(".mhtruediv").append('<table>'+  '<tbody class="thisgroup">' + '</tbody>'+'</table>');

	$.getJSON("./WGetConsumptionRecordPageServlet",{page:page},function(json){
		for ( var i = 0; i < json.length; i++) {
			var co="rgb(255,255,255)";
			if(i%2==0){
				co="rgb(255,255,255)";
			}
			else if(i%2!=0){
				co="rgb(250,250,250)";
			}
			for(var j = 0;j < $(".mhtruediv").length; j++){
				$(".mhtruediv").eq(j).find(".thisgroup").append('<tr onclick=do_onclick(this)  onselectstart="return false;"'+co+'">'+
						'<td>'+json[i].consumptionId+' </td>'+
						'<td>'+json[i].consumptionTime+'</td>'+
						'<td>'+json[i].consumptionMoney+' </td>'+
						'<td>'+json[i].consumptionName+'</td>'+
						'<td>'+json[i].consumptionPhon+'</td>'+
						'<td>'+json[i].consumptionIDNumber+'</td>'+
						'<td>'+json[i].consumptionAddress+'</td>'+
						'<td>'+json[i].userid+'</td>'+
				'</tr>')
			}
		}
		changehistorypage(page, 3);
	})
}

function torecharge(page) {
	$(".mhtruediv").html("");
	$(".mhtruediv").append("<div id=addgroup><div style='width:24%;' id=adde onclick='changebut(this),toloadpeople(1)'>清洁记录</div><div style='width:24%;' id=addg onclick='changebut(this),torecharge(1)'>充值记录</div>"+
	"<div id=adde onclick='changebut(this),toconsume(1)'>消费记录</div><div id=adde onclick='changebut(this),toworkarrange(1)'>清洁员工作安排记录</div></div>")	
	$(".mhtruediv").append('<div id=mccontent> '+
			'<table>'+
			'<tbody>'+
			'<tr>'+
			'<th>充值记记录号</th>'+
			'<th>充值时间</th>'+
			'<th>充值金额</th>'+
			'<th>客户号</th>'+
			'</tr>'+
			'</ty>'+
			'<tbody  class="thisgroup">'+
			'</tbody>'+
			'</table>'+
	'</div>');


	$.getJSON("./WGetRechageRecordPageServlet",{page:page},function(json){
		for ( var i = 0; i < json.length; i++) {
			var co="rgb(255,255,255)";
			if(i%2==0){
				co="rgb(255,255,255)";
			}
			else if(i%2!=0){
				co="rgb(175,196,224)";
			}
			for(var j = 0;j < $(".mrtruediv").length; j++){
				$(".mhtruediv").eq(j).find(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="overflow: hidden-x;height:60px;font-size:12px;font-weight: normal;-moz-user-select:none;background-color: '+co+'">'+
						'<td>'+json[i].rechargeId+'</th>'+
						'<td>'+json[i].rechargeTime+'</th>'+
						'<td>'+json[i].rechargeMoney+' </th>'+
						'<td>'+json[i].userId+'</th>'+
				'</tr>')
			}
		}
		changehistorypage(page, 2);
	})
}


function toloadpeople(page) {
	$(".mhtruediv").html("");
	$(".mhtruediv").append('<table>'+  '<tbody class="thisgroup">' + '</tbody>'+'</table>');

	$.getJSON("./WGetCleaningRecordPageServlet",{page:page},function(json){
		for ( var i = 0; i < json.length; i++) {
			var co="rgb(255,255,255)";
			if(i%2==0){
				co="rgb(255,255,255)";
			}
			else if(i%2!=0){
				co="rgb(250,250,250)";
			}
			for(var j = 0;j < $(".mrtruediv").length; j++){
				$(".mhtruediv").eq(j).find(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" '+co+'">'+
						'<td>'+json[i].cleaningId+'</th>'+
						'<td>'+json[i].cleaningTime+'</th>'+
						'<td>'+json[i].roomId+'</th>'+
						'<td>'+json[j].cleanerId+'</th>'+
				'</tr>')
			}
		}
	})
	changehistorypage(page, 1);
}

function showfenye(pages, pagestate) {
	var mypage = 0;
	if (pagestate == 1) {
		mypage = cleaningrecordlength;
	} else if (pagestate == 2) {
		mypage=rechargerecordlength;
	}else if(pagestate==3){
		mypage=comsumptionrecordlength;
	}else if(pagestate==4){
		mypage=cleanerworklength;
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

function changehistorypage(page, pagestate) {
	var mypage = 0;
	if (pagestate == 1) {
		mypage = cleaningrecordlength;
	} else if (pagestate == 2) {
		mypage = rechargerecordlength;
	}else if(pagestate==3){
		mypage=comsumptionrecordlength;
	}else if(pagestate==4){
		mypage=cleanerworklength;
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
		var pages = parseInt(cleaningrecordlength);// 获取当前的总页数
		if (cleaningrecordpage > 1) {
			cleaningrecordpage = cleaningrecordpage - 1;
//			changeevalutionpage(usercommintpage,1);
			scrolltop(cleaningrecordpage);
		}
		toloadpeople(cleaningrecordpage);
	} else if (pagestate == 2) {
		var pages = parseInt(rechargerecordlength);// 获取当前的总页数
		if (rechargerecordpage > 1) {
			rechargerecordpage = rechargerecordpage - 1;
//			changeevalutionpage(roomcommintpage,2);
			scrolltop(rechargerecordpage);
		}
		torecharge(rechargerecordpage);
	}else if(pagestate==3){
		var pages = parseInt(comsumptionrecordlength);// 获取当前的总页数
		if (comsumptionrecordpage > 1) {
			comsumptionrecordpage = comsumptionrecordpage - 1;
//			changeevalutionpage(roomcommintpage,2);
			scrolltop(comsumptionrecordpage);
		}
		toconsume(comsumptionrecordpage);
	}else if(pagestate==4){
		var pages = parseInt(cleanerworklength);// 获取当前的总页数
		if (cleanerworkpage > 1) {
			cleanerworkpage = cleanerworkpage - 1;
//			changeevalutionpage(roomcommintpage,2);
			scrolltop(cleanerworkpage);
		}
		toworkarrange(cleanerworkpage);
	}
}
function downclick(pagestate) {
	if (pagestate == 1) {
		var pages = parseInt(cleaningrecordlength);// 获取当前的总页数
		if (cleaningrecordpage < pages) {
			cleaningrecordpage = cleaningrecordpage + 1;
			scrolltop(cleaningrecordpage);
		}
		toloadpeople(cleaningrecordpage);
	} else if (pagestate == 2) {
		var pages = parseInt(rechargerecordlength);// 获取当前的总页数
		if (rechargerecordpage < pages) {
			rechargerecordpage = rechargerecordpage + 1;
			scrolltop(rechargerecordpage);
		}
		torecharge(rechargerecordpage);
	}else if(pagestate==3){
		var pages = parseInt(comsumptionrecordlength);// 获取当前的总页数
		if (comsumptionrecordpage < pages) {
			comsumptionrecordpage = comsumptionrecordpage + 1;
			scrolltop(comsumptionrecordpage);
		}
		toconsume(comsumptionrecordpage);
	}else if(pagestate==4){
		var pages = parseInt(cleanerworklength);// 获取当前的总页数
		if (cleanerworkpage < pages) {
			cleanerworkpage = cleanerworkpage + 1;
			scrolltop(cleanerworkpage);
		}
		toworkarrange(cleanerworkpage);
	}
}
//分页的的首页和未页
function firstclick(pagestate) {
	if (pagestate == 1) {
//		changeevalutionpage(1,1);
		cleaningrecordpage = 1;
		toloadpeople(1);
	} else if (pagestate == 2) {
//		changeevalutionpage(1,2);
		rechargerecordpage = 1;
		torecharge(1);
	}else if(pagestate==3){
		comsumptionrecordpage=1;
		toconsume(1);
	}
	else if(pagestate==4){
		cleanerworkpage=1;
		toworkarrange(1);
	}

}
function lastclick(pagestate) {
	if (pagestate == 1) {
//		changeevalutionpage(usercommintlength,1);
		cleaningrecordpage = cleaningrecordlength;
		toloadpeople(cleaningrecordlength);
	} else if (pagestate == 2) {
//		changeevalutionpage(roomcommintlength,2);
		rechargerecordpage = rechargerecordlength;
		torecharge(rechargerecordpage);
	}else if(pagestate==3){
		comsumptionrecordpage=comsumptionrecordlength;
		toconsume(comsumptionrecordpage);
	}else if(pagestate==4){
		cleanerworkpage=cleanerworklength;
		toworkarrange(cleanerworkpage);
	}
}


