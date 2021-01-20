var problem_id = 0;
var editor1;
var editor2;
var editor3;
var editor4;

$(document).ready(function() {
	getProblemId();
//	KindEditor.ready(function (){
	editor1 = KindEditor.create('#describe',{allowImageUpload:false,resizeType : 1,afterBlur: function(){this.sync();} });
	editor2 = KindEditor.create('#problem_input',{allowImageUpload:false,resizeType : 1,afterBlur: function(){this.sync();} });
	editor3 = KindEditor.create('#problem_output',{allowImageUpload:false,resizeType : 1,afterBlur: function(){this.sync();} });
	editor4 = KindEditor.create('#hint',{allowImageUpload:false,resizeType : 1,afterBlur: function(){this.sync();} });
	
	if(problem_id!=0){
		getProblemDetail();
	}
});

//获取界面上的数据
function getData() {
	var problem = new Object();
	problem.name = $("#problem_name").val();
	problem.time = $("#time_limit").val();
	problem.storage = $("#storage_limit").val();
	problem.describe = editor1.html();
	problem.input = editor2.html();
	problem.output = editor3.html();
	problem.hint = editor3.html();
	problem.sample_input = $("#input_example").val();
	problem.sample_output = $("#output_example").val();
	problem.spl = $("#spl").val();
	problem.source = $("#source").val();
	problem.contestId = 1000;
	return problem;
}

//添加问题
// TODO:添加问题JS验证
function addProblem() {
	var problem = getData();
	if( problem.name.length==0 || problem.time.length==0||problem.storage.length==0||problem.describe.length==0||problem.input.length==0||problem.output.length==0&&
			problem.hint.length==0||problem.sample_input.length==0||
			problem.sample_output.length==0||problem.spl.length==0||problem.source.length==0||problem.contestId.length==0
			) {
		alert("不能为空！");
	}
	else {
		var json = {
				"title" : problem.name,
				"time_limit" : problem.time,
				"memory_limit" : problem.storage,
				"description" : problem.describe,
				"output" : problem.output,
				"input" : problem.input,
				"sample_input" : problem.sample_input,
				"sample_output" : problem.sample_output,
				"hint" : problem.hint,
				"spj" : problem.spl,
				"source" : problem.source,
				"contestId" : problem.contestId,
			};
		$.post("../ProblemActionV2",{
			"method" : "addProblem",
			json : JSON.stringify(json)
		},function(data) {
			var json = JSON.parse(data);
			if(json.msg==false) {
				alert("添加失败");
			}
			else if(json.msg==true){
				alert("添加成功");
			}
		});
	}
	
}

//获取问题详情
function getProblemDetail() {
	var json = {
			"id" : problem_id
		};
	$.post("../ProblemActionV2",{
		"method" : "getProblemDetail",
		json : JSON.stringify(json)
	},function(data) {
		var json = JSON.parse(data);
		dealProblemDetail(json);
	});
}

//对问题详情数据的处理
function dealProblemDetail(data) {
	if(data.msg==true) {
		var json = data.data;
//		console.log(json);
		$("#problem_name").val(json.title);
		$("#time_limit").val(json.time_limit);
		$("#storage_limit").val(json.memory_limit);
		editor1.html(json.description);
		$("#input_example").val(json.sample_input);
		$("#output_example").val(json.sample_output);
		$("#spl").val();
		$("#source").val(json.source);
	}
	else {
		alert("获取问题信息失败！")
	}
}


//获取问题id
function getProblemId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	if(intPos!=-1) {
		var strRight = strHref.substr(intPos + 1);
		problem_id = strRight;
	}
}

