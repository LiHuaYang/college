
// 富文本编辑器
var editor = null;

$(document).ready(function() {
	$("#nsf_CompetitionEnrollStartTime").datepicker();
	$("#nsf_CompetitionEnrollEndTime").datepicker();

	$("#nsf_CompetitionEnrollStartTime").datepicker( {
		changeMonth : true,
		changeYear : true
	});

	$("#nsf_CompetitionEnrollStartTime").datepicker("option", "dateFormat",
			"yy-mm-dd");
	$("#nsf_CompetitionEnrollEndTime").datepicker("option", "dateFormat",
			"yy-mm-dd");

	AppendOrganizaOption();
	showcompetitionName();
	
});

function show(obj) {
	$("#contestPanel").show();
	showproject();
}

function middleClose() {
	$(".bodymiddle").hide();
}

// 暂存项目信息
var array = new Array();


/**
 * 取消或是全选
 * 
 * @param tag
 * @return
 * 
 */
function checkAll(objSpan) {
	var objTbody = objSpan.parentNode.parentNode.parentNode;
	// alert(objTbody);
	var checkBoxlist = $(objTbody).find("input[type='checkbox']");
	// alert(checkBoxlist.length);
	for ( var i = 0; i < checkBoxlist.length; i++) {
		var input = $(checkBoxlist[i]);
		if (input.is(':checked')) { // 判断是否选中
			input.attr("checked", false);
		} else {
			input.attr("checked", true);
		}
	}
}
function checkAll2(objSpan) {
	var objTbody = objSpan.parentNode.parentNode;
	var checkBoxlist = $(objTbody).find("input[type='checkbox']");
	for ( var i = 0; i < checkBoxlist.length; i++) {
		var input = $(checkBoxlist[i]);
		if (input.is(':checked')) { // 判断是否选中
			input.attr("checked", false);
		} else {
			input.attr("checked", true);
		}
	}
}

/**
 * 获取选中的考试信息中选中的年级
 * 
 * @return
 */
function getCheckBoxValue() {
	var CheckBoxArr = new Array();
	var checkBoxList = $(".Frameinput").find("input[type='checkbox']");

	for ( var i = 0; i < checkBoxList.length; i++) {
		var input = $(checkBoxList[i]);
		if (input.is(':checked')) { // 判断是否选中
			CheckBoxArr.push(input.val()); // 加入数组
		}
	}
	return CheckBoxArr;
}

var G_competition = new Object();

var G_contestinfonList = new Array(); // 大赛-所有科目信息
/**
 * 获取大赛简要信息
 * 
 * @return
 */
function getContestSimpleInfo() {
	var competition = new Object();
	// G_competition.sf_CompetitionName = $("#sf_CompetitionName").val(); // 大赛名字
	
	G_competition.sf_CompetitionName = $("#select_competition_name").find("option:selected")
	.text();// 获取选中的大赛名字
	
	alert("大赛名字为：" + G_competition.sf_CompetitionName);
	
	G_competition.sf_CompetitionSession = $("#sf_CompetitionSession").val();// 大赛届数
	G_competition.sf_ContestPropaganda = $("#sf_ContestPropaganda").val();// 大赛描述
	G_competition.sf_Organinaze = $("#sf_Organinaze").val();// 大赛主办单位
	G_competition.sf_ContestexamType = $("#sf_ContestexamType").val();// 大赛的形式

	var sf_CompetitionTime = $("#sf_CompetitionTime").val(); // 大赛时间描述
	G_competition.contestTimeDes = sf_CompetitionTime;

	var sf_Contest_Prize = $("#sf_Contest_Prize").val();// 大赛奖项描述
	G_competition.contestPrizeDes = sf_Contest_Prize;

	var sf_Contest_Price = $("#sf_Contest_Price").val();// 大赛费用描述
	G_competition.contestMoneyDec = sf_Contest_Price;
	
	var sf_Contest_Obj = $("#sf_Contest_Obj").val(); // 大赛对象描述
	G_competition.contestObjDes = sf_Contest_Obj;
	
	var nsf_CompetitionEnrollStartTime = $("#nsf_CompetitionEnrollStartTime").val(); // 报名开始时间
	G_competition.enrollStartTime = nsf_CompetitionEnrollStartTime;
	
	var nsf_CompetitionEnrollEndTime = $("#nsf_CompetitionEnrollEndTime").val(); // 报名结束时间
	G_competition.enrollEndTime = nsf_CompetitionEnrollEndTime;
	
	 var sf_CompetitionIntro = $("#sf_CompetitionIntro").val(); // 大赛简介
	 G_competition.contestIntro = sf_CompetitionIntro;
	
	var sf_Competition_picpath = picPathArr[0];//竞赛图片路径
	G_competition.Competitionpicpath = sf_Competition_picpath;
	
	var sf_Competition_piccontestpath = piccontestArr[0];//contest图片路径
	G_competition.contestpicpath = sf_Competition_piccontestpath;

	// 测试富文本编辑器
	var sf_Competitiondetails = CKEDITOR.instances.sf_Competitiondetails.getData();  //大赛详情
	// console.log("这是富文本编辑器：" + data);
	G_competition.competitiondetails = sf_Competitiondetails;
	
	console.log("大赛描述信息: " + JSON.stringify(G_competition));
}

