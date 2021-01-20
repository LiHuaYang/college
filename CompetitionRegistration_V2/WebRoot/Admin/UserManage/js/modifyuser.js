$(function(){
	var json={
			"UserId":jspUserId
			};
	$.getJSON(
			"./UserSearchSingelInfoServlet",
			{ json : JSON.stringify(json) },
			function(json) {
				//alert(json.result.userAddress);
				
				$("#UserSchool1").val(json.result.userSchool);
				$("#UserContactsMan1").val(json.result.userContactsMan);
				$("#UserContactsPhon1").val(json.result.userContactsPhon);
				$("#UserAddress1").val(json.result.userAddress);
				$("#UserTeacher1").val(json.result.userTeacher);
				$("#UserTeacherPhon1").val(json.result.userTeacherPhon);
				$("#UserName1").val(json.result.userName);
				$("#UserPic1").val(json.result.userPicture);
				$("#UserGrade1").val(json.result.userGrade);
				$("#UserIDNumber1").val(json.result.userIDNumber);
				$("#UserPhone1").val(json.result.userPhone);
				$("#UserSex1").val(json.result.userSex);
				$("#UserYear1").val(json.result.userYear);
	});
});


function ModifyAUser(){
	//alert(jspUserId);
	var UserSchool=$("#UserSchool1").val();
	var UserContactsMan=$("#UserContactsMan1").val();
	var UserContactsPhon=$("#UserContactsPhon1").val();
	var UserAddress=$("#UserAddress1").val();
	var UserTeacher=$("#UserTeacher1").val();
	var UserTeacherPhon=$("#UserTeacherPhon1").val();
	var UserName=$("#UserName1").val();
	var UserPic=$("#UserPic1").val();
	var UserGrade=$("#UserGrade1").val();
	var UserIDNumber=$("#UserIDNumber1").val();
	var UserPhone=$("#UserPhone1").val();
	var UserSex=$("#UserSex1").val();
	var UserYear=$("#UserYear1").val();
	
//	if(UserSchool==""){UserSchool=$("#UserSchool1").val();}
//	if(UserContactsMan==""){UserContactsMan=$("#UserContactsMan1").val();}
//	if(UserContactsPhon==""){UserContactsPhon=$("#UserContactsPhon1").val();}
//	if(UserAddress==""){UserAddress=$("#UserAddress1").val();}
//	if(UserTeacher==""){UserTeacher=$("#UserTeacher1").val();}
//	if(UserTeacherPhon==""){UserTeacherPhon=$("#UserTeacherPhon1").val();}
//	if(UserName=="")UserName=$("#UserName1").val();
//	if(UserPic=="")UserPic=$("#UserPic1").val();
//	if(UserGrade=="")UserGrade=$("#UserGrade1").val();
//	if( UserIDNumber=="")UserIDNumber = $("#UserIDNumber1").val();
//	if( UserPhone=="")UserPhone=$("#UserPhone1").val();
//	if( UserSex=="")UserSex=$("#UserSex1").val();
//	if( UserYear=="")UserYear=$("#UserYear1").val();
	
	var json={
			"UserId":jspUserId,
			"UserSchool":UserSchool,
			"UserContactsMan":UserContactsMan,
			"UserContactsPhon":UserContactsPhon,
			"UserAddress":UserAddress,
			"UserTeacher":UserTeacher,
			"UserTeacherPhon":UserTeacherPhon,
			"UserName":UserName,
			"UserPic":UserPic,
			"UserGrade":UserGrade,
			"UserIDNumber":UserIDNumber,
			"UserPhone":UserPhone,
			"UserSex":UserSex,
			"UserYear":UserYear
	};
	
	//alert(UserSchool+UserContactsMan+UserTeacher+UserContactsPhon+UserAddress+UserName+UserPic+UserTeacherPhon);
	$.getJSON(
			"./ModifyAUserServlet",
			{ json : JSON.stringify(json) },
			function(json) {
				if(json.result){
					alert("修改成功！");
					location.reload(true);
				}
				else{
					alert("修改失败！");
				}
	});
}
function glanceover(){
	alert("功能待开发！");
}
function save(){
	alert("功能待开发！");
}