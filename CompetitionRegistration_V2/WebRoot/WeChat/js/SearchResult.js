$(document).ready(function(){
	getCompetionResultList();	 //获得成绩列表
});

/*
 * 作者：鲍晓飞
 * 函数功能：提交查询信息
 * 所需参数：大赛名、考生名、准考证号
 * 返回值：
 * 创作时间：2016年2月27日
 */
function getCompetionResultInfo(){
	var comprtionName=document.getElementById("comName").value;	
	var stdName=document.getElementById("stdName").value;	
	var admCard=document.getElementById("admCard").value;	
	alert(comprtionName);
	//成绩查询
	//$.getJSON("./SearchTopNewsServlet",function(json){
	//});
}
/*
 * 作者：鲍晓飞
 * 函数功能：获得我的成绩列表
 * 所需参数：用户Id
 * 返回值：成绩列表 
 * 创作时间：2016年2月27日
 */
function getCompetionResultList(){
		$(".resultList").html("");
		//成绩列表查询
		/*$.getJSON("./SearchAllNewsServlet",{userId:1},function(json){
			for(var i=0;i<json.result.length;i++){
				var newsTitle= json.result[i].newsTitle;		//新闻标题
				var newsState= json.result[i].newsState;    	//新闻类型
				var newsPutTime=json.result[i].newsPutTime;		//发布时间
				var newsId = json.result[i].newsId;				//新闻id
				if(newsState==1){
					newsState = "小学";
				}
				else if(newsState==2){
					newsState = "初中";
				}
				else if(newsState==3){
					newsState = "高中";
				}*/
				//根据成绩列表数据追加界面		
				$(".resultList").append(
					"<div class='resultlistitem'>"+
				  		"<div class='resultinfo'>"+
				  				"<div class='competionname'>"+'比赛名:'+"</div>"+
				  				"<div class='competionrank'>"+'25级'+"</div>"+
				  				"<div class='itemstyle'>"+'比赛类别:'+"</div>"+
				  				"<div class='itemstyle'>"+'比赛等级:'+"</div>"+
				  				"<div class='itemstyle'>"+'考生姓名：'+"</div>"+
				  		"</div>"+
						"<div class='gradestyle'>"+
							"<div class='grade'>"+80+"</div>"+
	  					
						"</div>"+
				  		"<div class='line'></div>"+
				  	"</div>"
				);
			//};
		//});
}
/*
 * 返回按钮点击事件
 */
function backevent(){
	window.location.href="WeChat/jsp/CompetionNewsList.jsp";
}