function putContestInfoToServer() {
	
	 if( picPathArr.length ==0||piccontestArr.length==0||$("#sf_CompetitionSession").val()==""){
		 if($("#sf_CompetitionSession").val()==""){
			 alert("请填写竞赛届数！");
		 }else{
			 alert("请上传图片先！");
		 }
	 }
	 else{
	MakeUpOrgaContestInfo();// 组装竞赛的承办方信息

	getContestSimpleInfo(); // 获取大赛简要信息

	// var json = $.extend({}, G_competition, G_contestinfo); // 合并大赛对象
	// var json1 = $.extend({}, G_competitionList, G_contestinfo); // 合并大赛对象
	G_competition.ContestInfoList = G_contestinfonList; // 
	G_competition.ContestOrgList = G_contestOrgList; // 
	
	
	console.log("发送至服务器的数据(单个大赛+所有科目): " + JSON.stringify(G_competition));

	$.post("./ContestCreateServlet", {
		json : JSON.stringify(G_competition)
	}, function(jsonObject) {
		
		var contact = JSON.parse(jsonObject); 
		 
		if (contact.Check) {
			alert("添加大赛成功！");
		}
		else {
			alert("添加大赛失败，请核对重新添加！");
		}
	});
	 }
}

/**
 * 获取大赛的竞赛详细信息
 * 
 * @return
 */
function getContestSpesificInfo() {

	var G_contestinfo = new Object(); // 大赛-单个科目信息

	var checkBoxList = getCheckBoxValue(); // 获取选中的年级段
	var contestDataBarCount = checkBoxList.length;
	G_contestinfo.ContestObjectList = checkBoxList;
	
	var nsf_ContestSubject = $("#nsf_ContestSubject").find("option:selected")
			.text();// 获取竞赛的科目
	G_contestinfo.ContestSubject = nsf_ContestSubject;
	var nsf_ContestexamType = $("#nsf_ContestexamType").find("option:selected")
			.text();// 获取竞赛考试形式
	G_contestinfo.ContestexamType = nsf_ContestexamType;

	var nsf_CompetitionEnrollStartTime = $("#nsf_CompetitionEnrollStartTime")
			.val();// 获取竞赛的报名开始时间
	// alert(nsf_CompetitionEnrollStartTime);
	G_contestinfo.CompetitionEnrollStartTime = nsf_CompetitionEnrollStartTime;

	var nsf_CompetitionEnrollEndTime = $("#nsf_CompetitionEnrollEndTime").val();// 获取竞赛的报名结束时间
	// alert(nsf_CompetitionEnrollEndTime);
	G_contestinfo.CompetitionEnrollEndTime = nsf_CompetitionEnrollEndTime;
	
	var nsf_SignUpMoney = $("#nsf_SignUpMoney").val();// 获取报名费用
	G_contestinfo.SignUpMoney = nsf_SignUpMoney;
	//alert(nsf_SignUpMoney);

	// { json : JSON.stringify(json) },
	console.log("大赛-单个科目信息: " + JSON.stringify(G_contestinfo));

	G_contestinfonList.push(G_contestinfo); // 添加一个科目信息

	console.log("大赛-所有科目信息: " + JSON.stringify(G_contestinfonList));

	return G_contestinfo;
}

/**
 * 整个大赛对象
 */
var Competition = new Object();
/**
 * 组装数据
 * 
 * @return
 */
function MakeUpContestInfo() {
	var info = getContestSpesificInfo(); // 返回用户输入的信息
	if(info.ContestSubject!="请选择考试科目"&&info.ContestexamType!="请选择考试形式"&&info.SignUpMoney&&info.ContestObjectList){
		Competition = info;
		var flag = AppendAContestDataList(info);// 显示用户输入的数据
		middleClose();
	}
}

/**
 * 增加一条大赛信息数据条目
 * 
 * @return
 */
// 全局变量 记录数据列表的编号
var dataNumber = 1;

