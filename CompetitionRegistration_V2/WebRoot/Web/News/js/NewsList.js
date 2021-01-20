$(document).ready(function(){
	$("#MuneNews").attr("class", "curr");
	
	Search_Top_News(); //查询所有的头条新闻，目前只显示一个头条
	Search_All_News();//查询所有的新闻
	Get_Num_News();//获得所有非头条新闻总数来分页
});

//查询所有的头条新闻，目前只显示一个头条
function Search_Top_News(){
	$.ajax({
		type: "GET",
		url: "./SearchTopNewsServlet",
		data:{},
		dataType: "json",
		success: function(json){
			$(".TopNews").css({
//				"background-image":"url('"+json.result[0].newsPicUrl+"')"
			})
			$(".top_font").html(
				'<div class="top_title">'+json.result[0].newsTitle+'</div>'
			)
		}
	})
}

var NewsId=new Array();     //新闻id
//查询所有的新闻
function Search_All_News(){
	$.ajax({
		type: "GET",
		url: "./SearchAllNewsServlet",
		data:{page:1},
		dataType: "json",
		success: function(json){
			
			for ( var i = 0; i < json.result.length; i++) {
				NewsId[i]=json.result[i].newsId;
				$(".news_each").append(
					'<div class="news_small">'
//	   					+'<div class="news_pic" id="pic'+i+'"></div>'
	   					+'<div class="news_title" id="title'+i+'" onclick="Go_News_Detail('+i+')">'+json.result[i].newsTitle+'</div>'
	   					+'<div class="news_time">'+json.result[i].newsPutTime+'</div>'
	   				+'</div>'
				)
			}
		}
	})
	
}

//获得所有非头条新闻总数来分页
function Get_Num_News(){
	
	$.ajax({
		type: "GET",
		url: "./GetNewsAccountServlet",
		data:{},
		dataType: "json",
		success: function(json){
			
			page_all=Math.ceil(json.result/10);
			for ( var i = 1; i <= page_all; i++) {
				
				$(".news_page").append(
						'<div class="news_page_num" onclick="page_go('+i+')">'+i+'</div>'
				)
			}
			$(".news_page").append(
					'<div class="news_page_num2" onclick="page_next()">></div>'
			)
		}
	})
}

var page=1;       //当前页
var next_page=0;   //下一页
var page_all=0;   //页数总数
//跳转到指定页数
function page_go(i){
	
	page=i;
	$(".news_each").html("");
	$.ajax({
		type: "GET",
		url: "./SearchAllNewsServlet",
		data:{page:i},
		dataType: "json",
		success: function(json){
			
			for ( var i = 0; i < json.result.length; i++) {
				NewsId[i]=json.result[i].newsId;
				$(".news_each").append(
					'<div class="news_small">'
//	   					+'<div class="news_pic" id="pic'+i+'"></div>'
	   					+'<div class="news_title" id="title'+i+'" onclick="Go_News_Detail('+i+')">'+json.result[i].newsTitle+'</div>'
	   					+'<div class="news_time">'+json.result[i].newsPutTime+'</div>'
	   				+'</div>'
				)
			}
		}
	})
}

//跳转到下一页
function page_next(){
	
	next_page=page+1;
	if(next_page>page_all){
		alert("已经是最后一页了")
	}
	else{
		page_go(next_page);
	}
}

//搜索新闻
function Search_News(){
	
	var News_Name=$(".SearchBox").val();
	if(News_Name!=""){
		
		$(".news_each").html("");
		$(".news_page").html("");
		$.ajax({
			type: "GET",
			url: "./GetNewsbyNameState",
			data:{NewsSearch:News_Name},
			dataType: "json",
			success: function(json){
				
				for ( var i = 0; i < json.result.length; i++) {
					NewsId[i]=json.result[i].newsId;
					$(".news_each").append(
						'<div class="news_small">'
//		   					+'<div class="news_pic" id="pic'+i+'"></div>'
		   					+'<div class="news_title">'+json.result[i].newsTitle+'</div>'
		   					+'<div class="news_time">'+json.result[i].newsPutTime+'</div>'
		   				+'</div>'
					)
				}
			}
		})
	}
	else{
		alert("搜索内容不能为空")
	}
}

//跳转到新闻详细界面
function Go_News_Detail(i){
	
	var id=new Number(NewsId[i]);    //转为int类型
	window.location.href="Web/News/jsp/NewsDetail.jsp?newsid="+id+"";
}
