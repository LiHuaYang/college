var currentPage = 1;//当前页数 
$(document).ready(function(){
  getData();
});


//获取问题列表
function getData() {
	$.post("../ContestActionV2",{"method":"getContestSet", "type":"admin"
	},function(data) {
		var json = JSON.parse(data); 
		showList(json)
	});
}

//题目列表显示
function showList(json) {
		$("#contest").empty();
		$("#contest").append("<tr>"+
				"<th>"+"编号"+"</th>"+
				"<th>"+"标题"+"</th>"+
				"<th>"+"开始日期"+"</th>"+
				"<th>"+"结束日期"+"</th>"+
				"<th>"+"类型"+"</th>"+
				"<th>"+"Status"+"</th>"+
				"<th>"+"编辑"+"</th>"+
				"<th>"+"复制"+"</th>"+
				"<th>"+"到处"+"</th>"+
				"<th>"+"logs"+"</th>"
		)
		for(var i =0; i<json.length;i++) {
			var status;
			var Private;
			if(json[i].Private==1) {
				Private = "Private";
			} else {
				Private = "Public";
			}
			if(json[i].defunct.indexOf("Y")!=-1) {
				status = "Reserved";
			}
			else {
				status = "Available";
			}
			// javascript:
			// <a href="javascript:void(0)" onclick=""></a>
			$("#contest").append("<tr>"+
					"<td id='contest_id'>"+json[i].contest_id+"</td>"+
					"<td><a href='detail.html?problemid="+ json[i].contest_id + "'>"+json[i].title+"</a></td>"+
					"<td>"+json[i].start_time+"</td>"+
					"<td>"+json[i].end_time+"</td>"+
					"<td><a href='javascript:void(0);' onclick='setPrivate("+json[i].contest_id+",this)' href=''>"+Private+"</td>"+
					"<td><a href='javascript:void(0);' onclick='setStatus("+json[i].contest_id+",this)' href=''>"+status+"</td>"+
					"<td><a href='addContest.html?contest_id="+json[i].contest_id+"'>Edit</td>"+
					"<td><a href='addContest.html?contest_id="+json[i].contest_id+"'>Copy</td>"+
					"<td><a href=''>Export</td>"+
					"<td><a href=''>Log</td>"
			)
		}
}

// 公有还是私有
function setPrivate(id, obj) {
	var htm = $(obj).html(); 
	var flag = "0";
	if (htm=="Private") {
		flag = "0"; // 设置为公有
	} else {
		flag = "1"; // 设置为私有
	}
	
	$.post("../ContestActionV2",
			{
				"method":"updateContestState",
				"state" : flag,
				"key" : "p",
				"contest_id" : id,
				"type" : "admin"
			},
			function(data) {
//				 windows.location.href = "Contest_list.html";
//				window.location.reload();
				var json = {
						"page" : currentPage,// 初始化为当前页数
						"method" : "getContestSet",
						"type" : "admin"
					};
				getData();
			});
}


// 是否发布
function setStatus(id, obj) {
	// alert($(obj).html());
	var htm  = $(obj).html();
	var flag = null;
	if (htm=="Reserved") {
		flag = "N"; // 设置为发布 "Y"
	} else {
		flag = "Y";
	}
	$.post("../ContestActionV2",
			{
				"method":"updateContestState",
				"state" : flag,
				"key" : "r",
				"contest_id" : id,
				"type" : "admin"
			},
			function(data) {
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
			"method" : "adminAdd",
			"type" : "admin"
		};
	getData(json);
}