function AppendAContestDataList(contestJsonInfo) {
	var flag = true;
	var length = contestJsonInfo.ContestObjectList.length;
	if (length <= 0) {
		flag = false;
	}
	var ContestObjectList = formatContestInfo(contestJsonInfo); // 数据格式转化
	for ( var i = 0; i < length; i++, dataNumber++) {
		$("#subject_info_panel table")
				.append(
						'<tr class="odd"><td style="width:20px;"><input type="checkbox"></td>'
								+ '<td onclick="do_onclick(this)" id="contestSub">'
								+ contestJsonInfo.ContestSubject
								+ '</td>'
								+ '<td onclick="do_onclick(this)" id="contstExamType" >'
								+ contestJsonInfo.ContestexamType
								+ '</td>'
								+ '<td onclick="do_onclick(this)" id="contestObj">'
								+ ContestObjectList[i] + '</td>'
								+ '<td id="dasaibianhao" style="display:none">'
								+ dataNumber + '</td>' + '</tr>');
	}
	$("#subject_info_panel table")
			.append(
					'<tr class="odd"><td style="width:30px; color:blue;cursor: pointer;" onclick="checkAll2(this)">全选</td></tr>');
	return flag;
}

/**
 * 数据格式转换
 * 
 * @param contestJsonInfo
 * @return
 */
function formatContestInfo(contestJsonInfo) {
	var contestObj = contestJsonInfo.ContestObjectList;
	var objList = new Array();
	for ( var i = 0; i < contestObj.length; i++) {
		var obj = contestObj[i];
		switch (obj) {
		case "1":
			objList.push("小学一年级");
			break;
		case "2":
			objList.push("小学二年级");
			break;
		case "3":
			objList.push("小学三年级");
			break;
		case "4":
			objList.push("小学四年级");
			break;
		case "5":
			objList.push("小学五年级");
			break;
		case "6":
			objList.push("小学六年级");
			break;
		case "7":
			objList.push("初中一年级");
			break;
		case "8":
			objList.push("初中二年级");
			break;
		case "9":
			objList.push("初中三年级");
			break;
		case "10":
			objList.push("高中一年级");
			break;
		case "11":
			objList.push("高中二年级");
			break;
		case "12":
			objList.push("高中三年级");
			break;
		}
	}
	return objList;
}

function showOrzPanel() {
	$("#organizePanel").show();
}

/**
 * 
 * @return
 */
function AppendOrginazInfo() {
	var checkBoxList = $("#org_dt").find("tr").find("input[type='checkbox']");// 获取选中的数据列表
	var length = checkBoxList.length;
	var nsf_ComepetitionOrg = $("#nsf_ComepetitionOrg").find("option:selected")
			.text();// 获取大赛承办方信息
	var nsf_ComepetitionOrgVal = $("#nsf_ComepetitionOrg").find(
			"option:selected").val();
	for ( var i = 0; i < length; i++) { // 遍历判断是否选中
		var input = $(checkBoxList[i]);
		if (input.is(':checked')) {
			var tr = input.parent().parent();// 若选中,则append节点
			$td = $("<td></td>").html(nsf_ComepetitionOrg);
			$input = $('<input id="OrgID" style="display:none" type="text"></input>');
			$input.html(nsf_ComepetitionOrgVal);

			tr.append($input);
			tr.append($td);
		}
	}
	$(".bodymiddle").hide();
}

/**
 * 动态添加下拉选择框
 * 
 * @return
 */
function AppendOrganizaOption() {
	$.getJSON("./GetOrganizationInfo", function(jsonArray) {
		var select = $("#nsf_ComepetitionOrg")
		var length = jsonArray.length;
		for (i = 0; i < length; i++) {
			var Object = jsonArray[i];

			var name = Object.organizationName

			var $op = $("<option></option>").html(name);
			
			$op.val(Object.organizationId);
			select.append($op);
		}
	});
}

var G_contestOrgList = new Array();

function MakeUpOrgaContestInfo() {
	// 每个竞赛项目所对应的组织ID数组
	$dt = $("#org_dt");
	$trList = $dt.find("tr");
	var array = new Array();
	// 遍历数据条目
	for ( var i = 1; i < dataNumber; i++) {
		var OrgIdArr = new Array();
		var contestOrg = new Object();
		var $tr = $trList.eq(i);
		// 如果一个竞赛项目包含两个以及多个组织机构的时候
		var OrgArr = $tr.find(":input[id]"); // 选择节点为input的并且具有ID属性的节点
		// 遍历对应的组织ID数组
		// alert("包含的组织机构有：" + OrgArr.length);
		for ( var j = 0; j < OrgArr.length; j++) {
			var id = $(OrgArr[j]).text();
			OrgIdArr.push(id);
		}

		// 找到组织ID
		var OrgID = $tr.find("#OrgID").text();
		// 找到数据条目的ID
		var dataID = $tr.find("#dasaibianhao").text();

		contestOrg.OrgID = OrgIdArr; // 将大赛承办方的ID数组添加到大赛承办对象
		contestOrg.dataID = dataID; // 将大赛项目的标识ID添加到大赛承办对象

		G_contestOrgList.push(contestOrg);

		console.log("竞赛的承办方信息: " + JSON.stringify(G_contestOrgList))
	}
}

