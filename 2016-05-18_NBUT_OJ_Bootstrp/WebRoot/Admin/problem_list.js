

var currentPage = 1;//当前页数 

$(document).ready(function(){
	var json = {
			"page" : currentPage,// 初始化为当前页数
			"type" : "2"
		};
  getData(json);
});





//获取问题列表
function getData(json) {
	$.post("../ProblemActionV2",{
		"method":"list",
		json : JSON.stringify(json)
	},function(data) {
		var json = JSON.parse(data); 
		showList(json)
	});
}

//题目列表显示
function showList(data) {
	if(data.msg==true) {
		$("#problem").empty();
		$("#problem").append("<tr>"+
				"<th>"+""+"</th>"+
				"<th>"+"编号"+"</th>"+
				"<th>"+"标题"+"</th>"+
				"<th>"+"日期"+"</th>"+
				"<th>"+"状态"+"</th>"+
				"<th>"+"删除"+"</th>"+
				"<th>"+"编辑"+"</th>"+
				"<th>"+"测试数据"+"</th>"
		)
		var json = data.data;
		for(var i =0; i<json.length;i++) {
			var status;
			if(json[i].defunct.indexOf("Y")!=-1) {
				status = "Reserved";
			}
			else {
				status = "Available";
			}
			$("#problem").append("<tr>"+
					"<td><input type='checkbox' id='prockb' value=" + json[i].problem_id + " /></td>"+
					"<td>"+json[i].problem_id+"</td>"+
					"<td><a href='detail.html?problemid="+ json[i].problem_id + "'>"+json[i].title+"</a></td>"+
					"<td>"+json[i].in_date+"</td>"+
					"<td><a onclick='setStatus("+json[i].problem_id+",this)' href='javascript:void(0);'>"+status+"</td>"+
					"<td><a onclick='deleteProblem("+json[i].problem_id+")' href=''>Delete</td>"+
					"<td><a href='addProblem.html?problem_id="+json[i].problem_id+"'>Edit</td>"+
					"<td><a href=''>TestData</td>"
			)
		}
	}
	else {
		alert(data.other);
	}
}

//设置题目的状态
function setStatus(problem_id,thistr) {
	var status;
	if($(thistr).html().indexOf("Available")!=-1) {
		status = "Y";
	}
	else {
		status = "N";
	}
	var json = {
			"problem_id" : problem_id,
			"status" :status
		};
	$.post("../ProblemActionV2",{
		"method" : "setProblemStatus",
		json : JSON.stringify(json)
	},function(data) {
//		var json = JSON.parse(data); 
//		window.location.reload(); // 刷新当前frame
		var json = {
				"page" : currentPage,// 初始化为当前页数
				"type" : "2"
			};
		getData(json);
	});
}

//删除题目
function deleteProblem(problem_id) {
	var json = {
			"problem_id" :problem_id
		};
	$.post("../ProblemActionV2",{
		"method" : "deleteProblem",
		json : JSON.stringify(json)
	},function(data) {
//		var json = JSON.parse(data);
		window.location.reload(); // 刷新当前frame
	});
}


//上一页下一页
function nextPage(obj) {
	if ($(obj).val() == "pre") {
		currentPage--;
	}
	else {
		currentPage++;
	}
	var json = {
			"page" : currentPage,// 初始化为当前页数
			"type" : "2"
		};
	getData(json);
}

/**
 * 
 * 将选中的问题作为竞赛题目创建
 * 
 */
function checkToNewContest() {
	var probIds = $("input[id='prockb']:checked");
	var length = probIds.length;

	var ids = new Array();
	for (var i=0; i<length; i++) {
		ids.push($(probIds[i]).val());
	}
	if (ids.length > 0) {
		window.location.href = "addContest.html?ids=" + ids;
	} else {
		alert("请先选中比赛");
	}
}




