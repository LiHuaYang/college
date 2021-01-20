

//文件上传
//文件上传
$(function () {
    $("#uploadify").uploadify({
        //指定swf文件
        'swf': 'Common/Tool/uploadify/uploadify.swf',
        //后台处理的页面
        'uploader': 'upload',
        //按钮显示的文字
        'buttonText': '上传图片',
        //显示的高度和宽度，默认 height 30；width 120
        //'height': 15,
        //'width': 80,
        //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc': 'Image Files',
        //允许上传的文件后缀
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //发送给后台的其他参数通过formData指定
        //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
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
            // alert(dataObj.fileName);
            picPathArr.push(dataObj.filePath);
            console.log("文件名数组：" + picPathArr);
            }
    });
});