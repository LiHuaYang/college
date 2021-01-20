<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/style/css/amazeui.page.css">

<title>学生个人详细信息</title>
</head>

<body>

<div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
      </div>
      <hr>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="am-g">
                <div class="am-u-md-4">
                  <img class="am-img-circle am-img-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/200/h/200/q/80" alt="">
                </div>
                <div class="am-u-md-8">
                  <p>你可以使用<a href="#">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>
                  <form class="am-form">
                    <div class="am-form-group">
                      <input type="file" id="user-pic">
                      <p class="am-form-help">请选择要上传的文件...</p>
                      <button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>

          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="user-info">
                <p>等级信息</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar" style="width: 60%"></div>
                </div>
                <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
              </div>
              <div class="user-info">
                <p>信用信息</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
                </div>
                <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
              </div>
            </div>
          </div>

        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form class="am-form am-form-horizontal">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-name" placeholder="姓名 / Name" value="${requestScope.detail.name}">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
              <div class="am-u-sm-9">
                <input type="email" id="user-email" placeholder="输入用户的电子邮件 / Email" value="${requestScope.detail.name }">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
              <div class="am-u-sm-9">
                <input type="tel" id="user-phone" placeholder="输入用户的电话号码 / Telephone">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">QQ</label>
              <div class="am-u-sm-9">
                <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="输入用户的QQ号码">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">微博 / Twitter</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-weibo" placeholder="输入用户的微博 / Twitter">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">简介 / Intro</label>
              <div class="am-u-sm-9">
                <textarea class="" rows="5" id="user-intro" placeholder="输入个人简介"></textarea>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="button" class="am-btn am-btn-primary">保存修改</button>
              </div>
            </div>
          </form>
        </div>
      </div>	


</body>
</html>