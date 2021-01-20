/**
 * 
 */

$(document).ready(function(){
//	$(".MuneCompetition").removeClass(".titleMune div");
	$("#MuneCompetition").attr("class", "curr");
	
	
	number_competition();
	if(flag==1)    //正在报名
	{
		appear_on();
		
	}
	else if(flag==2)
	{
		appear_ing();
	}
})


var enroll_flag=1;    //点击正在报名，即将报名标志
var school_flag=1;    //点击学校标志
//即将报名事件
function appear_ing(){
	$(".com_middle").animate({left:'50%'});
	$(".ing_com_big").fadeOut();
	$(".ing_page").fadeOut();
	$(".soon_com_big").fadeIn();
	$(".soon_page").fadeIn();
	enroll_flag=2;
	$(".div_each_soon").html("");
	
	if(enroll_flag==2 && school_flag==1){    //点击即将报名和小学
		var ContestObject=2;
		var ContestState=1;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_soon").append(
						'<div class="soon_com_small">'
							+'<div class="soon_on_date">'+json.result[i].startTime+'<a class="soon_on">开始</a></div>'
							+'<div class="soon_div_rest">'
								+'<div class="soon_pic"></div>'
								+'<div class="soon_detail">'
									+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
									+'<div class="soon_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
									+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
									+'<div class="soon_obj">参赛对象：'+contestObjectString+'</div>'
									+'<div class="soon_detail_go">'
										+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
									+'</div>'
								+'</div>'
							+'</div>'
						+'</div>'
					)
				}
			}
		})
	}
	else if(enroll_flag==2 && school_flag==2){    //点击即将报名和初中
		var ContestObject=8;
		var ContestState=1;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_soon").append(
						'<div class="soon_com_small">'
							+'<div class="soon_on_date">'+json.result[i].startTime+'<a class="soon_on">开始</a></div>'
							+'<div class="soon_div_rest">'
								+'<div class="soon_pic"></div>'
								+'<div class="soon_detail">'
									+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
									+'<div class="soon_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
									+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
									+'<div class="soon_obj">参赛对象：'+contestObjectString+'</div>'
									+'<div class="soon_detail_go">'
										+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
									+'</div>'
								+'</div>'
							+'</div>'
						+'</div>'
					)
				}
			}
		})
	}
	else if(enroll_flag==2 && school_flag==3){    //点击即将报名和高中
		var ContestObject=10;
		var ContestState=1;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_soon").append(
						'<div class="soon_com_small">'
							+'<div class="soon_on_date">'+json.result[i].startTime+'<a class="soon_on">开始</a></div>'
							+'<div class="soon_div_rest">'
								+'<div class="soon_pic"></div>'
								+'<div class="soon_detail">'
									+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
									+'<div class="soon_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
									+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
									+'<div class="soon_obj">参赛对象：'+contestObjectString+'</div>'
									+'<div class="soon_detail_go">'
										+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
									+'</div>'
								+'</div>'
							+'</div>'
						+'</div>'
					)
				}
			}
		})
	}
}

//正在报名事件
function appear_on(){
	$(".com_middle").animate({left:'0%'});
	$(".soon_com_big").fadeOut();
	$(".soon_page").fadeOut();
	$(".ing_com_big").fadeIn();
	$(".ing_page").fadeIn();
	enroll_flag=1;
	$(".div_each_ing").html("");
	
	if(enroll_flag==1 && school_flag==1){   //点击正在报名和小学
		var ContestObject=2;
		var ContestState=2;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_ing").append(
							'<div class="ing_com_small">'
								+'<div class="ing_on_date">'+json.result[i].startTime+'<a class="ing_on">开始</a></div>'+
		   						'<div class="ing_div_rest">'
		   							+'<div class="ing_pic"></div>'
		   							+'<div class="ing_detail">'+
		   								'<div class="ing_sub">'+json.result[i].competitionName+'</div>'
		   								+'<div class="ing_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
			    						+'<div class="ing_type">赛事届数：'+json.result[i].competitionSession+'</div>'
			    						+'<div class="ing_obj">参赛对象：'+contestObjectString+'</div>'
			    						+'<div class="ing_detail_go">'
			    							+'<button class="button_ing_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">我要报名</button>'
			    						+'</div>'
		   							+'</div>'
		   						+'</div>'
		   					+'</div>'
					)
				}
			}
		})
	}
	else if(enroll_flag==1 && school_flag==2){   //点击正在报名和初中
		var ContestObject=8;
		var ContestState=2;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_ing").append(
							'<div class="ing_com_small">'
								+'<div class="ing_on_date">'+json.result[i].startTime+'<a class="ing_on">开始</a></div>'+
		   						'<div class="ing_div_rest">'
		   							+'<div class="ing_pic"></div>'
		   							+'<div class="ing_detail">'+
		   								'<div class="ing_sub">'+json.result[i].competitionName+'</div>'
		   								+'<div class="ing_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
			    						+'<div class="ing_type">赛事结束：'+json.result[i].competitionSession+'</div>'
			    						+'<div class="ing_obj">参赛对象：'+contestObjectString+'</div>'
			    						+'<div class="ing_detail_go">'
			    							+'<button class="button_ing_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">我要报名</button>'
			    						+'</div>'
		   							+'</div>'
		   						+'</div>'
		   					+'</div>'
	   							
					)
					
				}
			}
		})
	}
	else if(enroll_flag==1 && school_flag==3){   //点击正在报名和高中
		var ContestObject=10;
		var ContestState=2;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_ing").append(
							'<div class="ing_com_small">'
								+'<div class="ing_on_date">'+json.result[i].startTime+'<a class="ing_on">开始</a></div>'+
		   						'<div class="ing_div_rest">'
		   							+'<div class="ing_pic"></div>'
		   							+'<div class="ing_detail">'+
		   								'<div class="ing_sub">'+json.result[i].competitionName+'</div>'
		   								+'<div class="ing_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
			    						+'<div class="ing_type">赛事结束：'+json.result[i].competitionSession+'</div>'
			    						+'<div class="ing_obj">参赛对象：'+contestObjectString+'</div>'
			    						+'<div class="ing_detail_go">'
			    							+'<button class="button_ing_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">我要报名</button>'
			    						+'</div>'
		   							+'</div>'
		   						+'</div>'
		   					+'</div>'
	   							
					)
					
				}
			}
		})
	}
}

