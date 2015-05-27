<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<b>考勤管理</b>
<script language="javascript">
	function checkAllBox(obj) {
		var answer = document.getElementsByName("answer");
		if (obj.checked == true) {
			for (var i = 0; i < answer.length; i++) {
				answer[i].checked = true;
			}
		} else {
			for (var i = 0; i < answer.length; i++) {
				answer[i].checked = false;
			}
		}
	}
	
	$(function(){
		$("#submit").click(function(){
			var answer = $("#answer").val();
			if (answer.trim() == ""){
				alert("answer不能为空");
				return false;
			}
			else {	
			return true;
			}
		});
	});

</script>
<br />
<br />
<br />
<table class="table">
	<tr align="right">
		<td colspan="4"></td>
		<td><a class="btn btn-primary btn-xs"
			href="${pageContext.request.contextPath}/leave/"><b>返回</b></a></td>
	</tr>
</table>
<table class="table table-bordered">
	<form method="post" action="">
		<tr class="info" align="center">
			<th scope="col" width="100">
			<input name="checkall1" type="checkbox" value="0" onClick="checkAllBox(this);" />&nbsp;&nbsp;/&nbsp;&nbsp;全选</th>
			<th scope="col">编号</th>
			<th scope="col">员工</th>
			<th scope="col">时间</th>
			<th scope="col">签到</th>
		</tr>
		<c:forEach items="${custList}" var="ch" varStatus="list">
			<tr class="active" align="center">
				<td><input type="checkbox" id="answer" name="answer" value=${ch.id} >
					
				</td>
				<td>${list.index+1}</td>
				<td>${ch.name}</td>
				<td>${ch.checkin_time}</td>
				<td><c:if test="${ch.type == 1}">下班			
				</c:if> <c:if test="${ch.type == 2}">上班			
				</c:if></td>
			</tr>
		</c:forEach>
	<tr class="active" align="center">
		<td colspan="5">
		<input type="Submit" name="Submit"  id="submit" value="DELTE" /></td>
	</tr>

	</form>
</table>


<%@ include file="footer.jsp"%>