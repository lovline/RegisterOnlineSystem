<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>

<div class="row">
<div class='col-md-8'>
<form class="form-horizontal" method="post">
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Realname</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="email" name="email" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" name="password" placeholder="password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="remember" checked> 记住我的登录
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary btn-lg">登录</button>
    </div>
  </div>
</form>
</div>
<div class="col-md-4" style="border-right:1px solid black">
	<div style="margin-left: 80px">
		<h4>完成登陆后</h4>
		<ul>
		<li>考勤</li>
		<li>查看公司公告</li>
		<li>其他</li>
		<li><a href="${pageContext.request.contextPath}/login/">我要注册</a></li>
		</ul>
	</div>
</div>
</div>
<%@ include file="footer.jsp" %>