var problem_id;
var solutionId = 0;
$(document).ready(function() {
	getProblemId();
	getSolutionId();
	if(solutionId!=0) {
		getData();
	}
	$("#problem_id").html(problem_id);
})

function submitcode(problem_code) {
	var json = {
			"problemId" : problem_id,
			"code" : problem_code,
			"language" : 1,
			"ip" : "127.0.0"
		};
	$.post("../../ProblemActionV2",{
		json : JSON.stringify(json),
		"method" : "submiteCode"
	},function(data) {
		window.location.href = "solution.html";
	}) 
}


//获取problemId
function getProblemId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("problem_id")+11;
	var intPos2 = strHref.indexOf("&");
	var strRight;
	if(intPos2!=-1) {
		strRight = strHref.substr(intPos,intPos2-intPos);
	}
	else {
		strRight = strHref.substr(intPos);
	}
	problem_id = strRight;
}

//获取solutionId
function getSolutionId() {
	var strHref = window.document.location.href;
	intPos2 = strHref.indexOf("&");
	if(intPos2!=-1) {
		var strRight2 = strHref.substr(intPos2 + 1);
		var intPos = strRight2.indexOf("solution_Id=");
		var strRight = strRight2.substr(intPos + 12);
		solutionId = strRight;
	}
}

//获取数据


function getData() {
	var json = {
			"solutionId" : solutionId
		};
	$.post("../../SolutionActionV2",{
		json : JSON.stringify(json), "method" : "getsolutionset"
	},function(data) {
		var json = JSON.parse(data); 
		if(json.msg!=null) {
			editAreaLoader.setValue("problem_code", json.data);
		}
	});
}





