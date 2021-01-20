
var addcompetitionUrl = "Admin/CompetitionManage/jsp/AddCompetitionList.jsp";
var competitionDetaiUrl = "Admin/CompetitionManage/jsp/ContestDetail.jsp";


function addcompetition() {
	window.location.href = addcompetitionUrl;
}


function jump() {
	window.location.href = competitionDetaiUrl;
}

$.ajaxSettings.async = false; // 关闭Jquery中的异步功能

$(document).ready(function() {
	var json = {
		"type" : 0,
		"page" : paging.currentPage
	// 初始化为当前页数
	};
	var data = getData(json);
	showData(data);
	binding();
})

function binding() {
	$("#btn_next_page").bind("click", nextPage);
	$("#btn_pre_page").bind("click", prePage);
}
/**
 * 获取数据列表
 * @param json
 * @return
 */
function getData(json) {
	var data = null;
	$.getJSON("./ContestSearchInfoServlet", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		data = jsonObject;
	});
	return data;
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
		$tr.children("#contest_id").html("");
		$tr.children("#contest_name").html("");
		$tr.children("#contest_start_time").html("");
		$tr.children("#contest_end_time").html("");
		$tr.children("#contest_Subject").html("");
		$tr.children("#contest_player").html("");
		$tr.children("#contest_test_type").html("");
		$tr.children("#contest_publish_state").html("");
	}
	for ( var i = 1; i < trs.length && j < jsonObject.length; i++, j++) {
		var $tr = $(trs[i]);
		// alert(jsonObject[0].contestName);
		$tr.children("#contest_id").html(jsonObject[i - 1].contestId);
		$tr.children("#contest_name").html(jsonObject[i - 1].competitionName);
		$tr.children("#contest_start_time").html(jsonObject[i - 1].competitionEnrollStartTime);
		$tr.children("#contest_end_time").html(jsonObject[i - 1].competitionEnrollEndTime);
		$tr.children("#contest_Subject").html(jsonObject[i - 1].contestSubject);
		// alert(jsonObject[i-1].contestObject);
		switch (jsonObject[i - 1].contestObject) {
		case 1:
			ContestObject = "小学一年级";
			break;
		case 2:
			ContestObject = "小学二年级";
			break;
		case 3:
			ContestObject = "小学三年级";
			break;
		case 4:
			ContestObject = "小学四年级";
			break;
		case 5:
			ContestObject = "小学五年级";
			break;
		case 6:
			ContestObject = "小学六年级";
			break;
		case 7:
			ContestObject = "初中一年级";
			break;
		case 8:
			ContestObject = "初中二年级";
			break;
		case 9:
			ContestObject = "初中三年级";
			break;
		case 10:
			ContestObject = "高中一年纪";
			break;
		case 11:
			ContestObject = "高中二年级";
			break;
		case 12:
			ContestObject = "高中三年级";
			break;
		}
		$tr.children("#contest_player").html(ContestObject);
		$tr.children("#contest_test_type").html(
				jsonObject[i - 1].contestexamType);

		if (jsonObject[i - 1].competitionState == 0) {
			competitionState = "未发布"
		} 
		else if (jsonObject[i - 1].competitionState == 1) {
			competitionState = "即将开始报名"
		}
		else if (jsonObject[i - 1].competitionState == -1) {
			competitionState = "已删除"
		}
		else if (jsonObject[i - 1].competitionState == 2) {
			competitionState = "正在报名"
		}
		else if (jsonObject[i - 1].competitionState == 3) {
			competitionState = "比赛进行中"
		}
		else if (jsonObject[i - 1].competitionState == 4) {
			competitionState = "已结束"
		}
		else if (jsonObject[i - 1].competitionState == 5) {
			competitionState = "置顶（正在报名）"
		}
		$tr.children("#contest_publish_state").html(competitionState);
	}
}

//大赛成绩页面下拉框
function down() {
	var temp = $("#down_company").val();
	var positiontop = $('#down-competition').offset().top;
	var positionleft = $('#down-competition').offset().left;
	var height = $('#down-competition').height();
	var width = $('#down-competition').width();
	$(".pos").css("position", "absolute");
	$(".pos").css("top", positiontop + height + 4);
	$(".pos").css("left", positionleft);
	$(".pos").css("width", width + 12);
	switch (temp) {
	case "1":
		$("#down-competition").val("数学");
		break;
	case "2":
		$("#down-competition").val("语文");
		break;
	case "3":
		$("#down-competition").val("物理");
		break;
	case "4":
		$("#down-competition").val("政治");
		break;
	}
}
function down2(tab) {
	var subject = [ "数学", "英语", "语文", "物理", "化学", "地理", "政治", "政治", "政治" ];
	$(".down2_ul").empty();
	if ($("#down-competition").val()) {
		$(".pos").show();
		for ( var i = 0; i < subject.length; i++) {
			$(".down2_ul").append(
					'<li onclick="loadtext(this)">' + subject[i] + '</li>');
		}
	}
}

