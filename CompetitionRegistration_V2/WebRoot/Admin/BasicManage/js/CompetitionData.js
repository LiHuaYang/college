
function conversion(a)
{
	if(a=="小学一年级")
		return 1;
	if(a=="小学二年级")
		return 2;
	if(a=="小学三年级")
		return 3;
	if(a=="小学四年级")
		return 4;
	if(a=="小学五年级")
		return 5;
	if(a=="小学六年级")
		return 6;
	if(a=="初中一年级")
		return 7;
	if(a=="初中二年级")
		return 8;
	if(a=="初中三年级")
		return 9;
	if(a=="高中一年级")
		return 10;
	if(a=="高中二年级")
		return 11;
	if(a=="高中三年级")
		return 12;
}
function againstconversion(a)
{
	if(a==1)
		return "小学一年级";
	if(a==2)
		return "小学二年级";
	if(a==3)
		return "小学三年级";
	if(a==4)
		return "小学四年级";
	if(a==5)
		return "小学五年级";
	if(a==6)
		return "小学六年级";
	if(a==7)
		return "初中一年级";
	if(a==8)
		return "初中二年级";
	if(a==9)
		return "初中三年级";
	if(a==10)
		return "高中一年级";
	if(a==11)
		return "高中二年级";
	if(a==12)
		return "高中三年级";
}
function Stationconversion(a)
{
	if(a==0)
		return "不可报名";
	if(a==1)
		return "可以报名";
	if(a=="不可报名")
		return 0;
	if(a=="可以报名")
		return 1;
}
$(document).ready(function() {
   ShowCompetitionBasicData();

})
function ShowCompetitionBasicData()
{
	/**
	 * 获得大赛名称和简称
	 * author:lujinye
	 */
	$.getJSON("./GetCompetitionNameServlet",{},function(json){	
		
		for(var i = 0 ; i < json.competitionbasicdata.length ; i++){			
			
			var competition_name = json.competitionbasicdata[i].competitionBasicName;
			
			var competition_simple_name = json.competitionbasicdata[i].competitionBasicNickName;
			$("#addcompetition table").append(
					"<tr>"+
				  	"<td style='width:3%;'></td>"+					  
				    "<td style='width:47%'>"+competition_name+"</td>"+
				    "<td style='width:55%'>"+competition_simple_name+"</td>"+
				    "</tr>")
		}	
	});
	
	/**
	 * 获得竞赛科目
	 * author:lujinye
	 */
	$.getJSON("./GetCompetitionProjectServlet", {},function(json) {
		for(var i = 0;i < json.subjectbasicdata.length; i++)
		{
			var competition_project = json.subjectbasicdata[i].subjectName;
			$("#Competition_project table").append(
					"<tr>"+
				  	"<td style='width:35px;'></td>"+					  
				    "<td>"+competition_project+"</td>"+
				    "</tr>");
		}
			
	});
	
	/**
	 * 获得竞赛对象
	 * author:lujinye
	 */
	$.getJSON("./GetCompetitionObjectServlet", {},function(json) {
		for(var i = 0; i < json.gradebasicdata.length; i++)
		{
			var competition_object = againstconversion(json.gradebasicdata[i].greadState);
			$("#Competition_object table").append(
					"<tr>"+
							  	"<td style='width:35px;'></td>"+					  
							    "<td>"+competition_object+"</td>"+
							    "</tr>");
		}
			
	});
	
	/**
	 * 获得承办方信息
	 * author:lujinye
	 */
	$.getJSON("./GetOrganizationInfo", function(jsonArray) {

		var length = jsonArray.length;
		for (i = 0; i < length; i++) {
			var Object = jsonArray[i];
		var Name = Object.organizationName;
		var Address = Object.organizationAddress;
		var Station = Stationconversion(Object.organizationStation);
		var Tel = Object.organizationTel;
		var Contacts = Object.organizationContacts;
		

		$("#competition_Organization table").append(
				"<tr class=''>"+
			  	"<td style='width:35px;'></td>"+					  
			    "<td style='width:100px'>"+Name+"</td>"+
			    "<td style='width:100px'>"+Address+"</td>"+
			    "<td style='width:100px'>"+Station+"</td>"+
			    "<td style='width:100px'>"+Tel+"</td>"+
			    "<td style='width:100px'>"+Contacts+"</td>"+
			    
			    "</tr>");
	}
});
}
function show_organization() {
	$("#add_ompetiton_name_panel").show();
}

