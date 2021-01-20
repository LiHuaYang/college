/**
 * 
 */


$(function() {
	$.post("../f?m=getAll", {
	}, function(data) {
		var json = JSON.parse(data);
		show_board_article(json.board);
		show_category_article(json.categ);
	});
});

/****************************************************************************************************/
//101	教育新闻
//102	考试技巧
//103	课程安排
//104	招生专栏
//105	博文动态
//106	博文热点
//107	荣誉榜
function show_board_article (json) {
	var length = json.length;
	for (var i=0; i<length; i++) {
		switch (json[i].board_id) {
			case "101" : // 教育新闻
				show_bw_jyxw(json[i].article_list);
				break;
			case "102" : // 考试技巧
				show_bw_ksjq(json[i].article_list);
				break;
			case "103" : // 课程安排
				show_bw_kcap(json[i].article_list);
				break;
			case "105":  // 博文动态
				show_bw_dt(json[i].article_list);
				break;
			case "106":  // 博文热点
				show_bw_rd(json[i].article_list);
				break;
			case "107" : // 荣誉榜
				show_bw_ryb(json[i].article_list);
				break;
			case "111" : // 名师介绍
				show_bw_msjs(json[i].article_list);
				break;
		}
	}
}
// 博文动态--100--博文新闻
function show_bw_dt (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var link = json[i].link;
		html = html + '<h2><a href="'+ link + '" title="' + titile +'">' + titile + '</a></h2>';
	}
	$("#bwnews_content").append(html);
}

// 博文热点--100--博文新闻
function show_bw_rd (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		html = html + '<li><strong><a href="'+ link + '" title="' + titile +'">' + titile + '</a></strong><span>' + time +'</span></li>' ;
	}
	$("#infoList_bwrd").append(html);
}

// 荣誉榜--100--博文新闻
function show_bw_ryb (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		html = html + '<li><strong><a href="'+ link + '" title="' + titile +'">' + titile + '</a></strong><span>' + time +'</span></li>' ;
	}
	$("#infoList_bwryb").append(html);
}

// 课程安排--100--博文新闻
function show_bw_kcap (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		html = html + '<dd> <a href="' + link + '" title="' + titile +'">' + titile + '</a></dd>' ;
	}
	$("#ggl_content_kcap").append(html);
}

// 教育新闻--100--博文新闻
function show_bw_jyxw (json) {
	var length = json.length; // 文章的数目
	var html = "";
	var titile = json[0].title;
	var time = json[0].time;
	var link = json[0].link;
	html = '<h2><a href="' + link + '" title="' + titile +'">' + titile + '</a></h2>' ;
	$("#index_right_jyxw").append(html);
	html = "";
	
	for (var i=1; i<length; i++) {
		// 截取一小部分字符串
		titile = json[i].title;
		time = json[i].time;
		var link = json[i].link;
		html = html + '<dd><a href="' + link +'" title="' + titile +'">' + titile + '</a></dd>' ;
	}
	$("#index_bottom_jyxw").append(html);
}

// 考试技巧--100--博文新闻
function show_bw_ksjq (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		html = html + '<dd> <a href="' + link + '" title="' + titile +'">' + titile + '</a></dd>' ;
	}
	$("#mbright_content_ksjq").append(html);
}
/****************************************************************************************************/
//培训课程	101
//名师介绍	102
//博文采风	103
//关于我们	104
//联系我们	105
//校园风貌	106
//试题精选	107
//<li><a id="menu0" onmouseover="SelMenu(0)" href="main.html" class="menuO">网站首页</a></li> 
//<li><a id="menu1" onmouseover="SelMenu(1)" href="detail.html?article_id=1034" class="menuN">关于博文</a></li> 
//<li><a id="menu2" onmouseover="SelMenu(2)" href="list.html?id=101&type=c" class="menuN">培训课程</a></li> 
//<li><a id="menu3" onmouseover="SelMenu(3)" href="list.html?id=102&type=c" class="menuN">名师介绍</a></li> 
//<li><a id="menu4" onmouseover="SelMenu(4)" href="list.html?id=103&type=c" class="menuN">博文采风</a></li> 
//<li><a id="menu5" onmouseover="SelMenu(5)" href="list.html?id=103&type=b" class="menuN">课程安排</a></li> 
//<li><a id="menu6" onmouseover="SelMenu(6)" href="list.html?id=107&type=c" class="menuN">试题精选</a></li> 
function show_category_article (json) {
	var length = json.length;
	for (var i=0; i<length; i++) {
		switch (json[i].catgory_id) {
			case "101" : // 培训课程
				//show_bw_jyxw(json[i].article_list);
				break;
			case "102" : // 名师介绍
				show_bw_msjs(json[i].article_list);
				break;
			case "103" : // 博文采风
				//show_bw_kcap(json[i].article_list);
				break;
			case "104":  // 关于我们
				//show_bw_dt(json[i].article_list);
				break;
			case "105":  // 联系我们
				//show_bw_rd(json[i].article_list);
				break;
			case "106" : // 校园风貌
				//show_bw_ryb(json[i].article_list);
				break;
			case "107" : // 试题精选
				show_bw_stjx(json[i].article_list);
				break;
		}
	}
}

// 名师介绍
function show_bw_msjs (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	for (var i=0; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		html = html + '<li><a href="' + link + '" title="' + titile +'">' + titile + '</a></li>' ;
	}
	$("#infoList_msjs").append(html);
}


//<dl id="index_right_stjx">
//<!-- <dd>
//	<a href="http://www.ningbobw.com/download.php?id=516"
//		title="2014年希望杯六年级考前100题答案（76-100）" target="_blank">2014年希望杯六年级考前</a>
//</dd> -->
//</dl>

// 试题精选
function show_bw_stjx (json) {
	var length = json.length; // 文章的数目
	var html = "";
	
	if (length <= 4) {
		for (var i=0; i<length; i++) {
			var titile = json[i].title;
			var time = json[i].time;
			var link = json[i].link;
			html = html + '<dd><a href="' + link + '" title="' + titile +'">' + titile + '</a></dd>' ;
		}
	}
	
	$("#index_right_stjx").append(html);
	html = "";
	for (var i=4; i<length; i++) {
		var titile = json[i].title;
		var time = json[i].time;
		var link = json[i].link;
		html = html + '<dd><a href="' + link + '" title="' + titile +'">' + titile + '</a></dd>' ;
	}
	$("#index_bottom_stjx").append(html);
}
