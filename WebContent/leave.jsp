<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<b>考勤管理</b>
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
<table class="table" >
	<tr align="right">
	
		<td><form action="" method="post">
				<select name="kqId">
					<b><option value="">请选择上下班状态</option>
						<option value="3">所有签到</option></b>
					<option value="2">上班迟到</option>
					<option value="1">下班早退</option>
				</select> &nbsp;&nbsp;&nbsp; <input type="submit" value="查询"
					class="btn btn-default btn-xs" />
			</form></td>
			
				<td><a class="btn btn-default btn-xs" 
			href="${pageContext.request.contextPath}/updateleave/"><b>删除数据</b></a>
		</td>
	</tr>
</table>
<table class="table table-bordered">
	<tr class="info" align="center">
		<th scope="col">编号</th>
		<th scope="col">员工</th>
		<th scope="col">时间</th>
		<th scope="col">签到</th>
	</tr>
	<c:forEach items="${custList}" var="ch" varStatus="list">
		<tr class="active" align="center">
			<td>${list.index+1}</td>
			<td>${ch.name}</td>
			<td>${ch.checkin_time}</td>
			<td><c:if test="${ch.type == 1}">下班			
				</c:if>
				<c:if test="${ch.type == 2}">上班			
				</c:if></td>
		</tr>

	</c:forEach>

</table>


<%@ include file="footer.jsp"%>