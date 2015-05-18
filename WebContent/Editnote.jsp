<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h3>编辑记事本</h3>
<form action="" method="post">
<input type="hidden" name="id" value=" ${note.id} ">
<h3>标题<input type="text" name="subject" class="form-control"  value="${ note.subject }"></h3>
<h3>记事本内容</h3>
<h5><textarea name="content" rows=14 cols=70 class="form-control"  >${ note.content }</textarea></h5>
<h3><input type="checkbox" name="is_public" <c:if test="${note.is_public}">checked="checked"</c:if> > 是否选择公开</h3>
<h4><input type="submit" class="btn btn-primary" value="提交" ></h4>
</form>
 
</div>


<%@ include file="footer.jsp" %>