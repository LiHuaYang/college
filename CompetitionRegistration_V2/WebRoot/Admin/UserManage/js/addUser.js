

$(document).ready(function() {
	
})




function addAUser() {
	var json = { 
			"UserName" : $("#UserName").val(),
			"UserSex" : $("#UserSex").val(),
			"UserIDNumber" : $("#UserIDNumber").val(),
			"UserPhone" : $("#UserPhone").val(),
			"UserSchool" : $("#UserSchool").val(),
			"UserYear" : $("#UserYear").val(),
			"UserGrade" : $("#UserGrade").val(),
			"UserContactsMan" : $("#UserContactsMan").val(),
			"UserContactsPhon" : $("#UserContactsPhon").val(),
			"UserAddress" : $("#UserAddress").val(),
			"UserTeacher" : $("#UserTeacher").val(),
			"UserTeacherPhon" : $("#UserTeacherPhon").val(),
	};
	
	$.getJSON(
			"./UserCreateServlet",
			{ json : JSON.stringify(json) },
			function(jsonObject) {
				alert(jsonObject);
	});
}
function glanceover(){
	alert("功能待开发！");
}
function save(){
	alert("功能待开发！");
}