function loadtext(tab) {
	var temp = document.getElementById("down-competition");
	temp.value = tab.innerText;
	$(".pos").hide();
}


/**
 * 下一页
 * @return
 */
function nextPage() {
	paging.currentPage++;
	type = 0;

	$("#current_page").val(paging.currentPage);

	var json = {
		"page" : paging.currentPage,
		"type" : type
	};
	var res = getData(json);
	if(res.length!=0){
		showData(res);
	}
}

/**
 * 上一页
 * @return
 */
function prePage() {
	// 判断当前页数是否符合标准
	if (paging.currentPage < 2) {
		return ;
	}
	// 将当前页数减1,
	paging.currentPage--;
	// 搜索的类型
	type = 0;
	// 其他操作
	$("#current_page").val(paging.currentPage);
	// 将数据打包成为JSON格式
	var json = {
		"page" : paging.currentPage,
		"type" : type
	};
	// 发送请求,并接受服务器返回的数据
	var res = getData(json);
	// 显示服务器返回的数据
	showData(res);
}

/**
 * 0 是大赛初始化列表
 * 1 是大赛查找 具体的信息放在其他的地方，servlet可以选择不读取
 * @return
 */
function Search() {
	var keyword = $("#contest_name_keyword").val();
	var json = {
		"type" : 1,
		"contest_name_keywords" : keyword,
		"page" : 1
	};

	$.getJSON("./ContestSearchInfoServlet", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		showData(jsonObject);
	});
}


/*******

分页器
	1. 分页器的功能
		1.1 上一页
		1.2 下一页
		
	2. 分页器的属性
		1.1 当前页
		1.2 下一页
		1.3 上一页
		
*******/


//批量删除功能
function deletemost(judge){
	var array = new Array;
	var table=$(".data-table");
	var checkBoxlist = $(table).find("input[type='checkbox']");
	if(judge){
		var id=$(judge).parent().parent().find("#contest_id").text();
		array.push(id);
	}
	else{
		for (var i=0; i<checkBoxlist.length; i++) {
			var input = $(checkBoxlist[i]);
			if(input.is(':checked')) {	// 判断是否选中
				var id=input.parent().parent().find("#contest_id").text();
				array.push(id);
			}
	 	}
	}

	var obj = new Object();
	obj.json = array;
	
	var jj = JSON.stringify(obj);
	
	console.log(jj);
	if(jj.length!=11){
//	var json = {
//			"username" : $("#username").val(),
//			"password" :a
//		// 初始化为当前页数
//		};
//	var data=0;
	$.getJSON("./AdminDelete", {
		"json" : jj
	}, function(jsonObject) {
//		data = jsonObject;
//		if(data==1){
//			window.location.href="Admin/CompetitionManage/jsp/ContestList.jsp";
//		}
//		else {
//			alert("您的账号密码有误");
//		}
	});
	}
	else {
		alert("请先选择一个对象");
	}
	window.location.reload();
}

// 为竞赛项目导入试卷
isinput = false;
CompetitionId = 0;
CompetitionName = "";
CompetitionSubject = "";
CompetitionObject = "";

function importTest() {
	
    if (isinput){
    	window.location.href = "Admin/CompetitionManage/jsp/AddCompetitionTest.jsp?CompetitionId="+
    	CompetitionId + "&CompetitionName=" + encodeURI(encodeURI(CompetitionName)) + "&CompetitionSubject=" + encodeURI(encodeURI(CompetitionSubject)) +
    	"&CompetitionObject=" +encodeURI(encodeURI(CompetitionObject));
    }
    else{
    	alert("请选中你要导入试卷的赛事！！！");
    }
}
function choose(obj){
	var input=$(obj).children().children();
	
	if ($(input).attr('checked')){
		//alert("选中");
		isinput=$(input).attr('checked');
		CompetitionId = $(obj).children().eq(1).text();
		CompetitionName = $(obj).children().eq(2).text();
		CompetitionSubject = $(obj).children().eq(5).text();
		CompetitionObject = $(obj).children().eq(6).text();
		
		// alert(CompetitionName);
	}
	else{
		//alert("没选中");
		isinput=$(input).attr('checked');
	}
}

