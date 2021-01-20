




//显示科目
//function showSubject() {
//	$.ajax({
//		type: "GET",
//		url: "./GetContestSubjectServlet",
//		data: {CompetitionId:competitionId},
//		dataType: "json",
//		success: function(json){
//			Subject_NumBer=json.result.length;
//			$(".CompetitioninfoType").append(
//                '<th class="CominfoType">科目：</th>'+
//                '<th>'+
//		               '<select class="CominfoTypetext" id="CominfoTypetext" onchange="showGrade();">'+  
//		               '<option disabled="true">请选择</option>'+
//		               '</select>'+
//	               '</th>'
//			);
//			//循环option
//			for(var i=0;i<json.result.length;i++){
//				$("<option>"+json.result[i].contestSubject+"</option>").appendTo("#CominfoTypetext")
//			}
//		}
//	});
//}

// 判断科目有没有被选
function Subject_before(){
	
	var ContestSubject=$(".CominfoTypetext").val();
	if(ContestSubject==null){    // 科目未被选中
	
		document.getElementById('CominfoTypetext').size = Subject_NumBer+1;    // 科目下拉框展开
		document.getElementById('CominfoRanktext').size = 1;             // 年级下拉框关闭
	}
}

// 判断科目和年级有没有被选中
function Sub_Obj_Before(){
// qetext').size = Subject_NumBer+1; //科目下拉框展开
// document.getElementById('CominfoMechanismtext').size = 1; //报名机构下拉框关闭
// }
// if(Object_Rank=="选择参赛年级"){ //科目选中，年级没有被选中
// document.getElementById('CominfoRanktext').size = Object_Number+1; //年级下拉框展ss开
// document.getElementById('CominfoMechanismtext').size = 1; //报名机构下拉框关闭
// }
}





function isSecondEnrollment(info) {
// info.StudentIDNumber = StudentIDNumber;
// info.CompetitionName = CompetitionName;
// info.ContestObject = ContestObject;
// info.ContestSubject = ContestSubject;
// info.OrganizationName = OrganizationName;
}



// 让用户信息变为空
function AddOtherInfo() {
	document.getElementById('ParinfoNametext').value="";// 用户姓名
	document.getElementById('ParinfoSextext').value="";// 用户性别
	document.getElementById('ParinfoIDNumbertext').value="";// 用户身份证号码
	document.getElementById('ParinfoSchooltext').value="";// 学校名称
	document.getElementById('ParinfoGreadtext').value="";// 学校名称
	document.getElementById('ParinfoAdresstext').value="";// 通讯地址
	document.getElementById('GuainfoNametext').value="";// 监护人
	document.getElementById('GuainfoPhonetext').value="";// 监护人电话
	document.getElementById('GuainfoTeachertext').value="";// 指导老师
	document.getElementById('GuainfoTeacherPhonetext').value="";// 指导老师电话
}

// 判断是否可以报名
function Judge_Enroll(){
	
	var StudentIDNumber = $(".ParinfoIDNumbertext").val() ; // 学生的身份证号
	var ContestObject = $("#CominfoRanktext").find("option:selected").text(); // 参赛年级
	var ContestSubject = $("#CominfoTypetext").find("option:selected").text(); // 科目
	
	$.ajax({
		type: "GET",
		url: "./JudgeEnrollOrNotServlet",
		data: { "UserIdNumber":StudentIDNumber,
				"CompetitionName":Info.CompetitionName,
				"ContestSubject":ContestSubject,
				"ContestObject":ContestObject,
		},
		dataType: "json",
		success: function(json){
			if(json.result == true){   // 可以报名
				saveEnrollmentInfo();
			}
			else{
				alert("已报过名，无须重复报名");
			}
		}
	});
}


/***************************************************************************************************** */
// 全局变量
/***************************************************************************************************** */
var ContestSetObj = new Object();

var Subject_NumBer=0;   // 科目数

var Info = new Object();

var Enroll_StartTime="";

var Enroll_EndTime="";

var Contest_Money=0;

var Get_ContestId=0;    // ConTestId

var Object_Number=0;  // 年级数

/***************************************************************************************************** */
// 页面加载
/***************************************************************************************************** */
$(document).ready(function(){
	Info.CompetitionName = decodeURI(getUrlParam('CompetitionName'));
	
	// 获取竞赛组信息
	Info.ContestSet = decodeURI(getUrlParam("jcontestSet"));
	ContestSetObj   = JSON.parse(decodeURI(Info.ContestSet));
	
	 var length = ContestSetObj.length;
		
	 for (var r=0; r<length; r++) {
			
		 console.log(decodeURI(ContestSetObj[r].contestSubject));
	 }
	window.document.title = Info.CompetitionName + '  报名'; 
	
	document.getElementById('Com_Name').innerHTML = Info.CompetitionName;// 大赛名称
	
// showSubject();//显示科目
	bindClick();
	
	showSubjects(getSubjects(ContestSetObj));
	
	
});


