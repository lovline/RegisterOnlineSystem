<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<b>请假记录：</b>
<br>
<br>
<br>
<div style="width: 600; float: right">
	<a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/askleave/"><b>请假</b></a>
</div>
<br><br>
<table class="table table-bordered">
	<tr class="bg-primary">
		<th>申请时间</th>
		<th>开始时间</th>
		<th>结束时间</th>
		<th>申请状态</th>
	</tr>
	<c:forEach items="${results}" var="result" varStatus="results">

		<c:if test="${result.status == 1}">
			<tr class="bg-success">
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<td>审核中请等待</td>
			</tr>
		</c:if>
		<form action="" method="post">
			<c:if test="${result.status == 2}">
				<tr class="bg-success">
					<td>${result.created_at}</td>
					<td>${result.start_time}</td>
					<td>${result.end_time}</td>
					<td><input type="hidden" name="did" value="4" /><input
						type="hidden" name="dd" value="${result.id}" /> <input
						type="submit" value="销假" class="btn btn-warning" /></td>
				</tr>
			</c:if>
		</form>
		<c:if test="${result.status == 3}">
			<tr class="bg-success">
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<td>未通过</td>
			</tr>
		</c:if>
		<c:if test="${result.status == 4}">
			<tr class="bg-success">
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<td>等待销假</td>
			</tr>
		</c:if>
		<c:if test="${result.status == 5}">
			<tr class="bg-success">
				<td>${result.created_at}</td>
				<td>${result.start_time}</td>
				<td>${result.end_time}</td>
				<td>已销假</td>
			</tr>
		</c:if>

	</c:forEach>
</table>
<%@ include file="footer.jsp"%>