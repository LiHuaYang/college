$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	$('.activiysearchtime').dateDropper({bgColor:'#faf7f4',borderColor:'#faa755',textColor:'#9ed7db',color:'#faa755',format:'y-m-d'});//ʹ��ʱ����
	showhotactivity();
	showactivitylist();
	$(".activiysearchname").val(acname);
	$(".activiysearchtime").val(actime);
	$(".activiysearchaddress").val(acaddress);
})

function showhotactivity() {
	$.getJSON("./GetHotActivity",function(json){
		for ( var i = 0; i < 4; i++) {
			var text=json[i].activestageContent;
	    	 if (json[i].activestageContent.length>50) {
	    		 text=json[i].activestageContent.substring(0,50)+"...";
			}
	    	var activitystate='<div style="border-radius:5px;background:red;color:white;width:80px;float:right;text-align:center;margin-right:10px;">火热进行中</div>';
	    	if (json[i].activity.activityState==6) {
	    		activitystate='<div style="border-radius:5px;background:rgb(150,150,150);color:white;;width:50px;float:right;text-align:center;margin-right:10px;">已结束</div>';
			}
	    	
			$(".hotactivity-more").append('<div class="hotactivity-one" onclick=toactivityd('+json[i].activity.activityId+')>'+
					'<div class="hotactivity-one-pic" style="background-image:url('+json[i].activestagePic+')"></div>'+
					'<div class="hotactivity-one-title">'+json[i].activity.activityName+'</div>'+
					'<div class="hotactivity-one-buttom">地点：<font style="color:#f47920">'+json[i].activity.activityAddress+'</font>'+activitystate+'</div>'+
					'<div class="hotactivity-one-content">'+text+'</div>'+
				'</div>')
		}
	})
}
var nowpage=0;
var page=0;
var activitylist=new Array();
function showactivitylist() {
	$.getJSON("./GetActivityBulletin",function(json){
		activitylist=json;
		var len=8;
		
		if (json.length<8) {
			len=json.length;
		}
		for ( var i = 0; i < len; i++) {
			var text=json[i].activestageContent;
	    	 if (json[i].activestageContent.length>50) {
	    		 text=json[i].activestageContent.substring(0,50)+"...";
			}
	    	var activitystate='<div style="border-radius:5px;background:red;color:white;width:80px;float:right;text-align:center;margin-right:10px;">火热进行中</div>';
	    	if (json[i].activityState==6) {
	    		activitystate='<div style="border-radius:5px;background:rgb(150,150,150);color:white;;width:50px;float:right;text-align:center;margin-right:10px;">已结束</div>';
			}
	    	
			$(".activitylist-row-list").append('<div class="hotactivity-one" onclick=toactivityd('+json[i].activityId+')>'+
					'<div class="hotactivity-one-pic" style="background-image:url('+json[i].activestagePic+')"></div>'+
					'<div class="hotactivity-one-title">'+json[i].activityName+'</div>'+
					'<div class="hotactivity-one-buttom">地点：<font style="color:#f47920">'+json[i].activityAddress+'</font>'+activitystate+'</div>'+
					'<div class="hotactivity-one-content">'+text+'</div>'+
				'</div>')
		}
		 page=Math.ceil(json.length/8);
		 	$(".pagecount").append('<font style="color: black;font-size: bold;"onclick=" changepage(0)">1</font>');
		    for ( var i = 1; i < page; i++) {
		    	var x=i+1;
		    	$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>')
			}
		
	})

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
		if (max>activitylist.length) {
			max=activitylist.length;
		}
		$(".activitylist-row-list").html("");
	 for ( var i = min; i <max ; i++) {
		 var text=activitylist[i].activestageContent;
    	 if (activitylist[i].activestageContent.length>50) {
    		 text=activitylist[i].activestageContent.substring(0,50)+"...";
		}
    	var activitystate='<div style="border-radius:5px;background:red;color:white;width:80px;float:right;text-align:center;margin-right:10px;">火热进行中</div>';
    	if (activitylist[i].activityState==6) {
    		activitystate='<div style="border-radius:5px;background:rgb(150,150,150);color:white;;width:50px;float:right;text-align:center;margin-right:10px;">已结束</div>';
		}
    	
		$(".activitylist-row-list").append('<div class="hotactivity-one" onclick=toactivityd('+activitylist[i].activityId+')>'+
				'<div class="hotactivity-one-pic" style="background-image:url('+activitylist[i].activestagePic+')"></div>'+
				'<div class="hotactivity-one-title">'+activitylist[i].activityName+'</div>'+
				'<div class="hotactivity-one-buttom">地点：<font style="color:#f47920">'+activitylist[i].activityAddress+'</font>'+activitystate+'</div>'+
				'<div class="hotactivity-one-content">'+text+'</div>'+
			'</div>')
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


//搜索activity
function searchactivity() {
	var activityname=$(".activiysearchname").val();
	var time=$(".activiysearchtime").val();
	var address=$(".activiysearchaddress").val();
	var json={
			"activityName":activityname,
			"activityTime":time,
			"activityAddress":address
	}
	$.getJSON("./SearchActivityBulletin",{json:JSON.stringify(json)},function(json){
		$(".hotactivity").slideUp(300);
		$(".pagecount").html("");
		$(".activitylist-row-list").html("");
		$(".activiysearchtime").val("");
		activitylist=json;
		var len=8;
		if (json.length<8) {
			len=json.length;
		}
		for ( var i = 0; i < len; i++) {
			var text=json[i].activestageContent;
	    	 if (json[i].activestageContent.length>50) {
	    		 text=json[i].activestageContent.substring(0,50)+"...";
			}
	    	var activitystate='<div style="border-radius:5px;background:red;color:white;width:80px;float:right;text-align:center;margin-right:10px;">火热进行中</div>';
	    	if (json[i].activityState==6) {
	    		activitystate='<div style="border-radius:5px;background:rgb(150,150,150);color:white;;width:50px;float:right;text-align:center;margin-right:10px;">已结束</div>';
			}
	    	
			$(".activitylist-row-list").append('<div class="hotactivity-one" onclick=toactivityd('+json[i].activityId+')>'+
					'<div class="hotactivity-one-pic" style="background-image:url('+json[i].activestagePic+')"></div>'+
					'<div class="hotactivity-one-title">'+json[i].activityName+'</div>'+
					'<div class="hotactivity-one-buttom">地点：<font style="color:#f47920">'+json[i].activityAddress+'</font>'+activitystate+'</div>'+
					'<div class="hotactivity-one-content">'+text+'</div>'+
				'</div>')
		}
		 page=Math.ceil(json.length/8);
		 	$(".pagecount").append('<font style="color: black;font-size: bold;"onclick=" changepage('+i+')">1</font>');
		    for ( var i = 1; i < page; i++) {
		    	var x=i+1;
		    	$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>')
			}
	});
}
function toactivityd(x) {
	window.location.href="jsp/activity.jsp?myactivityId="+x;
} 