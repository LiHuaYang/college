


/******************************************************************************************************/
// 全局变量
/******************************************************************************************************/
var g_subjects = "";

/******************************************************************************************************/


/******************************************************************************************************/
// 页面加载
/******************************************************************************************************/
$(document).ready(function(){
//	$("#MuneHome").removeClass("MuneHome");
//	$("#MuneHome").addClass("curr");
//	$("#MuneHome").attr("class", "curr");
	
//	Show_All_Finished_Sub();   //显示所有已结束的比赛科目
	
	getCompetitionList ();
	
	getCompetitionNumber ();
	
	ShowMainPic();//显示首页面的主图片

	bindClick(); // 绑定页面上面的按钮
});


/******************************************************************************************************/
// 数据获取
/******************************************************************************************************/
/**
 * 获取大赛列表
 * 
 * 备注：
 * 		只获取状态为 1，2，5的大赛
 */
function getCompetitionList () {
	$.ajax({
		type: "GET",
		url: "./GetCompetitonListServlet",
		data:{},
		dataType: "json",
		success: function(json){
			showCompetitionList (json);
		}
	});
}

//{"numberOfTobeEnro":"2","numberOfDoingEnro":"0","numberOfDoing":"0"}
function getCompetitionNumber () {
	$.getJSON("./GetCompetitionNumberServlet",{},
		function (json) {
			if (json.msg) {
				var numberOfTobeEnro = json.res.numberOfTobeEnro; // 将要开始报名
				var numberOfDoingEnro = json.res.numberOfDoingEnro;// 正在报名
				var numberOfDoing = json.res.numberOfDoing;// 正在比赛中
				showCompetitionNumber(numberOfDoingEnro, numberOfTobeEnro) // 显示即将开始报名和正在报名的大赛数目
			}
	});
}

//显示首页的图片
function ShowMainPic() {
	$.ajax({
		type: "GET",
		url: "./GetBasicPictureDataServlet",
		data:{},
		dataType: "json",
		success: function(json){
			$(".pic").css({"background-image":"url('"+json.result+"')"});
			$(".pic").css({"background-position":"center"});
		}
	});
}

//显示所有已结束的比赛
function getMainPageBasicData (){
	
	$.getJSON("./QueryCompetitionNameServlet",{},
			function (json) {
		
			if (json == null ) {
				return ;
			}
			var length = json.result.length;
			
			for (var i=0; i<length; i++) {
				$("#choice_com_select").append(
				'<option id="choice_com_option">'+json.result[i].competitionName+'</option>'
			)
		}
	});
}

/******************************************************************************************************/





/******************************************************************************************************/
// 数据显示
/******************************************************************************************************/
// 显示所有正在报名和即将开始报名的大赛
function showCompetitionList (json) {
	var length = json.data.length;
	var showOngoingEnrollmentCount = 0;
	var showTobeEnrollmentCount = 0;
	var showHotCompetitionCount = 0;
	
	for (var i=0; i<length; i++) {
		var data = json.data[i];
		if (data.competitionState == 2 && showOngoingEnrollmentCount<3) {
			showOngoingEnrollment (data); // 正在报名
			showOngoingEnrollmentCount ++;
//			Number.numberEnrollmenting++;
		}
		if (data.competitionState == 1 && showTobeEnrollmentCount<2) {
			showTobeEnrollment (data); // 即将开始报名   
			showTobeEnrollmentCount ++;
//			Number.numberEnrollmentsoon++;
		}
		if (data.competitionState == 5 && showHotCompetitionCount<=1) {
			showHotCompetition (data); 
			showHotCompetitionCount ++;
		}
	}
}
// 显示正在报名列表
function showOngoingEnrollment (json) {
	
	$(".ing_com_small_box").append(
		'<div class="ing_com_small">'+
		'<div class="ing_com_pic" style="background-image:url('+json.competitionPicture+');"></div>'+
		'<div class="ing_com_sub">'+json.competitionName+'</div>'+
		'<div class="div_detail_go">'+
			'<button class="ing_com_detail_go" onclick="gotoCompetition('+json.competitionId+')">点我报名</button>'+
		'</div>'+
		'</div>'
	);
	g_subjects = getSubject(json.BriefContest);
}
//显示即将开始报名列表
function showTobeEnrollment (json) {
	$(".soon_com_small_box").append(
		'<div class="soon_com_small">'+
		'<div class="soon_div_rest">'+
			'<div class="soon_pic" style="background-image: url('+json.competitionPicture+');"></div>'+
			'<div class="soon_detail">'+
				'<div class="soon_sub">'+cutString(json.competitionName, 20)+'</div>'+
				'<div class="soon_subject">科目：<div>'+ getSubject(json.BriefContest) +'</div></div>'+
				'<div class="soon_type">届数：<div>'+json.competitionSession+'</div></div>'+
				'<div class="soon_obj">对象：<div>'+cutString(json.competitionObjectDescribe, 20)+'</div></div>'+
				'<div class="soon_type">报名开始时间：<div>'+json.competitionEnrollStartTime+'</div></div>'+
				'<div class="soon_detail_go">'+
					'<button class="button_soon_detail_go" onclick="gotoCompetition('+ json.competitionId +')">了解详情</button>'+
				'</div>'+
			'</div>'+
		'</div>'+
	'</div>'
	);
	g_subjects = getSubject(json.BriefContest);
}

