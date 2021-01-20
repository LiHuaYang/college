$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showdetail();
	showmember();
	
})
var organizationId=0;
function showdetail() {
	var json={
			"departmentId":mydepartmentId
	}
	$.getJSON("./GetDepartmentDetail",{json:JSON.stringify(json)},function(json){
		$(".dpic-left").css("background-image","url("+json.departmentPic+")");
		organizationId=json.departmentBelongId;
		var ot="学生会";
		if (organizationId==2) {
			ot="团委";
		}else if (organizationId==3) {
			ot="社联";
		}
		var name=json.departmentName+"("+ot+")";
		$(".dpic-name").html(name);
		$(".dpic-context").html(json.departmentIntroduction);
		showdepartment();
	})
}
function showmember() {
	var json={
			"departmentId":mydepartmentId
	}
	$.getJSON("./GetDepartmentMembers",{json:JSON.stringify(json)},function(json){
		for ( var i = 0; i < json.length; i++) {
			var grade=json[i].userName;
			var background='style="background-color:rgba(0,0,0,0.7)"';
			if (json[i].userGrade==4) {
				grade="部长："+json[i].userName;
				background='style="background-color:rgba(255,0,0,0.7)"';
			}else if(json[i].userGrade==3){
				grade="常副："+json[i].userName;
				background='style="background-color:rgba(32,136,59,0.7)"';
			}else if(json[i].userGrade==2){
				
				background='style="background-color:rgba(244,121,32,0.7)"';
			}
			$(".dmember-list").append('<div class="dmember-one">'+	
   					'<div class="dmember-one-pic" style="background-image:url('+json[i].gradePic+')">'+
						'<div style="overflow: hidden; padding-top:60px; height:30px;">'+
							'<div class="dmember-one-name" '+background+'>'+grade+'</div>'+
						'</div>'+
					'</div>'+
					'<div class="dmember-one-content">'+json[i].gradeContent+'</div>'+
				'</div>')
		}
	})
}

function partin() {
	if (myuserid<=0) {
		alert("请登录")
	}else {
		
		var json={
				"belongId":mydepartmentId,
				"belongType":0,
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

//显示部门
function showdepartment() {
	
	var json={
			"organizationId":organizationId
			
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