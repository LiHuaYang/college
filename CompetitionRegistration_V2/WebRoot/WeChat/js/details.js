$(document).ready(function(){
	showContestInfo();// 显示大赛部分信息
	showContestCommitInfo(1);// 显示大赛评论信息
	showCommitCount();// 显示评论总数和评论页数
}); 
var page=0;
var w=1;
// 滚动条在Y轴上的滚动距离
function getScrollTop(){
	　　var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
	　　if(document.body){
	　　　　bodyScrollTop = document.body.scrollTop;		  //网页被卷去的高
	　　}
		//兼容性写法
	　　if(document.documentElement){					
	　　　　documentScrollTop = document.documentElement.scrollTop;
	　　}
		//取兼容性写法中值大的
	　　scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
	　　return scrollTop;
}

	
// 文档的总高度
function getScrollHeight(){
	　　var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
	　　if(document.body){
	　　　　bodyScrollHeight = document.body.scrollHeight;//网页正文全文高
	　　}
		//兼容性写法
	　　if(document.documentElement){
	　　　　documentScrollHeight = document.documentElement.scrollHeight;
	　　}
		//取兼容性写法中值大的
	　　scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
	　　return scrollHeight;
}

// 浏览器视口的高度
function getWindowHeight(){
	　　var windowHeight = 0;
	　　if(document.compatMode == "CSS1Compat"){						//严格模式
	　　　　windowHeight = document.documentElement.clientHeight;	//窗口当前高度
	　　}else{														//怪异模式
	　　　　windowHeight = document.body.clientHeight;
	　　}
	　　return windowHeight;
}

// 判断是否到达页尾
window.onscroll = function(){			//当window发生scroll事件时，调用该函数。
	　　if(getScrollTop() + getWindowHeight() == getScrollHeight()){
		// alert("you are in the bottom!");
		if(w<page){
			w++;
		showContestCommitInfo(w);
		}else{
			$(".more").html("");
			$(".more").append(
					'没有更多'
				);
		}
	　　}
};

// 跳转到评价界面
function toevaluate(){
	if(userid!=0){
		window.location.href = "WeChat/jsp/evaluate.jsp?competitionId="+competitionId;
		}else{
			alert("请先登录！")
			window.location.href = "WeChat/jsp/logins.jsp";
		}
}


var detail="";
var little="";
// 显示大赛部分信息
function showContestInfo(){
	var json = {
			"competitionId":competitionId
	}
	
	// Res--获取大赛的详细信息
	$.getJSON("./GetCompetitionDetailServlet", 
		{data : JSON.stringify(json)}, 
		function(jsonObject) {
			if(jsonObject.msg == true){
				showCompetition(jsonObject.data);
			}else{
				alert("服务器错误");
			}
			
	});	
	
	// 大赛的评分
	$.ajax({
		type: "GET",
		url: "./CalculationCommitRankAverage",
		data:{CompetitionId:competitionId},
		dataType: "json",
		success: function(json){
			$(".score").append(
				json.result
			);

		}
	});
	
}

