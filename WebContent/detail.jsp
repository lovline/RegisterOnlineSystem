<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h1>${ note.subject }   </h1>
<h3>内容  ${ note.content }   </h3>			
<h3>是否公开 ${ note.is_public }</h3>
 
</div>


<%@ include file="footer.jsp" %>