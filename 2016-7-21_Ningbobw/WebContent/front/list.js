/**
 * 
 */





$(function() {
	var id = getUrlParam("id");
	var type = getUrlParam("type");
	
//	var name = getUrlParam("name");

	$.get("../f?m=getTitle&js_type=" + type + "&js_id=" + id, {
	}, function(data) {
		 var json = JSON.parse(data);
		show(json);
	});
});

function show(json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		
		html = html + '<dd><a href="'+ link + '" title="' + titile +'">' + titile + '</a><span>' + time + '</span></dd>';
	}
	$("#news_lists_categroy").append(html);
}


function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

