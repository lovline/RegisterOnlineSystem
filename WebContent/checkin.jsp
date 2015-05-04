<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<div class="row">
	<h1>考勤</h1>
</div>

<table width="600px" border="1">
	<tr>
		<th>时间</th>
		<th>用户</th>
		<th>签到</th>
	</tr>
	<c:forEach items="${list}" var="cust" varStatus="list">
		<tr>
			<td><%=(String) request.getAttribute("ckr1")%></td>
			<td><%=request.getAttribute("ckr2")%></td>
			<td><c:if test="${cust.type==0}">上班</c:if> <c:if
					test="${cust.type==1}">下班</c:if></td>
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

<table width="600px" border="1">
	<tr>
		<th>时间</th>
		<th>上班</th>
		<th>下班</th>
		<th>提交</th>
	</tr>

	<form action="" method="post">
		<tr>
			<!-- <td><div id="time">&nbsp;</div></td> -->
			<td><input type="datetime" id="notice.startTime" /></td>
			<td><input type="radio" name="type" value="0" /></td>
			<td><input type="radio" name="type" value="1" /></td>
			<td><input type="submit" value="提交" /></td>
		</tr>
	</form>
</table>

<%@ include file="footer.jsp"%>