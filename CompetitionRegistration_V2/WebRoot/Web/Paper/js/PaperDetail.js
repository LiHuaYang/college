$(document).ready(function(){
	Show_Ques_Ans();  //显示题目答案
	Judge_Save_Ornot();  //判断是否收藏
});

//显示题目答案
function Show_Ques_Ans(){
	
	$.ajax({
		type: "GET",
		url: "./GetTestPaperPictureById",
		data:{PaperId:paperid},
		dataType: "json",
		success: function(json){
			
			for ( var i = 0; i < json.result.length; i++) {
				var picurl=json.result[i].testPapeTitleUrl;
				var picurl_ans=json.result[i].testPaperAnswerUrl;
				$(".ques_box").append(
					'<div class="ques">'
		    			+'<div class="ques_num">第'+json.result[i].testPaperNumber+'题:</div>'
		    			+'<div class="ques_pic" id="ques_picture'+i+'" onclick="gotobigpic(\''+picurl+'\')"></div>'
	    			+'</div>'
				)
				$("#ques_picture"+i+"").css({
					"background-image":"url('"+json.result[i].testPapeTitleUrl+"')"
				})
				
				$(".ans_box").append(
					'<div class="ans">'
		    			
		    			+'<div class="ans_pic" id="ans_picture'+i+'" onclick="gotobigpic_ans(\''+picurl_ans+'\')"></div>'
		    		+'</div>'
				)
				$("#ans_picture"+i+"").css({
					"background-image":"url('"+json.result[i].testPaperAnswerUrl+"')"
				})
			}
		}
	})
}

//打开题目大图
function gotobigpic(picurl){
	document.getElementById("back-pic").style.display="";
	$("#big-pic").css({
		"background-image":"url('"+picurl+"')"
	})
}
//打开答案大图
function gotobigpic_ans(picurl_ans){
	document.getElementById("back-pic-ans").style.display="";
	$("#big-pic-ans").css({
		"background-image":"url('"+picurl_ans+"')"
	})
}
//关闭大图
function close_score(){
	$(".back-pic").hide();
	$(".back-pic-ans").hide();
	$(".all").show();
}

//判断用户是否收藏该试卷
function Judge_Save_Ornot(){
	
	if(userid!=0){     //只有用户登录了才判断
		$.ajax({
			type: "GET",
			url: "./CollectStateJudgeServlet",
			data:{UserId:userid,PaperId:paperid},
			dataType: "json",
			success: function(json){
				if(json.flag==true){
					var d = document.getElementById("img_save");

					d.style.backgroundColor = "red";
//					alert(d.style.backgroundColor)
				}
			}
		})
	}
}

//用户收藏\取消试卷
function Collect_Paper(){
	
	if(userid!=0){      //只有用户登录了才能收藏和取消收藏
		
		var d = document.getElementById("img_save");
		var color=d.style.backgroundColor;
		
		if(color=="red"){         //已经收藏过,点击取消收藏
			
			$.ajax({
				type: "GET",
				url: "./CancelCollenctStateServlet",
				data:{UserId:userid,PaperId:paperid},
				dataType: "json",
				success: function(json){
					
					alert("取消成功")
					var cancel_color = document.getElementById("img_save");

					cancel_color.style.backgroundColor = "white";
				}
			})
		}
		else{         //没有收藏过,点击收藏
			
			$.ajax({
				type: "GET",
				url: "./CollectCreateServlet",
				data:{CollectName:papername,TestPaperId:paperid,Userid:userid},
				dataType: "json",
				success: function(json){
					
					alert("收藏成功")
					var cancel_color = document.getElementById("img_save");

					cancel_color.style.backgroundColor = "red";
				}
			})
		}
	}
	else{
		alert("请先登录");
	}
}
