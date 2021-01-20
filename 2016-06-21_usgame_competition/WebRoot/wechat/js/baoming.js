$(document).ready(function(){
	getInfo();
});

function applyReportState(a) {
	if(a==0) {
		return "未付款";
	}
	if(a==1) {
		return "已付款";
	}
}
function getInfo() {
	$.post("../UserServlet", {
		method : "getUserCompetition"
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		var json = data.data;
		console.log(json);
		if(json.length>=1) {
			for(var i=0;i<json.length;i++) {
				$("#list").append(
						"<div class='weui_panel weui_panel_access' onclick='getmoreInfo("+json[i].applyReportId+")'>"+
						"<div class='weui_panel_hd'>"+
							"<h4 class='weui_media_title' id='competition_name'>"+json[i].competitionName+"</h4>"+
						"</div>"+
							"<div class='weui_media_box weui_media_text weui_panel_ft'>"+
								"<div class='info_list'>"+
									"<strong>科目 :</strong>"+
									"<p class='info_text' id='subject_info_text'>"+json[i].competitionSubject+"</p>"+
								"</div>"+
								"<div class='info_list'>"+
									"<strong>参赛者 :</strong>"+
									"<p class='info_text' id='subject_info_text'>"+json[i].name+"</p>"+
								"</div>"+
								"<div class='info_list'>"+
									"<strong>订单状态 :</strong>"+
									"<p class='info_text' id='subject_info_text'>"+applyReportState(json[i].applyReportState)+"</p>"+
								"</div>"+
							"</div>"+
						"</div>"
				)}	
		}
		else {
			showdialog1();
		}
		
		
	});
}

function showdialog1() {
	$("#dialog1").show();
}
function tobaoming() {
	window.location.href = "login.html";
}
function qx() {
	$("#dialog1").hide();
}

function getmoreInfo(a) {
	window.location.href="applyreportInfo.html?applyReportId="+a;
}