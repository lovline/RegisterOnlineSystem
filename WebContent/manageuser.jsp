<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<div style="width: 600">
	<b>员工管理</b>
</div>
<script language="javascript">
	function box(org) {
		if (org.checked == true) {
			var boxs = document.getElementsByName("inte");
			for (var i = 0; i < boxs.length; i++) {
				boxs[i].checked = true;
			}
			return;
		}

		if (org.checked == false) {
			var boxs = document.getElementsByName("inte");
			for (var i = 0; i < boxs.length; i++) {
				boxs[i].checked = false;
			}
		}
	}
</script>
<br />
<br />
<br />
<table class="table table-bordered">
	<form action="" method="post">
	<input type="hidden" name="type" value="delete" />
		<tr class="info" align="center">
			<th scope="col" width="100"></th>
			<th scope="col">编号</th>
			
			<th scope="col">email</th>
			<th scope="col">真实姓名</th>
		</tr>
		<c:forEach items="${user3}" var="user2" >
			<tr class="active" align="center">
				<td><input type="checkbox" name="checked" value="${ user2.id }"></td>
				<td>${list.index+1}</td>
			    <td>${user2.email}</td>
				<td>${user2.realname}</td>
				
			</tr>
		</c:forEach>
		<tr class="active" align="center">
			
			<td colspan="4"><input type="submit" value="删除" /></td>
		</tr>
	</form>
</table>
<table class="table table-bordered">
	<form action="" method="post">
		<input type="hidden" name="type" value="restore" />
		<tr class="info" align="center">
			<th scope="col" width="100"></th>
			<th scope="col">编号</th>
			
			<th scope="col">email</th>
			<th scope="col">真实姓名</th>
		</tr>
		<c:forEach items="${user4}" var="user5" >
			<tr class="active" align="center">
				<td><input type="checkbox" name="checked" value="${ user5.id }"></td>
				<td>${list.index+1}</td>
			    <td>${user5.email}</td>
				<td>${user5.realname}</td>
				
			</tr>
		</c:forEach>
		<tr class="active" align="center">
			
			<td colspan="4"><input type="submit" name="renew" value="恢复"></td>
		</tr>
	</form>
</table>

<%@ include file="footer.jsp"%>