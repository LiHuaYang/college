var bulltinlist=new Array();
$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	$('.noticeinput-starttime').dateDropper({bgColor:'#faf7f4',borderColor:'#faa755',textColor:'#9ed7db',color:'#faa755',format:'y-m-d'});//ʹ��ʱ����
	$('.noticeinput-endtime').dateDropper({bgColor:'#faf7f4',borderColor:'#faa755',textColor:'#9ed7db',color:'#faa755',format:'y-m-d'});//ʹ��ʱ����
	showhotbulltin();
	showallbulltin();
})
//显示热门公告
function showhotbulltin() {
	$.getJSON("./GetHotNotice",function(json){
	     for ( var i = 0; i < 15; i++) {
	    	 var text=json[i].noticeTitle;
	    	 if (json[i].noticeTitle.length>15) {
	    		 text=json[i].noticeTitle.substring(0,15)+"...";
			}
	    	$(".notice-row-right-more").append("<div class='bu-one' title="+json[i].noticeTitle+"  onclick='tonoticed("+json[i].noticeId+")'><font style='color:red'>·</font>"+text+"</div>");	
		}
	     
	});

}
var nowpage=0;
var page=0;
//显示所有公告
function showallbulltin() {
	$.getJSON("./GetAllNotice",function(json){
		bulltinlist=json;
		var max=15;
		if (json.length<max) {
			max=json.length
		}
	     for ( var i = 0; i <max; i++) {
	    	var time=json[i].noticeStartTime.split(".");
	    	
	    	$(".notice-row-left-list").append('<div class="noticeone"><div class="noticeone-title" onclick="tonoticed('+json[i].noticeId+')">'+json[i].noticeTitle+'</div><div class="noticeone-time">'+time[0]+'</div></div>');	
		}
	      page=Math.ceil(json.length/15);
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
		var min=num*15;
		var max=num*15+15;
		if (max>bulltinlist.length) {
			max=bulltinlist.length;
		}
		$(".notice-row-left-list").html("");
	 for ( var i = min; i <max ; i++) {
		 var time=bulltinlist[i].noticeStartTime.split(".");
	    $(".notice-row-left-list").append('<div class="noticeone"><div class="noticeone-title" onclick="tonoticed('+bulltinlist[i].noticeId+')">'+bulltinlist[i].noticeTitle+'</div><div class="noticeone-time">'+time[0]+'</div></div>');	
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

function searchnotice() {
	$(".notice-row-left-list").html("");
	var noticename=$(".noticeinput-name").val();
	var starttime=$(".noticeinput-starttime").val();
	var endtime=$(".noticeinput-endtime").val();
	var noticetype=$('input:radio[name="set"]:checked').val();
	if (starttime=="") {
		starttime="1000-10-10";
		
	}
	if (endtime=="") {
		endtime="9000-99-99";
	}
	var json={
			"noticeTitle":noticename,
			"noticeStartTime":starttime,
			"noticeEndTime":endtime,
			"noticeBelongType":noticetype
	}
	$.getJSON("./SearchNotice",{json:JSON.stringify(json)},function(json){
		bulltinlist=json;
		var max=15;
		if (json.length<max) {
			max=json.length
		}
	     for ( var i = 0; i <max; i++) {
	    	var time=json[i].noticeStartTime.split(".");
	    	
	    	$(".notice-row-left-list").append('<div class="noticeone"><div class="noticeone-title"  onclick="tonoticed('+json[i].noticeId+')">'+json[i].noticeTitle+'</div><div class="noticeone-time">'+time[0]+'</div></div>');	
		}
	      page=Math.ceil(json.length/15);
	      nowpage=0;
	      $(".pagecount").html("")
		 	$(".pagecount").append('<font style="color: black;font-size: bold;"onclick=" changepage('+i+')">1</font>');
		    for ( var i = 1; i < page; i++) {
		    	var x=i+1;
		    	$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>')
			}
	})
	$(".noticeinput-starttime").val("");
	$(".noticeinput-endtime").val("");
	
}


function tonoticed(noid) {
	
	window.location.href="jsp/notice.jsp?mynoticeId="+noid;
}