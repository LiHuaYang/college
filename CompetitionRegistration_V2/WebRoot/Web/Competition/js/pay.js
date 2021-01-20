



function pay () {
	$.getJSON("./WxNativePayToPayServlet", 
			{data : JSON.stringify(json)}, 
			function(jsonObject) {
				showCompetition (jsonObject.data);
				jcontestSet = jsonObject.data.contestSet;
		});	
}