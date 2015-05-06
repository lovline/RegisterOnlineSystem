<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h1 align="center">请假</h1>
</div>

<div style="float: left;margin-left:20px">
<h2>请假记录：</h2>
    <table width = "500" border="1">
        <tr>
            <th>申请时间</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>申请状态</th>
        </tr>
        <c:forEach items="${results}" var="result" varStatus="results">
        <tr>
 <!--       <td><input type="datetime" id="created_at" name="created_at" value=${result.created_at}/></td>
            <td><input type="datetime" id="start_time" name="start_time" value=${result.start_time}/></td>
            <td><input type="datetime" id="end_time" name="end_time" value=${result.end_time}/></td>
            <td><input type="text" id="status" name="status" value=${result.status}/></td>
             -->
            <td>${result.created_at}</td>
            <td>${result.start_time}</td>
            <td>${result.end_time}</td>
            <td align="center">${result.status}</td>  
        </tr>
        </c:forEach>
    </table>
</div>
<div style="float: left;margin-left:260px;">
<h2>申请请假：</h2>
    <form method="post" action="">   
	<table border="1">
		<tr>
			<th>开始时间</th>
			<th>结束时间</th>
		</tr>
		<tr>
			<td><input type="datetime" name="start_time" id="start_time" /></td>
			<td><input type="datetime" id="end_time" name="end_time" /></td>
		</tr>
	</table>
	<br />	
		<input type="submit" value="提交" />
	</form>
</div>

<%@ include file="footer.jsp" %>