/***************************************************************************************************** */
// 数据获取
/***************************************************************************************************** */
// 根据大赛,科目，参赛年级获得ContestId
function GetContestId(){
	
	document.getElementById('CominfoRanktext').size = 1;   // 年级下拉框收起
	var ContestSubject=$(".CominfoTypetext").val();
	var ContestObject=$(".CominfoRanktext").val();
	if(ContestSubject!=null && ContestObject!=null){
		$.ajax({
			type: "GET",
			url: "./QueryContestIdServlet",
			data: {CompetitionId:competitionId,ContestSubject:ContestSubject,ContestObject:ContestObject},
			dataType: "json",
			success: function(json){
				Get_ContestId=new Number(json.result);
//				ShowEnrollmentScore(); // 显示报名费
//				ShowOrgnization();    // 显示机构
			}
		});
	}
}



/***************************************************************************************************** */
// 数据显示
/***************************************************************************************************** */
// 显示用户信息
function AddUserInfo() {
	$.ajax({
		type: "GET",
		url: "./UserInfobyIdServlet",
		data: {UserId:userid},
		dataType: "json",
		success: function(json){
			document.getElementById('ParinfoNametext').value=json.result.userName;// 用户姓名
			document.getElementById('ParinfoSextext').value=json.result.userSex;// 用户性别
			document.getElementById('ParinfoIDNumbertext').value=json.result.userIDNumber;// 用户身份证号码
			document.getElementById('ParinfoSchooltext').value=json.result.userSchool;// 学校名称
			document.getElementById('ParinfoGreadtext').value=json.result.userGrade;// 学校名称
			document.getElementById('ParinfoAdresstext').value=json.result.userAddress;// 通讯地址
			document.getElementById('GuainfoNametext').value=json.result.userContactsMan;// 监护人
			document.getElementById('GuainfoPhonetext').value=json.result.userContactsPhon;// 监护人电话
			document.getElementById('GuainfoTeachertext').value=json.result.userTeacher;// 指导老师
			document.getElementById('GuainfoTeacherPhonetext').value=json.result.userTeacherPhon;// 指导老师电话
		}
	});
}

// 显示报名费
//function ShowEnrollmentScore() {
//	$("#CominfoPricetext ").empty(); 
//	
//	$.ajax({
//		type: "GET",
//		url: "./GetContestMoneybyId",
//		data: {contestId:Get_ContestId},
//		dataType: "json",
//		success: function(json){
//			Enroll_StartTime=new String(json.result[0].startTime);
//			Enroll_EndTime=new String(json.result[0].endTime);
//			Contest_Money = new Number(json.result[0].contestMoney);
//			document.getElementById("CominfoPricetext").innerHTML=json.result[0].contestMoney;
//		}
//	});
//}

/**
 * 显示竞赛组科目下拉框
 */
function showSubjects (subjectArr) {

	// getObjects(selectContestBySubject(' + ContestSetObj + '))
//	$(".CompetitioninfoType").append(
//		  '<th class="CominfoType">科目：</th>'+
//		  '<th>'+
//         '<select class="CominfoTypetext" id="CominfoTypetext" onchange="showObjects()">'+ 
//         '<option disabled="true">请选择</option>'+
//         '</select>'+
//     '</th>'
//	);
	
	var length2 = subjectArr.length;
	
	for(var i=0; i<length2; i++){
		
		$("<option>"+subjectArr[i]+"</option>").appendTo("#CominfoTypetext")
	}
}

/**
 * 显示用户所选的科目所对应的年纪信息
 * 
 * @return
 */
function showObjects () {
	
	var objectArr = getObjects(selectContestBySubject(ContestSetObj));
	
	var length = objectArr.length;
	// $("<option>选择参赛年级 </option>").appendTo("#CominfoRanktext");
	
	for (var i=0; i<length; i++) {
		$("<option>"+objectArr[i]+"</option>").appendTo("#CominfoRanktext")
	}
}

/**
 * 
 * 显示年级段所对应的承办机构信息和报名费用
 * 
 * @param contestObj
 * @return
 */
function showOrgAndMoney () {
	
	var Obj = selectContestByGrade(ContestSetObj);
	
	showOrgnization(Obj.organizerSet);
	
	showEnrollmentMoney(Obj.contestMoney);
	
}
//显示机构
function showOrgnization(organizationObj) {
	
	$("#CominfoMechanismtext ").empty(); 
//	$.ajax({
//		type: "GET",
//		url: "./GetOrganizationServelet",
//		data: {contestId:Get_ContestId},
//		dataType: "json",
//		success: function(json){	
//			$(".CompetitioninfoMechanism").append(
//					
//			);
//			// 循环option
//			for(var i=0;i<json.result.length;i++){
//				$("<option value='"+json.result[i].organizationId+"'>"+json.result[i].organizationName+"</option>").appendTo("#CominfoMechanismtext")
//			}
//		}
//	});
//	var length = organizationObj.length;
	
//	for(var i=0; i<length; i++){
		$("<option value='"+organizationObj[0].organizerId+"'>"+organizationObj[0].organizationName+"</option>").appendTo("#CominfoMechanismtext")
//	}
}

