$(document).ready(function(){
	Page = 1;
	flag = 1;
	getPastYearsPagerList(Page);			//加载历年真题列表第一页
	searchTextPagersByCondition();      	//条件查找真题选择框(科目、年级、比赛)
	
	//定义下面菜单栏的字体颜色
	$(".gotoTest").css("color","#0075c3");
});
/*
 * 作者：鲍晓飞
 * 函数功能：获得历年真题列表
 * 所需参数：无
 * 返回值：历年真题列表
 * 创作时间：2016年2月27日
 */
function getPastYearsPagerList(Page){
		
		$.getJSON("./SearchTestNameTimeInfo",{page:Page},function(json){
			if(json.result.length != 0){   //内容不为空，加载数据
			 for(var i=0;i<json.result.length;i++){
				//var contestId= json.result[i].contestId;				//竞赛项目Id
				var testDifficulty= json.result[i].testDifficulty;    	//难度系数
				//var testKnowledgepoint=json.result[i].testKnowledgepoint;//知识点
				var testPaperId = json.result[i].testPaperId;			//试卷id
				var testPaperName = json.result[i].testPaperName;		//试卷名字	
				//var testPaperState= json.result[i].testPaperState;	//试卷状态
				var testPaperTime= json.result[i].testPaperTime;    	//试卷发布时间
				var testState=json.result[i].testState;					//年级类型
				var testSubject = json.result[i].testSubject;			//科目	
			//	var testYear = json.result[i].testYear;					//年份
				
				
				$("#pagerlist").append(
					  "<div class='pagerlistitem' style='width:100%;height:4em;margin-left:0px;display:inline-block;' onclick='itemClick("+testPaperId+","+"\""+testPaperName+"\""+")'>"+
						"<div style='height:2em;width:100%;display:inline-block;'>" +
							"<div class='pagerTitle'>"+cutString(testPaperName, 40) + testState+testSubject+"</div>"+
							"<div class='pagerdifficult'>"+'难度系数:'+testDifficulty+"</div>"+
						"</div>"+
						"<div style='height:2em;width:100%;display:inline-block;'>" +
							"<div class='pagertime'>"+testPaperTime+"</div>"+
						"</div>"+
				  		"<div class='line' style='height:1px;width:100%;background:#cecece;overflow:hidden;'></div>"+
				  	 "</div>"
				);
			 }
			}
			else{	//内容为空
				for(var i=0; i<flag; i++){
					$("#pagerlist").append(
						 "<div id='more'>没有更多</div>" 
					);
				}
				flag--;
			}
		});
}

/*
 * 函数功能：查找真题搜索框
 * 作者：鲍晓飞
 * 时间：2016年2月27日
 */
function searchTextPagers(){
	var subject_choo = document.getElementById('subject_choose').innerHTML;
	var grade_choo = document.getElementById('grade_choose').innerHTML;
	var competition_choo = document.getElementById('competition_choose').innerHTML;
	$.getJSON("./SearchPapaer",
			{ContestSubject:subject_choo,
		 	 page:1,
		 	 CompetitionName:competition_choo,
		 	 StudentGrade:grade_choo},
			 function(json){
		 		for(var i=0;i<json.message.length;i++){
					var testDifficulty= json.message[i].testDifficulty;    		//难度系数
					//var testKnowledgepoint=json.message[i].testKnowledgepoint;		//知识点
					var testPaperId = json.message[i].testPaperId;			//试卷id
					var testPaperName = json.message[i].testPaperName;		//试卷名字	
					//var testPaperState= json.message[i].testPaperState;		//试卷状态
					var testPaperTime= json.message[i].testPaperTime;    	//试卷发布时间
					var testState=json.message[i].testState;					//年级类型
					var testSubject = json.message[i].testSubject;			//科目	
					var testYear = json.message[i].testYear;					//年份
					//出错处理界面
					if(!testYear|| 
					   !testPaperName||
					   !testState|| 
					   !testSubject|| 
					   !testDifficulty|| 
					   !testPaperTime){
							document.getElementById('pagerlist').innerHTML="";
							document.getElementById('pagerlist').innerHTML="";
							//显示无数据界面
							$("#pagerlist").append(
								    "<div class='error_page'>没有符合条件的真题</div>"
							);
					}
					//添加新的真题数据到列表中
					else{
						document.getElementById('pagerlist').innerHTML="";
						$("#pagerlist").append(
							"<div class='pagerlistitem' style='width:100%;height:4em;margin-left:0px;display:inline-block;' onclick='itemClick("+testPaperId+","+"\""+testPaperName+"\""+")'>"+
								"<div style='height:2em;width:100%;display:inline-block;'>" +
									"<div class='pagerTitle'>"+testPaperName+ "</br>"+testSubject+"</br>"+"</div>"+
									"<div class='pagerdifficult'>"+'难度系数:'+testDifficulty+"</div>"+
								"</div>"+
								"<div style='height:2em;width:100%;display:inline-block;'>" +
									"<div class='pagertime'>"+testPaperTime+"</div>"+
								"</div>"+
								"<div class='line' style='height:1px;width:100%;background:#cecece;overflow:hidden;'></div>"+
							"</div>"
						);
					};
				}
		});
}
/*
 * 函数功能：条件查找真题选择框(科目、年级、比赛)
 * 作者：鲍晓飞
 * 时间：2016年3月1日
 */
