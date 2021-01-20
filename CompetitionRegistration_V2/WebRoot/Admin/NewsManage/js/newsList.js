
$(document).ready(function() {
	// 绑定事件
	binding();
	// 初始化
	init();
	//alert(paging.currentPage);
});
$.ajaxSettings.async = false; // 关闭Jquery中的异步功能
//跳转到添加新闻页面
function addNews() {	
	window.location.href="Admin/NewsManage/jsp/AddNews.jsp";
}
function toModify(obj){
		var _table = obj.parentNode.parentNode;
	    var input = $(_table).children('td').eq(0).children('input');
	    if ($(input).attr('checked')){
	    	
	    	window.location.href="Admin/NewsManage/jsp/ModifyNews.jsp?NewsId="+
	    	$(obj).parent().parent().children().val();
	    }
	    else{
	    	alert("请选中你要修改的用户！！！");
	    }
	//alert($(id).parent().parent().children().val());
}
//事件绑定
function binding() {
	$("#btn_next_page").bind("click", nextPage);
	$("#btn_pre_page").bind("click", prePage);
}

//初始化数据
function init() {
	var json = { 
			"page" : paging.currentPage // 初始化为当前页数
		};
	var res = getData(json); // 获取当前页面数据

	showData(res);// 显示数据列表
	
}

/**
 * 获取数据列表
 * @param json
 * @return
 */
function getData(json) {
	var data = null;
	$.getJSON(
			"./GetAllNewsListServlet",
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
		$tr.children("#newsID").val("");
		$tr.children("#newstitle").html("");
		$tr.children("#puttime").html("");
		$tr.children("#state").html("");
	}
	
	for(var i=1; i<trs.length && j<jsonObject.length; i++,j++) {
		var $tr = $(trs[i]);
		$tr.children("#newsID").val(jsonObject[i-1].newsId);
		$tr.children("#newstitle").html(jsonObject[i-1].newsTitle);
		$tr.children("#puttime").html(jsonObject[i-1].newsPutTime);	
		$tr.children("#state").html(newsstate(jsonObject[i-1].newsSaveState));
	}
}
function newsstate(a){
	if(1 == a) return "正常";
	if(0 == a) return "已删除";
}
function newsremove(obj){
	  var _table = obj.parentNode.parentNode;
	    var id = 0;
	    
	    var input = $(_table).children('td').eq(0).children('input');
	    if ($(input).attr('checked')) {
	    	id = $(_table).children("#newsID").val(); // 获取当前选中用户的ID
	    	
	    	  var json = {
	    				"newsId" : id
	    	    }
	    	    
	    	   // alert("用户ID为" + id);
	    	    
	    	    $.getJSON("./ModifyNewsStateServlet",
	    				{
	    					json : JSON.stringify(json)
	    				},
	    				function(jsonObject) {
	    					
	    					if(jsonObject.flag){
	    						alert("删除成功！")
	    						location.reload(true);
	    					}
	    					else{
	    						alert("删除失败！")
	    					}
	    			});
	   }
	    else{
	    	alert("请选中你要删除的用户！！！");
	    }
	    
	  
	
}
/************************************************************************/

function nextPage() {
	//alert(paging.currentPage);
	paging.currentPage++;
	
	$("#current_page").val(paging.currentPage);
	
	var json = { 
			"page" : paging.currentPage
			}; 
	var res = getData(json);
	showData(res);
}

function prePage() {
	//alert(paging.currentPage);
	paging.currentPage--;
	
	if(paging.currentPage < 1) {
		paging.currentPage = 1;
	}
	$("#current_page").val(paging.currentPage);
	
	var json = { 
			"page" : paging.currentPage
			}; 
	var res = getData(json);
	showData(res);
}


