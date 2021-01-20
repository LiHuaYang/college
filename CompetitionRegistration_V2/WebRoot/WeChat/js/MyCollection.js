$(document).ready(function(){
	showmycollection(baruserid);
});
function showmycollection(baruserid)
{
	
	$.getJSON("./GetCollectInfoByUseridServlet",{Userid:baruserid},function(json){
		
		for(var i=0; i<json.result.length;i++)			
		{			
			var collectName= json.result[i].collectName;		//试卷名称
			var collectTime= json.result[i].collectTime;    	//收藏时间
			var testPaperId = json.result[i].testPaperId;
			
			$(".ww").append("<div class='one' onclick='gotopaperdetails("+testPaperId+","+"\""+collectName+"\""+")'><div class='collectname' >"+collectName+"</div>"+
		     "<div class='collecttime'>"+'收藏时间：'+collectTime+"</div></div>")
		}
		
	});
}


function gotopaperdetails(pagerId,testPaperName){
	window.location.href="WeChat/jsp/PastYearsPagerDetail.jsp?pagerId="+pagerId+"&testPaperName="+testPaperName;
}