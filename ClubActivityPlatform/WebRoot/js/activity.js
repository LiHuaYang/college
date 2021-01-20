$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	getdetail();
	 getactivestage();
	 getpartman();
})
function getdetail() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetActivityDetail",{json:JSON.stringify(json)},function(json){
		var x="社联";
		if (json.activityBelongId==1) {
			x="学生会"
		}else if (json.activityBelongId==2) {
			x="团委"
		}
		$(".zx1 font").html(json.activityName);
		$(".zx2 font").html(x);
		$(".zx3 font").html(json.activityAddress);
		$(".zx4 font").html(json.activityStartTime);
		$(".zx5 font").html(json.activityEndTime);
		if(json.activityState!=4){
			$(".partin").attr("onclick","");
			$(".partin").html("无法报名")
			$(".partin").attr("class","partout");
		}
	})
}

function getactivestage() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetActivestageByActivityId",{json:JSON.stringify(json)},function(json){
		$(".activitypic").css("background-image","url("+json[0].activestagePic+")")
		$(".cx1").html(json[0].activestageContent);
		for ( var i = 1; i < json.length; i++) {
			$(".activestages").append('<div class="activestage">'+
					'<div class="activestage-pic" style="background-image:url('+json[i].activestagePic+')"></div>'+
					'<div class="activestage-more">'+
						'<div class="activestage-title"><font>'+json[i].activestageName+'</font><font style="float: right;">发布时间：'+json[i].activestageTime+'</font></div>'+
						'<div class="activestage-content">'+json[i].activestageContent+'</div>'+
				'	</div>'+
				'</div>')
		}
	})
}

function getpartman() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetParticipantsByActivityId",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
			$(".parts").append("<div>"+json[i].participantsName+"</div>")	
		}
	
	})
}


function partinactivity() {
	if (myuserid<=0) {
		alert("请登录")
	}else {
		var json={
				"activityId":myactivityId,
				"participantsId":myuserid,
				"participantsName":$(".barusername").html()
		}
		$.getJSON("./EnterActivity",{json:JSON.stringify(json)},function(json){
	
			if (json.result==true) {
				alert("申请成功")
				
			}else{
				alert("你已经提交了申请，请耐心等候");
			}
				
			
		})
	}

}