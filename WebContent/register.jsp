<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>

<div class="row">
<div class='col-md-8'>
<form class="form-horizontal" method="post" >
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="email" name="email" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="realname" class="col-sm-2 control-label">真实姓名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="realname" name="realname" placeholder="张三">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" name="password" placeholder="">
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
      <button type="submit" class="btn btn-primary btn-lg">注册</button>
    </div>
  </div>
</form>
</div>
<div class="col-md-4" style="border-left:1px solid black">
	<h4>完成注册后</h4>
	<ul>
		<li>考勤</li>
		<li>查看公司公告</li>
		<li>其他</li>
	</ul>
</div>
</div>
<%@ include file="footer.jsp" %>