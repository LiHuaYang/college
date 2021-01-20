$(document).ready(function(){
	var PastPagerJson;					//真题数据集合
	var currentNum;						//当前显示的是第几条数据
	var totalNum;
	var isCollect = false;                      //试题是否已收藏
	getPastYearsPagerDetail();			//真题列表详情界面
	CollectStateJudge();				//判断用户是否收藏该界面
});
/*
 * 作者：鲍晓飞
 * 函数功能：真题列表详情界面
 * 所需参数：无
 * 返回值：真题列表详情界面
 * 创作时间：2016年2月29日
 */
function getPastYearsPagerDetail(){
	$.getJSON("./GetTestPaperPictureById",{PaperId:pagerId},function(json){
		PastPagerJson = json;
		currentNum = 0;
		totalNum = json.result.length;
		showInfo(currentNum,json,totalNum);	//显示第一题
	});
}
/*
 * 显示信息页
 */
function showInfo(currentNum,json,totalNum){
	var testPapeTitleUrl= json.result[currentNum].testPapeTitleUrl;			//题目图片路径
	var testPaperAnswerUrl= json.result[currentNum].testPaperAnswerUrl;  	//答案图片路径
	var testPaperId=json.result[currentNum].testPaperId;					//试卷id
	var testPaperNumber = currentNum+1;			//第几题
	var testPaperPictureid = json.result[currentNum].testPaperPictureid;	//试卷图片id
	
	
	$(".content").append(
	  	"<div class='titlepic' style='background:url("+testPapeTitleUrl+");background-size:100% 100%;'></div>"+
	  	"<div class='line'></div>"+
	  	"<div class='morediv' onclick='showmore()'>" +
	  		"<div class='more'><i class='iconfont' id='size2'>&#xf02a9;</i></div>"+
	  		"<div class='more'>答案与解析</div>"+
	  	"</div>"+
	  	"<div class='line'></div>"
	);

	$(".title_fix").append(
		"<div class='title' style='display:inline-block;margin-top:1em;font-size:3.0em;font-weight:bold;'>"+cutString(testPaperName,40)+"</div>"
	);
	$(".fix").append(
		"<div id='currentNum'>"+testPaperNumber+"/"+"</div>"+
		"<div class='totalNum'>"+totalNum+"</div>"
    )
    
}
/*
 * 显示更多
 */
function showmore(){
	var anspic = PastPagerJson.result[currentNum].testPaperAnswerUrl;
	$(".morediv").hide();
	$(".content").append(
		"<div class='anspic' style='background:url("+anspic+");background-size:100% 100%;background-repeat: no-repeat;'></div>"+
		"<div class='packup' onclick='hidemore()'>"+
			"<div class='more'><i class='iconfont'  id='size2'>&#xf02aa;</i></div>"+
			"<div class='more'>收起</div>"+
		"</div>"
	)
}
/*
 * 显示页码
 */

/*
 * 点击隐藏
 */
function hidemore(){
	$(".anspic").hide();
	$(".packup").hide();
	$(".morediv").show();
}
/*
 * 前一页
 */
function goback(){
	hidemore();
	currentNum--;
	if(currentNum>=0){
		var titleurl = PastPagerJson.result[currentNum].testPapeTitleUrl;
		//更新试题
		$(".titlepic").attr("style","background:url("+titleurl+") center no-repeat;background-size:100% 100%;");
		//更新页码
		document.getElementById('currentNum').innerHTML = "";
		document.getElementById('currentNum').innerHTML = PastPagerJson.result[currentNum].testPaperNumber+1+"/";
	}else{
		currentNum++;
	}
		
}
/*
 * 后一页
 */
function gonext(){
	hidemore();
	currentNum++;
	if(currentNum<totalNum){
		var titleurl = PastPagerJson.result[currentNum].testPapeTitleUrl;
		//更新试题
		$(".titlepic").attr("style","background:url("+titleurl+") center no-repeat;background-size:100% 100%;");
		//更新页码
		document.getElementById('currentNum').innerHTML = "";
		document.getElementById('currentNum').innerHTML = PastPagerJson.result[currentNum].testPaperNumber+1+"/";	
	}else{
		currentNum--;
	}
	
}

/*
 * 收藏按钮点击监听事件
 * 作者：鲍晓飞
 * 时间：2016年2月29日
 */
function collection(){
	if(userid!=0){
		if(isCollect){
			$.getJSON("./CancelCollenctStateServlet",
					{PaperId:pagerId,UserId:userid},function(json){
						if(json.result == true){
							$(".collect").
							attr("style","background:url(WeChat/image/w-wujiaoxing.png) center no-repeat;background-size:100%,100%;");
							isCollect = false;
							alert("取消收藏成功");
						}else{
							alert("取消收藏失败");
							isCollect = true;
						}
					});
		}else{
			$.getJSON("./CollectCreateServlet",
					{TestPaperId:pagerId,
				     Userid:userid,
				     CollectName:testPaperName},
				     function(json){
						if(json.result == true){
							$(".collect").
							attr("style","background:url(WeChat/image/r-wujiaoxing.png) center no-repeat;background-size:100%,100%;");
							isCollect = true;
							alert("收藏成功");
						}else{
							alert("收藏失败");
							isCollect = false;
						}
					});
			$(".collect").attr("style","background:url(WeChat/image/r-wujiaoxing.png) center no-repeat;background-size:100%,100%;");
		}
	}else{
		alert("请先登录！")
		window.location.href = "WeChat/jsp/logins.jsp";
	}
	
	
}
/*
 *根据用户Id判断用户是否收藏
 */
function CollectStateJudge(){

	if(userid!=0){
			$.getJSON("./CollectStateJudgeServlet",
					{PaperId:pagerId,UserId:userid},function(json){
						if(json.flag == true){
							$(".collect").
							attr("style","background:url(WeChat/image/r-wujiaoxing.png) center no-repeat;background-size:100%,100%;");
							isCollect = true;
						}else{
							isCollect = false;
						}
			});
		}
	
}


/**
 * 截取字符串
 * @param date
 * @param len
 * @return
 */
function cutString(date, len){
	//length属性读出来的汉字长度为1
	
    if(date.length*2 <= len) {
        return date;
    }
    var strlen = 0;
    var s = "";
    for(var i = 0;i < date.length; i++) {
        s = s + date.charAt(i);
        if (date.charCodeAt(i) > 128) {
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