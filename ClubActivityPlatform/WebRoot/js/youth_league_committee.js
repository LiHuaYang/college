$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showdetail();
	shownotice();
	showdepartment();
	showmember();
	showactivitybulltin();

})
//显示团委详情
function showdetail() {
	var json={
			"organizationId":2
			
	}
	$.getJSON("./GetOrganizationDetail",{json:JSON.stringify(json)},function(json){
			$(".youth_league_committee_pic").css("background-image","url("+json.organizationPic+")")
			$(".youth_league_committee_contextmore").html(json.organizationIntroduction);
			
	})
}
//显示团委公告
function shownotice() {
	var json={
			"noticeBelongId":2,
			"noticeBelongType":2
			
	}
	$.getJSON("./GetNoticeByBelong",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
	    	 var text=json[i].noticeTitle;
	    	 if (json[i].noticeTitle.length>15) {
	    		 text=json[i].noticeTitle.substring(0,15)+"...";
			}
	    	$(".youth_league_committee_main1-right-notice").append("<div onclick='tonoticed("+json[i].noticeId+")' class='bu-one' title="+json[i].noticeTitle+"><font style='color:red'>·</font>"+text+"</div>");	
		}
		
})
}
var departments=new Array();
//显示部门
function showdepartment() {
	var json={
			"organizationId":2
			
	}
	$.getJSON("./GetDepartmentsByorganizationId",{json:JSON.stringify(json)},function(json){
		departments=json;
		for ( var i = 0; i < json.length; i++) {
			$(".department-list").append('<div class="department-one"onclick=todepartment('+json[i].departmentId+')>'+
					'<div class="department-one-image" style="background-image:url('+json[i].departmentPic+')"></div>'+
					'<div class="department-one-title">'+json[i].departmentName+'</div>'+
				'</div>');
		}
		
	})
}

function todepartment(id) {
	window.location.href="jsp/department.jsp?mydepartmentId="+id;
}
//显示团委成员
function showmember() {
	var json={
			"organizationId":2
			
	}
	$.getJSON("./GetOrganizationMember",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
			if (json[i].gradeBelongType==2) {
				if (json[i].userGrade==6) {
					$(".user-top").append('<div class="user-one" style="background-image:url('+json[i].gradePic+')" gradeid='+json[i].gradeId+'><div style="height:30px;overflow: hidden;"><div class="user-one-name">'+json[i].userName+'</div></div></div>')
				}
				else {
					$(".user-middle").append('<div class="user-one" style="background-image:url('+json[i].gradePic+')" gradeid='+json[i].gradeId+'><div style="height:30px;overflow: hidden;"><div class="user-one-name">'+json[i].userName+'</div></div></div>')
					
				}
			}else {
				$(".user-one-list").append('<div class="user-one" style="background-image:url('+json[i].gradePic+')" gradeid='+json[i].gradeId+'><div style="height:30px;overflow: hidden;"><div class="user-one-name">'+json[i].departmentName+"部长"+json[i].userName+'</div></div></div>')
			}
		}
	})
}
//显示团委活动
function showactivitybulltin() {
	var json={
			"organizationId":2
			
	}
	$.getJSON("./GetOrganizationBulletin",{json:JSON.stringify(json)},function(json){
		var length=6;
		if (json.length<6) {
			length=json.length;
		}
		for ( var i = 0; i <length ; i++) {
	    	var activitystate='<div style="margin-left:20px;border-radius:5px;background:red;color:white;width:50px;font-size:12px;text-align:center;">进行中</div>';
	    	if (json[i].activityState==6) {
	    		activitystate='<div style="margin-left:20px;border-radius:5px;background:rgb(150,150,150);color:white;;width:50px;text-align:center;font-size:12px;">已结束</div>';
			}
			$(".youth_league_committee_main2-right-activity").append('<div class="activity-one" onclick=" toactivityd('+json[i].activityId+')" >'+
					'<div class="activity-one-pic" style="background-image:url('+json[i].activestagePic+')"></div>'+
					'<div class="activity-one-name">'+
						'<div class="activity-one-name1">'+json[i].activityName+'</div>'+
						activitystate+
					'</div>'+
				'</div>')
		}
	})
	
}
function iright() {
	var left=parseInt($(".user-one-list").css("left"))-parseInt(152);

	if(left>-parseInt($(".user-one-list").find(".user-one").length)*152+parseInt(152)*2){
		$(".user-one-list").css("left",left);
	}
}
function ileft() {
	var left=parseInt($(".user-one-list").css("left"))+parseInt(152);

	if(parseInt($(".user-one-list").css("left"))<0){
		$(".user-one-list").css("left",left);
	}
}
function showblackbar() {
	if (myuserid<=0) {
		alert("请登录")
	}else {
		$(".sel").html("");
		$(".texta").val("");
		for ( var i = 0; i < departments.length; i++) {
			$(".sel").append("<option value="+departments[i].departmentId+">"+departments[i].departmentName+"</option>");
		}
		$(".shadow").show();
	}
	
}
function closeblackbar() {
	$(".shadow").hide();
	
}

//加入
function partinyouth() {
	var json={
			"belongId":$(".sel option:selected").val(),
			"belongType":0,
			"userName":$(".barusername").html(),
			"userId":myuserid,
			"registrationContent":$(".texta").val()
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
function tonoticed(noid) {
	window.location.href="jsp/notice.jsp?mynoticeId="+noid;
}
function toactivityd(x) {
	window.location.href="jsp/activity.jsp?myactivityId="+x;
} 