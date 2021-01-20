
$(document).ready(function() {
	// 绑定事件
	binding();
	// 初始化
	init();
	//alert(paging.currentPage);
})

$.ajaxSettings.async = false; // 关闭Jquery中的异步功能

var addUserUrl = "Admin/UserManage/jsp/AddUser.jsp";
var modifyUserUrl = "Admin/UserManage/jsp/Modify.jsp?UserId=";

function toaddUser() {
	window.location.href = addUserUrl; 
}
function toModify(id) {
	
	window.location.href = modifyUserUrl+$(id).parent().parent().children().val();
	//alert($(id).parent().parent().children().val());
}

function binding() {
	$("#btn_next_page").bind("click", nextPage);
	$("#btn_pre_page").bind("click", prePage);
}

/**
 * 获取数据列表
 * @param json
 * @return
 */
function getData(json) {
	var data = null;
	$.getJSON(
			"./UserSearchInfoServlet",
			{ json : JSON.stringify(json) },
			function(jsonObject) {
				data = jsonObject;
	});
	return data;
}
function getDataresult(json){
	var data = null;
	$.getJSON(
			"./UserSearchServlet",
			{ json : JSON.stringify(json) },
			function(jsonObject) {
				data = jsonObject;
	});
	return data;
}
/**
 * 显示数据列表
 * @param jsonObject
 * @return
 */
function showData(jsonObject) {
	var trs = $(".data-table tr"); 
	// 找到tr标签中所有的td标签
	var j = 0;
	
	// TODO: JS显示数据清空列表可以优化
	for(var i=1; i<trs.length; i++) {
		var $tr = $(trs[i]);
		$tr.children("#userID").html("");
		$tr.children("#user").html("");
		$tr.children("#nickname").html("");
		$tr.children("#grade").html("");
		$tr.children("#connect-people").html("");
		$tr.children("#connect-phone").html("");
		$tr.children("#teacher").html("");
		$tr.children("#teacher-phone").html("");
		$tr.children("#state").html("");
	}
	
	for(var i=1; i<trs.length && j<jsonObject.length; i++,j++) {
		var $tr = $(trs[i]);
		// alert(jsonObject[i-1].userId);
		$tr.children("#userID").val(jsonObject[i-1].userId);
		$tr.children("#user").html(jsonObject[i-1].userName);
		$tr.children("#nickname").html(jsonObject[i-1].userNickname);
		$tr.children("#grade").html(jsonObject[i-1].userGrade);
		$tr.children("#connect-people").html(jsonObject[i-1].userContactsMan);
		
		$tr.children("#connect-phone").html(jsonObject[i-1].userPhone);
		
		
		$tr.children("#teacher").html(jsonObject[i-1].userTeacher);
		$tr.children("#teacher-phone").html(jsonObject[i-1].userTeacherPhon);
		
		$tr.children("#state").html(userstate(jsonObject[i-1].userState));
	}
}
function userstate(a){
	if(1 == a)return "正常";
	if(0 == a) return "已删除";
}
/**
 * 页面初始化
 * @return
 */
function init() {
	var json = { 
//			"searchInfo" : 
//			{
//				"searchType" : "1",
//				"searchCondition" : "资优"
//			},
			"page" : paging.currentPage // 初始化为当前页数
			};
	var res = getData(json); // 获取当前页数
	showData(res);// 显示数据列表
}

/**
 * 数据列表点击事件
 * @param obj
 * @return
 */
function clickTr(obj) {
	do_onclick(obj);
	showDetail(obj);
}
/**
 * 显示详细信息
 * @param obj
 * @return
 */
function showDetail(obj) {
	var _table = obj.parentNode;
	var tt = $(_table);
	var id =  tt.children("#userID").val();
	var json = { "UserId" : id }; 
	$.getJSON("./UserSearchSingelCompetitionInfoServlet",
			{
				json : JSON.stringify(json)
			},
			function(jsonObject) {
				// 筛选出data-table类下面的，所有的tr标签
				var trs = $(".data-table tr"); 
				// 找到tr标签中所有的td标签
				for(var i=1; i<trs.length; i++) {
					var $tr = $(trs[i]);
					$("#contest_name").html(jsonObject[i-1].competitionName);
				}
		});
}

/**
 * 查询客户
 * @return
 */
function search(btn) {
	if(btn.id == "name") {
		searchType = 1; // 姓名模糊查询
	}
	var keyword = $("#name_keyword").val();
	if(keyword!="")
	{
		var json = { 
				"searchInfo" : 
				{
					"searchType" : searchType ,
					"searchCondition" : keyword
				},
				"page" : paging.currentPage
				}; 
		var res = getDataresult(json);
		showData(res);
	}
	else{
		alert("输入为空,请重新输入！！！");
	}
}

/************************************************************************/

function nextPage() {
	paging.currentPage++;
	
	searchType = 1;
	
	$("#current_page").val(paging.currentPage);
	
	var json = { 
//			"searchInfo" : 
//			{
//				"searchType" : searchType,
//				"searchCondition" : "资优"
//			},
			"page" : paging.currentPage
			}; 
	var res = getData(json);
	showData(res);
}

function prePage() {
	paging.currentPage--;
	
	if(paging.currentPage < 1) {
		paging.currentPage = 1;
	}
	searchType = 1;
	$("#current_page").val(paging.currentPage);
	
	var json = { 
//			"searchInfo" : 
//			{
//				"searchType" : searchType ,
//				"searchCondition" : "资优"
//			},
			"page" : paging.currentPage
			}; 
	var res = getData(json);
	showData(res);
}


	
function deleteSomeUser() {
//	var tbl=$(".data-table");
//	var trlist=tbl.find("tr");
//	
//	var tobedeleteArray = new Array();
//	
//	for(var i=1,j=0; i<trlist.length; i++)
// 	{
//      var tr = $(trlist[i]);
//      var input = tr.find("input[type='checkbox']");
//      if(input.is(':checked')) {
//    	  tobedeleteArray.push(i)
//      }
// 	}
	alert("功能待开发");
	
}

function deleteAUser(obj) {
    var _table = obj.parentNode.parentNode;
    var id = 0;
    
    var input = $(_table).children('td').eq(0).children('input');
    if ($(input).attr('checked')) {
    	id = $(_table).children("#userID").val(); // 获取当前选中用户的ID
    	  var json = { 
    				"ModifyType" : "1",
    				"UserId" : id
    	    }
    	    
    	    alert("用户ID为" + id);
    	    
    	    $.getJSON("./ModifyUser",
    				{
    					json : JSON.stringify(json)
    				},
    				function(jsonObject) {
    					
    					alert("服务器：" + jsonObject.flag);
    					location.reload(true);
    			});
   }
    else{
    	alert("请选中你要删除的用户！！！");
    }
    
  
}


function uploadUserInfo() {
	alert("功能待开发");
//	 $.getJSON("./ImportUserInfo",
//				function(jsonObject) {
//					// alert("服务器：" + jsonObject.flag);
//			});
}
function exportusers(){
	alert("功能待开发");
}











































































