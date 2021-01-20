$(document).ready(function() {
	var id  = getUrlParam("contest_id");
	var probloemIds = getUrlParam("ids");
	
	// 判断地址栏中是否带peoblemid
	if (probloemIds!=null) {
		$("#problemName").val(probloemIds);
	}
	//1. 判断地址栏中是否带参数
	if (id!=null) {
		getContestInfo(id);
	}
	showContstTime();
});


/**
 * 当参数带有contestid时候，显示该contest的信息
 */
function getContestInfo(id) {
$.post( "../ContestActionV2",
		{
			"method":"getContest",
			"id" : id
		},
		function(data) {
			var json = JSON.parse(data);
			showContestInfo(json);
		});
}

/**
 * 
 * @param json
 */
function showContestInfo(json) {
	$("#title").val(json.title);
	// -1 0 1 2 3 4 5 6 7 8 10 11 12 
	// 2  0 1 6 - 0 7 - 2 5 2  0  : 00:00
	var stime = json.start_time;
	$("#startyear").val(stime.substr(0, 4));
	$("#startmonth").val(stime.substr(5, 2));
	$("#startday").val(stime.substr(8, 2));
	$("#starthour").val(stime.substr(10, 2));
	$("#startminute").val(stime.substr(13, 2));
	var etime = json.end_time;
	$("#endyear").val(etime.substr(0, 4));
	$("#endmonth").val(etime.substr(5, 2));
	$("#endday").val(etime.substr(8, 2));
	$("#endhour").val(etime.substr(10, 2));
	$("#endminute").val(etime.substr(13, 2));
	$("#privilege").val(json.Private); // 权限
	$("#password").val(json.password);
	$("#language").val(json.langmask); // 语言
	$("#problemName").val(json.problem_ids);
	editor1.html(json.description);
	
	var length = json.user_ids.length;
	var ids = "";
	for (var i=0; i<length; i++) {
		ids += json.user_ids[i] + "\n";
	}
	 $("#users").val(ids); // 显示的时候，换行显示
}
/**
 * 
 * 获取url中的参数
 * 
 */
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

/**
 * 
 */
function showContstTime() {
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
		document.getElementById("startyear").value = Y;
		document.getElementById("startmonth").value = M;	
		document.getElementById("startday").value = D;	
		document.getElementById("starthour").value = H;	
		document.getElementById("startminute").value = "00";	
		
		H = fillZero(d.getHours()+4);
		if(H>=24) {
			H =fillZero(d.getHours()-20);
			D = fillZero(d.getDate()+1);
		}
		document.getElementById("endyear").value = Y;	
		document.getElementById("endmonth").value = M;	
		document.getElementById("endday").value = D;	
		document.getElementById("endhour").value = H;	
		document.getElementById("endminute").value = "00";	
		var y = $("#startyear").val();
		})();
}

/**
 * 获取页面上的数据
 * 
 * 返回值为竞赛对象
 * @returns {___anonymous1051_1057}
 */
function getData() {
	var Contest = new Object();
	Contest.title = $("#title").val();
	Contest.startyear = $("#startyear").val();
	Contest.startmonth = $("#startmonth").val();
	Contest.startday = $("#startday").val();
	Contest.starthour = $("#starthour").val();
	Contest.startminute = $("#startminute").val();
	Contest.starttime = Contest.startyear+":"+Contest.startmonth+":"+Contest.startday+":"+Contest.starthour+":"+Contest.startminute+":"+"00";
	Contest.endyear = $("#endyear").val();
	Contest.endmonth = $("#endmonth").val();
	Contest.endday = $("#endday").val();
	Contest.endhour = $("#endhour").val();
	Contest.endminute = $("#endminute").val();
	Contest.endtime = Contest.endyear+":"+Contest.endmonth+":"+Contest.endday+":"+Contest.endhour+":"+Contest.endminute+":"+"00";
	Contest.privilege = $("#privilege").val();
	Contest.password = $("#password").val();
	Contest.language = $("#language").val();
	Contest.problem = $("#problemName").val();
	Contest.describe = editor1.html();
	Contest.users = $("#users").val();
	return Contest;
}
function Reset() {
	window.location.reload();
}

/**
 * 提交竞赛
 */
function Submit() {
	var Contest = getData();
	var json = {
		"title"      : Contest.title,
		"starttime"	 : Contest.starttime,
		"endtime"  	 : Contest.endtime,
	    "privilege"  : Contest.privilege,
	    "password"	 : Contest.password,
		"language"	 : Contest.language,
		"problem"    : Contest.problem,
		"describe"   : Contest.describe,
		"users"      : Contest.users
	};
	$.post("../ContestActionV2",{
		json : JSON.stringify(json),"method":"AddContest"
	},function(data) {
		var json = JSON.parse(data);
		alert(json.msg);
		if (json.res == "true") {
			window.location.href = "Contest_list.html";
		}
	});
}