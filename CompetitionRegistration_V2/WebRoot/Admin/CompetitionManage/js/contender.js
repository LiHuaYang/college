var addcontenderUrl = "Admin/CompetitionManage/jsp/AddContender.jsp"
$.ajaxSettings.async = false; // 关闭Jquery中的异步功能
function addcontender() {
	window.location.href=addcontenderUrl;
}
$(document).ready(function() {
	
	var json = {
		"type" : 0,
		"page" : paging.currentPage
	// 初始化为当前页数
	};
	var data = getData(json);
	showData(data);
//	binding();
	
	show_all_competition();   //显示所有大赛
	binding();
});

function binding() {
	$("#btn_next_page").bind("click", nextPage);
	$("#btn_pre_page").bind("click", prePage);
}


function getData(json) {
	var data = null;
	$.getJSON("./ContenderList", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		data = jsonObject;
	});
	return data;
}

/**
 * 动态添加op节点
 * @return
 */
function addSelectData() {
	var select = $("#select_sub")
	for (i=0; i<10; i++) {
		// var oOption = document.createElement("option");
		var $op = $("<option></option>").html("ni" + i);
		select.append($op);
		// $("p").append("<b>你好吗？</b>");//向p元素中追加《b》 
		// oOption.innerText=oOption.Value = "sText" + i;
	}
}

//显示所有大赛
function show_all_competition(){
	
	$(".Verificationselect").html(
			'<option selected="true" disabled="true">请选择大赛</option>'
	)
	$.getJSON("./QueryALLCompetitionServlet",function(json){
		
		for(var i=0;i<json.result.length;i++){
			$(".Verificationselect").append(
                    '<option>'+json.result[i].competitionName+'</option>'
			)
		}
	})
}

var name_flag = "";   //大赛选择改变标志
var number = 0;  
//根据相应大赛显示科目
function show_subject(){
	
	var competitionName=$(".Verificationselect").find("option:selected").text();
	
	if(name_flag!=competitionName){
		
		for (var i=0;i<number;i++) {
			$(".Verificationselect_subject").append(
					'<option></option>'
			);
		}
		$.ajax({
			type: "GET",
			url: "./QueryAllSubByCompetitionNameServlet",
			data:{CompetitionName:competitionName},
			dataType: "json",
			success: function(json){
				number=json.result.length;
				$(".Verificationselect_subject").html(
						'<option selected="true" disabled="true">请选择大赛的科目</option>'
				)
				for(var i=0;i<json.result.length;i++){
					$(".Verificationselect_subject").append(
						'<option>'+json.result[i].contestSubject+'</option>'
					)
				}
			}
		});
		name_flag=competitionName;
	}
}


function getStudentInfo () {
	var competitionName =  $("#select_orga").find("option:selected").text();// 获取竞赛名称
	var competitionsubj =  $("#select_sub").find("option:selected").text();// 获取竞赛名称
	$.ajax({
		type: "GET",
		url: "./QueryStuedntByComnaSubServlet",
		data:{
		"CompetitionName":competitionName,
		"ContestSubject": competitionsubj,
		page : 1},
		dataType: "json",
		success:function(json){
			showData(json);
		}
	});
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
		$tr.children("#JoinerName").html("");
		$tr.children("#enrollmentid").html("");
		$tr.children("#CompetitionName").html("");
		$tr.children("#CompetitionSubject").html("");
		$tr.children("#BaoMingZhunagTai").html("");
		$tr.children("#Phone").html("");
		$tr.children("#Score").html("");
	}
	for ( var i = 1; i < trs.length && j < jsonObject.length; i++, j++) {
		var $tr = $(trs[i]);
		$tr.children("#JoinerName").html(jsonObject[i - 1].studentName);
		$tr.children("#enrollmentid").html(jsonObject[i - 1].enrollmentid);
		$tr.children("#CompetitionName").html(jsonObject[i - 1].competitionName);
		$tr.children("#CompetitionSubject").html(jsonObject[i - 1].contestSubject);
		
		
		var state = jsonObject[i - 1].enrollmentState;
		// 报名状态显示
		if (state==1) {
			$tr.children("#BaoMingZhunagTai").html("未付款");
			
		}
		
		else if (state==3) {
			$tr.children("#BaoMingZhunagTai").html("已付款");
		}
		
		$tr.children("#Phone").html(jsonObject[i - 1].studentContactsPhon);
		if(jsonObject[i - 1].studentscore>0){
			$tr.children("#Score").html(jsonObject[i - 1].studentscore);
		}
		else{
			$tr.children("#Score").text("无成绩");
		}
		
//		$("#myId").attr("href","www.xxx.com"); 
		console.log(jsonObject[i - 1].url);
		$tr.find("#enroDetail").attr("href",jsonObject[i - 1].url); 
		// 附上报名详情超链接
	}
}