function showCompetition(json){
	
	$(".main").append(

			'<div class="intro">'+
			'<div class="box_1">'+
				'<button class="bt" id="green" onClick="toevaluate();">'+
					'我要评论'+
				'</button>'+
			'</div>'+
			
			'<div class="box">'+
					
	  			'<ul>'+
				'<li>'+
				'	科目：'+json.contestSet[0].contestSubject+''+
				'</li>'+
				'<li>'+
				'	形式：'+json.contestSet[0].contestexamType+''+
				'</li>'+
				'<li>'+
				'	对象：'+json.competitionObjectDescribe+''+
				'</li>'+

				'<li>'+
				'	报名截止：'+json.competitionEnrollEndTime+''+
				'</li>'+
			'</ul>'+
			'</div>'+
			
		'<div class="cont">"'+json.competitionPropaganda+'"</div>'+'</div>'+
		'<div class="aww">'+
		'<button class="login" onClick="toinfo('+competitionId+');">我要报名</button>'+
		'</div>'
	);
	$(".fl").append(
			'<img class = "image_1" src="'+json.competitionPicture+'"/>'
		);

	$(".head").append(
			'<div class = "head_1"><div class="title" id="com-name">'+json.competitionName+'</div>'+
			'<div class="number" id="com-session">'+json.competitionSession+'</div>'  //届数
		);
	$(".head").css("background:url(" + json.competitionPictureBig+ ")" + "center no-repeat");
	
	
	
	//显示大赛简介
	if(json.competitionBriefInfo==null||json.competitionBriefInfo==""){
		little="暂无简介";
	}
	else{
		little=json.competitionBriefInfo;
	}
	
	//显示大赛详情
	if(json.competitionInfo==null||json.competitionInfo==""){
		detail="暂无详情";
	}
	else{
		detail=json.competitionInfo;
	}
	
	$(".introduction").append(
			
		'<div class="introduction_1">'+
			'<div class = "time_des">'+little+'</div>'+
		'</div>'+
		'<div class="introduction_3" onclick="showintrodetails()">查看全部</div>'+
//					'<div class="introduction_3" onclick="showintrodetails()">查看全部</div>'+
		'<div class="introduction_4" onclick = "hideintrodetails();" style="display: none">收起</div>'
	);
		
//			$(".com_detail_right").append(
//					'<div class="com_type_first" id="com_type_first">'+json.result[0].competitionName+'</div>'+
//    				'<div class="com_session"><div id="com_session">'+json.result[0].competitionSession+'</div>届</div>'
//			);
	
}

//显示大赛详情
function showintrodetails() {
	
	$(".introduction_3").hide();
	$(".introduction_4").show();
	
	$(".introduction_1").html("");
	//显示大赛详情
	$(".introduction_1").html(
		'<div class = "time_des">'+detail+'</div>'
	);
	
	
}
// 显示大赛简介
function hideintrodetails() {
	
	$(".introduction_4").hide();
	$(".introduction_3").show();
	//显示大赛简介
	if(little==""){
		$(".introduction_1").html(
			'<div class = "time_des">暂无简介</div>'
		);
	}
	else{
		$(".introduction_1").html(
				'<div class = "time_des">'+little+'</div>'
			);
	}
	
}

//跳转到报名界面
function toinfo(competitionId){
	var competitionSession=document.getElementById("com-session").innerHTML;;//大赛届数
	var competitionName=document.getElementById("com-name").innerHTML;//大赛名称
	
	if(userid!=0){

		window.location.href = "WeChat/jsp/info.jsp?Userid="+userid+"&competitionId="+competitionId+"&CompetitionName="+competitionName+"&CompetitionSession="+competitionSession+"";
	}else{
		alert("请先登录！")
		window.location.href = "WeChat/jsp/logins.jsp";
	}
}


// 显示大赛评论信息
function showContestCommitInfo(w) {
	var page=w;
	$.ajax({
		type: "GET",
		url: "./GetContestCommitInfoServlet",
		data:{CompetitionId:competitionId,page:page},
		dataType: "json",
		success: function(json){
			for(var i=0;i<json.result.length;i++){
				$(".list").append(
						'<div class="evaluate">'+
						'<div class="evaluate_score">'+json.result[i].contestCommitRank+'</div>'+
							'<div class="image"><img class = "image_2" src="'+json.result[i].userPicture+'"/></div>'+
							'<div class="info">'+
								'<div class="info_1">'+json.result[i].userNickname+'</div>'+
								'<div class="info_2">'+json.result[i].contestCommitInfo+'</div>'+
							'	<div class="info_1">'+json.result[i].contestCommitTime+'</div>'+
							'</div>'+
						'</div>'
				);
			}
		}
	});
}

// 显示评论总数和评论页数
function showCommitCount() {
	$.ajax({
		type: "GET",
		url: "./GetCountbyCopetiitonIdServlet",
		data:{CompetitionId:competitionId},
		dataType: "json",
		success: function(json){
			$(".evaluates_number").append(
				'用户短评('+json.result+')'
			);
			if(json.result%6==0){
				page=json.result/6;						
			}
			else{
				page=Math.floor((json.result/6))+1;
			}
		}
	});
}


