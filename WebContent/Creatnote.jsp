<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h3>创建记事本</h3>
<form action="" method="post">
<h3>标题<input type="text" name="subject" class="form-control" placeholder="Text input"> </h3>
<h3>记事本内容</h3>
<h5><textarea name="content" rows=14 cols=70 class="form-control" placeholder="Text input"></textarea></h5>
<h5><input type="checkbox" name="is_public">是否选择公开</h5>
<input type="submit" class="btn btn-primary" value="提交" >
</form>
 
</div>


<%@ include file="footer.jsp" %>