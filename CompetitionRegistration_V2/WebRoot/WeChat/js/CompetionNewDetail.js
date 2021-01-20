$(document).ready(function(){
	getCompetionNewDetail();		//获得新闻详情
});
/*
 * 作者：鲍晓飞
 * 函数功能：获得新闻详情
 * 所需参数：无
 * 返回值：新闻详情
 * 创作时间：2016年2月26日
 */
function getCompetionNewDetail(){
		//获得新闻详情
		$.getJSON("./GetSingleNewsbyIdServlet",{newsId:newsId},function(json){
			
			for(var i=0;i<1;i++){
				var newsTitle= json.result[i].newsTitle;		//新闻标题
				var newsState= json.result[i].newsState;    	//新闻类型
				var newsPutTime=json.result[i].newsPutTime;		//发布时间
				var newsSource = json.result[i].newsSource;		//新闻出处
				var newsExtralInfo = json.result[i].newsExtralInfo;	 //新闻附加信息
				var newsPicUrl = json.result[i].newsPicUrl;	  //新闻图片路径
				if(newsState==1){
					newsState = "小学";
				}
				else if(newsState==2){
					newsState = "初中";
				}
				else if(newsState==3){
					newsState = "高中";
				}
				
				$(".detailstyle").append(
					"<div class='newlistitem' style='width:100%;height:4em;display:inline-block;margin-top:10px;'>"+
						"<div>"+
								"<div class='newsstate'>"+'['+newsState+']'+"</div>"+
				  		"</div>"+
				  		"<div class='competiontime'>"+
				  				"<div style='font-size:1em;width:100%;height:auto;'>"+newsTitle+"</div>"+
				  				
				  		"</div>"+
				  		"<div class='imgstyle' style='background:url("+newsPicUrl+") center no-repeat;'>"+"</div>"+
				  		"<div style='display:inline-block;width:100%;'>"+
		  				"<div class='info'>"+newsExtralInfo+"</div>"+
		  					"<div class='info2'>"+newsPutTime+"</div>"+
		  					"<div class='info2'>"+"转自《"+newsSource+"》"+"</div>"+
		  				"</div>"+
				  	"</div>"
				  
				  	
				);
				
				$(".titlebar").append(
					"<div class='newstitle'>"+newsTitle+"</div>"
				);
			}
		});
}