function middleClose() {
	$(".bodymiddle").hide();
}

function add_competition_name()
{  
	var competition_name = $("#competition_name").val();
	var competition_simple_name =  $("#competition_simple_name").val();
	if(competition_name&&competition_simple_name){
	console.log("所要添加的大赛名：" + competition_name);
	console.log("所要添加的大赛简称：" + competition_simple_name);
	var json = new Object();

	json.competition_name = competition_name;
	json.competition_simple_name = competition_simple_name;
	console.log(json);
	$("#addcompetition table").append(
			"<tr class=''>"+
		  	"<td style='width:35px;'></td>"+					  
		    "<td>"+json.competition_name+"</td>"+
		    "<td>"+json.competition_simple_name+"</td>"+
		    "</tr>");
	$.getJSON("./AddCompetitionNameServlet", {
		json : JSON.stringify(json)
	}, function(jsonObject) {

		
	});
	}
	else {
		alert("大赛布恩那个为空。");
	}
}
function submit_competition_project()
{
	var competition_project = $("#competition_project").val();
	if(competition_project){
		var json = new Object();
		json.competition_project = competition_project;
		$("#Competition_project table").append(
				"<tr class=''>"+
				"<td style='width:35px;'></td>"+					  
				"<td>"+json.competition_project+"</td>"+
		"</tr>");
		$.getJSON("./AddCompetitionProjectServlet", {
			"json" : JSON.stringify(json) 
		}, function(jsonObject) {
		});
	}
	else {
		alert("科目不能为空");
	}
}
function submit_competition_object()
{
	var competition_object = $("#competition_object").val();
	if(competition_object){
		var json = new Object();
		json.competition_object = conversion(competition_object);
		$("#Competition_object table").append(
				"<tr class=''>"+
				"<td style='width:35px;'></td>"+					  
				"<td>"+competition_object+"</td>"+
		"</tr>");
		$.getJSON("./AddCompetitionObjectServlet", 
				{"json" : JSON.stringify(json)
				},
				function(jsonObject) {
				});
	}
	else {
		alert("对象不能为空");
	}
}
function submit_organizationInfo()
{
	var Name = $("#organization_name").val();
	var Address = $("#organization_address").val();
	var Station = $('#grade1 input[name="organization_station"]:checked ').val();
	var Tel = $("#organization_tel").val();
	var Contacts = $("#organization_contacts").val();
	if(Name&&Address&&Station&&Tel&&Contacts){
//		alert(Name);
//		alert(Address);
//		alert(Station);
//		alert(Tel);
//		alert(Contacts);

		var json = new Object();

		json.Name = Name;
		json.Address = Address;
		json.Station = Station;
		json.Tel = Tel;
		json.Contacts = Contacts;
		$("#competition_Organization table").append(
				"<tr class=''>"+
				"<td style='width:35px;'></td>"+					  
				"<td style='width:100px'>"+Name+"</td>"+
				"<td style='width:100px'>"+Address+"</td>"+
				"<td style='width:100px'>"+Station+"</td>"+
				"<td style='width:100px'>"+Tel+"</td>"+
				"<td style='width:100px'>"+Contacts+"</td>"+		    
		"</tr>");

		$.getJSON("./AddOrganizationInfoServlet", 
				{"json" : JSON.stringify(json)
				},
				function(jsonObject) {
				});
		$(".bodymiddle").hide();
	}
	else {
		alert("数据不能为空");
	}

}

