$(document).ready(function(){
	//alert(userId);
	if(userId!=0){
	getMyMatch();
	}
	
});
function getMyMatch(){
	$.ajax({
		type: "GET",
		url: "./GetScoreByUseridServlet",
		data:{UserId:userId},
		dataType: "json",
		success: function(json){
		//	alert(json.flag);
			if(json.flag){
				//alert(json.result[0].contestSubject);
				for(var i=0;i<json.result.length;i++){
					$(".mymatchbody").append(
							"<table class='matchlist' onclick=todetails("+json.result[i].competitionId+")>"+
			       			"<tr>"+
			       				"<span class='tablehead' >"+json.result[i].competitionName+"</span>"+
			       			"</tr>"+
			       			"<tr>" +
			       				"<td>"+
			       					"<div class='divkuang'>第"+json.result[i].competitionSession+"届</div>"+
			       				"</td>"+
			       			"</tr>"+
			       			"<tr>"+
			       				"<td>比赛等级:</td>"+
			       				"<td>"+matchGrade(json.result[i].studentGrade)+"</td>"+
			       			"</tr>"+
			       			"<tr>"+
			       				"<td>比赛类别:</td>"+
			       				"<td>"+json.result[i].contestSubject+"</td>"+
			       			"</tr>"+
			       			"<tr>"+
			       				"<td>参赛人员:</td>"+
			       				"<td>"+json.result[i].studentName+"</td>"+
			       				"<td class='gradetd'>成绩:</td>"+
			       				"<td class='gradescore'>"+getgrade(json.result[i].studentscore)+"</td>"+
			       			"</tr>"+
			       		"</table>"
							);
				}
			}
			else{
				if(json.message=="搜索为空"){
					//alert(json.message);
					$(".mymatchnull").show();
				}
			}
		}
	});
}
var grade=["一","二","三","四","五","六"];
function matchGrade(a){
	if(a<=6){
		var s="小学"+grade[a]+"年级";
		return s;
	}
	else if(a>6&&a<=9){
		var s="初中"+grade[a-6]+"年级";
		return s;
	}
	else if(a>9&&a<=12){
		var s="高中"+grade[a-9]+"年级";
		return s;
	}
}
function getgrade(a){
	if(a==-1){
		return "未出成绩";
	}else{
		return a;
	}
}



//跳转到详情界面
function todetails(competitionId){
	window.location.href = "WeChat/jsp/details.jsp?competitionId="+competitionId;
}