// 显示首页置顶大赛
function showHotCompetition (json) {
	$(".pictureTrophy").html(
			'<div class="pic_Trophy" style="background-image: url('+json.competitionPicture+');"></div>'
			);
	$(".com_obj").html(
			'<div class="object_name"><a class="object">对象：</a>'+json.competitionObjectDescribe+'</div>'
	);
	$(".com_detail_middle").html(
			'<div class="com_type_first">'+json.competitionName+'</div>'
	)
	g_subjects = getSubject(json.BriefContest);
	$(".com_detail_right").html(
			'<div class="detail_first_line">'
				+'<div class="com_subject">科目：' + g_subjects + '</div>'
//				+'<div class="com_Type">赛事形式：笔试</div>'
			+'</div>'
			+'<div class="detail_second_line">报名截止时间：'+json.competitionEnrollEndTime+'</div>'
//			+'<div class="detail_third_line">复赛时间：2016年5月21日上午9:00~11:00</div>'				
			+'<div class="download_go">考前复习资料请点击</div>'
	)
	$(".com_money").html(
			'<div class="money_all">参赛费<a id="money_real">'+json.BriefContest[0].contestMoney+'</a></>元</div>'
			+'<button class="detail_go" onclick="gotoCompetition('+json.competitionId + ')">点我报名</button>'
	)
}

//显示即将开始和正在报名大赛的数目
function showCompetitionNumber (ErollmentingNumber, toboEromentNumber) {
	$(".font_ing").html(
			'<div>正在报名<a class="ing_number">' + ErollmentingNumber + '</a>个赛事</div>'
	)
	$(".soon_com_num_div").html(
			'<div>即将报名<a class="soon_com_num">' + toboEromentNumber + '</a>个赛事</div>'
	)
}


//显示成绩页面
function show_score(){
	var ContestSubject=$("#choice_com_select").find("option:selected").text();//第三种
	
	var StudentName=$(".input_idnumber").val();
	var StudentTicket=$(".input_password").val();
	var EnrollmentPassword=$("#input_secret_password").val();
	
	if(ContestSubject=="赛事选择" ||StudentName=="" || StudentTicket=="" || EnrollmentPassword==""){
		alert("信息不能为空");
	}
	else{
		alert(StudentName);
		window.location.href="Web/QueryScore/jsp/QueryScore.jsp?subject="+
		   encodeURI(encodeURI(ContestSubject))+
		  "&name="+ encodeURI(encodeURI(StudentName))+
		  "&id="+StudentTicket+
		  "&EnrollmentPassword="+EnrollmentPassword+"";
	}
}
/******************************************************************************************************/


/******************************************************************************************************/
// 数据的处理
/******************************************************************************************************/
//
function getSubject (json) {
	var subLength = json.length;
	var subString = new Array();
	
	for (var i=0; i<subLength; i++) {
		// console.log(json[i].contestSubject);
		var subject = json[i].contestSubject;
		
		if (isInArray(subject, subString) == false) { 	// 如果数组中不存在该科目
			subString.push(json[i].contestSubject);
		}
	}
	return subString.toString();
}

/**
 * 
 * 判断数组中是否存在某个元素
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


/******************************************************************************************************/




/******************************************************************************************************/
// 页面跳转
/******************************************************************************************************/
//跳转到大赛详情界面
function gotoCompetition(id) {
	var competitionId = id;//大赛id
	
	window.location.href="Web/Competition/jsp/competitionDetail.jsp?competitionId="+competitionId;// +"&contestSubjects="+ encodeURI(encodeURI(g_subjects));
}
//跳转更多正在报名比赛
function appear_more_on(){
	var flag;
	window.location.href="Web/Competition/jsp/list.jsp?flag="+1+"";
}

//跳转更多即将报名比赛
function appear_more_ing(){
	var flag;
	window.location.href="Web/Competition/jsp/list.jsp?flag="+2+"";
}

/******************************************************************************************************/


/******************************************************************************************************/
// 页面点击事件
/******************************************************************************************************/


function showCompetitionOption () {
	// 大赛状态：0:未发布 1：即将开始报名 2:正在报名 3：比赛进行中 4：已结束 -1：删除 5:头条
//	[{"CompetitionName":"2016年全国初中数学联赛","CompetitionId":"34","CompetitionState":"1"},
//	 {"CompetitionName":"第八届IYMC国际青少年数学竞赛(宁波赛区)","CompetitionId":"35","CompetitionState":"1"}]
	var json = {
			"state" : 4
	};
	
	$("#choice_com_select").html(
			'<option class="choice_com_option">赛事选择</option>'
	)
	
	$.getJSON("./GetCompetitionNameByCompetitionState",
			{data : JSON.stringify(json)}, 
			function (jsonObj) {
		
			if (jsonObj == null ) {
				return ;
			}
			var length = jsonObj.res.length;
			
			for (var i=0; i<length; i++) {
				$("#choice_com_select").append(
				'<option id="choice_com_option">'+jsonObj.res[i].CompetitionName+'</option>'
			)
		}
	});
}


/******************************************************************************************************/


/******************************************************************************************************/
// 事件绑定
/******************************************************************************************************/

function bindClick() {
	$("#choice_com_select").bind("click", showCompetitionOption());	
}




/******************************************************************************************************/






function pay() {
	$.getJSON("./WxNativePayToPayServlet",
			{data : JSON.stringify(json)}, 
			function (jsonObj) {
	});
}

