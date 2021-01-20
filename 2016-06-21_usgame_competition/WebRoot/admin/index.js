var competitionId=0;
$("a").click(function() {
	var title = $(this).text();
	
	title = $.trim(title);
	
	if ("赛事列表" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "competitionList.html"
			});
		}
	} 
	if ("增加赛事" == title) {
		var flag = $("#tabsID").tabs("exists", title);
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "addCompetition.html"
			});
		competitionId=0;
	}
	
	if ("订单列表" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "orderList.html"
			});
		}
	}
	
});

function getSelect() {
	var temp = ($('#competition').datagrid('getSelections'));
	if(temp=="") {
		alert("请先选中数据！");
	}
	return temp[0].competitionId;
}
//function deleteCompetition(competitionId) {
//	$.post("../CompetitionServlet", {
//		method : "delete",
//		competitionId : competitionId
//	}, function(json) {
//		console.log(json);
//	});
//}
function toadd() {
	var flag = $("#tabsID").tabs("exists", "增加赛事");
	if (!flag) {
		$("#tabsID").tabs("add", {
			"title" : "增加赛事",
			"closable" : true,
			"href" : "addCompetition.html"
		});
	}
	competitionId = getSelect();
}

