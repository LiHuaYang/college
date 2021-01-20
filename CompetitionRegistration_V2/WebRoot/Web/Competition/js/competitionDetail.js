


/******************************************************************************************************/
// 工具方法：
/******************************************************************************************************/

/**
 * 
 * 获取url中的参数
 * 
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);   // 匹配目标参数
	if (r != null) return unescape(r[2]); 
	return null;  // 返回参数值
}


/******************************************************************************************************/
// 
/******************************************************************************************************/
//var competitionId = 0;
//var contestSubject  "";

var Info = new Object();

$(document).ready(function(){
	//获取要定位元素距离浏览器顶部的距离   
	var navH = $(".enroll").offset().top;  
	//滚动条事件  
	$(window).scroll(function(){  
		//获取滚动条的滑动距离  
		var scroH = $(this).scrollTop();  
		//滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定  
		if(scroH>=navH){  
			$(".enroll").css({"position":"fixed","top":0});  
		}else if(scroH<navH){  	
			$(".enroll").css({"position":"static"}); 
		}  
	});
	
	Info.competitionId = getUrlParam('competitionId'); // 获取地址栏参数
//	Info.contestSubjects = decodeURI(getUrlParam('contestSubjects')) ;
	getData();
	
//	showContestInfo();//显示大赛部分信息
	showContestCommitInfo(1);//显示大赛评论信息
	showCommitCount();//显示评论总数和评论页数
//	showEnrollmentInfo();//显示大赛报名情况
}); 




function getData() {
	var json = {
			"competitionId" : Info.competitionId 
	};
	
	// Res--获取大赛的详细信息
	$.getJSON("./GetCompetitionDetailServlet", 
		{data : JSON.stringify(json)}, 
		function(jsonObject) {
			showCompetition(jsonObject.data);
			jcontestSet = jsonObject.data.contestSet;
//			console.log(jcontestSet);
	});	
}


// 用户保存大赛信息的对象
var jcompetition = new Object();
// 用于保存竞赛信息的对象
var jcontestSet = null;


/**
 * 
 * 显示大赛详细信息
 * 
 */
function showCompetition (json)　{
	var contestSubject = "";
	var contestexamType = "";
	
//	var contestSet = json.contestSet; // 获取科目信息
//	var length = jcontestSet.length;
//	
//	for (var i=0; i<length; i++) {
//		var jcontest = new Object();
//		
//		jcontest.contestSubjects = contestSet[i].contestSubject;
//		jcontest.contestObject = contestSet[i].contestSubject;
//		jcontest.contestMoney = contestSet[i].contestMoney;
//		jcontest.startTime = contestSet[i].startTime;
//		jcontest.endTime = contestSet[i].endTime;
//		jcontest.contestexamType = contestSet[i].contestexamType;
//		
//		jcontestSet.push(jcontest);
//	}
	
	$(".com_bref_box").append(
			'<dl class="info-dl"><dd><strong>科目:</strong>' + json.contestSet[0].contestSubject + '</dd>' +
			'<dd><strong>形式:</strong>' + json.contestSet[0].contestexamType+ '</dd>' +
			'<dd><strong>对象:</strong>' + json.competitionObjectDescribe + '</dd>' +
			'<dd><strong>时间:</strong>' + cutString(json.competitionTimeDescribe, 40)  + '</dd>' +
			'<dd><strong>报名费用:</strong>' + cutString(json.competitionPriceDescribe, 40) + '</dd>' +
			'<dd><strong>奖项设置:</strong>' + cutString(json.competitionPrize, 40)+ '</dd>' +
			'<dd><strong>大赛简介:</strong>' + cutString(json.competitionInfo, 40) + 
			'<div class="more_info" onclick="gotoCompetitionDetailInfo()">更多资料 </div>'+
			'</dd></dl>'
			
	);
	$(".com_detail_right").append(
			'<div class="com_type_first" id="com_type_first">' + json.competitionName + '</div>'+
			'<div class="com_session"><div id="sessionGoto">' + json.competitionSession +'</div><div>届</div></div>'+
			'<div class="com_bref">' + json.competitionPropaganda + '</div>'
	);
	$(".main_pic").css({"background-image":"url('"+json.competitionPicture+"')"});
	
	$(".pic").css({"background-image":"url('"+json.competitionPictureBig+"')"});
	$(".pic").css({"background-size":"100% 100%"});
	
	
	// TODO:详细页面跳转到报名页面，参数为竞赛Id，不是大赛Id
	if(json.competitionState==2){
		$(".com_enroll").append(
				'<button class="button_enroll" onclick="gotoenrollment(' + 1 + ')">点我报名</button>'
				);
	}
	else{
		$(".com_enroll").append(
				'<div class="button_enroll1">点我报名</div>'
				);
	}
}



