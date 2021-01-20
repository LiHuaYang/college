function login() {
	var phonenumber = $("#phonenumber").val();
	var password = $("#password").val();
	
	$.post("../UserServlet", {
		method : "login",
		phone :phonenumber,
		password : password
	}, function(json) {
		var json = JSON.parse(json);
		if(json.msg==true) {
			togeren();
			console.log(json.data);
		} 
		else {
			showdialog2();
		}
	});
}
function showdialog2 () {
	$("#dialog2").show();
}
function todenglu () {
	$("#dialog2").hide();
	window.location.href = "denglu.html";
}
function togeren () {
	window.location.href = "geren.html";
}
function tozhuce () {
	window.location.href = "zhuce.html";
}
function tofindfw () {
	
}