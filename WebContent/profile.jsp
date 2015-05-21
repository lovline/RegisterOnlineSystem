<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<div class='col-md-8'>
	<div class="panel panel-primary">
		<div class="panel-heading">${ owner.realname }</div>
		  <div class="panel-body">
		    <table class="table">
		    	<tr>
		    		<td>Email</td>
		    		<td>真实姓名</td>
		    		<td>是否管理员</td>
		    		<td>上次登录时间</td>
	    		</tr>
	    		<tr>
		    		<td>${ owner.email }</td>
		    		<td>${ owner.realname }</td>
		    		<td>${ owner.admin }</td>
		    		<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${ owner.last_login_at }" /></td>
	    		</tr>
		    </table>
		  </div>
	</div>
</div>
<div class="col-md-4" style="border-left:1px solid black">
	<c:choose>
	<c:when test="${ isOwner }">
	<h4>修改信息</h4>
	<ul>
		<li><a href="${pageContext.request.contextPath}/user/change/">修改个人信息</a></li>
		<li><a href="${pageContext.request.contextPath}/password/change/">修改密码</a></li>
	</ul>
	</c:when>
	<c:otherwise>
	<h4>回到我的主页</h4>
	<ul>
		<li><a href="${pageContext.request.contextPath}/profile/">回到我的主页</a></li>
	</ul>
	</c:otherwise>
	</c:choose>
</div>
</div>


<%@ include file="footer.jsp" %>