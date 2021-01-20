$(document).ready(function() {

    showcompetitionName();
    showproject();
    showobject();
    showhost();
});
function addcontender() {
	var number=-1;
	var grade = -1;
	switch($("#enrollmentState").val()){
	case "未付款":
		number=0;
		break;
	case "即将开始":
		number =1;
		break;
	case "已付款":
		number = 2;
		break;
	case "取消参加":
		number = 3;
		break;
	}
	switch ($("#ContestObject").val()) {
	case "小学一年级":
		grade = 1;
		break;
	case "小学二年级":
		grade = 2;
		break;
	case "小学三年级":
		grade = 3;
		break;
	case "小学三年级":
		grade = 3;
		break;
	case "小学四年级":
		grade = 4;
		break;
	case "小学五年级":
		grade = 5;
		break;
	case "小学六年级":
		grade = 6;
		break;
	case "初中一年级":
		grade = 7;
		break;
	case "初中二年级":
		grade = 8;
		break;
	case "初中三年级":
		grade = 9;
		break;
	case "高中一年级":
		grade = 10;
		break;
	case "高中二年级":
		grade = 11;
		break;
	case "高中三年级":
		grade = 12;
		break;
	}
	var json = {
			"StudentName" : $("#StudentName").val(),
			"StudentSex" : $("#StudentSex").val(),
			"StudentIDNumber" : $("#StudentIDNumber").val(),
			"StudentSchool" : $("#StudentSchool").val(),
			"StudentGrade" : $("#StudentGrade").val(),
			"StudentContactsMan" : $("#StudentContactsMan").val(),
			"StudentContactsPhon" : $("#StudentContactsPhon").val(),
			"UserAddress" : $("#UserAddress").val(),
			"StudentTeacher" : $("#StudentTeacher").val(),
			"StudentTeacherPhon" : $("#StudentTeacherPhon").val(),
			"CompetitionName" : $("#CompetitionName").val(),
			"CompetitionSession" : $("#CompetitionSession").val(),
			"ContestObject" : grade,
			"ContestSubject" : $("#ContestSubject").val(),
			"ContestMoney" : 0,
			"StartTime" : null,
			"EndTime" : null,
			"OrganizationName" : $("#OrganizationName").val(),
			"enrollmentState" : number,
			"StudentTicket" : null,
			"Studentscore" : 0,
			"StudentRank" : 0,
			"StudentPicture" : $("#StudentPicture").val()
			
		// 初始化为当前页数
		};
	console.log(json);
	$.getJSON("./AddContender", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
	});
}
function againstconversion(a)
{
	if(a==1)
		return "小学一年级";
	if(a==2)
		return "小学二年级";
	if(a==3)
		return "小学三年级";
	if(a==4)
		return "小学四年级";
	if(a==5)
		return "小学五年级";
	if(a==6)
		return "小学六年级";
	if(a==7)
		return "初中一年级";
	if(a==8)
		return "初中二年级";
	if(a==9)
		return "初中三年级";
	if(a==10)
		return "高中一年级";
	if(a==11)
		return "高中二年级";
	if(a==12)
		return "高中三年级";
}
function showcompetitionName()
{

var select = $("#CompetitionName");
	
	$.getJSON("./GetCompetitionNameServlet",
	function(json) {
		for(var i = 0 ; i < json.competitionbasicdata.length ; i++){			
			
			var competition_name = json.competitionbasicdata[i].competitionBasicName;
			var $op = $("<option></option>").html(competition_name);
			select.append($op);
		}	
	});
}
function showproject()
{
	 var select = $("#ContestSubject");
		
		$.getJSON("./GetCompetitionProjectServlet",
		function(json) {
			for(var i = 0 ; i < json.subjectbasicdata.length ; i++){			
				
				var competition_project = json.subjectbasicdata[i].subjectName;
				var $op = $("<option></option>").html(competition_project);
				select.append($op);
			}	
		});
}
function showobject()
{
	var select = $("#ContestObject");

	$.getJSON("./GetCompetitionObjectServlet",
	function(json) {
		for(var i = 0 ; i < json.gradebasicdata.length ; i++){			
			
			var competition_object = againstconversion(json.gradebasicdata[i].greadState);
			var $op = $("<option></option>").html(competition_object);
			select.append($op);
		}	
	});
}
function showhost()
{
	$.getJSON("./GetOrganizationInfo",
			function(jsonArray) {
				// alert(JSON.stringify(jsonObject));
				var select = $("#OrganizationName")
				var length = jsonArray.length;
				for (i=0; i<length; i++) {
					var Object = jsonArray[i];
					// jsonObject[i - 1].competitionName
					var name = Object.organizationName
					// alert("Name:::" + name);
					var $op = $("<option></option>").html(name);
					$op.val(Object.organizationId);
					// console.log(cc);
					select.append($op);
				}
			});
}