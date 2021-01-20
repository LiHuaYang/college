$(document).ready(function(){
	getData ();
}); 


/**
 * 
 * 获取url中的参数
 * 
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);   // 匹配目标参数
	if (r != null) return unescape(r[2]); 
	return null;  // 返回参数值
}


/**
 * 拿到数据
 * @return
 */
function getData () {
	var competitionId = getUrlParam('competitionId');
	
	var json = {
			"competitionId" : competitionId
	}
	
	$.getJSON("./GetCompetitionDetailServlet", 
			{data : JSON.stringify(json)}, 
			function(json) {
				var contestInfoObj = NewObj(json);          //1.数据转换
				if(contestInfoObj.flag == true){            //2.判断数据是否正确
					setContestInfoView(contestInfoObj);          //如果正确设置页面
				}else{
					alert("服务器错误");                          //错误则提示错误
				}
		});	
}

/**
 * 数据转换
 * @param json
 * @return
 */
function NewObj(json){
	//1.定义返回变量
	var contest = new Object();
	
	//2.数据转换
	if(json.msg == true){
		contest.flag = true;
		
		contest.prizeSetting = json.data.competitionPrize;
		contest.info = json.data.competitionInfo;
		contest.subject=json.data.contestSet[0].contestSubject;
		contest.name = json.data.competitionName;
		contest.type = json.data.contestSet[0].contestexamType;
		contest.object = json.data.competitionObjectDescribe;
		contest.time = json.data.competitionTimeDescribe;
		contest.enrollPrice = json.data.competitionPriceDescribe;
	}else{
		contest.flag = false;
	}
	
	//3.返回大赛数据变量
	return contest;
}

/**
 * 设置页面
 */
function setContestInfoView(contestInfoObj){
	//1.设置网页数据
	$("#prize_info_text").append(contestInfoObj.prizeSetting);
	$("#detail_info_text").append(contestInfoObj.info);
	$("#subject_info_text").append(contestInfoObj.subject);
	$("#type_info_text").append(contestInfoObj.type);
	$("#object_info_text").append(contestInfoObj.object);
	$("#time_info_text").append(contestInfoObj.time);
	$("#enrollPrice_info_text").append(contestInfoObj.enrollPrice);
	$("#info_title").append(contestInfoObj.name);
	
	//2.设置网页标题
	window.document.title = contestInfoObj.name + '  更多资料...'; 
}


















