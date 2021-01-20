var problem_id;
var solutionId = 0;
$(document).ready(function() {
	getProblemId();
	getSolutionId();
	if(solutionId!=0) {
		getData();
	}
})
//获取problemId
function getProblemId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("problem_id")+11;
	var intPos2 = strHref.indexOf("&");
	var strRight = strHref.substr(intPos,intPos2-intPos);
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
		json : JSON.stringify(json),"method" : "getsolutionset"
	},function(data) {
		console.log(data);
		var json = JSON.parse(data); 
		if(json.msg!=null) {
			$("#problem_code").val(json.data);
		}
	});
	
}