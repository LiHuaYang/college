$(document).ready(function(){
	getData();
});

//获取比赛列表
function getData() {
	$.post("../CompetitionServlet", {
		method : "list",
		type : "2"
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		var json = data.data;
		showData(json);
	});
}

//列表显示
function showData(json) {
	for(var i =0;i<json.length;i++){
		$("#list").append(
				"<div class='weui_panel weui_panel_access'>"+
				"<div class='weui_panel_hd'>"+
					"<h4 class='weui_media_title'>"+json[i].competitionName+"</h4>"+
				"</div>"+
				"<div class='weui_panel_bd' id='showDialog2'>"+
					"<a href='det.html?competitionId=" + json[i].competitionId + "'>"+
						"<div class='weui_media_box weui_media_text weui_panel_ft'>"+
							"<div class='info_list'>"+
								"<strong>截止 :</strong>"+
								"<p class='info_text' id='subject_info_text'>"+json[i].competitionApplyEndTime+"</p>"+
							"</div>"+
							"<div class='info_list'>"+
								"<strong>对象 :</strong>"+
								"<p class='info_text' id='subject_info_text'>"+json[i].competitionJoinerDes+"</p>"+
							"</div>"+
							"<div class='info_list'>"+
								"<strong>科目 :</strong>"+
								"<p class='info_text' id='subject_info_text'>"+json[i].competitionSubject+"</p>"+
							"</div>"+
						"</div>"+
					"</a>"+
				"</div>"+
			"</div>"
		)}
}