/**
 * 显示报名费用
 * @param money
 * @return
 */
function showEnrollmentMoney(money) {
	$("#CominfoPricetext").html(money);
}

//var Grade_tag=0; //年级只刷新一次
//显示年级
//function showGrade(){
//
//	document.getElementById('CominfoTypetext').size = 1;   // 科目下拉框收起
//	var ContestSubject = $(".CominfoTypetext").val();
//	$("#CominfoRanktext ").empty(); 
//	$("#CominfoPricetext").val("");
//	$("#CominfoMechanismtext ").empty(); 
//	
//	
//	$.ajax({
//		type: "GET",
//		url: "./GetContestObjectServlet",
//		data: {CompetitionId:competitionId,ContestSubject:ContestSubject},
//		dataType: "json",
//		success: function(json){	
//			Object_Number=json.result.length;
//			// 循环option
//			for(var i=0;i<json.result.length;i++){
//				$("<option>"+json.result[i]+"</option>").appendTo("#CominfoRanktext")
//			}
//		}
//	});
//}



/***************************************************************************************************** */
// 数据处理
/***************************************************************************************************** */
/**
 * 
 * 获取url中的参数
 * 
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);   // 匹配目标参数
	if (r != null) return unescape(r[2]); 
	return null;  // 返回参数值
}


/**
 * 报名之前的准备工作 1. 验证学生输入的身份信息 1.1 身份证号码 1.2 电话号码 2. 验证该学生是否是二次报名 1.1
 * 匹配身份证、大赛名、科目名、参赛年纪、报名机构名字
 * 
 */

// 判断字符串是否为纯数字
function isnumeric(str, length)
{
	// var patrn=/^\d$/;
	if (/^\d+$/.test(str) && str.length) {
	    // alert("内容不能全为数字");
		return true;
	}else{
	     return false; 
	}
}

/**
 * 
 * 判断数组中是否存在某个元素
 * 
 * @param search
 * @param array
 * @return
 */
function isInArray(search, array){
    for (var i in array){
        if(array[i] == search){
            return true;
        }
    }
    return false;
}

/**
 * 
 * 根据竞赛组信息，取出所有的科目
 * 
 * @param ContestInfoArr
 * @return
 */
function getSubjects(ContestInfoArr) {
	var subjects = new Array(); // 科目数组
	var length1 = ContestInfoArr.length;
	
	for (var i=0; i<length1; i++) {
		var subject = ContestSetObj[i].contestSubject;
		
		if (!isInArray(subject, subjects)) {
			subjects.push(subject);
		}
	}
	
	return subjects;
}

/**
 * 根据用户选择的参赛科目，筛选出该科目所对应的竞赛信息
 * 
 * @return
 */
function selectContestBySubject(ContestInfoArr) {
	var obj = new Object();
	var objArr = new Array();
	
	var subjectChoice = $("#CominfoTypetext option:selected").val(); // 选中项的值
	
//	alert("用户选中的科目是:"+ subjectChoice);
	
	var length1 = ContestInfoArr.length;
	
	for (var i=0; i<length1; i++) {
	
		if (ContestInfoArr[i].contestSubject == subjectChoice) {
			obj = ContestInfoArr[i];
			objArr.push(obj);
		}
	}
	
	console.log("根据用户的科目选择筛选出来的竞赛组：" + JSON.stringify(objArr));
	return objArr;
}

/**
 * 根据用户选择的参赛科目，取出该科目所对应的年纪段信息
 * 
 * @param ContestInfoArr
 * @return
 */
function getObjects(ContestInfoArr) {
	var objArr = new Array();
	
	var length1 = ContestInfoArr.length;
	
	for (var i=0; i<length1; i++) {
		
		objArr.push(ContestInfoArr[i].contestObject);
	}
	
	return objArr;
}
/**
 * 
 * 
 * @param gardeChoice
 * @return
 */
function selectContestByGrade(ContestInfoArr) {
	var length1 = ContestInfoArr.length;
	var obj = new Object();
	
	var objectChoice = $("#CominfoRanktext option:selected").val(); // 选中项的值
	
	
	for (var i=0; i<length1; i++) {
		var contestObject = ContestInfoArr[i].contestObject;
		
		if (objectChoice == contestObject) {
			obj = ContestInfoArr[i];
			return obj;
		}
	}
	
//	console.log("根据用户的年级段选择出来的竞赛信息：" + JSON.stringify(obj));
//	return obj;
}

