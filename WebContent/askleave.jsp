<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<div class="row">
	<h1 align="center">请假</h1>
</div><script type="text/javascript">
	function setTimes() {
		var date = new Date();
		var curTime = date.toLocaleString();
		var divObj = document.getElementById("time");
		divObj.innerHTML = curTime;
	}

	var timer = setInterval("setTimes()");
</script>
<b>申请请假：</b>
<table class="table table-bordered">

	<tr class="bg-primary">
		<th>申请时间</th>
		<th>开始时间</th>
		<th>结束时间</th>
		<th>操作</th>
	</tr>
	<form method="post" action="">
	<tr class="bg-success">
		<td id="time"></td>
		<td><input type="datetime-local" name="start_time" /></td>
		<td><input type="datetime-local" name="end_time" /></td>
		<td><input type="submit" value="提交"  class="btn btn-info"/></td>
	</tr>
	</form>
</table>
<br />
<br />
<br />
<br />
<b>请假记录：</b>
<table class="table table-bordered">
	<tr class="bg-primary">
		<th>申请时间</th>
		<th>开始时间</th>
		<th>结束时间</th>
		<th>申请状态</th>
	</tr>
	<c:forEach items="${results}" var="result" varStatus="results">
	<form action="" method="post">
		<tr class="bg-success">
			<td>${result.created_at}</td>
			<td>${result.start_time}</td>
			<td>${result.end_time}</td>
			<td align="center">
			<c:if test="${result.status == 1}">审核中请等待</c:if>
			<c:if test="${result.status == 2}">批准</c:if>
			<c:if test="${result.status == 3}">不批准</c:if>
			<c:if test="${result.status == 4}"><input type="submit" value="销假" class="btn btn-warning"/></c:if>
			<c:if test="${result.status == 5}">已销假</c:if>
			</td>
		</tr>
		</form>
	</c:forEach>
</table>
<%@ include file="footer.jsp"%>