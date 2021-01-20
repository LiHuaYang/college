var picTestPathArr = new Array();
var picTestAnswerNameArr = new Array();
var TestId = 0;

var CompetitionName = decodeURI(getUrlParam('CompetitionName'));
var CompetitionSubject = decodeURI(getUrlParam('CompetitionSubject'));
var CompetitionObject = decodeURI(getUrlParam('CompetitionObject'));
//
//alert(CompetitionName);
//alert(CompetitionSubject);
//alert(CompetitionObject);

//$("#TestPaperName").val(CompetitionName);

$(document).ready(function() {

	$("#TestPaperName").val(CompetitionName);
	$("#TestSubject").val(CompetitionSubject);
	$("#TestState").val(CompetitionObject);
});




$(function (){
	$.getJSON("./GetTestYearServlet",
			function(json) {
			//alert(json.testyears[2].testYear);
			for(var i=0;i<json.testyears.length;i++)
			{
				$("#TestYear").append("<option value='"+json.testyears[i].testYear+"'>" +
						json.testyears[i].testYear+"</option>");
			}
			
	});
});
// 提交新闻
function puttestpaper(){
	
	var TestPaperName = $("#TestPaperName").val();
	var TestSubject=$("#TestSubject").val();
	var TestDifficulty=$("#TestDifficulty").val();
	var TestKnowledgepoint=$("#TestKnowledgepoint").val();
	var TestYear=$("#TestYear").val();
	var TestState=$("#TestState").val();
	//alert(TestYear);
	var json = {
		"ContestId":jspCompetitionId,
		"TestPaperName" : TestPaperName,
		"TestSubject" : TestSubject,
		"TestDifficulty": TestDifficulty,
		"TestKnowledgepoint" :TestKnowledgepoint,
		"TestYear": TestYear,
		"TestState":TestState
	};
	//json.picPathArr = picPathArr;
	
	//console.log("添加试卷详情为：" + JSON.stringify(json));
	$.getJSON("./AddCompetitionTestServlet", {
		json : JSON.stringify(json)
	}, function(json) {
			//alert(json.TestId);
			TestId = json.TestId;
			if(0 != TestId){
				alert("提交试卷成功！");
			}
			else{
				alert("提交试卷失败！");
			}
	});
}




// 文件上传
$(function () {
    $("#uploadify").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'UpTestPictureServlet',
        //按钮显示的文字
        'buttonText': '上传试卷题目，这是第二步',
        //显示的高度和宽度，默认 height 30；width 120
        //'height': 15,
        //'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
        
       // 'formData': { json: JSON.stringify(json) },
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': true,
         //上传成功后执行
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html(' 上传完毕');
          //  alert(data);
            var dataObj = eval("("+data+")");
          //   alert(dataObj.fileName);
            picTestPathArr.length = 0;
            var TestPaperNumber=$("#TestPaperNumber").val();
            
            picTestPathArr.push(dataObj.fileName);
            $("#TestPapeTitleUrl").val("第"+TestPaperNumber+"题图片路径："+picTestPathArr[0]+";\n");
         //   console.log("试卷图片路径：" + picTestPathArr);
           //  alert(picTestPathArr);
            }
    });
    
    $("#uploadify2").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'UpTestAnsWerPictureServlet',
        //按钮显示的文字
        'buttonText': '上传题目答案，这是第三步',
        //显示的高度和宽度，默认 height 30；width 120
        //'height': 15,
        //'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
        
        //'formData': { json: JSON.stringify(json) },
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        //'queueID': 'fileQueue',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': true,
         //上传成功后执行
        'onUploadSuccess': function (file, data, response) {
            $('#' + file.id).find('.data').html(' 上传完毕');
            // alert(data);
            var dataObj = eval("("+data+")");
          //   alert(dataObj.fileName);
           //  alert(TestId);
            picTestAnswerNameArr.length=0;
            var TestPaperNumber=$("#TestPaperNumber").val();
            
             picTestAnswerNameArr.push(dataObj.fileName);
          //  console.log("试卷答案图片路径：" + picTestAnswerNameArr);
            $("#TestPaperAnswerUrl").val("第"+TestPaperNumber+"题答案图片路径："+picTestAnswerNameArr[0]+";\n");
         //  alert(picTestAnswerNameArr);
            }
    });
    
});

function putContestInfoToServer(){
	//alert(picTestPathArr);
	//alert(picTestAnswerNameArr);
//	alert(TestId);
	if(0 != TestId){
		var TestPaperNumber=$("#TestPaperNumber").val();
		var json ={
				"TestId":TestId,
				"picTestPathArr":picTestPathArr[0],
				"picTestAnswerNameArr":picTestAnswerNameArr[0],
				"TestPaperNumber":TestPaperNumber
		};		
		$.getJSON("./SaveTestPaperPicServlet", {
			json : JSON.stringify(json)
		}, function(json) {
			
				if(json.flag){
					alert("提交成功！");
				}
				else{
					alert("提交失败！");
				}
				//TestId = json.TestId;
		});
	}
	else{
		alert("请先提交试卷信息，再提交试卷图片！");
	}
}

/**
 * 
 * 获取url中的参数
 * 
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);   // 匹配目标参数
	if (r != null) return unescape(r[2]); 
	return null;  // 返回参数值
}


















