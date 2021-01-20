$(document).ready(function(){

	
}); 


//显示查询结果，根据大赛名称，科目
function showContestInfo(){
	
	var contestSearchWords=$(".searchwords").val(); //搜索条件
	$("#point").html("");
	$("#list").html("");
	$.ajax({
	type: "GET",
	url: "./GetContestInfobyNameObjectSubjectServlet",
	data:{contestSearchWords:contestSearchWords},
	dataType: "json",
	success: function(json){
		if(json.result.length==0){
			$("#point").html("搜索为空，请输入正确的赛事或科目。");
		}
		for(var i=0;i<json.result.length;i++){
			var contestState = json.result[i].competitionState;// 竞赛状态
		var contestObject = json.result[i].competitionObjectDescribe;// 竞赛年级
		var contestObjectString = "";
		var contestStateString = "";
		if (contestState == 1) {
			contestStateString = "即将开始报名";
		} else if (contestState == 2) {
			contestStateString = "正在报名";
		} else if (contestState == 3) {
			contestStateString = "比赛进行中";
		} else if (contestState == 4) {
			contestStateString = "比赛已结束";
		}
		if (contestObject <= 6 && contestObject >= 1) {
			contestObjectString = "小学生";
		} else if (contestObject <= 9 && contestObject >= 7) {
			contestObjectString = "初中生";
		} else if (contestObject <= 12 && contestObject >= 9) {
			contestObjectString = "高中生";
		}
		
		//查询科目
		var ContestObjectListSubject="";
		for(var j=0;j<json.result[i].contestList2.length;j++){
			 ContestObjectListSubject += json.result[i].contestList2[j].contestSubject+",";
		}
		ContestObjectListSubject=ContestObjectListSubject.substring(0,ContestObjectListSubject.length-1);//将最后一个逗号去掉
	  
		$("#list").append(						
				'<div class="singleton" onclick = "todetails('+json.result[i].competitionId+');">'
					+'<div class="image" ><img class = "image_1" src="'+json.result[i].competitionPicture+'"/></div>'
					+'<div class="info">'
					+'<div class="info_1">'+json.result[i].competitionName+'</div>'
					+'<div class="info_2">'+'报名截止时间：'+json.result[i].competitionEnrollEndTime+''+'</div>'
					+'<div class="info_3">'+'参赛对象：'+cutString(contestObject,40)+''+'</div>'
					+'<div class="info_3">'+'大赛科目：'+ContestObjectListSubject+'</div>'
					+'<div class="info_4">'+'赛事届数：'+json.result[i].competitionSession+''+'</div>'
					+'<div class="info_4">'+contestStateString+''+'</div>'
					+'</div>'
					+'</div>'
			)
		}
	}
})}

//跳转到详情界面
function todetails(competitionId){
	window.location.href = "WeChat/jsp/details.jsp?competitionId="+competitionId;
}


/**
 * 截取字符串
 * @param date
 * @param len
 * @return
 */
function cutString(date, len){
	//length属性读出来的汉字长度为1
	
    if(date.length*2 <= len) {
        return date;
    }
    var strlen = 0;
    var s = "";
    for(var i = 0;i < date.length; i++) {
        s = s + date.charAt(i);
        if (date.charCodeAt(i) > 128) {
            strlen = strlen + 2;
            if(strlen >= len){
                return s.substring(0,s.length-1) + " ....";
            }
        } else {
            strlen = strlen + 1;
            if(strlen >= len){
                return s.substring(0,s.length-2) + " ....";
            }
        }
    }
    return s;
}