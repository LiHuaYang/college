var length = 0;
var cleanerpage = 1;
$(document).ready(function() {
	$.getJSON("./WGetCleanerNumberServlet", function(jsonObject) {
		var pages = 0;
		if (jsonObject.cleanernumber <= 10) {
			pages = 1;
		} else {
			pages = parseInt(jsonObject.cleanernumber / 10);// 获取当前的总页数
			if (pages < jsonObject.cleanernumber / 10) {
				pages = pages + 1;
			}
		}
		length = pages;
		showfenye(pages);
	});
	toloadmaincleaner(1);
}) ;
function workarrange(){
	var x=tabuser;
	var CleanerId=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		$.getJSON("./WGetCleanerByIdServlet",{
			CleanerId:CleanerId
		},function(json){
			var CleanerId=json.result.cleanerId;
			var CleanerName=json.result.cleanerName;
			var CleanerState=json.result.cleanerState;
			if(CleanerState==0){
				CleanerState = "激活";
			}
			if(CleanerState==1){
				CleanerState = "锁定";
			}
			if(CleanerState==-1){
				CleanerState = "已删除";
			}
			sad(CleanerId,CleanerName,CleanerState);
		});
	}
}
function addcleaner_save(){
	var CleanerIDNumber = $("#CleanerIDNumber").val();
	var CleanerPhoneNumber = $("#CleanerPhoneNumber").val();
	var CleanerName = $("#CleanerName").val();
	var CleanerPassWord = $("#CleanerPassWord").val();
	var CleanerSex = $("#CleanerSex").val();
	$.getJSON("./WCleanerRegister",{
		CleanerIDNumber:CleanerIDNumber,
		CleanerPhoneNumber:CleanerPhoneNumber,
		CleanerName:CleanerName,
		CleanerPassWord:CleanerPassWord,
		CleanerSex:CleanerSex
	},function(json){
		if(json.result){
			alert("增加清洁员成功");
		}else{
			alert("增加清洁员失败");
		}
	});
}

