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
        if(json==null) {
        	window.location.href = "denglu.html";
		}
        else {
        	showInfo(json);
        }
		
		
	});
}

function showdialog3 () {
	$("#dialog3").show();
}
function todenglu () {
	$("#dialog3").hide();
	window.location.href = "denglu.html";
}
function togeren () {
	$("#dialog3").hide();
	window.location.href = "geren.html";
}
function showInfo (json) {
	$("#name").text(json.name);
	$("#phonenumber").text(json.phonenumber);
}
function logout() {
	$.post("../UserServlet", {
		method : "logout"
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		if(data.msg==true) {
			window.location.href = "denglu.html";
		}
		else {
			showdialog3();
		}
	});
	
}