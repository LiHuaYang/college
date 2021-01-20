

//$(function() {
//	
//	// 1. 先判断用户是否登陆
//	$.post("../../UserActionV2", {
//		method : "AdminCheck"
//	}, function(json) {
//		var data = JSON.parse(json);
//		if (data.res == "true") {
//			// 1. 用户已经登陆
//			$("#head").append('<html> <head></head> <body> <nav class="navbar navbar-default"> <div class="container-fluid"> <div class="navbar-header"> <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only"> Toggle navigation </span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="problem_list.html"> NBUT-HUSTOJ </a> </div> <div id="navbar" class="navbar-collapse collapse"> <ul class="nav navbar-nav"> <li> <a href="problem_list.html">问题</a> </li> <li> <a href="solution.html">状态</a> </li> <li> <a href="contest.html">竞赛和作业</a> </li> </ul> <ul class="nav navbar-nav navbar-right"> <li class="dropdown" id="dm"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" id="">' + data.data.user_id + '<span class="caret"></span> </a> <ul class="dropdown-menu"> <li id="dm_per"> <a href="register.html">个人主页</a> </li> <li id="dm_lot"> <a href="javascript:logout()">注销</a> </li> <li id="dm_man"> <a href="../../Admin/admin.html">管理</a> </li>  </ul> </li> </ul> </div> <!--/.nav-collapse --> </div> <!--/.container-fluid --> </nav>  </body> </html>');
//		} else {
//			// 2. 用户未登陆
//			$("#head").append('<html> <head></head> <body> <nav class="navbar navbar-default"> <div class="container-fluid"> <div class="navbar-header"> <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only"> Toggle navigation </span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="problem_list.html"> NBUT-HUSTOJ </a> </div> <div id="navbar" class="navbar-collapse collapse"> <ul class="nav navbar-nav"> <li><a href="problem_list.html">问题</a></li> <li><a href="solution.html">状态</a></li> <li><a href="contest.html">竞赛和作业</a></li> </ul> <ul class="nav navbar-nav navbar-right"> <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" id="">登录<span class="caret"></span> </a> <ul class="dropdown-menu"> <li><a href="login.html">登录</a></li> <li><a href="register.html">注册</a></li> </ul></li> </ul> </div> <!--/.nav-collapse --> </div> <!--/.container-fluid --> </nav> </body> </html>');
//		}
//	});
//});


$(function() {
	$("#footer").append('<div class="footer_menu"><ul><li><a href="">网站首页</a></li> 	<li class="footer_line">|</li> 	<li><a href="detail.html?article_id=1034">关于博文</a></li> <li class="footer_line">|</li> 	<li><a href="list.html?id=101">培训课程</a></li> 	<li class="footer_line">|</li> 	<li><a href="list.html?id=111">名师介绍</a></li> 	<li class="footer_line">|</li> 	<li><a href="">博文风采</a></li> 	<li class="footer_line">|</li> 	<li><a href="list.html?id=103">课程安排</a></li> 	<li class="footer_line">|</li> 	<li><a href="">试题精选</a></li> </ul> </div> <div class="copyright">  版权所有 <em style="font-style: normal; font-family: Arial;">Copyright (&copy;) 2008 - 2016</em> <a href="http://www.ningbobw.com/"> 	宁波市海曙区博文教育培训学校</a><span></span>技术支持：<a href="http://www.hisupplier.cc/" 	target="_blank">海商网</a><span></span>网址：<em 	style="font-style: normal; font-family: Arial;"><a 	href="http://www.ningbobw.com/" target="_blank">www.ningbobw.com</a></em><span></span><em 	style="font-style: normal;"> <p style="margin-top: 10px;">地址：宁波市海曙区世纪广场A304、A305<em style="font-style: normal; margin-left: 10px;">咨询热线：0574-27722770 27722780</em></p> </div>');
	$("#header").append('<div class="top"> <div class="logo"> <a href=""><img src="../images/logo.jpg" alt="博文教育" class="b" title="博文教育" /></a> </div> <div class="bl-logo"> <a href="" target="_blank"><img src="../images/bl-logo.gif" alt="" width="182" height="22" /></a> </div> <div class="tright"> <div class="globallinks"> <p><a href="javascript:void(0);" id="setHome" class="http://www.ningbobw.com/">设为首页</a></p> <p><a href="javascript:void(0);" id="addStar" class="http://www.ningbobw.com/|宁波市海曙区博文教育培训学校">加入收藏</a></p> </div> <div style="clear: both; font-size: 0;"></div> <div class="menu"> <ul> <li><a id="menu0" onmouseover="SelMenu(0)" href="main.html" class="menuO">网站首页</a></li> <li><a id="menu1" onmouseover="SelMenu(1)" href="detail.html?article_id=1034" class="menuN">关于博文</a></li> <li><a id="menu2" onmouseover="SelMenu(2)" href="list.html?id=101&type=c" class="menuN">培训课程</a></li> <li><a id="menu3" onmouseover="SelMenu(3)" href="list.html?id=102&type=c" class="menuN">名师介绍</a></li> <li><a id="menu4" onmouseover="SelMenu(4)" href="list.html?id=103&type=c" class="menuN">博文采风</a></li> <li><a id="menu5" onmouseover="SelMenu(5)" href="list.html?id=103&type=b" class="menuN">课程安排</a></li> <li><a id="menu6" onmouseover="SelMenu(6)" href="list.html?id=107&type=c" class="menuN">试题精选</a></li> </ul> </div> </div> </div> <div class="hcontact"></div>');
	$("#sidebar").append('<div class="sdh"> <h1>快速导航</h1> <div class="sdh_content"> <dl> <dt> <a href="detail.html?article_id=1034">学校简介</a> </dt> <dt> <a href="list.html?id=101&type=c">培训课程</a> </dt> <dt> <a href="list.html?id=102&type=c">名师介绍</a> </dt> <dt> <a href="list.html?id=103&type=c">博文采风</a> </dt> <dt> <a href="list.html?id=103&type=b">课程安排</a> </dt> <dt> <a href="list.html?id=107&type=c">试题精选</a> </dt> </dl> </div> </div> <div class="sdh scontact"> <h1>联系我们</h1> <div class="sdh_content scontact_content"> <p>地址：宁波市海曙区世纪广场</p> <p style="text-indent:3em;">A304、305</p> <p>邮编：315000</p> <p>电话：0574-27722780</p> <p style="text-indent:3em;">0574-27722770</p> <p>传真：0574-27722784</p> </div> </div> ');
});

/**
 * 用户登出
 */
//function logout() {
//	$.post("../../UserActionV2", {
//		method : "logout"
//	}, function(json) {
//		var data = JSON.parse(json);
//		if (data.res == "true") {
//			window.location.href = "problem_list.html";
//		} else {
//			alert("登出失败");
//		}
//	});
//}


