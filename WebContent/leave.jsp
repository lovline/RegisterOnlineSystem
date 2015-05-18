<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<div style="width: 600">
	<b>我的考勤</b>
</div>
<script language="javascript">
	function checkAll(name) {
		var names = document.getElementsByName(name);
		var len = names.length;
		if (len > 0) {
			var i = 0;
			for (i = 0; i < len; i++)
				names[i].checked = true;

		}
	}
</script>
<br />
<br />
<br />
<table class="table table-bordered">
	<form action="" method="post">
	<tr class="info">
		<th scope="col"><input type="checkbox" id="ckall" onclick="checkEvent('ck','ckall')" /></th>
		<th scope="col">编号</th>
		<th scope="col">员工</th>
		<th scope="col">时间</th>
		<th scope="col">签到</th>
	</tr>
	<c:forEach items="${custList}" var="ch" varStatus="list">
		<tr class="active">
			<td><input type="checkbox" name="ck" value="ch.id"></td>
			<td>${list.index+1}</td>
			<td>${ch.name}</td>
			<td>${ch.checkin_time}</td>
			<td><c:if test="${ch.type == 1}">下班
				</c:if> <c:if test="${ch.type == 2}">上班				
				</c:if></td>

		</tr>
	</c:forEach>
	</form>
</table>


<%@ include file="footer.jsp"%>