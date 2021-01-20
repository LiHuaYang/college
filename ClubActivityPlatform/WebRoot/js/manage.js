$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
/*	alert(mygrade);
	alert(mybelongId);
	alert(mybelongType);*/
	getinfo();
	getnotice();
	getmember();
	if (mybelongType==2||mybelongType==0&&mygrade==4) {
	
		getactivity();
	}
})
var pic;
//修改资料
function changebasic() {
	$(".infoblack").show();
	$(".gradeimg").css("background-image","url('"+pic+"')");
	$(".gradeimg").attr("img",pic);
	$(".grade-content").html($(".basic-content").html());
}
function closeg() {
	$(".infoblack").hide();
	$(".acblack").hide();
	$(".noblack").hide();
	$(".apblack").hide();
}
//修改确定
function commitchange() {
	var json={
			"organizationId":mybelongId,
			"organizationIntroduction":$(".grade-content").html(),
			"organizationPic": $(".gradeimg").attr("img")
	}
	$.getJSON("./ChangeOrganzation",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			closeg();
			getinfo();
		}
		else {
			alert("无法提交");
		}
	})
	
}

function tonoticed(noid) {
	
	window.location.href="jsp/notice.jsp?mynoticeId="+noid;
}


function getinfo() {
	if (mybelongType==0) {
		var json={
				"departmentId":mybelongId
		}
		$.getJSON("./GetDepartmentDetail",{json:JSON.stringify(json)},function(json){
			organizationId=json.departmentBelongId;
			var ot="学生会";
			if (organizationId==2) {
				ot="团委";
			}else if (organizationId==3) {
				ot="社联";
			}
			var name=json.departmentName+"("+ot+")";
			$(".basic-pic").css("background-image","url("+json.departmentPic+")")
			$(".basic-content").html(json.departmentIntroduction);
			$(".basic-name").html(name);
			pic=json.departmentPic;
		})
	}else if (mybelongType==1) {
		var json={
				"corporationId":mybelongId
		}
		$.getJSON("./GetCorporationDetailById",{json:JSON.stringify(json)},function(json){
			$(".basic-pic").css("background-image","url("+json.corporationPic+")")
			$(".basic-content").html(json.corporationIntroduction);
			$(".basic-name").html(json.corporationName);
			pic=json.corporationPic;
		})
	}else if (mybelongType==2) {
		var json={
				"organizationId":mybelongId
				
		}
		$.getJSON("./GetOrganizationDetail",{json:JSON.stringify(json)},function(json){
			$(".basic-pic").css("background-image","url("+json.organizationPic+")")
			$(".basic-content").html(json.organizationIntroduction);
			$(".basic-name").html(json.organizationName);
			pic=json.organizationPic;
		})
	}
}

function t(x) {
	if (x==0) {
		return "策划阶段";
	}else if(x==1){
		return "策划审核阶段";
	}else if (x==2) {
		return "任务方案制定阶段";
	}else if (x==3) {
		return "任务方案审核阶段";
	}else if(x==4){
		return "活动进行阶段";
	}else if (x==5) {
		return "活动总结阶段";
	}else if (x==6) {
		return "活动结束阶段"
	}
}

function getactivity() {
	var json={
			"organizationId":mybelongId
			
	}

	$.getJSON("./GetAllActivityByOrganizationId",{json:JSON.stringify(json)},function(json){
		$(".activity-list").html("");
		for ( var i = 0; i < json.length; i++) {
			$(".activity-list").append('<div class="activity-one">'+
		   			'<div class="activity-one-name">'+json[i].activityName+'</div>'+
		   			'<div style="width:200px">'+t(json[i].activityState)+'</div>'+
		   			'<div >意向：'+json[i].activityIntention+'</div>'+
		   			'<div style="width: 100px;float: right;">'+
		   			'<button onclick="toactivitymanage('+json[i].activityId+')">管理</button>'+
		   			'<button>删除</button>'+
		   			'</div>'+
		   			'</div>')
		   			
		}
	})
}

function toactivitymanage(id) {
	window.location.href="jsp/activitymanage.jsp?mygrade="+mygrade+"&myactivityId="+id;
}

