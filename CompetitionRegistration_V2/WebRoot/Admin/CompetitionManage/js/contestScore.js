

$(document).ready(function() {
	// alert("sadadasd");
	addComSelectData();
})
var data;
$.ajaxSettings.async = false; // 关闭Jquery中的异步功能
/**
 * 动态添加op节点
 * @return
 */
function addComSelectData() {
	var select = $("#select_competiiton");
	
	$.getJSON("./GetCompetitionInfo",
	function(json) {
		data = json;
	})
	var length = data.length;
	// alert(length);
	for (i=0; i<length; i++) {
		var $op = $("<option></option>").html(data[i].competitionName);
		select.append($op);
	}
	// 把选中的名字大赛名下面的所有的科目筛选出来.
	addSubSelectData();
}

function addSubSelectData() {
	var val = $("#select_competiiton").find("option:selected").val();
	var json = {
			"type" : 1,
			"page" : 1,
			"contest_name_keywords" : val
		}
	$.getJSON("./ContestSearchInfoServlet", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		var length = jsonObject.length;
		var $select = $("#select_sub");
		// 先把所有的科目全部保存下来
		var subArray = new Array();
	
		for (var j=0; j<length; j++) {
			var val = jsonObject[j].contestSubject;
			// alert(val);
			var $op = $("<option></option>").html(val);
			$select.append($op);
		}
	});
	// 把选中的名字大赛名下面的所有的科目筛选出来.
}

/**
 * type : 1 为名字查询
 * type : 2 为大赛名字 + 科目名称查询
 * @return
 */
function search() {
	var key = $("#contest_name_keyword").val();
	var json = {
		"key" : key,
		"type" : 1
	};
	$.getJSON("./GetStudentScore", {
		json : JSON.stringify(json)
	}, function(json) {
		showData(json);
	})
}


/**
 * 显示数据列表
 * @param jsonObject
 * @return
 */
function showData(jsonObject) {
	var trs = $(".data-table tr");
	var j = 0;
	var ContestObject = null;
	var contestState = null;

	for ( var i = 1; i < trs.length; i++) {
		var $tr = $(trs[i]);
		$tr.children("#contestSubject").html("");
		$tr.children("#studentName").html("");
		$tr.children("#studentTicket").html("");
		$tr.children("#studentscore").html("");
		$tr.children("#competitionName").html("");
	}
	for ( var i = 1; i < trs.length && j < jsonObject.length; i++, j++) {
		var $tr = $(trs[i]);
		$tr.children("#contestSubject").html(jsonObject[i - 1].contestSubject);
		$tr.children("#studentName").html(jsonObject[i - 1].studentName);
		$tr.children("#studentTicket").html(jsonObject[i - 1].studentTicket);
		$tr.children("#studentscore").html(jsonObject[i - 1].studentscore);
		$tr.children("#competitionName").html(jsonObject[i - 1].competitionName);
	}
}

/**
 * 根据大赛名字和比赛科目来查找对应的成绩列表
 * @return
 */
function searchCompetitionNameAndSubject () {
	var competitionName = $("#select_competiiton").find("option:selected").val(); // 选中的大赛名字
	var competitionsubj = $("#select_sub").find("option:selected").val(); // 选中的比赛科目
	alert(competitionName);
	alert(competitionsubj);
	var json = {
		"type" : 2,
		"competitionName" : competitionName,
		"sujectName" : competitionsubj
	}
	$.getJSON("./GetStudentScore", {
		json : JSON.stringify(json)
	}, function(json) {
		showData(json);
	})
}


