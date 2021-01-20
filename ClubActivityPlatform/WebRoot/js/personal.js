$(document).ready(function(){
	$(".heads").load("jsp/common/bar.jsp");
	showuserinfo();
	$(".ppb div").eq(0).attr("id","mn");
	getuserinfo();
	 getmymission();
	 getuserpart();
	 getuseractivity();
	 getplan();
	 getalluser();

})
//显示用户信息
function showuserinfo(x) {
	$(".personinfos").show();
	$(".mypart").hide();
	$(".mytask").hide();
	$(".mymessage").hide();
	$(".myactivity").hide();
	$(".myplan").hide();
	$("#mn").attr("id","");
	$(x).attr("id","mn");
}
//显示任务
function showmymission(x) {
	$(".personinfos").hide();
	$(".mypart").hide();
	$(".mytask").show();
	$(".mymessage").hide();
	$(".myactivity").hide();
	$(".myplan").hide();
	$("#mn").attr("id","");
	$(x).attr("id","mn");
}
//显示加入的部门
function showuserpart(x) {
	$(".personinfos").hide();
	$(".mypart").show();
	$(".mytask").hide();
	$(".mymessage").hide();
	$(".myactivity").hide();
	$(".myplan").hide();
	$("#mn").attr("id","");
	$(x).attr("id","mn");
}
//显示加入的活动
function showuseractivity(x) {
	$(".personinfos").hide();
	$(".mypart").hide();
	$(".mytask").hide();
	$(".mymessage").hide();
	$(".myactivity").show();
	$(".myplan").hide();
	$("#mn").attr("id","");
	$(x).attr("id","mn");
}
//显示加入的活动
function showmessage(x) {
	$(".personinfos").hide();
	$(".mypart").hide();
	$(".mytask").hide();
	$(".mymessage").show();
	$(".myactivity").hide();
	$(".myplan").hide();
	$("#mn").attr("id","");
	$(x).attr("id","mn");
	
}
//显示任务方案
function showplan(x) {
	$(".personinfos").hide();
	$(".mypart").hide();
	$(".mytask").hide();
	$(".mymessage").hide();
	$(".myactivity").hide();
	$(".myplan").show();
	$("#mn").attr("id","");
	$(x).attr("id","mn");
}
/*
 * 个人资料界面
 */
var user;
//获取用户资料
function getuserinfo( ) {
	var json={
			"userId":myuserid1
	}
	if (myuserid1!=0) {
		$.getJSON("./GetUserById",{json:JSON.stringify(json)},function(json){
			user=json;
			$(".bac-pic").css("background-image","url('"+json.userPic+"')");
			      
			$(".myname").html("姓名："+json.userName);
			if (json.userSex==0) {
				$(".mysex").html("性别：男")
			}else {
				$(".mysex").html("性别：女")
			}
			$(".mymajor").html("专业："+json.userMajor);
			$(".myphone").html("电话："+json.userPhone);
			$(".myroll").html("学号："+json.userRoll);
			$(".myaddress").html("地址："+json.userAddress);
			$(".myemail").html("邮箱："+json.userEmail);
			$(".mycontent").html("个性签名:</br>"+json.userSignature);
			
				
	})
	}
}
function getalluser() {
	$.getJSON("./getAllUserName",function(json){
		allusername=json;
	})
	
}


