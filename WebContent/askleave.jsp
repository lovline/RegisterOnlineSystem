<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<script type="text/javascript">
	function setTimes() {
		var date = new Date();
		var curTime = date.toLocaleString();
		var divObj = document.getElementById("time");
		divObj.innerHTML = curTime;
	}

	var timer = setInterval("setTimes()");
</script>
<b>申请请假：</b>
<br><br><br>
<br><br><br>
<div style="width: 600; float: right"><a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/askleavetwo/"><b>请假状态</b></a></div>
		<br><br>
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
<%@ include file="footer.jsp"%>