//弹出框
function entering(){
//	var array = new Array;
//	var table=$(".data-table");
//	var checkBoxlist = $(table).find("input[type='checkbox']");
//	for (var i=0; i<checkBoxlist.length; i++) {
//		var input = $(checkBoxlist[i]);
//		if(input.is(':checked')) {	// 判断是否选中
//			var id=input.parent().parent().find("#contest_id").text();
//			array.push(id);
//		}
// 	}
//	if(array.length>0){
//		$("#organizePanel").show();
//	}
////	if (array.length > 1) {
////		alert("一次只能更改一个大赛状态！");
////	}
//	if (array.length < 1) {
//		alert("请先选中，再更改状态！");
//	}
	
//	return array;
	 if (isinput){
		 $("#organizePanel").show();
		 //CompetitionName=;
	 }
	 else{
		 alert("请先选中，再更改状态！");
	 }
}

/**
 * 
 * 功能: 更改大赛状态
 * 
 * 步骤：
 * 	1. 获取选中的大赛名
 * 	2. 获取需要更改的状态
 * 	3. 提交至服务器
 */

// 
function ChangeCompetitionState (competiion_id_state_json) {
	
}

// 
// function () {}


function okenter() {
	//var array = new Array;
	//var statearray = new Array;
	//var table=$(".data-table");
	//var checkBoxlist = $(table).find("input[type='checkbox']");
	// 0:未发布 1：即将开始报名 2:正在报名 3：比赛进行中 4：已结束 -1：删除 5:头条
	var state = "0";
	switch ($(".conteststate").val()){
	case "未发布":
		state = "0";
		break;
	case "即将开始报名":
		state = "1";
		break;
	case "正在报名":
		state = "2";
		break;
	case "比赛进行中":
		state = "3";
		break;
	case "已结束":
		state = "4";
		break;
	case "大赛删除":
		state = "-1";
		break;
	case "置顶" :
		state = "5";
		break;
	}
//	for (var i=0; i<checkBoxlist.length; i++) {
//		var input = $(checkBoxlist[i]);
//		if(input.is(':checked')) {	// 判断是否选中
//			var id=input.parent().parent().find("#contest_id").text();
//			array.push(id);
//			statearray.push(state);
//		}
// 	}
//	var obj = new Object();
//	var obj1 = new Object();
//	obj1.json = statearray;
//	obj.json = array;
//	
//	var jj = JSON.stringify(obj);
//	var ss = JSON.stringify(obj1);
//	console.log(jj);
//	console.log(ss);
	var data = {
			"CompetitionName":CompetitionName,
			"State":state
	};
	//alert(data.CompetitionName+data.State);
		$.getJSON("./Publish", {
			"json" :JSON.stringify(data),
		}, function(json) {
			if(json.flag){
				alert("修改状态成功！！！");
				window.location.reload();
			}
			else{
				alert("修改状态失败！！！");
				}
		});
		
	
}

function middleClose(){
	$("#organizePanel").hide();
}


function openCheckGrade(){
	if (isinput){
		 $("#checkPanel").show();
		 //CompetitionName=;
	 }
	 else{
		 alert("请先选中，再开放成绩！");
	 }
}

function clearCheckGrade(){
	if (isinput){
		 $("#checkPanel1").show();
		 //CompetitionName=;
	 }
	 else{
		 alert("请先选中，再开放成绩！");
	 }
}

function closeCheckPanel(){
	$("#checkPanel").hide();
}

function closeCheckPanel1(){
	$("#checkPanel1").hide();
}

function okCheck(){
	var data = {
			"CompetitionName":CompetitionName
	};
	$.getJSON("./OpenCheckScore", {
		"data" :JSON.stringify(data),
	}, function(json) {
		if(json.result){
			alert("开放成绩成功");
		}
		else{
			alert("开放成绩失败,请确定此比赛的成绩已导入");
		}
		$("#checkPanel").hide();
	});
}

function okCheck1(){
	var data = {
			"CompetitionName":CompetitionName
	};
	//alert(data.CompetitionName+data.State);
	$.getJSON("./ClearScoreCache", {
		"data" :JSON.stringify(data),
	}, function(json) {
		if(json.result){
			alert("清除缓存成功");
		}
		else{
			alert("清除缓存失败");
		}
		$("#checkPanel1").hide();
	});
}




























































