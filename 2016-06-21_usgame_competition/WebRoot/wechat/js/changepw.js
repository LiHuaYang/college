function changepw () {
	var old_pw = $("#old_pw").val();
	var new_pw = $("#new_pw").val();
	if(old_pw==new_pw) {
		showdialog3();
	}
	else {
		$.post("../UserServlet", {
			method : "changepw",
			old_pw: old_pw,
			new_pw : new_pw
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
}

function showdialog1 () {
	$("#dialog1").show();
}
function showdialog2 () {
	$("#dialog2").show();
}
function showdialog3 () {
	$("#dialog3").show();
}
function todenglu () {
	$("#dialog1").hide();
	$("#dialog2").hide();
	$("#dialog3").hide();
	window.location.href = "denglu.html";
}
function togeren () {
	$("#dialog1").hide();
	$("#dialog2").hide();
	$("#dialog3").hide();
	window.location.href = "geren.html";
}
function tochangepw () {
	$("#dialog1").hide();
	$("#dialog2").hide();
	$("#dialog3").hide();
	window.location.href = "changepw.html";
}