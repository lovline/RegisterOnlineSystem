<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<b>请假管理——销假</b>
<br>
<br>
<br>
<div style="width: 600; float: right">
	<a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/absence/"><b>所有请假信息</b></a>
</div>
<br><br>
<table align="center" class="table table-bordered">
	<tr class="bg-primary">
		<th>姓名</th>
		<th>申请时间</th>
		<th>开始时间</th>
		<th>结束时间</th>
		<th>请假操作</th>
	</tr>
	<c:forEach items="${results}" var="result">
	<c:if test="${result.status ==2}">
			<tr class="bg-success">
				<td>${result.name}</td>
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<td>已批准待销假</td>
			</tr>
		</c:if>

		<c:if test="${result.status ==4}">
			<tr class="bg-success">
				<td>${result.name}</td>
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<form method="post" action="">
					<td><input type="hidden" name="xid" value="${result.id}" /> <input
						type="hidden" name="xid2" value="5" /> <input type="submit"
						value="销假" class="btn btn-info" /></td>
				</form>
			</tr>
		</c:if>
		<c:if test="${result.status ==5}">
			<tr class="bg-success">
				<td>${result.name}</td>
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<td>已销假</td>
			</tr>
		</c:if>
	</c:forEach>
</table>

<%@ include file="footer.jsp"%>