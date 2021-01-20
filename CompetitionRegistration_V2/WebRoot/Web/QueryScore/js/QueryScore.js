
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


$(document).ready(function(){
	QueryScore();    //查询成绩
	
})

//关闭成绩框
function close_score(){
	$(".all").hide();
	window.location.href="Web/Main/jsp/Main.jsp";
}

//查询成绩
function QueryScore(){
	
	var json={
			"CompetitionName": decodeURI(getUrlParam('subject')), 
			"StudentName":decodeURI(getUrlParam('name')),
			"StudentTicket":getUrlParam('id'),
			"EnrollmentPassword":getUrlParam('EnrollmentPassword')
		}
	
	    console.log(json);
	
		$.ajax({
			type: "GET",
			url: "./SearchScoreByInfoServlet",
			data:{json:JSON.stringify(json)},
			dataType: "json",
			success: function(json){
				
				if(json.data==undefined){
					alert("成绩还未出来或输入信息不匹配");
					window.location.href="Web/Main/jsp/Main.jsp";
				}
				else{
				    var contestObject=json.data.contestObject;//竞赛年级
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
					 
					$(".name_frame").html(
							'<div class="name_font">姓名：</div>'
							+'<div class="name_div">'+json.data.studentName+'</div>'
					)
					$(".ticket_number").html(
							'<div class="sex_font">准考证号：</div>'
							+'<div class="sex_div">'+json.data.studentTicket+'</div>'
					)
					$(".contest_name_frame").html(
							'<div class="contest_name_font">竞赛名称：</div>'
							+'<div class="contest_name_div">'+json.data.competitionName+'</div>'
					)
					$(".contest_rank_frame").html(
							'<div class="contest_rank_font">考试级别：</div>'
							+'<div class="contest_rank_div">'+contestObjectString+'</div>'
					)
					$(".contest_type_frame").html(
							'<div class="contest_type_font">考试类别：</div>'
							+'<div class="contest_type_div">'+json.data.contestSubject+'</div>'
					)
					
					var StudentScore=0;
					if(json.data.studentScore==-1){
						StudentScore="暂无成绩"
					}
					else{
						StudentScore=json.data.studentScore;
					}
					
					$(".total_score_frame").html(
							'<div class="total_score_font">考试总分：</div>'
							+'<div class="total_score_div">'+StudentScore+'</div>'
					)
				}
			}
		});
		
}