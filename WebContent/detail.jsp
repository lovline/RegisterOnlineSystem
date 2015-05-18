<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<p class="bg-primary" style="font-size:25px">${ note.subject }   </p>
<p class="bg-success" style="font-size:25px">  ${ note.htmlContent }   </p>			
<p class="bg-info" style="font-size:25px">是否公开 ${ note.is_public } </p>
 
</div>


<%@ include file="footer.jsp" %>