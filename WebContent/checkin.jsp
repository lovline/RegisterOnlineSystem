<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<div style="width: 600">
	<b>我的考勤</b>
</div>
<br />
<br />
<br />
<table class="table table-bordered">
	<tr class="info">
		<th scope="col">编号</th>
		<th scope="col">时间</th>
		<th scope="col">签到</th>
	</tr>
	<c:forEach items="${custList}" var="ch" varStatus="list">
		<tr class="active">
			<td>${list.index+1}</td>
			<td>${ch.checkin_time}</td>
			<td><c:if test="${ch.type == 1}">下班
				</c:if> <c:if test="${ch.type == 2}">上班				
				</c:if></td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<br>
<script type="text/javascript">
	function setTimes() {
		var date = new Date();
		var curTime = date.toLocaleString();
		var divObj = document.getElementById("time");
		divObj.innerHTML = curTime;
	}

	var timer = setInterval("setTimes()");
</script>
<table class="table table-bordered">
	<tr class="success">
		<th>时间</th>
		<th>上班</th>
		<th>下班</th>
		<th>提交</th>
	</tr>
	<form action=" " method="post">
		<tr class="active">
			<td><div id="time">&nbsp;</div></td>
			<td><input type="radio" name="type" value="2"  class="btn btn-info"/></td>
			<td><input type="radio" name="type" value="1"  class="btn btn-info"/></td>
			<td><input type="submit" value="提交" class="btn btn-warning" /></td>
		</tr>
	</form>
</table>

<%@ include file="footer.jsp"%>