function searchTextPagersByCondition(){
	var choosesubject;				//科目
	var choosegrade;				//成绩
	var choosecompetion;			//竞赛
	$.getJSON("./GetCompetitionProjectbyProjectId",function(json){
		for(var i=0; i<json.result.length; i++){
			$(".subject").append(
				"<option class='subject_item'>"+json.result[i].subjectName+"</option>"
			)
		}
	});
	$.getJSON("./GetCompetitionObjectbyObjectIdServlet",function(json){
		for(var i=0; i<json.result.length; i++){
			var gradestate;
			if(json.result[i].greadState==1){
				gradestate = "小学";
			}
			else if(json.result[i].greadState==2){
				gradestate = "初中";
			}
			else if(json.result[i].greadState==3){
				gradestate = "高中";
			}
			$(".grade").append(
				"<option class='subject_item'>"+gradestate+"</option>"
			)
		}
	});
	$.getJSON("./GetCompetitionNamebyNameIDServlet",function(json){
		for(var i=0; i<json.result.length; i++){
			$(".competion").append(
				"<option class='subject_item'>"+json.result[i].competitionBasicNickName+"</option>"
			)
		}
	});
}
/*
 * 判断option条目是否被点击
 */
function option_click(){
	choosesubject=$(".subject").find("option:selected").text();
	document.getElementById('subject_choose').innerHTML = "";
	$("#subject_choose").append(choosesubject);
}
function option_click1(){
	choosegrade=$(".grade").find("option:selected").text();
	document.getElementById('grade_choose').innerHTML = "";
	$("#grade_choose").append(choosegrade);
}
function option_click2(){
	choosecompetion=$(".competion").find("option:selected").text();
	document.getElementById('competition_choose').innerHTML = "";
	$("#competition_choose").append(choosecompetion);
}
/*
 * 函数功能：试题列表条目点击事件
 * 作者：鲍晓飞
 * 时间：2016年2月27日
 */
function itemClick(pagerId,testPaperName){
	
	window.location.href="WeChat/jsp/PastYearsPagerDetail.jsp?pagerId="+pagerId+"&testPaperName="+testPaperName;
}
/*
 * 滚动条在Y轴上的滚动距离
 */
function getScrollTop(){
	　　var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
	　　if(document.body){
	　　　　bodyScrollTop = document.body.scrollTop;		  //网页被卷去的高
	　　}
		//兼容性写法
	　　if(document.documentElement){					
	　　　　documentScrollTop = document.documentElement.scrollTop;
	　　}
		//取兼容性写法中值大的
	　　scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
	　　return scrollTop;
}
	
// 文档的总高度
function getScrollHeight(){
	　　var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
	　　if(document.body){
	　　　　bodyScrollHeight = document.body.scrollHeight;//网页正文全文高
	　　}
		//兼容性写法
	　　if(document.documentElement){
	　　　　documentScrollHeight = document.documentElement.scrollHeight;
	　　}
		//取兼容性写法中值大的
	　　scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
	　　return scrollHeight;
}

// 浏览器视口的高度
function getWindowHeight(){
	　　var windowHeight = 0;
	　　if(document.compatMode == "CSS1Compat"){						//严格模式
	　　　　windowHeight = document.documentElement.clientHeight;	//窗口当前高度
	　　}else{														//怪异模式
	　　　　windowHeight = document.body.clientHeight;
	　　}
	　　return windowHeight;
}		

/*
 *  判断是否到达页尾
 */
window.onscroll = function(){				//当window发生scroll事件时，调用该函数。
	　　if(getScrollTop() + getWindowHeight() == getScrollHeight()){//到达页面底部
			Page++;
			getPastYearsPagerList(Page);
		};
};


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