$(function() { 
	$("#header").append(
			'<!DOCTYPE html> <html>  <head>   <meta charset="UTF-8" />   <title>Insert title here</title>   <style> ul { border: 1px solid #CCC; padding:10px; margin:0; display:inline-block; width:auto;} ul li { float:left;list-style: none;margin:8px;}     #head-wrap {text-align:center;}     </style>  </head>   <body>  	 <div id="head-wrap"> 	  <ul> 		   <li> <a href="javascript:to_problem();">问题</a> </li> <li> <a href="javascript:to_solution();">状态</a> </li>    <div style="clear: both"></div> 	  </ul>    	 </div>  </body> </html>'	
			);
	}
);

function to_problem() {
	window.location.href = "Contest_problem.html?id="+contestId;	
}
function to_solution() {
	window.location.href = "Contest_solution.html?id="+contestId;
}

