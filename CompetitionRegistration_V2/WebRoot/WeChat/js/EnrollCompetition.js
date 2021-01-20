$(document).ready(function(){
	if(baruserid!=0){
		Show_Enroll_com();   // 显示已报名比赛
	}
	else{
		alert("请先登录");
	}
});

//显示已报名比赛
function Show_Enroll_com(){
	
	$.ajax({
		type: "GET",
		url: "./GetEnrollComByUseridServlet",
		data:{UserId:baruserid},
		dataType: "json",
		success: function(json){
			for ( var i = 0; i < json.result.length; i++) {
				var competitionId=json.result[i].competitionId;
				var StudentGrade=json.result[i].studentGrade;
				switch(StudentGrade){
					case "0":
						StudentGrade=" ";
						break;
					case "1":
						StudentGrade="小学一年级";
						break;
					case "2":
						StudentGrade="小学二年级";
						break;
					case "3":
						StudentGrade="小学三年级";
						break;
					case "4":
						StudentGrade="小学四年级";
						break;
					case "5":
						StudentGrade="小学五年级";
						break;
					case "6":
						StudentGrade="小学六年级";
						break;
					case "7":
						StudentGrade="初中一年级";
						break;
					case "8":
						StudentGrade="初中二年级";
						break;
					case "9":
						StudentGrade="初中三年级";
						break;
					case "10":
						StudentGrade="高中一年级";
						break;
					case "11":
						StudentGrade="高中二年级";
						break;
					case "12":
						StudentGrade="高中三年级";
						break;
				}
				
				$(".enroll_each_box").append(
					'<div class="enroll_each" onclick="go_Com('+competitionId+')">'
						+'<div class="com_name">'+json.result[i].competitionName+'</div>'
						+'<div class="com_session">'+json.result[i].competitionSession+'届</div>'
						+'<div class="com_people">参赛者：'+json.result[i].studentName+'</div>'
						+'<div class="com_time_address">'
							+'<div class="com_time">比赛时间：'+json.result[i].startTime+'</div>'
							+'<div class="com_address">准考证领取地址：'+json.result[i].organizationAddress+'</div>'
						+'</div>'
						+'<div class="com_type_rank">'
							+'<div class="com_type">比赛类别：'+json.result[i].contestSubject+'</div>'
							+'<div class="com_rank">比赛等级：'+StudentGrade+'</div>'
						+'</div>'
					+'</div>'
				)
			}
		}
	})
}

//跳转到详细比赛界面
function go_Com(competitionId){
	window.location.href="WeChat/jsp/details.jsp?competitionId="+competitionId;
}