//点击修改
function changeuserinfo() {
	$(".userblack").show();
	$(".img").css("background-image","url('"+user.userPic+"')");
	 $(".img").attr("img",user.userPic);
	$(".myname0 input").val(user.userName);
	if (user.userSex==0) {
		$(".man").attr("selected","selected");
	}else {
		$(".women").attr("selected","selected");
	}
	$(".mymajor0 input").val(user.userMajor);
	$(".myphone0 input").val(user.userPhone);
	$(".mypassword0 input").val(user.userPassword);
	$(".myaddress0 input").val(user.userAddress);
	$(".myemail0 input").val(user.userEmail);
	$(".con1").html(user.userSignature);
}
//取消修改资料
function resetbak() {
	$(".userblack").hide();
}
//确定修改资料
function userok() {
	var json={
			"userId":myuserid1,
			"userAddress":$(".myaddress0 input").val(),
			"userEmail":$(".myemail0 input").val(),
			"userMajor":$(".mymajor0 input").val(),
			"userName":$(".myname0 input").val(),
			"userPassword":$(".mypassword0 input").val(),
			"userPhone":$(".myphone0 input").val(),
			"userPic": $(".img").attr("img"),
			"userRoll":user.userRoll,
			"userSex":$(".mysex0 select option:selected").val(),
			"userSignature":$(".con1").html()
	}
	$.getJSON("./ChangeUser",{json:JSON.stringify(json)},function(json){
		
		 if (json.result==true) {
			 alert("修改成功!")
			 $(".userblack").hide();
			 $(".barusername").html($(".myname0 input").val());
			 $(".baruserpic").css("background-image","url('"+$(".img").attr("img")+"')");
			 getuserinfo();
		 }
		 else {
			 alert("修改失败")
		}
	})
}


/**
 * 任务界面
 */
var missionlist=new Array();
var nowpage=0;
var page=0;
//显示我收到的任务
function getmymission() {
	var json={
			"missionExecutorId":myuserid1
	}
	
	$.getJSON("./GetMissionBymissionExecutorId",{json:JSON.stringify(json)},function(json){
		$(".tasklist").html("");
		$("#numbh").html(json.length);
		missionlist=json;
		var max=4;
		if (json.length<max) {
			max=json.length
		}
		for ( var i = 0; i < max; i++) {
			
		
			var result='<div class="taskbutton" onclick="solveresult('+json[i].missionId+',this,'+missionlist[i].planId+')" >提交总结</div>';
			if (json[i].missionResult!=null&&json[i].missionResult!="") {
				result='<div class="taskshowresult" onclick="showresult('+i+',this)">查看总结</div>'

			}else if (json[i].missionType==0) {
				result='';
			}
			$(".tasklist").append('<div class="task-one">'+
						'<div class="task-one-title" ><div class="taskCreator">任务发起人：<font>'+json[i].userName+'</font></div><div class="tasktime">任务发起时间：<font>'+json[i].missionTime+'</font></div></div>'+
							'<div class="taskcontent">'+json[i].missionContent+'</div>'+
							'<div class="task-one-end"><div class="taskCreator">来自：<font>'+json[i].planName+'</font></div>'+result+'</div>'+
						'</div>')
		}
	    page=Math.ceil(json.length/4);
		$(".pagecount").html("")
	 	$(".pagecount").append('<font style="color: black;font-size: bold;"onclick=" changepage(0)">1</font>');
	    for ( var i = 1; i < page; i++) {
	    	var x=i+1;
	    	$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>');
		}
	
	})
		
}
function nextpage() {
	if (nowpage<page-1) {
	
		nowpage++;
		changepage(nowpage);
	}
	
}
function prevpage(){
	if (nowpage>0) {
		nowpage--;
		changepage(nowpage);
	}
}
//更改页码
function changepage(num) {
	nowpage=num;
		var min=num*4;
		var max=num*4+4;
		if (max>missionlist.length) {
			max=missionlist.length;
		}
		$(".tasklist").html("");
	 for ( var i = min; i <max ; i++) {
			var result='<div class="taskbutton" onclick="solveresult('+missionlist[i].missionId+',this,'+missionlist[i].planId+')" >提交总结</div>';
			if (missionlist[i].missionResult!=null) {
				result='<div class="taskshowresult" onclick="showresult('+i+',this)">查看总结</div>'

			}else if (missionlist[i].missionType==0) {
				result='';
			}
			$(".tasklist").append('<div class="task-one">'+
						'<div class="task-one-title" ><div class="taskCreator">任务发起人：<font>'+missionlist[i].userName+'</font></div><div class="tasktime">任务发起时间：<font>'+missionlist[i].missionTime+'</font></div></div>'+
							'<div class="taskcontent">'+missionlist[i].missionContent+'</div>'+
							'<div class="task-one-end"><div class="taskCreator">来自：<font>'+missionlist[i].planName+'</font></div>'+result+'</div>'+
						'</div>')	}
	 $(".pagecount").html("");
	 
	  for ( var i = 0; i < page; i++) {
	    	var x=i+1;
	    	if (i==num) {
	    		$(".pagecount").append(' <font style="color: black;font-size: bold;" onclick=" changepage('+i+')">'+x+'</font>');
			}else {
				$(".pagecount").append(' <font onclick=" changepage('+i+')">'+x+'</font>');
			}
	    	
	}
}
//打开提交总结界面
function solveresult(missionId,x,planId) {
	$(".missionbac").show();
	$(".task-content").html($(x).parent().parent().find(".taskcontent").html());
	$(".task-content").attr("missionId",missionId);
	$(".task-content").attr("planId",planId);
	$(".mmza").show();
}
//打开查看总结界面
function showresult(i,x) {
	$(".missionbac").show();
	$(".task-content").html($(x).parent().parent().find(".taskcontent").html());
	$(".result-content").html(missionlist[i].missionResult);
	$(".result-content").attr("contenteditable","false")
	$(".mmza").hide();
}
//关闭总结界面
function closeb() {
	$(".missionbac").hide();
}
//总结提交
function commitresult() {
	var json={
			"missionId":$(".task-content").attr("missionId"),
			"planId":$(".task-content").attr("planId"),
			"missionResult":$(".result-content").html()
	
	}
	
	$.getJSON("./SumbitActivityMissionResult",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			closeb();
			getmymission();
		}
		else {
			alert("无法提交");
		}
	})
	
}


