//活动类
var hotativitylist=new Array();
function  hotativity(activityId,activityName,activityPic,activityContent,activityStartTime) {
	this.activityId=activityId;
	this.activityName=activityName;
	this.activityPic=activityPic;
	this.activityContent=activityContent;
	this.activityStartTime=activityStartTime;
}

//热门社团类
var hotcorporationlist=new Array();
var hotnotice=new Array();


$(document).ready(function(){

	gethotactivity();
	gethotcorporation();

	$('.activiysearchtime').dateDropper({bgColor:'#faf7f4',borderColor:'#faa755',textColor:'#9ed7db',color:'#faa755',format:'y-m-d'});//使用时间插件
	
	
	$(".panel-block").hover(function(){
		$(this).parent().find(".panel-title").hide();
	},function(){$(this).parent().find(".panel-title").show();})	
	
	showhotbulltin();
	
	var json={
			"userId":myuserid
	}
	if (myuserid!=0) {
		$.getJSON("./GetUserById",{json:JSON.stringify(json)},function(json){
				
				$(".barusername").html(json.userName);
				$(".barusername").attr("onclick","topersonal()");
				$(".barusername").after("    <div class='loginout' >登出</div>")
				
	})
	}
	
}
)
function login() {
	window.location.href="jsp/login.jsp"
}

//自动变化
var hotnum=-1;
function countSecond(){　
　	hotnum=hotnum+1;
	if (hotnum==5) {
	
		hotnum=0;
	}
	changepointer($(".hotactivityblackpoint div").eq(hotnum),hotnum)
　 	setTimeout("countSecond()", 10000)
}






//获取活动
function gethotactivity(){
	$.getJSON("./GetHotActivity",function(json){
		for ( var i = 0; i < json.length; i++) {
			hotativitylist.push(new hotativity(json[i].activity.activityId,json[i].activity.activityName,json[i].activestagePic,json[i].activestageContent,json[i].activity.activityStartTime));
			
		}
		$("#hotactivity").css("background-image","url('"+hotativitylist[0].activityPic+"')");
		$(".hotactivitytitle").html(hotativitylist[0].activityName);
		$(".hotactivitydetail font").attr("onclick","toactivityd("+hotativitylist[0].activityId+")");
		$(".hotactivitycontent").html(hotativitylist[0].activityContent);
		$(".hotactivitystarttime").html(hotativitylist[0].activityStartTime);
		countSecond(0);
	})
	
}
//获取社团
function gethotcorporation() {
	$.getJSON("./GetHotcorporation",function(json){
		hotcorporationlist=json;
		$(".panel2-line1-block1").css("background-image","url('"+hotcorporationlist[0].corporationPic+"')");
		$(".panel2-line1-block2").css("background-image","url('"+hotcorporationlist[1].corporationPic+"')");
		$(".panel2-line2-block1").css("background-image","url('"+hotcorporationlist[2].corporationPic+"')");
		$(".panel2-line2-block2").css("background-image","url('"+hotcorporationlist[3].corporationPic+"')");
		$(".panel2-line2-block3").css("background-image","url('"+hotcorporationlist[4].corporationPic+"')");
		$(".panel2-line3-block1").css("background-image","url('"+hotcorporationlist[5].corporationPic+"')");
		$(".panel2-line3-block2").css("background-image","url('"+hotcorporationlist[6].corporationPic+"')");
		for ( var i = 0; i < 7; i++) {
			$(".panel-title").eq(i).html(hotcorporationlist[i].corporationName);
			$(".panel-block").eq(i).attr("onclick","tocorporationpage("+hotcorporationlist[i].corporationId+")")
			$(".panel-block-title").eq(i).html(hotcorporationlist[i].corporationName);
			var text=hotcorporationlist[i].corporationIntroduction.substring(0,150)+"......";
			$(".panel-block-more").eq(i).html(text);	
		}
		
		
	});
}


