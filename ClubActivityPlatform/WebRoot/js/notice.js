$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	getnoticedetial();
	getcomment();
})
function getnoticedetial() {
	var json={
			"noticeId":mynoticeId
			
	}
	$.getJSON("./GetNoticeDetail",{json:JSON.stringify(json)},function(json){
		$(".noticebelong-pic").css("background-image","url("+json.noticeReleasePic+")");
		$(".noticebelong-name").html(json.noticeReleaseName+"公告");
		var time=json.notice.noticeStartTime.substring(0,json.notice.noticeStartTime.length-2);
		
		$(".notice-title").html("<i class='iconfont' id='bc'>&#xf01bd;</i>   "+json.notice.noticeTitle+"<font style='float:right;font-size:14px;color:#F47920;margin-top:5px;margin-right:10px;'>"+time+"</font>"); 
		$(".notice-more").html(json.notice.noticeContent);
		getothernotice(json.notice.noticeBelongId,json.notice.noticeBelongType)
	})
	
}

function getcomment() {
	$(".comment").html("");
	var json={
			"noticeId":mynoticeId
			
	}
	$.getJSON("./GetAllComment",{json:JSON.stringify(json)},function(json){
		
	
		$(".page").html("    共有：<font style='color:red;'>"+json.length+"</font>条回复")
		for ( var i = 0; i < json.length; i++) {
			$(".comment").append('<div class="comment-one">'+
					'<div class="comment-one-left">'+
					'<div class="commenter-pic" style="background-image:url('+json[i].userPic+')"></div>'+
					'<div class="commenter-name">'+json[i].userName+'</div>'+
				'</div>'+
				'<div class="comment-one-right"><div style="text-align:right;font-size:13px;height:30px;">回复时间: <font style="color:#F47920;">'+json[i].commentTime+'</font></div>'+json[i].commentContent+'</div>'+
		'</div>');
		}
		
		
	})
}

function getothernotice(noticeBelongId,noticeBelongType) {
	var json={
			"noticeBelongId":noticeBelongId,
			"noticeBelongType":noticeBelongType
			
	}
	$.getJSON("./GetNoticeByBelong",{json:JSON.stringify(json)},function(json){   
		
		for ( var i = 0; i < json.length; i++) {
   	 var text=json[i].noticeTitle;
	 if (json[i].noticeTitle.length>15) {
		 text=json[i].noticeTitle.substring(0,15)+"...";
	}
	$(".notice-list-right").append("<div class='bu-one' title="+json[i].noticeTitle+"  onclick='tonoticed("+json[i].noticeId+")'><font style='color:red'>·</font>"+text+"</div>");	
}
		
	})
}

function commitcomment() {
	
		if (myuserid<=0) {
			alert("请登录")
		}else if($(".committext").find(".np").length>2){
			
			alert("图片数不能超出2张")
		}else if($(".committext").html()==""){
			alert("请输入点什么")
			$(".committext").focus()
		}
		else{
			var json={
					"userId":myuserid,
					"commentContent":$(".committext").html(),
					"noticeId":mynoticeId
					
			}
			$.getJSON("./CreateComment",{json:JSON.stringify(json)},function(json){ 
				 if (json.result="true") {
					 alert("发布成功");
					 $(".committext").html("");
					 getcomment();
				}else {
					alert("发布失败")
				}
			})
		}

}


function tonoticed(noid) {
	
	window.location.href="jsp/notice.jsp?mynoticeId="+noid;
}