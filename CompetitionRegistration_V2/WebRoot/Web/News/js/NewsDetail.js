$(document).ready(function(){
	Show_NewsDetail();
});

var number = 0;

//根据相应id显示新闻内容,(目前只显示一张图片)
function Show_NewsDetail(){
	
	$.ajax({
		type: "GET",
		url: "./GetSingleNewsbyIdServlet",
		data:{newsId:newsid},
		dataType: "json",
		success: function(json){
			$(".TopNews").css({
				"background-image":"url('"+json.result[number].newsPicUrl+"')"
			})
			$(".news_title_box").html(
				'<div class="news_title">'+json.result[0].newsTitle+'</div>'
			)
			$(".news_content_box").html(
				'<div class="news_content">'+json.result[0].newsContent+'</div>'
			)
			$(".news_time_box").html(
				'<div class="news_time">'+json.result[0].newsPutTime+'</div>'
			)
			$(".news_from_box").html(
				'<div class="news_from">新闻出处：'+json.result[0].newsSource+'</div>'
			)
		}
	})
}




//滚动查看大图查看下一张图片
function tonext(){
	number = number+1;	
	$.ajax({
		type: "GET",
		url: "./GetSingleNewsbyIdServlet",
		data:{newsId:newsid},
		dataType: "json",
		success: function(json){
			if(number < json.result.length){
				
				$(".TopNews").css({
					"background-image":"url('"+json.result[number].newsPicUrl+"')"
				})
				
			}else{
				number = 0;
				$(".TopNews").css({
					"background-image":"url('"+json.result[number].newsPicUrl+"')"
				})
			}
			
		}
	});
}

//滚动查看大图查看上一张图片
function toprevious(){
	number = number-1;
	$.ajax({
		type: "GET",
		url: "./GetSingleNewsbyIdServlet",
		data:{newsId:newsid},
		dataType: "json",
		success: function(json){
			if(number >= 0){
				
				$(".TopNews").css({
					"background-image":"url('"+json.result[number].newsPicUrl+"')"
				})
				
			}else{
				number = json.result.length-1;
				$(".TopNews").css({
					"background-image":"url('"+json.result[number].newsPicUrl+"')"
				})
			}
			
		}
	});
}