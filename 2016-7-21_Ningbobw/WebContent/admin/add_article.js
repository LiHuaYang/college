/**
 * 
 */

$(document).ready(function(){
	$.post( "../a?m=getCategory", {},
		function(data) {
		showData(data);
	});
	if(id!=0) {
		getData(id);
	}
	
});

function showData(data) {
	var json = JSON.parse(data);
	for (var i=0; i<json.length; i++) {
		var group = "";

		group = group + '<optgroup label=' + json[i].titile + '>';
		for (var j=0; j<json[i].item.length; j++) {
			group = group + '<option value=' + json[i].item[j].article_id + ' title='+ json[i].item[j].article_title + '>'+json[i].item[j].article_title+'</option>';
		}
		group = group + '</optgroup>';
		$("#js_cat_id").append(group);
	}
}

function getData(id) {ff
	
	$.post( "../a?m=detail", {
		"article_id" : id
	},
			function(data) {
			var json = JSON.parse(data);
			console.log(json);
			editor1.html(json.content);
			$('#ff').form('load', json);
		});
}



//$(function() {
//	$("#uploadify").uploadify({
//		// 指定swf文件
//		 'swf' : '../common/uploadify/uploadify.swf',
//		'uploader' : '../upload',// 后台处理的页面
//		'buttonText' : '添加附件',// 按钮显示的文字
//		// 显示的高度和宽度，默认 height 30；width 120
//		'height': 30,
//		'width': 100,
//		 'fileTypeDesc' : 'All Files',// 在浏览窗口底部的文件类型下拉菜单中显示的文本// 上传文件的类型 默认为所有文件 'All Files' ; '*.*'
//		'fileTypeExts' : '*.doc,*.docx',// 允许上传的文件后缀
//		
//		'fileSizeLimit' : '5MB',
//		
//		// 发送给后台的其他参数通过formData指定
//		// 'formData': { json: JSON.stringify(json) },
//		// 上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false 自动生成, 不带#
//		'queueID': 'fileQueue',
//		'auto' : false,// 选择文件后自动上传
//		'multi' : false,// 设置为true将允许多文件上传
//		
//		'onUploadSuccess' : function(file, data, response) {// 上传成功后执行
//			alert("文件为--" + file + "--类型为--" + typeof(file));
//			alert("文件为--" + data + "--类型为--" + typeof(data));
//			alert("文件为--" + response + "--类型为--" + typeof(response));
//			//$('#' + file.id).find('.data').html('上传完毕');
//			// alert(data);
//			//var dataObj = eval("(" + data + ")");
//			//console.log("大赛的数据库图片：" + dataObj.fileName);
//			//picPathArr.push(dataObj.fileName);
//		}
//	});
//});
	





/*************************/
// 当点击上传按钮时候，改变form的action值，自动提交文件


//function to_upload () {
//	//得到你的from
//	var form = document.forms['form1'];
//	// form.encoding="application/x-www-form-urlencoded" // 默认
//	form.encoding="multipart/form-data" // 文件上传编码
//	//在这里手工指定提交给哪个ACTION
//	form.action = '../upload';
//	//执行SUBMIT
//	form.submit();
//}






