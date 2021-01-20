<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>增加房间</title>
		<link rel="stylesheet" href="css/admincss/mainroom.css"
			type="text/css"></link>
		<script type="text/javascript" src="js/common/jq.js"></script>
		<script type="text/javascript" src="js/adminjs/addroom.js"></script>
		<script type="text/javascript" src="js/common/comm.js"></script>
		<link href="uploadify/uploadify.css" rel="stylesheet" type="text/css" />
		<script src="uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
		
		<script type="text/javascript">
		$(function () {
            $("#uploadify").uploadify({
                //指定swf文件
                'swf': 'uploadify/uploadify.swf',
                //后台处理的页面
                'uploader': './upload',
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
                'auto': false,
                //设置为true将允许多文件上传
                'multi': true,
                 //上传成功后执行
                'onUploadSuccess': function (file, data, response) {
                    $('#' + file.id).find('.data').html(' 上传完毕');
                    }
            });
        });
		</script>
	</head>
	<body>
		<jsp:include page="Header.html" flush="true" />
		<div class="content">
			<jsp:include page="MainLeft.html" flush="true" />
			<div class="mainright">
				<ul class="room-info-wrap">
					<li>
						<div class="condition-title">
							<p>
								<span style="font-weight: bold;">||</span>&nbsp基本信息
							</p>
						</div>
						<table class="data-table">
							<tr class="odd">
								<td>
									房间价格:
								</td>
								<td>
									<input id="RoomUnitPrice" type="text">
								</td>
								<td>
									密码:
								</td>
								<td>
									<input id="RoomPassWord" type="text">
								</td>
							</tr>
							<tr>
								<td>
									房间类型:
								</td>
								<td>
									<select name="selectRoomType" id="selectRoomType">
										<option value="1">
											标间
										</option>
										<option value="2">
											单人间
										</option>
										<option value="3">
											套房
										</option>
									</select>
								</td>
								<td>
									房间号码:
								</td>
								<td>
									<input id="RoomNumber" type="text" />
								</td>
							</tr>
							<tr class="odd">
								<td>
									房间锁状态:
								</td>
								<td>
									<input id="RoomLockState" type="text">
								</td>
								<td>
									房间使用状态:
								</td>
								<td>
									<input id="RoomUsingState" type="text">
								</td>
							</tr>
						</table>
					</li>

					<li>
						<div class="condition-title">
							<p>
								<span style="font-weight: bold;">||</span>&nbsp地址信息
							</p>
						</div>
						<table class="data-table">
							<tr class="odd">
								<td>
									房间所属省:
								</td>
								<td>
									<select name="selectRoomProvince" id="selectRoomProvince">
										<option value="1">
											浙江省
										</option>
									</select>
								</td>
								<td>
									房间所属市:
								</td>
								<td>
									<select name="selectRoomCity" id="selectRoomCity">
										<option value="1">
											宁波市
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									房间所属村:
								</td>
								<td>
									<select name="selectRoomVillage" id="selectRoomVillage">
										<option value="1">
											海曙区
										</option>
										<option value="2">
											江北区
										</option>
										<option value="3">
											江东区
										</option>
										<option value="4">
											奉化市
										</option>
										<option value="5">
											鄞州区
										</option>
										<option value="6">
											海曙区
										</option>
									</select>
								</td>
								<td>
									房间详细信息:
								</td>
								<td>
									<input type="input" id="RoomDetailAddress" />
								</td>
							</tr>
							<tr>
								<td>
									房间所在经度:
								</td>
								<td>
									<input id="AddressVillage" type="input" />
								</td>
								<td>
									房间所在纬度:
								</td>
								<td>
									<input type="input" id="RoomDetailAddress" />
								</td>
							</tr>
						</table>
					</li>
					<li>
						<div class="condition-title">
							<p>
								<span style="font-weight: bold;">||</span>&nbsp设备信息
							</p>
						</div>
						<table class="data-table">
							<tr class="odd">
								<td>
									生活必需品
									<input name="equipment" type="checkbox" value="Necessities">
								</td>
								<td>
									电视
									<input name="equipment" type="checkbox" value="TV">
								</td>
								<td>
									空调
									<input name="equipment" type="checkbox" value="AirConditioner">
								</td>
								<td>
									暖气
									<input name="equipment" type="checkbox" value="Heating">
								</td>
								<td>
									厨房
									<input name="equipment" type="checkbox" value="Kitchen">
								</td>
								<td>
									网络
									<input name="equipment" type="checkbox" value="Network">
								</td>
							</tr>
							<tr>
								<td>
									热水浴缸
									<input name="equipment" type="checkbox" value="HotTub">
								</td>
								<td>
									洗衣机
									<input name="equipment" type="checkbox" value="WashingMachine">
								</td>
								<td>
									游泳池
									<input name="equipment" type="checkbox" value="SwimmingPool">
								</td>
								<td>
									烘干机
									<input name="equipment" type="checkbox" value="DryingMachine">
								</td>
								<td>
									早餐
									<input name="equipment" type="checkbox" value="Breakfast">
								</td>
								<td>
									衣架
									<input name="equipment" type="checkbox" value="CoatHanger">
								</td>
							</tr>
							<tr class="odd">
								<td>
									熨斗
									<input name="equipment" type="checkbox" value="Iron">
								</td>
								<td>
									室内壁炉
									<input name="equipment" type="checkbox" value="IndoorFirePlace">
								</td>
								<td>
									无障碍设施
									<input name="equipment" type="checkbox"
										value="WheelchairAccessible">
								</td>
								<td>
									宠物设施
									<input name="equipment" type="checkbox" value="PETFacilities">
								</td>
								<td>
									工作区域
									<input name="equipment" type="checkbox" value="WorkingSpace">
								</td>
								<td></td>
							</tr>
						</table>
					</li>
					<li>
						<div class="condition-title">
							<p>
								<span style="font-weight: bold;">||</span>&nbsp其他信息
							</p>
						</div>

						<div>
							<%--用来作为文件队列区域--%>
							<div id="fileQueue">
							</div>
							<input type="file" name="uploadify" id="uploadify" />
							<%--
							<p>
								<a href="javascript:$('#uploadify').uploadify('upload')">上传</a>|
								<a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>
							</p>
							--%>

						</div>
					</li>
					<li>
						<input class="op-button" type="submit" value="确认" onclick="add()"/>
					</li>

				</ul>
			</div>
			<div style="clear: both"></div>
			<!-- ------------------------------------------------------------------------------------- -->
			<!-- 页面底部开始 -->
			<div class="foot"></div>
			<!-- 页面底部结束 -->

		</div>
		<jsp:include page="Footer.html" flush="true" />
	</body>
</html>
