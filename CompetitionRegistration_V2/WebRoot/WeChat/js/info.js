$(document).ready(function(){
	showSubject();//显示参赛类别
	AddUserInfo();
})

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


//显示用户信息
function AddUserInfo() {
	$.ajax({
		type: "GET",
		url: "./UserInfobyIdServlet",
		data: {UserId:userid},
		dataType: "json",
		success: function(json){	
			document.getElementById('name').value=json.result.userName;//用户姓名
		//	document.getElementById('sex').value=json.result.userSex;//用户性别
			document.getElementById('idnumber').value=json.result.userIDNumber;//用户身份证号码
			document.getElementById('school').value=json.result.userSchool;//学校名称
	//		document.getElementById('ParinfoGreadtext').value=json.result.userGrade;//学校年级
			document.getElementById('address').value=json.result.userAddress;//通讯地址
			document.getElementById('man').value=json.result.userContactsMan;//监护人
			document.getElementById('phone').value=json.result.userContactsPhon;//监护人电话
			document.getElementById('tman').value=json.result.userTeacher;//指导老师
			document.getElementById('tphone').value=json.result.userTeacherPhon;//指导老师电话
		}
	});
}

//显示参赛类别
function showSubject(){
	$.ajax({
		type: "GET",
		url: "./GetContestSubjectServlet",
		data: {CompetitionId:competitionId},
		dataType: "json",
		success: function(json){
			$(".ContestSubjectinfo").append(
                '<select class="ContestSubject" id="ContestSubject" onchange="showObject();">'+     
                '<option disabled="true">请选择</option>'+
                '</select>'
			);
		
			//循环option
			for(var i=0;i<json.result.length;i++){
				$("<option>"+json.result[i].contestSubject+"</option>").appendTo("#ContestSubject")
			}
		}
	});
}

//显示参赛级别
function showObject(){
	var ContestSubject=$(".ContestSubject").val();
	$("#CominfoRanktext ").empty(); 
	$("#CominfoPricetext").val("");
	//$("#CominfoMechanismtext ").empty(); 
	$("<option>选择参赛年级</option>").appendTo("#CominfoRanktext")

	$.ajax({
		type: "GET",
		url: "./GetContestObjectServlet",
		data: {CompetitionId:competitionId,ContestSubject:ContestSubject},
		dataType: "json",
		success: function(json){
	
			//循环option
			for(var i=0;i<json.result.length;i++){
				$("<option>"+json.result[i]+"</option>").appendTo("#CominfoRanktext")
			}
		}
	});
}
var Get_ContestId=0;    //ConTestId

//根据大赛,科目，参赛年级获得ContestId
function GetContestId(){
	
	var ContestSubject=$(".ContestSubject").val();
	var ContestObject=$(".ContestObject").val();
	if(ContestSubject!=null && ContestObject!=null){
//    alert(ContestSubject);
//    alert(ContestObject);
		$.ajax({
			type: "GET",
			url: "./QueryContestIdServlet",
			data: {CompetitionId:competitionId,ContestSubject:ContestSubject,ContestObject:ContestObject},
			dataType: "json",
			success: function(json){
				
				Get_ContestId=new Number(json.result);
				ShowEnrollmentScore(); //显示报名费
				ShowOrgnization();    //显示机构
			}
		});
	}
}

var Enroll_StartTime="";
var Enroll_EndTime="";
//显示报名费
function ShowEnrollmentScore() {
	$("#CominfoPricetext ").empty(); 
	$.ajax({
		type: "GET",
		url: "./GetContestMoneybyId",
		data: {contestId:Get_ContestId},
		dataType: "json",
		success: function(json){
			Enroll_StartTime=new String(json.result[0].startTime);
			Enroll_EndTime=new String(json.result[0].endTime);
			document.getElementById("CominfoPricetext").value=json.result[0].contestMoney;
		}
	});
}


//显示机构
function ShowOrgnization() {

$("#CominfoMechanismtext ").empty(); 
	$.ajax({
		type: "GET",
		url: "./GetOrganizationServelet",
		data: {contestId:Get_ContestId},
		dataType: "json",
		success: function(json){	
			$(".CompetitioninfoMechanism").append(
					
			);
			//循环option
			for(var i=0;i<json.result.length;i++){
				$("<option value='"+json.result[i].OrganizationId+"'>"+json.result[i].OrganizationName+"</option>").appendTo("#CominfoMechanismtext")
			}
		}
	});
}


//判断字符串是否为纯数字
function isnumeric(str, length)
{
	// var patrn=/^\d$/; 
	if (/^\d+$/.test(str) && str.length == length) {
	    // alert("内容不能全为数字");
		return true;
	}else{
	     return false; 
	}
}

//判断身份证号
function checkCard(str) {
    if (/^\d{15}|\d{}18$/.test(str)) {
        return true;
    }
    else {
        return false;
    }
}