// 删除一条大赛记录
function DeleteAContestDataList() {
	var checkBoxList = $("#basic_dt").find("tr").find("input[type='checkbox']");// 获取选中的数据列表
	var CheckBoxList = $("#org_dt").find("tr").find("input[type='checkbox']");// 获取选中的数据列表
	var length = checkBoxList.length;
	for ( var i = 0; i < length; i++) { // 遍历判断是否选中
		var input = $(checkBoxList[i]);
		if (input.is(':checked')) {
			var tr = input.parent().parent().remove();// 若选中,删除科目信息中选中的行
			var Del = $(CheckBoxList[i]);
			var del = Del.parent().parent().remove(); // 删除承办方信息中与科目信息一致的行
		}
	}
}


/**
 * 获取待删除的自己标记的竞赛ID
 */
function getRemoveId(){
	
	var idsArr = new Array();
	var $id = $("#basic_dt #dasaibianhao");
	var $input = $("#basic_dt input")
	//alert("一共添加" + ($id.length)+":"+$input.length+ "个竞赛条目！");
	for (var i=0; i<$id.length; i++) {
		if($input.eq(i).attr('checked'))				
			idsArr.push($id.eq(i).text());	
	}
	//alert(idsArr);
	return idsArr;
}


/**
 * 获取所有的自己标记的竞赛ID
 */
function getAllId() {
	
	var idsArr = new Array();
	
	$Allid = $("#dasaibianhao");
	alert("一共添加" + $Allid.length() + "个竞赛条目！");
	
	var $AllidLength = $Allid.length();
	for (var i=0; i<$AllidLength; i++) {
		idsArr.push($Allid.val());
		alert(idsArr);
	}
	return idsArr;
}


/**
 * 删除已经添加的竞赛数据条目
 * 
 */
function deleteContestsInfo (toBeDeleteIDs, toBeDeleteContestsIds) {
	
	var toBeDeleteIDsLength = toBeDeleteIDs.length();
	
	for (var i=0; i<toBeDeleteIDsLength; i++) {
		var toBeDeleteID = toBeDeleteIDs[i];
		
		var toBeDeleteContestsLength = toBeDeleteContestsIds.length();
		for (var j=0; j<toBeDeleteContestsLength; j++) {
			var deleteId = toBeDeleteContestsIds[j];
			
			if (toBeDeleteID == deleteId ) {
				
				toBeDeleteContestsIds.splice(j,1); 
			}
		}
	}
}




function showcompetitionName() {
	var select = $("#select_competition_name");
	$.getJSON(
			"./GetCompetitionNameServlet",
			function(json) {
				for ( var i = 0; i < json.competitionbasicdata.length; i++) {
					var competition_name = json.competitionbasicdata[i].competitionBasicName;
					var $op = $("<option></option>").html(
							competition_name);
					select.append($op);
				}
			});
}
function showproject() {
	var select = $("#nsf_ContestSubject");
	var del = $(nsf_ContestSubject).children().remove();
	select.append("<option selected='true' disabled='true'>请选择考试科目</option>");
	$.getJSON("./GetCompetitionProjectServlet", function(json) {
		for ( var i = 0; i < json.subjectbasicdata.length; i++) {	
			var competition_project = json.subjectbasicdata[i].subjectName;
			var $op = $("<option></option>").html(competition_project);
			select.append($op);
		}
	});
}

// 保存大赛图片
var  picPathArr = new Array();
// 保存竞赛图片
var  piccontestArr = new Array();
$(function () {
    $("#uploadify").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'UpLoadCompetitionPic',
        //按钮显示的文字
        'buttonText': '上传图片',
        //显示的高度和宽度，默认 height 30；width 120
        //'height': 15,
        //'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
       // 'formData': { json: JSON.stringify(json) },
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': false,
        //设置为true将允许多文件上传
        'multi': false,
         //上传成功后执行
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html('上传完毕');
          //  alert(data);
            var dataObj = eval("("+data+")");
            console.log("大赛的数据库图片：" + dataObj.fileName);
            picPathArr.push(dataObj.fileName);
            }
    });
    
    $("#uploadify1").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'UpLoadCompetitionPic',
        //按钮显示的文字
        'buttonText': '上传图片',
        //显示的高度和宽度，默认 height 30；width 120
        //'height': 15,
        //'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
       // 'formData': { json: JSON.stringify(json) },
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': false,
        //设置为true将允许多文件上传
        'multi': false,
         //上传成功后执行
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html(' 上传完毕');
          //  alert(data);
            var dataObj = eval("("+data+")");
            console.log("大赛的数据库图片：" + dataObj.fileName);
            piccontestArr.push(dataObj.fileName);
            }
    });
});




