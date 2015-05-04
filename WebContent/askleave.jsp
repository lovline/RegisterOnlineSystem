<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h1 align="center">请假</h1>
</div>

<div style="float: left;margin-left:20px">
<h2>请假记录：</h2>
    <table border="1">
        <tr>
            <th>申请时间</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
        
        <c:forEach items="${list}" var="cust" varStatus="list">
        
        <tr>
            <td><c:out value="${cust.created_at}"/></td>
            <td><c:out value="${cust.start_time}"/></td>
            <td><c:out value="${cust.end_time}"/></td>
        </tr>
        </c:forEach>
    </table>
</div>
<div style="float: left;margin-left:330px;">
<h2>申请请假：</h2>
	<table border="1">
		<tr>
			<th>开始时间</th>
			<th>结束时间</th>
		</tr>
		<tr>
			<td><input type="date" name="start_time" id="start_time" /></td>
			<td><input type="date" id="end_time" name="end_time" /></td>
		</tr>
	</table>
	<br />
	<form method="post" action="">
		<input type="submit" value="提交" />
	</form>
</div>

<%@ include file="footer.jsp" %>