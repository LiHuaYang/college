
$(document).ready(function() {
	//定义下面菜单栏的字体颜色
	$(".gotoCompetitionlist").css("color","#0075c3");
	
	getCompetitionList();
})

var enroll_flag=2;    //点击正在报名2，即将报名标志1,
var school_flag=1;    //点击学校标志，小学1，初中2，高中3

var isEnrollcompetition = new Array();
var aboutEnrollcompetition = new Array();


/**
 * 小学 中学 高中 的点击函数
 * @param school
 * @return
 */
function school(school){
	if(school_flag == school){
		showCompetitionList();
	}else{
		clearArray(isEnrollcompetition);
		clearArray(aboutEnrollcompetition);
		school_flag = school;
		getCompetitionList();
	}
	
} 

/**
 * 即将开始 正在报名 的点击函数
 * @param state
 * @return
 */
function enroll(state){
	enroll_flag = state;
	showCompetitionList();
}

/**
 * 得到比赛列表数据 
 * @param grade
 * @param state
 * @return
 */
function getCompetitionList(){
	
	var json = {
			"competitionGrade" : school_flag
	};
	
	$.getJSON("./GetCompetitionListByGradeServlet", 
		{data : JSON.stringify(json)}, 
		function(jsonObject) {
			if(jsonObject.msg){
				setCompetitionList(jsonObject.data);
				showCompetitionList();
			}else{
				alert("服务器错误");
			}
			
	});	

}

/**
 * 处理比赛数据
 * @param json
 * @return
 */
function setCompetitionList(json){
	
	for(var i=0; i<json.length; i++){
		var data = json[i];
		if(data.competitionState == 1){
			var competition = new Object();
			competition.name = data.competitionName;
			competition.enrollStartTime = data.competitionEnrollStartTime;
			competition.objectDes = data.competitionObjectDescribe;
			competition.subject = data.BriefContest;
			competition.pic = data.competitionPicture;
			competition.session = data.competitionSession;
			competition.id = data.competitionId;
			
			aboutEnrollcompetition.push(competition);
		}else if(data.competitionState == 2 || data.competitionState == 5){
			var competition = new Object();
			competition.name = data.competitionName;
			competition.enrollEndTime = data.competitionEnrollEndTime;
			competition.objectDes = data.competitionObjectDescribe;
			competition.subject = data.BriefContest;
			competition.pic = data.competitionPicture;
			competition.session = data.competitionSession;
			competition.id = data.competitionId;
			
			isEnrollcompetition.push(competition);
		}
	}
}


/**
 * 展示比赛数据
 * @param json
 * @return
 */
function showCompetitionList(){
	setMenuView();
	
	$("#list").html("");       //清空列表
	
	if(enroll_flag == 1){
		if(aboutEnrollcompetition.length == 0){
			$("#point").html("目前还没有任何赛事信息。");
		}else{
			$("#point").html("");
			for(var i=0; i<aboutEnrollcompetition.length; i++){
				$("#list").append(						
						'<div class="singleton" onclick = "todetails('+aboutEnrollcompetition[i].id+');">'
							+'<div class="image" ><img class = "image_1" src="'+aboutEnrollcompetition[i].pic+'"/></div>'
							+'<div class="info">'
								+'<div class="info_1">'+cutString(aboutEnrollcompetition[i].name,25)+'</div>'
								+'<div class="info_2">'+'报名开始时间：'+aboutEnrollcompetition[i].enrollStartTime+''+'</div>'
								+'<div class="info_3">'+'参赛对象：'+cutString(aboutEnrollcompetition[i].objectDes,20)+''+'</div>'
								+'<div class="info_3">'+'大赛科目：'+getSubjects(aboutEnrollcompetition[i].subject)+''+'</div>'
								+'<div class="info_4">'+'赛事届数：'+aboutEnrollcompetition[i].session+''+'</div>'
								+'</div>'
								+'</div>'
								
				)
			}
		}
		
	}else if(enroll_flag == 2){
		if(isEnrollcompetition.length == 0){
			$("#point").html("目前还没有任何赛事信息。");
		}else{
			$("#point").html("");
			for(var i=0; i<isEnrollcompetition.length; i++){
				$("#list").append(						
						'<div class="singleton" onclick = "todetails('+isEnrollcompetition[i].id+');">'
							+'<div class="image" ><img class = "image_1" src="'+isEnrollcompetition[i].pic+'"/></div>'
							+'<div class="info">'
								+'<div class="info_1">'+cutString(isEnrollcompetition[i].name,25)+'</div>'
								+'<div class="info_2">'+'报名截止时间：'+isEnrollcompetition[i].enrollEndTime+''+'</div>'
								+'<div class="info_3">'+'参赛对象：'+cutString(isEnrollcompetition[i].objectDes,20)+''+'</div>'
								+'<div class="info_3">'+'大赛科目：'+getSubjects(isEnrollcompetition[i].subject)+''+'</div>'
								+'<div class="info_4">'+'赛事届数：'+isEnrollcompetition[i].session+''+'</div>'
								+'</div>'
								+'</div>'
				)
			}
		}
		
	}
	
}

/**
 * 设置菜单的css
 * @return
 */
function setMenuView(){
	if(school_flag==1){
		$(".grade_1").css('color','#0075c4');
		$(".grade_2").css('color','black');
		$(".grade_3").css('color','black');
	}else if(school_flag == 2){
		$(".grade_1").css('color','black');
		$(".grade_2").css('color','#0075c4');
		$(".grade_3").css('color','black');
	}else if(school_flag == 3){
		$(".grade_1").css('color','black');
		$(".grade_2").css('color','black');
		$(".grade_3").css('color','#0075c4');
	}
	
	if(enroll_flag == 1){
		$("#bar_1").css('color','black');
		$("#bar_2").css('color','#0075c4');
	}else if(enroll_flag == 2){
		$("#bar_2").css('color','black');
		$("#bar_1").css('color','#0075c4');
	}
}

/**
 * 清除Array的内容
 * @param array
 * @return
 */
function clearArray(array){
	while(array.length!=0){
		array.shift();
	}
}


//跳转到详情界面
function todetails(competitionId){
	window.location.href = "WeChat/jsp/details.jsp?competitionId="+competitionId;
}

//跳转到搜索界面
function tosearch(){
	window.location.href = "WeChat/jsp/search.jsp";
}


/**
 * 
 * 判断数组中是否存在某个元素
 * 
 * @param search
 * @param array
 * @return
 */
function isInArray(search, array){
    for (var i in array){
        if(array[i] == search){
            return true;
        }
    }
    return false;
}

/**
 * 
 * 根据竞赛组信息，取出所有的科目
 * 
 * @param ContestInfoArr
 * @return
 */
function getSubjects(ContestInfoArr) {
	var subjects = new Array(); // 科目数组
	var length1 = ContestInfoArr.length;
	
	for (var i=0; i<length1; i++) {
		var subject = ContestInfoArr[i].contestSubject;
		
		if (!isInArray(subject, subjects)) {
			subjects.push(subject);
		}
	}
	
	var return_subject = subjects[0];
	var length2 = subjects.length;
	for(var j=1; j<length; i++){
		return_subject +="、" + subjects[i];
	}
	
	return subjects;
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