function gotoCompetitionDetailInfo(){
	window.location.href="Web/Competition/jsp/competitionDetailInfo.jsp?competitionId="+Info.competitionId;
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


//显示大赛评论信息
function showContestCommitInfo(w) {
	var page=w;
	$.ajax({
		type: "GET",
		url: "./GetContestCommitInfoServlet",
		data:{CompetitionId:Info.competitionId,page:page},
		dataType: "json",
		success: function(json){
			for(var i=0;i<json.result.length;i++){
				$(".comment_each").append(
				'<div  class="eachcomment"><div class="comment_pic" style="background-image:url('+json.result[i].userPicture+')"></div>'+
					'<div class="comment_right">'+
					'<div class="comm_name_div">'+
						'<div class="comm_name">'+json.result[i].userNickname+'</div>'+
						'<div class="comm_score">'+json.result[i].contestCommitRank+'</div>'+
						'<div class="comm_time">'+json.result[i].contestCommitTime+'</div>'+
					'</div>'+
					'<div class="comment">'+json.result[i].contestCommitInfo+'</div>'+
				'</div></div>'
				);
			}
		}
	});
	
}


//显示评论总数和评论页数
function showCommitCount() {
	
	$.ajax({
		type: "GET",
		url: "./GetCountbyCopetiitonIdServlet",
		data:{CompetitionId:Info.competitionId},
		dataType: "json",
		success: function(json){
			$(".comm_font_div").append(
				'<div class="comment_font"><div>'+json.result+'</div><div>条评论</div></div>'
  				
			);
			
			if(json.result%15==0){
				page=json.result/15;
			}
			else{
				page=Math.floor((json.result/15))+1;
			}
			
			var w=0;
			for(var i=0;i<page;i++){
				w=i+1;
				$(".comm_page").append(
					'<div class="comm_page_num" onclick="page_now('+w+')">'+w+'</div>'
				);
			}
			$(".comm_page").append(
					'<div class="comm_page_num" onclick="page_next()">></div>'
			);
		}
	});
}

var page_change=1;   //当前页面
var page=0;  //页面总数

function page_now(w) {
	page_change=w;
	$(".comment_each").html("");
	showContestCommitInfo(w);
}

function page_next() {
	
	if((page_change+1)<= page){
		page_change=page_change+1;
		$(".comment_each").html("");
		showContestCommitInfo(page_change);
	}
	else{
		alert("已经是最后一页了");
	}
}

//显示大赛报名情况
function showEnrollmentInfo(){
	
	//总报名人数
	$.ajax({
		type: "GET",
		url: "./GetCountEnrollmentByCompetiitonId",
		data:{CompetitionId:Info.competitiongotoId},
		dataType: "json",
		success: function(json){

			//显示总报名人数
			$(".enroll_com_all").append(
		      '<div class="com_all">总报名人数：'+json.result+'</div>'
					);
		}
		});
	
	//周报名人数
	$.ajax( {
		type : "GET",
		url : "./WeekNumber",
		data : {
			CompetitionId : Info.competitiongotoId,
		},
		dataType : "json",
		success : function(json) {
			$(".week_box").html(
				'<div class="com_week">周报名人数：'+json.result+'</div>'
			)

		}
	});
}

//显示我要评论框
function Show_Commit(){
	$(".want_commit_big").show();
}

//关闭我要评论框
function close_want_commit(){
	$(".want_commit_big").hide();
}


//评论
function createcommit() {
	var options=document.getElementById("want_score").value;
	var context = $(".content").val(); // 评价内容
	if(userid==0){
		alert("请先登录")
	}else{
	$.ajax( {
		type : "GET",
		url : "./CommitCreateServlet",
		data : {
			CompetitionId : Info.competitionId ,
			Userid:userid,
			ContestCommitRank : options,
			ContestCommitInfo : context
		},
		dataType : "json",
		success : function(json) {
			if(json.result== true){
				alert("评论成功");
				$(".comment_each").html("");
				window.location.reload();
			}else{
				alert("评论失败")
			}

		}
	});
	}
}

var number = 0;

//跳转到报名页面
function gotoenrollment(contestId) {
//	var CompetitionSession=document.getElementById("sessionGoto").text;//大赛届数
	var CompetitionSession=document.getElementById("sessionGoto").innerHTML;;
	var ContestId=contestId;//竞赛项目id
	var CompetitionName=document.getElementById("com_type_first").innerHTML;//大赛名称
	// alert(CompetitionName);
	if(userid!=0){
		// console.log(JSON.stringify(jcontestSet));
	    window.location.href="Web/Enrollment/jsp/enrollment.jsp?Userid=" + userid +
	    "&CompetitionSession=" + CompetitionSession+
	    "&ContestId=" + ContestId +
	    "&CompetitionName=" + encodeURI(encodeURI(CompetitionName)) +
	    "&competitionId=" + Info.competitionId +
	    "&jcontestSet=" + encodeURI(encodeURI(JSON.stringify(jcontestSet)));
	}
	else{
		alert("用户未登录,请登录");
	}
}


////滚动查看大图查看下一张图片
//function tonext(){
//	number = number+1;
//	$.ajax( {
//		type : "GET",
//		url : "./GetContestPicUrlbyCompetitionId",
//		data : {
//			CompetitionId : competitiongotoId,
//		},
//		dataType : "json",
//		success : function(json) {
//			if(number < json.result.length){
//				
//				$(".pic").css({"background-image":"url('"+json.result[number]+"')"});
//				
//			}else{
//				number = 0;
//				$(".pic").css({"background-image":"url('"+json.result[number]+"')"});
//			}
//			
//		}
//	});
//}
//
////滚动查看大图查看上一张图片
//function toprevious(){
//	number = number-1;
//	$.ajax( {
//		type : "GET",
//		url : "./GetContestPicUrlbyCompetitionId",
//		data : {
//			CompetitionId : competitiongotoId,
//		},
//		dataType : "json",
//		success : function(json) {
//			if(number >= 0){
//				
//				$(".pic").css({"background-image":"url('"+json.result[number]+"')"});
//				
//			}else{
//				number = json.result.length-1;
//				$(".pic").css({"background-image":"url('"+json.result[number]+"')"});
//			}
//			
//		}
//	});
//}



/*
//展开收起
function Show_Hide(id){
	
	var o = document.getElementById(id);
	var s = o.innerHTML;
	var p = document.createElement("span");
	var n = document.createElement("a");
	p.innerHTML = s.substring(0,60);
	n.innerHTML = s.length > 60 ? "...展开" : "";
	n.onclick = function(){
		if (n.innerHTML == "...展开"){
			
		    n.innerHTML = "收起";
		    p.innerHTML = s;
		}else{
			
		    n.innerHTML = "...展开";
		    p.innerHTML = s.substring(0,60);
		 }
	}
	o.innerHTML = "";
	o.appendChild(p);
	o.appendChild(n);
}
*/


/******************************************************************************************************
//显示大赛部分信息
function showContestInfo(){
	
	$.ajax({
		type: "GET",
		url: "./GetContestInfobyIdServlet",
		data:{CompetitionId:competitiongotoId},
		dataType: "json",
		success: function(json){
			var contestSubject = "";
			var contestexamType = "";
			
			//拼接赛事科目和赛事形式，去掉重复字段
			for(var i=0;i<json.result.length;i++){
				if (contestSubject.indexOf(json.result[i].contestSubject) < 0) {
				contestSubject = contestSubject + json.result[i].contestSubject +",";
				}
				if (contestexamType.indexOf(json.result[i].contestexamType) < 0) {
				contestexamType = contestexamType + json.result[i].contestexamType+",";
				}
			}
			contestSubject = contestSubject.substring(0,contestSubject.length-1);
			contestexamType = contestexamType.substring(0,contestexamType.length-1);
			
			
			// 加载大赛详细信息
			$(".com_bref_box").append(
					'<dl class="info-dl"><dd><strong>科目:</strong>' + contestSubject + '</dd>' +
					'<dd><strong>形式:</strong>' + contestexamType + '</dd>' +
					'<dd><strong>对象:</strong>' + json.result[0].competitionObjectDescribe + '</dd>' +
					'<dd><strong>时间:</strong>' + cutString(json.result[0].competitionTimeDescribe,40) +'</dd>' +
					'<dd><strong>报名费用:</strong>' + cutString(json.result[0].competitionPrize,40)+ '</dd>' +
					'<dd><strong>奖项设置:</strong>' + cutString(json.result[0].competitionPrize,40)+ '</dd>' +
					'<dd><strong>大赛简介:</strong>' + cutString(json.result[0].competitionInfo,40)+ 
					'<div class="more_info" onclick="gotoCompetitionDetailInfo()">更多资料 >></div>' +
					'</dd>' +
					'</dl>'
			);
			
			$(".com_detail_right").append(
					'<div class="com_type_first" id="com_type_first">'+json.result[0].competitionName+'</div>'+
  				'<div class="com_session"><div id="sessionGoto">'+json.result[0].competitionSession+'</div><div>届</div></div>'+
  				'<div class="com_bref">'+json.result[0].contestPropaganda+'</div>'
			);
			
			
			if(json.result[0].competitionState==2){
				$(".com_enroll").append(
						'<button class="button_enroll" onclick="gotoenrollment('+json.result[0].contestId+')">点我报名</button>'
						);
			}
			else{
				$(".com_enroll").append(
						'<div class="button_enroll1">点我报名</div>'
						);
			}
			
			$(".main_pic").css({"background-image":"url('"+json.result[0].competitionPicture+"')"});
//			$(".pic").css({"background-image":"url('"+json.result[0].contestPicUrl+"')"});
//			$(".pic").css({"background-size":"100% 100%"});
		}
	});
	
	
	$.ajax( {
		type : "GET",
		url : "./GetContestPicUrlbyCompetitionId",
		data : {
			CompetitionId : competitiongotoId,
		},
		dataType : "json",
		success : function(json) {
				
		}
	}
	)
	
	$.ajax({
		type: "GET",
		url: "./CalculationCommitRankAverage",
		data:{CompetitionId:competitiongotoId},
		dataType: "json",
		success: function(json){
			var score=parseFloat(json.result).toFixed(1);//将String类型转换成float类型，并取小数点的后一位

			$(".com_detail_left").append(
					'<div id="com_total">总评分</div>'+
					'<div class="com_score">'+score+'</div>'
					);
		}
	});

}
******************************************************************************************************/