//小学
function appear_pri(){
	$(".school_move").animate({left:'0%'});
	school_flag=1;
	
	if(enroll_flag==1 && school_flag==1){   //点击正在报名和小学
		$(".soon_com_big").fadeOut();
		$(".soon_page").fadeOut();
		$(".ing_com_big").fadeIn();
		$(".ing_page").fadeIn();
		$(".div_each_ing").html("");
		
		var ContestObject=2;
		var ContestState=2;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_ing").append(
							'<div class="ing_com_small">'
								+'<div class="ing_on_date">'+json.result[i].startTime+'<a class="ing_on">开始</a></div>'+
		   						'<div class="ing_div_rest">'
		   							+'<div class="ing_pic"></div>'
		   							+'<div class="ing_detail">'+
		   								'<div class="ing_sub">'+json.result[i].competitionName+'</div>'
		   								+'<div class="ing_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
			    						+'<div class="ing_type">赛事结束：'+json.result[i].competitionSession+'</div>'
			    						+'<div class="ing_obj">参赛对象：'+contestObjectString+'</div>'
			    						+'<div class="ing_detail_go">'
			    							+'<button class="button_ing_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">我要报名</button>'
			    						+'</div>'
		   							+'</div>'
		   						+'</div>'
		   					+'</div>'
					)
				}
			}
		})
	}
	else if(enroll_flag==2 && school_flag==1){   //点击即将报名和小学
		$(".ing_com_big").fadeOut();
		$(".ing_page").fadeOut();
		$(".soon_com_big").fadeIn();
		$(".soon_page").fadeIn();
		$(".div_each_soon").html("");
		
		var ContestObject=2;
		var ContestState=1;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_soon").append(
						'<div class="soon_com_small">'
							+'<div class="soon_on_date">'+json.result[i].startTime+'<a class="soon_on">开始</a></div>'
							+'<div class="soon_div_rest">'
								+'<div class="soon_pic"></div>'
								+'<div class="soon_detail">'
									+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
									+'<div class="soon_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
									+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
									+'<div class="soon_obj">参赛对象：'+contestObjectString+'</div>'
									+'<div class="soon_detail_go">'
										+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
									+'</div>'
								+'</div>'
							+'</div>'
						+'</div>'
					)
				}
			}
		})
	}
}

