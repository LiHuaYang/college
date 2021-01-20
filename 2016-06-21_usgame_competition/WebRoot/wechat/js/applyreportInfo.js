var applyReportId;
var message;
$(document).ready(function(){
	getapplyReportId();
});

function getapplyReportId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	applyReportId=strRight;
	getData(applyReportId);
}
function applyReportState(a) {
	if(a==0) {
		return "未付款";
	}
	if(a==1) {
		return "已付款";
	}
}
//年级转换
function gradeconversion(a) {
	switch (a)
	 {
	  case 1: 
		  return "一年级";
	  case 2: 
		  return "二年级";
	  case 3: 
		  return "三年级";
	  case 4: 
		  return "四年级";
	  case 5: 
		  return "五年级";
	  case 6: 
		  return "六年级";
	  case 7: 
		  return "七年级";
	  case 8: 
		  return "八年级";
	  case 9: 
		  return "九年级";
	 }
}
function showdialog1 () {
	$("#dialog1").show();
}
function getData(applyReportId) {
	$.post("../UserServlet", {
		method : "applyreportInfo" ,
		applyReportId : applyReportId	
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		var json = data.data;
		message = data.data;
		console.log(json);
			$("#list").append(
					"<div class='weui_panel weui_panel_access'>"+
					"<div class='weui_panel_hd'>"+
					"<h4 class='weui_media_title' id='competition_name'>"+json.competitionName+"</h4>"+
					"</div>"+
					"<div class='weui_media_box weui_media_text '>"+
					"<div class='info_list'>"+
					"<strong>科目 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.competitionSubject+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>参赛者 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.name+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>身份证号:</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.idCard+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>学校 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.school+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>年级 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+gradeconversion(json.grade)+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>竞赛年级 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+gradeconversion(json.competitionGrade)+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>联系人 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.contectName+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>联系号码 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.contectPhone+"</p>"+
					"</div>"+
							"<div class='info_list'>"+
								"<strong>订单状态 :</strong>"+
								"<p class='info_text' id='subject_info_text'>"+applyReportState(json.applyReportState)+"</p>"+
							"</div>"+
						"</div>"+
					"</div>")
					if(json.applyReportState==0) {
						showdialog1();
					}
	});
}

function topay() {
	window.location.href="bmqr.html?name="+encodeURI(encodeURI(message.name))+"&&idCard="+message.idCard+"&&school="+encodeURI(encodeURI(message.school))+"&&" +
	"grade="+message.grade+"&&competitionSubject="+encodeURI(encodeURI(message.competitionSubject))+"&&competitionName="+encodeURI(encodeURI(message.competitionName))+"&&" +
			"competitionGrade="+message.competitionGrade+"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone  + "&out_trade_no=" + message.out_trade_no+"&money="+message.money
}