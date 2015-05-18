<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h2>用户中心</h2>
<p class="bg-primary" style="font-size:25px">email: ${ userBean.email } </p>
<p class="bg-success" style="font-size:25px">真实姓名: ${ userBean.realname }  </p>
<p class="bg-info" style="font-size:25px">上次登录时间: ${ userBean.last_login_at } </p>


</div>


<%@ include file="footer.jsp" %>