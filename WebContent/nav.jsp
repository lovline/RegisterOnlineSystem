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
      <a class="navbar-brand" href="${pageContext.request.contextPath}/index/">${ SITE_NAME } </a>
    </div>

    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <!-- 暂时不使用
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      -->
      <ul class="nav navbar-nav navbar-right">
      <c:choose>
      	<c:when test="${is_logged}" >
      	<li><a href="#">打卡</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${ username } <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.request.contextPath}/profile/">用户中心</a></li>
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
