$(function (){
	var json={
			"NewsId":jspNewsId
			};
	$.getJSON(
			"./GetNewsByNewsIdServlet",
			{ json : JSON.stringify(json) },
			function(json) {
				//alert(json.result[0].newsSource);
				
			$("#news_title").val(json.result[0].newsTitle);
			$("#news_content").val(json.result[0].newsContent);
			$("#news_add").val(json.result[0].newsExtralInfo);
			$("#news_type").val(json.result[0].newsState);
			$("#news_source").val(json.result[0].newsSource);
			//$("#news_pic").val();
			if(json.result[0].newsTop==1)$("#news_ishead").attr("checked",true);
	});
});
function ModifyANews(){
	var newstitle=$("#news_title").val();
	var newscontent=$("#news_content").val();
	var newsExtralInfo=$("#news_add").val();
	var newsState=$("#news_type").val();
	
	var newssource=$("#news_source").val();
	//var newspic=$("#news_pic").val(); 
	var newsTop=$("#news_ishead").is(':checked')?1:0;
	// alert(newsTop+newsState);
	var json = {
		"newsId":jspNewsId,
		"newstitle" : newstitle,
		"newscontent" : newscontent,
		"newsExtralInfo": newsExtralInfo,
		"newsState" :newsState,
		"newssource":newssource,	
		//"newspic" : newspic,
		"newsTop":newsTop
	};
//	alert(json.newscontent+newsTop);
	$.getJSON(
			"./ModifyNewsServlet",
			{ json : JSON.stringify(json) },
			function(json) {
				if(json.flag){
					alert("修改成功！");
					location.reload(true);
				}
				else{
					alert("修改失败！");
				}
	});
}
function save(){
	alert("功能待开发");
}