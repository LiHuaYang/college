/**
 * 
 */





$(function() {

	var article_id = getUrlParam("article_id");
//	var name = getUrlParam("name");

	$.get("../f?m=getDetial&js_article_id=" + article_id, {
	}, function(data) {
		 var json = JSON.parse(data);
		show(json);
	});
});


//<h1 class="news_title" >2015睿达杯一试博文考点英语晋级名单</h1>
//<div class="news_mid">发布时间：2015-11-05 12:25<span></span>浏览量：3813<span></span><a href="javascript:history.back();">返回上一页</a></div>
//
//<div class="news_content">
//	这里是文章的正文！！！！
//</div>


function show(json) {
	var html = "";
	var title = json.title;
	var content = json.content;
	var time = json.time;
	var attach = json.attach;
	html = html + '<h1 class="news_title">' + title + '</h1>' ;
	html = html + '<div class="news_mid">发布时间：'  + time + '<a style="color:blue" href="'+ attach +'"><span>点击下载附件</span></a></div>' ;
	html = html + '<div class="news_content">' + content + '</div>' ;
		
	$("#ccontenter_bw_article").append(html);
}


function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

