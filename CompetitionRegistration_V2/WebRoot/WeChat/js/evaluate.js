$(document).ready(function() {
	
	
})
//
//function alerts(){
//	
//	var options=$("#comscore option:selected");  //获取选中的项
//
//	alert(options.val());   //拿到选中项的值
//}

function changescorecom(){
	var options=$("#comscore option:selected");  //获取选中的项
	if(options.val()>=1&&options.val()<=2){
		$(".score_1_1").html("");
		$(".score_1_1").append("很差，浪费时间");
	}else if(options.val()>=3&&options.val()<=5){
		$(".score_1_1").html("");
		$(".score_1_1").append("平庸之作，不看也罢");
	}else if(options.val()>=6&&options.val()<=7){
		$(".score_1_1").html("");
		$(".score_1_1").append("一般，不妨一看");
	}else if(options.val()>=8&&options.val()<=10){
		$(".score_1_1").html("");
		$(".score_1_1").append("很完美，不容错过");
	}
	

}

function createcommit() {
	var options = $("#comscore option:selected").val(); // 选中项的值
	var context = $(".content").val(); // 评价内容

	if(userid==0){
		alert("请先登录")
	}else{

	$.ajax( {
		type : "GET",
		url : "./CommitCreateServlet",
		data : {
			CompetitionId : competitionId,
			Userid:userid,
			ContestCommitRank : options,
			ContestCommitInfo : context
		},
		dataType : "json",
		success : function(json) {
			if(json.result== true){
				alert("评论成功");
				window.history.go(-1);  
//				window.location.href = "WeChat/jsp/details.jsp?competitionId="+competitionId;
			}else{
				alert("评论失败")
			}

		}
	})
	}
}

//
////跳转到详情界面
//function todetails(competitionId){
//	window.location.href = "WeChat/jsp/details.jsp?competitionId="+competitionId;
//}