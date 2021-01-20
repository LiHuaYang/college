var currentPage = 1;//当前页号

/**
 *  获取数据列表
 *  @return
 */
function getData(json) {
	// ProblemActionServlet
	// ProblemActionV2
	$.post("../../ProblemActionV2",{
		"json": JSON.stringify(json),
		 "method":"list"
	}, function(data) {
		var json = JSON.parse(data).data; 
		if(json.length>0) {
			$("#problem").empty();
			$("#problem").append("<tr>"+
					"<th>"+"编号"+"</th>"+
					"<th>"+"标题"+"</th>"+
					"<th>"+"正确"+"</th>"+
					"<th>"+"提交"+"</th>"+
					"<th>"+"来源"+"</th>"
					)
			for(var i =0; i<json.length;i++) {
				$("#problem").append("<tr>"+
					"<td><a href='detail.html?problemid=" + json[i].problem_id + "'>"+json[i].problem_id+"</a></td>"+
					"<td><a href='detail.html?problemid="+ json[i].problem_id + "'>"+json[i].title+"</a></td>"+
					"<td><a href='solution.html?problemid="+ json[i].problem_id + "&type=1'>"+json[i].accepted+"</td>"+
					"<td><a href='solution.html?problemid="+ json[i].problem_id + "&type=2'>"+json[i].submit+"</td>"+
					"<td>"+json[i].source+"</td>"
				)
			}
		}
		else {
			alert("无更多的问题！");
		}
	});
}

$(document).ready(function() {
	var json = {
			"page" : currentPage,
			"type" : "1"
		};
	getData(json);
})

function toDetail(obj) {
	var id = $(obj).find('span').html();
	alert(id);
	window.location.href = "detail.html?problemid="+id;
//	windows.location.href = detailPath + "?problemid=" + id;
}

function nextPage(obj) {
	if ($(obj).val() == "pre") {
		currentPage--;
	}
	else {
		currentPage++;
	}
	var json = {
			"page" : currentPage,// 初始化为当前页数
			"type" : "1"
		};
	getData(json);
}




