$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	setTimeout("getactivityde()", 500);

	getplan()
	getpartman();
	getactivestage();
})

function getactivityde() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetActivityDetail",{json:JSON.stringify(json)},function(json){
		$(".p font").html(getusername(json.plotterId));
		$(".p2 font").html(getusername(json.plannerId));
		$(".in-content").html(json.activityIntention);
		$(".zxh").html(json.activityName);
		$(".m1").html(json.activityStartTime);
		$(".m2").html(json.activityEndTime);
		$(".m3").html(json.activityAddress);
	})
}
function getactivestage() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetActivestageByActivityId",{json:JSON.stringify(json)},function(json){
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

function getplan() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetPlanByActivityId",{json:JSON.stringify(json)},function(json){
		$(".saz font").html(json.planName);
		$(".asd font").html(json.planContent);
	
	})
}
function getpartman() {
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetParticipantsByActivityId",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
			$(".part-list").append("<div style='display:inline-block;width:200px;margin:3px;borfrt-radius:5px;border:1px solid rgb(200,200,200)'>"+json[i].participantsName+"</div>")	
		}
	
	})
}
function closzg() {

	$(".psbac").hide();

}
function getapply() {
	$(".psbac").show();
	var json={
			"activityId":myactivityId
	}
	$.getJSON("./GetActivityEnter",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
			$(".plist").append("<div class='ap-one'><div style='width:80px;'>"+json[i].participantsName+"</div><span style='float:right'><button onclick='partok("+json[i].participantsId+")'>同意</button><button onclick='partno("+json[i].userId+")'>拒绝</button></span></div>")
		}
	
	})
}
function partok(id){
	
}