/*
 * 参加的社团部门界面
 */
var Organization;
var Department;
var Corporation;
function getuserpart() {
	var json={
			"userId":myuserid1
	}
	$(".partlist").html("");
	$.getJSON("./GetUserPart",{json:JSON.stringify(json)},function(json){
		Organization=json.Organization;
		Department=json.Department;
		Corporation=json.Corporation;
		for ( var i = 0; i < Organization.length; i++) {
			var usergrade="副主席";
			if (Organization[i].grade.userGrade==6) {
				usergrade="主席";
				
			}
			$(".partlist").append('<div class="part-one">'+
						'<div class="part-one-pic" style="background-image:url('+Organization[i].organizationPic+')">'+
							'<div class="part-name">'+Organization[i].organizationName+'</div>'+
						'</div>'+
						'<div class="partgrade">'+
							'<div class="partimgback">'+
								'<div class="partgradepic"style="background-image:url('+Organization[i].grade.gradePic+')">'+
									'<div style="height: 24px;overflow: hidden;">'+
										'<div class="usergradename">'+usergrade+'</div>'+
									'</div>'+
								'</div>'+
								
							'</div>'+
							'<div class="gradetex" >'+Organization[i].grade.gradeContent+'</div>'+
							'<div class="gradebu"><button onclick="changegradeinfo(this,'+Organization[i].grade.gradeId+')">修改资料</button><button onclick="tomanage('+Organization[i].grade.userGrade+','+Organization[i].grade.gradeBelongId+','+Organization[i].grade.gradeBelongType+')">进入管理</button></div>'+
						'</div>'+
					'</div>')
		}
		for ( var i = 0; i < Department.length; i++) {
			var usergrade="部长";
			if (Department[i].grade.userGrade==3) {
				usergrade="常副";	
			}else if (Department[i].grade.userGrade==2) {
				usergrade="副部长";
			}else if (Department[i].grade.userGrade==1) {
				usergrade="干事";
			}
			$(".partlist").append('<div class="part-one">'+
						'<div class="part-one-pic" style="background-image:url('+Department[i].departmentPic+')">'+
							'<div class="part-name">'+Department[i].departmentName+'</div>'+
						'</div>'+
						'<div class="partgrade">'+
							'<div class="partimgback">'+
								'<div class="partgradepic"style="background-image:url('+Department[i].grade.gradePic+')">'+
									'<div style="height: 24px;overflow: hidden;">'+
										'<div class="usergradename">'+usergrade+'</div>'+
									'</div>'+
								'</div>'+
								
							'</div>'+
							'<div class="gradetex" >'+Department[i].grade.gradeContent+'</div>'+
							'<div class="gradebu"><button onclick="changegradeinfo(this,'+Department[i].grade.gradeId+')">修改资料</button><button onclick="tomanage('+Department[i].grade.userGrade+','+Department[i].grade.gradeBelongId+','+Department[i].grade.gradeBelongType+')">进入管理</button></div>'+
						'</div>'+
					'</div>')
		}

		for ( var i = 0; i < Corporation.length; i++) {
			var usergrade="社长";
			if (Corporation[i].grade.userGrade==3) {
				usergrade="副社长";	
			}else if (Corporation[i].grade.userGrade==2) {
				usergrade="骨干";
			}else if (Corporation[i].grade.userGrade==1) {
				usergrade="成员"; 
			}
			$(".partlist").append('<div class="part-one">'+
						'<div class="part-one-pic" style="background-image:url('+Corporation[i].corporationPic+')">'+
							'<div class="part-name">'+Corporation[i].corporationName+'</div>'+
						'</div>'+
						'<div class="partgrade">'+
							'<div class="partimgback">'+
								'<div class="partgradepic"style="background-image:url('+Corporation[i].grade.gradePic+')">'+
									'<div style="height: 24px;overflow: hidden;">'+
										'<div class="usergradename">'+usergrade+'</div>'+
									'</div>'+
								'</div>'+
								
							'</div>'+
							'<div class="gradetex" >'+Corporation[i].grade.gradeContent+'</div>'+
							'<div class="gradebu"><button onclick="changegradeinfo(this,'+Corporation[i].grade.gradeId+')">修改资料</button><button onclick="tomanage('+Corporation[i].grade.userGrade+','+Corporation[i].grade.gradeBelongId+','+Corporation[i].grade.gradeBelongType+')">进入管理</button></div>'+
						'</div>'+
					'</div>')
		}
	})
}