//点击小点
function changepointer(x,num){
	hotnum=num;
	
	$("#whitepointer").attr("id","");
	$(x).attr("id","whitepointer");
	$("#hotactivity").css("background-image","url('"+hotativitylist[num].activityPic+"')");
	$(".hotactivitytitle").html(hotativitylist[num].activityName);
	$(".hotactivitydetail font").attr("onclick","toactivityd("+hotativitylist[num].activityId+")");

	$(".hotactivitycontent").html(hotativitylist[num].activityContent);
	$(".hotactivitystarttime").html(hotativitylist[num].activityStartTime);
}
//显示黑板
function hotactivityblackshow() {
	$(".hotactivityblack").css("top",380);
	$(".hotactivityblackgo").attr("onclick","hotactivityblackhide()");
	$(".hotactivityblackgo").html("<i class='iconfont'>&#xf02a9;</i>");
	$(".hotactivitysearch").slideToggle(400)
}
//影藏黑板
function hotactivityblackhide() {
	$(".hotactivityblack").css("top",460);
	$(".hotactivityblackgo").attr("onclick","hotactivityblackshow()");
	$(".hotactivityblackgo").html("<i class='iconfont'>&#xf02aa;</i>");
	$(".hotactivitysearch").slideToggle(400)
	
}
//展示并播放
function playvideo() {
	$(".shadow").fadeIn();
	document.getElementById("vi").play();
	$("#govideo").css("top",110);
}
//关闭退出
function closevideo() {
	$(".shadow").fadeOut();
	document.getElementById("vi").pause();

}

//暂停
function offvideo(){
	document.getElementById("vi").pause();
	var videoheight= document.body.clientHeight/2;
	$("#govideo").css("top","-"+videoheight);
	
	
}
//继续
function govideo() {
	document.getElementById("vi").play();
	$("#govideo").css("top",110);
}
//显示热门公告
function showhotbulltin() {
	$.getJSON("./GetHotNotice",function(json){
	     for ( var i = 0; i < 20; i++) {
	    	 var text=json[i].noticeTitle;
	    	 if (json[i].noticeTitle.length>13) {
	    		 text=json[i].noticeTitle.substring(0,13)+"...";
			}
	    	 
			if(i<5){
				$(".bu-mm").eq(0).append("<div onclick='tonoticed("+json[i].noticeId+")' class='bu-one'title="+json[i].noticeTitle+"><font>·</font>"+text+"</div>");
			}else if(i<10){
				$(".bu-mm").eq(1).append("<div onclick='tonoticed("+json[i].noticeId+")' class='bu-one'title="+json[i].noticeTitle+"><font>·</font>"+text+"</div>");
			}else if (i<15) {
				$(".bu-mm").eq(2).append("<div onclick='tonoticed("+json[i].noticeId+")' class='bu-one'title="+json[i].noticeTitle+"><font>·</font>"+text+"</div>");
			}else if (i<20) {
				$(".bu-mm").eq(3).append("<div onclick='tonoticed("+json[i].noticeId+")' class='bu-one'title="+json[i].noticeTitle+"><font>·</font>"+text+"</div>");
			}
		} 
	});

}
function tonotice() {
	window.location.href="jsp/noticelist.jsp"
}

function tocorporation() {
	window.location.href="jsp/corporationlist.jsp"
}
function toactivity() {
	window.location.href="jsp/activitylist.jsp"
}
function toyouth() {
	window.location.href="jsp/youth_league_committee.jsp"
}

function tosearchactivity() {
	var activityname=$(".activiysearchname").val();
	var time=$(".activiysearchtime").val();
	var address=$(".activiysearchaddress").val();
	window.location.href="jsp/activitylist.jsp?acname="+activityname+"&actime="+time+"&acaddress="+address;
}
function topersonal() {
	window.location.href="jsp/personal.jsp"
}
function toactivityd(x) {
	window.location.href="jsp/activity.jsp?myactivityId="+x;
} 
function tocorporationpage(mycorporationId) {
	window.location.href="jsp/corporation.jsp?mycorporationId="+mycorporationId;

}
function tonoticed(noid) {
	window.location.href="jsp/notice.jsp?mynoticeId="+noid;
}