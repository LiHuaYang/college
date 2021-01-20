$(document).ready(function(){
	ShowContest();
	shownowtime();
});
function ShowContest()
{
	$.getJSON("../../ContestActionV2",{"method" : "getContestSet", "type":"user"},function(jsonArray){
			for(var i=0;i<jsonArray.length;i++)
				{
				var id = jsonArray[i].contest_id;
				var Pri = jsonArray[i].Private;
				var title = jsonArray[i].title;
				var start_time = jsonArray[i].start_time;
				var end_time = jsonArray[i].end_time;
				var creator = jsonArray[i].creator;
				$("#contestlist").append("<tr>"+
						"<td>"+id+"</td>"+
						"<td><a href='javascript:tocontest(\""+id+"\",\""+Pri+"\");'>"+title+"</a></td>"+
						"<td>"+Status(start_time,end_time)+"</td>"+
						"<td>"+Private(Pri)+"</td>"+
						"<td>"+creator+"</td>"
						)
				}
		});
}

function tocontest(id,Private) {
	switch (Private) {
		case "0" :
			window.location.href="Contest_problem.html?id="+id;
			break;
		case "1" :
		    window.location.href="inputContestPw.html?id="+id;
			break;
	}
}
function Status(start_time,end_time) {
	start_time = start_time.substring(0,19);
	end_time = end_time.substring(0,19);
	var now = new Date().getTime();
	var end = new Date(end_time).getTime();
	var start = new Date(start_time).getTime();
	if((now-end)>0){
		return "已结束@"+end_time;
		}
	if((start-now)>0)
		{
		return "开始于@"+start_time +" 总赛时"+time(start,end);
		}
	if((start-now)<0&&(now-end)<0)
		{
		return "运行中  剩余 "+time(now,end);
		}
       
}

function time(start,end){
	var sec = end-start;
	var day = parseInt(sec/1000/86400);
	  
	var hour =parseInt((sec/1000%86400)/3600);
	var min = parseInt(((sec/1000%86400)%3600)/60);
	var s = parseInt(((sec/1000%86400)%3600)%60);
	if(s==0){
		 if(min==0){
			 if(hour==0){
				 if(day==0)
					 {
					  return "0秒"
					 }
				 else{
					 return day+"天";
				     }
			   }
			 else{
				 return day+"天"+hour+"小时";
			     }
			 }
		 else
			 {
			 return day+"天"+hour+"小时"+min+"分";
			 }
		}
	else
		{
		return day+"天"+hour+"小时"+min+"分"+s+"秒";
		}
	
}
function Private(a)
{
   switch (a)
   {
   case 0: 
	   return "公有";
   case 1:
	   return "私有";
   }
}
function shownowtime(){
		function fillZero(v){
		if(v<10){v='0'+v;}
		return v;
		}
		(function(){
		var d=new Date();
		Y=d.getFullYear();
		M=fillZero(d.getMonth()+1);
		D=fillZero(d.getDate());
		H=fillZero(d.getHours());
		I=fillZero(d.getMinutes());
		S=fillZero(d.getSeconds());
		var time = Y+'-'+M+'-'+D+' '+H+':'+I+':'+S;
		// TODO:contest.js  -- document.getElementById("showtime").innerHTML="ServerTime:"+time;
//		document.getElementById("showtime").innerHTML="ServerTime:"+time;
		//每秒更新时间
		setTimeout(arguments.callee,1000);
		})();
		
	
}