function tomanage(grade,mybelongId,mybelongType) {
	window.location.href="jsp/manage.jsp?mygrade="+grade+"&mybelongId="+mybelongId+"&mybelongType="+mybelongType;
}

//打开修改职位信息
function changegradeinfo(x,id) {
	$(".gradebac").show();
	$(".gradeimg").css("background-image",$(x).parent().parent().find(".partgradepic").css("background-image"));
	 $(".gradeimg").attr("img",$(x).parent().parent().find(".partgradepic").css("background-image"));
	$(".grade-content").html($(x).parent().parent().find(".gradetex").html());
	$(".grade-content").attr("gradeId",id);
}

//关闭修改职位信息
function closeg() {
	$(".gradebac").hide();
}
//确定职位修改
function surechangegradeinfo(x) {
	var json={
			"gradeId":$(".grade-content").attr("gradeId"),
			"gradeContent":$(".grade-content").html(),
			"gradePic": $(".gradeimg").attr("img")
	
	}
	
	$.getJSON("./ChangeGradeDatum",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("成功")
			closeg();
			getuserpart();
		}
		else {
			alert("无法提交");
		}
	})
}
/**
 * 获取用户参加的活动
 */
function getuseractivity() {
	var json={
			"userId":myuserid1
	}
	if (myuserid1!=0) {
		$.getJSON("./GetActivityByUser",{json:JSON.stringify(json)},function(json){
			for ( var i = 0; i < json.length; i++) {
				var activitystate='<div style="margin-top:4px;text-indent: 0em;font-size:12px;border-radius:5px;background:red;color:white;width:80px;float:right;text-align:center;margin-right:10px;">火热进行中</div>';
		    	if (json[i].activityState==6) {
		    		activitystate='<div style="margin-top:4px;text-indent: 0em;font-size:12px;border-radius:5px;background:rgb(150,150,150);color:white;;width:50px;float:right;text-align:center;margin-right:10px;">已结束</div>';
				}
		    	var text=json[i].activestageContent;
		    	 if (json[i].activestageContent.length>100) {
		    		 text=json[i].activestageContent.substring(0,100)+"...";
				}
				$(".partactlist").append('<div class="partact-one">'+
   									'<div class="partact-one-pic" style="background-image:url('+json[i].activestagePic+')">'+
   										
   									'</div>'+
   									'<div class="partact-one-more">'+
   									'	<div class="partact-one-title">'+json[i].activityName+activitystate+'</div>'+
   									'	<div class="partact-one-content">'+text+'</div>'+
   									'</div>'+
   								'	<div class="partact-one-button" onclick="toactivityd('+json[i].activityId+')">进入</div>'+
   								'</div>')
			}
		})
	}
}
function toactivityd(x) {
	window.location.href="jsp/activity.jsp?myactivityId="+x;
} 


