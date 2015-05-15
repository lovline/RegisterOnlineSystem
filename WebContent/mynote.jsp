<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
   <head>
       <style type="text/css">
    leftmargin={margin-left=50px;}; 
    
              </style>
               </head>
 <h1 style="color:purple;font-size:20px;margin-left:20px">记事本</h1>
         
<div class="row" >


<div class="col-md-6">
<h4>编辑我的记事本</h4>
<ul>
<c:forEach  items="${notes}" var="note" varStatus="list">
	<li><div class="col-md-4">
		${ note.subject } </div><div class="col-md-2"><a href="${pageContext.request.contextPath}/note/edit/?id=${ note.id }">编辑</a>
		</div> <div class="col-md-4"><a href="${pageContext.request.contextPath}/note/detail/?id=${ note.id }">阅读全文</a></div>
	</li>
</c:forEach>
</ul>
<h4><a href="${pageContext.request.contextPath}/note/create/">创建我的记事本</a></h4>
</div>
<div class="col-md-6">
<h4>全部公开记事本</h4>
<ul>
<c:forEach  items="${notess}" var="note" varStatus="list">
	<li>
	<div class="col-md-4">
	${ note.subject } </div> <div class="col-md-4"> <a href="${pageContext.request.contextPath}/note/detail/?id=${ note.id }">阅读全文</a></div>
	</li>
</c:forEach>
</ul>
</div>
</div>


<%@ include file="footer.jsp" %>