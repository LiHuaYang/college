


$(document).ready(function(){
  shownavigation();
});

/**
 * 
 * 显示管理员页面，左侧导航条
 * 
 */
function shownavigation() {
	$.getJSON("../UserActionV2",{"method" : "AdminCheck"},function(json) {
		if (json.res=="true") {
			var privilege = json.data.privileges;
			indexof(privilege);
			alert("权限:"+privilege);
		} else {
			// 用户未登陆--跳转到登陆页面
			if (confirm("是否去登陆"))  {  
				window.location.href="../Front/Pages/login.html";
			} 
		}
	});
}

function indexof(privilege){
   var P=privilege;
   
   var b1 = P.indexOf("administrator");
   var b2 = P.indexOf("problem_editor");
   var b3 = P.indexOf("contest_creator");
   
   if(b1>=0){
	   $("#navigation").append(
				"<p>1.<a href='seefront.html' target='mainframe' ><button>查看前台</button></a></p>"+
//				"<p>2.<a onclick = alertwarming() target='mainframe' ><button>添加新闻</button></a></p>"+
//				"<p>3.<a onclick = alertwarming() target='mainframe' ><button>新闻列表</button></a></p>"+
				"<p>2.<a href='addProblem.html' target='mainframe' ><button>添加问题</button></a></p>"+
				"<p>3.<a href='problem_list.html' target='mainframe' ><button>问题列表</button></a></p>"+
				"<p>4.<a href='addContest.html' target='mainframe' ><button>添加竞赛&作业</button></a></p>"+
				"<p>5.<a href='Contest_list.html' target='mainframe' ><button>竞赛&作业列表</button></a></p>"+
//				"<p>8.<a onclick = alertwarming() target='mainframe' ><button>比赛队账号生成器</button></a></p>"+
//				"<p>10.<a onclick = alertwarming() target='mainframe' ><button>修改密码</button></a></p>"+
//				"<p>11.<a onclick = alertwarming() target='mainframe' ><button>重判题目</button></a></p>"+
				"<p>6.<a href='add_privilege.html' target='mainframe' ><button>添加权限</button></a></p>"+
				"<p>7.<a href='privilege_list.html' target='mainframe' ><button>权限列表</button></a></p>"
//				"<p>14.<a onclick = alertwarming() target='mainframe' ><button>转移源码</button></a></p>"+
//				"<p>15.<a onclick = alertwarming() target='mainframe' ><button>导出问题</button></a></p>"+
//				"<p>16.<a onclick = alertwarming() target='mainframe' ><button>导入问题</button></a></p>"
		)
   }
   else {
	   if(b2>=0&&b3<0){
		   $("#navigation").append(
					"<p>1.<a href='seefront.html' target='mainframe' ><button>查看前台</button></a></p>"+
					"<p>2.<a href='addProblem.html' target='mainframe' ><button>添加问题</button></a></p>"+
					"<p>3.<a href='problem_list.html' target='mainframe' ><button>问题列表</button></a></p>"
			)
	   }
	   if(b3>=0&&b2<0){
		   $("#navigation").append(
					"<p>1.<a href='seefront.html' target='mainframe' ><button>查看前台</button></a></p>"+
					"<p>2.<a href='problem_list.html' target='mainframe' ><button>问题列表</button></a></p>"+
					"<p>3.<a href='addContest.html' target='mainframe' ><button>添加竞赛&作业</button></a></p>"+
					"<p>4.<a href='Contest_list.html' target='mainframe' ><button>竞赛&作业列表</button></a></p>"
			)
	   }
	   if(b2>=0&&b3>=0){
		   $("#navigation").append(
					"<p>1.<a href='seefront.html' target='mainframe' ><button>查看前台</button></a></p>"+
					"<p>2.<a href='addProblem.html' target='mainframe' ><button>添加问题</button></a></p>"+
					"<p>3.<a href='problem_list.html' target='mainframe' ><button>问题列表</button></a></p>"+
					"<p>4.<a href='addContest.html' target='mainframe' ><button>添加竞赛&作业</button></a></p>"+
					"<p>5.<a href='Contest_list.html' target='mainframe' ><button>竞赛&作业列表</button></a></p>"
			) 
	   }
   }
}

function alertwarming() {
	alert("暂未开发！");
}