/**
 * 显示信息
 * @return
 */
function getmessage() {
	alert("努力创作中")
}


/**
 * 显示任务方案
 * @return
 */
var Plan;
function getplan() {
	var json={
			"planCreatorId":myuserid1
	}
	$(".myplan-list").html("");
	if (myuserid1!=0) {
		$.getJSON("./GetPlanByPlanCreatorId",{json:JSON.stringify(json)},function(json){
			Plan=json;
			for ( var i = 0; i < json.length; i++) {
				var text='<div class="mp" onclick="showplanmissions('+i+')">查看</div>';
				if (json[i].Missions.length==0&&json[i].Plan.activityId==0) {
					text='<div class="mp" onclick="deleteplan('+json[i].Plan.planId+')">删除</div>'+text;
				}
				$(".myplan-list").append('<div class="myplan-one">'+
							'<div class="myplan-one-left">'+
								'<div class="myplan-onetitle">'+json[i].Plan.planName+'<div style="width: 200px;float:right;font-size:13px">所属活动：<font class="belongactivity">'+json[i].activityName+'</font></div></div>'+
								'<div class="myplan-onecontent">'+json[i].Plan.planContent+'</div>'+
							'</div>'+
							'<div class="myplan-one-right">'+text+''+
									
							'</div>'+
					'	</div>	');
			}
		})
	}
}
//通过ID查询用户名
function getusername(userid) {
	for ( var i = 0; i <allusername.length; i++) {
		if (userid==allusername[i].userId) {
			return allusername[i].userName;
		}
	}
}
var allusername;
//查看任务方案
function showplanmissions(x) {
	$(".planbac").show();
	$(".plan-tablename").attr("planId",Plan[x].Plan.planId);
	$(".plan-tablename").html(Plan[x].Plan.planName);
	$(".plan-content").html(Plan[x].Plan.planContent);
	$(".ms-list").html("");
	for ( var i = 0; i < Plan[x].Missions.length; i++) {
		 var name=getusername(Plan[x].Missions[i].missionExecutorId)
		 var p="总结："
		 if (Plan[x].Missions[i].missionType==0) {
			p="无需总结"
		}
		$(".ms-list").append('<div class="ms-one">'+
				'<div class="ms-onetitle"><font>接受者：'+name+'</font><i class="iconfont zoon" style="float: right;margin-left:10px;cursor: pointer;" onclick="deletethis(this)">&#xf00b3;</i>    <font style="float: right;"></font>    </div>'+
					'<div class="ms-onecontent">'+
				'<div class="ms-onecontent1"><div>内容：</div><div class="conms1">'+Plan[x].Missions[i].missionContent+'</div></div>'+
				'<div class="ms-onecontent2"><div>'+p+'</div><div class="resu1">'+Plan[x].Missions[i].missionResult+'</div></div>'+
				'</div>'+
				'</div>')
	}
	if (!Plan[x].PlanChangeType) {
		$(".plan-tablename").attr("contenteditable",false);
		$(".plan-content").attr("contenteditable",false);
		$(".fd").hide();
	/*	*/
	}else {
		$(".plan-tablename").attr("contenteditable",true);
		$(".plan-content").attr("contenteditable",true);
		$(".fd").show();
	/*	*/
	}
	if (Plan[x].PlanChangeType||Plan[x].Missions.length==0) {
		$(".onc").show();
		$(".ms-onetitle").find("i").show();
		$(".partsel").html("");
		if (Plan[x].activityBelongId==0) {
			for ( var i = 0; i < Organization.length; i++) {
				if (Organization[i].grade.userGrade<10) {
					var gradename=getgradename(2, Organization[i].grade.userGrade);
					$(".partsel").append('<option value ='+Organization[i].organizationId+' belongtype="2" grade='+Organization[i].grade.userGrade+'>'+Organization[i].organizationName+gradename+'</option>');

				}	
			}
		
			for ( var i = 0; i < Department.length; i++) {
				var gradename=getgradename(0, Department[i].grade.userGrade);
				$(".partsel").append('<option  value ='+Department[i].departmentId+'  belongtype="0" grade='+Department[i].grade.userGrade+'>'+Department[i].departmentName+gradename+'</option>');
			}
			for ( var i = 0; i < Corporation.length; i++) {
				if (Organization[i].grade.userGrade<10) {
				var gradename=getgradename(1, Corporation[i].grade.userGrade);
				$(".partsel").append('<option  value ='+Corporation[i].corporationId+'  belongtype="1" grade='+Corporation[i].grade.userGrade+'>'+Corporation[i].corporationName+gradename+'</option>');
			
				}
			}
		
		}else {
			for ( var i = 0; i < Organization.length; i++) {
			if (Plan[x].activityBelongId==Organization.organizationId) {
				if (Organization[i].grade.userGrade<10) {
					var gradename=getgradename(2, Organization[i].grade.userGrade);
					$(".partsel").append('<option value ='+Organization[i].organizationId+' belongtype="2" grade='+Organization[i].grade.userGrade+'>'+Organization[i].organizationName+gradename+'</option>');
					
				}
			}
			}
		}
	}else {
		$(".onc").hide();
		$(".ms-onetitle").find("i").hide();
	}
	
	
	
	
}
function closeplanbac(){
	$(".planbac").hide();
}
function deletethis(x) {
	$(x).parent().parent().remove();
}
//显示添加子任务
function openmb() {
	$(".createmissionb").show();
	$(".zxcd").html("任务内容");
	var json={
			"corporationId":$(".partsel option:selected").val()
	}
	var load="./GetCorporationMembers";
	if ($(".partsel option:selected").attr("belongtype")==2) {
		load="./GetOrganizationMember";
		json={
				"organizationId":$(".partsel option:selected").val()
		}
	}else if ($(".partsel option:selected").attr("belongtype")==0) {
		load="./GetDepartmentMembers";
		json={
				"departmentId":$(".partsel option:selected").val()
		}
	}
	var type=$(".partsel option:selected").attr("belongtype");
	var belongid=$(".partsel option:selected").val();
	var belongname=$(".partsel option:selected").text();
	$.getJSON(load,{json:JSON.stringify(json)},function(json){
		$(".els").html("");
		var mygrade=$(".partsel option:selected").attr("grade");
		for ( var i = 0; i < json.length; i++) {
			var pgrade=json[i].userGrade;
				var name=json[i].userName;
				if (type==0) {
					var gradename=getgradename(0, pgrade);
					name=gradename+name;
					if (pgrade<mygrade) {
						$(".els").append('<option  value ='+json[i].userId+'>'+name+'</option>');
					}
				}else if (type==1) {
					var gradename=getgradename(1, pgrade);
					name=gradename+name;
					if (pgrade<mygrade) {
						$(".els").append('<option  value ='+json[i].userId+'>'+name+'</option>');
					}
					if (mygrade>=3&&pgrade>=10) {
						$(".els").append('<option  value ='+json[i].userId+'>'+name+'</option>');
					}
				}else {
					var gradename=getgradename(2, pgrade);
					name=gradename+name;
					if (pgrade==4) {
						name=json[i].departmentName+name;
					}
					if (pgrade<mygrade) {
						$(".els").append('<option  value ='+json[i].userId+'>'+name+'</option>');
					}
					if (pgrade>=10) {
						$(".els").append('<option  value ='+json[i].userId+'>'+name+'</option>');
					}
				}
				
			
		}
		
	})
	
}