/***************************************************************************************************** */
// 数据提交
/***************************************************************************************************** */
//报名
function saveEnrollmentInfo() {
	
	var StudentName=$(".ParinfoNametext").val(); // 学生姓名
	var StudentSex=$(".ParinfoSextext").val(); // 学生性别
	var StudentIDNumber=$(".ParinfoIDNumbertext").val() ; // 学生的身份证号
	var StudentSchool=$(".ParinfoSchooltext").val(); // 学生学校
	var StudentGrade=$(".ParinfoGreadtext").val();  // 学生年级
	var UserAddress=$(".ParinfoAdresstext").val(); // 通讯地址
	var StudentContactsMan=$(".GuainfoNametext").val();  // 监护人
	var StudentContactsPhon=$(".GuainfoPhonetext").val(); // 监护人号码
	var StudentTeacher=$(".GuainfoTeachertext").val(); // 指导老师
	var StudentTeacherPhon=$(".GuainfoTeacherPhonetext").val(); // 指导老师电话号码
	
	var ContestObject=$("#CominfoRanktext").find("option:selected").text(); // 参赛年级
	var ContestSubject=$("#CominfoTypetext").find("option:selected").text(); // 科目
	
	var OrganizationName=$("#CominfoMechanismtext").find("option:selected").text();// 报名机构名字
	var StudentPicture="image/headboy.jpg"; // 学生照片
	var enrollmentState=0;// 大赛报名状态
	var OrganizationId = $("#CominfoMechanismtext option:selected").val(); // 选中项的值

	// 验证身份证号的格式
	if (!isnumeric(StudentIDNumber, 16)) {
		alert("您输入的身份证号码有误，请修改后，再此报名！");
		return ;
	}
	// 验证手机号码的格式
	if (!isnumeric(StudentContactsPhon, 11)) {
		alert("您输入的手机号码有误，请修改后，再此报名！");
		return ;
	}
	// 提醒用户报名
	var flag="";
	
	if(confirm("确定报名吗？")){
		enrollmentState=3;// 即大赛报名状态为已付款
		flag="报名成功";
	}
	else{
		enrollmentState=1;// 即大赛报名的状态为未付款
		flag="报名已取消";
	}
	// 验证用户是否是二次报名
	var json = new Object();
	json.StudentIDNumber = StudentIDNumber;
	json.CompetitionName = Info.CompetitionName;
	json.ContestObject = ContestObject;
	json.ContestSubject = ContestSubject;
	json.OrganizationName = OrganizationName;
	isSecondEnrollment(json);
	
	// 提交报名单
	$.ajax({
		type: "GET",
		url: "./EnrollmentCompetition",
		data: {"StudentName":StudentName,
				"StudentSex":StudentSex,
				"StudentIDNumber":StudentIDNumber,
				"StudentSchool":StudentSchool,
				"StudentGrade":StudentGrade,
				"UserAddress":UserAddress,
				"StudentContactsMan":StudentContactsMan,
				"StudentContactsPhon":StudentContactsPhon,
				"StudentTeacher":StudentTeacher,
				"StudentTeacherPhon":StudentTeacherPhon,
				"StudentSchool":StudentSchool,
				"CompetitionName":Info.CompetitionName,
				"ContestObject":ContestObject,
				"ContestSubject":ContestSubject,
				"ContestMoney":Contest_Money,
				"OrganizationName":OrganizationName,
				"StudentPicture":StudentPicture,
				"CompetitionSession":CompetitionSession,// 大赛届数
				"StartTime": Enroll_StartTime,// 大赛开始时间
				"EndTime":Enroll_EndTime, // 大赛结束时间
				"enrollmentState":enrollmentState,// 大赛报名状态
				"ContestId":Get_ContestId,// 竞赛项目id
				"OrganizationId":OrganizationId, // 机构id
				"UserId":userid // 用户id
		},
		dataType: "json",
		success: function(json){
			if(json.result==true){
				alert(flag);
				window.location.href="Web/Competition/jsp/competitionDetail.jsp?competitionId="+competitionId;
			}
		}
	});
}


/***************************************************************************************************** */
// 页面跳转
/***************************************************************************************************** */


/***************************************************************************************************** */
// 页面点击
/***************************************************************************************************** */



/***************************************************************************************************** */
// 事件绑定
/***************************************************************************************************** */

function bindClick() {
	// $("#choice_com_select").bind("click", showCompetitionOption());
	
	$("#CominfoTypetext").change(showObjects); // 将科目下拉框绑定显示参赛年级方法
	
	
	$("#CominfoRanktext").change(showOrgAndMoney); // 将年纪端下拉框绑定显示承办机构信息和报名费用方法
}










