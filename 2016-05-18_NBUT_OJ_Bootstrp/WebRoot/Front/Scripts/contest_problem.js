var contestId=null;
var currentPage = 1;//当前页号
$(document).ready(function() {
	getContestId();
	getData(contestId);
	shownowtime();
	var json = {
			"page" : currentPage,// 初始化为当前页数
			"contestId" : contestId
		};
	getProblem(json);
})

function getProblem(json) {
	$.post("../../ContestActionV2",{
			json : JSON.stringify(json),"method" : "getContestProblemSet"
	},function(data) {
		var json = JSON.parse(data); 
		if(json.length>0) {
			$("#problem").empty();
			$("#problem").append("<tr>"+
					"<th>"+"编号"+"</th>"+
					"<th>"+"标题"+"</th>"+
					"<th>"+"来源"+"</th>"+
					"<th>"+"正确"+"</th>"+
					"<th>"+"提交"+"</th>"
					)
					
			for(var i =0; i<json.length;i++) {
				$("#problem").append("<tr>"+
						"<td><a href='detail.html?problemid=" + json[i].problem_id + "'>"+json[i].problem_id+"</a></td>"+
						"<td><a href='detail.html?problemid="+ json[i].problem_id + "'>"+json[i].title+"</a></td>"+
						"<td>"+json[i].source+"</td>"+
						"<td><a href='solution.html?problemid="+ json[i].problem_id + "&type=1'>"+json[i].accepted+"</td>"+
						"<td><a href='solution.html?problemid="+ json[i].problem_id + "&type=2'>"+json[i].submit+"</td>"
					)
			}
		}
		else {
			alert("无更多的问题！");
		}
		console.log(json);
	});
	
	
}



function toDetail(obj) {
	var id = $(obj).find('span').html();
	alert(id);
	window.location.href = "detail.html?problemid="+contestId;
}

function nextPage(obj) {
	if ($(obj).val() == "pre") {
		currentPage--;
	}
	else {
		currentPage++;
	}
	var json = {
			"page" : currentPage,// 初始化为当前页数
			"contestId" : contestId
		};
	getProblem(json);
}
function getContestId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	contestId = strRight;
}


function getData(contestId) {
	$.post("../../ContestActionV2",{
		"id" : contestId,"method":"getContest"
	},function(data) {
		var json = JSON.parse(data); 
		$("#contest_title").html("Contest"+json.contest_id+" - "+json.title);
		$("#contest_description").html(json.description);
		$("#start_time").html(json.start_time);
		$("#end_time").html(json.end_time);
		///////////
		$("#Status").html(time(json.start_time,json.end_time)+"  "+Private(json.Private));
		
		
	});
}

function time(start,end){
	var now = new Date().getTime(); 
	var end = new Date(end).getTime();
	var start = new Date(start).getTime();
	var sec = end-start;
	if((now-end)>0){
		return "Ended"
		}
	if((start-now)<0&&(now-end)<0)
		{
		return "Running "
		}
	
}

function Private(a)
{
   switch (a)
   {
   case 0: 
	   return "public";
   case 1:
	   return "Private";
   }
}

function shownowtime(){
	function fillZero(v){
	if(v<10){v='0'+v;}
	return v;
	}
	(function(){
	var d=new Date();
	Y=d.getFullYear();
	M=fillZero(d.getMonth()+1);
	D=fillZero(d.getDate());
	H=fillZero(d.getHours());
	I=fillZero(d.getMinutes());
	S=fillZero(d.getSeconds());
	var time = Y+'-'+M+'-'+D+' '+H+':'+I+':'+S;
	
	document.getElementById("current_time").innerHTML =	time;
		
	//每秒更新时间
	setTimeout(arguments.callee,1000);
	})();
}