function insertinfo() {
	    var StudentGrade=$("#grade").find("option:selected").text();
		switch(StudentGrade){
		case "":
			StudentGrade="0";
			break;
		case "小学一年级":
			StudentGrade="1";
			break;
		case "小学二年级":
			StudentGrade="2";
			break;
		case "小学三年级":
			StudentGrade="3";
			break;
		case "小学四年级":
			StudentGrade="4";
			break;
		case "小学五年级":
			StudentGrade="5";
			break;
		case "小学六年级":
			StudentGrade="6";
			break;
		case "初中一年级":
			StudentGrade="7";
			break;
		case "初中二年级":
			StudentGrade="8";
			break;
		case "初中三年级":
			StudentGrade="9";
			break;
		case "高中一年级":
			StudentGrade="10";
			break;
		case "高中二年级":
			StudentGrade="11";
			break;
		case "高中三年级":
			StudentGrade="12";
			break;
		}
	
		var StudentName=$("#name").val();
		var StudentSex=$("#sex").find("option:selected").text();
//		var ContestSbject =$("#ContestSubject option:selected").val();
//		var ContestObject =$("#CominfoRanktext option:selected").val();
//		var OrganizationName =$("#CominfoMechanismtext option:selected").val();
		var ContestObject=$("#CominfoRanktext").find("option:selected").text(); //参赛年级
		var ContestSubject=$("#ContestSubject").find("option:selected").text(); //科目
		var OrganizationName=$("#CominfoMechanismtext").find("option:selected").text();//报名机构名字
		var ContestMoney=$("#CominfoPricetext").val();
		var StudentIDNumber=$("#idnumber").val();
		var StudentSchool=$("#school").val();
		var UserAddress=$("#address").val();
		var StudentContactsMan=$("#man").val();
		var StudentContactsPhon=$("#phone").val();
		var StudentTeacher=$("#tman").val();
		var StudentTeacherPhon=$("#tphone").val();
		var OrganizationId =$("#CominfoMechanismtext option:selected").val(); // 选中项的值
		var StudentPicture="image/headdd.jpg"; //学生照片
		
		 //判断用户输入是否为身份证号  
        if(!checkCard(StudentIDNumber)){
        	alert("请确认您的身份证号码，修改后再次报名！");
			return ;
        }
		// 验证手机号码的格式
		if (!isnumeric(StudentContactsPhon, 11)) {
			alert("请确认监护人的手机号码，修改后再次报名！");
			return ;
		}
		if (StudentSchool.length <= 0||StudentContactsMan.length <= 0) {
			alert("*为必填信息,请填写完整！");
			return ;
		}
		//判断所在年级是否已选择
		if (StudentGrade=="请选择") {
			alert("请选择所在年级");
			return ;
		}
		// 提醒用户报名
		if(confirm("确定报名吗？")){
			enrollmentState = 1; //即大赛报名状态为未付款
		}
		else{
			// enrollmentState = 1; // 即大赛报名的状态为未付款
			return ;
		}	
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
					"CompetitionName":CompetitionName,
					"ContestObject":ContestObject,
					"ContestSubject":ContestSubject,
					"ContestMoney":ContestMoney,
					"OrganizationName":OrganizationName,
					"StudentPicture":StudentPicture,
					"CompetitionSession":CompetitionSession,//大赛届数
					"StartTime": Enroll_StartTime,//大赛开始时间
					"EndTime":Enroll_EndTime, //大赛结束时间
					"enrollmentState":enrollmentState,//大赛报名状态
					"ContestId":Get_ContestId,//竞赛项目id
					"OrganizationId":OrganizationId, //机构id
					"UserId":userid //用户id
			},
			dataType: "json",
			success: function(json){
				if(json.result==true){
					window.location.href="MainServlet?ContestMoney="+ContestMoney + "&userid=" + userid;  
				}
			}
		});
	}

//判断是否可以报名
function Judge_Enroll(){
	
	var CompetitionName="";
	var StudentIDNumber="";
	var StudentIDNumber=$("#idnumber").val() ; //学生的身份证号
	var ContestObject=$("#CominfoRanktext").find("option:selected").text(); //参赛年级
	var ContestSubject=$("#ContestSubject").find("option:selected").text(); //科目
	
	  //判断参赛科目是否已选择
	if (ContestSubject=="请选择") {
		alert("请选择参赛科目");
		return ;
	}
	 //判断参赛年级是否已选择
	if (ContestObject=="选择参赛年级  ") {
		alert("请选择参赛年级");
		return ;
	}
	$.ajax({
		type: "GET",
		url: "./JudgeEnrollOrNotServlet",
		data: { "UserIdNumber":StudentIDNumber,
				"CompetitionName":CompetitionName,
				"ContestSubject":ContestSubject,
				"ContestObject":ContestObject,
		},
		dataType: "json",
		success: function(json){
			if(json.result == true){   //可以报名
				insertinfo();
			}
			else{
				alert("已报过名，无须重复报名");
			}
		}
	});
}
		