//初中
function appear_midd(){
	$(".school_move").animate({left:'33.3%'});
	school_flag=2;
	
	if(enroll_flag==1 && school_flag==2){   //点击正在报名和初中
		$(".soon_com_big").fadeOut();
		$(".soon_page").fadeOut();
		$(".ing_com_big").fadeIn();
		$(".ing_page").fadeIn();
		$(".div_each_ing").html("");
		
		var ContestObject=8;
		var ContestState=2;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_ing").append(
							'<div class="ing_com_small">'
								+'<div class="ing_on_date">'+json.result[i].startTime+'<a class="ing_on">开始</a></div>'+
		   						'<div class="ing_div_rest">'
		   							+'<div class="ing_pic"></div>'
		   							+'<div class="ing_detail">'+
		   								'<div class="ing_sub">'+json.result[i].competitionName+'</div>'
		   								+'<div class="ing_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
			    						+'<div class="ing_type">赛事结束：'+json.result[i].competitionSession+'</div>'
			    						+'<div class="ing_obj">参赛对象：'+contestObjectString+'</div>'
			    						+'<div class="ing_detail_go">'
			    							+'<button class="button_ing_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">我要报名</button>'
			    						+'</div>'
		   							+'</div>'
		   						+'</div>'
		   					+'</div>'
					)
				}
			}
		})
	}
	else if(enroll_flag==2 && school_flag==2){   //点击即将报名和初中
		$(".ing_com_big").fadeOut();
		$(".ing_page").fadeOut();
		$(".soon_com_big").fadeIn();
		$(".soon_page").fadeIn();
		$(".div_each_soon").html("");
		
		var ContestObject=8;
		var ContestState=1;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_soon").append(
						'<div class="soon_com_small">'
							+'<div class="soon_on_date">'+json.result[i].startTime+'<a class="soon_on">开始</a></div>'
							+'<div class="soon_div_rest">'
								+'<div class="soon_pic"></div>'
								+'<div class="soon_detail">'
									+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
									+'<div class="soon_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
									+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
									+'<div class="soon_obj">参赛对象：'+contestObjectString+'</div>'
									+'<div class="soon_detail_go">'
										+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
									+'</div>'
								+'</div>'
							+'</div>'
						+'</div>'
					)
				}
			}
		})
	}
}

//高中
function appear_high(){
	$(".school_move").animate({left:'66.6%'});
	school_flag=3;
	
	if(enroll_flag==1 && school_flag==3){   //点击正在报名和高中
		$(".soon_com_big").fadeOut();
		$(".soon_page").fadeOut();
		$(".ing_com_big").fadeIn();
		$(".ing_page").fadeIn();
		$(".div_each_ing").html("");
		
		var ContestObject=10;
		var ContestState=2;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_ing").append(
							'<div class="ing_com_small">'
								+'<div class="ing_on_date">'+json.result[i].startTime+'<a class="ing_on">开始</a></div>'+
		   						'<div class="ing_div_rest">'
		   							+'<div class="ing_pic"></div>'
		   							+'<div class="ing_detail">'+
		   								'<div class="ing_sub">'+json.result[i].competitionName+'</div>'
		   								+'<div class="ing_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
			    						+'<div class="ing_type">赛事结束：'+json.result[i].competitionSession+'</div>'
			    						+'<div class="ing_obj">参赛对象：'+contestObjectString+'</div>'
			    						+'<div class="ing_detail_go">'
			    							+'<button class="button_ing_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">我要报名</button>'
			    						+'</div>'
		   							+'</div>'
		   						+'</div>'
		   					+'</div>'
					)
				}
			}
		})
	}
	else if(enroll_flag==2 && school_flag==3){   //点击即将报名和高中
		$(".ing_com_big").fadeOut();
		$(".ing_page").fadeOut();
		$(".soon_com_big").fadeIn();
		$(".soon_page").fadeIn();
		$(".div_each_soon").html("");
		
		var ContestObject=10;
		var ContestState=1;	
		$.ajax({
			type: "GET",
			url: "./MainContestNewsInfo",
			data:{ContestObject:ContestObject,ContestState:ContestState},
			dataType: "json",
			success: function(json){
				for(var i=0;i<json.result.length;i++){
					
					var contestObject=json.result[i].contestObject;//竞赛年级
					var contestObjectString="";
					if(contestObject<=6&&contestObject>=1){
						contestObjectString="小学生";
					}
					else if(contestObject<=9&&contestObject>=7){
						contestObjectString="初中生";
					}
					else if(contestObject<=12&&contestObject>=9){
						contestObjectString="高中生";
					}
					$(".div_each_soon").append(
						'<div class="soon_com_small">'
							+'<div class="soon_on_date">'+json.result[i].startTime+'<a class="soon_on">开始</a></div>'
							+'<div class="soon_div_rest">'
								+'<div class="soon_pic"></div>'
								+'<div class="soon_detail">'
									+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
									+'<div class="soon_subject">赛事科目：'+json.result[i].contestSubject+'</div>'
									+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
									+'<div class="soon_obj">参赛对象：'+contestObjectString+'</div>'
									+'<div class="soon_detail_go">'
										+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
									+'</div>'
								+'</div>'
							+'</div>'
						+'</div>'
					)
				}
			}
		})
	}
}

//赛事详情
function gotoCompetitionDetail(id) {
	var competitionId=id;
	window.location.href="Web/Competition/jsp/competitionDetail.jsp?competitionId="+competitionId;
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
			$(".com_left_box").html(
					'<div class="com_left" onclick="appear_on()">正在报名'+json.result+'个赛事</div>'
			)
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
			$(".com_right_box").html(
					'<div class="com_right" onclick="appear_ing()">即将报名'+json.result+'个赛事</div>'
			)
		}
	})
}