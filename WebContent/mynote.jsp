<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
   <head>
       <style type="text/css">
    leftmargin={margin-left=50px;};   
              </style>
               </head>
<div class="row">
<h1 style="color:purple;font-size:20px;margin-left:22px">记事本</h1>

<h4>编辑我的记事本</a></h4>
<ul>
<c:forEach  items="${notes}" var="note" varStatus="list">
	<li>
		${ note.subject } | <a href="${pageContext.request.contextPath}/note/edit/?id=${ note.id }">编辑</a>
		| <a href="${pageContext.request.contextPath}/note/detail/?id=${ note.id }">阅读全文</a>
	</li>
</c:forEach>
</ul>
</div>

<h4><a href="${pageContext.request.contextPath}/note/create/">创建我的记事本</a></h4>
<h4>全部公开记事本</h4>
<ul>
<c:forEach  items="${notess}" var="note" varStatus="list">
	<li>
		${ note.subject } | <a href="${pageContext.request.contextPath}/note/detail/?id=${ note.id }">阅读全文</a>
	</li>
</c:forEach>
</ul>



<%@ include file="footer.jsp" %>