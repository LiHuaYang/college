$(document).ready(function(){
	show_com();
});

//显示查询出的大赛
function show_com(){
	
	$.ajax({
		type: "GET",
		url: "./GetContestInfobyNameObjectSubjectServlet",
		data:{contestSearchWords:condition},
		dataType: "json",
		success: function(json){
			if(json.result.length!=0){
				for(var i=0;i<json.result.length;i++){
					
					var CompetitionStartTime="";//比赛开始时间	
						CompetitionStartTime=json.result[i].contestList1[0].startTime;
					
					var CompetitionSubject="";//大赛科目
					for(var j=0;j<json.result[i].contestList2.length;j++){
						CompetitionSubject+=json.result[i].contestList2[j].contestSubject+",";//科目拼接
					}
					CompetitionSubject=CompetitionSubject.substring(0,CompetitionSubject.length-1);//将最后一个逗号去掉
					
					
					if(json.result[i].contestState==2){   //正在报名
						$(".com_each").append(
							'<div class="soon_com_small">'+
								'<div class="soon_on_date"><a class="soon_on">'+CompetitionStartTime+'开始进行</a></div>'
								+'<div class="soon_div_rest">'
									+'<div class="soon_pic" id="picture'+i+'"></div>'
									+'<div class="soon_detail">'
										+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
										+'<div class="soon_subject">赛事科目：'+CompetitionSubject+'</div>'
										+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
										+'<div class="soon_obj">参赛对象：'+json.result[i].competitionObjectDescribe+'</div>'
										+'<div class="enroll_start">报名开始时间：'+json.result[i].competitionEnrollStartTime+'</div>'
										+'<div class="enroll_end">报名结束时间：'+json.result[i].competitionEnrollEndTime+'</div>'
										+'<div class="soon_detail_go">'
											+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">点我报名</button>'
										+'</div>'
									+'</div>'
								+'</div>'
								+'<div class="com_describ">'+json.result[i].contestPropaganda+'</div>'
							+'</div>'
						)
					}
					else{         //其余情况
						$(".com_each").append(
								'<div class="soon_com_small">'+
									'<div class="soon_on_date"><a class="soon_on">'+CompetitionStartTime+'开始进行</a></div>'
									+'<div class="soon_div_rest">'
										+'<div class="soon_pic" id="picture'+i+'"></div>'
										+'<div class="soon_detail">'
											+'<div class="soon_sub">'+json.result[i].competitionName+'</div>'
											+'<div class="soon_subject">赛事科目：'+CompetitionSubject+'</div>'
											+'<div class="soon_type">赛事届数：'+json.result[i].competitionSession+'</div>'
											+'<div class="soon_obj">参赛对象：'+json.result[i].competitionObjectDescribe+'</div>'
											+'<div class="enroll_start">报名开始时间：'+json.result[i].competitionEnrollStartTime+'</div>'
											+'<div class="enroll_end">报名结束时间：'+json.result[i].competitionEnrollEndTime+'</div>'
											+'<div class="soon_detail_go">'
												+'<button class="button_soon_detail_go" onclick="gotoCompetitionDetail('+json.result[i].competitionId+')">了解详情</button>'
											+'</div>'
										+'</div>'
									+'</div>'
									+'<div class="com_describ">'+json.result[i].contestPropaganda+'</div>'
								+'</div>'
						)
					}
					$("#picture"+i+"").css({"background-image":"url('"+json.result[i].competitionPicture+"')"});
				}
			}
			else{
				//跳转到主界面
				alert("没有该比赛");
				window.location.href="Web/Main/jsp/Main.jsp";
			}
		}
	});
}

//跳转到大赛详情界面
function gotoCompetitionDetail(id){
	var competitionId=id;
	window.location.href="Web/Competition/jsp/competitionDetail.jsp?competitionId="+competitionId;
}