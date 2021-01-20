$(document).ready(function(){
	getInfo();
});
function getInfo() {
	$.post("../UserServlet", {
		method : "getUserInfo"
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		var json = data.data;
		showInfo(json);
	});
}
function showInfo (json) {
	document.getElementById("name").value=json.name;
	document.getElementById("sex").value=json.sex;
	document.getElementById("school").value=json.school;
	document.getElementById("grade").value=json.grade;
	document.getElementById("contactNumber").value=json.contactNumber;
	document.getElementById("iDcard").value=json.iDcard;
	document.getElementById("address").value=json.address;
	document.getElementById("motto").value=json.motto;
	$("#phonenumber").append("<p id='phone'>"+json.phonenumber+"</p>");
}
function saveInfo () {
	var name = $("#name").val();
	var sex = $("#sex").val();
	var school = $("#school").val();
	var grade = $("#grade").val();
	var contactNumber = $("#contactNumber").val();
	var iDcard = $("#iDcard").val();
	var address = $("#address").val();
	var motto = $("#motto").val(); 
	var phonenumber = $("#phone").text();
	
	$.post("../UserServlet", {
		method : "toUser",
		name: name,
		sex : sex,
		school : school,
		grade : grade,
		contactNumber : contactNumber,
		iDcard : iDcard,
		address : address,
		motto : motto,
		phonenumber : phonenumber
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		if(data.msg==true) {
			showdialog1();
		}
		else {
			showdialog2();
		}
	});
	
}
function showdialog1 () {
	$("#dialog1").show();
}
function showdialog2 () {
	$("#dialog2").show();
}
function toziliao () {
	$("#dialog1").hide();
	$("#dialog2").hide();
	window.location.href = "ziliao.html";
}