function search() {
	var key = $("#student_name_keyword").val();
	
	var json = {
		"type" : 1,
		"key" : key
	};
	console.log(json);
	
	$.getJSON("./GetJoinerInfo", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
		showData(jsonObject);
	})
}

function entering(){
	var judge=0;
	var table = $(".data-table");
	var tr = $(table).find("tr");
	var score = $("#inputscore").val();
	for(var i=0;i<11;i++){
		if(tr.eq(i).css('background-color')!=tr.eq(0).css('background-color')){
			judge=1;
			break;
		}
	}
	if(judge==1){
		$("#organizePanel").show();
	}
	else{
		alert("请先选择对象");
	}	
}

function okenter() {
	var table = $(".data-table");
	var tr = $(table).find("tr");
	var id = null;
	var score=$("#inputscore").val();
	for(var i=0; i<11; i++){
		if(tr.eq(i).css('background-color')!=tr.eq(0).css('background-color')){
			id = tr.eq(i).children('td').eq(1).text();
			break;
		}
	}
	var json = {
			"id" : id,
			"score" : score
		// 初始化为当前页数
		};
	var data = null;
	$.getJSON("./EnterScore", {
		json : JSON.stringify(json)
	}, function(jsonObject) {
	});
	window.location.reload();
}

function middleClose(){
	$("#organizePanel").hide();
}
function exportcontender() {
	alert("此功能待开发");
}
function inportcontender() {
	alert("此功能待开发");
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
	showData(res);
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



function addscore(obj) {
	 alert("尚未开发");
	
	alert($(obj).val());
	var json = {
			"CompetitionName" : $("#select_orga").val(),
			"ContestSubject" : $("#select_sub").val(),
			"Path" : $(obj).val()
	};
	$.getJSON("./InportScore", {
		json : JSON.stringify(json)
	}, function() {
	});
//	   alert(strFileName);
//	
//	
//	alert($(obj).val());
//	var json = {
//			"CompetitionName" : $("#select_orga").val(),
//			"ContestSubject" : $("#select_sub").val(),
//			"Path" : $(obj).val()
//	};
//	$.getJSON("./InportScore", {
//		json : JSON.stringify(json)
//	}, function() {
//	});
	
}


$(function () {
	$("#upExcel").uploadify({
	    //指定swf文件
	    'swf': 'Common/Tool/uploadify/uploadify.swf',
	    //后台处理的页面
	    'uploader': 'UpLoadExcel',
	    //按钮显示的文字
	    'buttonText': '上传Excel,导入学生成绩，注意格式，Excel为97-03版本',
	    //显示的高度和宽度，默认 height 30；width 120
	    'height': 30,
	    'width': 400,
	    //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
	    //在浏览窗口底部的文件类型下拉菜单中显示的文本
	    'fileTypeDesc': 'Image Files',
	    //允许上传的文件后缀
	    'fileTypeExts': '*.xls',
	    //发送给后台的其他参数通过formData指定
	   // 'formData': { json: JSON.stringify(json) },
	    //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
	    //'queueID': 'fileQueue',
	    //选择文件后自动上传
	    'auto': true,
	    //设置为true将允许多文件上传
	    'multi': false,
	     //上传成功后执行
	    'onUploadSuccess': function (file, data, response) {
	        $('#' + file.id).find('.data').html(' 上传完毕');
	      //  alert(data);
	        var dataObj = eval("("+data+")");
	        console.log("上传的Excel的路径和文件名：" + dataObj.fileNameAndPath);
//	       piccontestArr.push(dataObj.fileName);
	}
	});
})

                    





