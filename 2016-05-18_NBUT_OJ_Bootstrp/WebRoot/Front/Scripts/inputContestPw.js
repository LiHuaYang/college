var password = null;
var id = null;
$(document).ready(function() {
	var url = location.search;
	id = url.substring(4,10); 
	$.getJSON("../../ContestActionV2",{id: id,"method":"getContest"},function(result){
		password = result.password;
	});
})

function submit() {
 var pw = $(".pw").val();
 if(pw==password) {
		window.location.href="Contest_problem.html?id="+id;	
	}
	else {
		alert("密码错误");
	}
}

