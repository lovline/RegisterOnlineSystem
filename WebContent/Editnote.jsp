<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h1>编辑记事本${note.id}</h1>
<form action="" method="post">
<input type="hidden" name="id" value=" ${note.id} ">
<h1>标题<input type="text" name="subject" value="${ note.subject }"></h1>
<h2>记事本内容</h2>
<h5><textarea name="content" rows=14 cols=70 >${ note.content }</textarea></h5>
<h3><input type="checkbox" name="is_public" <c:if test="${note.is_public}">checked="checked"</c:if> > 是否选择公开</h3>
<h4><input type="submit" value="提交" ></h4>
</form>
 
</div>


<%@ include file="footer.jsp" %>