


/**
	<li id="dm_per"> <a href="register.html">个人主页</a> </li> 
	<li id="dm_lot"> <a href="javascript:logout()">注销</a> </li> 
	<li id="dm_man"> <a href="../../Admin/admin.html">管理</a> </li> 
 */
$(function() {
	
	// 1. 先判断用户是否登陆
	$.post("../../UserActionV2", {
		method : "AdminCheck"
	}, function(json) {
		var data = JSON.parse(json);
		if (data.res == "true") {
			// 1. 用户已经登陆
			$("#head").append('<html> <head></head> <body> <nav class="navbar navbar-default"> <div class="container-fluid"> <div class="navbar-header"> <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only"> Toggle navigation </span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="problem_list.html"> NBUT-HUSTOJ </a> </div> <div id="navbar" class="navbar-collapse collapse"> <ul class="nav navbar-nav"> <li> <a href="problem_list.html">问题</a> </li> <li> <a href="solution.html">状态</a> </li> <li> <a href="contest.html">竞赛和作业</a> </li> </ul> <ul class="nav navbar-nav navbar-right"> <li class="dropdown" id="dm"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" id="">' + data.data.user_id + '<span class="caret"></span> </a> <ul class="dropdown-menu"> <li id="dm_per"> <a href="register.html">个人主页</a> </li> <li id="dm_lot"> <a href="javascript:logout()">注销</a> </li> <li id="dm_man"> <a href="../../Admin/admin.html">管理</a> </li>  </ul> </li> </ul> </div> <!--/.nav-collapse --> </div> <!--/.container-fluid --> </nav>  </body> </html>');
		} else {
			// 2. 用户未登陆
			$("#head").append('<html> <head></head> <body> <nav class="navbar navbar-default"> <div class="container-fluid"> <div class="navbar-header"> <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only"> Toggle navigation </span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="problem_list.html"> NBUT-HUSTOJ </a> </div> <div id="navbar" class="navbar-collapse collapse"> <ul class="nav navbar-nav"> <li><a href="problem_list.html">问题</a></li> <li><a href="solution.html">状态</a></li> <li><a href="contest.html">竞赛和作业</a></li> </ul> <ul class="nav navbar-nav navbar-right"> <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" id="">登录<span class="caret"></span> </a> <ul class="dropdown-menu"> <li><a href="login.html">登录</a></li> <li><a href="register.html">注册</a></li> </ul></li> </ul> </div> <!--/.nav-collapse --> </div> <!--/.container-fluid --> </nav> </body> </html>');
		}
	});
});

/**
 * 用户登出
 */
function logout() {
	$.post("../../UserActionV2", {
		method : "logout"
	}, function(json) {
		var data = JSON.parse(json);
		if (data.res == "true") {
			window.location.href = "problem_list.html";
		} else {
			alert("登出失败");
		}
	});
}


