<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

// int competitionId = Integer.parseInt(request.getParameter("competitionId"));
// System.out.println("ddd----" + competitionId);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更多资料...</title>
    
    <script type="text/javascript" src="Common/jquery-1.8.3.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="Web/Competition/css/competitionDetailInfo.css">
	<script type="text/javascript" src="Web/Competition/js/competitionDetailInfo.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	</script>

  </head>
  
  <body>
      <!-- 头---开始 -->
      <jsp:include page="../../Common/jsp/Title.jsp" flush="true" />
      <!-- 头---结束 -->
  
      <!-- 中间---开始 -->
       <div class="contest_detail_info" id="contest_detail_info">
       
          <!-- 标题---开始 -->
          <div class="info_title_bar" style="background-image: url('Web/image/info.png');">
            <div class="info_t">
	            <h2 class="info_title" id="info_title"></h2>
	            <div class="info_title_more">更多资料</div>
            </div>
          </div>
          <!-- 标题---结束 -->
       
          <!-- 信息---开始 -->
          <div class="info">
          
              <!-- 科目---开始 -->
	          <div class="info_list">
	               <strong>科目 :</strong>
	               <p class="info_text" id="subject_info_text">
	               </p>
	          </div>
	           <!-- 科目---结束 -->
	           
	           <!-- 形式---开始 -->
	          <div class="info_list">
	               <strong>形式 :</strong>
	               <p class="info_text" id="type_info_text">
	               </p>
	          </div>
	           <!-- 形式---结束 -->
	           
	            <!--对象---开始 -->
	          <div class="info_list">
	               <strong>对象 :</strong>
	               <p class="info_text" id="object_info_text">
	               </p>
	          </div>
	           <!-- 对象---结束 -->
	           
	            <!--时间---开始 -->
	          <div class="info_list">
	               <strong>时间 :</strong>
	               <p class="info_text" id="time_info_text">
	               </p>
	          </div>
	           <!-- 时间---结束 -->
	           
	            <!--报名费用---开始 -->
	          <div class="info_list">
	               <strong>报名费用 :</strong>
	               <p class="info_text" id="enrollPrice_info_text">
	               </p>
	          </div>
	           <!-- 报名费用---结束 -->
	           
	          <!-- 奖项设置---开始 -->
	          <div class="info_list">
	               <strong>奖项设置 :</strong>
	               <p class="info_text" id="prize_info_text"> 
	               </p>
	          </div>
	          <!-- 奖项设置---结束 -->
	          
	          <!-- 简介---开始 -->
	          <div class="info_list">
	               <strong>大赛简介 :</strong>
	               <p class="info_text" id="detail_info_text">
	               </p>
	          </div>
	           <!-- 简介---结束 -->
	           
          </div>
          <!-- 信息---结束 -->
         
          
	  </div>
      <!-- 中间---结束 -->
    
       <!-- 尾---开始 -- -->
       <jsp:include page="../../Common/jsp/End.jsp" flush="true" />
       <!-- 尾 ---结束-->
  </body>
</html>
