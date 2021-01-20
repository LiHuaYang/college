/**
 * 
 *  获取数据列表
 *  @return
 */

/**
 * @param problemid
 */
function getData(problemid) {
	var json = {
			"id" : problemid
		};
	$.post("../../ProblemActionV2",{
		"method" : "getProblemDetail",
		json : JSON.stringify(json)
	},function(data) {
		var json1 = JSON.parse(data);
		if(json1.msg==true) {
			var json = json1.data;
			$("#problem_detail").append("<div></<center>"+"<h2>"+json.title+"</h2>"+
					"时间限制："+json.time_limit+
					"内存限制："+json.memory_limit+"</br>"+
					"提交："+json.submit+
					"时间限制："+json.accepted+"</br>"+
					"[<a href='submit_problem.html?problem_id=" + json.problem_id + "'>提交</a>]"+
					"[<a href=''>状态</a>]"+
					"[<a href=''>讨论版</a>]</center>");
			$("#problem_detail").append("<h2>题目描述：</h2>"+json.description+"</br>")
			$("#problem_detail").append(json.description);
			$("#problem_detail").append("<h2>样例输入：</h2>"+json.sample_input+"</br>");
			$("#problem_detail").append("<h2>样例输出：</h2>"+json.sample_output+"</br>");
			$("#problem_detail").append("<h2>提示：</h2>"+json.hint+"</br>");
			$("#problem_detail").append("<h2>来源：</h2>"+"<a href=''>"+json.source+"</a>"+"</br>");
			$("#problem_detail").append("<center><a class='btn btn-default' href='submit_problem.html?problem_id=" + json.problem_id + "'>提交</a><a class='btn btn-default' href=''>状态</a>");
		}
//		console.log(json.problem_id);
	});
}

function getProblemId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	getData(strRight);
}

$(document).ready(function() {
	getProblemId();
})
