var competitionId;
var competitionGrade;
var money;
$(document).ready(function(){
	getCompetitionId();
});

function getCompetitionId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	competitionId=strRight;
	getData(strRight);
}

function getData(competitionId) {
	$.post("../CompetitionServlet", {
		method : "detail",
		type : "1",
		competitionId :competitionId
	}, function(json) {
		var data = JSON.parse(json);
//		console.log(data.data);
		if(data.msg==true) {
			showData(data.data);
		}
		else {
			alert("加载失败！")
		}
		showData(data.data);
	});
}

function showData(json) {
	var form;
	var applyTime;
	switch(json.competitionForm) {
	case 1:
		form = "笔试";
		break;
	case 2:
		form = "听力";
		break;
	case 3:
		form = "笔试，听力";
		break;
	}
	applyTime = json.competitionApplyStartTime+"->"+json.competitionApplyEndTime;
	
	$('#js_competitionName').html(json.competitionName);
	$('#js_competitionName1').html(json.competitionName);
	$('#work_unit').html(json.competitionSupportDesc);
	$('#form').html(form);
	$('#object').html(json.competitionJoinerDes);
	$('#subject').html(json.competitionSubject);
	$('#sign_up_time').html(applyTime);
	$('#text_time').html(json.competitionTestTimeDes);
	$('#sign_up_address').html(json.competitionApplyAddress);
	$('#text_address').html(json.competitionTestAddress);
	$('#describle').html(json.competitionPrizeDes);
	$('#money').html(json.competitionMoney+"元");
	money = json.competitionMoney;
	competitionGrade = json.competitionGrade;
}

function down(obj){
	if($(obj).attr('class')=="info_text1"){
		if($('.info_text').css("-webkit-line-clamp")==3) {
			$(obj).css("-webkit-transform","rotate(315deg)");
			$('.info_text').css("-webkit-line-clamp","10");
		}
		else {
			$(obj).css("-webkit-transform","rotate(135deg)");
			$('.info_text').css("-webkit-line-clamp","3");
		}
	}
	else {
		if($('.info_text2').css("-webkit-line-clamp")==3) {
			$(obj).css("-webkit-transform","rotate(315deg)");
			$('.info_text2').css("-webkit-line-clamp","10");
		}
		else {
			$(obj).css("-webkit-transform","rotate(135deg)");
			$('.info_text2').css("-webkit-line-clamp","3");
		}
	}
}

function toDes() {
	window.location.href="competitionDet.html?competitionId="+competitionId;
}

function qd() {
	// alert("用户点击确定!");
	window.location.href="bm.html?competitionName="+encodeURI(encodeURI($('#js_competitionName').html()))+"&&competitionSubject="+encodeURI(encodeURI($('#subject').html()))+"&&competitionGrade="+encodeURI(encodeURI(competitionGrade))+"&&money="+money;
}