//获取职位名称
function getgradename(type,grade) {
	var gradename="";
	if (type==0) {
		switch (grade) {
		case 1:
			gradename="干事"
			break;
		case 2:
			gradename="副部长"
			break;
		case 3:
			gradename="常副"
			break;
		case 4:
			gradename="部长"
			break;
		default:
			break;
		}
	}else if(type==1){
		switch (grade) {
		case 1:
			gradename="成员"
			break;
		case 2:
			gradename="骨干"
			break;
		case 3:
			gradename="副社长"
			break;
		case 4:
			gradename="社长"
			break;
		case 10:
			gradename="公告管理人"
			break;
		case 12:
			gradename="器材管理人";
			break;
		case 13:
			gradename="资金管理人";
			break;
		default:
			break;
		}
	}else {
		switch (grade) {
		case 4:
			gradename="部长"
			break;
		case 5:
			gradename="副主席"
			break;
		case 6:
			gradename="主席"
			break;
		case 10:
			gradename="公告管理人"
			break;
		case 11:
			gradename="活动布告管理人";
			break;
		case 12:
			gradename="器材管理人";
			break;
		case 13:
			gradename="资金管理人";
			break;
		default:
			break;
		}
	}
	return gradename;
}

//关闭创建子任务
function closemb() {
	
$(".createmissionb").hide();	
}
//确定添加
function createmb() {
	var name=$(".els option:selected").text();
	var con=$(".zxcd").html();
	var result=$(".misresult option:selected").val();
	var bid=$(".els option:selected").val();
	var te="要求总结"
	if (result==0) {
		te="不要求总结"
	}
	$(".ms-list").append('<div class="ms-one">'+
				'<div class="ms-onetitle" personId='+bid+'><font>接受者：'+name+'</font><i class="iconfont" style="float: right;margin-left:10px;cursor: pointer;" onclick="deletethis(this)">&#xf00b3;</i>    <font style="float: right;" class="resx" value='+result+'>'+te+'</font>    </div>'+
					'<div class="ms-onecontent">'+con+'</div>'+
				'</div>')
				
 closemb();
}
//创建任务方案
function openreb() {
	$(".createplanbac").show();
}
//退出创建任务方案界面
function reb() {
	$(".createplanbac").hide();
}

