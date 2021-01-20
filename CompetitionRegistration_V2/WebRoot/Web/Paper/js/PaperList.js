$(document).ready(function(){
	$("#MunePaper").attr("class", "curr");
	
//	Show_Paper_List();  //显示试卷列表
//	ShowSearchSubject();//显示科目
	
	ShowSearchName();  //显示搜索的名字
	ShowSearchYear();  //显示年份
	ShowSearchObject();//显示年级
});

var PaperId=new Array();     //试卷id
var PaperName=new Array();    //试卷名字


//显示试卷列表
function Show_Paper_List(){
	
	$.ajax({
		type: "GET",
		url: "./SearchTestNameTimeInfo",
		data:{page:1},
		dataType: "json",
		success: function(json){
			for ( var i = 0; i < json.result.length; i++) {
				PaperId[i]=json.result[i].testPaperId;
				PaperName[i]=json.result[i].testPaperName;
				$(".text_paper_box").append(
						'<div class="text_paper">'
							+'<div class="paper_name" onclick="Go_Paper_Detail('+i+')">'+json.result[i].testPaperName+'</div>'
							+'<div class="paper_time">'+json.result[i].testPaperTime+'</div>'
							+'<div class="paper_diff">'+json.result[i].testDifficulty+'级</div>'
						+'</div>'
				)
			}
		}
	})
}

//查询试卷总数来分页
function Get_Num_Paper(){
	
	$.ajax({
		type: "GET",
		url: "./GetSearchTestParperCountServlet",
		data:{ContestSubject:ContestSubject,CompetitionName:CompetitionName,StudentGrade:StudentGrade},
		dataType: "json",
		success: function(json){
			
			page_all=Math.ceil(json.result/10);
			for ( var i = 1; i <= page_all; i++) {
				
				$(".paper_page").append(
						'<div class="paper_num" onclick="paper_page_go('+i+')">'+i+'</div>'
				)
			}
			$(".paper_page").append(
					'<div class="paper_num2" onclick="paper_page_next()">></div>'
			)
		}
	})
}

var page=1;       //当前页
var next_page=0;   //下一页
var page_all=0;   //页数总数
//跳转到指定页数
function paper_page_go(i){
	
	page=i;
	if(CompetitionName=="大赛选择"){
		CompetitionName="";
	}
	if(ContestSubject=="年份选择"){
		ContestSubject="";
	}
	if(StudentGrade=="年级选择"){
		StudentGrade="";
	}
	$.ajax({
		type: "GET",
		url: "./SearchPapaer",
		data:{CompetitionName:CompetitionName,ContestSubject:ContestSubject,StudentGrade:StudentGrade,page:i},
		dataType: "json",
		success: function(json){
			if(json.flag==true){
				$(".text_paper_box").html("");//列表置空
				
				for ( var i = 0; i < json.result.length; i++) {
					PaperId[i]=json.result[i].testPaperId;
					PaperName[i]=json.result[i].testPaperName;
					$(".text_paper_box").append(
						'<div class="text_paper">'
							+'<div class="paper_name" onclick="Go_Paper_Detail('+i+')">'+json.result[i].testPaperName+'</div>'
							+'<div class="paper_time">'+json.result[i].testPaperTime+'</div>'
							+'<div class="paper_diff">'+json.result[i].testDifficulty+'级</div>'
						+'</div>'
					)
					
				}
				$(".gif").hide();
				
			}
			else{
				alert(json.message);
			}
		}
	});
}

//跳转到下一页
function paper_page_next(){
	
	next_page=page+1;
	if(next_page>page_all){
		alert("已经是最后一页了")
	}
	else{
		paper_page_go(next_page);
	}
}

//跳转到试卷详细界面
function Go_Paper_Detail(i){
	
	var id=new Number(PaperId[i]);    //转为int类型
	var name=new String(PaperName[i]);    //转为String类型
	window.location.href="Web/Paper/jsp/PaperDetail.jsp?paperid="+id+"&papername='"+name+"'";
}



//显示搜索的名字
function ShowSearchName(){
	$.ajax({
		type: "GET",
		url: "./GetCompetitionNamebyNameIDServlet",
		data:{},
		dataType: "json",
		success: function(json){
			for(var i=0;i<json.result.length;i++){
				$(".Test_Search_Name").append(
					'<option id="choice_com_option">'+json.result[i].competitionBasicName+'</option>'
				)
			}
		}
	});
}

//显示年份
function ShowSearchYear() {
	$.ajax({
		type: "GET",
		url: "./GetTestPaperYearbyObjectId",
		data:{},
		dataType: "json",
		success: function(json){
			for(var i=0;i<json.result.length;i++){
				$(".Test_Search_Year").append(
					'<option id="choice_com_option">'+json.result[i].yearData+'</option>'
				)
			}
		}
	});
}

//显示科目
function ShowSearchSubject() {
	$.ajax({
		type: "GET",
		url: "./GetCompetitionProjectbyProjectId",
		data:{},
		dataType: "json",
		success: function(json){
			for(var i=0;i<json.result.length;i++){
				$(".Test_Search_Subject").append(
					'<option id="choice_com_option">'+json.result[i].subjectName+'</option>'
				)
			}
		}
	});
}

//显示年级
function ShowSearchObject() {
	$.ajax({
		type: "GET",
		url: "./GetCompetitionObjectbyObjectIdServlet",
		data:{},
		dataType: "json",
		success: function(json){
			for(var i=0;i<json.result.length;i++){
				$(".Test_Search_Object").append(
					'<option id="choice_com_option">'+json.result[i].greadState+'</option>'
				)
			}
		}
	});
}

var CompetitionName; //大赛名字
var ContestSubject;  //科目
var StudentGrade;   //年级
//显示搜索后的试卷列表
function SearchTestParper(){
	CompetitionName=$(".Test_Search_Name").find("option:selected").text(); //大赛名字
	ContestSubject=$(".Test_Search_Year").find("option:selected").text();  //年份
	StudentGrade=$(".Test_Search_Object").find("option:selected").text();   //年级
	var page=1;   //页数
	
	if(CompetitionName=="大赛选择"){
		CompetitionName="";
	}
	if(ContestSubject=="年份选择"){
		ContestSubject="";
	}
	if(StudentGrade=="年级选择"){
		StudentGrade="";
	}
	$.ajax({
		type: "GET",
		url: "./SearchPapaer",
		data:{CompetitionName:CompetitionName,ContestSubject:ContestSubject,StudentGrade:StudentGrade,page:page},
		dataType: "json",
		success: function(json){
			if(json.flag==true){
				$(".text_paper_box").html("");//列表置空
				$(".paper_page").html("");//页数置空
				
				for ( var i = 0; i < json.result.length; i++) {
					PaperId[i]=json.result[i].testPaperId;
					PaperName[i]=json.result[i].testPaperName;
					$(".text_paper_box").append(
						'<div class="text_paper">'
							+'<div class="paper_name" onclick="Go_Paper_Detail('+i+')">'+json.result[i].testPaperName+'</div>'
							+'<div class="paper_time">'+json.result[i].testPaperTime+'</div>'
							+'<div class="paper_diff">'+json.result[i].testDifficulty+'级</div>'
							+'</div>'
					)
					
				}
				$(".gif").hide();
				
				Get_Num_Paper();    //页码
			}
			else{
				alert(json.message);
			}
		}
	});
	
	
}