function sad(CleanerId,CleanerName,CleanerState) {
	$(".shadow").show();
	$(".pagehead font").html("清洁员工作安排");
	$(".showpage").css("height","220px");
	$(".showpage").css("width","270px");
	$(".pagemain").html(
			"<div class=userset>"+
			"<div><a>清洁员号：</a><input type='text' disabled='disabled' id='CleanerId' value='"+CleanerId+"'/></div>"+
			"<div style='margin-top: 10px'><a>名&nbsp;&nbsp;&nbsp;&nbsp;字&nbsp;：</a><input disabled='disabled' id='CleanerName'  type='text' value='"+CleanerName+"'/></div>"+
			"<div style='margin-top: 10px'><a>状&nbsp;&nbsp;&nbsp;&nbsp;态&nbsp;：</a><input disabled='disabled' id='CleanerState'  type='text' value='"+CleanerState+"'/></div>"+
			"<div style='margin-top: 10px'><a>房&nbsp;间&nbsp;号&nbsp;：</a><select id=RoomId> "+
			"<option >"+1+"</option>"+
			"<option >"+2+"</option>"+
			"<option >"+3+"</option>"+
			"</select></div>"+
			"<div><button class=search-btn2 onclick='workarrange_save()' style='margin-right:20px; float:right;'>安排</button></div>"+
	"</div>"); 
}
function workarrange_save(){
	var CleanerId = $("#CleanerId").val();
	var RoomId = $("#RoomId").val();
	$.getJSON("./WCleanerWorkArrangeServlet",{
		CleanerId:CleanerId,
		RoomId:RoomId
	},function(json){
		if(json.result){
			alert("安排成功");
		}
		else {
			alert("安排失败");
		}
	});
}
function changecleaner_save(){
	var CleanerId=$("#CleanerId").val();
	var CleanerIDNumber=$("#CleanerIDNumber").val();
	var CleanerName=$("#CleanerName").val();
	var CleanerPassWord=$("#CleanerPassWord").val();
	var CleanerPhoneNumber=$("#CleanerPhoneNumber").val();
	var CleanerSex=$("#CleanerSex").val();
	var CleanerState=$("#CleanerState").val();
	if(CleanerState == "激活"){
		CleanerState = 0;
	}
	if(CleanerState == "锁定"){
		CleanerState = 1;
	}
	if(CleanerState == "已删除"){
		CleanerState = -1;
	}
	$.getJSON("./WChangeCleanerServlet",{
		CleanerId:CleanerId,
		CleanerIDNumber:CleanerIDNumber,
		CleanerName:CleanerName,
		CleanerPassWord:CleanerPassWord,
		CleanerPhoneNumber:CleanerPhoneNumber,
		CleanerSex:CleanerSex,
		CleanerState:CleanerState
	},function(json){
		if(json.Check){
			alert("修改成功");
		}
		else {
			alert("修改失败");
		}
	})
}
//删除
function del(){
	var x=tabuser;
	var roomid=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		if (confirm("是否删除？")){
			$.getJSON("./WDeleteRoomServlet",{RoomId:roomid},function(json){
				if(json.Check){
					alert("删除成功");
					toloadmaincleaner(1);
				}
				else{
					alert("删除失败");
				}
			})
		}
	}
}
function toloadmaincleaner(page) {
	$(".mrtruediv").html("");
	$(".mrtruediv").append('<table id="data_tab">'+  '<tbody class="thisgroup">' + '</tbody>'+'</table>');

	$.getJSON("./WGetCleanerPageServlet",{page:page},function(json){
		for ( var i = 0; i < json.length; i++) {
			var cleanerstate="激活";
			if(json[i].cleanerState==0){
				cleanerstate="激活";
			} 
			if(json[i].cleanerState==1){
				cleanerstate="锁定";
			}
			if(json[i].cleanerState==-1){
				cleanerstate="已删除";
			}
			for(var j = 0;j < $(".mrtruediv").length; j++){
				$(".mrtruediv").eq(j).find(".thisgroup").append('<tr onclick="do_onclick(this)"  onselectstart="return false;"">'+
						'<td >'+json[i].cleanerId+'</td>'+
						'<td >'+json[i].cleanerName+'</td>'+
						'<td >'+json[i].cleanerSex+'</td>'+
						'<td >'+json[i].cleanerPhoneNumber+'</td>'+
						'<td >'+cleanerstate+'</td>'+
						'<td >'+json[i].cleanerIDNumber+'</td>'+
				'</tr>')
			}
		}
	})
}
function showfenye(pages){
	$(".fenye").html("");
	$(".fenye").append('<ul>'+
			'<li id="first" onclick=firstclick();>首页</li>'+
			'<li id="top" onclick=topclick();>上一页</li>'+
			'<li class="xifenye" id="xifenye">'+
			'<a id="xiye">1</a>	/  <a id="mo">'+length+'</a>'+
			'<div class="xab" id="xab" style="display: none">'+
			'<ul id="uljia"></ul>'+
			'</div>'+
			'</li>'+
			'<li id="down" onclick=downclick();>下一页</li>'+
			'<li id="last" onclick=lastclick();>末页</li>'+
			'</ul>'
	);
}
function changecleanerpage(page) {
	$(".fenye").html("");
	$(".fenye").append('<ul>'+
			'<li id="first" onclick=firstclick();>首页</li>'+
			'<li id="top" onclick=topclick();>上一页</li>'+
			'<li class="xifenye" id="xifenye">'+
			'<a id="xiye">'+page+'</a>	/  <a id="mo">'+length+'</a>'+
			'<div class="xab" id="xab" style="display: none">'+
			'<ul id="uljia"></ul>'+
			'</div>'+
			'</li>'+
			'<li id="down" onclick=downclick();>下一页</li>'+
			'<li id="last" onclick=lastclick();>末页</li>'+
			'</ul>'
	);
}