//创建任务方案确定
function createplan() {
	var json={
			"planCreatorId":myuserid1,
			"planName":$(".pname").val(),
			"planContent":$(".pcontent").html()
	}
	$.getJSON("./CreatePlan",{json:JSON.stringify(json)},function(json){
		if (json.result==true) {
			alert("创建成功")
			 reb() ;
			
			getplan();
		}else {
			alert("创建失败")
		}
	})
}
function deleteplan(x) {
	 if(confirm("你确信要删除这个方案吗？"))
		 
	    {
			var json={
					"planId":x
				
			}
			
			$.getJSON("./DeletePlan",{json:JSON.stringify(json)},function(json){
				if (json.result==true) {
					alert("删除成功")
					getplan();
				}else {
					alert("删除失败")
				}
			
			})
	     }
	 
	    else
	 
	    {

	    
	    }
}
//提交创建的任务方案
function createmission() {
	var missions=new Array();
	for ( var i = 0; i < $(".ms-one").length; i++) {
		var json={
				"planId":$(".plan-tablename").attr("planid"),
				"missionExecutorId":$(".ms-onetitle").eq(i).attr("personId"),
				"missionContent":$(".ms-onecontent").eq(i).html(),
				"missionPromoterId":myuserid1,
				"missionType":$(".resx").eq(i).attr("value")	
		}
		missions.push(json)
	}
	$.getJSON("./CreateMission",{json:JSON.stringify(missions)},function(json){
		if (json.result==true) {
			alert("提交成功")
			getplan();
			closeplanbac();
		}else {
			alert("提交失败")
		}
	
	})

}