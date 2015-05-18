<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
   <head>
       <style type="text/css">
    leftmargin={margin-left=50px;}; 
    
              </style>
               </head>

<div class="row" >



<h4>公开记事本</h4>
<div class="col-md-6">
<c:forEach  items="${notess}" var="note" varStatus="list">
	
	<div class="col-md-4">
	${ note.subject } </div><div class="col-md-2">${note.author.realname} </div> <div class="col-md-4"> <a class="btn btn-default" href="${pageContext.request.contextPath}/note/detail/?id=${ note.id }">阅读全文</a></div>
	
</c:forEach>
</div>
<div class="col-md-6">

<h4>编辑我的记事本</h4>
<c:forEach  items="${notes}" var="note" varStatus="list">
	<div class="col-md-4">
		${ note.subject } </div><div class="col-md-2"><a class="btn btn-default" href="${pageContext.request.contextPath}/note/edit/?id=${ note.id }">编辑</a>
		</div> <div class="col-md-4"><a class="btn btn-default" href="${pageContext.request.contextPath}/note/detail/?id=${ note.id }">阅读全文</a></div>
	
</c:forEach>

<h4><a class="btn btn-default" href="${pageContext.request.contextPath}/note/create/">创建我的记事本</a></h4>
</div>


</div>


<%@ include file="footer.jsp" %>