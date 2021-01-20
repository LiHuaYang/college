var nowpage = 1;
var contestId = null;
$(document).ready(function() {
	getContestId();
		var json = {
			"page" : 1,
			"contestId" : contestId
		}
		ShowAllSolution(json);
});

function getContestId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	contestId = strRight;
}
function ShowAllSolution(json) {
	$.getJSON("../../ContestActionV2", {
		json : JSON.stringify(json),"method" : "getContestSolution"
	}, function(jsonArray) {
		console.log(jsonArray);
		if (jsonArray.length > 0) {
			$(".solutionlist").empty();
			$(".solutionlist").append(
					"<tr>" + "<th>运行编号</th>" + "<th>用户</th>" + "<th>问题</th>"
							+ "<th>结果</th>" + "<th>内存</th>" + "<th>耗时</th>"
							+ "<th>语言</th>" + "<th>代码长度</th>" + "<th>提交时间</th>"
							+ "</tr>")
		}
		for (var i = 0; i < jsonArray.length; i++) {
			$(".solutionlist").append(
					"<tr>" + "<td>" + jsonArray[i].solution_id + "</td>"
					+ "<td><a href='#'>" + jsonArray[i].user_id
					+ "</a></td>" + "<td>" + jsonArray[i].problem_id
					+ "</td>" + "<td><button>"
					+ resultconversion(jsonArray[i].result)
					+ "</button></td>" + "<td>" + jsonArray[i].memory
					+ "</td>" + "<td>" + jsonArray[i].time + "</td>"
					+ "<td>" + jsonArray[i].language + "</td>" + "<td>"
					+ jsonArray[i].code_length + " B" + "</td>"
					+ "<td>" + jsonArray[i].in_date.substring(0,19) + "</td>")
		}
	});
}

function resultconversion(a) {
	switch (a) {
	case 4:
		return "正确";
	case 7:
		return "时间超限";
	case 11:
		return "编译错误";
	case 6:
		return "答案错误";
	}
}
function languageconversion(a) {
	switch (a) {
	case 0:
		return "C";
	case 1:
		return "C++";
	case 2:
		return "Pascal";
	case 3:
		return "Java";
	case 4:
		return "Ruby";
	case 5:
		return "Bash";
	case 6:
		return "Python";
	case 7:
		return "PHP";
	case 8:
		return "Perl";
	case 9:
		return "C#";
	case 10:
		return "Obj-C";
	case 11:
		return "FreeBasic";
	case 12:
		return "Schema";
	case 13:
		return "Clang";
	case 14:
		return "Clang++";
	case 15:
		return "Lua";
	case 16:
		return "Swift";
	}
}

function Top() {
	location.reload(true);
}
function PreviousPage() {
	if (nowpage > 1) {
		nowpage--;
		var json = {
				"page" : nowpage,
				"contestId" : contestId
		};
		ShowAllSolution(json);
	} else {
		alert("已到第一页");
	}
}
function NextPage(obj) {
	nowpage++;
	var json = {
		"page" : nowpage,
		"contestId" : contestId
	};
	ShowAllSolution(json);
}
