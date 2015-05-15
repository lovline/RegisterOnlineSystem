<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h1>用户中心</h1>
<p style="color:purple;font-size:20px;margin-left:22px">email: ${ userBean.email } </p>
<p style="color:red;font-size:20px;margin-left:22px">真实姓名: ${ userBean.realname }  </p>
<p style="color:green;font-size:20px;margin-left:22px">上次登录时间: ${ userBean.last_login_at } </p>


</div>


<%@ include file="footer.jsp" %>