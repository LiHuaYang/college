$(document).ready(function(){
	getCompetionNewsHot();	 //获得新闻头条
	getCompetionNewsList();	 //获得新闻列表
	
	//定义下面菜单栏的字体颜色
	$(".gotoNews").css("color","#0075c3");
});

/*
 * 作者：鲍晓飞
 * 函数功能：获得新闻头条 
 * 所需参数：无
 * 返回值：新闻头条
 * 创作时间：2016年2月26日
 */
function getCompetionNewsHot(){
	//获得新闻头条
	$.getJSON("./SearchTopNewsServlet",function(json){
		for(var i=0;i<1;i++){
			var newsTitle = json.result[0].newsTitle;
			$(".top").attr("style","background:url(WeChat/image/h3.jpg) center no-repeat;");
			$(".top").append(
					"<div class='hot'>"+newsTitle+"</div>"
			);
		}
	});
}
/*
 * 作者：鲍晓飞
 * 函数功能：获得新闻列表
 * 所需参数：无
 * 返回值：新闻列表 
 * 创作时间：2016年2月25日
 */
function getCompetionNewsList(){

		//获得新闻列表数据
		$.getJSON("./SearchAllNewsServlet",{page:1},function(json){
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
				}
				//根据新闻列表数据追加界面			
				$(".style_div").append(
					"<div class='newlistitem' style='width:100%;height:4em;margin-left:0px;display:inline-block;' onclick='itemClick(\""+newsId+"\")'>"+
						"<div>"+
								"<div style='font-size:1em;font-weight:bold;margin-top:6px;margin-left:10px;position:absolute;'>"+'['+newsState+']'+"</div>"+
				  		"</div>"+
				  		"<div class='competiontime' style='margin-top:6px;text-size:10em;margin-left:4em;display:inline-block;height:90%;'>"+
				  				"<div style='font-size:1em;font-weight:bold;width:100%;height:auto;'>"+cutString(newsTitle,30)+"</div>"+
				  				"<div style='font-size:1em;font-weight:bold;width:100%;height:auto;margin-top:10px;'>"+newsPutTime+"</div>"+
				  		"</div>"+
				  		"<div class='line' style='height:1px;width:100%;background:#cecece;overflow:hidden;'></div>"+
				  	"</div>"
				);
			};
		});
}
/*
 * 函数功能：新闻列表条目点击事件
 * 作者：鲍晓飞
 * 时间：2016年2月26日
 */
function itemClick(newsId){
	window.location.href="WeChat/jsp/CompetionNewDetail.jsp?newsId="+newsId;
}

/**
 * 截取字符串
 * @param str
 * @param len
 * @return
 */
function cutString(str, len){
	//length属性读出来的汉字长度为1
	
    if(str.length*2 <= len) {
        return str;
    }
    var strlen = 0;
    var s = "";
    for(var i = 0;i < str.length; i++) {
        s = s + str.charAt(i);
        if (str.charCodeAt(i) > 128) {
            strlen = strlen + 2;
            if(strlen >= len){
                return s.substring(0,s.length-1) + " ....";
            }
        } else {
            strlen = strlen + 1;
            if(strlen >= len){
                return s.substring(0,s.length-2) + " ....";
            }
        }
    }
    return s;
}

