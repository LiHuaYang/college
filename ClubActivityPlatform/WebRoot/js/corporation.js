$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showcorporationdetail();
	showmember();
	shownotive();
})
function showcorporationdetail() {
	var json={
			"corporationId":mycorporationId
	}
	$.getJSON("./GetCorporationDetailById",{json:JSON.stringify(json)},function(json){
		$(".cpic").css("background-image","url("+json.corporationPic+")");
		$(".cpic-title").html(json.corporationName);
		$(".corporation-content-more").html(json.corporationIntroduction);
		
	})
}
function showmember() {
	var json={
			"corporationId":mycorporationId
	}
	$.getJSON("./GetCorporationMembers",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
			var grade=json[i].userName;
			var background='style="background-color:rgba(0,0,0,0.7)"';
			if (json[i].userGrade==4) {
				grade="社长："+json[i].userName;
				background='style="background-color:rgba(255,0,0,0.7)"';
			}else if(json[i].userGrade==3){
				grade="副社长："+json[i].userName;
				background='style="background-color:rgba(32,136,59,0.7)"';
			}else if(json[i].userGrade==2){
				
				background='style="background-color:rgba(244,121,32,0.7)"';
			}
			$(".corporation-member-all").append(
					'<div class="member-one"style="background-image:url('+json[i].gradePic+')">'+
						'<div style="overflow: hidden; margin-top:60px; height:30px;">'+
							'<div class="member-one-name" '+background+'>'+grade+'</div>'+
						'</div>'+
					'</div>')
		}
		
		
	})
}
var nowpage=0;
var page=0;
function shownotive() {
	var json={
			"noticeBelongId":mycorporationId,
			"noticeBelongType":1
			
	}
	$.getJSON("./GetNoticeByBelong",{json:JSON.stringify(json)},function(json){
		bulltinlist=json;
		var max=8;
		if (json.length<max) {
			max=json.length
		}
	     for ( var i = 0; i <max; i++) {
	    	var time=json[i].noticeStartTime.split(".");
	    	
	    	$(".corporation-notice-list").append('<div class="noticeone" ><div class="noticeone-title" onclick="tonoticed('+json[i].noticeId+')">'+json[i].noticeTitle+'</div><div class="noticeone-time">'+time[0]+'</div></div>');	
		}
	      page=Math.ceil(json.length/8);
		 	$(".pagecount").append('<font style="color: black;font-size: bold;"onclick=" changepage(0)">1</font>');
		    for ( var i = 1; i < page; i++) {
		    	var x=i+1;
		    	$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>')
			}
	});
}
function nextpage() {
	if (nowpage<page-1) {
	
		nowpage++;
		changepage(nowpage);
	}
	
}
function prevpage(){
	if (nowpage>0) {
		nowpage--;
		changepage(nowpage);
	}
}
//更改页码
function changepage(num) {
	nowpage=num;
		var min=num*8;
		var max=num*8+8;
		if (max>bulltinlist.length) {
			max=bulltinlist.length;
		}
		$(".corporation-notice-list").html("");
	 for ( var i = min; i <max ; i++) {
		 var time=bulltinlist[i].noticeStartTime.split(".");
	    $(".corporation-notice-list").append('<div class="noticeone"><div class="noticeone-title">'+bulltinlist[i].noticeTitle+'</div><div class="noticeone-time">'+time[0]+'</div></div>');	
	}
	 $(".pagecount").html("");
	 
	  for ( var i = 0; i < page; i++) {
	    	var x=i+1;
	    	if (i==num) {
	    		$(".pagecount").append(' <font style="color: black;font-size: bold;" onclick=" changepage('+i+')">'+x+'</font>');
			}else {
				$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>');
			}
	    	
	}
}
function iright() {
	var left=parseInt($(".corporation-member-all").css("left"))-parseInt(140);

	if(left>-parseInt($(".corporation-member-all").find(".member-one").length)*140+parseInt(140)*5){
		$(".corporation-member-all").css("left",left);
	}
}
function ileft() {
	var left=parseInt($(".corporation-member-all").css("left"))+parseInt(140);

	if(parseInt($(".corporation-member-all").css("left"))<0){
		$(".corporation-member-all").css("left",left);
	}
}

function partin() {
	if (myuserid<=0) {
		alert("请登录")
	}else {
		
		var json={
				"belongId":mycorporationId,
				"belongType":1,
				"userName":$(".barusername").html(),
				"userId":myuserid,
				"registrationContent":$(".part-text").val()
		}
		$.getJSON("./ApplyingRegistration",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("申请成功")
			closeblackbar();
			
		}else{
			alert("你已经提交了申请，请耐心等候");
		}
		})
	}
}
function reset() {
	$(".part-text").val("");
}
function tonoticed(noid) {
	
	window.location.href="jsp/notice.jsp?mynoticeId="+noid;
}