//分页的的上一页和下一页
function topclick(){
	var pages = parseInt(length);// 获取当前的总页数
	if (cleanerpage > 1) {
		cleanerpage = cleanerpage - 1;
		changecleanerpage(cleanerpage);
		scrolltop(cleanerpage);
	}
	toloadmaincleaner(cleanerpage);
}

function downclick(){
	var pages = parseInt(length);// 获取当前的总页数
	if (cleanerpage < pages) {
		cleanerpage = cleanerpage + 1;
		scrolltop(cleanerpage);
		changecleanerpage(cleanerpage);
	}
	toloadmaincleaner(cleanerpage);

}
//分页的的首页和未页
function firstclick() {
	changecleanerpage(1);
	cleanerpage = 1;
	toloadmaincleaner(1);


}
function lastclick() {
	changecleanerpage(length);
	cleanerpage = length;
	toloadmaincleaner(length);
}
//滚动条
function scrolltop(top){
	var hei=25*top-25;
	$("#xab").scrollTop(hei);
}
var curtab = null;
var tabuser = null;
function activateorlock3(){
	var x = tabuser;
	var cleanerId = $(x).find("th").eq(0).html();
	if (x == null) {
		alert("Not Clicked");
		$("#ActiveOrLock3").find("option").eq(0).attr("selected","selected");
	} else {
		var cleanerState = $("#ActiveOrLock3").val();
		if(cleanerState==0){
			$.getJSON("./WChangeCleanerStateServlet", {
				CleanerId : cleanerId,
				CleanerState:cleanerState
			}, function(jsonObject) {
				if (jsonObject.Check) {
					alert("激活成功");
					$("#ActiveOrLock3").find("option").eq(0).attr("selected","selected");
					toloadmaincleaner(1);
				}else{
					alert("激活失败");
					$("#ActiveOrLock3").find("option").eq(0).attr("selected","selected");
				}
			});
		}
		if(cleanerState==1){
			$.getJSON("./WChangeCleanerStateServlet", {
				CleanerId:cleanerId,
				CleanerState:cleanerState
			},function(jsonObject){
				if (jsonObject.Check) {
					alert("锁定成功");
					$("#ActiveOrLock3").find("option").eq(0).attr("selected","selected");
					toloadmaincleaner(1);
				}else{
					alert("锁定失败");
					$("#ActiveOrLock3").find("option").eq(0).attr("selected","selected");
				}
			});
		}
	}
}

//function activate(){
//	var x=tabuser;
//	var CleanerId=$(x).find("th").eq(0).html();
//	if(x==null){
//		alert("Not Clicked");
//	}else{
//		var cleanerState = 0;
//		$.getJSON("./WChangeCleanerStateServlet",{
//			CleanerId:CleanerId,
//			CleanerState:cleanerState},function(jsonObject){
//				if (jsonObject.Check) {
//					alert("激活成功");
//					toloadmaincleaner(1);
//				}
//			});
//	}
//}
//
//function lock(){
//	var x=tabuser;
//	var CleanerId=$(x).find("th").eq(0).html();
//	if(x==null){
//		alert("Not Clicked");
//	}else{
//		var CleanerState = 1;
//		$.getJSON("./WChangeCleanerStateServlet",{
//			CleanerId:CleanerId,
//			CleanerState:CleanerState},function(jsonObject){
//				if (jsonObject.Check) {
//					alert("锁定成功");
//					toloadmaincleaner(1);
//				}
//			})
//	}
//}
function del(){
	var x=tabuser;
	var CleanerId=$(x).find("th").eq(0).html();
	if(x==null){
		alert("Not Clicked");
	}else{
		var CleanerState = -1;
		$.getJSON("./WChangeCleanerStateServlet",{
			CleanerId:CleanerId,
			CleanerState:CleanerState},function(jsonObject){
				if (jsonObject.Check) {
					alert("删除成功");
					toloadmaincleaner(1);
				}
			})
	}
}