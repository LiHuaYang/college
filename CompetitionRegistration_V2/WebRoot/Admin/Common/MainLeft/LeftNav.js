var flag = new Array;//标记菜单展开状态，展开记为1，未展开记为0；
$(document).ready(function() {
	var URL=window.location.pathname;
	var B=URL.indexOf("BasicManage")
	var C=URL.indexOf("CompetitionManage");
	var O=URL.indexOf("OrderManage");
	var S=URL.indexOf("ShoppingManage");
	var U=URL.indexOf("UserManage");
	if(C!=-1){
		$("#left0 dd").hide();
		$("#left1 dd").show();
		$("#left2 dd").hide();
		$("#left3 dd").hide();
		$("#left4 dd").hide();
		$("#left5 dd").hide();
	}
	else if(U!=-1) {
		$("#left0 dd").hide();
		$("#left1 dd").hide();
		$("#left2 dd").show();
		$("#left3 dd").hide();
		$("#left4 dd").hide();
		$("#left5 dd").hide();
	}
	else if(O!=-1){
		$("#left0 dd").hide();
		$("#left1 dd").hide();
		$("#left2 dd").hide();
		$("#left3 dd").show();
		$("#left4 dd").hide();
		$("#left5 dd").hide();
	}
	else if(S!=-1){
		$("#left0 dd").hide();
		$("#left1 dd").hide();
		$("#left2 dd").hide();
		$("#left3 dd").hide();
		$("#left4 dd").show();
		$("#left5 dd").hide();
	}
	else if(B!=-1) {
		$("#left0 dd").show();
		$("#left1 dd").hide();
		$("#left2 dd").hide();
		$("#left3 dd").hide();
		$("#left4 dd").hide();
		$("#left5 dd").hide();
	}
	else{
		$("#left0 dd").hide();
		$("#left1 dd").hide();
		$("#left2 dd").hide();
		$("#left3 dd").hide();
		$("#left4 dd").hide();
		$("#left5 dd").hide();
	}
});


//菜单
function list(obj){
	switch (obj.id){
	case "item0":
		if(flag[5]!=1){
			$("#left0 dd").show();
			flag[5]=1;
		}
		else{
			flag[5]=0;
			$("#left0 dd").hide();
		}
		break;
	case "item1":
		if(flag[0]!=1){
			$("#left1 dd").show();
			flag[0]=1;
		}
		else{
			flag[0]=0;
			$("#left1 dd").hide();
		}
		break;
	case "item2":
		if(flag[1]!=1){
			$("#left2 dd").show();
			flag[1]=1;
		}
		else{
			flag[1]=0;
			$("#left2 dd").hide();
		}
		break;
	case "item3":
		if(flag[2]!=1){
			$("#left3 dd").show();
			flag[2]=1;
		}
		else{
			flag[2]=0;
			$("#left3 dd").hide();
		}
		break;
	case "item4":
		if(flag[3]!=1){
			$("#left4 dd").show();
			flag[3]=1;
		}
		else{
			flag[3]=0;
			$("#left4 dd").hide();
		}
		break;
	case "item5":
		if(flag[4]!=1){
			$("#left5 dd").show();
			flag[4]=1;
		}
		else{
			flag[4]=0;
			$("#left5 dd").hide();
		}
		break;
	}
	
}

//页面跳转

function load_list(obj){
	switch(obj.id){
	case "basic_competition_setting":
		window.location.href="Admin/BasicManage/jsp/WebData.jsp";
		break;
	case "basic_competition_data":
		window.location.href="Admin/BasicManage/jsp/CompetitionData.jsp";
		break;
	case "const_list":
		window.location.href="Admin/CompetitionManage/jsp/ContestList.jsp";
		break;
	case "const_people":
		window.location.href="Admin/CompetitionManage/jsp/ContenderList.jsp";
		break;
	case "const_score":
		window.location.href="Admin/CompetitionManage/jsp/ContestScore.jsp";
		break;
	case "store_user":
		window.location.href="Admin/UserManage/jsp/StoreUser.jsp";
		break;
	case "contest_person":
		window.location.href="Admin/UserManage/jsp/ContestPerson.jsp";
		break;
	case "work_person":
		window.location.href="Admin/UserManage/jsp/WorkPerson.jsp";
		break;
	case "wait_deal":
		window.location.href="Admin/OrderManage/jsp/WaitDealt.jsp";
		break;
	case "all_order":
		window.location.href="Admin/OrderManage/jsp/AllOrder.jsp";
		break;
	case "stocks_list":
		window.location.href="Admin/ShoppingManage/jsp/StocksList.jsp";
		break;
	case "today_add":
		window.location.href="Admin/ShoppingManage/jsp/TodayAdd.jsp";
		break;
	case "news_list":
		window.location.href="Admin/NewsManage/jsp/News.jsp";
		break;
		
	case "basic_competition_data":
		window.location.href="Admin/NewsManage/jsp/News.jsp";
		break;
	}
}