function getnotice() {
	var json={
			"noticeBelongId":mybelongId,
			"noticeBelongType":mybelongType
			
	}
	$.getJSON("./GetNoticeByBelong",{json:JSON.stringify(json)},function(json){   
		
		for ( var i = 0; i < json.length; i++) {
			var time=json[i].noticeStartTime.split(".");
			$(".notice-list").append('<div class="noticeone"><div class="noticeone-title"  onclick="tonoticed('+json[i].noticeId+')">'+json[i].noticeTitle+'</div><div class="noticeone-time">'+time[0]+'</div></div>');	
			
		}
	})
}
function getmember() {
	var json={
			"corporationId":mybelongId
	}
	var load="./GetCorporationMembers";
	if (mybelongType==2) {
		load="./GetOrganizationMember";
		json={
				"organizationId":mybelongId
		}
	}else if (mybelongType==0) {
		load="./GetDepartmentMembers";
		json={
				"departmentId":mybelongId
		}
	}
	$.getJSON(load,{json:JSON.stringify(json)},function(json){
		$(".member-list").html("");
		for ( var i = 0; i < json.length; i++) {
			var gradename=getgradename(mybelongType, json[i].userGrade);
			if (json[i].userGrade==4&&mybelongType==2) {
				gradename=json[i].departmentName+gradename;
			}
			if (json[i].userGrade<mygrade) {
				$(".member-list").append('<div class="member-one"><div style="width:200px;display:inline-block;">'+json[i].userName+'</div>'+gradename+'<button style="float:right;">操作</button></div>')
				$("#p").append('<option  value ='+json[i].userId+'>'+gradename+json[i].userName+'</option>');
				$("#p2").append('<option  value ='+json[i].userId+'>'+gradename+json[i].userName+'</option>');
			}
		}
		
		
	})
	
}
function createactivity() {
	$(".acblack").show();
}
function createactivityok() {
	var json={
			"activityBelongId":mybelongId,
			"activityIntention":$(".m-content").html(),
			"plotterId":$("#p  option:selected").val(),
			"plannerId":$("#p2  option:selected").val()
	}
	$.getJSON("./CreateActivity",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			closeg();
			getactivity();
		}
		else {
			alert("无法提交");
		}
	})
}

function createnotice() {
	$(".noblack").show();
}
function createnoticeok() {
	var json={
			"noticeTitle":$("#noticetitlein").val(),
			"noticeContent":'<div class="np"  style="background-image:url('+$(".noticeimg").attr("img")+')"></div></br>'+$(".n-content").html(),
			"noticeBelongType":mybelongType,
			"noticeBelongId":mybelongId,
			"noticePicture":$(".noticeimg").attr("img")
	}
	$.getJSON("./CreateNotice",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			closeg();
			getnotice();
		}
		else {
			alert("无法提交");
		}
	})
}

function showapply() {
	$(".apblack").show();
	var json={
			"belongId":mybelongId,
			"belongType":mybelongType
			
	}
	
	$.getJSON("./GetRegistrationByBelong",{json:JSON.stringify(json)},function(json){
		$(".aplist").html("");
		for ( var i = 0; i < json.length; i++) {
			var text=json[i].registrationContent;
			if (json[i].registrationContent.length>15) {
	    		 text=json[i].registrationContent.substring(0,15)+"...";
			}
			$(".aplist").append("<div class='ap-one'><div style='width:80px;'>"+json[i].userName+"</div>"+text+"<span style='float:right'><button onclick='partok("+json[i].userId+")'>同意</button><button onclick='partno("+json[i].userId+")'>拒绝</button></span></div>")
		}
	})
}

function partok(id) {
	var json={
			"belongId":mybelongId,
			"belongType":mybelongType,
			"userId":id
	}
	$.getJSON("./SubmitRegistration",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			showapply();
		}
		else {
			alert("无法提交");
		}
	})
}
function partno(id) {
	var json={
			"belongId":mybelongId,
			"belongType":mybelongType,
			"userId":id
	}
	$.getJSON("./RefuseRegistration",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			showapply()
		}
		else {
			alert("无法提交");
		}
	})
}

//获取职位名称
function getgradename(type,grade) {
	var gradename="";
	if (type==0) {
		switch (grade) {
		case 1:
			gradename="干事"
			break;
		case 2:
			gradename="副部长"
			break;
		case 3:
			gradename="常副"
			break;
		case 4:
			gradename="部长"
			break;
		default:
			break;
		}
	}else if(type==1){
		switch (grade) {
		case 1:
			gradename="成员"
			break;
		case 2:
			gradename="骨干"
			break;
		case 3:
			gradename="副社长"
			break;
		case 4:
			gradename="社长"
			break;
		case 10:
			gradename="公告管理人"
			break;
		case 12:
			gradename="器材管理人";
			break;
		case 13:
			gradename="资金管理人";
			break;
		default:
			break;
		}
	}else {
		switch (grade) {
		case 4:
			gradename="部长"
			break;
		case 5:
			gradename="副主席"
			break;
		case 6:
			gradename="主席"
			break;
		case 10:
			gradename="公告管理人"
			break;
		case 11:
			gradename="活动布告管理人";
			break;
		case 12:
			gradename="器材管理人";
			break;
		case 13:
			gradename="资金管理人";
			break;
		default:
			break;
		}
	}
	return gradename;
}