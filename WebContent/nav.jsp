<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <div class="row">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/index/">${ SITE_NAME } 
      </a>
    </div>

    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     <ul class="nav navbar-nav navbar-right">
      <c:choose>
      	<c:when test="${is_logged}" >
      	<li><a href="${pageContext.request.contextPath}/checkin/">考勤</a></li>
      	<li><a href="${pageContext.request.contextPath}/askleave/">请假</a></li>
        <c:if test="${ userBean.admin }" >
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> 管理 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.request.contextPath}/manage/leave/">考勤管理</a></li>
            <li><a href="${pageContext.request.contextPath}/manage/absence/">请假管理</a></li>
            <li><a href="${pageContext.request.contextPath}/manage/user/">员工管理</a></li>
            <li><a href="${pageContext.request.contextPath}/worktwo/">工作管理</a></li>
          </ul>
        </li>
        </c:if>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${ userBean.realname } <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.request.contextPath}/profile/">用户中心</a></li>
            <li><a href="${pageContext.request.contextPath}/mywork/">我的工作</a></li>
            <li><a href="${pageContext.request.contextPath}/mynote/">我的记事本</a></li>
            <li><a href="${pageContext.request.contextPath}/logout/">退出</a></li>
          </ul>
        </li>
      	</c:when>
      	<c:otherwise>
      	<li><a href="${pageContext.request.contextPath}/register/">注册</a></li>
      	<li><a href="${pageContext.request.contextPath}/login/">登录</a></li>
      	</c:otherwise>
        </c:choose>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
<c:if test="${ has_alert }">
<div class="alert alert-success" role="alert">${ alert_info }</div>
</c:if>
