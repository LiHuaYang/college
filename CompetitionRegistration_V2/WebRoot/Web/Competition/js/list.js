
$(document).ready(function() {
	$("#MuneCompetition").attr("class", "curr");
	
	
	number_competition();
	
		
	var json = {
			"competitionGrade" : 1
	};
	
	$.getJSON("./GetCompetitionListByGradeServlet", 
		{data : JSON.stringify(json)}, 
		function(jsonObject) {
			if(jsonObject.msg){
				setCompetitionList(jsonObject.data);
				showCompetitionList();
				enroll_flag = 2;
				showCompetitionList();
			}else{
				alert("服务器错误");
			}
			
	});	

	
});


/******************************************************************************************************/
// 地址跳转模块
/******************************************************************************************************/
/**
 * 
 * 跳转到赛事详细页面
 * 
 * 怎样获取competitionId？
 * 
 * 页面上设置隐藏控件，存放competitionId
 * 
 */
function gotoCompetitionDetail(id) {
	var competitionId = id;
	window.location.href = "Web/Competition/jsp/competitionDetail.jsp?competitionId=" + competitionId;
}

var school_flag = 1;
var enroll_flag = 1;

var isEnrollcompetition = new Array();
var aboutEnrollcompetition = new Array();

/**
 * 小学 中学 高中 的点击函数
 * @param school
 * @return
 */
function school(school,state){
	if(school_flag == school){
		enroll_flag = state;
		showCompetitionList();
	}else{
		clearArray(isEnrollcompetition);
		clearArray(aboutEnrollcompetition);
		
		school_flag = school;
		enroll_flag = state;
		
		getCompetitionList();
	}
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
			competition.subject = data.BriefContest[0].contestSubject;
			competition.pic = data.competitionPicture;
			competition.session = data.competitionSession;
			competition.id = data.competitionId;
			
			aboutEnrollcompetition.push(competition);
		}else if(data.competitionState == 2){
			var competition = new Object();
			competition.name = data.competitionName;
			competition.enrollEndTime = data.competitionEnrollEndTime;
			competition.objectDes = data.competitionObjectDescribe;
			competition.subject = data.BriefContest[0].contestSubject;
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
	
	if(enroll_flag == 1){
		$("#contest-item2").html("");       //清空列表
		if(aboutEnrollcompetition.length == 0){
			nocompetition("#contest-item2");
		}else{
			for(var i=0; i<aboutEnrollcompetition.length; i++){
				$("#contest-item2").append(								
						"<li  id='contest_ul_will'>"+
						"<div class='enrollmenting'>"+
						"<div class='pic1' style='background-image:url("+aboutEnrollcompetition[i].pic+");' value='1'></div>"+
						"<div class='info'>"+"<dl class='item-info'>"+
						"<dt style='height:50px'>"+
						"<h3 id='contest_name'>"+ cutString(aboutEnrollcompetition[i].name, 20) +"</h3>"+"</dt>"+
						"<dd id='contest_subject'>"+"科目："+ aboutEnrollcompetition[i].subject +"</dd>"+
						"<dd id='contest_session'>"+"届数："+ aboutEnrollcompetition[i].session +"</dd>"+
						"<dd id='contest_obj'>"+"对象："+ cutString(aboutEnrollcompetition[i].objectDes, 20) +"</dd>"+
						"<dd id='competitionEnrollEndTime' style='height:50px'>"+"报名开始时间："+ aboutEnrollcompetition[i].enrollStartTime +"</dd>"+
						"<dd class='click' onclick='gotoCompetitionDetail(\""+aboutEnrollcompetition[i].id+"\")'>"+"了解详情"+"</dd>"+
						"</dl>"+"</div>"+"</div>"+"</li>"
				)
				
			}
		}
		
	}else if(enroll_flag == 2){
		$("#contest-item1").html("");       //清空列表
		if(isEnrollcompetition.length == 0){
			nocompetition("#contest-item1");
		}else{
			for(var i=0; i<isEnrollcompetition.length; i++){
				$("#contest-item1").append(						
						"<li  id='contest_ul_hot'>"+
						"<div class='enrollment'>"+
						"<div class='pic1' style='background-image:url("+isEnrollcompetition[i].pic+");' value='1'></div>"+
						"<div class='info'>"+
						"<dl class='item-info'>"+
						"<dt style='height:50px'>"+
						"<h3 id='contest_name'>"+ cutString(isEnrollcompetition[i].name, 20) +"</h3>"+
						"</dt>"+"<dd id='contest_subject'>"+"科目："+ isEnrollcompetition[i].subject +"</dd>"+
						"<dd id='contest_session'>"+"届数："+ isEnrollcompetition[i].session +"</dd>"+
						"<dd id='contest_obj'>"+"对象："+ cutString(isEnrollcompetition[i].objectDes, 20) +"</dd>"+
						"<dd id='competitionEnrollEndTime' style='height:50px'>"+"报名截止时间："+ isEnrollcompetition[i].enrollEndTime +"</dd>"+
						"<dd class='click' onclick='gotoCompetitionDetail(\""+isEnrollcompetition[i].id+"\")' style='margin-top:15px'>"+
						"我要报名"+"</dd>"+"</dl>"+"</div>"+"</div>"+"</li>"
								
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
	if(enroll_flag == 1){
		if(school_flag==1){
			$(".school_pri1").css("color","black");
			$(".school_midd1").css("color","#08c");
			$(".school_high1").css("color","#08c");
		}else if(school_flag == 2){
			$(".school_pri1").css("color","#08c");
			$(".school_midd1").css("color","black");
			$(".school_high1").css("color","#08c");
		}else if(school_flag == 3){
			$(".school_pri1").css("color","#08c");
			$(".school_midd1").css("color","#08c");
			$(".school_high1").css("color","black");
		}
	}else if(enroll_flag == 2){
		if(school_flag==1){
			$(".school_pri").css("color","black");
			$(".school_midd").css("color","#08c");
			$(".school_high").css("color","#08c");
		}else if(school_flag == 2){
			$(".school_pri").css("color","#08c");
			$(".school_midd").css("color","black");
			$(".school_high").css("color","#08c");
		}else if(school_flag == 3){
			$(".school_pri").css("color","#08c");
			$(".school_midd").css("color","#08c");
			$(".school_high").css("color","black");
		}
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



function nocompetition(id) {
	$(id).append(
			'<li class="enrollmenting">\
			<h4 style="text-align:center">暂无信息</h4>\
		</li>'
	)
}


//正在报名以及即将报名赛事个数
function number_competition(){
	//正在报名
	var ContestState2=2;
	$.ajax({
		type: "GET",
		url: "./GetNumberCompetitionServlet",
		data:{ContestState:ContestState2},
		dataType: "json",
		success: function(json){
			$(".hot_enro").text(json.result);
		}
	})
	
	//即将报名
	var ContestState1=1;
	$.ajax({
		type: "GET",
		url: "./GetNumberCompetitionServlet",
		data:{ContestState:ContestState1},
		dataType: "json",
		success: function(json){
			$(".begin_enro").text(json.result);
		}
	})
}

/******************************************************************************************************/


/**
 * 截取字符串
 * @param str
 * @param len
 * @return
 */
function cutString(str, len){
	//length属性读出来的汉字长度为1
	
    if(str.length*2 <= len) {
        return str;
    }
    var strlen = 0;
    var s = "";
    for(var i = 0;i < str.length; i++) {
        s = s + str.charAt(i);
        if (str.charCodeAt(i) > 128) {
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















